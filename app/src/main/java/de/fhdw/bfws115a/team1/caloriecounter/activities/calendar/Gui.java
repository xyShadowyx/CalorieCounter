package de.fhdw.bfws115a.team1.caloriecounter.activities.calendar;

import android.widget.Button;
import android.widget.CalendarView;

import java.util.Calendar;

import de.fhdw.bfws115a.team1.caloriecounter.R;

public class Gui {

    private CalendarView mCalendarView;
    private Button mTodayButton;

    public Gui(Init activity) {
        activity.setContentView(R.layout.activity_calendar);

        mCalendarView = (CalendarView) activity.findViewById(R.id.idCalendarView);
        mTodayButton = (Button) activity.findViewById(R.id.idTodayButton);
    }

    public CalendarView getCalendarView() {
        return mCalendarView;
    }

    public Button getTodayButton() {
        return mTodayButton;
    }

    /* Methods to apply changes */
    public void setSelectedDate(int year, int month, int day) {
        Calendar date = Calendar.getInstance();
        date.set(year, month, day);

        mCalendarView.setDate(date.getTimeInMillis());
    }
}
