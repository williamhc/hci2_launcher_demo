package com.example.hci2_demo.app;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SectionIndexer;
import java.util.ArrayList;

public class AppButtonArrayAdapter extends ArrayAdapter<View> implements SectionIndexer {
    private final Context context;
    private final ArrayList<View> values;
    private static String sections = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

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
        for (int i=0; i < this.getCount(); i++) {
//            String item = this.values.get(i).toLowerCase();
//            if (item.charAt(0) == sections.charAt(section))
//                return i;
        }
        return 0;
    }

    public int getSectionForPosition(int arg0) {
        return 0;
    }

    public Object[] getSections() {
        String[] sectionsArr = new String[sections.length()];
        for (int i=0; i < sections.length(); i++)
            sectionsArr[i] = "" + sections.charAt(i);

        return sectionsArr;

    }
}

