package com.ice.wenjuandiaocha.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.ice.wenjuandiaocha.R;
import com.ice.wenjuandiaocha.base.BaseBackActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

public class SimpleInfoBackActivity extends BaseBackActivity {


    @Bind(R.id.one_one)
    CheckBox oneOne;
    @Bind(R.id.one_two)
    CheckBox oneTwo;
    @Bind(R.id.one_three)
    CheckBox oneThree;
    @Bind(R.id.detail1)
    Button detail1;
    @Bind(R.id.two_one)
    CheckBox twoOne;
    @Bind(R.id.two_two)
    CheckBox twoTwo;
    @Bind(R.id.detail2)
    Button detail2;
    @Bind(R.id.three_one)
    CheckBox threeOne;
    @Bind(R.id.three_two)
    CheckBox threeTwo;
    @Bind(R.id.four_one)
    CheckBox fourOne;
    @Bind(R.id.four_two)
    CheckBox fourTwo;
    @Bind(R.id.five_one)
    CheckBox fiveOne;
    @Bind(R.id.five_two)
    CheckBox fiveTwo;
    @Bind(R.id.five_three)
    CheckBox fiveThree;
    @Bind(R.id.detail5)
    Button detail5;
    @Bind(R.id.six_one)
    CheckBox sixOne;
    @Bind(R.id.six_two)
    CheckBox sixTwo;
    @Bind(R.id.seven_one)
    CheckBox sevenOne;
    @Bind(R.id.detail7)
    Button detail7;
    @Bind(R.id.eight_one)
    CheckBox eightOne;
    @Bind(R.id.eight_two)
    CheckBox eightTwo;
    @Bind(R.id.eight_three)
    CheckBox eightThree;
    @Bind(R.id.detail8)
    Button detail8;
    @Bind(R.id.nine_one)
    CheckBox nineOne;
    @Bind(R.id.nine_two)
    CheckBox nineTwo;
    @Bind(R.id.detail9)
    Button detail9;
    @Bind(R.id.ten_one)
    CheckBox tenOne;
    @Bind(R.id.ten_two)
    CheckBox tenTwo;
    @Bind(R.id.ten_three)
    CheckBox tenThree;
    @Bind(R.id.ten_four)
    CheckBox tenFour;
    @Bind(R.id.detail10)
    Button detail10;
    @Bind(R.id.add)
    Button add;
    int flag1 = 0;
    int flag2 = 0;
    int flag5 = 0;
    int flag7 = 0;
    int flag8 = 0;
    int flag9 = 0;
    int flag10 = 0;

