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
    //private String[] items = new String[] {"Profile" , "Search", "Journal", "Forums" , "Settings", "Log Out"};
    public MoreFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.more_fragment, container, false);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, items);
//        setListAdapter(adapter);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        MoreMenuArray more_items[] = new MoreMenuArray[] {
                new MoreMenuArray(R.drawable.profile_icon, "Profile"),
                new MoreMenuArray(R.drawable.search_icon, "Search"),
                new MoreMenuArray(R.drawable.forum_icon, "Forum"),
                new MoreMenuArray(R.drawable.journal_icon, "Journal"),
                new MoreMenuArray(R.drawable.settings_icon, "Settings"),
                new MoreMenuArray(R.drawable.logout_icon, "Log Out")
        };
        MoreMenuAdapter adapter = new MoreMenuAdapter(getActivity(), R.layout.more_item_row, more_items);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        switch(position) {
            case 0:
                //Profile
                Intent intent = new Intent(getActivity().getApplicationContext(), ProfileActivity.class);
                startActivity(intent);
                break;
            case 1:
                //Search
                break;
            case 2:
                //Journal
                break;
            case 3:
                //Forum
                break;
            case 4:
                //Settings
                break;
            case 5:
                //Log out
                break;
        }
    }
}
