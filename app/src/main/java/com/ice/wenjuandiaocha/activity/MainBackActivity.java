package com.ice.wenjuandiaocha.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ice.wenjuandiaocha.R;
import com.ice.wenjuandiaocha.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainBackActivity extends BaseActivity {

    @Bind(R.id.login)
    Button login;
    @Bind(R.id.invest)
    Button invest;
    @Bind(R.id.upload)
    Button upload;
    @Bind(R.id.exit)
    Button exit;
    @Bind(R.id.test)
    Button test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.login, R.id.invest, R.id.upload, R.id.exit, R.id.test})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login:
                Intent intent3 = new Intent(MainBackActivity.this, LoginBackActivity.class);
                startActivity(intent3);
                break;
            case R.id.invest:
                Intent intent = new Intent(MainBackActivity.this, IDCheckBackActivity.class);
                startActivity(intent);
                break;
            case R.id.upload:
                Intent intent2 = new Intent(MainBackActivity.this, UploadBackActivity.class);
                startActivity(intent2);
                break;
            case R.id.exit:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("是否要退出");
                builder.setPositiveButton("退出", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                builder.show();
                break;
            case R.id.test:
                Intent intent9 = new Intent(MainBackActivity.this, TestActivity.class);
                startActivity(intent9);
                break;
        }
    }


}
