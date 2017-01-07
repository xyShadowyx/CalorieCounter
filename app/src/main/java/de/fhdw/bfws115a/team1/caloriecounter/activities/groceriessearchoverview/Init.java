package de.fhdw.bfws115a.team1.caloriecounter.activities.groceriessearchoverview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

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

