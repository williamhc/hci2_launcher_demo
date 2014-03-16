package com.example.hci2_demo.app;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
        return super.onCreateView(inflater, container, savedInstanceState);

//        final StableArrayAdapter = new StableArrayAdapter(this.context, R.id.listView, this.icons);
    }
}
