package chemotracker.fydp.chemotrackerandroid;

import java.util.ArrayList;
import java.util.Date;

public class Schedule {

    private ArrayList<Event> eventList;
    private Date currentDate;

    public Schedule(Date currentDate) {
        this.currentDate = currentDate;
        eventList = new ArrayList<Event>();
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void addEvent(Event e) {
        eventList.add(e);
    }

    public void removeEvent(Event e) {
        eventList.remove(e);
    }

    public ArrayList<Event> getEventList() {
        return this.eventList;
    }
}
