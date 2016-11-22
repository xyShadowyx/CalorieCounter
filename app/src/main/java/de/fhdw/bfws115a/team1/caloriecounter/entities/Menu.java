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
            addGrocery(new Grocery(g));
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

    public void setName(String mName) {
        this.mName = mName;
    }

    public void setPortions(double mPortions) {
        this.mPortions = mPortions;
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

    public String toString() {
        String result = "Menu(Name: " + getName() + ", Portions: " + getPortions() + ", Groceries: ";
        ArrayList<Grocery> groceries = getGroceries();
        if(groceries.size() > 0) {
            for (Grocery g : groceries) {
                result += g.toString();
                result += ", ";
            }
            result = result.substring(0, result.length() - 2);
        } else {
            result += "-";
        }
        result += ")";
        return result;
    }
}
