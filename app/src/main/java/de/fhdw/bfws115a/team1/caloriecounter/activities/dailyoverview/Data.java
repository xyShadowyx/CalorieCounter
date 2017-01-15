package de.fhdw.bfws115a.team1.caloriecounter.activities.dailyoverview;

import android.content.Intent;
import android.os.Bundle;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseEntityManager;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseEntry;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;

public class Data {

    /* Member variables */
    private Init mActivity;
    private DatabaseEntityManager mDatabaseEntityManager;
    private ArrayList<DatabaseEntry> mDatabaseEntryList;
    private DatabaseEntry mEntryToCopy;
    private int mSelectedYear;
    private int mSelectedMonth;
    private int mSelectedDay;

    /* Keys */
    private final String KEY_DAILYOVERVIEW_SELECTED_YEAR = "dailyoverview1";
    private final String KEY_DAILYOVERVIEW_SELECTED_MONTH = "dailyoverview2";
    private final String KEY_DAILYOVERVIEW_SELECTED_DAY = "dailyoverview3";

    /**
     * Method which gets the current layout attributes and put them into an 'Intent' object.
     * The reasons are possible saving and retrieving options of the data stored.
     *
     * @param savedInstanceState A bundle where data can be stored.
     * @param activity           The current initialised activity.
     */
    public Data(Bundle savedInstanceState, Init activity) {
        mActivity = activity;
        mDatabaseEntityManager = new DatabaseEntityManager(mActivity.getApplicationContext());

        mDatabaseEntryList = new ArrayList<DatabaseEntry>();
        if (savedInstanceState == null) {
            Intent intent;
            intent = mActivity.getIntent();
            Calendar calendarToday = Calendar.getInstance();
            
            mSelectedYear = intent.getIntExtra("year", calendarToday.get(Calendar.YEAR));
            mSelectedMonth = intent.getIntExtra("month", calendarToday.get(Calendar.MONTH));
            mSelectedDay = intent.getIntExtra("day", calendarToday.get(Calendar.DAY_OF_MONTH));
            mDatabaseEntryList.addAll(mDatabaseEntityManager.getEntriesOf(mSelectedYear, mSelectedMonth, mSelectedDay));
            mEntryToCopy = null;

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
        b.putInt(KEY_DAILYOVERVIEW_SELECTED_YEAR, mSelectedYear);
        b.putInt(KEY_DAILYOVERVIEW_SELECTED_MONTH, mSelectedMonth);
        b.putInt(KEY_DAILYOVERVIEW_SELECTED_DAY, mSelectedDay);
    }

    /**
     * Provides the possibility of retrieving the saved non-persistent data.
     *
     * @param b The bundle where the data is saved in.
     */
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

    public DatabaseEntityManager getDatabaseEntityManager() {
        return mDatabaseEntityManager;
    }

    public ArrayList<DatabaseEntry> getDatabaseEntryList() {
        return mDatabaseEntryList;
    }

    public DatabaseEntry getEntryToCopy() {
        return mEntryToCopy;
    }
    /* Setter Methods */
    public void setEntryToCopy(DatabaseEntry entryToCopy) {
        this.mEntryToCopy = entryToCopy;
    }
}