package de.fhdw.bfws115a.team1.caloriecounter.activities.grocerymanagement;

import android.os.Bundle;

/**
 * Created by Florian on 08.11.2016.
 */
public class Data {

    private de.fhdw.bfws115a.team1.caloriecounter.activities.quantityunitmanagement.Init mActivity;

    private String mGrocerieName;
    private String mNewQuantity;
    private String mKiloCalories;


    private final String DEFAULTGROCERIENAME = "";
    private final String DEFAULTNEWQUANTITY = "";
    private final String DEFAULTKILOCALORIES = "";

    private final String KEYGROCERIENAME  = "K1";
    private final String KEYNEWQUANTITY = "K2";
    private final String KEYKILOCALORIES = "K3";

    public Data(Bundle savedInstanceState, de.fhdw.bfws115a.team1.caloriecounter.activities.quantityunitmanagement.Init activity) {
        mActivity = activity;

        if (savedInstanceState == null) {
            mGrocerieName = DEFAULTGROCERIENAME;
            mNewQuantity = DEFAULTNEWQUANTITY;
            mKiloCalories = DEFAULTKILOCALORIES;

        } else {
            restoreDataFromBundle(savedInstanceState);
        }
    }


    public void saveDataInBundle(Bundle b) {
        b.putString(KEYGROCERIENAME, mGrocerieName);
        b.putString(KEYNEWQUANTITY, mNewQuantity);
        b.putString(KEYKILOCALORIES, mKiloCalories);
    }

    private void restoreDataFromBundle(Bundle b) {
        mGrocerieName = b.getString(KEYGROCERIENAME);
        mNewQuantity = b.getString(KEYNEWQUANTITY);
        mKiloCalories = b.getString(KEYKILOCALORIES);
    }
    //setter


    public void setGrocerieName(String mGrocerieName) {
        this.mGrocerieName = mGrocerieName;
    }

    public void setNewQuantity(String mNewQuantity) {
        this.mNewQuantity = mNewQuantity;
    }

    public void setKiloCalories(String mKiloCalories) {
        this.mKiloCalories = mKiloCalories;
    }
    //getter


}
