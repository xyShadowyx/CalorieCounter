package de.fhdw.bfws115a.team1.caloriecounter.activities.selectamount;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import de.fhdw.bfws115a.team1.caloriecounter.R;
import de.fhdw.bfws115a.team1.caloriecounter.entities.Unit;
import de.fhdw.bfws115a.team1.caloriecounter.utilities.Validation;

/**
 * @author Niklas Lammers.
 */
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
        arrayAdapter = new ArrayAdapter<String>(mData.getActivity(), android.R.layout.simple_list_item_1, mData.getUnitList());
        mGui.getSpinner().setAdapter(arrayAdapter);
        mGui.getSelectedAmount().setText(String.valueOf(mData.getSelectedAmount()));
        mGui.getPickedGrocery().setText(mData.getPickedGrocery());
    }

    /**
     * Initialization.
     */
    private void initListener() {
        ClickListener cl;
        TextChangeListener tcl;

        cl = new ClickListener(this, mData);
        tcl = new TextChangeListener(this, mGui);

        mGui.getSelectedAmount().setOnClickListener(cl);
        mGui.getAddAmount().setOnClickListener(cl);
        mGui.getSelectedAmount().addTextChangedListener(tcl);

        mGui.getSpinner().setOnItemSelectedListener(cl);
    }

    /**
     * If called, it adds an amount with the appropriate quantity unit to a grocery or menu entity.
     * A validation checker checks if the input has a valid value.
     */
    public void onAddAmountClicked() {
        if (Validation.checkNumberValue(mData.getSelectedAmount()) && !Validation.checkIfEmpty(mData.getSpinnerStatus())) {
            Intent resultIntent;
            resultIntent = new Intent();
            resultIntent.putExtra("amount", mData.getSelectedAmount());
            resultIntent.putExtra("unit", new Unit(mData.getSpinnerStatus()));
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
        mData.setSelectedAmount(Double.parseDouble(newValue));
    }


    /**
     * Called if user changes the unit spinner.
     *
     * @param status sets the selected unit position.
     */
    public void onSpinnerStateChanged(String status) {
        mData.setSpinnerStatus(status);
    }
}