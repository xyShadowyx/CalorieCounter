package de.fhdw.bfws115a.team1.caloriecounter.activities.calendar;

import android.widget.Button;
import android.widget.CalendarView;

import java.util.Calendar;

import de.fhdw.bfws115a.team1.caloriecounter.R;

public class Gui {

    /* Member variables */
    private CalendarView mCalendarView;
    private Button mTodayButton;

    /**
     * Assign layout components to member variables so that they can be changed in backend.
     *
     * @param activity The current initialised activity.
     */
    public Gui(Init activity) {
        activity.setContentView(R.layout.calendar);

        mCalendarView = (CalendarView) activity.findViewById(R.id.idCalendarCalendarView);
        mTodayButton = (Button) activity.findViewById(R.id.idCalendarTodayButton);
    }

    /* Getter methods */
    public CalendarView getCalendarView() {
        return mCalendarView;
    }

    public Button getTodayButton() {
        return mTodayButton;
    }

    /* Setter methods */
    public void setSelectedDate(int year, int month, int day) {
        Calendar date;
        date = Calendar.getInstance();
        date.set(year, month, day);
        mCalendarView.setDate(date.getTimeInMillis(), true, true);
    }
}