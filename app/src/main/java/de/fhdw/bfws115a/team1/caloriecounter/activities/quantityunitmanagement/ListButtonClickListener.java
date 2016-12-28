package de.fhdw.bfws115a.team1.caloriecounter.activities.quantityunitmanagement;

import android.view.View;
import de.fhdw.bfws115a.team1.caloriecounter.R;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseUnit;
import de.fhdw.bfws115a.team1.caloriecounter.entities.FixGrocery;
import de.fhdw.bfws115a.team1.caloriecounter.entities.Unit;

public class ListButtonClickListener implements View.OnClickListener {
    private ApplicationLogic mApplicationLogic;
    private DatabaseUnit mDatabaseUnit;

    public ListButtonClickListener(ApplicationLogic applicationLogic, DatabaseUnit databaseUnit) {
        mApplicationLogic = applicationLogic;
        mDatabaseUnit = databaseUnit;
    }

    public void setDatabaseUnit(DatabaseUnit databaseUnit) {
        mDatabaseUnit = databaseUnit;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.idQuantityUnitManagementDeleteQuantityUnit:
                mApplicationLogic.onDeleteQuantityUnitClicked(mDatabaseUnit);
                break;
        }
    }
}
