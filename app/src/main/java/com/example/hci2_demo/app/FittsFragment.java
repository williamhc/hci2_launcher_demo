package com.example.hci2_demo.app;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A fragment for Fitts' wheel.
 */
public class FittsFragment extends LauncherFragment {

    public FittsFragment(AppLaunch appLaunch, Context context){
        super(appLaunch, context);
    }

    public int getLayoutID(){
        return R.layout.fitts_wheel;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) super.onCreateView(inflater, container, savedInstanceState);

        // if its on the first page, doesn't work
        // if we scroll, then it works

        ArrayList<View> rows = new ArrayList<View>(createLauncherRows(icons));
        for (int i = 0; i < rows.size(); i++) {
            ViewGroup row = (ViewGroup) rows.get(i);
            row.setPadding(0, 0, 50, 0);
        }
        final AppButtonArrayAdapter adapter = new AppButtonArrayAdapter(this.context, rows);
        FastSearchListView lv = (FastSearchListView) rootView.findViewById(R.id.fast);
        lv.setAdapter(adapter);

        return rootView;
    }
}
