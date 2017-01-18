package de.fhdw.bfws115a.team1.caloriecounter.activities.quantityunitmanagement;

import android.text.Editable;
import android.text.TextWatcher;

/**
 * @author Florian Obladen.
 */

public class TextChangeListener implements TextWatcher {

    /* Member variable */
    private ApplicationLogic mApplicationLogic;

    public TextChangeListener(ApplicationLogic applicationLogic, Gui gui) {
        mApplicationLogic = applicationLogic;
    }

    /**
     * Called to notify me (or you) that someone just replaced the old text sequence with a new one.
     * It is an error to attempt to make changes to "charSequence" from this callback.
     *
     * @param charSequence The text sequence.
     * @param start        The first char to start the count.
     * @param before       The length of the text sequence.
     * @param count        The quantity of number that changed.
     */

    @Override
    public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
        mApplicationLogic.onQuantityUnitNameChanged(charSequence.toString());
    }

    /**
     * Never used in out application.
     *
     * @param charSequence
     * @param i
     * @param i1
     * @param i2
     */

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}