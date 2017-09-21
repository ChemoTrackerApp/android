package com.innovare.chemotracker;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Typeface openSans;

    @InjectView(R.id.bottom_navigation) BottomNavigationView bottomNavigation;

    //Fragment stuff
    private Fragment fragment = new HomeFragment();
    private FragmentManager fragmentManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.inject(this);

        //bottom navigation bar
        bottomNavigation.inflateMenu(R.menu.bottom_menu);
        BottomNavigationViewHelper.removeShiftMode(bottomNavigation);
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.main_container, fragment).commit();

        //bottom navigation menu, will change fragment as what is chosen
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            int id = item.getItemId();
                Fragment selected = null;
            Log.d(TAG, item.toString());
            switch (id){
                case R.id.action_home:
                    selected = new HomeFragment();
                    break;
                case R.id.action_track:
                    selected = new TrackFragment();
                    break;
                case R.id.action_calendar:
                    selected = new CalendarFragment();
                    break;
                case R.id.action_more:
                    selected = new MoreFragment();
                    break;
            }
            final FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.main_container, selected).commit();
            return true;
            }
        });
    }
}
