package com.example.nate.second_app;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FilterQueryProvider;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Nate on 11/18/2018.
 */

public class AllFragment extends Fragment {
    private final static String LOG_TAG = AllFragment.class.getSimpleName();
    private ListView itemList;
    private ListAdapter itemAdapter;
    private Cursor itemCursor;
    private DBHelper handler;
    private SQLiteDatabase db;
    private EditText findItem;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_all, container, false);
    }

    @Override
    public void onViewCreated(View fragView, Bundle savedInstanceState){
        handler = new DBHelper(fragView.getContext());
        db = handler.getWritableDatabase();

        //get all items in list
        itemCursor = db.rawQuery("SELECT _id, item_name FROM all_item ORDER BY item_name", null);
        Log.d(LOG_TAG, "Item cursor, size: " + itemCursor.getCount());
        if(itemCursor.getCount() > 0){
            // Find ListView to populate
            itemList = (ListView) fragView.findViewById(R.id.all_items);
            // Setup cursor adapter using cursor from last step
            itemAdapter = new ListAdapter(fragView.getContext(), itemCursor);
            Log.d(LOG_TAG, "Populated adapter with cursor");
            // Attach cursor adapter to the ListView
            itemList.setAdapter(itemAdapter);
            Log.d(LOG_TAG, "attached itemAdapter to list view");

            itemList.setTextFilterEnabled(true);

            itemAdapter.setFilterQueryProvider(new FilterQueryProvider() {
                @Override
                public Cursor runQuery(CharSequence constraint) {
                    Log.d(LOG_TAG, "runQuery with constraint: " + constraint);
                    String[] input = { constraint.toString() };
                    Cursor cur = db.rawQuery("SELECT _id, item_name FROM all_item WHERE item_name LIKE '%' || ? || '%' ORDER BY item_name", input);
                    if (cur != null) {
                        cur.moveToFirst();
                    }
                    return cur;
                }
            });

        } else{
            Toast.makeText(fragView.getContext(), "Lets add some items to this list", Toast.LENGTH_SHORT).show();
        }

        findItem = (EditText) fragView.findViewById(R.id.find_item);
        findItem.addTextChangedListener(new TextWatcher()
        {
            public void afterTextChanged(Editable s)
            {
                // Abstract Method of TextWatcher Interface.

            }
            public void beforeTextChanged(CharSequence s,
                                          int start, int count, int after)
            {

                // Abstract Method of TextWatcher Interface.

            }
            public void onTextChanged(CharSequence s,
                                      int start, int before, int count)
            {
                Log.d(LOG_TAG, "filtering listview based on string: " + s);
                itemAdapter.getFilter().filter(s);
            }
        });
    }
}
