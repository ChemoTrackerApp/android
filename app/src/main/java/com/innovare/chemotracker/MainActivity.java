package com.innovare.chemotracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CalendarView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    // Dummy Data
    private static final ArrayList<String> DUMMY_DATA = new ArrayList<String>(
            Arrays.asList("Chemotherapy", "12/24/2016 10:00", "Stouffville Hospital"));
    private int counter;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
    private SimpleDateFormat simpleDateTimeFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");

    private CalendarView calendarScheduleView;
    private Toolbar headerbar;
    private static String username, password;

    private Calendar currentDate;

    //Model
    private ScheduleCalendar scheduleCalendar;

    @Override
    public void onRestart() {
        super.onRestart();
        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        Bundle b = new Bundle();
        b.putString("username",username);
        b.putString("password",password);
        intent.putExtras(b);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        headerbar = (Toolbar) findViewById(R.id.header_bar);
        setSupportActionBar(headerbar);

        currentDate = Calendar.getInstance();

        // ToDo: Remove after
        counter = 0;

        scheduleCalendar = new ScheduleCalendar();
        calendarScheduleView = (CalendarView) findViewById(R.id.calendarScheduleView);
        calendarScheduleView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int i, int i1, int i2) {
                Log.d(TAG, "Selected date: " + i2 + "/" + (i1+1) + "/" + i);
                currentDate.set(i, i1, i2, 0, 0);

                // I dont know how to do this!!
//                Schedule s = scheduleCalendar.getSchedule(currentDate.getTime());
//                ArrayList<CalendarEvent> eventList = s.getEventList();
//                List<String> eventNames = new ArrayList<String>();
//                for (CalendarEvent e: eventList) {
//                    eventNames.add(e.getName());
//                }
//
//                ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, eventNames);
//                ListView lv = (ListView)findViewById(R.layout.calendarScheduleList);
//                lv.setAdapter(adapter);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        Log.d(TAG, "onOptionsItemSelected: " + item);
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_menu) {
//            // ToDo:
//        } else if (id == R.id.action_add_entry) {
//            Log.d(TAG, "action_add_entry: " + currentDate.getTime());
//            String strDate = simpleDateFormat.format(currentDate.getTime());
//            strDate += " 10:00";
//            try {
//                Date date = simpleDateTimeFormat.parse(strDate);
//                CalendarEvent newEvent = new CalendarEvent(DUMMY_DATA.get(0)+ " " + counter, date, DUMMY_DATA.get(2));
//                scheduleCalendar.addEvent(currentDate.getTime(), newEvent);
//                counter++;
//            } catch (ParseException e) {
//                System.out.println("Exception: "+ e);
//            }
//        }

        return super.onOptionsItemSelected(item);
    }

}
