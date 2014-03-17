package com.example.hci2_demo.app;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by alumbs on 16/03/14.
 */
public class AppDrawerFragment extends LauncherFragment {
    private Context context;

    public AppDrawerFragment(AppLaunch appLaunch, Context context) {
        super(appLaunch, context);
    }

    @Override
    public int getLayoutID() {
        return R.layout.fragment_app_drawer;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_app_drawer, container, false);

        ArrayList<View> rows = new ArrayList<View>(createLauncherRows(icons));
        final AppButtonArrayAdapter adapter = new AppButtonArrayAdapter(this.context, rows);
        ListView lv = (ListView) rootView.findViewById(R.id.listView);
        lv.setAdapter(adapter);

        return rootView;
    }
}
