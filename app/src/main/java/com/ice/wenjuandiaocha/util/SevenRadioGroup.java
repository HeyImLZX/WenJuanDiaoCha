package com.ice.wenjuandiaocha.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.ice.wenjuandiaocha.R;

import java.util.ArrayList;


/**
 * Created by ice on 2016/3/15.
 */
public class SevenRadioGroup extends RadioGroup {

    private String radio1;
    private String radio2;
    private String radio3;
    private String radio4;
    private String radio5;
    private String radio6;
    private String radio7;

    ArrayList<String> stringArrayList = new ArrayList<>();

    public SevenRadioGroup(Context context) {
        this(context, null);
    }

    public SevenRadioGroup(Context context, AttributeSet attrs) {
        super(context, attrs);

        //获取自定义属性
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.SevenRadioGroup, 0, 0);

        radio1 = a.getString(R.styleable.SevenRadioGroup_radio_text1);
        radio2 = a.getString(R.styleable.SevenRadioGroup_radio_text2);
        radio3 = a.getString(R.styleable.SevenRadioGroup_radio_text3);
        radio4 = a.getString(R.styleable.SevenRadioGroup_radio_text4);
        radio5 = a.getString(R.styleable.SevenRadioGroup_radio_text5);
        radio6 = a.getString(R.styleable.SevenRadioGroup_radio_text6);
        radio7 = a.getString(R.styleable.SevenRadioGroup_radio_text7);

        stringArrayList.add(radio1);
        stringArrayList.add(radio2);
        stringArrayList.add(radio3);
        stringArrayList.add(radio4);
        stringArrayList.add(radio5);
        stringArrayList.add(radio6);
        stringArrayList.add(radio7);

        a.recycle();


    }


    @Override
    protected void onLayout(final boolean changed, int l, int t, int r, int b) {


        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {

            View childView = getChildAt(i);

            ((RadioButton) childView).setText(stringArrayList.get(i));

        }

        super.onLayout(changed, l, t, r, b);


    }


    public int getSelectRadio() {

        int select = -1;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {

            View childView = getChildAt(i);

            if (((RadioButton) childView).isChecked()) {
                select = i + 1;
                break;
            }

        }

        return select;


    }


}
