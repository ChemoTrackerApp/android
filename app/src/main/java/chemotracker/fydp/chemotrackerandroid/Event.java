package chemotracker.fydp.chemotrackerandroid;


import java.util.Date;

public class Event {
    private String name;
    private Date scheduleTime;
    private String location;

    public Event(String name, Date scheduleTime, String location) {
        this.name = name;
        this.scheduleTime = scheduleTime;
        this.location = location;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getScheduleTime() {
        return this.scheduleTime;
    }

    public void setScheduleTime(Date scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
