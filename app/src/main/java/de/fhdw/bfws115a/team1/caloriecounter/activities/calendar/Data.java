package de.fhdw.bfws115a.team1.caloriecounter.activities.calendar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseEntityManager;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseHelper;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseUnit;
import de.fhdw.bfws115a.team1.caloriecounter.entities.Unit;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Data {
    private Init mActivity;
    private DatabaseHelper mDatabaseHelper;
    private DatabaseEntityManager mDatabaseEntityManager;

    /* Data variables */
    private int mSelectedYear;
    private int mSelectedMonth;
    private int mSelectedDay;

    /* Keys */
    private final String KEYSELECTEDYEAR = "calendar1";
    private final String KEYSELECTEDMONTH = "calendar2";
    private final String KEYSELECTEDDAY = "calendar3";

    public Data(Bundle savedInstanceState, Init activity) {
        mActivity = activity;
        mDatabaseHelper = new DatabaseHelper(mActivity.getApplicationContext(), activity);
        mDatabaseEntityManager = new DatabaseEntityManager(mDatabaseHelper);

        List<DatabaseUnit> databaseUnits = (ArrayList<DatabaseUnit>) mDatabaseEntityManager.getAllUnits();

        mDatabaseEntityManager.createUnit(new Unit("abc"));

        for(DatabaseUnit dbu : databaseUnits) {
            Toast.makeText(mActivity.getApplicationContext(), "Unit: " + dbu.getName(), Toast.LENGTH_SHORT).show();
        }



        Intent intent = mActivity.getIntent();

        if (savedInstanceState == null) {
            Calendar calendarToday = Calendar.getInstance();
            mSelectedYear = intent.getIntExtra("year", calendarToday.get(Calendar.YEAR));
            mSelectedMonth = intent.getIntExtra("month", calendarToday.get(Calendar.MONTH));
            mSelectedDay = intent.getIntExtra("day", calendarToday.get(Calendar.DAY_OF_MONTH));
        } else {
            restoreDataFromBundle(savedInstanceState);
        }
    }

    public void saveDataInBundle(Bundle b) {
        b.putInt(KEYSELECTEDYEAR, mSelectedYear);
        b.putInt(KEYSELECTEDMONTH, mSelectedMonth);
        b.putInt(KEYSELECTEDDAY, mSelectedDay);
    }

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

    public void setSelectedYear(int mSelectedYear) {
        this.mSelectedYear = mSelectedYear;
    }

    public int getSelectedMonth() {
        return mSelectedMonth;
    }

    /* Setter methods */
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
