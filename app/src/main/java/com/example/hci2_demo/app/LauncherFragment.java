package com.example.hci2_demo.app;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public abstract class LauncherFragment extends Fragment {
    public String[] animals;
    public Context context;
    public abstract int getLayoutID();

    public LauncherFragment(Context context) {
        this.context = context;
        animals = new String[]{"Aardvark", "Albatross", "Alligator", "Alpaca", "Ant",
                "Anteater", "Antelope", "Ape", "Armadillo"};
    }

    public void appWasTapped(View view) {
        System.out.println("OHAI");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(this.getLayoutID(), container, false);
        final Fragment f;
        f = this;
        for (int i = 0; i < animals.length; i++) {
            Button animal_string;
            View.OnClickListener l;

            animal_string = new Button(context);
            animal_string.setText(animals[i]);
            animal_string.setWidth(250);
            animal_string.setHeight(250);
            animal_string.setPadding(30, 30, 30, 30);

            l = new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((FittsFragment)f).appWasTapped(view);
                }
            };
            animal_string.setOnClickListener(l);

            rootView.addView(animal_string);
        }
        return rootView;
    }
}

