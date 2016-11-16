package de.fhdw.bfws115a.team1.caloriecounter.activities.grocerymanagement;

import android.widget.SeekBar;
import android.widget.TextView;

import de.fhdw.bfws115a.team1.caloriecounter.R;

public class Gui {

    private TextView mDummyTextView;
    private SeekBar mDummySeekBar;

    public Gui(Init activity) {
        activity.setContentView(R.layout.activity_main);

        mDummyTextView = (TextView) activity.findViewById(R.id.idDummyTextView);
        mDummySeekBar = (SeekBar) activity.findViewById(R.id.idDummySeekBar);
    }
}
