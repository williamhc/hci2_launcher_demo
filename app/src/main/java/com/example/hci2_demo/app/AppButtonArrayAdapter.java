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
    Map<Character, Integer> letterMappings = new HashMap<Character, Integer>();

    public AppButtonArrayAdapter(Context context, ArrayList<View> values) {
        super(context, R.id.listView, values);
        this.context = context;
        this.values = values;
        GetInitialSections();
    }

    public void GetInitialSections() {
        for (int index = 0; index < values.size(); index++) {
            ViewGroup row = (ViewGroup) this.values.get(index);

            for (int j = 0; j < row.getChildCount(); j++) {
                TextView tv = (TextView) row.getChildAt(j);
                String item = (String) tv.getText();
                item = item.toUpperCase();
                if (!letterMappings.containsKey(item.charAt(0)))
                    letterMappings.put(item.charAt(0),index);
            }
        }

        int lastRow = 0;
        for (int i = 0; i < sections.length(); i++) {
            if (letterMappings.containsKey(sections.charAt(i)))
                lastRow = letterMappings.get(sections.charAt(i));
            else
                letterMappings.put(sections.charAt(i), lastRow);
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return values.get(position);
    }

    public int getPositionForSection(int section) {
        char letter = sections.charAt(section);
        int position = letterMappings.get(letter);
        return position;
    }

    public int getSectionForPosition(int position) {
        return 0;
    }

    public Object[] getSections() {
        return new String[] {"A","B","C","D","E","F","G","H","I","J","K","L",
                "M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    }
}

