package de.fhdw.bfws115a.team1.caloriecounter.activities.quantityunitmanagement;

import android.os.Bundle;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseEntityManager;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseUnit;
import de.fhdw.bfws115a.team1.caloriecounter.entities.Unit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Data {

    /* Member variables */
    private Init mActivity;
    private String mNewQuantityUnitName;
    private ArrayList<DatabaseUnit> mQuantityUnits;
    private DatabaseEntityManager mDatabaseEntityManager;

    /* Default values */
    private final String DEFAULT_NEWQUANTITYUNITNAME = "";

    /* Keys */
    private final String KEY_NEW_QUANTITY_UNIT_NAME = "quantityunitmanagement1";
    private final String KEY_QUANTITY_UNITS = "quantityunitmanagement2";

    /**
     * Method which gets the current layout attributes and put them into an 'Intent' object.
     * The reasons are possible saving and retrieving options of the data stored.
     *
     * @param savedInstanceState A bundle where data can be stored.
     * @param activity           The current initialised activity.
     */
    public Data(Bundle savedInstanceState, Init activity) {
        mActivity = activity;
        List<DatabaseUnit> allDbUnits;

        mDatabaseEntityManager = new DatabaseEntityManager(mActivity.getApplicationContext());
        allDbUnits = mDatabaseEntityManager.getAllUnits();
        mQuantityUnits = new ArrayList<DatabaseUnit>();
        for (DatabaseUnit dbu : allDbUnits) {
            mQuantityUnits.add(dbu);
        }
        Collections.sort(mQuantityUnits, new UnitComparetor());

        if (savedInstanceState == null) {
            mNewQuantityUnitName = DEFAULT_NEWQUANTITYUNITNAME;
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
        b.putString(KEY_NEW_QUANTITY_UNIT_NAME, mNewQuantityUnitName);
        b.putSerializable(KEY_QUANTITY_UNITS, mQuantityUnits);
    }

    /**
     * Provides the possibility of retrieving the saved non-persistent data.
     *
     * @param b The bundle where the data is saved in.
     */
    private void restoreDataFromBundle(Bundle b) {
        mNewQuantityUnitName = b.getString(KEY_NEW_QUANTITY_UNIT_NAME);
        mQuantityUnits = (ArrayList<DatabaseUnit>)b.getSerializable(KEY_QUANTITY_UNITS);
    }

    /* Getter methods */
    public Init getActivity() {
        return mActivity;
    }

    public String getNewQuantityUnitName() {
        return mNewQuantityUnitName;
    }

    public DatabaseEntityManager getDatabaseEntityManager() {
        return mDatabaseEntityManager;
    }

    public ArrayList<DatabaseUnit> getQuantityUnits() {
        return mQuantityUnits;
    }

    /* Setter methods */
    public void setNewQuantityUnitName(String mNewQuantityUnitName) {
        this.mNewQuantityUnitName = mNewQuantityUnitName;
    }
}