package de.fhdw.bfws115a.team1.caloriecounter.activities.dailyoverview;

import android.util.Log;
import android.view.View;
import de.fhdw.bfws115a.team1.caloriecounter.R;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseEntry;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseGroceriesEntity;

public class ListButtonClickListener implements View.OnClickListener {
    private DatabaseEntry mDatabaseEntry;
    private ApplicationLogic mApplicationLogic;

    public ListButtonClickListener(ApplicationLogic applicationLogic, DatabaseEntry databaseEntry) {
        mApplicationLogic = applicationLogic;
        mDatabaseEntry = databaseEntry;
    }

    public void setDatabaseEntry(DatabaseEntry databaseEntry) {
        mDatabaseEntry = databaseEntry;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.idDailyoverviewDeleteButton:
                mApplicationLogic.deleteItem(mDatabaseEntry);
                break;
            case R.id.idDailyoverviewCopyButton:
                mApplicationLogic.onSelectCopyItem(mDatabaseEntry);
                break;
            case R.id.idDailyoverviewSettingButton:
                mApplicationLogic.onEditEntry(mDatabaseEntry);
                break;
        }
    }
}
