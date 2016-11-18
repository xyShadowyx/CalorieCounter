package de.fhdw.bfws115a.team1.caloriecounter.activities.quantityunitmanagement;

import android.os.Bundle;

/**
 * Created by Florian on 08.11.2016.
 */
public class Data {

    /* Data variables */
    private Init mActivity;

    private String mNewQuantityunitName;

    /* Default values */
    private final String DEFAULT_NEWQUANTITYUNITNAME = "";

    /* Keys */
    private final String KEY_NEWQUANTITYUNITNAME = "K1";

    public Data(Bundle savedInstanceState, Init activity) {
        mActivity = activity;

        if (savedInstanceState == null) {
            mNewQuantityunitName = DEFAULT_NEWQUANTITYUNITNAME;
        } else {
            restoreDataFromBundle(savedInstanceState);
        }
    }

    public void saveDataInBundle(Bundle b) {
        b.putString(KEY_NEWQUANTITYUNITNAME, mNewQuantityunitName);
    }

    private void restoreDataFromBundle(Bundle b) {
        mNewQuantityunitName = b.getString(KEY_NEWQUANTITYUNITNAME);
    }

    /* Getter methods */
    public Init getActivity() {
        return mActivity;
    }

    public String getNewQuantityunitName() {
        return mNewQuantityunitName;
    }

    /* Setter methods */
    public void setNewQuantityunitName(String mNewQuantityunitName) {
        this.mNewQuantityunitName = mNewQuantityunitName;
    }
}
