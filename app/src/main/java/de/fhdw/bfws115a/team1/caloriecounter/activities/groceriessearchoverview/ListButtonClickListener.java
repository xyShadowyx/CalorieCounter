package de.fhdw.bfws115a.team1.caloriecounter.activities.groceriessearchoverview;

import android.util.Log;
import android.view.View;
import de.fhdw.bfws115a.team1.caloriecounter.R;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseGroceriesEntity;

public class ListButtonClickListener implements View.OnClickListener {
    private DatabaseGroceriesEntity mDatabaseGroceriesEntity;
    private ApplicationLogic mApplicationLogic;

    public ListButtonClickListener(ApplicationLogic applicationLogic, DatabaseGroceriesEntity databaseGroceriesEntity) {
        mApplicationLogic = applicationLogic;
        mDatabaseGroceriesEntity = databaseGroceriesEntity;
    }

    public void setDatabaseGroceriesEntity(DatabaseGroceriesEntity databaseGroceriesEntity) {
        mDatabaseGroceriesEntity = databaseGroceriesEntity;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.idGroceriesSearchOverviewDeleteButton:
                mApplicationLogic.deleteItem(mDatabaseGroceriesEntity);
                break;
            case R.id.idGroceriesSearchOverviewSettingButton:
                mApplicationLogic.editItem(mDatabaseGroceriesEntity);
                break;
        }
    }
}
