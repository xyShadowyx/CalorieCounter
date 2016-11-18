package de.fhdw.bfws115a.team1.caloriecounter.activities.grocerymanagement;

import android.view.View;
import de.fhdw.bfws115a.team1.caloriecounter.R;
import de.fhdw.bfws115a.team1.caloriecounter.activities.quantityunitmanagement.*;

/**
 * Created by Florian on 08.11.2016.
 */
public class ClickListener implements View.OnClickListener {

    private de.fhdw.bfws115a.team1.caloriecounter.activities.quantityunitmanagement.ApplicationLogic mApplicationLogic;

    public ClickListener(de.fhdw.bfws115a.team1.caloriecounter.activities.quantityunitmanagement.ApplicationLogic applicationLogic) {
        mApplicationLogic = applicationLogic;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //case für + Button
            case R.id.idAddQuantity:
                mApplicationLogic.onAddNewQuantity();
                break;
            //case für - Button
            case R.id.idDeleteQuantity:
                mApplicationLogic.onDeleteQuantity();
                break;
            case R.id.idSaveGrocerie:
                //speichern in der Datenbank
                break;

            //DropDown?
        }
    }

}

