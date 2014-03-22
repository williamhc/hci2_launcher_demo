package com.example.hci2_demo.app;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.EventLog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import experiment.Treatment;
import experiment.Trial;

/**
 * A fragment that shows the user the app they will launch next
 */
public class BreakFragment extends Fragment {
    private AppLaunch appLaunch;
    public Context context;

    public BreakFragment(AppLaunch appLaunch, Context context) {
        this.appLaunch = appLaunch;
        this.context = context;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.break_between, container, false);

        Button continueButton = (Button) rootView.findViewById(R.id.continuebtn);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, new PreTrialFragment(appLaunch, context, true))
                        .commit();
            }
        });

        return rootView;
    }
}
