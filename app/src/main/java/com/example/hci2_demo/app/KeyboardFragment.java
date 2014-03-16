package com.example.hci2_demo.app;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

import experiment.Trial;

public class KeyboardFragment extends LauncherFragment {
    private Trial trial;
    private Activity appLaunch;

    public KeyboardFragment(AppLaunch appLaunch, Context context) {
        super(appLaunch, context);
        this.appLaunch = appLaunch;
    }

//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        super.onCreateView(inflater, container, savedInstanceState);
//        ViewGroup rootView = (ViewGroup) inflater.inflate(this.getLayoutID(), container, false);
////        Button keyboardBtn = (Button) rootView.findViewById(R.id.keyboard);
////
////        View.OnClickListener keyboardListener = new View.OnClickListener() {
////            public void onClick(View view) {
////                InputMethodManager imm = (InputMethodManager) appLaunch.getSystemService(Context.INPUT_METHOD_SERVICE);
////                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);
////            }
////        };
////
////        keyboardBtn.setOnClickListener(keyboardListener);
////
//        return rootView;
//    }

    public int getLayoutID() {
        return R.layout.keyboard_search;
    }


}
