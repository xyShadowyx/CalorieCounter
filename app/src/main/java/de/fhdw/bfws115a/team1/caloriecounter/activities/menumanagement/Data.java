package de.fhdw.bfws115a.team1.caloriecounter.activities.menumanagement;

import android.content.Intent;
import android.os.Bundle;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseEntityManager;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseMenu;
import de.fhdw.bfws115a.team1.caloriecounter.entities.FixGrocery;

import java.util.ArrayList;

/**
 * @author Niklas Lammers and Florian Obladen.
 */
public class Data {

    /* Default values */
    private final String DEFAULT_MENUNAME = "";
    private final double DEFAULT_PORTIONSIZE = 0.0;
    /* Keys */
    private final String KEY_MENU_NAME = "menumanagement1";
    private final String KEY_PORTION_SIZE = "menumanagement2";
    private final String KEY_MENU_FIX_GROCERIES = "menumanagement3";
    private final String KEY_INPUT_MENU = "menumanagement4";
    /* Member variables */
    private Init mActivity;
    private String mMenuName;
    private double mPortionSize;
    private ArrayList<FixGrocery> mMenuFixGroceries;
    private DatabaseMenu mInputMenu;
    private DatabaseEntityManager mDatabaseEntityManager;

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
        b.putString(KEY_MENU_NAME, mMenuName);
        b.putDouble(KEY_PORTION_SIZE, mPortionSize);
        b.putSerializable(KEY_MENU_FIX_GROCERIES, mMenuFixGroceries);
        b.putSerializable(KEY_INPUT_MENU, mInputMenu);
    }

    /**
     * Provides the possibility of retrieving the saved non-persistent data.
     *
     * @param b The bundle where the data is saved in.
     */
    private void restoreDataFromBundle(Bundle b) {
        mMenuName = b.getString(KEY_MENU_NAME);
        mPortionSize = b.getInt(KEY_PORTION_SIZE);
        mMenuFixGroceries = (ArrayList<FixGrocery>) b.getSerializable(KEY_MENU_FIX_GROCERIES);
        mInputMenu = (DatabaseMenu) b.getSerializable(KEY_INPUT_MENU);
    }

    /* Getter methods */
    public Init getActivity() {
        return mActivity;
    }

    /* Setter methods */
    public void setActivity(Init mActivity) {
        this.mActivity = mActivity;
    }

    public String getMenuName() {
        return mMenuName;
    }

    public void setMenuName(String mMenuName) {
        this.mMenuName = mMenuName;
    }

    public double getPortionSize() {
        return mPortionSize;
    }

    public void setPortionSize(double mPortionSize) {
        this.mPortionSize = mPortionSize;
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
}