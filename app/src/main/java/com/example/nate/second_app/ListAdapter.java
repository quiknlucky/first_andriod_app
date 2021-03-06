package com.example.nate.second_app;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class ListAdapter extends CursorAdapter {
    private final static String LOG_TAG = ListAdapter.class.getSimpleName();

    public ListAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    // The newView method is used to inflate a new view and return it,
    // you don't bind any data to the view at this point.
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_layout, parent, false);
    }

    // The bindView method is used to bind all data to a given view
    // such as setting the text on a TextView.
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        Log.d(LOG_TAG, "Inside bindView");
        // Find fields to populate in inflated template
        TextView tvLists = (TextView) view.findViewById(R.id.tvLists);
        // Extract properties from cursor
        String name= cursor.getString(1);
        Log.d(LOG_TAG, "Name from cursor to display: " + name);
        // Populate fields with extracted properties
        tvLists.setText(name);
    }
}
