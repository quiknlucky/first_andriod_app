package com.example.nate.second_app;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Nate on 11/18/2018.
 */

public class CategoryFragment extends Fragment {
    private final static String LOG_TAG = CategoryFragment.class.getSimpleName();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View fragView = inflater.inflate(R.layout.fragment_common, container, false);

        DBHelper handler = new DBHelper(fragView.getContext());
        SQLiteDatabase db = handler.getWritableDatabase();

        //get all categories in list
        Cursor itemCursor = db.rawQuery("SELECT _id, category_name FROM category ORDER BY category_name", null);
        Log.d(LOG_TAG, "Item cursor, size: " + itemCursor.getCount());
        if(itemCursor.getCount() > 0){
            // Find ListView to populate
            ListView item_list = (ListView) fragView.findViewById(R.id.common_items);
            // Setup cursor adapter using cursor from last step
            ListAdapter itemAdapter = new ListAdapter(fragView.getContext(), itemCursor);
            Log.d(LOG_TAG, "Populated adapter with cursor");
            // Attach cursor adapter to the ListView
            item_list.setAdapter(itemAdapter);
            Log.d(LOG_TAG, "attached itemAdapter to list view");
        } else{
            Toast.makeText(fragView.getContext(), "Lets add some items to this list", Toast.LENGTH_SHORT).show();
        }
        return fragView;
    }
}
