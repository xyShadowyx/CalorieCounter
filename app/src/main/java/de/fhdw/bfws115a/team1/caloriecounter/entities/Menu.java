package de.fhdw.bfws115a.team1.caloriecounter.entities;

import java.util.ArrayList;

/**
 * Created by Viktor on 15.11.2016.
 */

public class Menu extends GroceriesEntity {
    private double mAmount;
    private int mKcal;
    private ArrayList<Grocery> mGroceries;

    public Menu(String name, double amount) {
        super(name);
        mAmount = amount;
        mKcal = 0;
        mGroceries = new ArrayList<Grocery>();
    }

    public Menu(Menu menu) {
        this(menu.getName(), menu.getAmount());
        for(Grocery g : menu.getGroceries()) {
            addGrocery(new Grocery(g));
        }
    }

    @Override
    public Unit getUnit() {
        // TODO: add 'Portionen' to values as string
        return new Unit("Portionen");
    }

    @Override
    public int getKcal() {
        return mKcal;
    }

    @Override
    public double getAmount() {
        return mAmount;
    }

    public void setAmount(double mAmount) {
        this.mAmount = mAmount;
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
        String result = "Menu(Name: " + getName() + ", Portions: " + getAmount() + ", Groceries: ";
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
