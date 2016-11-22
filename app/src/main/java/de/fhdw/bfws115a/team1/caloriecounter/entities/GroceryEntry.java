package de.fhdw.bfws115a.team1.caloriecounter.entities;

/**
 * Created by Viktor on 16.11.2016.
 */

public class GroceryEntry extends Entry {
    private Grocery mGrocery;

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

    public void setGrocery(Grocery grocery) {
        mGrocery = new Grocery(grocery);
    }

    public String toString() {
        return "GroceryEntry(Year: " + getYear() + ", Month: " + getMonth() + ", Day: " + getDay() + ", Grocery: " + getGrocery().toString() + ")";
    }
}
