package de.fhdw.bfws115a.team1.caloriecounter.activities.calendar;

import android.app.Activity;
import android.content.Intent;

public class ApplicationLogic {

    private Data mData;
    private Gui mGui;

    public ApplicationLogic(Data data, Gui gui) {
        mData = data;
        mGui = gui;
        initGui();
        initListener();
    }

    private void initGui() {
        mGui.setSelectedDate(mData.getSelectedYear(), mData.getSelectedMonth(), mData.getSelectedDay());
    }

    private void initListener() {
        DateChangeListener dcl = new DateChangeListener(this);

        mGui.getCalendarView().setOnDateChangeListener(dcl);
    }

    public void onDateSelect(int year, int month, int day) {
        mGui.setSelectedDate(year, month, day);
        mData.setSelectedYear(year);
        mData.setSelectedMonth(month);
        mData.setSelectedDay(day);

        Intent resultIntent = new Intent();
        resultIntent.putExtra("year", year);
        resultIntent.putExtra("month", month);
        resultIntent.putExtra("day", day);
        mData.getActivity().setResult(Activity.RESULT_OK, resultIntent);
        mData.getActivity().finish();
    }
}
