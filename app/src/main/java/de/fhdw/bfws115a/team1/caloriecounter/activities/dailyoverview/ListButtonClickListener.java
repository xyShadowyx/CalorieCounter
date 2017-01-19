package de.fhdw.bfws115a.team1.caloriecounter.activities.dailyoverview;

import android.view.View;
import de.fhdw.bfws115a.team1.caloriecounter.R;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseEntry;


/**
 * @author Viktor Schroeder
 */
public class ListButtonClickListener implements View.OnClickListener {
    private DatabaseEntry mDatabaseEntry;
    private ApplicationLogic mApplicationLogic;

    /**
     * Constructor
     *
     * @param applicationLogic
     * @param databaseEntry
     */
    public ListButtonClickListener(ApplicationLogic applicationLogic, DatabaseEntry databaseEntry) {
        mApplicationLogic = applicationLogic;
        mDatabaseEntry = databaseEntry;
    }

    /**
     * Set databaseEntry
     *
     * @param databaseEntry
     */
    public void setDatabaseEntry(DatabaseEntry databaseEntry) {
        mDatabaseEntry = databaseEntry;
    }


    /**
     * Called when button in list is clicked
     *
     * @param view
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
