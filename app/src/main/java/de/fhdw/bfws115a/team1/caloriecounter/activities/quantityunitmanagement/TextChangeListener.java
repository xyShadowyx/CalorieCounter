package de.fhdw.bfws115a.team1.caloriecounter.activities.quantityunitmanagement;

import android.text.Editable;
import android.text.TextWatcher;

public class TextChangeListener implements TextWatcher {

    /* Member variable */
    private ApplicationLogic mApplicationLogic;

    public TextChangeListener(ApplicationLogic applicationLogic, Gui gui) {
        mApplicationLogic = applicationLogic;
    }

    //TODO Löschen?
    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        mApplicationLogic.onQuantityUnitNameChanged(charSequence.toString());
    }

    //TODO Löschen?
    @Override
    public void afterTextChanged(Editable editable) {

    }
}