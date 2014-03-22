package com.example.hci2_demo.app;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import experiment.Experiment;

public class StartFragment extends Fragment {
    private AppLaunch appLaunch;
    private Context context;
    private int participantNum = 0;

    public StartFragment(AppLaunch appLaunch, Context context){
        this.appLaunch = appLaunch;
        this.context = context;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.start_screen, container, false);
        Button fitts = (Button) rootView.findViewById(R.id.fitts);
        Button keyboard = (Button) rootView.findViewById(R.id.keyboard);
        Button location = (Button) rootView.findViewById(R.id.location);
        Button start = (Button) rootView.findViewById(R.id.begin);

        start.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Experiment experiment = new Experiment(context, 60, "ALL", 5, participantNum);
                appLaunch.experiment = experiment;
                appLaunch.startNextTrial();
            }
        });

        location.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Experiment experiment = new Experiment(context, 4, "GPS Launcher", 1, participantNum);
                appLaunch.experiment = experiment;
                appLaunch.startNextTrial();
            }
        });

        keyboard.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Experiment experiment = new Experiment(context, 4, "Keyboard Search", 1, participantNum);
                appLaunch.experiment = experiment;
                appLaunch.startNextTrial();
            }
        });

        fitts.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Experiment experiment = new Experiment(context, 4, "Fitts' Wheel", 1, participantNum);
                appLaunch.experiment = experiment;
                appLaunch.startNextTrial();
            }
        });

        EditText appFilterText = (EditText) rootView.findViewById(R.id.partNum);

        appFilterText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                try {
                    participantNum = Integer.parseInt(charSequence.toString());
                }
                catch(Exception e) {

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        return rootView;
    }
}
