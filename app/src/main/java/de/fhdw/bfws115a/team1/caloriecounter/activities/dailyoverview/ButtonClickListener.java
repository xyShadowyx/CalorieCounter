package de.fhdw.bfws115a.team1.caloriecounter.activities.dailyoverview;

import android.view.View;
import android.widget.Button;
import de.fhdw.bfws115a.team1.caloriecounter.R;

/**
 * Created by xySha on 28.12.2016.
 */
public class ButtonClickListener implements Button.OnClickListener {
    private ApplicationLogic mApplicationLogic;

    public ButtonClickListener(ApplicationLogic applicationLogic) {
        mApplicationLogic = applicationLogic;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.spoonButton: {
                mApplicationLogic.onClickUnitQuantityButton();
                break;
            }
            case R.id.menuButton: {
                mApplicationLogic.onClickMenuButton();
                break;
            }
            case R.id.groceryButton: {
                mApplicationLogic.onClickGroceryButton();
                break;
            }
            case R.id.date: {
                mApplicationLogic.onClickChangeDate();
                break;
            }
        }
    }
}