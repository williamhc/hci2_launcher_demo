package com.example.hci2_demo.app;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.TextView;


public class AppLaunch extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_launch);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new FittsFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.app_launch, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public class FittsFragment extends Fragment {

        public String[] animals;

        public FittsFragment() {
            animals = new String[]{"Aardvark", "Albatross", "Alligator", "Alpaca", "Ant",
                                    "Anteater", "Antelope", "Ape", "Armadillo"};
        }

        public void buttonWasClicked(View view){
            System.out.println("OHAI");
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fitts_wheel, container, false);
            final Fragment f;
            f = this;
            for (int i = 0; i < animals.length; i++) {
                Button animal_string;
                View.OnClickListener l;

                animal_string = new Button(getApplicationContext());
                animal_string.setText(animals[i]);
                animal_string.setWidth(250);
                animal_string.setHeight(250);
                animal_string.setPadding(30, 30, 30, 30);

                l = new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ((FittsFragment)f).buttonWasClicked(view);
                    }
                };
                animal_string.setOnClickListener(l);

                rootView.addView(animal_string);
            }
            return rootView;
        }
    }
}
