package com.example.hci2_demo.app;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import experiment.Trial;

/**
 * Created by alumbs on 15/03/14.
 */
public class GPSLauncherFragment extends Fragment {
    public Context context;
    public Trial trial;

    public GPSLauncherFragment(Context appContext)
    {
        this.context = appContext;
        //this.trial = trial;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_gps_launcher, container, false);

        TextView locationName = (TextView) rootView.findViewById(R.id.locationTextView);
        locationName.setText("Uncategorized location");

        ImageButton appDrawer = (ImageButton) rootView.findViewById(R.id.imageButton4);
        //System.out.println("DEBUG: the appDrawer button is: " + appDrawer);
        appDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();

                ft.replace(R.id.container, new AppDrawerFragment(context));
                ft.commit();
            }
        });

        return rootView;
    }
}
