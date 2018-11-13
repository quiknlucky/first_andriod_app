package com.example.nate.second_app;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class EditItems extends AppCompatActivity {
    private final static String LOG_TAG = EditItems.class.getSimpleName();
    private long listID = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_items);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(myToolbar);
        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();
        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);

        Bundle b = getIntent().getExtras();
        if(b != null){
            listID = b.getLong("id");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.edit_item_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI...
                return true;

            case R.id.action_done:
                //get value from edit box
                EditText nameEdit = (EditText) findViewById(R.id.editName);
                String item_name = nameEdit.getText().toString();
                Log.d(LOG_TAG, "create item: " + item_name);

                //create list record
                DBHelper handler = new DBHelper(this);
                Items new_item = new Items();

                //assign values to items object
                new_item.setName(item_name);
                Log.d(LOG_TAG, "item name: " + item_name);
                new_item.setListID(listID);
                Log.d(LOG_TAG, "listID: " + listID);
                //TODO add rest of values

                Log.d("NewItem: ", "calling addNewItem");
                //TODO should wrap this in try catch
                handler.addNewItem(new_item);
                Log.d(LOG_TAG, "new item created");
                Toast.makeText(this, "Item Saved!", Toast.LENGTH_SHORT).show();

                //send back to uselist page
                Intent intent = new Intent(this, UseList.class);

                //pass list id back to uselist activity
                Bundle b = new Bundle();
                b.putLong("id", listID);
                intent.putExtras(b);

                startActivity(intent);
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}
