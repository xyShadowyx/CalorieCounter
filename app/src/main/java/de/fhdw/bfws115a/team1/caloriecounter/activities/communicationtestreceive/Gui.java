package de.fhdw.bfws115a.team1.caloriecounter.activities.communicationtestreceive;

import android.widget.SeekBar;
import android.widget.TextView;
import de.fhdw.bfws115a.team1.caloriecounter.R;

public class Gui {

    private TextView mDummyTextView;

    public Gui(Init activity) {
        activity.setContentView(R.layout.rec);
        mDummyTextView = (TextView) activity.findViewById(R.id.idTextRec);
    }

    public TextView getDummyTextView() {
        return mDummyTextView;
    }
}
