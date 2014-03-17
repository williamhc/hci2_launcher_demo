package com.example.hci2_demo.app;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
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

        ArrayList<View> rows = new ArrayList<View>(createLauncherRows(icons));
        final AppButtonArrayAdapter adapter = new AppButtonArrayAdapter(this.context, rows);
        FastSearchListView lv = (FastSearchListView) rootView.findViewById(R.id.fast);
        lv.setAdapter(adapter);

        return rootView;
    }
}
