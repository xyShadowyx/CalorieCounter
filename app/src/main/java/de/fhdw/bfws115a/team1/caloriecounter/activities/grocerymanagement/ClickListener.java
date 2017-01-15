package de.fhdw.bfws115a.team1.caloriecounter.activities.grocerymanagement;

import android.view.View;
import de.fhdw.bfws115a.team1.caloriecounter.R;

/**
 * Created by Florian on 08.11.2016.
 */
public class ClickListener implements View.OnClickListener {

    private ApplicationLogic mApplicationLogic;

    public ClickListener(ApplicationLogic applicationLogic) {
        mApplicationLogic = applicationLogic;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //case für + Button
            case R.id.idGroceryManagementAddAmount:
                mApplicationLogic.onAddNewQuantityClicked();
                break;
            case R.id.idGroceryManagementSaveGrocery:
                mApplicationLogic.onSaveGroceryClicked();
                //speichern in der Datenbank
                break;
        }
    }

}

