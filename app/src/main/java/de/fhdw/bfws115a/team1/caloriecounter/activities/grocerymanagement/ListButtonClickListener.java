package de.fhdw.bfws115a.team1.caloriecounter.activities.grocerymanagement;

import android.view.View;
import de.fhdw.bfws115a.team1.caloriecounter.R;
import de.fhdw.bfws115a.team1.caloriecounter.entities.GroceryUnit;

/**
 * @author Niklas Lammers.
 */
public class ListButtonClickListener implements View.OnClickListener {

    /* Member variables */
    private GroceryUnit mGroceryUnit;
    private ApplicationLogic mApplicationLogic;

    public ListButtonClickListener(ApplicationLogic applicationLogic, GroceryUnit groceryUnit) {
        mApplicationLogic = applicationLogic;
        mGroceryUnit = groceryUnit;
    }

    /**
     * Sets a new grocery unit.
     *
     * @param groceryUnit The new grocery unit.
     */
    public void setGroceryUnit(GroceryUnit groceryUnit) {
        mGroceryUnit = groceryUnit;
    }

    /**
     * Assign layout components to backend functionality if triggered by user.
     *
     * @param view The specific view which should be assigned with functionality.
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.idGroceryManagementRowDeleteAmount:
                mApplicationLogic.onDeleteQuantityClicked(mGroceryUnit);
                break;
        }
    }
}