package com.ice.wenjuandiaocha.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ice.wenjuandiaocha.R;
import com.ice.wenjuandiaocha.base.BaseBackActivity;
import com.ice.wenjuandiaocha.util.SevenRadioGroup;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WaTianBackActivity extends BaseBackActivity {


    @Bind(R.id.wt_group)
    SevenRadioGroup wtGroup;
    @Bind(R.id.score)
    EditText score;
    @Bind(R.id.add)
    Button add;

    boolean flag = false;

    int groupNum = 1;
    ArrayList<SevenRadioGroup> groupList = new ArrayList<SevenRadioGroup>();
    StringBuilder resultSb = new StringBuilder();
    int scoreValue = 0;
    boolean isScored = false;//是否计算了分数

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wa_tian);
        ButterKnife.bind(this);

        groupList.add(wtGroup);

    }

    @OnClick(R.id.add)
    public void onClick() {

        if (isScored)//分数计算完成
        {
            setResult(RESULT_OK, getIntent());
            finish();
        } else {

            for (int i = 0; i < groupNum; i++) {

                if (groupList.get(i).getCheckedRadioButtonId() == -1) {
                    Toast.makeText(WaTianBackActivity.this, "请选择", Toast.LENGTH_SHORT).show();
                    break;
                }

                int chose = groupList.get(i).getSelectRadio();
                // chose = chose == 0 ? 5 : chose;
                resultSb.append(chose);
                scoreValue = scoreValue + chose;

            }
            score.setText(scoreValue + "");
            isScored = true;
            System.out.println(resultSb.toString());
            System.out.println(scoreValue);

        }




    }


}
