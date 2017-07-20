package com.innovare.chemotracker;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private Typeface openSans;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        openSans = Typeface.createFromAsset(getAssets(), "fonts/OpenSans-Regular.ttf");

        currentCalendar = Calendar.getInstance(Locale.getDefault());
        currentCalendar.setTime(new Date());

        TextView month_tv = (TextView) findViewById(R.id.todays_month);
        month_tv.setTypeface(openSans,Typeface.NORMAL);
        TextView date_tv = (TextView) findViewById(R.id.todays_date);
        date_tv.setTypeface(openSans,Typeface.NORMAL);
        TextView dayOfWeek_tv = (TextView) findViewById(R.id.todays_dayOfWeek);
        dayOfWeek_tv.setTypeface(openSans,Typeface.NORMAL);

        String month = dateFormatForMonth.format(currentCalendar.getTime());
        String date = dateFormatForDate.format(currentCalendar.getTime());
        String dayOfWeek = dateFormatForDayOfWeek.format(currentCalendar.getTime());

        month_tv.setText(month);
        date_tv.setText(date);
        dayOfWeek_tv.setText(dayOfWeek);

        todaysEvents = new ArrayList<>();
        todaysEventsLV = (ListView) findViewById(R.id.todays_events);
        adapter = new TodaysEventArrayAdapter(getApplicationContext(), R.layout.today_events, todaysEvents, openSans);
        todaysEventsLV.setAdapter(adapter);

        List<CalendarEvent> tmpEvents = getDummyCalendarEvents();
        for (CalendarEvent e: tmpEvents) {
            todaysEvents.add(e);
        }
        adapter.notifyDataSetChanged();
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
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main_menu, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here.
//        Log.d(TAG, "onOptionsItemSelected: " + item);
//        int id = item.getItemId();
//        //noinspection SimplifiableIfStatement
////        if (id == R.id.action_menu) {
////            // ToDo:
////        } else if (id == R.id.action_add_entry) {
////            Log.d(TAG, "action_add_entry: " + currentDate.getTime());
////            String strDate = simpleDateFormat.format(currentDate.getTime());
////            strDate += " 10:00";
////            try {
////                Date date = simpleDateTimeFormat.parse(strDate);
////                CalendarEvent newEvent = new CalendarEvent(DUMMY_DATA.get(0)+ " " + counter, date, DUMMY_DATA.get(2));
////                scheduleCalendar.addEvent(currentDate.getTime(), newEvent);
////                counter++;
////            } catch (ParseException e) {
////                System.out.println("Exception: "+ e);
////            }
////        }
//
//        return super.onOptionsItemSelected(item);
//    }
//
}
