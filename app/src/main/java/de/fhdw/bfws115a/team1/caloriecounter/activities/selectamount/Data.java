package de.fhdw.bfws115a.team1.caloriecounter.activities.selectamount;

import android.content.Intent;
import android.os.Bundle;
import de.fhdw.bfws115a.team1.caloriecounter.R;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseEntityManager;
import de.fhdw.bfws115a.team1.caloriecounter.entities.GroceriesEntity;
import de.fhdw.bfws115a.team1.caloriecounter.entities.Grocery;
import de.fhdw.bfws115a.team1.caloriecounter.entities.GroceryUnit;
import de.fhdw.bfws115a.team1.caloriecounter.entities.Menu;

import java.util.ArrayList;

public class Data {

    /* Data variables */
    private Init mActivity;
    private String mPickedGrocery;
    private double mSelectedAmount;
    private String mSpinnerStatus;
    private ArrayList<String> mUnitList;

    /* Default values */
    private final double DEFAULT_SELECTEDAMOUNT = 0;

    /* Keys */
    private final String KEY_PICKEDGROCERY = "selectamount1";
    private final String KEY_SELECTAMOUNT = "selectamount2";
    private final String KEY_SPINNERSTATUS = "selectamount3";

    public Data(Bundle savedInstanceState, Init activity) {
        mActivity = activity;

        if (savedInstanceState == null) {
            Intent intent = mActivity.getIntent();
            mPickedGrocery = mActivity.getResources().getString(R.string.selectamount_default_pickedgrocery);
            mSelectedAmount = DEFAULT_SELECTEDAMOUNT;
            mSpinnerStatus = mActivity.getResources().getString(R.string.selectamount_default_spinnerstatus);
            mUnitList = new ArrayList<String>();

            GroceriesEntity groceriesEntity = (GroceriesEntity) intent.getSerializableExtra("groceriesEntity");
            if (groceriesEntity instanceof Grocery) {
                Grocery grocery = (Grocery) groceriesEntity;
                mPickedGrocery = grocery.getName();
                for (GroceryUnit gu : grocery.getGroceryUnits()) {
                    mUnitList.add(gu.getUnit().getName());
                }
            }
            if (groceriesEntity instanceof Menu) {
                Menu menu = (Menu) groceriesEntity;
                mPickedGrocery = menu.getName();

                mUnitList.add("Portion");
            }
        } else {
            restoreDataFromBundle(savedInstanceState);
        }
    }

    public void saveDataInBundle(Bundle b) {
        b.putString(KEY_PICKEDGROCERY, mPickedGrocery);
        b.putDouble(KEY_SELECTAMOUNT, mSelectedAmount);
        b.putString(KEY_SPINNERSTATUS, mSpinnerStatus);
    }

    private void restoreDataFromBundle(Bundle b) {
        mPickedGrocery = b.getString(KEY_PICKEDGROCERY);
        mSelectedAmount = b.getDouble(KEY_SELECTAMOUNT);
        mSpinnerStatus = b.getString(KEY_SPINNERSTATUS);
    }

    /* Getter methods */
    public Init getActivity() {
        return mActivity;
    }

    public String getPickedGrocery() {
        return mPickedGrocery;
    }

    public double getSelectedAmount() {
        return mSelectedAmount;
    }

    public String getSpinnerStatus() {
        return mSpinnerStatus;
    }

    public ArrayList<String> getUnitList() {
        return mUnitList;
    }

    /* Setter methods */
    public void setActivity(Init mActivity) {
        this.mActivity = mActivity;
    }

    public void setPickedGrocery(String mPickedGrocery) {
        this.mPickedGrocery = mPickedGrocery;
    }

    public void setSelectedAmount(double mSelectedAmount) {
        this.mSelectedAmount = mSelectedAmount;
    }

    public void setSpinnerStatus(String mSpinnerStatus) {
        this.mSpinnerStatus = this.mSpinnerStatus;
    }

    /* Other methods */
}