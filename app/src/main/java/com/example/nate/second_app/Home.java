package com.example.nate.second_app;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

public class Home extends AppCompatActivity {
    private final static String LOG_TAG = Home.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);


        DBHelper handler = new DBHelper(this);
        SQLiteDatabase db = handler.getWritableDatabase();
        // Query for items from the database and get a cursor back
        Cursor listCursor = db.rawQuery("SELECT  * FROM list", null);
        Log.d(LOG_TAG, "Created cursor, size: " + listCursor.getCount());
        // Find ListView to populate
        ListView list_list = (ListView) findViewById(R.id.list_list);
        // Setup cursor adapter using cursor from last step
        ListAdapter listAdapter = new ListAdapter(this, listCursor);
        Log.d(LOG_TAG, "Populated adapter with cursor");
        // Attach cursor adapter to the ListView
        list_list.setAdapter(listAdapter);
        Log.d(LOG_TAG, "attached adapter list to list view");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI...
                return true;

            case R.id.manage_db:
                Log.d(LOG_TAG, "Manage db button clicked");
                Intent dbmanager = new Intent(Home.this,AndroidDatabaseManager.class);
                startActivity(dbmanager);
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    public void onButtonTap(View v) {
        Log.d(LOG_TAG, "Create list button clicked");
        Intent intent = new Intent(this, NewList.class);
        startActivity(intent);
    }
}
