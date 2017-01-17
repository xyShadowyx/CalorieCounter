package de.fhdw.bfws115a.team1.caloriecounter.activities.grocerymanagement;

import android.view.View;
import de.fhdw.bfws115a.team1.caloriecounter.R;

/**
 * @author Niklas Lammers.
 */
public class ClickListener implements View.OnClickListener {

    /* Member variable */
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
            case R.id.idGroceryManagementAddAmount:
                mApplicationLogic.onAddNewQuantityClicked();
                break;
            case R.id.idGroceryManagementSaveGrocery:
                mApplicationLogic.onSaveGroceryClicked();
                break;
        }
    }
}