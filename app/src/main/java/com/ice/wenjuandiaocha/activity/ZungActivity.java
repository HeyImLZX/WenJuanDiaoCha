package com.ice.wenjuandiaocha.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.ice.wenjuandiaocha.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

public class ZungActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    @Bind(R.id.group1)
    RadioGroup group1;
    @Bind(R.id.group2)
    RadioGroup group2;
    @Bind(R.id.group3)
    RadioGroup group3;
    @Bind(R.id.group4)
    RadioGroup group4;
    @Bind(R.id.group5)
    RadioGroup group5;
    @Bind(R.id.group6)
    RadioGroup group6;
    @Bind(R.id.group7)
    RadioGroup group7;
    @Bind(R.id.group8)
    RadioGroup group8;
    @Bind(R.id.group9)
    RadioGroup group9;
    @Bind(R.id.group10)
    RadioGroup group10;
    @Bind(R.id.group11)
    RadioGroup group11;
    @Bind(R.id.group12)
    RadioGroup group12;
    @Bind(R.id.group13)
    RadioGroup group13;
    @Bind(R.id.group14)
    RadioGroup group14;
    @Bind(R.id.group15)
    RadioGroup group15;
    @Bind(R.id.group16)
    RadioGroup group16;
    @Bind(R.id.group17)
    RadioGroup group17;
    @Bind(R.id.group18)
    RadioGroup group18;
    @Bind(R.id.group19)
    RadioGroup group19;
    @Bind(R.id.group20)
    RadioGroup group20;
    @Bind(R.id.add)
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zung);
        ButterKnife.bind(this);

        group1.setOnCheckedChangeListener(this);
        group2.setOnCheckedChangeListener(this);
        group3.setOnCheckedChangeListener(this);
        group4.setOnCheckedChangeListener(this);
        group5.setOnCheckedChangeListener(this);
        group6.setOnCheckedChangeListener(this);
        group7.setOnCheckedChangeListener(this);
        group8.setOnCheckedChangeListener(this);
        group9.setOnCheckedChangeListener(this);
        group10.setOnCheckedChangeListener(this);
        group11.setOnCheckedChangeListener(this);
        group12.setOnCheckedChangeListener(this);
        group13.setOnCheckedChangeListener(this);
        group14.setOnCheckedChangeListener(this);
        group15.setOnCheckedChangeListener(this);
        group16.setOnCheckedChangeListener(this);
        group17.setOnCheckedChangeListener(this);
        group18.setOnCheckedChangeListener(this);
        group19.setOnCheckedChangeListener(this);
        group20.setOnCheckedChangeListener(this);


    }

    @OnClick(R.id.add)
    public void onClick() {

        finish();

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        Toast.makeText(ZungActivity.this, "click  " + checkedId, Toast.LENGTH_SHORT).show();
    }
//    @On({R.id.group1, R.id.group2, R.id.group3, R.id.group4, R.id.group5, R.id.group6, R.id.group7, R.id.group8, R.id.group9, R.id.group10, R.id.group11, R.id.group12, R.id.group13, R.id.group14, R.id.group15, R.id.group16, R.id.group17, R.id.group18, R.id.group19, R.id.group20})
//    public void onCheckedChanged(RadioGroup group, int checkedId) {
//        Toast.makeText(ZungActivity.this, "click  " + checkedId, Toast.LENGTH_SHORT).show();
//    }


//
//    @OnCheckedChanged
//    public void onCheckedChanged(RadioGroup group, int checkedId) {
//        Toast.makeText(ZungActivity.this,"click  "+checkedId,Toast.LENGTH_SHORT).show();
//    }'


}