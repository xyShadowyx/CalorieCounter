package de.fhdw.bfws115a.team1.caloriecounter.activities.groceriessearchoverview;

import android.content.Intent;
import android.os.Bundle;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseEntityManager;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseGrocery;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseHelper;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseUnit;
import de.fhdw.bfws115a.team1.caloriecounter.entities.*;

import java.util.ArrayList;

public class Data {
    private Init mActivity;

    /* Data variables */
    private String mDummyString;
    private int mDummyInt;
    private ArrayList<GroceriesEntity> mGroceriesEntityList;
    private DatabaseEntityManager mDatabaseEntityManager;

    private boolean mIsWaitingForResult;

    /* Default values */
    private final boolean DEFAULTISWAITINGFORRESULT = false;

    /* Keys */
    private final String KEYISWAITINGFORRESULT = "groceriessearchoverview1";


    public Data(Bundle savedInstanceState, Init activity) {
        mActivity = activity;

        mDatabaseEntityManager = new DatabaseEntityManager(mActivity.getApplicationContext());
        mGroceriesEntityList = new ArrayList<GroceriesEntity>();

        mGroceriesEntityList.addAll(mDatabaseEntityManager.getAllGroceries());
        mGroceriesEntityList.addAll(mDatabaseEntityManager.getAllMenus());

        if (savedInstanceState == null) {
            Intent intent = mActivity.getIntent();
            mIsWaitingForResult = intent.getBooleanExtra("waiting_for_result", DEFAULTISWAITINGFORRESULT);
        } else {
            restoreDataFromBundle(savedInstanceState);
        }
    }

    public void saveDataInBundle(Bundle b) {
        b.putBoolean(KEYISWAITINGFORRESULT, mIsWaitingForResult);
    }

    private void restoreDataFromBundle(Bundle b) {
        mIsWaitingForResult = b.getBoolean(KEYISWAITINGFORRESULT);
    }

    public boolean isWaitingForResult() {
        return mIsWaitingForResult;
    }

    /* Getter methods */
    public Init getActivity() {
        return mActivity;
    }

    public ArrayList<GroceriesEntity> getGroceriesEntityList() {
        return mGroceriesEntityList;
    }

    /* Setter methods */
}
