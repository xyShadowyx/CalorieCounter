package de.fhdw.bfws115a.team1.caloriecounter.activities.groceriessearchoverview;

import android.content.Intent;
import android.os.Bundle;
import de.fhdw.bfws115a.team1.caloriecounter.constants.SearchSettings;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseEntity;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseEntityManager;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseGroceriesEntity;
import de.fhdw.bfws115a.team1.caloriecounter.entities.*;

import java.util.ArrayList;

public class Data {

    /* Member variable */
    private Init mActivity;
    private ArrayList<DatabaseGroceriesEntity> mDatabaseGroceriesEntityList;
    private DatabaseEntityManager mDatabaseEntityManager;
    private GroceriesEntity mSelectedEntity;

    /* Default values */
    private final int DEFAULT_SEARCH_SETTINGS = SearchSettings.DISPLAY_ALL.ordinal();

    /* Keys */
    private final String KEY_GROCERIES_ENTITY_LIST = "groceriessearchoverview1";
    private final String KEY_SELECTED_ENTITY = "groceriessearchoverview2";

    /**
     * Method which gets the current layout attributes and put them into an 'Intent' object.
     * The reasons are possible saving and retrieving options of the data stored.
     *
     * @param savedInstanceState A bundle where data can be stored.
     * @param activity           The current initialised activity.
     */
    public Data(Bundle savedInstanceState, Init activity) {
        mActivity = activity;
        mDatabaseEntityManager = new DatabaseEntityManager(mActivity.getApplicationContext());
        SearchSettings searchSettings;

        if (savedInstanceState == null) {
            Intent intent = mActivity.getIntent();
            searchSettings = SearchSettings.values()[intent.getIntExtra("searchSettings", DEFAULT_SEARCH_SETTINGS)];
            mDatabaseGroceriesEntityList = new ArrayList<DatabaseGroceriesEntity>();
            mSelectedEntity = null;

            if (SearchSettings.DISPLAY_ONLY_GROCERY == searchSettings || SearchSettings.DISPLAY_ALL == searchSettings) {
                mDatabaseGroceriesEntityList.addAll(mDatabaseEntityManager.getAllGroceries());
            }
            if (SearchSettings.DISPLAY_ONLY_MENU == searchSettings || SearchSettings.DISPLAY_ALL == searchSettings) {
                mDatabaseGroceriesEntityList.addAll(mDatabaseEntityManager.getAllMenus());
            }
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
        b.putSerializable(KEY_GROCERIES_ENTITY_LIST, mDatabaseGroceriesEntityList);
        b.putSerializable(KEY_SELECTED_ENTITY, mSelectedEntity);
    }

    /**
     * Provides the possibility of retrieving the saved non-persistent data.
     *
     * @param b The bundle where the data is saved in.
     */
    private void restoreDataFromBundle(Bundle b) {
        mDatabaseGroceriesEntityList = (ArrayList<DatabaseGroceriesEntity>) b.getSerializable(KEY_GROCERIES_ENTITY_LIST);
        mSelectedEntity = (GroceriesEntity) b.getSerializable(KEY_SELECTED_ENTITY);
    }

    /* Getter methods */
    public Init getActivity() {
        return mActivity;
    }

    public ArrayList<DatabaseGroceriesEntity> getDatabaseGroceriesEntityList() {
        return mDatabaseGroceriesEntityList;
    }

    public GroceriesEntity getSelectedEntity() {
        return mSelectedEntity;
    }

    public DatabaseEntityManager getDatabaseEntityManager() {
        return mDatabaseEntityManager;
    }

    /* Setter methods */
    public void setSelectedEntity(GroceriesEntity mSelectedEntity) {
        this.mSelectedEntity = mSelectedEntity;
    }
}