package de.fhdw.bfws115a.team1.caloriecounter.entities;

import java.util.ArrayList;

/**
 * Created by Viktor on 15.11.2016.
 */

public class Menu extends GroceriesEntity {
    private double mAmount;
    private int mKcal;
    private ArrayList<FixGrocery> mFixGroceries;

    public Menu(String name, double amount) {
        super(name);
        mAmount = amount;
        mKcal = 0;
        mFixGroceries = new ArrayList<FixGrocery>();
    }

    public Menu(Menu menu) {
        this(menu.getName(), menu.getAmount());
        for(FixGrocery fg : menu.getFixGroceries()) {
            addGrocery(new FixGrocery(fg));
        }
    }

    public int getKcal() {
        return mKcal;
    }

    public double getAmount() {
        return mAmount;
    }

    public void setAmount(double mAmount) {
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
        if(mFixGroceries.remove(fixGrocery)) {
            mKcal -= fixGrocery.getKcal();
            return true;
        }
        return false;
    }

    public String toString() {
        String result = "Menu(Name: " + getName() + ", Portions: " + getAmount() + ", Groceries: ";
        ArrayList<FixGrocery> fixGroceries = getFixGroceries();
        if(fixGroceries.size() > 0) {
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
