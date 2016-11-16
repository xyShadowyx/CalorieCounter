package de.fhdw.bfws115a.team1.caloriecounter.activities.spinner;

import android.widget.Spinner;
import de.fhdw.bfws115a.team1.caloriecounter.R;

public class Gui {

    private Spinner mSpinner;

    public Gui(Init activity) {
        activity.setContentView(R.layout.activitiy_spinnertest);

        mSpinner = (Spinner) activity.findViewById(R.id.spinner);
    }

    public Spinner getSpinner() {
        return mSpinner;
    }
}
