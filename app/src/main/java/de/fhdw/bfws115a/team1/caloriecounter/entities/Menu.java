package de.fhdw.bfws115a.team1.caloriecounter.entities;

import java.util.ArrayList;

/**
 * This class contains the structure of a menu.
 *
 * @author Viktor Schroeder
 */
public class Menu extends GroceriesEntity {
    /* Member variables */
    private double mAmount;
    private int mKcal;
    private ArrayList<FixGrocery> mFixGroceries;

    /**
     * Constructor
     *
     * @param name menu name
     * @param amount portion size of menu
     */
    public Menu(String name, double amount) {
        super(name);
        mAmount = amount;
        mKcal = 0;
        mFixGroceries = new ArrayList<FixGrocery>();
    }

    /**
     * Constructor for copies.
     *
     * @param menu to copy menu
     */
    public Menu(Menu menu) {
        this(menu.getName(), menu.getAmount());
        for (FixGrocery fg : menu.getFixGroceries()) {
            addGrocery(new FixGrocery(fg));
        }
    }

    /**
     * Get calories of this menu.
     *
     * @return amount of calories
     */
    public int getKcal() {
        return mKcal;
    }

    /**
     * Get the portion size of the menu.
     *
     * @return portion size
     */
    public double getAmount() {
        return mAmount;
    }

    /**
     * Changes the amount of menu portion and recalculates the calories.
     *
     * @param amount portion size
     */
    public void setAmount(double amount) {
        mKcal = 0;
        for (FixGrocery fg : getFixGroceries()) {
            fg.setAmount((fg.getAmount() / mAmount) * amount);
            fg.setKcal((int) Math.round((fg.getKcal() / mAmount) * amount));
            mKcal += fg.getKcal();
        }
        mAmount = amount;
    }

    /**
     * Get all groceries with fixed size and unit of the menu.
     *
     * @return ArrayList of FixGroceries
     */
    public ArrayList<FixGrocery> getFixGroceries() {
        return mFixGroceries;
    }

    /**
     * Add grocery with fixed size and unit to the menu.
     *
     * @param fixGrocery FixGrocery to add into menu
     */
    public void addGrocery(FixGrocery fixGrocery) {
        mFixGroceries.add(new FixGrocery(fixGrocery));
        mKcal += fixGrocery.getKcal();
    }

    /**
     * Removes a grocery with fixed size and unit from the menu
     *
     * @param fixGrocery FoxGrocery for remove
     *
     * @return grocery successfully removed.
     */
    public boolean removeGrocery(FixGrocery fixGrocery) {
        if (mFixGroceries.remove(fixGrocery)) {
            mKcal -= fixGrocery.getKcal();
            return true;
        }
        return false;
    }

    /**
     * Removes all groceries with fixed size and unit from menu.
     */
    public void removeAllGrocery() {
        mFixGroceries.clear();
        mKcal = 0;
    }

    /**
     * Converts this object to a readable output.
     *
     * @return this object as a text
     */
    public String toString() {
        String result = "Menu(Name: " + getName() + ", Portions: " + getAmount() + ", Groceries: ";
        ArrayList<FixGrocery> fixGroceries = getFixGroceries();
        if (fixGroceries.size() > 0) {
            for (FixGrocery fg : fixGroceries) {
                result += fg.toString();
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
