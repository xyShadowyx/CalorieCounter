package de.fhdw.bfws115a.team1.caloriecounter.activities.calendar;

import android.view.View;
import android.widget.Button;
import de.fhdw.bfws115a.team1.caloriecounter.R;

public class ButtonClickListener implements Button.OnClickListener {
    private ApplicationLogic mApplicationLogic;

    public ButtonClickListener(ApplicationLogic applicationLogic) {
        mApplicationLogic = applicationLogic;
    }

    /**
     * Assign layout components to backend functionality if triggered by user.
     *
     * @param view The specific view which should be assigned with functionality.
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.idCalendarTodayButton: {
                mApplicationLogic.selectToday();
                break;
            }
        }
    }
}
