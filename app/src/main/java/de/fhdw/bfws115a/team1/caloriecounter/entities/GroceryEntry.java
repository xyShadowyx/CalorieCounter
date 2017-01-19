package de.fhdw.bfws115a.team1.caloriecounter.entities;

/**
 * This class represents a specific menu entry at a day.
 *
 * @author Viktor Schroeder
 */
public class GroceryEntry extends Entry {
    /* Member variables */
    private FixGrocery mFixGrocery;

    /**
     * Constructor
     *
     * @param year       year of entry
     * @param month      month of entry
     * @param day        day of entry
     * @param fixGrocery fixed grocery with unit and size
     */
    public GroceryEntry(int year, int month, int day, FixGrocery fixGrocery) {
        super(year, month, day);
        mFixGrocery = fixGrocery;
    }

    /**
     * Constructor for copies.
     *
     * @param groceryEntry to copy GroceryEntry
     */
    public GroceryEntry(GroceryEntry groceryEntry) {
        this(groceryEntry.getYear(), groceryEntry.getMonth(), groceryEntry.getDay(), groceryEntry.getFixGrocery());
    }

    /**
     * Get the grocery with fixed unit and size.
     *
     * @return grocery with fixed unit and size
     */
    public FixGrocery getFixGrocery() {
        return mFixGrocery;
    }

    /**
     * Set the grocery with fixed unit and size.
     *
     * @param fixGrocery to set FixGrocery
     */
    public void setFixGrocery(FixGrocery fixGrocery) {
        mFixGrocery = new FixGrocery(fixGrocery);
    }

    /**
     * Converts this object to a readable output.
     *
     * @return this object as a text
     */
    public String toString() {
        return "GroceryEntry(Year: " + getYear() + ", Month: " + getMonth() + ", Day: " + getDay() + ", FixGrocery: " + getFixGrocery().toString() + ")";
    }
}
