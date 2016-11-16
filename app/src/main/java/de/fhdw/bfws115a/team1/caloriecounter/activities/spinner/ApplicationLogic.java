package de.fhdw.bfws115a.team1.caloriecounter.activities.spinner;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;

public class ApplicationLogic {

    private Data mData;
    private Gui mGui;

    public ApplicationLogic(Data data, Gui gui) {
        mData = data;
        mGui = gui;
        initGui();
        initListener();

        Context context = mData.getActivity().getApplicationContext();
        Toast toast = Toast.makeText(context, "Ich bin ein Toast", Toast.LENGTH_SHORT);
        toast.show();
    }

    private void initGui() {
        ArrayAdapter<String> spinnerAdapter;
        ArrayList<String> spinnerItems;

        spinnerItems = new ArrayList<String>();
        spinnerItems.add("A 1");
        spinnerItems.add("B 2");
        spinnerItems.add("C 3");
        spinnerItems.add("D 4");
        spinnerItems.add("Item 5");
        spinnerAdapter = new ArrayAdapter<String>(mData.getActivity().getApplicationContext(), android.R.layout.simple_spinner_item, spinnerItems);

        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mGui.getSpinner().setAdapter(spinnerAdapter);
        mGui.getSpinner().setSelection(0);
    }

    private void initListener() {
        SpinnerItemChangeListener sicl;

        sicl = new SpinnerItemChangeListener(mData.getActivity());

        mGui.getSpinner().setOnItemSelectedListener(sicl);
    }
}
