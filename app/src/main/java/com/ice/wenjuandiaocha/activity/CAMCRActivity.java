package com.ice.wenjuandiaocha.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.ice.wenjuandiaocha.Application.MyApplication;
import com.ice.wenjuandiaocha.R;
import com.ice.wenjuandiaocha.util.FourRadioGroup;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CAMCRActivity extends AppCompatActivity {
    private static final String TAG = "CAMCRActivity";
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
    @Bind(R.id.score)
    EditText score;

    int groupNum = 11;
    ArrayList<FourRadioGroup> groupList = new ArrayList<FourRadioGroup>();
    StringBuilder resultSb = new StringBuilder();
    int scoreValue = 0;
    boolean isScored = false;//是否计算了分数

    String timeStamp = "2798";
    String personId = "2798";
    String tableId = "8";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camcr);
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
                // chose = chose == 0 ? 4 : chose;
                resultSb.append(chose);
                scoreValue = scoreValue + chose;

            }
            score.setText(scoreValue + "");
            isScored = true;
            System.out.println(resultSb.toString());
            System.out.println(scoreValue);
            MyApplication.insertDao(timeStamp, personId, tableId, "", resultSb.toString(), String.valueOf(scoreValue), TAG);
        }
    }
}
