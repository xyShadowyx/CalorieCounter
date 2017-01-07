package de.fhdw.bfws115a.team1.caloriecounter.entities;

import java.io.Serializable;

/**
 * Created by xySha on 24.11.2016.
 */
public class GroceryUnit implements Serializable {
    private Unit mUnit;
    private double mAmount;

    public GroceryUnit(Unit unit, double amount) {
        mUnit = new Unit(unit);
        mAmount = amount;
    }

    public GroceryUnit(GroceryUnit groceryUnit) {
        this(groceryUnit.getUnit(), groceryUnit.getAmount());
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

    public boolean equals(GroceryUnit groceryUnit) {
        return (groceryUnit.getUnit().getName() == this.getUnit().getName()
                && groceryUnit.getAmount() == this.getAmount());
    }
}
