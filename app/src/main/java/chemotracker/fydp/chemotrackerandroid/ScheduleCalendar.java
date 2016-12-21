package chemotracker.fydp.chemotrackerandroid;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ScheduleCalendar {
    private Map<Date, Schedule> scheduleMap;

    public ScheduleCalendar() {
        scheduleMap = new HashMap<Date, Schedule>();
    }
}
