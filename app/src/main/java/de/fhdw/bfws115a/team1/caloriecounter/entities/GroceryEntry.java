package de.fhdw.bfws115a.team1.caloriecounter.entities;

/**
 * Created by Viktor on 16.11.2016.
 */

public class GroceryEntry extends Entry {
    private FixGrocery mFixGrocery;

    public GroceryEntry(int year, int month, int day, FixGrocery fixGrocery) {
        super(year, month, day);
        mFixGrocery = fixGrocery;
    }

    public GroceryEntry(GroceryEntry groceryEntry) {
        this(groceryEntry.getYear(), groceryEntry.getMonth(), groceryEntry.getDay(), groceryEntry.getFixGrocery());
    }

    public FixGrocery getFixGrocery() {
        return mFixGrocery;
    }

    public void setFixGrocery(FixGrocery fixGrocery) {
        mFixGrocery = new FixGrocery(fixGrocery);
    }

    public String toString() {
        return "GroceryEntry(Year: " + getYear() + ", Month: " + getMonth() + ", Day: " + getDay() + ", FixGrocery: " + getFixGrocery().toString() + ")";
    }
}
