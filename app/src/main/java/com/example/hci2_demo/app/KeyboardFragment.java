package com.example.hci2_demo.app;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ListView;

import experiment.Trial;

public class KeyboardFragment extends LauncherFragment {
    private Trial trial;
    private Activity appLaunch;

    public KeyboardFragment(AppLaunch appLaunch, Context context) {
        super(appLaunch, context);
        this.appLaunch = appLaunch;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        ViewGroup rootView = (ViewGroup) inflater.inflate(this.getLayoutID(), container, false);

        final AppButtonArrayAdapter adapter = new AppButtonArrayAdapter(this.context, this.icons);
//        adapter.notifyDatasetChanged();
        ListView lv = (ListView) rootView.findViewById(R.id.listView);
        lv.setAdapter(adapter);

        return rootView;
    }

    public int getLayoutID() {
        return R.layout.keyboard_search;
    }


}
