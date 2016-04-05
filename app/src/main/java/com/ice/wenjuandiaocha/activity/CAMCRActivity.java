package com.ice.wenjuandiaocha.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.RadioGroup;

import com.ice.wenjuandiaocha.R;
import com.ice.wenjuandiaocha.util.FourRadioGroup;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CAMCRActivity extends AppCompatActivity {

    @Bind(R.id.add)
    Button add;
    @Bind(R.id.group1)
    FourRadioGroup group1;
    @Bind(R.id.group2)
    FourRadioGroup group2;
    @Bind(R.id.group3)
    FourRadioGroup group3;
    @Bind(R.id.group4)
    FourRadioGroup group4;
    @Bind(R.id.group5)
    FourRadioGroup group5;
    @Bind(R.id.group6)
    FourRadioGroup group6;
    @Bind(R.id.group7)
    FourRadioGroup group7;
    @Bind(R.id.group8)
    FourRadioGroup group8;
    @Bind(R.id.group9)
    FourRadioGroup group9;
    @Bind(R.id.group10)
    FourRadioGroup group10;
    @Bind(R.id.group11)
    FourRadioGroup group11;

    ArrayList<RadioGroup> groupList = new ArrayList<RadioGroup>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camcr);
        ButterKnife.bind(this);

        groupList.add(group1);
        groupList.add(group2);
        groupList.add(group3);
        groupList.add(group4);
        groupList.add(group5);
        groupList.add(group6);
        groupList.add(group7);
        groupList.add(group8);
        groupList.add(group9);
        groupList.add(group10);
        groupList.add(group11);

    }

    @OnClick(R.id.add)
    public void onClick() {

        group1.getSelectRadio();
        StringBuilder sb = new StringBuilder();

        int score = 0;
        for (int i = 0; i < 11; i++) {
            int chose = groupList.get(i).getCheckedRadioButtonId();
            //chose = chose == 0 ? 4 : chose;
            sb.append(chose);

            if (i == 4 || i == 8 || i == 12 || i == 16 || i == 18) {//5 9 13 17 19 都-1
                score = score + 5 - chose;

            } else
                score = score + chose;

        }

        System.out.println(sb.toString());
        System.out.println((int) (score * 1.25));
        finish();
    }
}
