package de.fhdw.bfws115a.team1.caloriecounter.activities.grocerymanagement;

import android.os.Bundle;
import de.fhdw.bfws115a.team1.caloriecounter.R;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseEntityManager;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseHelper;

/**
 * Created by Florian on 08.11.2016.
 */
public class Data {

    /* Data variables */
    private Init mActivity;
    private String mGroceryName;
    private int mSelectedAmount;
    private String mSpinnerStatus;
    private int mKiloCalories;

    /* Database Entity Manager */
    private DatabaseEntityManager mDatabaseEntityManager;

    /* Default values */
    private final String DEFAULT_GROCERYNAME = "";
    private final int DEFAULT_SELECTEDAMOUNT = 0;
    private final int DEFAULt_KILOCALORIES = 0;

    /* Keys */
    private final String KEY_GROCERYNAME = "grocerymanagement1";
    private final String KEY_NEWQUANTITY = "grocerymanagement2";
    private final String KEY_KILOCALORIES = "grocerymanagement3";
    private final String KEY_SPINNERSTATUS = "grocerymanagement4";

    public Data(Bundle savedInstanceState, Init activity) {
        mActivity = activity;
        mDatabaseEntityManager = new DatabaseEntityManager(new DatabaseHelper(mActivity.getApplicationContext()));

        if (savedInstanceState == null) {
            mGroceryName = DEFAULT_GROCERYNAME;
            mSelectedAmount = DEFAULT_SELECTEDAMOUNT;
            mKiloCalories = DEFAULt_KILOCALORIES;
            mSpinnerStatus = mActivity.getResources().getString(R.string.selectamount_default_spinnerstatus);
        } else {
            restoreDataFromBundle(savedInstanceState);
        }
    }

    public void saveDataInBundle(Bundle b) {
        b.putString(KEY_GROCERYNAME, mGroceryName);
        b.putInt(KEY_NEWQUANTITY, mSelectedAmount);
        b.putInt(KEY_KILOCALORIES, mKiloCalories);
        b.putString(KEY_SPINNERSTATUS, mSpinnerStatus);
    }

    private void restoreDataFromBundle(Bundle b) {
        mGroceryName = b.getString(KEY_GROCERYNAME);
        mSelectedAmount = b.getInt(KEY_NEWQUANTITY);
        mKiloCalories = b.getInt(KEY_KILOCALORIES);
        mSpinnerStatus = b.getString(KEY_SPINNERSTATUS);
    }

    /* Getter methods */
    public Init getActivity() {
        return mActivity;
    }

    public String getGroceryName() {
        return mGroceryName;
    }

    public int getSelectedAmount() {
        return mSelectedAmount;
    }

    public int getKiloCalories() {
        return mKiloCalories;
    }

    public String getSpinnerStatus() {
        return mSpinnerStatus;
    }

    public DatabaseEntityManager getDatabaseEntityManager() {
        return mDatabaseEntityManager;
    }

    /* Setter methods */
    public void setGroceryName(String mGroceryName) {
        this.mGroceryName = mGroceryName;
    }

    public void setKiloCalories(int mKiloCalories) {
        this.mKiloCalories = mKiloCalories;
    }
}
