package de.fhdw.bfws115a.team1.caloriecounter.activities.calendar;

import android.annotation.TargetApi;
import android.os.Build;
import android.widget.CalendarView;

/**
 * Created by Viktor on 14.11.2016.
 */

public class DateChangeListener implements CalendarView.OnDateChangeListener {

    private ApplicationLogic mApplicationLogic;

    public DateChangeListener(ApplicationLogic applicationLogic) {
        mApplicationLogic = applicationLogic;
    }

    @Override
    public void onSelectedDayChange(CalendarView calendarView, int year, int month, int day) {
        mApplicationLogic.onDateSelect(year, month, day);
    }
}
