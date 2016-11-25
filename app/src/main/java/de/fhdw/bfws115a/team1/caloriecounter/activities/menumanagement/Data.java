package de.fhdw.bfws115a.team1.caloriecounter.activities.menumanagement;

import android.os.Bundle;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseEntityManager;
import de.fhdw.bfws115a.team1.caloriecounter.entities.FixGrocery;

import java.util.ArrayList;

public class Data {

    /* Data variables */
    private Init mActivity;
    private String mSelectMenuName;
    private int mSelectPortionSize;
    private String mAddedGroceries;
    private ArrayList<FixGrocery> mMenuFixGroceries;

    /* Database Entity Manager */
    private DatabaseEntityManager mDatabaseEntityManager;

    /* Default values */
    private final String DEFAULT_SELECTMENUNAME = "";
    private final int DEFAULT_SELECTPORTIONSIZE = 0;
    private final String DEFAULT_ADDEDGROCERIES = "";

    /* Keys */
    private final String KEY_SELECTMENUNAME = "menumanagement1";
    private final String KEY_SELECTPORTIONSIZE = "menumanagement2";
    private final String KEY_ADDEDGROCERIES = "menumanagement3";

    public Data(Bundle savedInstanceState, Init activity) {
        mActivity = activity;
        mDatabaseEntityManager = new DatabaseEntityManager(activity.getApplicationContext());

        if (savedInstanceState == null) {
            mSelectMenuName = DEFAULT_SELECTMENUNAME;
            mSelectPortionSize = DEFAULT_SELECTPORTIONSIZE;
            mAddedGroceries = DEFAULT_ADDEDGROCERIES;
        } else {
            restoreDataFromBundle(savedInstanceState);
        }
    }

    public void saveDataInBundle(Bundle b) {
        b.putString(KEY_SELECTMENUNAME, mSelectMenuName);
        b.putInt(KEY_SELECTPORTIONSIZE, mSelectPortionSize);
        b.putString(KEY_ADDEDGROCERIES, mAddedGroceries);
    }

    private void restoreDataFromBundle(Bundle b) {
        mSelectMenuName = b.getString(KEY_SELECTMENUNAME);
        mSelectPortionSize = b.getInt(KEY_SELECTPORTIONSIZE);
        mAddedGroceries = b.getString(KEY_ADDEDGROCERIES);
    }

    /* Getter methods */
    public Init getActivity() {
        return mActivity;
    }

    public String getSelectMenuName() {
        return mSelectMenuName;
    }

    public int getSelectPortionSize() {
        return mSelectPortionSize;
    }

    public String getAddedGroceries() {
        return mAddedGroceries;
    }

    public ArrayList<FixGrocery> getmMenuFixGroceries() {
        return mMenuFixGroceries;
    }

    public DatabaseEntityManager getDatabaseEntityManager() {
        return mDatabaseEntityManager;
    }

    /* Setter methods */
    public void setActivity(Init mActivity) {
        this.mActivity = mActivity;
    }

    public void setSelectMenuName(String mSelectMenuName) {
        this.mSelectMenuName = mSelectMenuName;
    }

    public void setSelectPortionSize(int mSelectPortionSize) {
        this.mSelectPortionSize = mSelectPortionSize;
    }

    public void setAddedGroceries(String mAddedGroceries) {
        this.mAddedGroceries = mAddedGroceries;
    }
}
