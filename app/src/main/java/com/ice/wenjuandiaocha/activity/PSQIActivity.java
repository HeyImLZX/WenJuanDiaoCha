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

public class PSQIActivity extends AppCompatActivity {

    @Bind(R.id.edit_text_1)
    EditText editText1;
    @Bind(R.id.edit_text_2)
    EditText editText2;
    @Bind(R.id.edit_text_3)
    EditText editText3;
    @Bind(R.id.edit_text_4)
    EditText editText4;
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
    @Bind(R.id.score)
    EditText score;
    @Bind(R.id.add)
    Button add;

    int groupNum = 24;
    ArrayList<FourRadioGroup> groupList = new ArrayList<FourRadioGroup>();
    StringBuilder resultSb = new StringBuilder();
    int scoreValue = 0;
    boolean isScored = false;//是否计算了分数

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_psqi);
        ButterKnife.bind(this);


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

        groupList.add(group20);
        groupList.add(group21);
        groupList.add(group22);
        groupList.add(group23);
        groupList.add(group24);

    }

    @OnClick(R.id.add)
    public void onClick() {

        if (isScored)//分数计算完成
        {
            finish();
        } else {
            int j = 0;
            for (int i = 0; i < groupNum; i++) {

                if (i == 0 || i == 1 || i == 2 || i == 3 || i == 18)
                    continue;

                int chose = groupList.get(j).getSelectRadio();
                // chose = chose == 0 ? 4 : chose;
                resultSb.append(chose);
                scoreValue = scoreValue + chose - 1;
                j++;
            }
            score.setText(scoreValue + "");
            isScored = true;
            System.out.println(resultSb.toString());
            System.out.println(scoreValue);

        }

    }
}
