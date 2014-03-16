package com.example.hci2_demo.app;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

import experiment.Animal;
import experiment.Trial;

public abstract class LauncherFragment extends Fragment {
    private final AppLaunch appLaunch;
    public Context context;
    private Trial trial;
    private int numErrors;
    private Calendar startTime;
    ArrayList<View> icons;

    public abstract int getLayoutID();

    public LauncherFragment(AppLaunch appLaunch, Context context) {
        this.icons = new ArrayList<View>();
        this.context = context;
        this.appLaunch = appLaunch;
        this.trial = this.appLaunch.experiment.currentTrial();
        this.numErrors = 0;
        this.startTime = Calendar.getInstance();
    }

    public void appWasTapped(Animal animal) {
        if (animal == this.trial.searchAnimal){
            Calendar now = Calendar.getInstance();
            trial.timeTaken = now.getTimeInMillis() - this.startTime.getTimeInMillis();
            this.appLaunch.startNextTrial();
        } else {
            this.trial.numOfErrors += 1;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(this.getLayoutID(), container, false);

//        GridView animalGrid = (GridView) rootView.findViewById(R.id.gr);

        for (int i = 0; i < this.trial.allAnimals.length; i++) {
            TextView animalButton;
            View.OnClickListener l;
            Animal animal = this.trial.allAnimals[i];

            animalButton = new TextView(context);
            animalButton.setText(animal.name.substring(0, 1).toUpperCase() + animal.name.substring(1));
            animalButton.setCompoundDrawablesWithIntrinsicBounds(0, animal.img_id, 0, 0);
            animalButton.setPadding(30, 30, 30, 30);
            final LauncherFragment f = this;
            final int finalI = i;
            l = new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Animal animal = f.trial.allAnimals[finalI];
                    ((LauncherFragment)f).appWasTapped(animal);
                }
            };
            animalButton.setOnClickListener(l);

            this.icons.add(animalButton);
        }

        return rootView;
    }
}

