package de.fhdw.bfws115a.team1.caloriecounter.activities.calendar;

import android.widget.CalendarView;

public class DateChangeListener implements CalendarView.OnDateChangeListener {

    /* Member variable */
    private ApplicationLogic mApplicationLogic;

    public DateChangeListener(ApplicationLogic applicationLogic) {
        mApplicationLogic = applicationLogic;
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
        mApplicationLogic.onDateSelect(year, month, day);
    }
}