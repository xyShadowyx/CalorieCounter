package de.fhdw.bfws115a.team1.caloriecounter.activities.calendar;

import android.app.Activity;
import android.content.Intent;

import java.util.Calendar;

/**
 * @author Florian Obladen.
 */

public class ApplicationLogic {
    /*Member variable*/
    private Data mData;
    private Gui mGui;

    public ApplicationLogic(Data data, Gui gui) {
        mData = data;
        mGui = gui;
        initGui();
        initListener();
    }

    /**
     * Initialization.
     */
    private void initGui() {
        mGui.setSelectedDate(mData.getSelectedYear(), mData.getSelectedMonth(), mData.getSelectedDay());
    }

    /**
     * Initialization.
     */
    private void initListener() {
        DateChangeListener dcl;
        ButtonClickListener bcl;

        dcl = new DateChangeListener(this, mData);
        bcl = new ButtonClickListener(this);

        mGui.getCalendarView().setOnDateChangeListener(dcl);
        mGui.getTodayButton().setOnClickListener(bcl);
    }

    /**
     * Leads to the present day.
     */
    public void selectToday() {
        Intent resultIntent;
        Calendar calendarToday;
        int year, month, day;

        calendarToday = Calendar.getInstance();
        year = calendarToday.get(Calendar.YEAR);
        month = calendarToday.get(Calendar.MONTH);
        day = calendarToday.get(Calendar.DAY_OF_MONTH);

        onDateSelect(year, month, day);
    }

    /**
     * Leads to the selected date.
     *
     * @param year  The selected year.
     * @param month The selected month.
     * @param day   The selected day.
     */
    public void onDateSelect(int year, int month, int day) {
        Intent resultIntent;

        resultIntent = new Intent();
        resultIntent.putExtra("year", year);
        resultIntent.putExtra("month", month);
        resultIntent.putExtra("day", day);
        mData.getActivity().setResult(Activity.RESULT_OK, resultIntent);
        mData.getActivity().finish();
    }
}