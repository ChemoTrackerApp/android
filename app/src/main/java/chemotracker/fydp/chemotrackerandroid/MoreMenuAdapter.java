package chemotracker.fydp.chemotrackerandroid;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Janice on 7/12/2017.
 */

public class MoreMenuAdapter extends ArrayAdapter<MoreMenuArray> {
  Context context;
  int layoutResourceId;
  MoreMenuArray data[] =  null;

  public MoreMenuAdapter(Context context, int layoutResourceId, MoreMenuArray[] data) {
	super(context, layoutResourceId, data);
	this.layoutResourceId = layoutResourceId;
	this.context = context;
	this.data = data;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
	View row = convertView;
	MoreMenuArrayHolder holder = null;

	if(row == null)
	{
	  LayoutInflater inflater = ((Activity)context).getLayoutInflater();
	  row = inflater.inflate(layoutResourceId, parent, false);

	  holder = new MoreMenuArrayHolder();
	  holder.menuIcon = (ImageView)row.findViewById(R.id.menuIcon);
	  holder.menuLabel = (TextView)row.findViewById(R.id.menuLabel);

	  row.setTag(holder);
	} else {
	  holder = (MoreMenuArrayHolder)row.getTag();
	}

	MoreMenuArray menuItem = data[position];
	holder.menuLabel.setText(menuItem.label);
	holder.menuIcon.setImageResource(menuItem.icon);

	return row;
  }

  static class MoreMenuArrayHolder
  {
	ImageView menuIcon;
	TextView menuLabel;
  }
}
