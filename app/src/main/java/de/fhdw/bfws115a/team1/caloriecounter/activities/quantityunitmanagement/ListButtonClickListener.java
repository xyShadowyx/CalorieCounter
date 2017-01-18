package de.fhdw.bfws115a.team1.caloriecounter.activities.quantityunitmanagement;

import android.view.View;
import de.fhdw.bfws115a.team1.caloriecounter.R;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseUnit;

/**
 * @author Florian Obladen.
 */

public class ListButtonClickListener implements View.OnClickListener {

    /* Member variables */
    private ApplicationLogic mApplicationLogic;
    private DatabaseUnit mDatabaseUnit;

    public ListButtonClickListener(ApplicationLogic applicationLogic, DatabaseUnit databaseUnit) {
        mApplicationLogic = applicationLogic;
        mDatabaseUnit = databaseUnit;
    }

    /**
     * Sets a DatabaseUnit.
     *
     * @param databaseUnit The DatabaseUnit which should be set.
     */

    public void setDatabaseUnit(DatabaseUnit databaseUnit) {
        mDatabaseUnit = databaseUnit;
    }

    /**
     * Assign layout components to backend functionality if triggered by user.
     *
     * @param view The specific view which should be assigned with functionality.
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.idQuantityUnitManagementRowDeleteQuantityUnit:
                mApplicationLogic.onDeleteQuantityUnitClicked(mDatabaseUnit);
                break;
        }
    }
}