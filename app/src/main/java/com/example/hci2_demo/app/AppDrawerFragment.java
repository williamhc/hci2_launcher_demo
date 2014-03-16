package com.example.hci2_demo.app;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by alumbs on 16/03/14.
 */
public class AppDrawerFragment extends Fragment {
    private Context context;

    public AppDrawerFragment(Context appContext)
    {
        this.context = appContext;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_app_drawer, container, false);

        return rootView;
    }
}
