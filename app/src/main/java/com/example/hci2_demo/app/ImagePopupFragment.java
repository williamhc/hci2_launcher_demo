package com.example.hci2_demo.app;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import experiment.Animal;

/**
 * Created by alumbs on 2014-03-23.
 */
public class ImagePopupFragment extends Fragment{
    private Context context;
    private AppLaunch appLaunch;
    private Animal animal;
    private int numClick;
    public ImagePopupFragment(Context context, AppLaunch appLaunch, Animal animal)
    {
        this.context = context;
        this.appLaunch = appLaunch;
        this.animal = animal;
        numClick = 0;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_image_popup, container, false);

        ImageView imageView = (ImageView) rootView.findViewById(R.id.imageView);
        TextView animalName = (TextView) rootView.findViewById(R.id.textView);
        Button nextTrial = (Button) rootView.findViewById(R.id.button);

        if(this.animal != null)
        {
            imageView.setImageDrawable(animal.img);
            animalName.setText("You selected " + animal.name);
            nextTrial.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //This is here so startNextTrial can only be called once
                    if(numClick == 0) {
                        numClick++;
                        appLaunch.startNextTrial();
                    }
                }
            });
        }
        else
        {
            animalName.setText("The animal you selected could not be found");
        }

        return rootView;
    }
}
