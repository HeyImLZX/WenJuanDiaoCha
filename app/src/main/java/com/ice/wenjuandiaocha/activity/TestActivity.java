package com.ice.wenjuandiaocha.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.ice.wenjuandiaocha.R;

import java.util.ArrayList;
import java.util.List;

public class TestActivity extends AppCompatActivity {

    private ListView list;
    ArrayList<String> arrayList = new ArrayList<String>();
    String[] strings = {"MNA", "洼田饮水", "吞咽困难", "尿失禁ICIQSF", "面部表情FRS", "匹兹堡睡眠PSQI", "跌到风险FRA", "谵妄CAMCR", "简易智力Minicog", "简易智能MMSE", "焦虑Zung", "抑郁Zung", "GDS15", "GDSDD", "日常生活ADL", "功能独立FIM", "Tinwtti平衡量步态量", "APGAR家庭功能", "老年社会FAQ"};
    Class[] activityArray = {MNAActivity.class, WaTianBackActivity.class, TunYanActivity.class, ICIQSFActivity.class,
            FRSActivity.class, PSQIActivity.class, FRAActivity.class, CAMCRActivity.class, MiniCogActivity.class, MMSEActivity.class, ZungActivity.class, ZungSDSActivity.class, GDSActivity.class, GDSDDActivity.class, ADLActivity.class, FIMActivity.class, TinettiActivity.class, APGARActivity.class, FAQActivity.class};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);


        list = (ListView) findViewById(R.id.list);

        for (int i = 0; i < strings.length; i++)
            arrayList.add(strings[i]);


        ArrayAdapter arrayAdapter = new ArrayAdapter(TestActivity.this, android.R.layout.simple_list_item_1, arrayList);

        list.setAdapter(arrayAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(TestActivity.this, activityArray[position]);
                startActivity(intent);

            }
        });

    }
}
