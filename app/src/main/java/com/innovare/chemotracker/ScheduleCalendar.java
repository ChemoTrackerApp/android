package com.innovare.chemotracker;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ScheduleCalendar {
    private Map<Date, Schedule> scheduleMap;

    public ScheduleCalendar() {
        scheduleMap = new HashMap<Date, Schedule>();
    }

    public void addEvent(Date d, CalendarEvent e) {
        if (scheduleMap.containsKey(d)) {
            Schedule schedule = scheduleMap.get(d);
            schedule.addEvent(e);
        } else {
            Schedule schedule = new Schedule(d);
            schedule.addEvent(e);
            scheduleMap.put(d, schedule);
        }
    }

    public void deleteEvent(Date d, CalendarEvent e) {
        if (scheduleMap.containsKey(d)) {
            Schedule schedule = scheduleMap.get(d);
            schedule.removeEvent(e);
        }
    }

    public Map<Date, Schedule> getScheduleMap() {
        return scheduleMap;
    }

    public Schedule getSchedule(Date d) {
        if (scheduleMap.containsKey(d)) {
            Schedule schedule = scheduleMap.get(d);
            return schedule;
        }
        return null;
    }
}
