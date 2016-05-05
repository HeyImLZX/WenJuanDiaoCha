package com.ice.wenjuandiaocha.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import com.ice.greendao.PersonInfo;
import com.ice.greendao.PersonInfoDao;
import com.ice.wenjuandiaocha.Application.MyApplication;
import com.ice.wenjuandiaocha.R;
import com.ice.wenjuandiaocha.base.BaseBackActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.greenrobot.dao.query.QueryBuilder;

/**
 * ID检查检查是否已经输入过基本信息，如果没有则输入，如果有，选择直接使用或修改
 */
public class IDCheckBackActivity extends BaseBackActivity {

    private static final String TAG = "PersonInfoBackActivity";
    @Bind(R.id.idcard)
    AutoCompleteTextView idcard;
    @Bind(R.id.add)
    Button add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_id_check);
        ButterKnife.bind(this);

        setTitle("基本信息");


    }

    @OnClick(R.id.add)
    public void onClick() {

        final PersonInfo personInfo = selectDao(idcard.getText().toString());

        if (personInfo == null) {

            Intent intent = new Intent(IDCheckBackActivity.this, PersonInfoBackActivity.class);
            intent.putExtra("personId", idcard.getText().toString());
            startActivity(intent);
        }else{

            AlertDialog.Builder builder = new AlertDialog.Builder(this, 0);
            builder.setTitle("基本信息");
            builder.setMessage("检查到已有基本信息");
            builder.setPositiveButton("直接使用", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    long timeStamp = System.currentTimeMillis();


                    Intent intent = new Intent(IDCheckBackActivity.this, SimpleInfoBackActivity.class);
                    intent.putExtra("timeStamp", String.valueOf(timeStamp));
                    intent.putExtra("personId", idcard.getText().toString());

                    startActivity(intent);
                }
            });
            builder.setNegativeButton("修改信息", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    Intent intent = new Intent(IDCheckBackActivity.this, PersonInfoBackActivity.class);

                    intent.putExtra("personInfo", personInfo);

                    startActivity(intent);
                }
            });
            builder.show();
        }

    }


    public PersonInfo selectDao(String personId) {

        QueryBuilder qb = MyApplication.getPersonInfoDao().queryBuilder();
        qb.where(PersonInfoDao.Properties.PersonId.eq(personId));

        if (qb.list().isEmpty()) {
            return null;
        } else {
            PersonInfo personInfo = (PersonInfo) qb.list().get(0);
            return personInfo;
        }

    }


}
