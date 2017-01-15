package de.fhdw.bfws115a.team1.caloriecounter.activities.grocerymanagement;

import android.view.View;
import android.widget.AdapterView;

/**
 * Created by xySha on 07.01.2017.
 */
public class SpinnerItemSelectListener implements AdapterView.OnItemSelectedListener {
    private ApplicationLogic mApplicationLogic;
    private Data mData;

    public SpinnerItemSelectListener(ApplicationLogic applicationLogic, Data data) {
        mApplicationLogic = applicationLogic;
        mData = data;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        mApplicationLogic.onNewUnitNameChanged(mData.getUnitList().get(i));
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
