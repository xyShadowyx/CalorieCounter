package de.fhdw.bfws115a.team1.caloriecounter.activities.calendar;

import android.widget.CalendarView;

/**
 * @author Florian Obladen.
 */

public class DateChangeListener implements CalendarView.OnDateChangeListener {

    /* Member variable */
    private ApplicationLogic mApplicationLogic;
    private Data mData;

    public DateChangeListener(ApplicationLogic applicationLogic, Data data) {
        mApplicationLogic = applicationLogic;
        mData = data;
    }

    /**
     * Changes to the selected date.
     *
     * @param calendarView The calendar view used.
     * @param year         The year to change.
     * @param month        The month to change.
     * @param day          The day to change.
     */
    @Override
    public void onSelectedDayChange(CalendarView calendarView, int year, int month, int day) {
        if(year != mData.getSelectedYear() || month != mData.getSelectedMonth() || day != mData.getSelectedDay()) {
            mApplicationLogic.onDateSelect(year, month, day);
        }
    }
}