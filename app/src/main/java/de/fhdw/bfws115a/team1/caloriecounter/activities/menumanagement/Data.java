package de.fhdw.bfws115a.team1.caloriecounter.activities.menumanagement;

import android.os.Bundle;

public class Data {

    /* Data variables */
    private Init mActivity;
    private String mSelectMenuName;
    private int mSelectPortionSize;
    private String mAddedGroceries;

    /* Default values */
    private final String DEFAULT_SELECTMENUNAME = "";
    private final int DEFAULT_SELECTPORTIONSIZE = 0;
    private final String DEFAULT_ADDEDGROCERIES = "";

    /* Keys */
    private final String KEY_SELECTMENUNAME = "K1";
    private final String KEY_SELECTPORTIONSIZE = "K2";
    private final String KEY_ADDEDGROCERIES = "K3";


    public Data(Bundle savedInstanceState, Init activity) {
        mActivity = activity;

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
