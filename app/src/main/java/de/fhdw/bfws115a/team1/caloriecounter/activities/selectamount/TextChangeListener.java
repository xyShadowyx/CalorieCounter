package de.fhdw.bfws115a.team1.caloriecounter.activities.selectamount;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import de.fhdw.bfws115a.team1.caloriecounter.R;
import org.w3c.dom.Text;

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
        mApplicationLogic.onAmountChanged(charSequence.toString());
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
