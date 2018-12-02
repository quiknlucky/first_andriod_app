package com.example.nate.second_app;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class UseList extends AppCompatActivity {
    private final static String LOG_TAG = UseList.class.getSimpleName();
    private long listID = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_use_list);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar3);
        setSupportActionBar(myToolbar);
        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();
        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);

        Bundle b = getIntent().getExtras();
        if(b != null){
            listID = b.getLong("id");
        }

        Log.d(LOG_TAG, "List id: " + listID);
        if(listID != -1){
            DBHelper handler = new DBHelper(this);
            SQLiteDatabase db = handler.getWritableDatabase();

            //get list name to set title of toolbar
            Cursor listCursor = db.rawQuery("SELECT list_name FROM list WHERE _id = " + listID, null);
            Log.d(LOG_TAG, "List cursor, size: " + listCursor.getCount());
            if(listCursor.moveToFirst()) {
                String listName = listCursor.getString(0);
                Log.d(LOG_TAG, "List name: " + listName);
                ab.setTitle(listName);
            }

            //get items in list
            Cursor itemCursor = db.rawQuery("SELECT _id, item_name FROM item WHERE list_id = " + listID + " ORDER BY item_name", null);
            Log.d(LOG_TAG, "Item cursor, size: " + itemCursor.getCount());
            if(itemCursor.getCount() > 0){
                // Find ListView to populate
                ListView item_list = (ListView) findViewById(R.id.list_items);
                // Setup cursor adapter using cursor from last step
                ListAdapter itemAdapter = new ListAdapter(this, itemCursor);
                Log.d(LOG_TAG, "Populated adapter with cursor");
                // Attach cursor adapter to the ListView
                item_list.setAdapter(itemAdapter);
                Log.d(LOG_TAG, "attached itemAdapter to list view");
            } else{
                Toast.makeText(this, "Lets add some items to this list", Toast.LENGTH_SHORT).show();
            }
        } else{
            Toast.makeText(this, "Something went wrong, lets try again", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, Home.class);
            startActivity(intent);
        }
    }

    public void onButtonTap(View v) {
        Log.d(LOG_TAG, "Create item button clicked");
        Intent intent = new Intent(this, ManageItems.class);

        //pass list id to edititem activity
        Bundle b = new Bundle();
        b.putLong("id", listID);
        intent.putExtras(b);

        startActivity(intent);
    }

}
