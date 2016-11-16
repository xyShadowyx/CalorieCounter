package de.fhdw.bfws115a.team1.caloriecounter.entities;

/**
 * Created by Viktor on 16.11.2016.
 */

public class GroceryEntry extends Entry {
    private Grocery mGrocery;

    /* static functions */
    public static GroceryEntry add(int year, int month, int day, Grocery grocery) {

        GroceryEntry groceryEntry = new GroceryEntry(year, month, day, new Grocery(grocery));
        return groceryEntry;
    }

    private static void insert(GroceryEntry groceryEntry) {

    }

    public GroceryEntry(int year, int month, int day, Grocery grocery) {
        super(year, month, day);
        mGrocery = grocery;
    }

    public GroceryEntry(GroceryEntry groceryEntry) {
        this(groceryEntry.getYear(), groceryEntry.getMonth(), groceryEntry.getDay(), groceryEntry.getGrocery());
    }

    public Grocery getGrocery() {
        return mGrocery;
    }
}
