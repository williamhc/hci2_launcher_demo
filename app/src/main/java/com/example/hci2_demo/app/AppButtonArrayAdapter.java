package com.example.hci2_demo.app;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;

import java.util.ArrayList;

/**
 * From http://www.vogella.com/tutorials/AndroidListView/article.html
 */

public class AppButtonArrayAdapter extends ArrayAdapter<ImageButton> {
    private final Context context;
    private final ArrayList<ImageButton> values;

    public AppButtonArrayAdapter(Context context, ArrayList<ImageButton> values) {
        super(context, R.id.listView, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return values.get(position);
    }
}

