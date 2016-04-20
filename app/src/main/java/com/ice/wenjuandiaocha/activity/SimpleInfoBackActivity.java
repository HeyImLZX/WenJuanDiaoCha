package com.ice.wenjuandiaocha.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.ice.greendao.SimpleInfo;
import com.ice.wenjuandiaocha.Application.MyApplication;
import com.ice.wenjuandiaocha.R;
import com.ice.wenjuandiaocha.base.BaseBackActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

public class SimpleInfoBackActivity extends BaseBackActivity {


    private static final String TAG = "SimpleInfoBackActivity";
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
    @Bind(R.id.detail2B)
    Button detail2B;
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
    int flag14 = 0;
    int flag17 = 0;
    int flag20 = 0;

    int detail_count = 0;

    @Bind(R.id.detail11)
    Button detail11;
    @Bind(R.id.detail12)
    Button detail12;
    @Bind(R.id.detail13)
    Button detail13;
    @Bind(R.id.fourteen_one)
    CheckBox fourteenOne;
    @Bind(R.id.fourteen_two)
    CheckBox fourteenTwo;
    @Bind(R.id.fourteen_three)
    CheckBox fourteenThree;
    @Bind(R.id.fourteen_four)
    CheckBox fourteenFour;
    @Bind(R.id.fourteen_five)
    CheckBox fourteenFive;
    @Bind(R.id.detail14)
    Button detail14;
    @Bind(R.id.detail15)
    Button detail15;
    @Bind(R.id.detail16)
    Button detail16;
    @Bind(R.id.seventeen_one)
    CheckBox seventeenOne;
    @Bind(R.id.seventeen_two)
    CheckBox seventeenTwo;
    @Bind(R.id.seventeen_three)
    CheckBox seventeenThree;
    @Bind(R.id.seventeen_four)
    CheckBox seventeenFour;
    @Bind(R.id.seventeen_five)
    CheckBox seventeenFive;
    @Bind(R.id.detail17)
    Button detail17;
    @Bind(R.id.detail18)
    Button detail18;
    @Bind(R.id.nineteen_one)
    CheckBox nineteenOne;
    @Bind(R.id.nineteen_two)
    CheckBox nineteenTwo;
    @Bind(R.id.twenty_one)
    CheckBox twentyOne;
    @Bind(R.id.twenty_two)
    CheckBox twentyTwo;
    @Bind(R.id.detail20)
    Button detail20;
    @Bind(R.id.detail21)
    Button detail21;
    @Bind(R.id.detail22)
    Button detail22;


    @Bind(R.id.disease)
    EditText disease;
    @Bind(R.id.medicine)
    EditText medicine;


