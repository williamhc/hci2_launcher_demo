package com.example.hci2_demo.app;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * A collection of four animal icons
 */
public class LauncherRow extends LinearLayout{
    public LauncherRow(Context context, View[] textViews) {
        super(context);
        //this.removeAllViews();
        for (int i = 0; i < 4; i++) {
            if(textViews[i] != null)
            {
                View v = textViews[i];
                ViewGroup p = (ViewGroup) v.getParent();
                if(p != null)
                {
                    p.removeView(v);
                }
                this.addView(v);
            }
        }
    }
}

