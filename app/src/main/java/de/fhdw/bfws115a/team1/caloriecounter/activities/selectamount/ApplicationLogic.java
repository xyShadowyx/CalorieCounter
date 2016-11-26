package de.fhdw.bfws115a.team1.caloriecounter.activities.selectamount;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import de.fhdw.bfws115a.team1.caloriecounter.R;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseEntityManager;
import de.fhdw.bfws115a.team1.caloriecounter.utilities.validation;

public class ApplicationLogic {

    private Data mData;
    private Gui mGui;

    public ApplicationLogic(Data data, Gui gui) {
        mData = data;
        mGui = gui;
        initGui();
        initListener();
    }

    private void initGui() {

    }

    private void initListener() {
        ClickListener cl;

        cl = new ClickListener(this);
        mGui.getSelectedAmount().setOnClickListener(cl);
        mGui.getSpinnerStatus().setOnClickListener(cl);
        mGui.getAddAmount().setOnClickListener(cl);
    }

    /**
     * If called, it adds an amount with the right quantity unit to a grocery or menu entity.
     * A validation checker controls if the input has a valid value.
     */
    public void onAddAmountClicked() {
        if (validation.checkNumberValue(mData.getSelectedAmount())) {
            /* Return of values to the activity which triggered 'selectamount' */
            Intent resultIntent = new Intent();
            resultIntent.putExtra("amount", Integer.parseInt(mGui.getSelectedAmount().getText().toString()));
            resultIntent.putExtra("unit", mGui.getSpinnerStatus().getSelectedItem().toString());
            mData.getActivity().setResult(Activity.RESULT_OK, resultIntent);
            mData.getActivity().finish();
        } else {
            Context context = mData.getActivity().getApplicationContext();
            Toast toast = Toast.makeText(context, R.string.selectamount_emptyamounttoast, Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}

