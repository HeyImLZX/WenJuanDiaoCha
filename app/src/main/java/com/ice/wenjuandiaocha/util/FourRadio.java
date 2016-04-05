package com.ice.wenjuandiaocha.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.ice.wenjuandiaocha.R;

import java.util.ArrayList;


/**
 * Created by ice on 2016/3/15.
 */
public class FourRadio extends ViewGroup {

    private String radio1;
    private String radio2;
    private String radio3;
    private String radio4;

    ArrayList<String> stringArrayList = new ArrayList<>();


    public FourRadio(Context context) {
        this(context, null);
    }

    public FourRadio(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FourRadio(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        //获取自定义属性
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.FourRadio, defStyle, 0);

        radio1 = a.getString(R.styleable.FourRadio_radio_text1);
        radio2 = a.getString(R.styleable.FourRadio_radio_text2);
        radio3 = a.getString(R.styleable.FourRadio_radio_text3);
        radio4 = a.getString(R.styleable.FourRadio_radio_text4);

        stringArrayList.add(radio1);
        stringArrayList.add(radio2);
        stringArrayList.add(radio3);
        stringArrayList.add(radio4);


        a.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            measureChild(getChildAt(i), widthMeasureSpec, heightMeasureSpec);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(final boolean changed, int l, int t, int r, int b) {

        int mViewGroupWidth = getMeasuredWidth();  //当前ViewGroup的总宽度

        int mPainterPosX = l;  //当前绘图光标横坐标位置
        int mPainterPosY = t;  //当前绘图光标纵坐标位置

        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {

            View childView = getChildAt(i);

            ((RadioButton) childView).setText(stringArrayList.get(i));


            int width = childView.getMeasuredWidth();
            int height = childView.getMeasuredHeight();

            //如果剩余的空间不够，则移到下一行开始位置
            if (mPainterPosX + width > mViewGroupWidth) {
                mPainterPosX = l;
                mPainterPosY += height;
            }

            //执行ChildView的绘制
            childView.layout(mPainterPosX, mPainterPosY, mPainterPosX + width, mPainterPosY + height);

            //记录当前已经绘制到的横坐标位置
            mPainterPosX += width;
        }


    }


}
