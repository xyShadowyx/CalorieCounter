package de.fhdw.bfws115a.team1.caloriecounter.activities.quantityunitmanagement;

import android.content.Context;
import android.media.Image;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import static android.R.attr.text;

/**
 * Created by Florian on 08.11.2016.
 */
public class Gui {


    private LinearLayout mLayout;


    private EditText mEditNewQuantityunit;// abfangen wann etwas geändert wird

    private TextView mQuantityunit;

    private ImageView mAddNewQuantityunit;
    private ImageView mDeleteQuantityunit;


    public Gui(Init activity) {
        activity.setContentView(R.layout.quantityunitmanagement);

        mLayout = (LinearLayout) activity.findViewById(R.id.idLinearLayout);
        mEditNewQuantityunit = (EditText) activity.findViewById(R.id.idEditNewQuantityunit);

        mQuantityunit = activity.findViewById(R.id.idQuantityunit);

        mAddNewQuantityunit = (ImageView) activity.findViewById(R.id.idAddQuantityunit);
        mDeleteQuantityunit = (ImageView) activity.findViewById(R.id.idDeleteQuantityunit);


    }

//getter

    public LinearLayout getLayout() {
        return mLayout;
    }

    public EditText getEditNewQuantityunit() {
        return mEditNewQuantityunit;
    }

    public ImageView getAddNewQuantityunit() {
        return mAddNewQuantityunit;
    }

    public ImageView getDeleteQuantityunit() {
        return mDeleteQuantityunit;
    }

    //methods

    public TextView createNewTextView(String text) {
        final ViewGroup.LayoutParams lparams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        final TextView textView = new TextView(this);
        textView.setLayoutParams(lparams);
        textView.setText("New text: " + text);
        return textView;
    }


    public View createNewImageView() {
        final ViewGroup.LayoutParams lparams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        final ImageView imageView = new ImageView(this);
        imageView.setLayoutParams(lparams);
        imageView.setImageResource(R.drawable.plusButton);
        //muss eine Id bekommen mit der einer mengenangabe zugeordnet sein
        return imageView;
    }

}


