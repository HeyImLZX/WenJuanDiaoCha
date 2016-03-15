package com.ice.wenjuandiaocha.activity;

import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.google.gson.Gson;
import com.ice.greendao.PersonInfo;
import com.ice.wenjuandiaocha.Application.MyApplication;
import com.ice.wenjuandiaocha.R;
import com.ice.wenjuandiaocha.base.BaseBackActivity;
import com.ice.wenjuandiaocha.tool.VolleySingleton;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UploadBackActivity extends BaseBackActivity {

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
    private RequestQueue mQueue;
    List<PersonInfo> personInfos;

    private Cursor cursor;
    private String targetIp;
    private static final String VOLLEY_TAG = "UploadBackActivity";
    private String jsonStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);
        ButterKnife.bind(this);

        setTitle("上传");

        mQueue = VolleySingleton.getInstance(getApplicationContext()).getRequestQueue();

        personInfos = getAllPerson();
        dataNum.setText("未上传记录数目：" + personInfos.size());
        targetIp = ipText.getEditText().getText().toString();

        Gson gson = new Gson();

        jsonStr = gson.toJson(personInfos);

        Log.e("SSS", jsonStr);


    }

    public List<PersonInfo> getAllPerson() {
        return MyApplication.getPersonInfoDao().loadAll();// 获取图片相册
    }

    @OnClick({R.id.upload, R.id.connect})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.upload:
                if (personInfos.size() < 0)
                    Toast.makeText(UploadBackActivity.this, "无新纪录上传", Toast.LENGTH_SHORT).show();
                else
                    sendSimplePost(jsonStr, targetIp, "上传成功", "上传失败", VOLLEY_TAG, true);
                break;
            case R.id.connect:
                break;
        }
    }


    public void sendSimplePost(String str, String targetIp, final String successText, final String failText, String VOLLEY_TAG, final boolean flag) {

//
//        StringRequest stringRequest = new StringRequest(Request.Method.POST, targetIp, str, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                Log.d("TAG", response.toString());
//                try {
//
//                    JSONObject jsonObject = new JSONObject(response);
//
//                    String resp = jsonObject.getString("resp");
//                    if (flag) {
//                        if (resp.equals("Success")) {
//                            Toast.makeText(MyApplication.getContext(), successText, Toast.LENGTH_SHORT).show();
//                        } else {
//                            Toast.makeText(MyApplication.getContext(), failText, Toast.LENGTH_SHORT).show();
//                        }
//                    }
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.e("TAG", error.getMessage(), error);
//            }
//        });
//        stringRequest.setTag(VOLLEY_TAG);
//        mQueue.add(stringRequest);
    }

}



