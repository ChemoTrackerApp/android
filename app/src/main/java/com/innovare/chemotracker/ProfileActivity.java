package com.innovare.chemotracker;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Janice on 7/5/2017.
 */

public class ProfileActivity extends AppCompatActivity {
    private static final String TAG = "ProfileActivity";
    @InjectView(R.id.profile_image) ImageView profileImage;
    @InjectView(R.id.user_profile_name) TextView profileName;
    @InjectView(R.id.bottom_navigation) BottomNavigationView bottomNavigation;
    private Fragment fragment;
    private FragmentManager fragmentManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_profile);
        ButterKnife.inject(this);
        bottomNavigation.inflateMenu(R.menu.bottom_menu);
		BottomNavigationViewHelper.removeShiftMode(bottomNavigation);
        fragmentManager = getSupportFragmentManager();
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            int id = item.getItemId();
            Log.d(TAG, item.toString());
            switch (id){
                case R.id.action_track:
                    fragment = new TrackFragment();
                    break;
                case R.id.action_calendar:
                    fragment = new CalendarFragment();
                    break;
                case R.id.action_more:
                    fragment = new MoreFragment();
                    break;
            }
            final FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.main_container, fragment).commit();
            return true;
            }
        });
    }
}
