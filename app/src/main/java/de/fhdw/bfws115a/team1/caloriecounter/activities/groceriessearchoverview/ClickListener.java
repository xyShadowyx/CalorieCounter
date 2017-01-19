package de.fhdw.bfws115a.team1.caloriecounter.activities.groceriessearchoverview;

import android.view.View;
import de.fhdw.bfws115a.team1.caloriecounter.R;

/**
 * @author Viktor Schroeder
 */
public class ClickListener implements View.OnClickListener {

    /* Member variable */
    private ApplicationLogic mApplicationLogic;

    /**
     * Constructor
     *
     * @param applicationLogic
     */
    public ClickListener(ApplicationLogic applicationLogic) {
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
            case R.id.idGroceriesSearchOverviewAddGroceryButton:
                mApplicationLogic.onCreateNewGroceryClicked();
                break;
            case R.id.idGroceriesSearchOverviewAddMenuButton:
                mApplicationLogic.onCreateNewMenuClicked();
                break;
        }
    }
}