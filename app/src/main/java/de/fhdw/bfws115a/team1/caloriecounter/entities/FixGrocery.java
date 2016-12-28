package de.fhdw.bfws115a.team1.caloriecounter.entities;

import android.widget.Filterable;

/**
 * Created by xySha on 25.11.2016.
 */
public class FixGrocery extends GroceriesEntity {
    private Unit mUnit;
    private double mAmount;
    private int mKcal;

    public FixGrocery(String name, Unit unit, double amount, int kcal) {
        super(name);
        mUnit = new Unit(unit);
        mAmount = amount;
        mKcal = kcal;
    }

    public FixGrocery(FixGrocery fixGrocery) {
        this(fixGrocery.getName(), fixGrocery.getUnit(), fixGrocery.getAmount(), fixGrocery.getKcal());
    }

    public FixGrocery(Grocery grocery, GroceryUnit groceryUnit) {
        this(grocery.getName(), groceryUnit.getUnit(), groceryUnit.getAmount(), grocery.getKcal());
    }

    public Unit getUnit() {
        return mUnit;
    }

    public void setUnit(Unit mUnit) {
        this.mUnit = mUnit;
    }

    public double getAmount() {
        return mAmount;
    }

    public void setAmount(double mAmount) {
        this.mAmount = mAmount;
    }

    public int getKcal() {
        return mKcal;
    }

    public void setKcal(int mKcal) {
        this.mKcal = mKcal;
    }

    public String toString() {
        return "FixGrocery(Name: " + getName() + ", Unit: " + getUnit().getName() + ", Amount: " + getAmount() + ", KCal: " + getKcal() +  ")";
    }
}
