package de.fhdw.bfws115a.team1.caloriecounter.entities;

import android.view.MotionEvent;

/**
 * This class represents a specific entry at a day.
 */

public class MenuEntry extends Entry {
    private Menu mMenu;

    /**
     * Constructor
     *
     * @param year
     * @param month
     * @param day
     * @param menu
     */
    public MenuEntry(int year, int month, int day, Menu menu) {
        super(year, month, day);
        mMenu = new Menu(menu);
    }

    /**
     * Constructor for copies
     *
     * @param menuEntry
     */
    public MenuEntry(MenuEntry menuEntry) {
        this(menuEntry.getYear(), menuEntry.getMonth(), menuEntry.getDay(), menuEntry.getMenu());
    }

    /**
     * Get the menu of the entry
     *
     * @return menu
     */
    public Menu getMenu() {
        return mMenu;
    }

    /**
     * Set the menu
     *
     * @param menu
     */
    public void setMenu(Menu menu) {
        mMenu = new Menu(menu);
    }

    /**
     * Converts this object to a readable output
     *
     * @return
     */
    public String toString() {
        return "MenuEntry(Year: " + getYear() + ", Month: " + getMonth() + ", Day: " + getDay() + ", Menu: " + getMenu().toString() + ")";
    }
}
