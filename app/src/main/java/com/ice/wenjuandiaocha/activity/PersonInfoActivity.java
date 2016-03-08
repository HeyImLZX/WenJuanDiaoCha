package com.ice.wenjuandiaocha.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.ice.greendao.DaoMaster;
import com.ice.greendao.DaoSession;
import com.ice.greendao.PersonInfo;
import com.ice.greendao.PersonInfoDao;
import com.ice.wenjuandiaocha.R;
import com.ice.wenjuandiaocha.util.DatePickerFragment;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PersonInfoActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private static final String TAG = "PersonInfoActivity";
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
    @Bind(R.id.accident)
    TextView accident;
    @Bind(R.id.wish1)
    EditText wish1;
    @Bind(R.id.wish2)
    EditText wish2;
    @Bind(R.id.add)
    Button add;
    private DatePickerFragment newFragment;

    private SQLiteDatabase db;
    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_info);
        ButterKnife.bind(this);

        // 官方推荐将获取 DaoMaster 对象的方法放到 Application 层，这样将避免多次创建生成 Session 对象
        setupDatabase();
        // 获取 NoteDao 对象
        getPersonInfoDao();

        cursor = db.query(getPersonInfoDao().getTablename(), getPersonInfoDao().getAllColumns(), null, null, null, null, null);


        ArrayAdapter<CharSequence> sexAdapter = ArrayAdapter.createFromResource(this,
                R.array.sex_array, android.R.layout.simple_spinner_item);
        sexAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sex.setAdapter(sexAdapter);

        ArrayAdapter<CharSequence> educationAdapter = ArrayAdapter.createFromResource(this,
                R.array.education_array, android.R.layout.simple_spinner_item);
        educationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        education.setAdapter(educationAdapter);

        ArrayAdapter<CharSequence> occupationAdapter = ArrayAdapter.createFromResource(this,
                R.array.occupation_array, android.R.layout.simple_spinner_item);
        occupationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        occupation.setAdapter(occupationAdapter);

        ArrayAdapter<CharSequence> marriageAdapter = ArrayAdapter.createFromResource(this,
                R.array.marriage_array, android.R.layout.simple_spinner_item);
        marriageAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        marriage.setAdapter(marriageAdapter);

        ArrayAdapter<CharSequence> paymentAdapter = ArrayAdapter.createFromResource(this,
                R.array.payment_array, android.R.layout.simple_spinner_item);
        paymentAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        payment.setAdapter(paymentAdapter);

        ArrayAdapter<CharSequence> homeAdapter = ArrayAdapter.createFromResource(this,
                R.array.home_array, android.R.layout.simple_spinner_item);
        homeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        home.setAdapter(homeAdapter);

        ArrayAdapter<CharSequence> economyAdapter = ArrayAdapter.createFromResource(this,
                R.array.economy_array, android.R.layout.simple_spinner_item);
        economyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        economy.setAdapter(economyAdapter);

        ArrayAdapter<CharSequence> oldhelpAdapter = ArrayAdapter.createFromResource(this,
                R.array.oldhelp_array, android.R.layout.simple_spinner_item);
        oldhelpAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        oldhelp.setAdapter(oldhelpAdapter);

//
//        sex.setOnItemSelectedListener(listener);
//        education.setOnItemSelectedListener(listener);
//        occupation.setOnItemSelectedListener(listener);
//        marriage.setOnItemSelectedListener(listener);
//        payment.setOnItemSelectedListener(listener);
//        home.setOnItemSelectedListener(listener);
//        economy.setOnItemSelectedListener(listener);
//        oldhelp.setOnItemSelectedListener(listener);

        birthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(v);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 插入操作，简单到只要你创建一个 Java 对象
                PersonInfo note = new PersonInfo(null, name.getText().toString(), sex.getSelectedItem().toString(), birthday.getText().toString()
                        , height.getText().toString()
                        , weight.getText().toString()
                        , provider.getText().toString()
                        , relation.getText().toString()
                        , religion.getText().toString()
                        , idcard.getText().toString()
                        , education.getSelectedItem().toString()
                        , occupation.getSelectedItem().toString()
                        , marriage.getSelectedItem().toString()
                        , payment.getSelectedItem().toString()
                        , home.getSelectedItem().toString()
                        , economy.getSelectedItem().toString()
                        , oldhelp.getSelectedItem().toString()
                        , accident.getText().toString()
                        , wish1.getText().toString()
                        , wish2.getText().toString());
                getPersonInfoDao().insert(note);
                Log.d(TAG, "Inserted new note, ID: " + note.getId());
                cursor.requery();

                Intent intent = new Intent(PersonInfoActivity.this, SimpleInfoActivity.class);
                startActivity(intent);
            }
        });


    }

    private void setupDatabase() {
        // 通过 DaoMaster 的内部类 DevOpenHelper，你可以得到一个便利的 SQLiteOpenHelper 对象。
        // 可能你已经注意到了，你并不需要去编写「CREATE TABLE」这样的 SQL 语句，因为 greenDAO 已经帮你做了。
        // 注意：默认的 DaoMaster.DevOpenHelper 会在数据库升级时，删除所有的表，意味着这将导致数据的丢失。
        // 所以，在正式的项目中，你还应该做一层封装，来实现数据库的安全升级。
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "notes-db", null);
        db = helper.getWritableDatabase();
        // 注意：该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接。
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    private PersonInfoDao getPersonInfoDao() {
        return daoSession.getPersonInfoDao();
    }

//
//    AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {
//        @Override
//        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//            switch (parent.getId()) {
//                case R.id.sex:
//                    Log.e("dddd", "ddddddddddddddddddddddddddddddddddddddddddddd" + position);
//                    break;
//                case R.id.education:
//                    Log.e("dddd", "ddddddddddddddddddddddddddddddddddddddddddddd" + position);
//                    break;
//                case R.id.occupation:
//                    Log.e("dddd", "ddddddddddddddddddddddddddddddddddddddddddddd" + position);
//                    break;
//                case R.id.marriage:
//                    break;
//                case R.id.payment:
//                    break;
//                case R.id.home:
//                    break;
//                case R.id.economy:
//                    break;
//                case R.id.oldhelp:
//                    break;
//            }
//        }
//
//        @Override
//        public void onNothingSelected(AdapterView<?> parent) {
//
//        }
//    };

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
