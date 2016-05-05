package com.ice.wenjuandiaocha.activity;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;

import com.ice.greendao.PersonInfo;
import com.ice.greendao.PersonInfoDao;
import com.ice.greendao.QuestionResult;
import com.ice.greendao.QuestionResultDao;
import com.ice.greendao.SimpleInfo;
import com.ice.greendao.SimpleInfoDao;
import com.ice.wenjuandiaocha.Application.MyApplication;
import com.ice.wenjuandiaocha.R;
import com.ice.wenjuandiaocha.base.BaseBackActivity;
import com.ice.wenjuandiaocha.tool.UpdateBean;
import com.ice.wenjuandiaocha.tool.VolleySingleton;
import com.ice.wenjuandiaocha.util.MyJsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.greenrobot.dao.query.QueryBuilder;

public class UploadBackActivity extends BaseBackActivity {

    private static final String VOLLEY_TAG = "UploadBackActivity";
    @Bind(R.id.upload)
    Button upload;
    @Bind(R.id.connect)
    Button connect;
    @Bind(R.id.ip_text)
    TextInputLayout ipText;
    @Bind(R.id.data_num)
    TextView dataNum;
    @Bind(R.id.status)
    TextView status;
    ArrayList<UpdateBean> updateBeans = new ArrayList<>();
    private RequestQueue mQueue;
    private Cursor cursor;
    private String targetIp;
    private String jsonStr;
    List<SimpleInfo> simpleInfos = new ArrayList<>();

    SharedPreferences sp;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);
        ButterKnife.bind(this);

        sp = getSharedPreferences("WenJuan", MODE_PRIVATE);
        editor = sp.edit();//获取编辑器

        ipText.getEditText().setText(sp.getString("ip", ""));


        setTitle("上传");

        mQueue = VolleySingleton.getInstance(getApplicationContext()).getRequestQueue();

        simpleInfos = getNotUploadSimpleInfo();//先获取SimpleInfo，代表有问卷没上传
        //然后根据simpleinfo中的问卷号，查找具体问卷答案列表   根据personID查找用户信息

        for (SimpleInfo simpleInfo : simpleInfos) {
            UpdateBean updateBean = new UpdateBean();

            String personId = simpleInfo.getPersonId();
            String questionId = simpleInfo.getQuestionId();

            // MyApplication.getPersonInfoDao().load("personId");

            QueryBuilder qb = MyApplication.getPersonInfoDao().queryBuilder();
            qb.where(PersonInfoDao.Properties.PersonId.eq(personId));

            QueryBuilder qb2 = MyApplication.getQuestionResultDao().queryBuilder();
            qb2.where(QuestionResultDao.Properties.QuestionId.eq(questionId));

            List<QuestionResult> questionList = qb2.list();
            for (QuestionResult questionResult :
                    questionList) {

                updateBean.addQuestionResults(questionResult);
            }

            updateBean.setPersonInfo((PersonInfo) qb.list().get(0));
            updateBean.setSimpleInfo(simpleInfo);

            updateBeans.add(updateBean);

        }

        dataNum.setText("未上传记录数目：" + updateBeans.size());

        Gson gson = new Gson();
        jsonStr = gson.toJson(updateBeans);
        Log.e("SSS", jsonStr);

    }

    public List<PersonInfo> getAllPerson() {
        return MyApplication.getPersonInfoDao().loadAll();//
    }

    public List<SimpleInfo> getAllSimpleInfo() {
        return MyApplication.getSimpleInfoDao().loadAll();//
    }

    public List<SimpleInfo> getNotUploadSimpleInfo() {
        QueryBuilder qb = MyApplication.getSimpleInfoDao().queryBuilder();
        qb.where(SimpleInfoDao.Properties.Upload.eq(false));

        return qb.list();//
    }


    @OnClick({R.id.upload, R.id.connect})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.upload:
                if (updateBeans.size() < 0)
                    Toast.makeText(UploadBackActivity.this, "无新纪录上传", Toast.LENGTH_SHORT).show();
                else {
                    editor.putString("ip", ipText.getEditText().getText().toString());
                    editor.commit();
                    targetIp = "http://" + ipText.getEditText().getText().toString();
                    sendSimplePost(jsonStr, targetIp, "上传成功", "上传失败", VOLLEY_TAG, true);
                }
                break;
            case R.id.connect:
                break;
        }
    }

    //"http://192.168.100.134:8821"
    public void sendSimplePost(String str, String targetIp, final String successText, final String failText, String VOLLEY_TAG, final boolean flag) {


        JSONArray params = null;
        try {
            params = new JSONArray(str);
        } catch (JSONException e) {
            e.printStackTrace();
        }

//        Log.d("TAG", params.toString());
        MyJsonObjectRequest jsonObjectRequest = new MyJsonObjectRequest(Request.Method.POST, "http://192.168.100.134:8080/ServerJsonDemo/servlet/AddServlet", params,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("TAG", response.toString());
                        try {

                            String resp = response.getString("resp");
                            if (flag) {
                                if (resp.equals("Success")) {
                                    Toast.makeText(MyApplication.getContext(), successText, Toast.LENGTH_SHORT).show();
                                    ChangeDaoTrue();
                                } else {
                                    Toast.makeText(MyApplication.getContext(), failText, Toast.LENGTH_SHORT).show();
                                }
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG", error.getMessage(), error);
                Toast.makeText(MyApplication.getContext(), "网络连接失败", Toast.LENGTH_SHORT).show();
            }
        });
        jsonObjectRequest.setTag(VOLLEY_TAG);
        mQueue.add(jsonObjectRequest)
        ;
    }

    private void ChangeDaoTrue() {

        for (SimpleInfo simpleInfo : simpleInfos) {
            simpleInfo.setUpload(true);

            MyApplication.getSimpleInfoDao().update(simpleInfo);




        }
    }


}



