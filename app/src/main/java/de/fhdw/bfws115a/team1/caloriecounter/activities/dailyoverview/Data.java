package de.fhdw.bfws115a.team1.caloriecounter.activities.dailyoverview;

import android.content.Intent;
import android.os.Bundle;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseEntityManager;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseEntry;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * @author Viktor Schroeder
 */
public class Data {

    /* Keys */
    private final String KEY_DAILYOVERVIEW_DATABASE_ENTRY_LIST = "dailyoverview1";
    private final String KEY_DAILYOVERVIEW_SELECTED_YEAR = "dailyoverview2";
    private final String KEY_DAILYOVERVIEW_SELECTED_MONTH = "dailyoverview3";
    private final String KEY_DAILYOVERVIEW_SELECTED_DAY = "dailyoverview4";
    private final String KEY_DAILYOVERVIEW_USED_CALORIES = "dailyoverview5";
    private final String KEY_DAILYOVERVIEW_MAX_CALORIES = "dailyoverview6";
    private final String KEY_DAILYOVERVIEW_LEFT_CALORIES = "dailyoverview7";
    private final String KEY_DAILYOVERVIEW_ENTRY_TO_COPY = "dailyoverview8";
    private final String KEY_DAILYOVERVIEW_ENTRY_TO_EDIT = "dailyoverview9";
    /* Member variables */
    private Init mActivity;
    private DatabaseEntityManager mDatabaseEntityManager;
    private ArrayList<DatabaseEntry> mDatabaseEntryList;
    private DatabaseEntry mEntryToCopy;
    private DatabaseEntry mEntryToEdit;
    private int mSelectedYear;
    private int mSelectedMonth;
    private int mSelectedDay;
    private int mUsedCalories;
    private int mMaxCalories;
    private int mLeftCalories;

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

            mUsedCalories = 0;
            mMaxCalories = Globals.CALORIES_LIMIT;
            mLeftCalories = 0;
            mEntryToCopy = null;
            mEntryToEdit = null;

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
        b.putSerializable(KEY_DAILYOVERVIEW_DATABASE_ENTRY_LIST, mDatabaseEntryList);

        b.putInt(KEY_DAILYOVERVIEW_SELECTED_YEAR, mSelectedYear);
        b.putInt(KEY_DAILYOVERVIEW_SELECTED_MONTH, mSelectedMonth);
        b.putInt(KEY_DAILYOVERVIEW_SELECTED_DAY, mSelectedDay);

        b.putInt(KEY_DAILYOVERVIEW_USED_CALORIES, mUsedCalories);
        b.putInt(KEY_DAILYOVERVIEW_LEFT_CALORIES, mLeftCalories);
        b.putInt(KEY_DAILYOVERVIEW_MAX_CALORIES, mMaxCalories);

        b.putSerializable(KEY_DAILYOVERVIEW_ENTRY_TO_COPY, mEntryToCopy);
        b.putSerializable(KEY_DAILYOVERVIEW_ENTRY_TO_EDIT, mEntryToEdit);
    }

    /**
     * Provides the possibility of retrieving the saved non-persistent data.
     *
     * @param b The bundle where the data is saved in.
     */
    private void restoreDataFromBundle(Bundle b) {
        mDatabaseEntryList = (ArrayList<DatabaseEntry>) b.getSerializable(KEY_DAILYOVERVIEW_DATABASE_ENTRY_LIST);

        mSelectedYear = b.getInt(KEY_DAILYOVERVIEW_SELECTED_YEAR);
        mSelectedMonth = b.getInt(KEY_DAILYOVERVIEW_SELECTED_MONTH);
        mSelectedDay = b.getInt(KEY_DAILYOVERVIEW_SELECTED_DAY);

        mUsedCalories = b.getInt(KEY_DAILYOVERVIEW_USED_CALORIES);
        mLeftCalories = b.getInt(KEY_DAILYOVERVIEW_LEFT_CALORIES);
        mMaxCalories = b.getInt(KEY_DAILYOVERVIEW_MAX_CALORIES);

        mEntryToCopy = (DatabaseEntry) b.getSerializable(KEY_DAILYOVERVIEW_ENTRY_TO_COPY);
        mEntryToEdit = (DatabaseEntry) b.getSerializable(KEY_DAILYOVERVIEW_ENTRY_TO_EDIT);
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

    public DatabaseEntry getEntryToEdit() {
        return mEntryToEdit;
    }

    public void setEntryToEdit(DatabaseEntry entryToEdit) {
        this.mEntryToEdit = entryToEdit;
    }

    public int getUsedCalories() {
        return mUsedCalories;
    }

    public void setUsedCalories(int amount) {
        mUsedCalories = amount;
    }

    public int getMaxCalories() {
        return mMaxCalories;
    }

    public void setMaxCalories(int amount) {
        mMaxCalories = amount;
        Globals.CALORIES_LIMIT = amount;
    }

    public int getLeftCalories() {
        return mLeftCalories;
    }

    public void setLeftCalories(int amount) {
        mLeftCalories = amount;
    }
}