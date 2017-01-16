package de.fhdw.bfws115a.team1.caloriecounter.activities.selectamount;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import de.fhdw.bfws115a.team1.caloriecounter.R;
import de.fhdw.bfws115a.team1.caloriecounter.entities.Unit;
import de.fhdw.bfws115a.team1.caloriecounter.utilities.Validation;

public class ApplicationLogic {

    /* Member variables */
    private Data mData;
    private Gui mGui;

    public ApplicationLogic(Data data, Gui gui) {
        mData = data;
        mGui = gui;
        initGui();
        initListener();
    }

    /**
     * Initialization.
     */
    private void initGui() {
        ArrayAdapter<String> arrayAdapter;
        arrayAdapter = new ArrayAdapter<String>(mData.getActivity(), android.R.layout.simple_spinner_item, mData.getUnitList());
        mGui.getSpinnerStatus().setAdapter(arrayAdapter);
        mGui.getSelectedAmount().setText(String.valueOf(mData.getSelectedAmount()));
        mGui.getPickedGrocery().setText(mData.getPickedGrocery());
    }

    /**
     * Initialization.
     */
    private void initListener() {
        ClickListener cl;
        TextChangeListener tcl;

        cl = new ClickListener(this);
        tcl = new TextChangeListener(this, mGui);

        mGui.getSelectedAmount().setOnClickListener(cl);
        mGui.getSpinnerStatus().setOnItemSelectedListener(cl);
        mGui.getAddAmount().setOnClickListener(cl);
        mGui.getSelectedAmount().addTextChangedListener(tcl);
    }

    /**
     * If called, it adds an amount with the appropriate quantity unit to a grocery or menu entity.
     * A validation checker checks if the input has a valid value.
     */
    public void onAddAmountClicked() {
        if (Validation.checkNumberValue(mData.getSelectedAmount())) {
            Intent resultIntent;
            resultIntent = new Intent();
            resultIntent.putExtra("amount", mData.getSelectedAmount());
            resultIntent.putExtra("unit", new Unit(mGui.getSpinnerStatus().getSelectedItem().toString()));
            mData.getActivity().setResult(Activity.RESULT_OK, resultIntent);
            mData.getActivity().finish();
        } else {
            Context context;
            Toast toast;
            context = mData.getActivity().getApplicationContext();
            toast = Toast.makeText(context, R.string.selectamount_emptyamounttoast, Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    /**
     * Called if user triggers amount-spinner and changes an amount.
     *
     * @param newValue Sets the the amount value.
     */
    public void onAmountChanged(String newValue) {
        Log.d("Debug", "New Value: " + newValue);
        mData.setSelectedAmount(Double.parseDouble(newValue));
    }
}