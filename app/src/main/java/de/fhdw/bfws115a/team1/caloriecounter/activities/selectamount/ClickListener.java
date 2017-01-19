package de.fhdw.bfws115a.team1.caloriecounter.activities.selectamount;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import de.fhdw.bfws115a.team1.caloriecounter.R;

/**
 * @author Niklas Lammers.
 */
public class ClickListener implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    /* Member variables */
    private ApplicationLogic mApplicationLogic;
    private Data mData;

    public ClickListener(ApplicationLogic applicationLogic, Data data) {
        mApplicationLogic = applicationLogic;
        mData = data;
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

    /**
     * Never used in our application.
     *
     * @param adapterView
     * @param view
     * @param i
     * @param l
     */
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if(i > 0) {
            mApplicationLogic.onSpinnerStateChanged(mData.getUnitList().get(i));
        } else if(!mData.getIsMenu()) {
            mApplicationLogic.onSpinnerStateChanged("");
        }
    }

    /**
     * Case if spinner element is empty and therefore nothing is selected.
     * Annotation: The spinner wont be empty at any circumstances.
     *
     * @param adapterView
     */
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}