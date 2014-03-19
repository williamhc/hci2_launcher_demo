package com.example.hci2_demo.app;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SectionIndexer;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AppButtonArrayAdapter extends ArrayAdapter<View> implements SectionIndexer {
    private final Context context;
    private final ArrayList<View> values;
    private static String sections = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    Map<String, String> letterMappings = new HashMap<String, String>();

    public AppButtonArrayAdapter(Context context, ArrayList<View> values) {
        super(context, R.id.listView, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return values.get(position);
    }

    public int getPositionForSection(int section) {
        return 0;
    }

    public int getSectionForPosition(int arg0) {
        return 0;
    }

    public Object[] getSections() {
        return null;
    }
}

