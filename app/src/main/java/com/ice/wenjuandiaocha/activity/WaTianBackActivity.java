package com.ice.wenjuandiaocha.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.ice.wenjuandiaocha.R;
import com.ice.wenjuandiaocha.base.BaseBackActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WaTianBackActivity extends BaseBackActivity {

    @Bind(R.id.wt_btn1)
    RadioButton wtBtn1;
    @Bind(R.id.wt_btn2)
    RadioButton wtBtn2;
    @Bind(R.id.wt_btn3)
    RadioButton wtBtn3;
    @Bind(R.id.wt_btn4)
    RadioButton wtBtn4;
    @Bind(R.id.wt_btn5)
    RadioButton wtBtn5;
    @Bind(R.id.wt_group)
    RadioGroup wtGroup;
    @Bind(R.id.add)
    Button add;

    boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wa_tian);
        ButterKnife.bind(this);
        wtGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId) {
                    case R.id.wt_btn1:
                        Log.e("cc", "aaaaaaaaaaaaaaaaaaaaaaaaaaaa" + wtGroup.getCheckedRadioButtonId());
                        flag = true;
                        break;
                    case R.id.wt_btn2:
                        Log.e("cc", "bbbbbbbbbbbbbbbbbbb");
                        flag = true;
                        break;
                    case R.id.wt_btn3:
                        Log.e("cc", "ccccccccccccccccccccccccccccccc");
                        flag = true;
                        break;
                    case R.id.wt_btn4:
                        Log.e("cc", "ddddddddddddddddddddddddddddd");
                        flag = true;
                        break;
                }
            }
        });


    }

    @OnClick(R.id.add)
    public void onClick() {
        if (flag) {
            setResult(RESULT_OK, getIntent());
            finish();
        } else {
            Toast.makeText(WaTianBackActivity.this, "请选择", Toast.LENGTH_SHORT).show();
        }
    }
}
