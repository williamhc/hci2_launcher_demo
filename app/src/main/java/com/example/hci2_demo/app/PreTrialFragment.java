package com.example.hci2_demo.app;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import experiment.Treatment;
import experiment.Trial;

/**
 * A fragment that shows the user the app they will launch next
 */
public class PreTrialFragment extends Fragment {
    private Trial trial;
    private AppLaunch appLaunch;
    public Context context;

    public PreTrialFragment(AppLaunch appLaunch, Context context) {
        this.appLaunch = appLaunch;
        this.context = context;
        this.trial = appLaunch.experiment.currentTrial();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.prep_screen, container, false);

        Button startButton = (Button) rootView.findViewById(R.id.button);
        addListenerToStartButton(startButton);

        TextView animalName = (TextView)rootView.findViewById(R.id.textView);
        animalName.setText(trial.searchAnimal.name);

        ImageView iv = (ImageView)rootView.findViewById(R.id.imageView);
        iv.setImageDrawable(this.trial.searchAnimal.img);

        Treatment treatment = this.trial.treatment;
        TextView trialInfo = (TextView)rootView.findViewById(R.id.trialInfo);
        trialInfo.setText(treatment.Technique() + ", " + treatment.AppsInstalled() +
                " total apps, " + (treatment.IsFrequentlyUsed() ? "": "in") + "frequent apps");
        return rootView;
    }

    public void addListenerToStartButton(Button button) {
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, getFragForTrial())
                    .commit();
            }
        });
    }

    private Fragment getFragForTrial() {
        String technique = trial.treatment.Technique();
        if (technique.equals("Fitts' Wheel"))
            return new FittsFragment(appLaunch, context);
        else if (technique.equals("GPS Launcher"))
            return new GPSLauncherFragment(context);
        else if (technique.equals("Keyboard Search")) {
            return new KeyboardFragment(appLaunch, context);
        }

        return new PreTrialFragment(appLaunch, context);
    }
}
