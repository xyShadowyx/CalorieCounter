package de.fhdw.bfws115a.team1.caloriecounter.entities;

import java.util.ArrayList;

/**
 * This class contains the structure of a menu.
 */
public class Menu extends GroceriesEntity {
    private double mAmount;
    private int mKcal;
    private ArrayList<FixGrocery> mFixGroceries;

    /**
     * Constructor
     *
     * @param name
     * @param amount
     */
    public Menu(String name, double amount) {
        super(name);
        mAmount = amount;
        mKcal = 0;
        mFixGroceries = new ArrayList<FixGrocery>();
    }

    /**
     * Constructor for copies
     *
     * @param menu
     */
    public Menu(Menu menu) {
        this(menu.getName(), menu.getAmount());
        for (FixGrocery fg : menu.getFixGroceries()) {
            addGrocery(new FixGrocery(fg));
        }
    }

    /**
     * Get calories of this menu
     *
     * @return amount of kilocalories
     */
    public int getKcal() {
        return mKcal;
    }

    /**
     * Get the
     *
     * @return
     */
    public double getAmount() {
        return mAmount;
    }

    public void setAmount(double mAmount) {
        mKcal = 0;
        for (FixGrocery fg : getFixGroceries()) {
            fg.setAmount(fg.getAmount() * mAmount);
            fg.setKcal((int) Math.round(fg.getAmount() * mAmount * fg.getKcal()));
            mKcal += fg.getKcal();
        }
        this.mAmount = mAmount;
    }

    public ArrayList<FixGrocery> getFixGroceries() {
        return mFixGroceries;
    }

    public void addGrocery(FixGrocery fixGrocery) {
        mFixGroceries.add(new FixGrocery(fixGrocery));
        mKcal += fixGrocery.getKcal();
    }

    public boolean removeGrocery(FixGrocery fixGrocery) {
        if (mFixGroceries.remove(fixGrocery)) {
            mKcal -= fixGrocery.getKcal();
            return true;
        }
        return false;
    }

    public void removeAllGrocery() {
        mFixGroceries.clear();
        mKcal = 0;
    }

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
