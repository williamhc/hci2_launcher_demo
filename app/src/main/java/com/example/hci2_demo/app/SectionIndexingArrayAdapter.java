package com.example.hci2_demo.app;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SectionIndexer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class SectionIndexingArrayAdapter<T> extends ArrayAdapter<T> implements SectionIndexer {

    HashMap<String, Integer> sectionsMap = new HashMap<String, Integer>();
    ArrayList<String> sectionsList = new ArrayList<String>();

    ArrayList<Integer> sectionForPosition = new ArrayList<Integer>();
    ArrayList<Integer> positionForSection = new ArrayList<Integer>();

    private final ArrayList<View> values;

    public SectionIndexingArrayAdapter(Context context,
                                       List<T> objects) {
        super(context, R.layout.fitts_wheel, objects);

        // Note that List<T> objects has already been sorted alphabetically
        // e.g. with Collections.sort(objects) **before** being passed to
        // this constructor.

        // Figure out what the sections should be (one section per unique
        // initial letter, to accommodate letters that might be missing,
        // or characters like ,)
        for (int i = 0; i < objects.size(); i++) {
            String objectString = objects.get(i).toString();
            if (objectString.length() > 0) {
                String firstLetter = objectString.substring(0, 1).toUpperCase();
                if (!sectionsMap.containsKey(firstLetter)) {
                    sectionsMap.put(firstLetter, sectionsMap.size());
                    sectionsList.add(firstLetter);
                }
            }
        }

        // Calculate the section for each position in the list.
        for (int i = 0; i < objects.size(); i++) {
            String objectString = objects.get(i).toString();
            if (objectString.length() > 0) {
                String firstLetter = objectString.substring(0, 1).toUpperCase();
                if (sectionsMap.containsKey(firstLetter)) {
                    sectionForPosition.add(sectionsMap.get(firstLetter));
                } else
                    sectionForPosition.add(0);
            } else
                sectionForPosition.add(0);
        }



        // Calculate the first position where each section begins.
        for (int i = 0; i < sectionsMap.size(); i++)
            positionForSection.add(0);
        for (int i = 0; i < sectionsMap.size(); i++) {
            for (int j = 0; j < objects.size(); j++) {
                Integer section = sectionForPosition.get(j);
                if (section == i) {
                    positionForSection.set(i, j);
                    break;
                }
            }
        }
        values = new ArrayList<View>((Collection<? extends View>) objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return this.values.get(position);
    }

    // The interface methods.

    public int getPositionForSection(int section) {
        return positionForSection.get(section);
    }

    public int getSectionForPosition(int position) {
        return sectionForPosition.get(position);
    }

    public Object[] getSections() {
        return sectionsList.toArray();
    }
}