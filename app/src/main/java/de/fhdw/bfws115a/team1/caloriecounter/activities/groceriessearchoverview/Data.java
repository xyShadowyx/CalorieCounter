package de.fhdw.bfws115a.team1.caloriecounter.activities.groceriessearchoverview;

import android.os.Bundle;
import de.fhdw.bfws115a.team1.caloriecounter.entities.GroceriesEntity;
import de.fhdw.bfws115a.team1.caloriecounter.entities.Grocery;
import de.fhdw.bfws115a.team1.caloriecounter.entities.Menu;
import de.fhdw.bfws115a.team1.caloriecounter.entities.Unit;

import java.util.ArrayList;

public class Data {
    private Init mActivity;

    /* Data variables */
    private String mDummyString;
    private int mDummyInt;
    private ArrayList<GroceriesEntity> mGroceriesEntityList;
    private ListAdapter mListAdapter;

    /* Default values */
    private final String DEFAULTDUMMYSTRING = "Dummy";
    private final int DEFAULTDUMMYINT = 937;

    /* Keys */
    private final String KEYDUMMYSTRING = "groceriessearchoverview1";
    private final String KEYDUMMYINT = "groceriessearchoverview2";


    public Data(Bundle savedInstanceState, Init activity) {
        mActivity = activity;

        mGroceriesEntityList = new ArrayList<GroceriesEntity>();
        mGroceriesEntityList.add(new Grocery("Möhre", new Unit("Stück"), 2.0, 120));
        mGroceriesEntityList.add(new Grocery("Hamburger", new Unit("g"), 200.0, 1200));
        mGroceriesEntityList.add(new Grocery("Cola", new Unit("ml"), 330.0, 300));
        mGroceriesEntityList.add(new Grocery("Kiwi", new Unit("g"), 50.0, 40));
        mGroceriesEntityList.add(new Grocery("Kiwi", new Unit("g"), 50.0, 40));
        mGroceriesEntityList.add(new Grocery("Kiwi", new Unit("g"), 50.0, 40));
        mGroceriesEntityList.add(new Grocery("Kiwi", new Unit("g"), 50.0, 40));
        mGroceriesEntityList.add(new Grocery("Kiwi", new Unit("g"), 50.0, 40));
        mGroceriesEntityList.add(new Grocery("Kiwi", new Unit("g"), 50.0, 40));
        mGroceriesEntityList.add(new Grocery("Kiwi", new Unit("g"), 50.0, 40));
        mGroceriesEntityList.add(new Grocery("Kiwi", new Unit("g"), 50.0, 40));
        mGroceriesEntityList.add(new Grocery("Kiwi", new Unit("g"), 50.0, 40));
        mGroceriesEntityList.add(new Grocery("Kiwi", new Unit("g"), 50.0, 40));
        mGroceriesEntityList.add(new Grocery("Kiwi", new Unit("g"), 50.0, 40));
        mGroceriesEntityList.add(new Grocery("Kiwi", new Unit("g"), 50.0, 40));

        Menu m1 = new Menu("Kleines McMenu", 1.0);
        m1.addGrocery(new Grocery("Burger", new Unit("g"), 300.0, 1000));
        m1.addGrocery(new Grocery("Cola", new Unit("ml"), 330.0, 300));

        mGroceriesEntityList.add(m1);

        mListAdapter = new ListAdapter(mActivity, mGroceriesEntityList);

        if (savedInstanceState == null) {
            mDummyString = DEFAULTDUMMYSTRING;
            mDummyInt = DEFAULTDUMMYINT;
        } else {
            restoreDataFromBundle(savedInstanceState);
        }
    }

    public void saveDataInBundle(Bundle b) {
        b.putString(KEYDUMMYSTRING, mDummyString);
        b.putInt(KEYDUMMYINT, DEFAULTDUMMYINT);
    }

    private void restoreDataFromBundle(Bundle b) {
        mDummyString = b.getString(KEYDUMMYSTRING);
        mDummyInt = b.getInt(KEYDUMMYINT);
    }

    /* Getter methods */
    public Init getActivity() {
        return mActivity;
    }

    public ListAdapter getListAdapter() {
        return mListAdapter;
    }
    /* Setter methods */
}
