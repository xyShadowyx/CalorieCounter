package de.fhdw.bfws115a.team1.caloriecounter.activities.dailyoverview;

import android.content.Intent;
import android.os.Bundle;

import java.util.Calendar;

public class Data {
    private Init mActivity;

    /* Data variables */
    private int mSelectedYear;
    private int mSelectedMonth;
    private int mSelectedDay;

    /* Default values */

    /* Keys */
    private final String KEY_DAILYOVERVIEW_SELECTED_YEAR = "dailyoverview1";
    private final String KEY_DAILYOVERVIEW_SELECTED_MONTH = "dailyoverview2";
    private final String KEY_DAILYOVERVIEW_SELECTED_DAY = "dailyoverview3";

    public Data(Bundle savedInstanceState, Init activity) {
        mActivity = activity;

        if (savedInstanceState == null) {
            Intent intent = mActivity.getIntent();
            Calendar calendarToday = Calendar.getInstance();
            mSelectedYear = intent.getIntExtra("year", calendarToday.get(Calendar.YEAR));
            mSelectedMonth = intent.getIntExtra("month", calendarToday.get(Calendar.MONTH));
            mSelectedDay = intent.getIntExtra("day", calendarToday.get(Calendar.DAY_OF_MONTH));

        } else {
            restoreDataFromBundle(savedInstanceState);
        }
    }

    public void saveDataInBundle(Bundle b) {
        b.putInt(KEY_DAILYOVERVIEW_SELECTED_YEAR, mSelectedYear);
        b.putInt(KEY_DAILYOVERVIEW_SELECTED_MONTH, mSelectedMonth);
        b.putInt(KEY_DAILYOVERVIEW_SELECTED_DAY, mSelectedDay);
    }

    private void restoreDataFromBundle(Bundle b) {
        mSelectedYear = b.getInt(KEY_DAILYOVERVIEW_SELECTED_YEAR);
        mSelectedMonth = b.getInt(KEY_DAILYOVERVIEW_SELECTED_MONTH);
        mSelectedDay = b.getInt(KEY_DAILYOVERVIEW_SELECTED_DAY);
    }

    /* Getter methods */
    public Init getActivity() {
        return mActivity;
    }

    public int getSelectedYear() {
        return mSelectedYear;
    }

    public int getSelectedMonth() {
        return mSelectedMonth;
    }

    public int getSelectedDay() {
        return mSelectedDay;
    }

    /* Setter methods */
}
