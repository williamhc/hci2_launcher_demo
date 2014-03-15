package com.example.hci2_demo.app;

import android.content.Context;

/**
 * A fragment for Fitt's wheel.
 */
public class FittsFragment extends LauncherFragment {
    public FittsFragment(Context context){
        super(context);
    }

    public int getLayoutID(){
        return R.layout.fitts_wheel;
    }

}
