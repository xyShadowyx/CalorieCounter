package de.fhdw.bfws115a.team1.caloriecounter.activities.groceriessearchoverview;

import android.util.Log;
import android.view.View;
import de.fhdw.bfws115a.team1.caloriecounter.R;
import de.fhdw.bfws115a.team1.caloriecounter.entities.GroceriesEntity;

public class ListButtonClickListener implements View.OnClickListener {
    private GroceriesEntity mGroceriesEntity;
    private ApplicationLogic mApplicationLogic;

    public ListButtonClickListener(ApplicationLogic applicationLogic, GroceriesEntity groceriesEntity) {
        mApplicationLogic = applicationLogic;
        mGroceriesEntity = groceriesEntity;
    }

    public void setGroceriesEntity(GroceriesEntity groceriesEntity) {
        mGroceriesEntity = groceriesEntity;
    }

    @Override
    public void onClick(View view) {
        Log.d("Dabug", "Clicked id: " + view.getId());
        switch (view.getId()) {
            case R.id.idGroceriesSearchOverviewDeleteButton:
                // Delete Image clicked
                break;
            case R.id.idGroceriesSearchOverviewSettingButton:
                // Edit Image clicked
                break;
        }
    }
}
