package chemotracker.fydp.chemotrackerandroid;

/**
 * Created by Janice on 7/10/2017.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
    public class MenuFragment extends Fragment {
        public MenuFragment() {
        }
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            return inflater.inflate(R.layout.menu_fragment, container, false);
        }
    }
