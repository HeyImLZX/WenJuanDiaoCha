package com.ice.wenjuandiaocha.activity;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.widget.Button;
import android.widget.Toast;

import com.ice.wenjuandiaocha.R;
import com.ice.wenjuandiaocha.base.BaseBackActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginBackActivity extends BaseBackActivity {

    @Bind(R.id.login)
    Button login;
    @Bind(R.id.name_text)
    TextInputLayout nameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        setTitle("登陆");
    }

    @OnClick(R.id.login)
    public void onClick() {
        if (nameText.getEditText().getText().toString().isEmpty())
            nameText.setError("请输入医生姓名");
        else {
            Toast.makeText(getApplicationContext(), "登陆成功", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
