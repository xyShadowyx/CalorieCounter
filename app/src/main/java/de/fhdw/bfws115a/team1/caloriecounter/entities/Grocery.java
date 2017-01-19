package de.fhdw.bfws115a.team1.caloriecounter.entities;

import java.util.ArrayList;

/**
 * This class contains the structure of a grocery.
 *
 * @author Viktor Schroeder
 */
public class Grocery extends GroceriesEntity {
    /* Member variables */
    private ArrayList<GroceryUnit> mGroceryUnits;
    private int mCalories;

    /**
     * Constructor
     *
     * @param name name of grocery
     * @param kcal calories of grocery
     */
    public Grocery(String name, int kcal) {
        super(name);
        mGroceryUnits = new ArrayList<GroceryUnit>();
        mCalories = kcal;
    }

    /**
     * Constructor for copies.
     *
     * @param grocery to copy Grocery
     */
    public Grocery(Grocery grocery) {
        this(grocery.getName(), grocery.getKcal());
        for(GroceryUnit gu : grocery.getGroceryUnits()) {
            addGroceryUnit(new GroceryUnit(gu));
        }
    }

    /**
     * Get all added GroceryUnits.
     *
     * @return ArrayList of GroceryUnits
     */
    public ArrayList<GroceryUnit> getGroceryUnits() {
        return mGroceryUnits;
    }

    /**
     * Add a GroceryUnit.
     *
     * @param groceryUnit fixed unit with amount to add to grocery
     * @return true if add was successful
     */
    public boolean addGroceryUnit(GroceryUnit groceryUnit) {
        for(GroceryUnit gu : mGroceryUnits) {
            if(gu.equals(groceryUnit)) return false;
        }
        mGroceryUnits.add(new GroceryUnit(groceryUnit));
        return true;
    }

    /**
     * Removes a GroceryUnit.
     *
     * @param groceryUnit GroceryUnit to remove
     * @return true if remove was successful
     */
    public boolean removeGroceryUnit(GroceryUnit groceryUnit) {
        return mGroceryUnits.remove(groceryUnit);
    }

    /**
     * Get the calories of this grocery.
     *
     * @return number of calories
     */
    public int getKcal() {
        return mCalories;
    }

    /**
     * Set the calories of this grocery.
     *
     * @param mKcal number of calories
     */
    public void setKcal(int mKcal) {
        this.mCalories = mKcal;
    }

    /**
     * Converts this object to a readable output.
     *
     * @return this object as a text
     */
    public String toString() {
        /* TODO: add GroceryUnits to string */
        return "Grocery(Name: " + getName() + ")";
    }
}
