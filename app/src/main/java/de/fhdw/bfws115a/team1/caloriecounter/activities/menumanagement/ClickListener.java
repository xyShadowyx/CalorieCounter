package de.fhdw.bfws115a.team1.caloriecounter.activities.menumanagement;

import android.view.View;
import de.fhdw.bfws115a.team1.caloriecounter.R;

public class ClickListener implements View.OnClickListener {

    private ApplicationLogic mApplicationLogic;

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
            case R.id.idMenuManagementAddNewGrocery:
                mApplicationLogic.onAddNewGroceryClicked();
                break;
            case R.id.idMenuManagementAddMenu:
                mApplicationLogic.onAddMenuClicked();
                break;
        }
    }
}