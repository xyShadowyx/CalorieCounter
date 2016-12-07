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
    private ArrayList<GroceriesEntity> mGroceriesEntityList;
    private DatabaseEntityManager mDatabaseEntityManager;

    /* Default values */
    private final boolean DEFAULT_GROCERIESENTITYLIST = false;

    /* Keys */
    private final String KEY_GROCERIES_ENTITY_LIST = "groceriessearchoverview1";


    public Data(Bundle savedInstanceState, Init activity) {
        mActivity = activity;
        mDatabaseEntityManager = new DatabaseEntityManager(mActivity.getApplicationContext());

        if (savedInstanceState == null) {
            mGroceriesEntityList = new ArrayList<GroceriesEntity>();

            mGroceriesEntityList.addAll(mDatabaseEntityManager.getAllGroceries());
            mGroceriesEntityList.addAll(mDatabaseEntityManager.getAllMenus());
        } else {
            restoreDataFromBundle(savedInstanceState);
        }
    }

    public void saveDataInBundle(Bundle b) {
        b.putSerializable(KEY_GROCERIES_ENTITY_LIST, mGroceriesEntityList);
    }

    private void restoreDataFromBundle(Bundle b) {
        mGroceriesEntityList = (ArrayList<GroceriesEntity>) b.getSerializable(KEY_GROCERIES_ENTITY_LIST);
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
