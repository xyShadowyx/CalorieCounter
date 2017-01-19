package de.fhdw.bfws115a.team1.caloriecounter.entities;

/**
 * This class represents a specific menu entry at a day.
 *
 * @author Viktor Schroeder
 */
public class MenuEntry extends Entry {
    /* Member variables */
    private Menu mMenu;

    /**
     * Constructor
     *
     * @param year year of entry
     * @param month month of entry
     * @param day day of entry
     * @param menu menu for entry
     */
    public MenuEntry(int year, int month, int day, Menu menu) {
        super(year, month, day);
        mMenu = new Menu(menu);
    }

    /**
     * Constructor for copies.
     *
     * @param menuEntry the to copy menu entry
     */
    public MenuEntry(MenuEntry menuEntry) {
        this(menuEntry.getYear(), menuEntry.getMonth(), menuEntry.getDay(), menuEntry.getMenu());
    }

    /**
     * Get the menu of the entry.
     *
     * @return menu object
     */
    public Menu getMenu() {
        return mMenu;
    }

    /**
     * Set the menu.
     *
     * @param menu menu object for entry
     */
    public void setMenu(Menu menu) {
        mMenu = new Menu(menu);
    }

    /**
     * Converts this object to a readable output.
     *
     * @return a string of this object content
     */
    public String toString() {
        return "MenuEntry(Year: " + getYear() + ", Month: " + getMonth() + ", Day: " + getDay() + ", Menu: " + getMenu().toString() + ")";
    }
}
