package com.ice.wenjuandiaocha.util;

import android.app.DatePickerDialog;
import android.app.Dialog;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;

import com.ice.wenjuandiaocha.activity.PersonInfoActivity;

import java.util.Calendar;

/**
 * Created by ice on 2016/3/7.
 */
public class DatePickerFragment extends DialogFragment {

    private int mYear;
    private int mMonth;
    private int mDay;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
//         mYear = c.get(Calendar.YEAR);
//        mMonth = c.get(Calendar.MONTH);
//         mDay = c.get(Calendar.DAY_OF_MONTH);
        mYear = 1990;
        mMonth = 1;
        mDay = 1;
        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), (PersonInfoActivity) getActivity(), mYear, mMonth, mDay);
    }

//    public void onDateSet(DatePicker view, int year, int month, int day) {
//        // Do something with the date chosen by the user
//
//        mYear =year;
//        mMonth =month;
//        mDay = day;
//    }
//
//    public String getDate(){
//
//        String result =mYear +"-"+mMonth+"-"+mDay;
//        return result;
//    }
}
