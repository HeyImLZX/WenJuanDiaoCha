package com.ice.wenjuandiaocha.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.ice.wenjuandiaocha.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class WaTianActivity extends AppCompatActivity {

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
                        break;
                    case R.id.wt_btn2:
                        Log.e("cc", "bbbbbbbbbbbbbbbbbbb");
                        break;
                    case R.id.wt_btn3:
                        Log.e("cc", "ccccccccccccccccccccccccccccccc");
                        break;
                    case R.id.wt_btn4:
                        Log.e("cc", "ddddddddddddddddddddddddddddd");
                        break;
                }
            }
        });


    }

}
