package de.fhdw.bfws115a.team1.caloriecounter.activities.dailyoverview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * @author Viktor Schroeder.
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
     * //TODO was macht diese Methode????
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case ResultCodes.NEWENTRY_RESULT:
                    mApplicationLogic.onEntrySelected(data);
                    break;
                case ResultCodes.CALENDAR_RESULT:
                    mApplicationLogic.onDateChanged(data);
                    break;
                case ResultCodes.COPYTODATE:
                    mApplicationLogic.onCopyDateSelected(data);
                    break;
                case ResultCodes.EDITENTRY:
                    mApplicationLogic.onEntryEdited(data);
                    break;
            }
        }
    }
}