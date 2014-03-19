package com.example.hci2_demo.app;

import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import experiment.Animal;

/**
 * Created by alumbs on 15/03/14.
 */
public class GPSLauncherFragment extends LauncherFragment {
    private final int MAIN_PAGE = 16;
    private List<View> mainScreen;


    public GPSLauncherFragment(AppLaunch appLaunch, Context context) {
        super(appLaunch, context);
        this.mainScreen = new ArrayList<View>();
    }

    @Override
    public int getLayoutID() {
        return R.layout.fragment_gps_launcher;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_gps_launcher, container, false);

        TextView locationName = (TextView) rootView.findViewById(R.id.locationTextView);
        locationName.setText("Uncategorized location");

        ImageButton appDrawer = new ImageButton(context);
        Drawable appDrawerble = getResources().getDrawable(R.drawable.zzzappdrawer);
        appDrawer.setImageDrawable(appDrawerble);
        //System.out.println("DEBUG: the appDrawer button is: " + appDrawer);
        appDrawer.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.container, new AppDrawerFragment(appLaunch, context));
                ft.commit();
                return true;
            }
        });

        for (int i = 0; i < MAIN_PAGE - 1; i++) {
            TextView animalButton;
            View.OnTouchListener l;
            Animal animal = this.trial.allAnimals[i];

            animalButton = new TextView(context);
            animalButton.setText(animal.name.substring(0, 1).toUpperCase() + animal.name.substring(1));
            animalButton.setCompoundDrawablesWithIntrinsicBounds(0, animal.img_id, 0, 0);
            animalButton.setPadding(30, 30, 30, 30);
            final LauncherFragment f = this;
            final int finalI = i;
            l = new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    Animal animal = f.trial.allAnimals[finalI];
                    ((LauncherFragment)f).appWasTapped(animal);
                    return true;
                }
            };
            animalButton.setOnTouchListener(l);

            this.mainScreen.add(animalButton);
        }

        this.mainScreen.add(appDrawer);

        ArrayList<View> rows = new ArrayList<View>(createLauncherRows(mainScreen));
        final AppButtonArrayAdapter adapter = new AppButtonArrayAdapter(this.context, rows);
        ListView lv = (ListView) rootView.findViewById(R.id.listView);
        lv.setAdapter(adapter);

        return rootView;
    }
}
