package com.example.hci2_demo.app;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

/**
 * A collection of four animal icons
 */
public class LauncherRow extends LinearLayout{
    public LauncherRow(Context context, View[] textViews) {
        super(context);
        for (int i = 0; i < 4; i++) {
            if(textViews[i] != null)
                this.addView(textViews[i]);
        }
    }
}

