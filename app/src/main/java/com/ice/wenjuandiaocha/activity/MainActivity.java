package com.ice.wenjuandiaocha.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.ice.wenjuandiaocha.R;
import com.ice.wenjuandiaocha.util.DatePickerFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.login)
    Button login;
    @Bind(R.id.invest)
    Button invest;
    @Bind(R.id.upload)
    Button upload;
    @Bind(R.id.exit)
    Button exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.login, R.id.invest, R.id.upload, R.id.exit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login:
                showDatePickerDialog(view);
                break;
            case R.id.invest:
                Intent intent = new Intent(MainActivity.this,PersonInfoActivity.class);
                startActivity(intent);
                break;
            case R.id.upload:
                Intent intent2 = new Intent(MainActivity.this,SimpleInfoActivity.class);
                startActivity(intent2);
                break;
            case R.id.exit:
                break;
        }
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
}
