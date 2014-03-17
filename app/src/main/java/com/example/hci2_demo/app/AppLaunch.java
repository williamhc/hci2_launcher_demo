package com.example.hci2_demo.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import experiment.Experiment;
import experiment.Trial;

public class AppLaunch extends Activity {
    public Experiment experiment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_launch);
        getFragmentManager().beginTransaction()
                .replace(R.id.container, new StartFragment(this, getApplicationContext()))
                .commit();
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

    public void startNextTrial() {
        Trial nextTrial = this.experiment.nextTrial();

        if (nextTrial != null) {
            getFragmentManager().beginTransaction()
                    .replace(R.id.container, new PreTrialFragment(this, getApplicationContext()))
                    .commit();
        }
        else {
            getFragmentManager().beginTransaction()
                    .replace(R.id.container, new StartFragment(this, getApplicationContext()))
                    .commit();
        }

    }
}
