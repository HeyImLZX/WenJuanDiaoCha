package com.ice.wenjuandiaocha.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.ice.greendao.PersonInfo;
import com.ice.wenjuandiaocha.Application.MyApplication;
import com.ice.wenjuandiaocha.R;
import com.ice.wenjuandiaocha.base.BaseBackActivity;
import com.ice.wenjuandiaocha.util.DatePickerFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PersonInfoBackActivity extends BaseBackActivity implements DatePickerDialog.OnDateSetListener {

    private static final String TAG = "PersonInfoBackActivity";
    @Bind(R.id.name)
    EditText name;
    @Bind(R.id.sex)
    Spinner sex;
    @Bind(R.id.birthday)
    TextView birthday;
    @Bind(R.id.height)
    EditText height;
    @Bind(R.id.weight)
    EditText weight;
    @Bind(R.id.provider)
    EditText provider;
    @Bind(R.id.relation)
    EditText relation;
    @Bind(R.id.age)
    EditText age;
    @Bind(R.id.religion)
    EditText religion;
    @Bind(R.id.idcard)
    EditText idcard;
    @Bind(R.id.education)
    Spinner education;
    @Bind(R.id.occupation)
    Spinner occupation;
    @Bind(R.id.marriage)
    Spinner marriage;
    @Bind(R.id.payment)
    Spinner payment;
    @Bind(R.id.home)
    Spinner home;
    @Bind(R.id.economy)
    Spinner economy;
    @Bind(R.id.oldhelp)
    Spinner oldhelp;

    @Bind(R.id.wish1)
    EditText wish1;
    @Bind(R.id.wish2)
    EditText wish2;
    @Bind(R.id.add)
    Button add;
    @Bind(R.id.accident1)
    CheckBox accident1;
    @Bind(R.id.accident2)
    CheckBox accident2;
    @Bind(R.id.accident3)
    CheckBox accident3;
    @Bind(R.id.accident4)
    CheckBox accident4;
    private DatePickerFragment newFragment;


    long timeStamp = 0;
    private ArrayAdapter<CharSequence> sexAdapter;
    private ArrayAdapter<CharSequence> educationAdapter;
    private ArrayAdapter<CharSequence> occupationAdapter;
    private ArrayAdapter<CharSequence> marriageAdapter;
    private ArrayAdapter<CharSequence> paymentAdapter;
    private ArrayAdapter<CharSequence> homeAdapter;
    private ArrayAdapter<CharSequence> economyAdapter;
    private ArrayAdapter<CharSequence> oldhelpAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_info);
        ButterKnife.bind(this);

        setTitle("基本信息");