    String timeStamp = "2798";
    String personId = "2798";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_info);
        ButterKnife.bind(this);

        if (getIntent().getExtras() != null) {
            timeStamp = getIntent().getExtras().getString("timeStamp");
            personId = getIntent().getExtras().getString("personId");
        }

    }

    @OnCheckedChanged({R.id.one_one, R.id.one_two, R.id.one_three, R.id.two_one, R.id.two_two, R.id.three_one, R.id.three_two, R.id.four_one, R.id.four_two, R.id.five_one, R.id.five_two, R.id.five_three, R.id.six_one, R.id.six_two, R.id.seven_one, R.id.eight_one, R.id.eight_two, R.id.eight_three, R.id.nine_one, R.id.nine_two, R.id.ten_one, R.id.ten_two, R.id.ten_three, R.id.ten_four, R.id.fourteen_one, R.id.fourteen_two, R.id.fourteen_three, R.id.fourteen_four, R.id.fourteen_five, R.id.seventeen_one, R.id.seventeen_two, R.id.seventeen_three, R.id.seventeen_four, R.id.seventeen_five, R.id.nineteen_one, R.id.nineteen_two, R.id.twenty_one, R.id.twenty_two})
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
                    detail_count++;
                    detail2B.setVisibility(View.VISIBLE);
                } else {
                    detail_count--;
                    detail2.setVisibility(View.GONE);
                    detail_count--;
                    detail2B.setVisibility(View.GONE);
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


            case R.id.fourteen_one:
            case R.id.fourteen_two:
            case R.id.fourteen_three:
            case R.id.fourteen_four:
            case R.id.fourteen_five:
                if (isChecked)
                    flag14++;
                else
                    flag14--;

                if (flag14 > 0) {
                    detail_count++;
                    detail14.setVisibility(View.VISIBLE);
                } else {
                    detail_count--;
                    detail14.setVisibility(View.GONE);
                }

                break;
            case R.id.seventeen_one:
            case R.id.seventeen_two:
            case R.id.seventeen_three:
            case R.id.seventeen_four:
            case R.id.seventeen_five:
                if (isChecked)
                    flag17++;
                else
                    flag17--;

                if (flag17 > 0) {
                    detail_count++;
                    detail17.setVisibility(View.VISIBLE);
                } else {
                    detail_count--;
                    detail17.setVisibility(View.GONE);
                }

                break;
            case R.id.nineteen_one:
            case R.id.nineteen_two:
                break;
            case R.id.twenty_one:
            case R.id.twenty_two:
                if (isChecked)
                    flag20++;
                else
                    flag20--;

                if (flag20 > 0) {
                    detail_count++;
                    detail20.setVisibility(View.VISIBLE);
                } else {
                    detail_count--;
                    detail20.setVisibility(View.GONE);
                }

                break;

        }
    }

    @OnClick({R.id.detail1, R.id.detail2, R.id.detail5, R.id.detail7, R.id.detail8, R.id.detail9, R.id.detail10, R.id.detail11, R.id.detail12, R.id.detail13, R.id.detail14, R.id.detail15, R.id.detail16, R.id.detail17, R.id.detail18, R.id.detail20, R.id.detail21, R.id.detail22, R.id.add})
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.detail1:
                intent = new Intent(SimpleInfoBackActivity.this, MNAActivity.class);
                intent.putExtra("timeStamp", timeStamp);
                intent.putExtra("personId", personId);
                startActivityForResult(intent, 1);
                break;
            case R.id.detail2:
                intent = new Intent(SimpleInfoBackActivity.this, WaTianBackActivity.class);
                intent.putExtra("timeStamp", timeStamp);
                intent.putExtra("personId", personId);
                startActivityForResult(intent, 2);
                break;
            case R.id.detail2B:
                intent = new Intent(SimpleInfoBackActivity.this, TunYanActivity.class);
                intent.putExtra("timeStamp", timeStamp);
                intent.putExtra("personId", personId);
                startActivityForResult(intent, 200);
                break;
            case R.id.detail5:
                intent = new Intent(SimpleInfoBackActivity.this, ICIQSFActivity.class);
                intent.putExtra("timeStamp", timeStamp);
                intent.putExtra("personId", personId);
                startActivityForResult(intent, 5);
                break;
            case R.id.detail7:
                intent = new Intent(SimpleInfoBackActivity.this, FRSActivity.class);
                intent.putExtra("timeStamp", timeStamp);
                intent.putExtra("personId", personId);
                startActivityForResult(intent, 7);
                break;
            case R.id.detail8:
                intent = new Intent(SimpleInfoBackActivity.this, PSQIActivity.class);
                intent.putExtra("timeStamp", timeStamp);
                intent.putExtra("personId", personId);
                startActivityForResult(intent, 8);
                break;
            case R.id.detail9:
                intent = new Intent(SimpleInfoBackActivity.this, FRAActivity.class);
                intent.putExtra("timeStamp", timeStamp);
                intent.putExtra("personId", personId);
                startActivityForResult(intent, 9);
                break;
            case R.id.detail10:
                intent = new Intent(SimpleInfoBackActivity.this, CAMCRActivity.class);
                intent.putExtra("timeStamp", timeStamp);
                intent.putExtra("personId", personId);
                startActivityForResult(intent, 10);
                break;


            case R.id.detail11:
                intent = new Intent(SimpleInfoBackActivity.this, MMSEActivity.class);
                intent.putExtra("timeStamp", timeStamp);
                intent.putExtra("personId", personId);
                startActivityForResult(intent, 11);
                break;
            case R.id.detail12:
                intent = new Intent(SimpleInfoBackActivity.this, HISActivity.class);
                intent.putExtra("timeStamp", timeStamp);
                intent.putExtra("personId", personId);
                startActivityForResult(intent, 12);
                break;
            case R.id.detail13:
                intent = new Intent(SimpleInfoBackActivity.this, ZungActivity.class);
                intent.putExtra("timeStamp", timeStamp);
                intent.putExtra("personId", personId);
                startActivityForResult(intent, 13);
                break;

            case R.id.detail14:
                intent = new Intent(SimpleInfoBackActivity.this, ZungSDSActivity.class);
                intent.putExtra("timeStamp", timeStamp);
                intent.putExtra("personId", personId);
                startActivityForResult(intent, 14);
                break;
            case R.id.detail15:
                intent = new Intent(SimpleInfoBackActivity.this, GDSActivity.class);
                intent.putExtra("timeStamp", timeStamp);
                intent.putExtra("personId", personId);
                startActivityForResult(intent, 15);
                break;
            case R.id.detail16:
                intent = new Intent(SimpleInfoBackActivity.this, GDSDDActivity.class);
                intent.putExtra("timeStamp", timeStamp);
                intent.putExtra("personId", personId);
                startActivityForResult(intent, 16);
                break;

            case R.id.detail17:
                intent = new Intent(SimpleInfoBackActivity.this, ADLActivity.class);
                intent.putExtra("timeStamp", timeStamp);
                intent.putExtra("personId", personId);
                startActivityForResult(intent, 17);
                break;
            case R.id.detail18:
                intent = new Intent(SimpleInfoBackActivity.this, FIMActivity.class);
                intent.putExtra("timeStamp", timeStamp);
                intent.putExtra("personId", personId);
                startActivityForResult(intent, 18);
                break;

            case R.id.detail20:
                intent = new Intent(SimpleInfoBackActivity.this, TinettiActivity.class);
                intent.putExtra("timeStamp", timeStamp);
                intent.putExtra("personId", personId);
                startActivityForResult(intent, 20);
                break;
            case R.id.detail21:
                intent = new Intent(SimpleInfoBackActivity.this, APGARActivity.class);
                intent.putExtra("timeStamp", timeStamp);
                intent.putExtra("personId", personId);
                startActivityForResult(intent, 21);
                break;
            case R.id.detail22:
                intent = new Intent(SimpleInfoBackActivity.this, FAQActivity.class);
                intent.putExtra("timeStamp", timeStamp);
                intent.putExtra("personId", personId);
                startActivityForResult(intent, 22);
                break;


            case R.id.add:
                if (detail_count > 0)
                    Toast.makeText(SimpleInfoBackActivity.this, "请填写完详细调查", Toast.LENGTH_SHORT).show();
                else {

                    insertDao();

                    Toast.makeText(getApplicationContext(), "问卷填写完成", Toast.LENGTH_SHORT).show();
                    intent = new Intent(SimpleInfoBackActivity.this, MainBackActivity.class);
                    startActivity(intent);
                }
                break;
        }
    }

    public void insertDao() {


        // 插入操作，简单到只要你创建一个 Java 对象
        SimpleInfo simpleInfo = new SimpleInfo(null
                , timeStamp
                , personId
                , disease.getText().toString()
                , medicine.getText().toString()
                , oneOne.isChecked()
                , oneTwo.isChecked()
                , oneThree.isChecked()
                , twoOne.isChecked()
                , twoTwo.isChecked()
                , threeOne.isChecked()
                , threeTwo.isChecked()
                , fourOne.isChecked()
                , fourTwo.isChecked()
                , fiveOne.isChecked()
                , fiveTwo.isChecked()
                , fiveThree.isChecked()
                , sixOne.isChecked()
                , sixTwo.isChecked()
                , sevenOne.isChecked()
                , eightOne.isChecked()
                , eightTwo.isChecked()
                , eightThree.isChecked()
                , nineOne.isChecked()
                , nineTwo.isChecked()
                , tenOne.isChecked()
                , tenTwo.isChecked()
                , tenThree.isChecked()
                , tenFour.isChecked()
                , fourteenOne.isChecked()
                , fourteenTwo.isChecked()
                , fourteenThree.isChecked()
                , fourteenFour.isChecked()
                , fourteenFive.isChecked()
                , seventeenOne.isChecked()
                , seventeenTwo.isChecked()
                , seventeenThree.isChecked()
                , seventeenFour.isChecked()
                , seventeenFive.isChecked()
                , nineteenOne.isChecked()
                , nineteenTwo.isChecked()
                , twentyOne.isChecked()
                , twentyTwo.isChecked()

        );
        MyApplication.getSimpleInfoDao().insert(simpleInfo);
        Log.d(TAG, "Inserted new note, ID: " + simpleInfo.getId());
        //   cursor.requery();
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
                case 200:
                    detail2B.setText("已完成");
                    detail2B.setBackgroundColor(getResources().getColor(R.color.colorGray));
                    detail2B.setEnabled(false);
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


                case 11:
                    detail11.setText("已完成");
                    detail11.setBackgroundColor(getResources().getColor(R.color.colorGray));
                    detail11.setEnabled(false);
                    detail_count--;
                    break;
                case 12:
                    detail12.setText("已完成");
                    detail12.setBackgroundColor(getResources().getColor(R.color.colorGray));
                    detail12.setEnabled(false);
                    detail_count--;
                    break;
                case 13:
                    detail13.setText("已完成");
                    detail13.setBackgroundColor(getResources().getColor(R.color.colorGray));
                    detail13.setEnabled(false);
                    detail_count--;
                    break;
                case 14:
                    detail14.setText("已完成");
                    detail14.setBackgroundColor(getResources().getColor(R.color.colorGray));
                    detail14.setEnabled(false);
                    detail_count--;
                    break;

                case 15:
                    detail15.setText("已完成");
                    detail15.setBackgroundColor(getResources().getColor(R.color.colorGray));
                    detail15.setEnabled(false);
                    detail_count--;
                    break;
                case 16:
                    detail16.setText("已完成");
                    detail16.setBackgroundColor(getResources().getColor(R.color.colorGray));
                    detail16.setEnabled(false);
                    detail_count--;
                    break;
                case 17:
                    detail17.setText("已完成");
                    detail17.setBackgroundColor(getResources().getColor(R.color.colorGray));
                    detail17.setEnabled(false);
                    detail_count--;
                    break;
                case 18:
                    detail18.setText("已完成");
                    detail18.setBackgroundColor(getResources().getColor(R.color.colorGray));
                    detail18.setEnabled(false);
                    detail_count--;
                    break;

                case 20:
                    detail20.setText("已完成");
                    detail20.setBackgroundColor(getResources().getColor(R.color.colorGray));
                    detail20.setEnabled(false);
                    detail_count--;
                    break;
                case 21:
                    detail21.setText("已完成");
                    detail21.setBackgroundColor(getResources().getColor(R.color.colorGray));
                    detail21.setEnabled(false);
                    detail_count--;
                    break;
                case 22:
                    detail22.setText("已完成");
                    detail22.setBackgroundColor(getResources().getColor(R.color.colorGray));
                    detail22.setEnabled(false);
                    detail_count--;
                    break;

            }
        }

    }

}
