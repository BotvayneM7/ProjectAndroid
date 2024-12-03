package com.example.finalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

// Custom adapter for displaying recent activities in a list
public class AdapterActivity extends ArrayAdapter<String> {

    // Constructor to initialize the adapter with context and a list of activities
    public AdapterActivity(Context context, ArrayList<String> recentActivities) {
        super(context, 0, recentActivities);
    }

    // Method to provide a view for each item in the list
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Inflate a new view if no reusable view is available
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_recent_activity, parent, false);
        }

        // Get the current activity from the list
        String activity = getItem(position);

        // Set the activity text in the TextView
        TextView activityTextView = convertView.findViewById(R.id.activityTextView);
        activityTextView.setText(activity);

        // Return the prepared view
        return convertView;
    }
}
