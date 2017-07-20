package com.innovare.chemotracker;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
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
import android.widget.LinearLayout;
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
    @InjectView(R.id.profile_full_name) TextView profileRealName;
    @InjectView(R.id.profile_up) LinearLayout profileUp;
    @InjectView(R.id.bottom_navigation) BottomNavigationView bottomNavigation;
    @InjectView(R.id.profile_diagnosis) TextView profileDiagnosis;
    @InjectView(R.id.profile_drug_allergies) TextView profileDrugAllergies;

    //Fragment stuff
    private Fragment fragment;
    private FragmentManager fragmentManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_profile);
        ButterKnife.inject(this);
        //TO DO: change these according to the backend data
		profileImage.setImageResource(R.drawable.user_sample);
		profileName.setText("Carrie");
        profileUp.setBackgroundResource(R.drawable.background_profile);
        profileRealName.setText("Carrie Bradshaw");
        profileDiagnosis.setText("Breast Cancer");
        profileDrugAllergies.setText("None");

//        bottomNavigation.inflateMenu(R.menu.bottom_menu);
//		BottomNavigationViewHelper.removeShiftMode(bottomNavigation);
//        fragmentManager = getSupportFragmentManager();
//        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//            int id = item.getItemId();
//            Log.d(TAG, item.toString());
//            switch (id){
//                case R.id.action_track:
//                    fragment = new TrackFragment();
//                    break;
//                case R.id.action_calendar:
//                    fragment = new CalendarFragment();
//                    break;
//                case R.id.action_more:
//                    fragment = new MoreFragment();
//                    break;
//            }
//            final FragmentTransaction transaction = fragmentManager.beginTransaction();
//            transaction.replace(R.id.main_container, fragment).commit();
//            return true;
//            }
//        });
    }
}
