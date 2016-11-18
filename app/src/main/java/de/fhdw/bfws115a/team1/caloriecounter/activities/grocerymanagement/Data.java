package de.fhdw.bfws115a.team1.caloriecounter.activities.grocerymanagement;

import android.os.Bundle;

/**
 * Created by Florian on 08.11.2016.
 */
public class Data {

    private Init mActivity;


    private String mGroceryName;
    private int mSelectedAmount;
    private int mKiloCalories;


    private final String DEFAULT_GROCERYNAME = "";
    private final int DEFAULT_SELECTEDAMOUNT = 0;
    private final int DEFAUL_TKILOCALORIES = 0;

    private final String KEY_GROCERYNAME = "grocerymanagement1";
    private final String KEY_NEWQUANTITY = "grocerymanagement2";
    private final String KEY_KILOCALORIES = "grocerymanagement3";

    public Data(Bundle savedInstanceState, Init activity) {
        mActivity = activity;

        if (savedInstanceState == null) {
            mGroceryName = DEFAULT_GROCERYNAME;
            mSelectedAmount = DEFAULT_SELECTEDAMOUNT;
            mKiloCalories = DEFAUL_TKILOCALORIES;

        } else {
            restoreDataFromBundle(savedInstanceState);
        }
    }

    public void saveDataInBundle(Bundle b) {
        b.putString(KEY_GROCERYNAME, mGroceryName);
        b.putInt(KEY_NEWQUANTITY, mSelectedAmount);
        b.putInt(KEY_KILOCALORIES, mKiloCalories);
    }

    private void restoreDataFromBundle(Bundle b) {
        mGroceryName = b.getString(KEY_GROCERYNAME);
        mSelectedAmount = b.getInt(KEY_NEWQUANTITY);
        mKiloCalories = b.getInt(KEY_KILOCALORIES);
    }

    /* Getter methods */
    public Init getActivity() {
        return mActivity;
    }

    public String getGrocerieName() {
        return mGroceryName;
    }

    public int getSelectedAmount() {
        return mSelectedAmount;
    }

    public int getKiloCalories() {
        return mKiloCalories;
    }

    /* Setter methods */
    public void setGroceryName(String mGroceryName) {
        this.mGroceryName = mGroceryName;
    }

    public void setKiloCalories(int mKiloCalories) {
        this.mKiloCalories = mKiloCalories;
    }
}
