package com.innovare.chemotracker;

/**
 * Created by janice on 2017-09-15.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class HomeFragment extends Fragment {

    // Dummy Data
    private static final ArrayList<String> DUMMY_DATA = new ArrayList<String>(
            Arrays.asList("Chemotherapy", "12/24/2016 10:00", "Stouffville Hospital"));
    private SimpleDateFormat dateFormatForMonth = new SimpleDateFormat("MMMM", Locale.getDefault());
    private SimpleDateFormat dateFormatForDate = new SimpleDateFormat("dd", Locale.getDefault());
    private SimpleDateFormat dateFormatForDayOfWeek = new SimpleDateFormat("EEEE", Locale.getDefault());
    private SimpleDateFormat dateFormatForTime = new SimpleDateFormat("h:mm a", Locale.getDefault());

//    private Toolbar toolbar;

    private Calendar currentCalendar;
    private ArrayList<CalendarEvent> todaysEvents = new ArrayList<>();
    private TodaysEventArrayAdapter adapter;

    private ListView todaysEventsLV;

//    private ScheduleCalendar scheduleCalendar;


    public HomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        return view;
    }

    List<CalendarEvent> getDummyCalendarEvents() {
        String startTime1, endTime1, startTime2, endTime2;

        Calendar c = Calendar.getInstance(Locale.getDefault());
        c.clear(java.util.Calendar.HOUR_OF_DAY);
        c.setTime(new Date());
        c.add(Calendar.HOUR, 3);

        startTime1 = dateFormatForTime.format(c.getTime());
        c.add(Calendar.HOUR, 1);
        endTime1 = startTime2 = dateFormatForTime.format(c.getTime());
        c.add(Calendar.MINUTE, 45);
        endTime2 = dateFormatForTime.format(c.getTime());

        return Arrays.asList(
                new CalendarEvent("Chemo Check-Up", "St. John's Hospital", startTime1, endTime1),
                new CalendarEvent("Chemotherapy Session", "St. John's Hospital", startTime2, endTime2)
        );
    }
}
