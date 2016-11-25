package de.fhdw.bfws115a.team1.caloriecounter.entities;

/**
 * Created by xySha on 24.11.2016.
 */
public class GroceryUnit {
    private Unit mUnit;
    private double mAmount;
    private int mKcal;

    public GroceryUnit(Unit unit, double amount, int kcal) {
        mUnit = new Unit(unit);
        mAmount = amount;
        mKcal = kcal;
    }

    public GroceryUnit(GroceryUnit groceryUnit) {
        this(groceryUnit.getUnit(), groceryUnit.getAmount(), groceryUnit.getKcal());
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

    public void setmKcal(int mKcal) {
        this.mKcal = mKcal;
    }

    public boolean equals(GroceryUnit groceryUnit) {
        return (groceryUnit.getUnit().getName() == this.getUnit().getName()
                && groceryUnit.getKcal() == this.getKcal()
                && groceryUnit.getAmount() == this.getAmount());
    }
}
