package com.ice.wenjuandiaocha.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.ice.wenjuandiaocha.Application.MyApplication;
import com.ice.wenjuandiaocha.R;
import com.ice.wenjuandiaocha.util.SevenRadioGroup;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FIMActivity extends AppCompatActivity {


    private static final String TAG = "FIMActivity";
    @Bind(R.id.group1)
    SevenRadioGroup group1;
    @Bind(R.id.group2)
    SevenRadioGroup group2;
    @Bind(R.id.group3)
    SevenRadioGroup group3;
    @Bind(R.id.group4)
    SevenRadioGroup group4;
    @Bind(R.id.group5)
    SevenRadioGroup group5;
    @Bind(R.id.group6)
    SevenRadioGroup group6;
    @Bind(R.id.group7)
    SevenRadioGroup group7;
    @Bind(R.id.group8)
    SevenRadioGroup group8;
    @Bind(R.id.group9)
    SevenRadioGroup group9;
    @Bind(R.id.group10)
    SevenRadioGroup group10;
    @Bind(R.id.group11)
    SevenRadioGroup group11;
    @Bind(R.id.group12)
    SevenRadioGroup group12;
    @Bind(R.id.group13)
    SevenRadioGroup group13;
    @Bind(R.id.group14)
    SevenRadioGroup group14;
    @Bind(R.id.group15)
    SevenRadioGroup group15;
    @Bind(R.id.group16)
    SevenRadioGroup group16;
    @Bind(R.id.group17)
    SevenRadioGroup group17;
    @Bind(R.id.group18)
    SevenRadioGroup group18;
    @Bind(R.id.score)
    EditText score;
    @Bind(R.id.add)
    Button add;


    int groupNum = 18;
    ArrayList<SevenRadioGroup> groupList = new ArrayList<SevenRadioGroup>();
    StringBuilder resultSb = new StringBuilder();
    int scoreValue = 0;
    boolean isScored = false;//是否计算了分数

    String timeStamp = "2798";
    String personId = "2798";
    String tableId = "17";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fim);
        ButterKnife.bind(this);

        if (getIntent().getExtras() != null) {
            timeStamp = getIntent().getExtras().getString("timeStamp");
            personId = getIntent().getExtras().getString("personId");
        }

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
        groupList.add(group12);
        groupList.add(group13);
        groupList.add(group14);
        groupList.add(group15);
        groupList.add(group16);
        groupList.add(group17);
        groupList.add(group18);
    }

    @OnClick(R.id.add)
    public void onClick() {

        if (isScored)//分数计算完成
        {
            setResult(RESULT_OK, getIntent());
            finish();
        } else {

            for (int i = 0; i < groupNum; i++) {
                int chose = groupList.get(i).getSelectRadio();
                //  chose = chose == 0 ? 7 : chose;
                resultSb.append(chose);
                scoreValue = scoreValue + 8 - chose;

            }
            score.setText(scoreValue + "");
            isScored = true;
            System.out.println(resultSb.toString());
            System.out.println(scoreValue);
            MyApplication.insertDao(timeStamp, personId, tableId, "", resultSb.toString(), String.valueOf(scoreValue), TAG);
        }

    }
}
