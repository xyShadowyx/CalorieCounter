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
 * @author Niklas Lammers.
 */
public class Data {

    /* Member variables */
    private Init mActivity;
    private String mGroceryName;
    private int mGroceryCalories;
    private String mNewUnitName;
    private double mNewUnitAmount;
    private ArrayList<String> mUnitList;
    private ArrayList<GroceryUnit> mGroceryUnits;
    private DatabaseGrocery mInputGrocery;
    private DatabaseEntityManager mDatabaseEntityManager;

    /* Default values */
    private final String DEFAULT_GROCERYNAME = "";
    private final int DEFAULT_GROCERYCALORIES = 0;
    private final String DEFAULT_NEWUNITNAME = "";
    private final double DEFAULT_NEWUNITAMOUNT = 0;

    /* Keys */
    private final String KEY_GROCERY_NAME = "grocerymanagement1";
    private final String KEY_GROCERY_CALORIES = "grocerymanagement2";
    private final String KEY_NEW_UNIT_NAME = "grocerymanagement3";
    private final String KEY_NEW_UNIT_AMOUNT = "grocerymanagement4";
    private final String KEY_UNIT_LIST = "grocerymanagement5";
    private final String KEY_GROCERY_UNITS = "grocerymanagement6";
    private final String KEY_INPUT_GROCERY = "grocerymanagement7";

    /**
     * Method which gets the current layout attributes and put them into an 'Intent' object.
     * The reasons are possible saving and retrieving options of the data stored.
     *
     * @param savedInstanceState A bundle where data can be stored.
     * @param activity           The current initialised activity.
     */
    public Data(Bundle savedInstanceState, Init activity) {
        mActivity = activity;
        Intent intent;
        intent = mActivity.getIntent();
        mDatabaseEntityManager = new DatabaseEntityManager(mActivity.getApplicationContext());
        mGroceryUnits = new ArrayList<GroceryUnit>();
        mUnitList = new ArrayList<String>();
        mUnitList.add(mActivity.getResources().getString(R.string.selectamount_default_spinnerstatus));
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
                    mUnitList.remove(gu.getUnit().getName());
                }
            } else {
                mGroceryName = DEFAULT_GROCERYNAME;
                mGroceryCalories = DEFAULT_GROCERYCALORIES;
            }
            mNewUnitName = DEFAULT_NEWUNITNAME;
            mNewUnitAmount = DEFAULT_NEWUNITAMOUNT;

        } else {
            restoreDataFromBundle(savedInstanceState);
        }
    }

    /**
     * Provides the possibility of saving the non-persistent data in a bundle.
     *
     * @param b The bundle where the data will be saved.
     */
    public void saveDataInBundle(Bundle b) {
        b.putString(KEY_GROCERY_NAME, mGroceryName);
        b.putDouble(KEY_GROCERY_CALORIES, mGroceryCalories);
        b.putString(KEY_NEW_UNIT_NAME, mNewUnitName);
        b.putDouble(KEY_NEW_UNIT_AMOUNT, mNewUnitAmount);
        b.putSerializable(KEY_UNIT_LIST, mUnitList);
        b.putSerializable(KEY_GROCERY_UNITS, mGroceryUnits);
        b.putSerializable(KEY_INPUT_GROCERY, mInputGrocery);
    }

    /**
     * Provides the possibility of retrieving the saved non-persistent data.
     *
     * @param b The bundle where the data is saved in.
     */
    private void restoreDataFromBundle(Bundle b) {
        mGroceryName = b.getString(KEY_GROCERY_NAME);
        mGroceryCalories = b.getInt(KEY_GROCERY_CALORIES);
        mNewUnitName = b.getString(KEY_NEW_UNIT_NAME);
        mNewUnitAmount = b.getDouble(KEY_NEW_UNIT_AMOUNT);
        mUnitList = (ArrayList<String>) b.getSerializable(KEY_UNIT_LIST);
        mGroceryUnits = (ArrayList<GroceryUnit>)b.getSerializable(KEY_GROCERY_UNITS);
        mInputGrocery = (DatabaseGrocery) b.getSerializable(KEY_INPUT_GROCERY);
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