package com.innovare.chemotracker;

import java.util.ArrayList;
import java.util.Date;

public class Schedule {

    private ArrayList<CalendarEvent> eventList;
    private Date currentDate;

    public Schedule(Date currentDate) {
        this.currentDate = currentDate;
        eventList = new ArrayList<CalendarEvent>();
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void addEvent(CalendarEvent e) {
        eventList.add(e);
    }

    public void removeEvent(CalendarEvent e) {
        eventList.remove(e);
    }

    public ArrayList<CalendarEvent> getEventList() {
        return this.eventList;
    }
}
