package de.fhdw.bfws115a.team1.caloriecounter.activities.groceriessearchoverview;

import android.content.Intent;
import android.os.Bundle;
import de.fhdw.bfws115a.team1.caloriecounter.constants.SearchSettings;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseEntityManager;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseGrocery;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseHelper;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseUnit;
import de.fhdw.bfws115a.team1.caloriecounter.entities.*;

import java.util.ArrayList;

public class Data {
    private Init mActivity;

    /* Data variables */
    private ArrayList<GroceriesEntity> mGroceriesEntityList;
    private DatabaseEntityManager mDatabaseEntityManager;
    private GroceriesEntity mSelectedEntity;

    /* Default values */
    private final int DEFAULT_SEARCH_SETTINGS = SearchSettings.DISPLAY_ALL.ordinal();

    /* Keys */
    private final String KEY_GROCERIES_ENTITY_LIST = "groceriessearchoverview1";
    private final String KEY_SELECTED_ENTITY = "groceriessearchoverview2";

    public Data(Bundle savedInstanceState, Init activity) {
        mActivity = activity;
        mDatabaseEntityManager = new DatabaseEntityManager(mActivity.getApplicationContext());

        if (savedInstanceState == null) {
            Intent intent = mActivity.getIntent();
            SearchSettings searchSettings = SearchSettings.values()[intent.getIntExtra("searchSettings", DEFAULT_SEARCH_SETTINGS)];
            mGroceriesEntityList = new ArrayList<GroceriesEntity>();
            mSelectedEntity = null;

            if(SearchSettings.DISPLAY_ONLY_GROCERY == searchSettings || SearchSettings.DISPLAY_ALL == searchSettings) {
                mGroceriesEntityList.addAll(mDatabaseEntityManager.getAllGroceries());
            }
            if(SearchSettings.DISPLAY_ONLY_MENU == searchSettings || SearchSettings.DISPLAY_ALL == searchSettings) {
                mGroceriesEntityList.addAll(mDatabaseEntityManager.getAllMenus());
            }
        } else {
            restoreDataFromBundle(savedInstanceState);
        }
    }

    public void saveDataInBundle(Bundle b) {
        b.putSerializable(KEY_GROCERIES_ENTITY_LIST, mGroceriesEntityList);
        b.putSerializable(KEY_SELECTED_ENTITY, mSelectedEntity);
    }

    private void restoreDataFromBundle(Bundle b) {
        mGroceriesEntityList = (ArrayList<GroceriesEntity>) b.getSerializable(KEY_GROCERIES_ENTITY_LIST);
        mSelectedEntity = (GroceriesEntity) b.getSerializable(KEY_SELECTED_ENTITY);
    }

    /* Getter methods */
    public Init getActivity() {
        return mActivity;
    }

    public ArrayList<GroceriesEntity> getGroceriesEntityList() {
        return mGroceriesEntityList;
    }

    public GroceriesEntity getSelectedEntity() {
        return mSelectedEntity;
    }


    /* Setter methods */
    public void setSelectedEntity(GroceriesEntity mSelectedEntity) {
        this.mSelectedEntity = mSelectedEntity;
    }
}
