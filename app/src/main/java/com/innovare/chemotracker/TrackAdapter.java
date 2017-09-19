package com.innovare.chemotracker;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Janice on 7/17/2017.
 */
//
//public class TrackAdapter extends BaseAdapter {
//	private Context context;
//	private final String[] symptomValues;
//
//	public TrackAdapter(Context context, String[] symptomValues) {
//		this.context = context;
//		this.symptomValues = symptomValues;
//	}
//
//	public View getView(int position, View convertView, ViewGroup parent) {
//
//		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//
//		View grid;
//
//		if (convertView == null) {
//
//			grid = new View(context);
//
//			// get layout from mobile.xml
//			grid = inflater.inflate(R.layout.track_symptoms, null);
//
//			// set value into textview
//			TextView textView = (TextView) grid
//					.findViewById(R.id.symptom_label);
//			textView.setText(symptomValues[position]);
//
//			// set image based on selected text
//			ImageView imageView = (ImageView) grid
//					.findViewById(R.id.symptom_image);
//
//			String symptom = symptomValues[position];
//
//			if (symptom.equals("Nausea")) {
//				imageView.setImageResource(R.drawable.nausea_icon);
//			} else if (symptom.equals("Fatigue")) {
//				imageView.setImageResource(R.drawable.fatigue_icon);
//			} else if (symptom.equals("Constipation")) {
//				imageView.setImageResource(R.drawable.constipation_icon);
//			} else if(symptom.equals("Vomit")){
//				imageView.setImageResource(R.drawable.vomit_icon);
//			} else if(symptom.equals("Diarrhea")){
//				imageView.setImageResource(R.drawable.diarrhea_icon);
//			}
//
//		} else {
//			grid = (View) convertView;
//		}
//
//		return grid;
//	}


	/**
	 * Provide views to RecyclerView with data from mDataSet.
	 */
	public class TrackAdapter extends RecyclerView.Adapter<TrackAdapter.ViewHolder> {
		private static final String TAG = "CustomAdapter";

		private String[] mDataSet;

		/**
		 * Provide a reference to the type of views that you are using (custom ViewHolder)
		 */
		public static class ViewHolder extends RecyclerView.ViewHolder {
			private final TextView textView;

			public ViewHolder(View v) {
				super(v);
				// Define click listener for the ViewHolder's View.
				v.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						Log.d(TAG, "Element " + getAdapterPosition() + " clicked.");
					}
				});
				textView = (TextView) v.findViewById(R.id.textView);
			}

			public TextView getTextView() {
				return textView;
			}
		}

		/**
		 * Initialize the dataset of the Adapter.
		 *
		 * @param dataSet String[] containing the data to populate views to be used by RecyclerView.
		 */
		public TrackAdapter(String[] dataSet) {
			mDataSet = dataSet;
		}

		// Create new views (invoked by the layout manager)
		@Override
		public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
			// Create a new view.
			View v = LayoutInflater.from(viewGroup.getContext())
					.inflate(R.layout.track_recycler, viewGroup, false);

			return new ViewHolder(v);
		}

		// Replace the contents of a view (invoked by the layout manager)
		@Override
		public void onBindViewHolder(ViewHolder viewHolder, final int position) {
			Log.d(TAG, "Element " + position + " set.");

			// Get element from your dataset at this position and replace the contents of the view
			// with that element
			viewHolder.getTextView().setText(mDataSet[position]);
		}

		// Return the size of your dataset (invoked by the layout manager)
		@Override
		public int getItemCount() {
			return mDataSet.length;
		}
	}
