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
        int realSection = getExistingLetters("" + sections.charAt(section));

        for (int i=0; i < this.getCount(); i++) {
            ViewGroup row = (ViewGroup) this.values.get(i);
            TextView tv = (TextView) row.getChildAt(0);
            String item = (String) tv.getText();
            item = item.toUpperCase();
            char s = sections.charAt(realSection);
            char t = item.charAt(0);
            if (item.charAt(0) == sections.charAt(realSection))
                return i;
        }

        return 0;
//        return getExistingLetters("" + sections.charAt(section));
    }

    private int getExistingLetters(String letter) {
        ArrayList<String> existingLetters= new ArrayList<String>();
        int letterIndex = -1;
        boolean isFound = false;

        for (int index = 0; index < this.values.size(); index++) {
            ViewGroup row = (ViewGroup) this.values.get(index);
            TextView tv = (TextView) row.getChildAt(0);
            String item = (String) tv.getText();
            item = item.toUpperCase();

            if (!existingLetters.contains("" + item.charAt(0))) {
                existingLetters.add("" + item.charAt(0));
            }
        }

        if (!existingLetters.contains(letter))
        {
            String lastLetter;
            for (int i = 0; i < existingLetters.size() && !isFound; i++)
            {
                String temp = existingLetters.get(i);

                if (temp.compareToIgnoreCase(letter) > 0)
                {
                    //get the index of the last one
                    letterIndex = i-1;
                    isFound = true;
                }
            }

            if(letterIndex < 0)
            {
                lastLetter = existingLetters.get(0);
                letterIndex = 0;
            }
            else
            {
                lastLetter = existingLetters.get(letterIndex);
            }

            for (int j = 0; j < sections.length(); j++)
            {
                if (lastLetter.charAt(0) == sections.charAt(j))
                {
                    letterIndex = j;
                }
            }
        }
        else
        {
            for (int j = 0; j < sections.length(); j++)
            {
                if (letter.charAt(0) == sections.charAt(j))
                {
                    letterIndex = j;
                }
            }
        }

        return letterIndex;
    }

    public int getSectionForPosition(int arg0) {
//        int realSection = getExistingLetters("" + sections.charAt(arg0));
//
//        for (int i=0; i < this.getCount(); i++) {
//            ViewGroup row = (ViewGroup) this.values.get(i);
//            TextView tv = (TextView) row.getChildAt(0);
//            String item = (String) tv.getText();
//            item = item.toUpperCase();
//            char s = sections.charAt(realSection);
//            char t = item.charAt(0);
//            if (item.charAt(0) == sections.charAt(realSection))
//                return i;
//        }

        return 0;
    }

    public Object[] getSections() {
        String[] sectionsArr = new String[sections.length()];
        for (int i=0; i < sections.length(); i++)
            sectionsArr[i] = "" + sections.charAt(i);

        return sectionsArr;

    }
}

