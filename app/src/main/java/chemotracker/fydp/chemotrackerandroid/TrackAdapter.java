package chemotracker.fydp.chemotrackerandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Janice on 7/17/2017.
 */

public class TrackAdapter extends BaseAdapter {
	private Context context;
	private final String[] symptomValues;

	public TrackAdapter(Context context, String[] symptomValues) {
		this.context = context;
		this.symptomValues = symptomValues;
	}

	public View getView(int position, View convertView, ViewGroup parent) {

		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View grid;

		if (convertView == null) {

			grid = new View(context);

			// get layout from mobile.xml
			grid = inflater.inflate(R.layout.track_symptoms, null);

			// set value into textview
			TextView textView = (TextView) grid
					.findViewById(R.id.symptom_label);
			textView.setText(symptomValues[position]);

			// set image based on selected text
			ImageView imageView = (ImageView) grid
					.findViewById(R.id.symptom_image);

			String symptom = symptomValues[position];

			if (symptom.equals("Nausea")) {
				imageView.setImageResource(R.drawable.nausea_icon);
			} else if (symptom.equals("Fatigue")) {
				imageView.setImageResource(R.drawable.fatigue_icon);
			} else if (symptom.equals("Constipation")) {
				imageView.setImageResource(R.drawable.constipation_icon);
			} else if(symptom.equals("Vomit")){
				imageView.setImageResource(R.drawable.vomit_icon);
			} else if(symptom.equals("Diarrhea")){
				imageView.setImageResource(R.drawable.diarrhea_icon);
			}

		} else {
			grid = (View) convertView;
		}

		return grid;
	}

	@Override
	public int getCount() {
		return symptomValues.length;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

}
