package de.fhdw.bfws115a.team1.caloriecounter.activities.menumanagement;

import android.content.Intent;
import android.os.Bundle;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseEntityManager;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseMenu;
import de.fhdw.bfws115a.team1.caloriecounter.entities.FixGrocery;

import java.util.ArrayList;

public class Data {

    /* Member variables */
    private Init mActivity;
    private String mMenuName;
    private double mPortionSize;
    private ArrayList<FixGrocery> mMenuFixGroceries;
    private DatabaseMenu mInputMenu;
    private DatabaseEntityManager mDatabaseEntityManager;

    /* Default values */
    private final String DEFAULT_MENUNAME = "";
    private final double DEFAULT_PORTIONSIZE = 0.0;

    /* Keys */
    private final String KEY_INPUTMENU = "menumanagement1";
    private final String KEY_MENUFIXGROCERIES = "menumanagement2";
    private final String KEY_MENUNAME = "menumanagement3";
    private final String KEY_PORTIONSIZE = "menumanagement4";

    /**
     * Method which gets the current layout attributes and put them into an Intent object.
     * The reasons are possible saving and retrieving options of the data stored.
     *
     * @param savedInstanceState A bundle where data can be stored.
     * @param activity           The current initialised activity.
     */
    public Data(Bundle savedInstanceState, Init activity) {
        mActivity = activity;
        mDatabaseEntityManager = new DatabaseEntityManager(activity.getApplicationContext());

        if (savedInstanceState == null) {
            Intent intent;
            intent = mActivity.getIntent();
            mMenuFixGroceries = new ArrayList<FixGrocery>();

            mInputMenu = (DatabaseMenu) intent.getSerializableExtra("databaseMenu");
            if (mInputMenu != null) {
                mMenuName = mInputMenu.getName();
                mPortionSize = mInputMenu.getAmount();
                for (FixGrocery fg : mInputMenu.getFixGroceries()) {
                    mMenuFixGroceries.add(fg);
                }
            } else {
                mInputMenu = null;
                mMenuName = DEFAULT_MENUNAME;
                mPortionSize = DEFAULT_PORTIONSIZE;
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
        b.putSerializable(KEY_INPUTMENU, mInputMenu);
        b.putSerializable(KEY_MENUFIXGROCERIES, mMenuFixGroceries);
        b.putString(KEY_MENUNAME, mMenuName);
        b.putDouble(KEY_PORTIONSIZE, mPortionSize);
    }

    /**
     * Provides the possibility of retrieving the saved non-persistent data.
     *
     * @param b The bundle where the data is saved in.
     */
    private void restoreDataFromBundle(Bundle b) {
        mInputMenu = (DatabaseMenu) b.getSerializable(KEY_INPUTMENU);
        mMenuFixGroceries = (ArrayList<FixGrocery>) b.getSerializable(KEY_MENUFIXGROCERIES);
        mMenuName = b.getString(KEY_MENUNAME);
        mPortionSize = b.getInt(KEY_PORTIONSIZE);
    }

    /* Getter methods */
    public Init getActivity() {
        return mActivity;
    }

    public String getMenuName() {
        return mMenuName;
    }

    public double getPortionSize() {
        return mPortionSize;
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

    public void setPortionSize(double mPortionSize) {
        this.mPortionSize = mPortionSize;
    }
}