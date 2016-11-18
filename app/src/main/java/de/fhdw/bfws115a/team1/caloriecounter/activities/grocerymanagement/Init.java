package de.fhdw.bfws115a.team1.caloriecounter.activities.grocerymanagement;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Florian on 13.11.2016.
 */
public class Init extends Activity {

    private Data mData;
    private Gui mGui;
    private ApplicationLogic mApplicationLogic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData(savedInstanceState);
        initGui();
        initApplicationLogic();
    }

    private void initData(Bundle savedInstanceState) {
        mData = new Data(savedInstanceState, this);
    }

    private void initGui() {
        mGui = new Gui(this);
    }

    private void initApplicationLogic() {
        mApplicationLogic = new ApplicationLogic(mData, mGui);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        mData.saveDataInBundle(outState);
        super.onSaveInstanceState(outState);
    }

}