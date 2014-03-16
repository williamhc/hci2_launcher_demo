package com.example.hci2_demo.app;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;

import experiment.Experiment;
import experiment.Trial;

/**
 * A fragment that shows the user the app they will launch next
 */
public class PreTrialFragment extends Fragment {
    private Trial trial;
    private Experiment experiment;
    public Context context;

    public PreTrialFragment(Experiment experiment, Context context) {
        this.experiment = experiment;
        this.context = context;
        this.trial = experiment.nextTrial();
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
        return rootView;
    }

    public void addListenerToStartButton(Button button) {
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                // Replace the container with the new fragment
                ft.replace(R.id.container, new PreTrialFragment(experiment, context));
                // or ft.add(R.id.your_placeholder, new FooFragment());
                // Execute the changes specified
                ft.commit();
            }
        });
    }
}
