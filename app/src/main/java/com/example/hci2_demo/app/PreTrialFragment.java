package com.example.hci2_demo.app;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;

import experiment.Trial;

/**
 * A fragment that shows the user the app they will launch next
 */
public class PreTrialFragment extends Fragment {
    private Trial trial;
    public Context context;

    public PreTrialFragment(Context context, Trial trial) {
        this.context = context;
        this.trial = trial;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.prep_screen, container, false);

        TextView animalName = (TextView)rootView.findViewById(R.id.textView);
        animalName.setText(trial.searchAnimal.name);

        ImageView iv = (ImageView)rootView.findViewById(R.id.imageView);
        iv.setImageDrawable(this.trial.searchAnimal.img);
        return rootView;
    }
}
