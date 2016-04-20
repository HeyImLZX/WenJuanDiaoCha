package com.ice.wenjuandiaocha.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ice.wenjuandiaocha.R;

public class MiniCogActivity extends AppCompatActivity {
    String timeStamp = "2798";
    String personId = "2798";
    String tableId = "9";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mini_cog);

        if (getIntent().getExtras() != null) {
            timeStamp = getIntent().getExtras().getString("timeStamp");
            personId = getIntent().getExtras().getString("personId");
        }
    }
}
