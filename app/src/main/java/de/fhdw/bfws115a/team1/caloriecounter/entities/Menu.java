package de.fhdw.bfws115a.team1.caloriecounter.entities;

import java.util.ArrayList;

/**
 * Created by Viktor on 15.11.2016.
 */

public class Menu {
    private String mName;
    private double mPortions;
    private int mKcal;
    private ArrayList<Grocery> mGroceries;

    public Menu(String name, double portions) {
        mName = name;
        mPortions = portions;
        mKcal = 0;
        mGroceries = new ArrayList<Grocery>();
    }

    public Menu(Menu menu) {
        this(menu.getName(), menu.getPortions());
        for(Grocery g : menu.getGroceries()) {
            menu.addGrocery(new Grocery(g));
        }
    }

    public String getName() {
        return mName;
    }

    public double getPortions() {
        return mPortions;
    }

    public int getKcal() {
        return mKcal;
    }

    public ArrayList<Grocery> getGroceries() {
        return mGroceries;
    }

    public void addGrocery(Grocery grocery) {
        mGroceries.add(new Grocery(grocery));
        mKcal += grocery.getKcal();
    }

    public void removeGrocery(Grocery grocery) {
        if(mGroceries.remove(grocery)) {
            mKcal -= grocery.getKcal();
        }
    }
}
