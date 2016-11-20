package de.fhdw.bfws115a.team1.caloriecounter.activities.menumanagement;

import android.view.View;
import de.fhdw.bfws115a.team1.caloriecounter.R;

/**
 * Created by Niklas on 17.11.2016.
 */
public class ClickListener implements View.OnClickListener {

    private ApplicationLogic mApplicationLogic;

    public ClickListener(ApplicationLogic applicationLogic) {
        mApplicationLogic = applicationLogic;
    }

    /* IDs müssen noch auf das passende Layout referenziert werden! */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.idDeleteGrocery:
                mApplicationLogic.onDeleteGroceryClicked();
                //magic
                break;
            case R.id.idAddNewGrocery:
                mApplicationLogic.onAddNewGroceryClicked();
                //magic
                break;
            case R.id.idAddMenu:
                mApplicationLogic.onAddMenuClicked();
                //magic
                break;
        }
    }
}
