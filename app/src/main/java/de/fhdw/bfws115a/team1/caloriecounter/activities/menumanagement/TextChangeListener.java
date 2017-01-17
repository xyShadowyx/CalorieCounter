package de.fhdw.bfws115a.team1.caloriecounter.activities.menumanagement;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import de.fhdw.bfws115a.team1.caloriecounter.R;

/**
 * @author Niklas Lammers and Florian Obladen.
 */
public class TextChangeListener implements TextWatcher {

    /* Member variables */
    private ApplicationLogic mApplicationLogic;
    private View mView;

    public TextChangeListener(ApplicationLogic applicationLogic, View view) {
        mApplicationLogic = applicationLogic;
        mView = view;
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
        switch (mView.getId()) {
            case R.id.idMenuManagementSelectMenuName: {
                mApplicationLogic.onMenuNameChanged(charSequence.toString());
                break;
            }
            case R.id.idMenuManagementSelectPortionSize: {
                mApplicationLogic.onPortionSizeChanged(charSequence.toString());
                break;
            }
        }
    }

    /**
     * Never used in our application.
     *
     * @param charSequence
     * @param i
     * @param i1
     * @param i2
     */
    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }

    /**
     * Never used in our application.
     *
     * @param editable
     */
    @Override
    public void afterTextChanged(Editable editable) {
    }
}