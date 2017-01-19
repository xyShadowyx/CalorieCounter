package de.fhdw.bfws115a.team1.caloriecounter.activities.groceriessearchoverview;

import android.util.Log;
import android.view.View;
import de.fhdw.bfws115a.team1.caloriecounter.R;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseGroceriesEntity;

/**
 * @author Viktor Schroeder.
 */
public class ListButtonClickListener implements View.OnClickListener {

    /* Member variables */
    private DatabaseGroceriesEntity mDatabaseGroceriesEntity;
    private ApplicationLogic mApplicationLogic;

    public ListButtonClickListener(ApplicationLogic applicationLogic, DatabaseGroceriesEntity databaseGroceriesEntity) {
        mApplicationLogic = applicationLogic;
        mDatabaseGroceriesEntity = databaseGroceriesEntity;
    }

    public void setDatabaseGroceriesEntity(DatabaseGroceriesEntity databaseGroceriesEntity) {
        mDatabaseGroceriesEntity = databaseGroceriesEntity;
    }

    /**
     * Assign layout components to backend functionality if triggered by user.
     *
     * @param view The specific view which should be assigned with functionality.
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.idGroceriesSearchOverviewRowDeleteButton:
                mApplicationLogic.deleteItem(mDatabaseGroceriesEntity);
                break;
            case R.id.idGroceriesSearchOverviewRowSettingButton:
                mApplicationLogic.editItem(mDatabaseGroceriesEntity);
                break;
        }
    }
}