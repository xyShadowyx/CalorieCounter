package de.fhdw.bfws115a.team1.caloriecounter.activities.grocerymanagement;

import android.view.View;
import android.widget.AdapterView;

/**
 * @author Niklas Lammers.
 */
public class SpinnerItemSelectListener implements AdapterView.OnItemSelectedListener {

    /* Member variables */
    private ApplicationLogic mApplicationLogic;
    private Data mData;

    public SpinnerItemSelectListener(ApplicationLogic applicationLogic, Data data) {
        mApplicationLogic = applicationLogic;
        mData = data;
    }

    /**
     * Invoked if an item in this view has been selected.
     *
     * @param adapterView The AdapterView where the selection happened.
     * @param view        The view within the AdapterView that was clicked.
     * @param i           The position of the view in the adapter.
     * @param l           The ID of the item that is selected.
     */
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        mApplicationLogic.onNewUnitNameChanged(mData.getUnitList().get(i));
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