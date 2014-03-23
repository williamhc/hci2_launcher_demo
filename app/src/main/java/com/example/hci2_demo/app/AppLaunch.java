package com.example.hci2_demo.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

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
            this.setTitle(nextTrial.searchAnimal.name + " - " + nextTrial.treatment.toString());
            getFragmentManager().beginTransaction()
                    .replace(R.id.container, new PreTrialFragment(this, getApplicationContext(), false))
                    .commit();
        }
        else {
            sendOffData();
            getFragmentManager().beginTransaction()
                    .replace(R.id.container, new StartFragment(this, getApplicationContext()))
                    .commit();
        }

    }

    private void sendOffData() {
        String body = this.experiment.getDataReport();

        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"williamhumphreyscloutier@gmail.com"});
        i.putExtra(Intent.EXTRA_SUBJECT, "HCI2 Experiment Complete");
        i.putExtra(Intent.EXTRA_TEXT   , body);
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(AppLaunch.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }

    }

    public void closeKeyboard(EditText editText) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    public void openKeyboard(EditText editText){
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0, InputMethodManager.SHOW_IMPLICIT);
    }
}
