package de.fhdw.bfws115a.team1.caloriecounter.activities.quantityunitmanagement;

import android.text.Editable;
import android.text.TextWatcher;


/**
 * Created by Niklas on 17.11.2016.
 */
public class TextChangeListener implements TextWatcher {

    private ApplicationLogic mApplicationLogic;

    public TextChangeListener(ApplicationLogic applicationLogic, Gui gui) {
        mApplicationLogic = applicationLogic;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        mApplicationLogic.onQuantityUnitNameChanged(charSequence.toString());
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
