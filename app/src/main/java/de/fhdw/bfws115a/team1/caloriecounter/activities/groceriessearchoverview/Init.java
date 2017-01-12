package de.fhdw.bfws115a.team1.caloriecounter.activities.groceriessearchoverview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

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

    //TODO Was macht dise Methode?
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case ResultCodes.SELECT_AMOUNT:
                    mApplicationLogic.onSelectAmountResult(data);
                    break;
                case ResultCodes.RELOAD:
                    mApplicationLogic.reload();
                    break;
            }
        }
    }
}