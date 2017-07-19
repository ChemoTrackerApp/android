package com.innovare.chemotracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

//import com.github.sundeepk.compactcalendarview.domain.Event;

public class EventArrayAdapter extends ArrayAdapter<CalendarEvent> {
    private String title;
    private String location;
    private String startTime;
    private String endTime;

    private ArrayList<CalendarEvent> objects;

    public EventArrayAdapter(Context context, int textViewResourceId, ArrayList<CalendarEvent> objects) {
        super(context, textViewResourceId, objects);
        this.objects = objects;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View v = convertView;

        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.activity_event, null);
        }

        CalendarEvent i = objects.get(position);

        if (i != null) {
            TextView title = (TextView) v.findViewById(R.id.title);
            TextView location = (TextView) v.findViewById(R.id.location);
            TextView startTime = (TextView) v.findViewById(R.id.start_time);
            TextView endTime = (TextView) v.findViewById(R.id.end_time);

            if (title != null){
                title.setText(i.getTitle());
            }
            if (location != null){
                location.setText(i.getLocation());
            }
            if (startTime != null){
                startTime.setText(i.getStartTime());
            }
            if (endTime != null){
                endTime.setText(i.getEndTime());
            }
        }

        // the view must be returned to our activity
        return v;
    }

}
