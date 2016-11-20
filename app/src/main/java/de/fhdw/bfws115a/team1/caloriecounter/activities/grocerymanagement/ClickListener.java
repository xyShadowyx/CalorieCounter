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
            case R.id.idAddNewQuantity:
                mApplicationLogic.onAddNewQuantityClicked();
                break;
            //case für - Button
            case R.id.idDeleteQuantity:
                mApplicationLogic.onDeleteQuantityClicked();
                break;
            case R.id.idSaveGrocery:
                mApplicationLogic.onSaveGroceryClicked();
                //speichern in der Datenbank
                break;

            //DropDown?
        }
    }

}

