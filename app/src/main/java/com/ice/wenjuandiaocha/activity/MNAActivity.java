package com.ice.wenjuandiaocha.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.ice.greendao.QuestionResult;
import com.ice.greendao.SimpleInfo;
import com.ice.wenjuandiaocha.Application.MyApplication;
import com.ice.wenjuandiaocha.R;
import com.ice.wenjuandiaocha.util.FourRadioGroup;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MNAActivity extends AppCompatActivity {

    private static final String TAG = "MNAActivity";
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
    @Bind(R.id.group12)
    FourRadioGroup group12;
    @Bind(R.id.group13)
    FourRadioGroup group13;
    @Bind(R.id.group14)
    FourRadioGroup group14;
    @Bind(R.id.group15)
    FourRadioGroup group15;
    @Bind(R.id.group16)
    FourRadioGroup group16;
    @Bind(R.id.group17)
    FourRadioGroup group17;
    @Bind(R.id.group18)
    FourRadioGroup group18;
    @Bind(R.id.score)
    EditText score;
    @Bind(R.id.add)
    Button add;

    int groupNum = 18;
    ArrayList<FourRadioGroup> groupList = new ArrayList<FourRadioGroup>();
    StringBuilder resultSb = new StringBuilder();
    double scoreValue = 0;
    boolean isScored = false;//是否计算了分数

    String timeStamp = "2798";
    String personId = "2798";
    String tableId = "1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mna);
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
                // chose = chose == 0 ? 4 : chose;
                resultSb.append(chose);
                if (i == 10 || i == 12 || i == 16) {
                    scoreValue = scoreValue + (chose - 1) / 2.0;
                    System.out.println("index" + i + " " + (chose - 1) / 2.0);
                } else if (i == 15) {
                    if (chose != 4) {
                        scoreValue = scoreValue + (chose - 1) / 2.0;
                        System.out.println("index" + i + " " + (chose - 1) / 2.0);
                    } else {
                        scoreValue = scoreValue + 2;
                        System.out.println("index" + i + " " + 2);
                    }
                } else if (i == 3) {
                    scoreValue = scoreValue + (chose - 1) * 2;
                    System.out.println("index" + i + " " + (chose - 1) * 2);
                } else {
                    scoreValue = scoreValue + chose - 1;
                    System.out.println("index" + i + " " + (chose - 1));
                }
            }
            score.setText(scoreValue + "");
            isScored = true;
            System.out.println(resultSb.toString());
            System.out.println(scoreValue);


            MyApplication.insertDao(timeStamp, personId, tableId, "", resultSb.toString(), String.valueOf(scoreValue), TAG);


        }

    }


}
