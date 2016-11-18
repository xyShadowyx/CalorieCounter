package de.fhdw.bfws115a.team1.caloriecounter.activities.selectamount;

import android.os.Bundle;

public class Data {

    /* Data variables */
    private Init mActivity;
    private String mPickedGrocery;
    private int mSelectAmount;
    private String mSpinnerStatus;

    /* Default values */
    private final String DEFAULT_PICKEDGROCERY = "Error";
    private final int DEFAULT_SELECTAMOUNT = 0;
    private final String DEFAULT_SPINNERSTATUS = "Einheit";

    /* Keys */
    private final String KEY_PICKEDGROCERY = "K1";
    private final String KEY_SELECTAMOUNT = "K2";
    private final String KEY_SPINNERSTATUS = "K3";


    public Data(Bundle savedInstanceState, Init activity) {
        mActivity = activity;

        if (savedInstanceState == null) {
            mPickedGrocery = DEFAULT_PICKEDGROCERY;
            mSelectAmount = DEFAULT_SELECTAMOUNT;
            mSpinnerStatus = DEFAULT_SPINNERSTATUS;
        } else {
            restoreDataFromBundle(savedInstanceState);
        }
    }

    public void saveDataInBundle(Bundle b) {
        b.putString(KEY_PICKEDGROCERY, mPickedGrocery);
        b.putInt(KEY_SELECTAMOUNT, mSelectAmount);
        b.putString(KEY_SPINNERSTATUS, mSpinnerStatus);
    }

    private void restoreDataFromBundle(Bundle b) {
        mPickedGrocery = b.getString(KEY_PICKEDGROCERY);
        mSelectAmount = b.getInt(KEY_SELECTAMOUNT);
        mSpinnerStatus = b.getString(KEY_SPINNERSTATUS);
    }


    /* Getter methods */
    public Init getActivity() {
        return mActivity;
    }

    public String getPickedGrocery() {
        return mPickedGrocery;
    }

    public int getSelectAmount() {
        return mSelectAmount;
    }

    public String getDropDownStatus() {
        return mSpinnerStatus;
    }

    /* Setter methods */
    public void setActivity(Init mActivity) {
        this.mActivity = mActivity;
    }

    public void setPickedGrocery(String mPickedGrocery) {
        this.mPickedGrocery = mPickedGrocery;
    }

    public void setSelectAmount(int mSelectAmount) {
        this.mSelectAmount = mSelectAmount;
    }

    public void setSpinnerStatus(String mSpinnerStatus) {
        this.mSpinnerStatus = this.mSpinnerStatus;
    }
}
