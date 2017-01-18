package de.fhdw.bfws115a.team1.caloriecounter.activities.grocerymanagement;

import android.app.Activity;
import android.os.Bundle;

/**
 * @author Niklas Lammers.
 */
public class Init extends Activity {

    /* Member variables */
    private Data mData;
    private Gui mGui;
    private ApplicationLogic mApplicationLogic;

    /**
     * Initializes the Data.java attributes.
     *
     * @param savedInstanceState Maybe contains non-persistent data.
     */
    private void initData(Bundle savedInstanceState) {
        mData = new Data(savedInstanceState, this);
    }

    /**
     * Initializes the Gui.java.
     */
    private void initGui() {
        mGui = new Gui(this);
    }

    /**
     * Initializes the ApplicationLogic.java.
     */
    private void initApplicationLogic() {
        mApplicationLogic = new ApplicationLogic(mData, mGui);
    }

    /**
     * Method initializes the current activity.
     *
     * @param savedInstanceState Maybe contains non-persistent data.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData(savedInstanceState);
        initGui();
        initApplicationLogic();
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
}