package de.fhdw.bfws115a.team1.caloriecounter.activities.dailyoverview;

import android.view.View;
import android.widget.Button;
import de.fhdw.bfws115a.team1.caloriecounter.R;

public class ButtonClickListener implements Button.OnClickListener {

    /* Member variable */
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
            case R.id.idDailyoverviewSpoonButton: {
                mApplicationLogic.onClickUnitQuantityButton();
                break;
            }
            case R.id.idDailyoverviewMenuButton: {
                mApplicationLogic.onClickMenuButton();
                break;
            }
            case R.id.idDailyoverviewGroceryButton: {
                mApplicationLogic.onClickGroceryButton();
                break;
            }
            case R.id.idDailyoverviewDate: {
                mApplicationLogic.onClickChangeDate();
                break;
            }
            case R.id.idDailyoverviewAddNewEntry: {
                mApplicationLogic.onClickAddEntry();
            }
        }
    }
}