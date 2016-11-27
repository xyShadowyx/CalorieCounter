package de.fhdw.bfws115a.team1.caloriecounter.activities.selectamount;

import android.os.Bundle;
import de.fhdw.bfws115a.team1.caloriecounter.R;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseEntityManager;

public class Data {

    /* Data variables */
    private Init mActivity;
    private String mPickedGrocery;
    private int mSelectedAmount;
    private String mSpinnerStatus;

    /* Default values */
    private final int DEFAULT_SELECTEDAMOUNT = 0;

    /* Keys */
    private final String KEY_PICKEDGROCERY = "selectamount1";
    private final String KEY_SELECTAMOUNT = "selectamount2";
    private final String KEY_SPINNERSTATUS = "selectamount3";

    public Data(Bundle savedInstanceState, Init activity) {
        mActivity = activity;

        if (savedInstanceState == null) {
            mPickedGrocery = mActivity.getResources().getString(R.string.selectamount_default_pickedgrocery);
            mSelectedAmount = DEFAULT_SELECTEDAMOUNT;
            mSpinnerStatus = mActivity.getResources().getString(R.string.selectamount_default_spinnerstatus);
        } else {
            restoreDataFromBundle(savedInstanceState);
        }
    }

    public void saveDataInBundle(Bundle b) {
        b.putString(KEY_PICKEDGROCERY, mPickedGrocery);
        b.putInt(KEY_SELECTAMOUNT, mSelectedAmount);
        b.putString(KEY_SPINNERSTATUS, mSpinnerStatus);
    }

    private void restoreDataFromBundle(Bundle b) {
        mPickedGrocery = b.getString(KEY_PICKEDGROCERY);
        mSelectedAmount = b.getInt(KEY_SELECTAMOUNT);
        mSpinnerStatus = b.getString(KEY_SPINNERSTATUS);
    }

    /* Getter methods */
    public Init getActivity() {
        return mActivity;
    }

    public String getPickedGrocery() {
        return mPickedGrocery;
    }

    public int getSelectedAmount() {
        return mSelectedAmount;
    }

    public String getSpinnerStatus() {
        return mSpinnerStatus;
    }

    /* Setter methods */
    public void setActivity(Init mActivity) {
        this.mActivity = mActivity;
    }

    public void setPickedGrocery(String mPickedGrocery) {
        this.mPickedGrocery = mPickedGrocery;
    }

    public void setSelectedAmount(int mSelectedAmount) {
        this.mSelectedAmount = mSelectedAmount;
    }

    public void setSpinnerStatus(String mSpinnerStatus) {
        this.mSpinnerStatus = this.mSpinnerStatus;
    }

    /* Other methods */
}