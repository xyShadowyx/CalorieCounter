package de.fhdw.bfws115a.team1.caloriecounter.activities.grocerymanagement;

import android.content.Intent;
import android.os.Bundle;
import de.fhdw.bfws115a.team1.caloriecounter.R;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseEntityManager;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseGrocery;
import de.fhdw.bfws115a.team1.caloriecounter.entities.GroceryUnit;
import de.fhdw.bfws115a.team1.caloriecounter.entities.Unit;

import java.util.ArrayList;

/**
 * Created by Florian on 08.11.2016.
 */
public class Data {

    /* Data variables */
    private Init mActivity;
    private String mGroceryName;
    private int mGroceryCalories;

    private String mNewUnitName;
    private double mNewUnitAmount;

    private ArrayList<String> mUnitList;
    private ArrayList<GroceryUnit> mGroceryUnits;

    private DatabaseGrocery mInputGrocery;

    /* Database Entity Manager */
    private DatabaseEntityManager mDatabaseEntityManager;

    /* Default values */
    private final String DEFAULT_GROCERYNAME = "";
    private final int DEFAULT_GROCERYCALORIES = 0;
    private final String DEFAULT_NEWUNITNAME = "";
    private final double DEFAULT_NEWUNITAMOUNT = 0;
    private final int DEFAULT_GROCERYUNITS = 0;

    /* Keys */
    private final String KEY_GROCERYNAME = "grocerymanagement1";
    private final String KEY_GROCERYCALORIES = "grocerymanagement2";
    private final String KEY_NEWUNITAMOUNT = "grocerymanagement3";
    private final String KEY_GROCERYUNITS = "grocerymanagement4";

    public Data(Bundle savedInstanceState, Init activity) {
        mActivity = activity;
        Intent intent = mActivity.getIntent();

        mDatabaseEntityManager = new DatabaseEntityManager(mActivity.getApplicationContext());
        mGroceryUnits = new ArrayList<GroceryUnit>();

        mUnitList = new ArrayList<String>();
        for (Unit u : mDatabaseEntityManager.getAllUnits()) {
            mUnitList.add(u.getName());
        }
        if (savedInstanceState == null) {
            mInputGrocery = (DatabaseGrocery) intent.getSerializableExtra("databaseGrocery");
            if (mInputGrocery != null) {
                mGroceryName = mInputGrocery.getName();
                mGroceryCalories = mInputGrocery.getKcal();
                mGroceryCalories = mInputGrocery.getKcal();
                for (GroceryUnit gu : mInputGrocery.getGroceryUnits()) {
                    mGroceryUnits.add(gu);
                }
            } else {
                mGroceryName = DEFAULT_GROCERYNAME;
                mGroceryCalories = DEFAULT_GROCERYCALORIES;
            }
            mNewUnitName = mActivity.getResources().getString(R.string.selectamount_default_spinnerstatus);
            mNewUnitAmount = DEFAULT_NEWUNITAMOUNT;
        } else {
            restoreDataFromBundle(savedInstanceState);
        }
    }

    public void saveDataInBundle(Bundle b) {
        b.putString(KEY_GROCERYNAME, mGroceryName);
        b.putDouble(KEY_GROCERYCALORIES, mGroceryCalories);
        b.putString(KEY_NEWUNITAMOUNT, mNewUnitName);
        b.putDouble(KEY_GROCERYUNITS, mNewUnitAmount);
    }

    private void restoreDataFromBundle(Bundle b) {
        mGroceryName = b.getString(KEY_GROCERYNAME);
        mGroceryCalories = b.getInt(KEY_GROCERYCALORIES);
        mNewUnitName = b.getString(KEY_NEWUNITAMOUNT);
        mNewUnitAmount = b.getDouble(KEY_GROCERYUNITS);
    }

    /* Getter methods */
    public Init getActivity() {
        return mActivity;
    }

    public String getGroceryName() {
        return mGroceryName;
    }

    public int getGroceryCalories() {
        return mGroceryCalories;
    }

    public String getNewUnitName() {
        return mNewUnitName;
    }

    public double getNewUnitAmount() {
        return mNewUnitAmount;
    }

    public DatabaseEntityManager getDatabaseEntityManager() {
        return mDatabaseEntityManager;
    }

    public DatabaseGrocery getInputGrocery() {
        return mInputGrocery;
    }

    public ArrayList<String> getUnitList() {
        return mUnitList;
    }

    public ArrayList<GroceryUnit> getGroceryUnits() {
        return mGroceryUnits;
    }

    /* Setter methods */
    public void setGroceryName(String mGroceryName) {
        this.mGroceryName = mGroceryName;
    }

    public void setGroceryCalories(int mGroceryCalories) {
        this.mGroceryCalories = mGroceryCalories;
    }

    public void setNewUnitAmount(double mNewUnitAmount) {
        this.mNewUnitAmount = mNewUnitAmount;
    }

    public void setNewUnitName(String mNewUnitName) {
        this.mNewUnitName = mNewUnitName;
    }


}
