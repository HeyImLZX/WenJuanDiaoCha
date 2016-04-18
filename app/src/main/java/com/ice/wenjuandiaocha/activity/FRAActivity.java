package com.ice.wenjuandiaocha.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;


import com.ice.wenjuandiaocha.R;
import com.ice.wenjuandiaocha.util.FourRadioGroup;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FRAActivity extends AppCompatActivity {

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
    @Bind(R.id.group19)
    FourRadioGroup group19;
    @Bind(R.id.group20)
    FourRadioGroup group20;
    @Bind(R.id.group21)
    FourRadioGroup group21;
    @Bind(R.id.group22)
    FourRadioGroup group22;
    @Bind(R.id.group23)
    FourRadioGroup group23;
    @Bind(R.id.group24)
    FourRadioGroup group24;
    @Bind(R.id.group25)
    FourRadioGroup group25;
    @Bind(R.id.group26)
    FourRadioGroup group26;
    @Bind(R.id.group27)
    FourRadioGroup group27;
    @Bind(R.id.group28)
    FourRadioGroup group28;
    @Bind(R.id.group29)
    FourRadioGroup group29;
    @Bind(R.id.group30)
    FourRadioGroup group30;
    @Bind(R.id.group31)
    FourRadioGroup group31;
    @Bind(R.id.group32)
    FourRadioGroup group32;
    @Bind(R.id.group33)
    FourRadioGroup group33;
    @Bind(R.id.group34)
    FourRadioGroup group34;
    @Bind(R.id.group35)
    FourRadioGroup group35;
    @Bind(R.id.score)
    EditText score;
    @Bind(R.id.add)
    Button add;

    int groupNum = 35;
    ArrayList<FourRadioGroup> groupList = new ArrayList<FourRadioGroup>();
    StringBuilder resultSb = new StringBuilder();
    int scoreValue = 0;
    boolean isScored = false;//是否计算了分数

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fra);
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
        groupList.add(group12);
        groupList.add(group13);
        groupList.add(group14);
        groupList.add(group15);
        groupList.add(group16);
        groupList.add(group17);
        groupList.add(group18);
        groupList.add(group19);
        groupList.add(group20);
        groupList.add(group21);
        groupList.add(group22);
        groupList.add(group23);
        groupList.add(group24);
        groupList.add(group25);
        groupList.add(group26);
        groupList.add(group27);
        groupList.add(group28);
        groupList.add(group29);
        groupList.add(group30);
        groupList.add(group31);
        groupList.add(group32);
        groupList.add(group33);
        groupList.add(group34);
        groupList.add(group35);

    }

    @OnClick(R.id.add)
    public void onClick() {

        if (isScored)//分数计算完成
        {
            finish();
        } else {

            for (int i = 0; i < groupNum; i++) {
                int chose = groupList.get(i).getSelectRadio();
                // chose = chose == 0 ? 2 : chose;
                resultSb.append(chose);

                if (i == 0 || i == 1 | i == 2 || i == 3 || i == 4 || i == 5 || i == 6 || i == 8 || i == 34)
                    scoreValue = scoreValue + (chose - 1) * 3;
                else if (i == 7) {
                    scoreValue = scoreValue + (chose - 1) * 2;
                } else {
                    scoreValue = scoreValue + (chose - 1) * 1;
                }

            }
            score.setText(scoreValue + "");
            isScored = true;
            System.out.println(resultSb.toString());
            System.out.println(scoreValue);

        }

    }
}
