package de.fhdw.bfws115a.team1.caloriecounter.activities.selectamount;

import android.view.View;
import android.widget.AdapterView;
import de.fhdw.bfws115a.team1.caloriecounter.R;

/**
 * Created by Niklas on 17.11.2016.
 */
public class ClickListener implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private ApplicationLogic mApplicationLogic;
    private Gui mGui;

    public ClickListener(ApplicationLogic applicationLogic) {
        mApplicationLogic = applicationLogic;
    }

    /* IDs müssen noch auf das passende Layout referenziert werden! */
    @Override
    public void onClick(View view) {
        /* Creating a switch-case due to easier adding of clickable buttons later on. */
        switch (view.getId()) {
            case R.id.idSelectAmountAddAmount:
                mApplicationLogic.onAddAmountClicked();
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
