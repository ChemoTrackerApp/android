package com.innovare.chemotracker;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.view.ContextThemeWrapper;

import java.util.ArrayList;

public class TodaysEventArrayAdapter extends ArrayAdapter<CalendarEvent> {
    private String title;
    private String location;
    private String startTime;

    private ArrayList<CalendarEvent> events;

    private Typeface openSans;

    public TodaysEventArrayAdapter(Context context, int textViewResourceId, ArrayList<CalendarEvent> events, Typeface openSans) {
        super(context, textViewResourceId, events);
        this.events = events;
        this.openSans = openSans;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View v = convertView;

        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.today_events, null);
        }

        CalendarEvent i = events.get(position);

        if (i != null) {
            TextView title = (TextView) v.findViewById(R.id.todaysevent_title);
            title.setTypeface(openSans,Typeface.NORMAL);
            TextView location = (TextView) v.findViewById(R.id.todaysevent_location);
            location.setTypeface(openSans,Typeface.NORMAL);
            TextView startTime = (TextView) v.findViewById(R.id.todaysevent_start_time);
            startTime.setTypeface(openSans,Typeface.NORMAL);

            if (title != null){
                title.setText(i.getTitle());
            }
            if (location != null){
                location.setText(i.getLocation());
            }
            if (startTime != null){
                startTime.setText(i.getStartTime());
            }
        }

        return v;
    }
}
