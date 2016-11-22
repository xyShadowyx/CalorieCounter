package de.fhdw.bfws115a.team1.caloriecounter.activities.databasetest;

import android.os.Bundle;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseEntityManager;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseHelper;

public class Data {
    private Init mActivity;
    private DatabaseEntityManager mDatabaseEntityManager;

    /* Data variables */
    private String mDummyString;
    private int mDummyInt;

    /* Default values */
    private final String DEFAULTDUMMYSTRING = "Dummy";
    private final int DEFAULTDUMMYINT = 937;

    /* Keys */
    private final String KEYDUMMYSTRING = "databasetest1";
    private final String KEYDUMMYINT = "databasetest2";

    public Data(Bundle savedInstanceState, Init activity) {
        mActivity = activity;
        mDatabaseEntityManager = new DatabaseEntityManager(new DatabaseHelper(mActivity.getApplicationContext()));

        if (savedInstanceState == null) {
            mDummyString = DEFAULTDUMMYSTRING;
            mDummyInt = DEFAULTDUMMYINT;
        } else {
            restoreDataFromBundle(savedInstanceState);
        }
    }

    public void saveDataInBundle(Bundle b) {
        b.putString(KEYDUMMYSTRING, mDummyString);
        b.putInt(KEYDUMMYINT, DEFAULTDUMMYINT);
    }

    private void restoreDataFromBundle(Bundle b) {
        mDummyString = b.getString(KEYDUMMYSTRING);
        mDummyInt = b.getInt(KEYDUMMYINT);
    }

    /* Getter methods */
    public Init getActivity() {
        return mActivity;
    }

    public DatabaseEntityManager getDatabaseEntityManager() {
        return mDatabaseEntityManager;
    }
    /* Setter methods */
}
