package de.fhdw.bfws115a.team1.caloriecounter.activities.menumanagement;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * @author Niklas Lammers and Florian Obladen.
 */
public class Init extends Activity {

    /* Member variables */
    private Data mData;
    private Gui mGui;
    private ApplicationLogic mApplicationLogic;

    /**
     * Method initializes the current activity.
     *
     * @param savedInstanceState Contains non-persistent data.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData(savedInstanceState);
        initGui();
        initApplicationLogic();
    }

    /**
     * Initializes data attributes by retrieving saved non-persistent data.
     *
     * @param savedInstanceState Contains non-persistent data.
     */
    private void initData(Bundle savedInstanceState) {
        mData = new Data(savedInstanceState, this);
    }

    /**
     * Initializes the GUI.
     */
    private void initGui() {
        mGui = new Gui(this);
    }

    /**
     * Initializes the application logic.
     */
    private void initApplicationLogic() {
        mApplicationLogic = new ApplicationLogic(mData, mGui);
    }

    /**
     * Saves the current instance state due to risk of loosing non-persistent data.
     *
     * @param outState The non-persistent data.
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        mData.saveDataInBundle(outState);
        super.onSaveInstanceState(outState);
    }

    /**
     * See activity's onActivityResult.
     * E.g. you start a specific activity and get a result as an Intent-object back.
     * In this case the result will be a FixGrocery entity which will be retrieved and
     * ultimately added to a menu.
     *
     * @param requestCode The request code.
     * @param resultCode  The result code.
     * @param data        The intent-object.
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case ResultCodes.SELECT_GROCERY:
                    mApplicationLogic.onFixGrocerySelected(data);
                    break;
            }
        }
    }
}