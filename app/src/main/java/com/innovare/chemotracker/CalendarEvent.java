package com.innovare.chemotracker;

import android.util.Log;

import com.github.sundeepk.compactcalendarview.domain.Event;

public class CalendarEvent {
    private static final String TAG = "CalendarEvent";

    private String title;
    private String location;
    private String startTime;
    private String endTime;

    public CalendarEvent(Event event) {
        String data = (String) event.getData();
        Log.d(TAG, "data: " + data);
        String[] dataArray = data.split("\\|");
        this.title = dataArray[0];
        this.location = dataArray[1];
        this.startTime = dataArray[2];
        this.endTime = dataArray[3];

        Log.d(TAG, toString());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return title + "|" + location + "|" + startTime + "|" + endTime;
    }


}
