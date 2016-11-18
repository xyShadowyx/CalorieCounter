package de.fhdw.bfws115a.team1.caloriecounter.activities.quantityunitmanagement;

import android.view.View;

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
            case R.id.idAddQuantityunit:
                mApplicationLogic.onAddNewQuantityunit();
                break;
            //case für - Button
            case R.id.idDeleteQuantityunit:
                mApplicationLogic.onDeleteQuantityunit();
                break;
        }
    }

}
