package de.fhdw.bfws115a.team1.caloriecounter.activities.quantityunitmanagement;

import android.os.Bundle;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseEntityManager;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseUnit;

import java.util.ArrayList;
import java.util.List;

public class Data {

    /* Member variables */
    private Init mActivity;
    private String mNewQuantityUnitName;
    private ArrayList<DatabaseUnit> mQuantityUnit;
    private DatabaseEntityManager mDatabaseEntityManager;

    /* Default values */
    private final String DEFAULT_NEWQUANTITYUNITNAME = "";

    /* Keys */
    private final String KEY_NEWQUANTITYUNITNAME = "quantityunitmanagement1";

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
        mQuantityUnit = new ArrayList<DatabaseUnit>();

        for (DatabaseUnit dbu : allDbUnits) {
            mQuantityUnit.add(dbu);
        }

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
        b.putString(KEY_NEWQUANTITYUNITNAME, mNewQuantityUnitName);
    }

    /**
     * Provides the possibility of retrieving the saved non-persistent data.
     *
     * @param b The bundle where the data is saved in.
     */
    private void restoreDataFromBundle(Bundle b) {
        mNewQuantityUnitName = b.getString(KEY_NEWQUANTITYUNITNAME);
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
        return mQuantityUnit;
    }

    /* Setter methods */
    public void setNewQuantityUnitName(String mNewQuantityUnitName) {
        this.mNewQuantityUnitName = mNewQuantityUnitName;
    }
}