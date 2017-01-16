package de.fhdw.bfws115a.team1.caloriecounter.activities.menumanagement;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import de.fhdw.bfws115a.team1.caloriecounter.R;

public class TextChangeListener implements TextWatcher {

    /* Member variables */
    private ApplicationLogic mApplicationLogic;
    private View mView;

    public TextChangeListener(ApplicationLogic applicationLogic, View view) {
        mApplicationLogic = applicationLogic;
        mView = view;
    }

    /**
     * //TODO Was macht diese Methode?
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
     * //TODO Was macht diese Methode???
     *
     * @param charSequence
     * @param i
     * @param i1
     * @param i2
     */
    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
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
     * //TODO Löschen?
     *
     * @param editable
     */
    @Override
    public void afterTextChanged(Editable editable) {

    }
}