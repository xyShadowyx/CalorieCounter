package de.fhdw.bfws115a.team1.caloriecounter.activities.quantityunitmanagement;

import android.os.Bundle;

/**
 * Created by Florian on 08.11.2016.
 */
public class Data {

    private Init mActivity;

    private String mNewQuantityunitName;

    private final String DEFAULTNEWQUANTITYUNITNAME = "";

    private final String KEYNEWQUANTITYUNITNAME = "K1";

    public Data(Bundle savedInstanceState, Init activity) {
        mActivity = activity;

        if (savedInstanceState == null) {
            mNewQuantityunitName = DEFAULTNEWQUANTITYUNITNAME;
        } else {
            restoreDataFromBundle(savedInstanceState);
        }
    }


    public void saveDataInBundle(Bundle b) {
        b.putString(KEYNEWQUANTITYUNITNAME, mNewQuantityunitName);
    }

    private void restoreDataFromBundle(Bundle b) {
        mNewQuantityunitName = b.getString(KEYNEWQUANTITYUNITNAME);
    }
    //setter

    public void setNewQuantityunitName(String mNewQuantityunitName) {
        this.mNewQuantityunitName = mNewQuantityunitName;
    }
    //getter


}
