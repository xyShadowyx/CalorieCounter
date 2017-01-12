package de.fhdw.bfws115a.team1.caloriecounter.activities.selectamount;

import android.view.View;
import android.widget.AdapterView;
import de.fhdw.bfws115a.team1.caloriecounter.R;

public class ClickListener implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    /* Member variables */
    private ApplicationLogic mApplicationLogic;
    private Gui mGui;

    public ClickListener(ApplicationLogic applicationLogic) {
        mApplicationLogic = applicationLogic;
    }

    /**
     * Assign layout components to backend functionality if triggered by user.
     *
     * @param view The specific view which should be assigned with functionality.
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.idSelectAmountAddAmount:
                mApplicationLogic.onAddAmountClicked();
                break;
        }
    }

    //TODO Löschen?
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    //TODO Löschen?
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}