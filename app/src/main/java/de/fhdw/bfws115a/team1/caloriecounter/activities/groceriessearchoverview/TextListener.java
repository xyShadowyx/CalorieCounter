package de.fhdw.bfws115a.team1.caloriecounter.activities.groceriessearchoverview;

import android.widget.SearchView.OnQueryTextListener;

public class TextListener implements OnQueryTextListener {

    /* Member variables */
    private ApplicationLogic mApplicationLogic;

    public TextListener(ApplicationLogic applicationLogic) {
        mApplicationLogic = applicationLogic;
    }

    //TODO Was macht diese Methode?
    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    //TODO Was macht diese Methode?
    @Override
    public boolean onQueryTextChange(String s) {
        mApplicationLogic.filterListByName(s);
        return false;
    }
}