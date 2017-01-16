package de.fhdw.bfws115a.team1.caloriecounter.activities.menumanagement;

import android.view.View;
import de.fhdw.bfws115a.team1.caloriecounter.R;
import de.fhdw.bfws115a.team1.caloriecounter.entities.FixGrocery;

public class ListButtonClickListener implements View.OnClickListener {

    /* Member variables */
    private FixGrocery mFixGrocery;
    private ApplicationLogic mApplicationLogic;

    public ListButtonClickListener(ApplicationLogic applicationLogic, FixGrocery fixGrocery) {
        mApplicationLogic = applicationLogic;
        mFixGrocery = fixGrocery;
    }

    /**
     * Sets a FixGrocery.
     *
     * @param fixGrocery The FixGrocery which sould be set.
     */
    public void setFixGrocery(FixGrocery fixGrocery) {
        mFixGrocery = fixGrocery;
    }

    /**
     * Assign layout components to backend functionality if triggered by user.
     *
     * @param view The specific view which should be assigned with functionality.
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.idMenuManagementDeleteGrocery:
                mApplicationLogic.onDeleteGroceryClicked(mFixGrocery);
                break;
        }
    }
}