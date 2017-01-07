package de.fhdw.bfws115a.team1.caloriecounter.activities.calendar;

import android.view.View;
import android.widget.Button;
import de.fhdw.bfws115a.team1.caloriecounter.R;

/**
 * Created by xySha on 22.11.2016.
 */
public class ButtonClickListener implements Button.OnClickListener {
    private ApplicationLogic mApplicationLogic;

    public ButtonClickListener(ApplicationLogic applicationLogic) {
        mApplicationLogic = applicationLogic;
    }

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
