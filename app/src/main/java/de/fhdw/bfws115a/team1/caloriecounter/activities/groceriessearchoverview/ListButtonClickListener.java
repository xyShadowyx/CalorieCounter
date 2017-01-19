package de.fhdw.bfws115a.team1.caloriecounter.activities.groceriessearchoverview;

import android.view.View;
import de.fhdw.bfws115a.team1.caloriecounter.R;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseGroceriesEntity;

/**
 * @author Viktor Schroeder
 */
public class ListButtonClickListener implements View.OnClickListener {
    private DatabaseGroceriesEntity mDatabaseGroceriesEntity;
    private ApplicationLogic mApplicationLogic;

    /**
     * Constructor
     *
     * @param applicationLogic
     * @param databaseGroceriesEntity
     */
    public ListButtonClickListener(ApplicationLogic applicationLogic, DatabaseGroceriesEntity databaseGroceriesEntity) {
        mApplicationLogic = applicationLogic;
        mDatabaseGroceriesEntity = databaseGroceriesEntity;
    }

    /**
     * Set databaseGroceriesEntity
     *
     * @param databaseGroceriesEntity
     */
    public void setDatabaseGroceriesEntity(DatabaseGroceriesEntity databaseGroceriesEntity) {
        mDatabaseGroceriesEntity = databaseGroceriesEntity;
    }

    /**
     * Called when button in list is clicked
     *
     * @param view
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