    int detail_count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_info);
        ButterKnife.bind(this);

        ;

    }

    @OnCheckedChanged({R.id.one_one, R.id.one_two, R.id.one_three, R.id.two_one, R.id.two_two, R.id.three_one, R.id.three_two, R.id.four_one, R.id.four_two, R.id.five_one, R.id.five_two, R.id.five_three, R.id.six_one, R.id.six_two, R.id.seven_one, R.id.eight_one, R.id.eight_two, R.id.eight_three, R.id.nine_one, R.id.nine_two, R.id.ten_one, R.id.ten_two, R.id.ten_three, R.id.ten_four})
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.one_one:
            case R.id.one_two:
            case R.id.one_three:
                if (isChecked)
                    flag1++;
                else
                    flag1--;
                System.out.println(flag1);
                if (flag1 > 0) {
                    detail_count++;
                    detail1.setVisibility(View.VISIBLE);
                } else {
                    detail_count--;
                    detail1.setVisibility(View.GONE);
                }
                break;
            case R.id.two_one:
            case R.id.two_two:
                if (isChecked)
                    flag2++;
                else
                    flag2--;

                if (flag2 > 0) {
                    detail_count++;
                    detail2.setVisibility(View.VISIBLE);
                } else {
                    detail_count--;
                    detail2.setVisibility(View.GONE);
                }
                break;
            case R.id.three_one:
                break;
            case R.id.three_two:
                break;
            case R.id.four_one:
                break;
            case R.id.four_two:
                break;
            case R.id.five_one:
            case R.id.five_two:
            case R.id.five_three:
                if (isChecked)
                    flag5++;
                else
                    flag5--;

                if (flag5 > 0) {
                    detail_count++;
                    detail5.setVisibility(View.VISIBLE);
                } else {
                    detail_count--;
                    detail5.setVisibility(View.GONE);
                }
                break;
            case R.id.six_one:
                break;
            case R.id.six_two:
                break;
            case R.id.seven_one:
                if (isChecked)
                    flag7++;
                else
                    flag7--;

                if (flag7 > 0) {
                    detail_count++;
                    detail7.setVisibility(View.VISIBLE);
                } else {
                    detail_count--;

                    detail7.setVisibility(View.GONE);
                }
                break;
            case R.id.eight_one:
            case R.id.eight_two:
            case R.id.eight_three:
                if (isChecked)
                    flag8++;
                else
                    flag8--;

                if (flag8 > 0) {
                    detail_count++;
                    detail8.setVisibility(View.VISIBLE);
                } else {
                    detail_count--;
                    detail8.setVisibility(View.GONE);
                }
                break;
            case R.id.nine_one:
            case R.id.nine_two:
                if (isChecked)
                    flag9++;
                else
                    flag9--;

                if (flag9 > 0) {
                    detail_count++;
                    detail9.setVisibility(View.VISIBLE);
                } else {
                    detail_count--;
                    detail9.setVisibility(View.GONE);
                }
                break;
            case R.id.ten_one:
            case R.id.ten_two:
            case R.id.ten_three:
            case R.id.ten_four:
                if (isChecked)
                    flag10++;
                else
                    flag10--;

                if (flag10 > 0) {
                    detail_count++;
                    detail10.setVisibility(View.VISIBLE);
                } else {
                    detail_count--;
                    detail10.setVisibility(View.GONE);
                }
                break;
        }
    }

    @OnClick({R.id.detail1, R.id.detail2, R.id.detail5, R.id.detail7, R.id.detail8, R.id.detail9, R.id.detail10, R.id.add})
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.detail1:
                intent = new Intent(SimpleInfoBackActivity.this, WaTianBackActivity.class);
                startActivityForResult(intent, 1);
                break;
            case R.id.detail2:
                intent = new Intent(SimpleInfoBackActivity.this, WaTianBackActivity.class);
                startActivityForResult(intent, 2);
                break;
            case R.id.detail5:
                intent = new Intent(SimpleInfoBackActivity.this, WaTianBackActivity.class);
                startActivityForResult(intent, 5);
                break;
            case R.id.detail7:
                intent = new Intent(SimpleInfoBackActivity.this, WaTianBackActivity.class);
                startActivityForResult(intent, 7);
                break;
            case R.id.detail8:
                intent = new Intent(SimpleInfoBackActivity.this, WaTianBackActivity.class);
                startActivityForResult(intent, 8);
                break;
            case R.id.detail9:
                intent = new Intent(SimpleInfoBackActivity.this, WaTianBackActivity.class);
                startActivityForResult(intent, 9);
                break;
            case R.id.detail10:
                intent = new Intent(SimpleInfoBackActivity.this, WaTianBackActivity.class);
                startActivityForResult(intent, 10);
                break;
            case R.id.add:
                if (detail_count > 0)
                    Toast.makeText(SimpleInfoBackActivity.this, "请填写完详细调查", Toast.LENGTH_SHORT).show();
                else {
                    Toast.makeText(getApplicationContext(), "问卷填写完成", Toast.LENGTH_SHORT).show();
                    intent = new Intent(SimpleInfoBackActivity.this, MainBackActivity.class);
                    startActivity(intent);
                }
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.e("cccc", resultCode + "");
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case 1:
                    detail1.setText("已完成");
                    detail1.setBackgroundColor(getResources().getColor(R.color.colorGray));
                    detail1.setEnabled(false);
                    detail_count--;
                    break;
                case 2:
                    detail2.setText("已完成");
                    detail2.setBackgroundColor(getResources().getColor(R.color.colorGray));
                    detail2.setEnabled(false);
                    detail_count--;
                    break;
                case 5:
                    detail5.setText("已完成");
                    detail5.setBackgroundColor(getResources().getColor(R.color.colorGray));
                    detail5.setEnabled(false);
                    detail_count--;
                    break;
                case 7:
                    detail7.setText("已完成");
                    detail7.setBackgroundColor(getResources().getColor(R.color.colorGray));
                    detail7.setEnabled(false);
                    detail_count--;
                    break;
                case 8:
                    detail8.setText("已完成");
                    detail8.setBackgroundColor(getResources().getColor(R.color.colorGray));
                    detail8.setEnabled(false);
                    detail_count--;
                    break;
                case 9:
                    detail9.setText("已完成");
                    detail9.setBackgroundColor(getResources().getColor(R.color.colorGray));
                    detail9.setEnabled(false);
                    detail_count--;
                    break;
                case 10:
                    detail10.setText("已完成");
                    detail10.setBackgroundColor(getResources().getColor(R.color.colorGray));
                    detail10.setEnabled(false);
                    detail_count--;
                    break;
            }
        }

    }
}
