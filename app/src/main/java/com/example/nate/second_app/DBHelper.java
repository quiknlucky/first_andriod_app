package com.example.nate.second_app;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.database.MatrixCursor;
import android.database.Cursor;
import java.util.ArrayList;



/**
 * Created by Nate on 6/10/2017.
 */

public class DBHelper extends SQLiteOpenHelper {
    private final static String LOG_TAG = DBHelper.class.getSimpleName();
    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "List.db";
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
            db.execSQL(CREATE_LIST_TABLE);
            db.execSQL(CREATE_ITEM_TABLE);
        } catch (SQLException e){
            Log.d(LOG_TAG, "Error creating database " + e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private static final String CREATE_LIST_TABLE =
            "CREATE TABLE " + ListTable.ListEntry.TABLE_NAME + "(" +
                    ListTable.ListEntry._ID + " INTEGER PRIMARY KEY," +
                    ListTable.ListEntry.COLUMN_NAME_LIST_NAME +  "TEXT)";

    private static final String CREATE_ITEM_TABLE =
            "CREATE TABLE " + ItemTable.ItemEntry.TABLE_NAME + "(" +
                    ItemTable.ItemEntry._ID + " INTEGER PRIMARY KEY," +
                    ItemTable.ItemEntry.COLUMN_NAME_ITEM_NAME + " TEXT," +
                    ItemTable.ItemEntry.COLUMN_NAME_LAST_PRICE + " NUMBER," +
                    ItemTable.ItemEntry.COLUMN_NAME_AVG_PRICE + " NUMBER," +
                    ItemTable.ItemEntry.COLUMN_NAME_MIN_PRICE + " NUMBER," +
                    ItemTable.ItemEntry.COLUMN_NAME_MAX_PRICE + " NUMBER," +
                    ItemTable.ItemEntry.COLUMN_NAME_LAST_STORE + " TEXT," +
                    ItemTable.ItemEntry.COLUMN_NAME_LAST_DATE + " DATE";

    public ArrayList<Cursor> getData(String Query){
        //get writable database
        SQLiteDatabase sqlDB = this.getWritableDatabase();
        String[] columns = new String[] { "message" };
        //an array list of cursor to save two cursors one has results from the query
        //other cursor stores error message if any errors are triggered
        ArrayList<Cursor> alc = new ArrayList<Cursor>(2);
        MatrixCursor Cursor2= new MatrixCursor(columns);
        alc.add(null);
        alc.add(null);

        try{
            String maxQuery = Query ;
            //execute the query results will be save in Cursor c
            Cursor c = sqlDB.rawQuery(maxQuery, null);

            //add value to cursor2
            Cursor2.addRow(new Object[] { "Success" });

            alc.set(1,Cursor2);
            if (null != c && c.getCount() > 0) {

                alc.set(0,c);
                c.moveToFirst();

                return alc ;
            }
            return alc;
        } catch(SQLException sqlEx){
            Log.d("printing exception", sqlEx.getMessage());
            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[] { ""+sqlEx.getMessage() });
            alc.set(1,Cursor2);
            return alc;
        } catch(Exception ex){
            Log.d("printing exception", ex.getMessage());

            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[] { ""+ex.getMessage() });
            alc.set(1,Cursor2);
            return alc;
        }
    }
}
