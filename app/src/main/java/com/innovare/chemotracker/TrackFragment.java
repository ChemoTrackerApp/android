package com.innovare.chemotracker;

/**
 * Created by Janice on 7/10/2017.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class TrackFragment extends Fragment {

//    static final String[] SYMPTOMS = new String[] {
//            "Nausea", "Fatigue", "Constipation", "Vomit", "Diarrhea"
//    };
//
//    public TrackFragment() {
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.track_fragment, container, false);
//        GridView grid = (GridView) view.findViewById(R.id.track_gridView);
//
//        grid.setAdapter(new TrackAdapter(this.getContext(), SYMPTOMS));
//        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
//
//            }
//        });
//        return view;
//    }

    private static final String TAG = "TrackFragment";
    private static final String KEY_LAYOUT_MANAGER = "layoutManager";
    private static final int SPAN_COUNT = 2;
    private static final int DATASET_COUNT = 5;


    protected RecyclerView mRecyclerView;
    protected TrackAdapter trackAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    static final String[] SYMPTOMS = new String[] {
            "Nausea", "Fatigue", "Constipation", "Vomit", "Diarrhea"
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.track_fragment, container, false);
        rootView.setTag(TAG);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);

        // LinearLayoutManager is used here, this will layout the elements in a similar fashion
        // to the way ListView would layout elements. The RecyclerView.LayoutManager defines how
        // elements are laid out.
        mLayoutManager = new LinearLayoutManager(getActivity());

        trackAdapter = new TrackAdapter(SYMPTOMS);
        // Set CustomAdapter as the adapter for RecyclerView.
        mRecyclerView.setAdapter(trackAdapter);
        mRecyclerView.setLayoutManager(mLayoutManager);

        return rootView;
    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
    }

}

