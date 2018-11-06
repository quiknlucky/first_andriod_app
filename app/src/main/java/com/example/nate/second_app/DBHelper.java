package com.example.nate.second_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.database.MatrixCursor;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;



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
        Log.d(LOG_TAG, "Creating database object");
        try{
            db.execSQL(CREATE_LIST_TABLE);
            db.execSQL(CREATE_STORE_TABLE);
            db.execSQL(CREATE_ITEM_CATEGORY_TABLE);
            db.execSQL(CREATE_UNIT_CATEGORY_TABLE);
            db.execSQL(CREATE_ITEM_TABLE);
            db.execSQL(CREATE_HISTORY_TABLE);

            db.execSQL(POPULATE_STORE_TABLE);
            db.execSQL(POPULATE_ITEM_CATEGORY_TABLE);
            db.execSQL(POPULATE_UNIT_CATEGORY_TABLE);
            db.execSQL(POPULATE_LIST_TABLE);
            db.execSQL(POPULATE_LIST_TABLE_2);
            Log.d(LOG_TAG, "Created and populated database");
        } catch (SQLException e){
            Log.d(LOG_TAG, "Error creating database " + e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //table create statements
    private static final String CREATE_LIST_TABLE =
            "CREATE TABLE " + ListTable.ListEntry.TABLE_NAME + "(" +
                    ListTable.ListEntry._ID + " INTEGER PRIMARY KEY," +
                    ListTable.ListEntry.COLUMN_NAME_LIST_NAME +  " TEXT)";

    private static final String CREATE_STORE_TABLE =
            "CREATE TABLE " + StoreTable.StoreEntry.TABLE_NAME + "(" +
                    StoreTable.StoreEntry._ID + " INTEGER PRIMARY KEY," +
                    StoreTable.StoreEntry.COLUMN_NAME_STORE_NAME +  " TEXT)";

    private static final String CREATE_ITEM_CATEGORY_TABLE =
            "CREATE TABLE " + ItemCategoryTable.ItemCategoryEntry.TABLE_NAME + "(" +
                    ItemCategoryTable.ItemCategoryEntry._ID + " INTEGER PRIMARY KEY," +
                    ItemCategoryTable.ItemCategoryEntry.COLUMN_NAME_STORE_NAME +  " TEXT)";

    private static final String CREATE_UNIT_CATEGORY_TABLE =
            "CREATE TABLE " + UnitCategoryTable.UnitCategoryEntry.TABLE_NAME + "(" +
                    UnitCategoryTable.UnitCategoryEntry._ID + " INTEGER PRIMARY KEY," +
                    UnitCategoryTable.UnitCategoryEntry.COLUMN_NAME_STORE_NAME +  " TEXT)";

    private static final String CREATE_ITEM_TABLE =
            "CREATE TABLE " + ItemTable.ItemEntry.TABLE_NAME + "(" +
                    ItemTable.ItemEntry._ID + " INTEGER PRIMARY KEY," +
                    ItemTable.ItemEntry.COLUMN_NAME_ITEM_NAME + " TEXT," +
                    ItemTable.ItemEntry.COLUMN_NAME_CATEGORY + " TEXT," +
                    ItemTable.ItemEntry.COLUMN_NAME_QUANTITY + " NUMBER," +
                    ItemTable.ItemEntry.COLUMN_NAME_QUANTITY_UNIT + " TEXT," +
                    ItemTable.ItemEntry.COLUMN_NAME_LAST_UNIT_PRICE + " NUMBER," +
                    ItemTable.ItemEntry.COLUMN_NAME_LAST_TOTAL_PRICE + " NUMBER," +
                    ItemTable.ItemEntry.COLUMN_NAME_LAST_DATE + " DATE," +
                    ItemTable.ItemEntry.COLUMN_NAME_LAST_STORE + " TEXT," +
                    ItemTable.ItemEntry.COLUMN_NAME_AVG_PRICE + " NUMBER," +
                    ItemTable.ItemEntry.COLUMN_NAME_MIN_PRICE + " NUMBER," +
                    ItemTable.ItemEntry.COLUMN_NAME_MIN_PRICE_DATE + " DATE," +
                    ItemTable.ItemEntry.COLUMN_NAME_MIN_PRICE_STORE + " TEXT," +
                    ItemTable.ItemEntry.COLUMN_NAME_MAX_PRICE + " NUMBER)";

    private static final String CREATE_HISTORY_TABLE =
            "CREATE TABLE " + HistoryTable.HistoryEntry.TABLE_NAME + "(" +
                    HistoryTable.HistoryEntry._ID + " INTEGER PRIMARY KEY," +
                    HistoryTable.HistoryEntry.COLUMN_NAME_ITEM_NAME + " TEXT," +
                    HistoryTable.HistoryEntry.COLUMN_NAME_CATEGORY + " TEXT," +
                    HistoryTable.HistoryEntry.COLUMN_NAME_QUANTITY + " NUMBER," +
                    HistoryTable.HistoryEntry.COLUMN_NAME_QUANTITY_UNIT + " TEXT," +
                    HistoryTable.HistoryEntry.COLUMN_NAME_UNIT_PRICE + " NUMBER," +
                    HistoryTable.HistoryEntry.COLUMN_NAME_TOTAL_PRICE + " NUMBER," +
                    HistoryTable.HistoryEntry.COLUMN_NAME_DATE + " DATE," +
                    HistoryTable.HistoryEntry.COLUMN_NAME_STORE + " TEXT)";

    //populate validation tables with generic data
    private static final String POPULATE_STORE_TABLE =
            "INSERT INTO " + StoreTable.StoreEntry.TABLE_NAME +
                    " (store_name) VALUES ('COSTCO')";

    private static final String POPULATE_ITEM_CATEGORY_TABLE =
            "INSERT INTO " + ItemCategoryTable.ItemCategoryEntry.TABLE_NAME +
                    " (item_category_name) VALUES ('FRUIT')";

    private static final String POPULATE_UNIT_CATEGORY_TABLE =
            "INSERT INTO " + UnitCategoryTable.UnitCategoryEntry.TABLE_NAME +
                    " (unit_category_name) VALUES ('POUND')";

    private static final String POPULATE_LIST_TABLE =
            "INSERT INTO " + ListTable.ListEntry.TABLE_NAME +
                    " (list_name) VALUES ('test_list_1')";

    private static final String POPULATE_LIST_TABLE_2 =
            "INSERT INTO " + ListTable.ListEntry.TABLE_NAME +
                    " (list_name) VALUES ('test_list_2')";


    public void addNewList(Lists list) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ListTable.ListEntry.COLUMN_NAME_LIST_NAME, list.getName());

        // Inserting new Row
        db.insert(ListTable.ListEntry.TABLE_NAME, null, values);
        db.close(); // Closing database connection
    }

    public List<Lists> getAllLists() {
        List<Lists> listList = new ArrayList<Lists>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + ListTable.ListEntry.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // Getting the address list which we already into our database
        if (cursor.moveToFirst()) {
            do {
                Lists list = new Lists();
                list.setId(Integer.parseInt(cursor.getString(0)));
                list.setName(cursor.getString(1));
                listList.add(list);
                Log.d("List: ", list.getId()+" , "+list.getName());
            } while (cursor.moveToNext());
        }

        return listList;
    }

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
