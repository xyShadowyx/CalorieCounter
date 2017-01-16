package de.fhdw.bfws115a.team1.caloriecounter.activities.grocerymanagement;

import android.view.View;
import de.fhdw.bfws115a.team1.caloriecounter.R;
import de.fhdw.bfws115a.team1.caloriecounter.entities.GroceryUnit;

public class ListButtonClickListener implements View.OnClickListener {
    private GroceryUnit mGroceryUnit;
    private ApplicationLogic mApplicationLogic;

    public ListButtonClickListener(ApplicationLogic applicationLogic, GroceryUnit groceryUnit) {
        mApplicationLogic = applicationLogic;
        mGroceryUnit = groceryUnit;
    }

    public void setGroceryUnit(GroceryUnit groceryUnit) {
        mGroceryUnit = groceryUnit;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.idMenuManagementDeleteGrocery:
                //mApplicationLogic.onDeleteGroceryClicked(mGroceryUnit);
                break;
        }
    }
}
