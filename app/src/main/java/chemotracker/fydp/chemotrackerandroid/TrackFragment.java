package chemotracker.fydp.chemotrackerandroid;

/**
 * Created by Janice on 7/10/2017.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class TrackFragment extends Fragment {

    static final String[] SYMPTOMS = new String[] {
            "Nausea", "Fatigue", "Constipation", "Vomit", "Diarrhea"
    };

    public TrackFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.track_fragment, container, false);
        GridView grid = (GridView) view.findViewById(R.id.track_gridView);

        grid.setAdapter(new TrackAdapter(this.getContext(), SYMPTOMS));
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

            }
        });
        return view;
    }
}

