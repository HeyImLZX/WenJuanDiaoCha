package com.ice.wenjuandiaocha.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.GridLayout;
import android.widget.GridView;

import com.ice.wenjuandiaocha.R;

public class SimpleInfoActivity extends AppCompatActivity {

    private CheckBox oneone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_info);


        final GridLayout grid = (GridLayout) findViewById(R.id.lllg);
      //  grid.setVisibility(View.GONE);

        oneone = (CheckBox) findViewById(R.id.one_one);
        oneone.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                         grid.setVisibility(View.GONE);
                else
                    grid.setVisibility(View.VISIBLE);

            }
        });
    }
}
