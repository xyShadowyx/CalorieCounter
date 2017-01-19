package de.fhdw.bfws115a.team1.caloriecounter.activities.dailyoverview;

import android.util.Log;
import android.view.View;
import de.fhdw.bfws115a.team1.caloriecounter.R;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseEntry;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseGroceriesEntity;

/**
 * @author Viktor Schroeder.
 */
public class ListButtonClickListener implements View.OnClickListener {

    /* Member variables */
    private DatabaseEntry mDatabaseEntry;
    private ApplicationLogic mApplicationLogic;

    public ListButtonClickListener(ApplicationLogic applicationLogic, DatabaseEntry databaseEntry) {
        mApplicationLogic = applicationLogic;
        mDatabaseEntry = databaseEntry;
    }

    public void setDatabaseEntry(DatabaseEntry databaseEntry) {
        mDatabaseEntry = databaseEntry;
    }

    /**
     * Assign layout components to backend functionality if triggered by user.
     *
     * @param view The specific view which should be assigned with functionality.
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.idDailyoverviewRowDeleteButton:
                mApplicationLogic.deleteItem(mDatabaseEntry);
                break;
            case R.id.idDailyoverviewRowCopyButton:
                mApplicationLogic.onSelectCopyItem(mDatabaseEntry);
                break;
            case R.id.idDailyoverviewRowSettingButton:
                mApplicationLogic.onEditEntry(mDatabaseEntry);
                break;
        }
    }
}
