package chemotracker.fydp.chemotrackerandroid;

/**
 * Created by Janice on 7/10/2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MoreFragment extends ListFragment {
    private static final String TAG = "MoreFragment";
    private String[] items = new String[] {"Profile" , "Search", "Journal", "Forums" , "Settings", "Log Out"};
    public MoreFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.more_fragment, container, false);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, items);
        setListAdapter(adapter);
        return rootView;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // TODO implement some logic
        if(position == 0) {
            //Profile
            Log.d(TAG, items[position]);
            Intent intent = new Intent(getActivity().getApplicationContext(), ProfileActivity.class);
            startActivity(intent);
        }
    }
}
