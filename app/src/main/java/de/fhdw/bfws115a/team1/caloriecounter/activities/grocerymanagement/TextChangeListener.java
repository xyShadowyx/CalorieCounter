package de.fhdw.bfws115a.team1.caloriecounter.activities.grocerymanagement;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import de.fhdw.bfws115a.team1.caloriecounter.R;

/**
 * Created by Niklas on 17.11.2016.
 */
public class TextChangeListener implements TextWatcher {

    private ApplicationLogic mApplicationLogic;
    private View mView;

    public TextChangeListener(ApplicationLogic applicationLogic, View view) {
        mApplicationLogic = applicationLogic;
        mView = view;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        Log.d("Debug", "OnChangeListener called: " + charSequence);
        switch (mView.getId()) {
            case R.id.idGroceryManagementGroceryName: {
                mApplicationLogic.onGroceryNameChanged(charSequence.toString());
                break;
            }
            case R.id.idGroceryManagementKiloCalories: {
                mApplicationLogic.onGroceryCaloriesChanged(charSequence.toString());
                break;
            }
            case R.id.idGroceryManagementSelectedAmount: {
                mApplicationLogic.onNewUnitAmountChanged(charSequence.toString());
                break;
            }
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
