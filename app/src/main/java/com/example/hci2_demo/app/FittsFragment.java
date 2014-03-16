package com.example.hci2_demo.app;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.R;

import java.util.Calendar;
import experiment.Trial;

/**
 * A fragment for Fitts' wheel.
 */
public class FittsFragment extends LauncherFragment {
    private Trial trial;
    private int numErrors;
    private Calendar time;
    private char[] alphabet;

    public FittsFragment(Context context, Trial trial){
        super(context);
        this.trial = trial;
        numErrors = 0;
        time = Calendar.getInstance();
        alphabet = new char[] {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    }

    public int getLayoutID(){
        return R.layout.fitts_wheel;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(this.getLayoutID(), container, false);

        final Fragment f;
        f = this;

        return rootView;
    }

    private void setButtonListeners(ViewGroup rootView, final Fragment f) {
        GridView animalGrid = (GridView) rootView.findViewById(R.id.buttonsGrid);

        for (int i = 0; i < trial.allAnimals.length; i++) {
            ImageButton animal_string;
            View.OnClickListener l;

            animal_string = new ImageButton(context);
            animal_string.setImageDrawable(trial.allAnimals[i].img);
            animal_string.setPadding(30, 30, 30, 30);

            l = new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((FittsFragment)f).appWasTapped(view);
                }
            };
            animal_string.setOnClickListener(l);

            animalGrid.addView(animal_string);
        }
    }

    public void setAlphabetButtonListeners(ViewGroup rootView, final Fragment f) {
        GridView alphaGrid = (GridView) rootView.findViewById(R.id.alphaGrid);

        for (int i = 0; i < alphabet.length; i++) {
            Button animal_string;
            View.OnClickListener l;

            animal_string = new Button(context);
            animal_string.setText(alphabet[i]);


            l = new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((FittsFragment)f).appWasTapped(view);
                }
            };
            animal_string.setOnClickListener(l);

            alphaGrid.addView(animal_string);
        }
    }

}
