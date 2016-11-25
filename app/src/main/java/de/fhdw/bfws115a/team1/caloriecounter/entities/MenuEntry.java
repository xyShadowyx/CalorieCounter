package de.fhdw.bfws115a.team1.caloriecounter.entities;

import android.view.MotionEvent;

/**
 * Created by Viktor on 16.11.2016.
 */

public class MenuEntry extends Entry {
    private Menu mMenu;

    public MenuEntry(int year, int month, int day, Menu menu) {
        super(year, month, day);
        mMenu = new Menu(menu);
    }

    public MenuEntry(MenuEntry menuEntry) {
        this(menuEntry.getYear(), menuEntry.getMonth(), menuEntry.getDay(), menuEntry.getMenu());
    }

    public Menu getMenu() {
        return mMenu;
    }

    public void setMenu(Menu menu) {
        mMenu = new Menu(menu);
    }

    public String toString() {
        return "MenuEntry(Year: " + getYear() + ", Month: " + getMonth() + ", Day: " + getDay() + ", Menu: " + getMenu().toString() + ")";
    }
}
