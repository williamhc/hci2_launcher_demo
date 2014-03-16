package com.example.hci2_demo.app;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
    }

    public int getLayoutID(){
        return R.layout.fitts_wheel;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(this.getLayoutID(), container, false);

        return rootView;
    }

//    private void setButtonListeners(ViewGroup rootView, final Fragment f) {
//        GridView animalGrid = (GridView) rootView.findViewById();
//
//        for (int i = 0; i < trial.allAnimals.length; i++) {
//            ImageButton animal_string;
//            View.OnClickListener l;
//
//            animal_string = new ImageButton(context);
//            animal_string.setImageDrawable(trial.allAnimals[i].img);
//            animal_string.setPadding(30, 30, 30, 30);
//
//            l = new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    ((FittsFragment)f).appWasTapped(view);
//                }
//            };
//            animal_string.setOnClickListener(l);
//
//            animalGrid.addView(animal_string);
//        }
//    }


}
