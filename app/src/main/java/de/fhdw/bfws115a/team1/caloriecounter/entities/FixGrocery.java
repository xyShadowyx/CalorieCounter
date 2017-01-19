package de.fhdw.bfws115a.team1.caloriecounter.entities;

/**
 * This class represents a grocery with fixed unit and size
 *
 * @author Viktor Schroeder
 */
public class FixGrocery extends GroceriesEntity {
    /* Member variables */
    private Unit mUnit;
    private double mAmount;
    private int mKcal;

    /**
     * Constructor
     *
     * @param name name of fixed grocery
     * @param unit unit of fixed grocery
     * @param amount amount of fixed grocery
     * @param kcal calories of fixed grocery
     */
    public FixGrocery(String name, Unit unit, double amount, int kcal) {
        super(name);
        mUnit = new Unit(unit);
        mAmount = amount;
        mKcal = kcal;
    }

    /**
     * Constructor for copies
     *
     * @param fixGrocery to copy FixGrocery
     */
    public FixGrocery(FixGrocery fixGrocery) {
        this(fixGrocery.getName(), fixGrocery.getUnit(), fixGrocery.getAmount(), fixGrocery.getKcal());
    }

    /**
     * Constructor to concat a GroceryUnit to Grocery
     *
     * @param grocery not fixed grocery
     * @param groceryUnit unit with amount
     */
    public FixGrocery(Grocery grocery, GroceryUnit groceryUnit) {
        this(grocery.getName(), groceryUnit.getUnit(), groceryUnit.getAmount(), grocery.getKcal());
    }

    /**
     * Get the fixed unit
     *
     * @return get the unit
     */
    public Unit getUnit() {
        return mUnit;
    }

    /**
     * Set the fixed unit
     *
     * @param unit new unit
     */
    public void setUnit(Unit unit) {
        this.mUnit = unit;
    }

    /**
     * Get the amount of the unit
     *
     * @return number of amount
     */
    public double getAmount() {
        return mAmount;
    }

    /**
     * Set the amount of the unit
     *
     * @param amount number of amount
     */
    public void setAmount(double amount) {
        this.mAmount = amount;
    }

    /**
     * Get calories of this grocery.
     *
     * @return number of calories
     */
    public int getKcal() {
        return mKcal;
    }

    /**
     * Set calories of this grocery.
     *
     * @param mKcal number of calories
     */
    public void setKcal(int mKcal) {
        this.mKcal = mKcal;
    }

    /**
     * Converts this object to a readable output.
     *
     * @return this object as a text
     */
    public String toString() {
        return "FixGrocery(Name: " + getName() + ", Unit: " + getUnit().getName() + ", Amount: " + getAmount() + ", KCal: " + getKcal() + ")";
    }
}
