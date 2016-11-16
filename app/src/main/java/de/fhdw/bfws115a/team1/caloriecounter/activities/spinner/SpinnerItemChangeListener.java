package de.fhdw.bfws115a.team1.caloriecounter.activities.spinner;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by Niklas on 16.11.2016.
 */
public class SpinnerItemChangeListener implements Spinner.OnItemSelectedListener {

    public Init mActivity;

    public SpinnerItemChangeListener(Init activity) {
        mActivity = activity;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Context context = mActivity.getApplicationContext();
        String selItem = (String) adapterView.getSelectedItem(); //
        Toast toast = Toast.makeText(context, "ItemSelected: " + i + " - " + l + ": " + selItem, Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


}
