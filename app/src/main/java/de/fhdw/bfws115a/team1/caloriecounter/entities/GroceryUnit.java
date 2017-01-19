package de.fhdw.bfws115a.team1.caloriecounter.entities;

import java.io.Serializable;

/**
 * This represents a unit with a amount.
 *
 * @author Viktor Schroeder
 */
public class GroceryUnit implements Serializable {
    /* Member variables */
    private Unit mUnit;
    private double mAmount;

    /**
     * Constructor
     *
     * @param unit   unit
     * @param amount amount of unit
     */
    public GroceryUnit(Unit unit, double amount) {
        mUnit = new Unit(unit);
        mAmount = amount;
    }

    /**
     * Constructor for copies.
     *
     * @param groceryUnit to copy groceryUnit
     */
    public GroceryUnit(GroceryUnit groceryUnit) {
        this(groceryUnit.getUnit(), groceryUnit.getAmount());
    }

    /**
     * Get the unit.
     *
     * @return unit
     */
    public Unit getUnit() {
        return mUnit;
    }

    /**
     * Set the unit.
     *
     * @param unit new unit
     */
    public void setUnit(Unit unit) {
        this.mUnit = new Unit(unit);
    }

    /**
     * Get the amount.
     *
     * @return amount
     */
    public double getAmount() {
        return mAmount;
    }

    /**
     * Set the amount.
     *
     * @param amount amount of unit
     */
    public void setAmount(double amount) {
        this.mAmount = amount;
    }

    /**
     * Check for equality of two GroceryUnits.
     *
     * @param groceryUnit to compare GroceryUnit
     * @return is equal or not
     */
    public boolean equals(GroceryUnit groceryUnit) {
        return (groceryUnit.getUnit().getName().equals(this.getUnit().getName())
                && groceryUnit.getAmount() == this.getAmount());
    }
}
