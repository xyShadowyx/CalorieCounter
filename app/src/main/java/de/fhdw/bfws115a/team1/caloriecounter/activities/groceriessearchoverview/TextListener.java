package de.fhdw.bfws115a.team1.caloriecounter.activities.groceriessearchoverview;

import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;

import org.w3c.dom.Text;

/**
 * Created by xySha on 23.11.2016.
 */
public class TextListener implements OnQueryTextListener {
    private ApplicationLogic mApplicationLogic;
    public TextListener(ApplicationLogic applicationLogic) {
        mApplicationLogic = applicationLogic;
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        mApplicationLogic.filterListByName(s);
        return false;
    }
}
