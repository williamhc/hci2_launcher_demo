package com.example.hci2_demo.app;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import experiment.Trial;

public class KeyboardFragment extends LauncherFragment {
    private Trial trial;
    private Activity appLaunch;
    private int count;

    public KeyboardFragment(AppLaunch appLaunch, Context context) {
        super(appLaunch, context);
        this.appLaunch = appLaunch;
        count = 0;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        final ViewGroup rootView = (ViewGroup) inflater.inflate(this.getLayoutID(), container, false);
        EditText appFilterText = (EditText) rootView.findViewById(R.id.editText);

        appFilterText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                //Do nothing
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                //Go through the list of apps, find those that match
                //just display one image at a time
                updateListView(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                //Do nothing
            }

            private void updateListView(CharSequence filterText)
            {
                List<View> newList = new ArrayList<View>();
                //Update List view with new objects
                for(int i = 0; i < icons.size(); i++)
                {
                    TextView tv = (TextView)icons.get(i);
                    String tvText = tv.getText().toString().toLowerCase();
                    String filter = filterText.toString().toLowerCase();
                    /*newList.add(icons.get(i));*/
                    if((tvText.startsWith(filter)))
                    {
                        //rootView.removeAllViews();
                        newList.add(icons.get(i));
                    }
                }

                //Code below works
                ArrayList<View> rows = new ArrayList<View>(createLauncherRows(newList));
                final AppButtonArrayAdapter adapter = new AppButtonArrayAdapter(context, rows);
                ListView lv = (ListView) rootView.findViewById(R.id.listView);
                lv.setAdapter(adapter);
            }
        });

        ArrayList<View> rows = new ArrayList<View>(createLauncherRows(icons));
        final AppButtonArrayAdapter adapter = new AppButtonArrayAdapter(this.context, rows);
        ListView lv = (ListView) rootView.findViewById(R.id.listView);
        lv.setAdapter(adapter);
        return rootView;
    }

    public int getLayoutID() {
        return R.layout.keyboard_search;
    }


}
