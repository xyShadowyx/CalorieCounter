package de.fhdw.bfws115a.team1.caloriecounter.activities.calendar;

import android.content.Intent;
import android.os.Bundle;

import java.util.Calendar;

/**
 * @author Florian Obladen.
 */

public class Data {
    private final String KEYSELECTEDYEAR = "calendar1";
    private final String KEYSELECTEDMONTH = "calendar2";
    private final String KEYSELECTEDDAY = "calendar3";
    /*Member variable*/
    private Init mActivity;

    /*Keys*/
    private int mSelectedYear;
    private int mSelectedMonth;
    private int mSelectedDay;

    /**
     * Method which gets the current layout attributes and put them into an 'Intent' object.
     * The reasons are possible saving and retrieving options of the data stored.
     *
     * @param savedInstanceState A bundle where data can be stored.
     * @param activity           The current initialised activity.
     */
    public Data(Bundle savedInstanceState, Init activity) {
        mActivity = activity;

        if (savedInstanceState == null) {
            Intent intent;
            Calendar calendarToday;
            intent = mActivity.getIntent();
            calendarToday = Calendar.getInstance();

            mSelectedYear = intent.getIntExtra("year", calendarToday.get(Calendar.YEAR));
            mSelectedMonth = intent.getIntExtra("month", calendarToday.get(Calendar.MONTH));
            mSelectedDay = intent.getIntExtra("day", calendarToday.get(Calendar.DAY_OF_MONTH));
        } else {
            restoreDataFromBundle(savedInstanceState);
        }
    }

    /**
     * Provides the possibility of saving the non-persistent data in a bundle.
     *
     * @param b The bundle where the data will be saved.
     */
    public void saveDataInBundle(Bundle b) {
        b.putInt(KEYSELECTEDYEAR, mSelectedYear);
        b.putInt(KEYSELECTEDMONTH, mSelectedMonth);
        b.putInt(KEYSELECTEDDAY, mSelectedDay);
    }

    /**
     * Provides the possibility of retrieving the saved non-persistent data.
     *
     * @param b The bundle where the data is saved in.
     */
    private void restoreDataFromBundle(Bundle b) {
        mSelectedYear = b.getInt(KEYSELECTEDYEAR);
        mSelectedMonth = b.getInt(KEYSELECTEDMONTH);
        mSelectedDay = b.getInt(KEYSELECTEDDAY);
    }

    /* Getter methods */
    public Init getActivity() {
        return mActivity;
    }

    public int getSelectedYear() {
        return mSelectedYear;
    }

    /* Setter methods */
    public void setSelectedYear(int mSelectedYear) {
        this.mSelectedYear = mSelectedYear;
    }

    public int getSelectedMonth() {
        return mSelectedMonth;
    }

    public void setSelectedMonth(int mSelectedMonth) {
        this.mSelectedMonth = mSelectedMonth;
    }

    public int getSelectedDay() {
        return mSelectedDay;
    }

    public void setSelectedDay(int mSelectedDay) {
        this.mSelectedDay = mSelectedDay;
    }
}