//        cursor = db.query(getPersonInfoDao().getTablename(), getPersonInfoDao().getAllColumns(), null, null, null, null, null);


        sexAdapter = ArrayAdapter.createFromResource(this,
                R.array.sex_array, android.R.layout.simple_spinner_item);
        sexAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sex.setAdapter(sexAdapter);

        educationAdapter = ArrayAdapter.createFromResource(this,
                R.array.education_array, android.R.layout.simple_spinner_item);
        educationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        education.setAdapter(educationAdapter);

        occupationAdapter = ArrayAdapter.createFromResource(this,
                R.array.occupation_array, android.R.layout.simple_spinner_item);
        occupationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        occupation.setAdapter(occupationAdapter);

        marriageAdapter = ArrayAdapter.createFromResource(this,
                R.array.marriage_array, android.R.layout.simple_spinner_item);
        marriageAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        marriage.setAdapter(marriageAdapter);

        paymentAdapter = ArrayAdapter.createFromResource(this,
                R.array.payment_array, android.R.layout.simple_spinner_item);
        paymentAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        payment.setAdapter(paymentAdapter);

        homeAdapter = ArrayAdapter.createFromResource(this,
                R.array.home_array, android.R.layout.simple_spinner_item);
        homeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        home.setAdapter(homeAdapter);

        economyAdapter = ArrayAdapter.createFromResource(this,
                R.array.economy_array, android.R.layout.simple_spinner_item);
        economyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        economy.setAdapter(economyAdapter);

        oldhelpAdapter = ArrayAdapter.createFromResource(this,
                R.array.oldhelp_array, android.R.layout.simple_spinner_item);
        oldhelpAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        oldhelp.setAdapter(oldhelpAdapter);


        if (getIntent().getExtras() != null) {

            if (getIntent().getExtras().getString("personId") != null) {
                idcard.setText(getIntent().getExtras().getString("personId"));
            } else if (getIntent().getExtras().getSerializable("personInfo") != null) {
                PersonInfo personInfo = (PersonInfo) getIntent().getExtras().getSerializable("personInfo");
                initOrgin(personInfo);
            }
        }



        birthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(v);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().toString().isEmpty())
                    name.setError("姓名不能为空");
                if (height.getText().toString().isEmpty())
                    height.setError("请输入身高");
                if (weight.getText().toString().isEmpty())
                    weight.setError("请输入体重");
                if (provider.getText().toString().isEmpty())
                    provider.setError("请输入供史者");
                if (relation.getText().toString().isEmpty())
                    relation.setError("请输入亲属关系");
                if (age.getText().toString().isEmpty())
                    age.setError("请输入亲属关系");
                if (religion.getText().toString().isEmpty())
                    religion.setError("请输入宗教信仰");
                if (idcard.getText().toString().isEmpty())
                    idcard.setError("请输入身份证号");


                if (name.getText().toString().isEmpty()
                        || height.getText().toString().isEmpty()
                        || weight.getText().toString().isEmpty()
                        || provider.getText().toString().isEmpty()
                        || age.getText().toString().isEmpty()
                        || relation.getText().toString().isEmpty()
                        || religion.getText().toString().isEmpty()
                        || idcard.getText().toString().isEmpty()) {
                    Toast.makeText(PersonInfoBackActivity.this, "请完整填写信息", Toast.LENGTH_SHORT).show();
                } else {
                    timeStamp = System.currentTimeMillis();
                    insertDao();

                    Intent intent = new Intent(PersonInfoBackActivity.this, SimpleInfoBackActivity.class);
                    intent.putExtra("timeStamp", String.valueOf(timeStamp));
                    intent.putExtra("personId", idcard.getText().toString());

                    startActivity(intent);
                }
            }
        });


    }

    private void initOrgin(PersonInfo personInfo) {
        name.setText(personInfo.getName());
        height.setText(personInfo.getHeight());
        weight.setText(personInfo.getWeight());
        provider.setText(personInfo.getProvider());
        relation.setText(personInfo.getRelation());
        age.setText(personInfo.getAge());
        religion.setText(personInfo.getReligion());
        idcard.setText(personInfo.getPersonId());

        birthday.setText(personInfo.getBirthday());

        sex.setSelection(sexAdapter.getPosition(personInfo.getSex()));
        education.setSelection(educationAdapter.getPosition(personInfo.getEducation()));
        occupation.setSelection(occupationAdapter.getPosition(personInfo.getOccupation()));
        marriage.setSelection(marriageAdapter.getPosition(personInfo.getMarriage()));
        payment.setSelection(paymentAdapter.getPosition(personInfo.getPayment()));
        home.setSelection(homeAdapter.getPosition(personInfo.getHome()));
        economy.setSelection(economyAdapter.getPosition(personInfo.getEconomy()));
        oldhelp.setSelection(oldhelpAdapter.getPosition(personInfo.getOldhelp()));

        String[] accident = personInfo.getAccident().split("/");
        for (String chose : accident) {
            if (chose.endsWith("跌倒")) {
                accident1.setChecked(true);
            } else if (chose.endsWith("走失")) {
                accident2.setChecked(true);
            } else if (chose.endsWith("噎食、呛食")) {
                accident3.setChecked(true);
            } else if (chose.endsWith("自杀")) {
                accident4.setChecked(true);
            }

        }


        wish1.setText(personInfo.getWish1());
        wish2.setText(personInfo.getWish2());



    }


    public void insertDao() {

        boolean flag = false;
        StringBuffer accidentResult = new StringBuffer("无");
        if (accident1.isChecked()) {
            accidentResult.append(accident1.getText().toString() + "/");
            flag = true;
        }
        if (accident2.isChecked()) {
            accidentResult.append(accident2.getText().toString() + "/");
            flag = true;
        }
        if (accident3.isChecked()) {
            accidentResult.append(accident3.getText().toString() + "/");
            flag = true;
        }
        if (accident4.isChecked()) {
            accidentResult.append(accident4.getText().toString() + "/");
            flag = true;
        }
        if (flag) {
            accidentResult.deleteCharAt(accidentResult.length() - 1);
            accidentResult.deleteCharAt(0);
        }

        // 插入操作，简单到只要你创建一个 Java 对象
        PersonInfo note = new PersonInfo(null, name.getText().toString(), String.valueOf(timeStamp)
                , sex.getSelectedItem().toString()
                , birthday.getText().toString()
                , height.getText().toString()
                , weight.getText().toString()
                , provider.getText().toString()
                , relation.getText().toString()
                , age.getText().toString()
                , religion.getText().toString()
                , idcard.getText().toString()
                , education.getSelectedItem().toString()
                , occupation.getSelectedItem().toString()
                , marriage.getSelectedItem().toString()
                , payment.getSelectedItem().toString()
                , home.getSelectedItem().toString()
                , economy.getSelectedItem().toString()
                , oldhelp.getSelectedItem().toString()
                , accidentResult.toString()
                , wish1.getText().toString()
                , wish2.getText().toString());
        MyApplication.getPersonInfoDao().insertOrReplace(note);
        Log.d(TAG, "Inserted new note, ID: " + note.getId());
        //   cursor.requery();
    }

//    private void setupDatabase() {
//        // 通过 DaoMaster 的内部类 DevOpenHelper，你可以得到一个便利的 SQLiteOpenHelper 对象。
//        // 可能你已经注意到了，你并不需要去编写「CREATE TABLE」这样的 SQL 语句，因为 greenDAO 已经帮你做了。
//        // 注意：默认的 DaoMaster.DevOpenHelper 会在数据库升级时，删除所有的表，意味着这将导致数据的丢失。
//        // 所以，在正式的项目中，你还应该做一层封装，来实现数据库的安全升级。
//        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "notes-db", null);
//        db = helper.getWritableDatabase();
//        // 注意：该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接。
//        daoMaster = new DaoMaster(db);
//        daoSession = daoMaster.newSession();
//    }
//
//    private PersonInfoDao getPersonInfoDao() {
//        return daoSession.getPersonInfoDao();
//    }


    public void showDatePickerDialog(View v) {
        newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");

    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        String result = year + "-" + monthOfYear + "-" + dayOfMonth;

        birthday.setText(result);

    }


}
