package de.fhdw.bfws115a.team1.caloriecounter.activities.menumanagement;

import android.content.Intent;
import android.os.Bundle;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseEntityManager;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseMenu;
import de.fhdw.bfws115a.team1.caloriecounter.entities.FixGrocery;
import de.fhdw.bfws115a.team1.caloriecounter.entities.Unit;

import java.util.ArrayList;

public class Data {

    /* Data variables */
    private Init mActivity;
    private String mMenuName;
    private int mPortionSize;
    private String mAddedGroceries;
    private ArrayList<FixGrocery> mMenuFixGroceries;
    private DatabaseMenu mInputMenu;

    /* Database Entity Manager */
    private DatabaseEntityManager mDatabaseEntityManager;

    /* Default values */
    private final String DEFAULT_MENUNAME = "";
    private final int DEFAULT_PORTIONSIZE = 0;
    private final String DEFAULT_ADDEDGROCERIES = "";

    /* Keys */
    private final String KEY_INPUTMENU = "menumanagement1";
    private final String KEY_MENUFIXGROCERIES = "menumanagement2";
    private final String KEY_MENUNAME = "menumanagement3";
    private final String KEY_PORTIONSIZE = "menumanagement4";
    private final String KEY_ADDEDGROCERIES = "menumanagement5";

    public Data(Bundle savedInstanceState, Init activity) {
        mActivity = activity;
        mDatabaseEntityManager = new DatabaseEntityManager(activity.getApplicationContext());

        if (savedInstanceState == null) {
            Intent intent = mActivity.getIntent();

            mMenuFixGroceries = new ArrayList<FixGrocery>();
            if (intent.hasExtra("databaseMenu")) {
                mInputMenu = (DatabaseMenu) intent.getSerializableExtra("databaseMenu");
                for(FixGrocery fg : mInputMenu.getFixGroceries()){
                    mMenuFixGroceries.add(fg);
                }
            } else {
                mInputMenu = null;
            }

            mMenuName = DEFAULT_MENUNAME;
            mPortionSize = DEFAULT_PORTIONSIZE;
            mAddedGroceries = DEFAULT_ADDEDGROCERIES;
        } else {
            restoreDataFromBundle(savedInstanceState);
        }
    }

    public void saveDataInBundle(Bundle b) {
        b.putSerializable(KEY_INPUTMENU, mInputMenu);
        b.putSerializable(KEY_MENUFIXGROCERIES, mMenuFixGroceries);
        b.putString(KEY_MENUNAME, mMenuName);
        b.putInt(KEY_PORTIONSIZE, mPortionSize);
        b.putString(KEY_ADDEDGROCERIES, mAddedGroceries);
    }

    private void restoreDataFromBundle(Bundle b) {
        mInputMenu = (DatabaseMenu) b.getSerializable(KEY_INPUTMENU);
        mMenuFixGroceries = (ArrayList<FixGrocery>) b.getSerializable(KEY_MENUFIXGROCERIES);
        mMenuName = b.getString(KEY_MENUNAME);
        mPortionSize = b.getInt(KEY_PORTIONSIZE);
        mAddedGroceries = b.getString(KEY_ADDEDGROCERIES);
    }

    /* Getter methods */
    public Init getActivity() {
        return mActivity;
    }

    public String getMenuName() {
        return mMenuName;
    }

    public int getPortionSize() {
        return mPortionSize;
    }

    public String getAddedGroceries() {
        return mAddedGroceries;
    }

    public ArrayList<FixGrocery> getMenuFixGroceries() {
        return mMenuFixGroceries;
    }

    public DatabaseEntityManager getDatabaseEntityManager() {
        return mDatabaseEntityManager;
    }

    public DatabaseMenu getInputMenu() {
        return mInputMenu;
    }

    /* Setter methods */
    public void setActivity(Init mActivity) {
        this.mActivity = mActivity;
    }

    public void setMenuName(String mMenuName) {
        this.mMenuName = mMenuName;
    }

    public void setPortionSize(int mPortionSize) {
        this.mPortionSize = mPortionSize;
    }

    public void setAddedGroceries(String mAddedGroceries) {
        this.mAddedGroceries = mAddedGroceries;
    }


}
