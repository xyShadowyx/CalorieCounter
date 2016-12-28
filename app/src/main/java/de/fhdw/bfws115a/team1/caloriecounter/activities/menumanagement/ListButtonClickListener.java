package de.fhdw.bfws115a.team1.caloriecounter.activities.menumanagement;

import android.view.View;
import android.widget.ImageView;
import de.fhdw.bfws115a.team1.caloriecounter.R;
import de.fhdw.bfws115a.team1.caloriecounter.entities.FixGrocery;

public class ListButtonClickListener implements View.OnClickListener {
    private FixGrocery mFixGrocery;
    private ApplicationLogic mApplicationLogic;

    public ListButtonClickListener(ApplicationLogic applicationLogic, FixGrocery fixGrocery) {
        mApplicationLogic = applicationLogic;
        mFixGrocery = fixGrocery;
    }

    public void setFixGrocery(FixGrocery fixGrocery) {
        mFixGrocery = fixGrocery;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.idMenuManagementDeleteGrocery:
                mApplicationLogic.onDeleteGroceryClicked(mFixGrocery);
                break;
        }
    }
}
