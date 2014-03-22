package com.example.hci2_demo.app;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import experiment.Animal;
import experiment.Trial;

public abstract class LauncherFragment extends Fragment {
    final AppLaunch appLaunch;
    public Context context;
    Trial trial;
    private int numErrors;
    private long startTime;
    List<View> icons;
    int ICON_PADDING = 25;
    boolean isComplete = false;
    long timeLastAnimalTapped = 0;
    String lastAnimalTapped = "";

    public abstract int getLayoutID();

    public LauncherFragment(AppLaunch appLaunch, Context context) {
        this.icons = new ArrayList<View>();
        this.context = context;
        this.appLaunch = appLaunch;
        this.trial = this.appLaunch.experiment.currentTrial();
        this.numErrors = 0;
        this.startTime = Calendar.getInstance().getTimeInMillis();
    }

    public void appWasTapped(Animal animal, MotionEvent event) {
        System.out.println("Launcher Fragment");

//        int action = MotionEventCompat.getActionMasked(event);
//
//        switch(action) {
//            case (MotionEvent.ACTION_DOWN) :
//                System.out.println("Action was DOWN");
//                break;
//            case (MotionEvent.ACTION_MOVE) :
//                System.out.println("Action was MOVE");
//                break;
//            case (MotionEvent.ACTION_UP) :
//                System.out.println("Action was UP");
//                break;
//            case (MotionEvent.ACTION_CANCEL) :
//                System.out.println("Action was CANCEL");
//                break;
//            case (MotionEvent.ACTION_OUTSIDE) :
//                System.out.println("Movement occurred outside bounds " +
//                        "of current screen element");
//                break;
//        }
        long currentTimeInMillis = Calendar.getInstance().getTimeInMillis();
        long timeDifferenceSeconds = TimeUnit.MILLISECONDS.toSeconds(currentTimeInMillis - timeLastAnimalTapped);
        timeLastAnimalTapped = currentTimeInMillis;
        if (this.trial.searchAnimal.name.equals(animal.name)){
            if (!isComplete) {
                trial.timeTaken = TimeUnit.MILLISECONDS.toSeconds(currentTimeInMillis - this.startTime);
                this.appLaunch.startNextTrial();
                isComplete = true;
            }
        } else if (timeDifferenceSeconds > 5 || !lastAnimalTapped.equals(animal.name))  {
            lastAnimalTapped = animal.name;
            this.trial.numOfErrors += 1;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(this.getLayoutID(), container, false);

        for (int i = 0; i < this.trial.allAnimals.length; i++) {
            TextView animalButton;
            View.OnTouchListener l;
            Animal animal = this.trial.allAnimals[i];

            animalButton = new TextView(context);
            animalButton.setText(animal.name.substring(0, 1).toUpperCase() + animal.name.substring(1));
            animalButton.setCompoundDrawablesWithIntrinsicBounds(0, animal.img_id, 0, 0);
            animalButton.setPadding(ICON_PADDING, ICON_PADDING, ICON_PADDING, ICON_PADDING);
            final LauncherFragment f = this;
            final int finalI = i;
            l = new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    Animal animal = f.trial.allAnimals[finalI];
                    ((LauncherFragment)f).appWasTapped(animal, motionEvent);
                    return true;
                }
            };
            animalButton.setOnTouchListener(l);

            this.icons.add(animalButton);
        }

        return rootView;
    }

    public List<LauncherRow> createLauncherRows(List<View> views){
        ArrayList<LauncherRow> rows = new ArrayList<LauncherRow>();

        for (int i = 0; i < views.size(); i+=4) {
            View[] rowViews = new View[4];
            for (int j = 0; j < 4; j++) {
                if (i + j < views.size())
                    rowViews[j] = views.get(i+j);
            }
            rows.add(new LauncherRow(this.context, rowViews));
        }

        return rows;
    }
}

