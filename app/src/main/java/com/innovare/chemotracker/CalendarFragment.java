package com.innovare.chemotracker;

/**
 * Created by Janice on 7/10/2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
public class CalendarFragment extends Fragment {
    public CalendarFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.calendar_fragment, container, false);
        Intent i = new Intent();
        i.setClass(view.getContext(), CalendarActivity.class);
        view.getContext().startActivity(i);
        return view;
    }
}
