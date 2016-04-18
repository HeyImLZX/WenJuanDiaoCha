package com.ice.wenjuandiaocha.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.ice.wenjuandiaocha.R;
import com.ice.wenjuandiaocha.util.SevenRadioGroup;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FRSActivity extends AppCompatActivity {

    @Bind(R.id.group1)
    SevenRadioGroup group1;
    @Bind(R.id.score)
    EditText score;
    @Bind(R.id.add)
    Button add;


    int groupNum = 1;
    ArrayList<SevenRadioGroup> groupList = new ArrayList<SevenRadioGroup>();
    StringBuilder resultSb = new StringBuilder();
    int scoreValue = 0;
    boolean isScored = false;//是否计算了分数

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frs);
        ButterKnife.bind(this);

        groupList.add(group1);
    }

    @OnClick(R.id.add)
    public void onClick() {

        if (isScored)//分数计算完成
        {
            finish();
        } else {

            for (int i = 0; i < groupNum; i++) {
                int chose = groupList.get(i).getSelectRadio();
                // chose = chose == 0 ? 6 : chose;
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
