package de.fhdw.bfws115a.team1.caloriecounter.entities;

import java.util.ArrayList;

/**
 * Created by Viktor on 15.11.2016.
 */

public class Grocery extends GroceriesEntity {
    private ArrayList<GroceryUnit> mGroceryUnits;
    private int mKcal;

    public Grocery(String name, int kcal) {
        super(name);
        mGroceryUnits = new ArrayList<GroceryUnit>();
        mKcal = kcal;
    }

    public Grocery(Grocery grocery) {
        this(grocery.getName(), grocery.getKcal());
        for(GroceryUnit gu : grocery.getGroceryUnits()) {
            addGroceryUnit(new GroceryUnit(gu));
        }
    }

    public ArrayList<GroceryUnit> getGroceryUnits() {
        return mGroceryUnits;
    }

    public boolean addGroceryUnit(GroceryUnit groceryUnit) {
        for(GroceryUnit gu : mGroceryUnits) {
            if(gu.equals(groceryUnit)) return false;
        }
        mGroceryUnits.add(new GroceryUnit(groceryUnit));
        return true;
    }

    public boolean removeGroceryUnit(GroceryUnit groceryUnit) {
        return mGroceryUnits.remove(groceryUnit);
        /*GroceryUnit removeGroceryUnit = null;
        for(GroceryUnit gu : mGroceryUnits) {
            if(gu.equals(groceryUnit)) {
                removeGroceryUnit = gu;
                break;
            }
        }
        if(removeGroceryUnit != null) {
            mGroceryUnits.remove(removeGroceryUnit);
        }
        return false;*/
    }

    public int getKcal() {
        return mKcal;
    }

    public void setKcal(int mKcal) {
        this.mKcal = mKcal;
    }

    public String toString() {
        //TODO: add GroceryUnits to string
        return "Grocery(Name: " + getName() + ")";
    }
}
