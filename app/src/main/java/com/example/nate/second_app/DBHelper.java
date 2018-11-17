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
            db.execSQL(CREATE_CATEGORY_TABLE);
            db.execSQL(CREATE_UNIT_TABLE);
            db.execSQL(CREATE_ITEM_TABLE);
            db.execSQL(CREATE_HISTORY_TABLE);

            db.execSQL(POPULATE_STORE_TABLE);
            db.execSQL(POPULATE_CATEGORY_TABLE);
            db.execSQL(POPULATE_UNIT_TABLE);
            db.execSQL(POPULATE_LIST_TABLE);
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

    private static final String CREATE_CATEGORY_TABLE =
            "CREATE TABLE " + CategoryTable.CategoryEntry.TABLE_NAME + "(" +
                    CategoryTable.CategoryEntry._ID + " INTEGER PRIMARY KEY," +
                    CategoryTable.CategoryEntry.COLUMN_NAME_CATEGORY_ID +  " INTEGER)" +
                    CategoryTable.CategoryEntry.COLUMN_NAME_CATEGORY_NAME +  " TEXT)";

    private static final String CREATE_UNIT_TABLE =
            "CREATE TABLE " + UnitTable.UnitEntry.TABLE_NAME + "(" +
                    UnitTable.UnitEntry._ID + " INTEGER PRIMARY KEY," +
                    UnitTable.UnitEntry.COLUMN_NAME_UNIT_NAME +  " TEXT)";

    private static final String CREATE_ITEM_TABLE =
            "CREATE TABLE " + ItemTable.ItemEntry.TABLE_NAME + "(" +
                    ItemTable.ItemEntry._ID + " INTEGER PRIMARY KEY," +
                    ItemTable.ItemEntry.COLUMN_NAME_LIST_ID + " INTEGER," +
                    ItemTable.ItemEntry.COLUMN_NAME_ITEM_NAME + " TEXT," +
                    ItemTable.ItemEntry.COLUMN_NAME_CATEGORY_ID + " INTEGER," +
                    ItemTable.ItemEntry.COLUMN_NAME_USED + " BOOLEAN," +
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
                    HistoryTable.HistoryEntry.COLUMN_NAME_CATEGORY_ID + " INTEGER," +
                    HistoryTable.HistoryEntry.COLUMN_NAME_QUANTITY + " NUMBER," +
                    HistoryTable.HistoryEntry.COLUMN_NAME_QUANTITY_UNIT + " TEXT," +
                    HistoryTable.HistoryEntry.COLUMN_NAME_UNIT_PRICE + " NUMBER," +
                    HistoryTable.HistoryEntry.COLUMN_NAME_TOTAL_PRICE + " NUMBER," +
                    HistoryTable.HistoryEntry.COLUMN_NAME_DATE + " DATE," +
                    HistoryTable.HistoryEntry.COLUMN_NAME_STORE + " TEXT)";

    //populate validation tables with generic data
    private static final String POPULATE_STORE_TABLE =
            "INSERT INTO " + StoreTable.StoreEntry.TABLE_NAME + " (store_name) VALUES ('Costco')" +
            "INSERT INTO " + StoreTable.StoreEntry.TABLE_NAME + " (store_name) VALUES ('Albertsons')" +
            "INSERT INTO " + StoreTable.StoreEntry.TABLE_NAME + " (store_name) VALUES ('Safeway')" +
            "INSERT INTO " + StoreTable.StoreEntry.TABLE_NAME + " (store_name) VALUES ('Target')" +
            "INSERT INTO " + StoreTable.StoreEntry.TABLE_NAME + " (store_name) VALUES ('Walmart')" +
            "INSERT INTO " + StoreTable.StoreEntry.TABLE_NAME + " (store_name) VALUES ('Rosauers')" +
            "INSERT INTO " + StoreTable.StoreEntry.TABLE_NAME + " (store_name) VALUES ('Whole Foods')" +
            "INSERT INTO " + StoreTable.StoreEntry.TABLE_NAME + " (store_name) VALUES ('Trader Joes')" +
            "INSERT INTO " + StoreTable.StoreEntry.TABLE_NAME + " (store_name) VALUES ('Aldi')" +
            "INSERT INTO " + StoreTable.StoreEntry.TABLE_NAME + " (store_name) VALUES ('Hy-Vee')" +
            "INSERT INTO " + StoreTable.StoreEntry.TABLE_NAME + " (store_name) VALUES ('Kroger')" +
            "INSERT INTO " + StoreTable.StoreEntry.TABLE_NAME + " (store_name) VALUES ('Town & Country')" +
            "INSERT INTO " + StoreTable.StoreEntry.TABLE_NAME + " (store_name) VALUES ('WinCo')";

    private static final String POPULATE_CATEGORY_TABLE =
            "INSERT INTO " + CategoryTable.CategoryEntry.TABLE_NAME + " (category_id, category_name) VALUES ('0100','Dairy and Egg Products')" +
            "INSERT INTO " + CategoryTable.CategoryEntry.TABLE_NAME + " (category_id, category_name) VALUES ('0200','Spices and Herbs')" +
            "INSERT INTO " + CategoryTable.CategoryEntry.TABLE_NAME + " (category_id, category_name) VALUES ('0300','Baby Foods')" +
            "INSERT INTO " + CategoryTable.CategoryEntry.TABLE_NAME + " (category_id, category_name) VALUES ('0400','Fats and Oils')" +
            "INSERT INTO " + CategoryTable.CategoryEntry.TABLE_NAME + " (category_id, category_name) VALUES ('0500','Poultry Products')" +
            "INSERT INTO " + CategoryTable.CategoryEntry.TABLE_NAME + " (category_id, category_name) VALUES ('0600','Soups, Sauces, and Gravies')" +
            "INSERT INTO " + CategoryTable.CategoryEntry.TABLE_NAME + " (category_id, category_name) VALUES ('0700','Sausages and Luncheon Meats')" +
            "INSERT INTO " + CategoryTable.CategoryEntry.TABLE_NAME + " (category_id, category_name) VALUES ('0800','Breakfast Cereals')" +
            "INSERT INTO " + CategoryTable.CategoryEntry.TABLE_NAME + " (category_id, category_name) VALUES ('0900','Fruits and Fruit Juices')" +
            "INSERT INTO " + CategoryTable.CategoryEntry.TABLE_NAME + " (category_id, category_name) VALUES ('1000','Pork Products')" +
            "INSERT INTO " + CategoryTable.CategoryEntry.TABLE_NAME + " (category_id, category_name) VALUES ('1100','Vegetables and Vegetable Products')" +
            "INSERT INTO " + CategoryTable.CategoryEntry.TABLE_NAME + " (category_id, category_name) VALUES ('1200','Nut and Seed Products')" +
            "INSERT INTO " + CategoryTable.CategoryEntry.TABLE_NAME + " (category_id, category_name) VALUES ('1300','Beef Products')" +
            "INSERT INTO " + CategoryTable.CategoryEntry.TABLE_NAME + " (category_id, category_name) VALUES ('1400','Beverages')" +
            "INSERT INTO " + CategoryTable.CategoryEntry.TABLE_NAME + " (category_id, category_name) VALUES ('1500','Finfish and Shellfish Products')" +
            "INSERT INTO " + CategoryTable.CategoryEntry.TABLE_NAME + " (category_id, category_name) VALUES ('1600','Legumes and Legume Products')" +
            "INSERT INTO " + CategoryTable.CategoryEntry.TABLE_NAME + " (category_id, category_name) VALUES ('1700','Lamb, Veal, and Game Products')" +
            "INSERT INTO " + CategoryTable.CategoryEntry.TABLE_NAME + " (category_id, category_name) VALUES ('1800','Baked Products')" +
            "INSERT INTO " + CategoryTable.CategoryEntry.TABLE_NAME + " (category_id, category_name) VALUES ('1900','Sweets')" +
            "INSERT INTO " + CategoryTable.CategoryEntry.TABLE_NAME + " (category_id, category_name) VALUES ('2000','Cereal Grains and Pasta')" +
            "INSERT INTO " + CategoryTable.CategoryEntry.TABLE_NAME + " (category_id, category_name) VALUES ('2100','Fast Foods')" +
            "INSERT INTO " + CategoryTable.CategoryEntry.TABLE_NAME + " (category_id, category_name) VALUES ('2200','Meals, Entrees, and Side Dishes')" +
            "INSERT INTO " + CategoryTable.CategoryEntry.TABLE_NAME + " (category_id, category_name) VALUES ('2500','Snacks')" +
            "INSERT INTO " + CategoryTable.CategoryEntry.TABLE_NAME + " (category_id, category_name) VALUES ('3500','American Indian/Alaska Native Foods')" +
            "INSERT INTO " + CategoryTable.CategoryEntry.TABLE_NAME + " (category_id, category_name) VALUES ('3600','Restaurant Foods')" +
            "INSERT INTO " + CategoryTable.CategoryEntry.TABLE_NAME + " (category_id, category_name) VALUES ('7000','Personal Care')" +
            "INSERT INTO " + CategoryTable.CategoryEntry.TABLE_NAME + " (category_id, category_name) VALUES ('8000','Pharmacy')" +
            "INSERT INTO " + CategoryTable.CategoryEntry.TABLE_NAME + " (category_id, category_name) VALUES ('9000','Household')";

    private static final String POPULATE_UNIT_TABLE =
            "INSERT INTO " + UnitTable.UnitEntry.TABLE_NAME + " (unit_category_name) VALUES ('POUND')";

    private static final String POPULATE_LIST_TABLE =
            "INSERT INTO " + ListTable.ListEntry.TABLE_NAME + " (list_name) VALUES ('Example Grocery List')";


    public void addNewList(Lists list) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ListTable.ListEntry.COLUMN_NAME_LIST_NAME, list.getName());

        // Inserting new Row
        db.insert(ListTable.ListEntry.TABLE_NAME, null, values);
        db.close(); // Closing database connection
    }

    public void addNewItem(Items item) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ItemTable.ItemEntry.COLUMN_NAME_ITEM_NAME, item.getName());
        values.put(ItemTable.ItemEntry.COLUMN_NAME_LIST_ID, item.getListID());
        values.put(ItemTable.ItemEntry.COLUMN_NAME_USED, item.getUsed());

        // Inserting new Row
        db.insert(ItemTable.ItemEntry.TABLE_NAME, null, values);
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
