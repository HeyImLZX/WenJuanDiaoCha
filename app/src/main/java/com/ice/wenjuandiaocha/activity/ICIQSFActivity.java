package com.ice.wenjuandiaocha.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;


import com.ice.wenjuandiaocha.R;
import com.ice.wenjuandiaocha.util.SevenRadioGroup;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ICIQSFActivity extends AppCompatActivity {

    @Bind(R.id.group1)
    SevenRadioGroup group1;
    @Bind(R.id.group2)
    SevenRadioGroup group2;
    @Bind(R.id.group3)
    SevenRadioGroup group3;
    @Bind(R.id.check1)
    CheckBox check1;
    @Bind(R.id.check2)
    CheckBox check2;
    @Bind(R.id.check3)
    CheckBox check3;
    @Bind(R.id.check4)
    CheckBox check4;
    @Bind(R.id.check5)
    CheckBox check5;
    @Bind(R.id.check6)
    CheckBox check6;
    @Bind(R.id.check7)
    CheckBox check7;
    @Bind(R.id.check8)
    CheckBox check8;
    @Bind(R.id.score)
    EditText score;
    @Bind(R.id.add)
    Button add;

    int groupNum = 3;
    ArrayList<SevenRadioGroup> groupList = new ArrayList<SevenRadioGroup>();
    StringBuilder resultSb = new StringBuilder();
    int scoreValue = 0;
    boolean isScored = false;//是否计算了分数

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iciqsf);
        ButterKnife.bind(this);

        groupList.add(group1);
        groupList.add(group2);
        groupList.add(group3);

    }

    @OnClick(R.id.add)
    public void onClick() {

        if (isScored)//分数计算完成
        {
            finish();
        } else {

            for (int i = 0; i < groupNum; i++) {
                int chose = groupList.get(i).getSelectRadio();
                //chose = chose == 0 ? 4 : chose;
                resultSb.append(chose);
                scoreValue = scoreValue + chose - 1;

            }
            score.setText(scoreValue + "");
            isScored = true;
            System.out.println(resultSb.toString());
            System.out.println(scoreValue);

        }


    }
}
