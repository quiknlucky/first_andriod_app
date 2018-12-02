package com.example.nate.second_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
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
        db.beginTransaction();
        try{
            db.execSQL(CREATE_LIST_TABLE);
            db.execSQL(CREATE_STORE_TABLE);
            db.execSQL(CREATE_CATEGORY_TABLE);
            db.execSQL(CREATE_UNIT_TABLE);
            db.execSQL(CREATE_ITEM_TABLE);
            db.execSQL(CREATE_ALLITEM_TABLE);
            db.execSQL(CREATE_HISTORY_TABLE);

            //populate store table
            SQLiteStatement insert_store_rec = db.compileStatement("INSERT INTO " + StoreTable.StoreEntry.TABLE_NAME + " (store_name) VALUES (?); ");
            insert_store_rec.bindString(1, "Albertsons");
            insert_store_rec.executeInsert();
            insert_store_rec.bindString(1, "Aldi");
            insert_store_rec.executeInsert();
            insert_store_rec.bindString(1, "Costco");
            insert_store_rec.executeInsert();
            insert_store_rec.bindString(1, "Hy-Vee");
            insert_store_rec.executeInsert();
            insert_store_rec.bindString(1, "Kroger");
            insert_store_rec.executeInsert();
            insert_store_rec.bindString(1, "Rosauers");
            insert_store_rec.executeInsert();
            insert_store_rec.bindString(1, "Safeway");
            insert_store_rec.executeInsert();
            insert_store_rec.bindString(1, "Target");
            insert_store_rec.executeInsert();
            insert_store_rec.bindString(1, "Town & Country");
            insert_store_rec.executeInsert();
            insert_store_rec.bindString(1, "Trader Joes");
            insert_store_rec.executeInsert();
            insert_store_rec.bindString(1, "Walmart");
            insert_store_rec.executeInsert();
            insert_store_rec.bindString(1, "Whole Foods");
            insert_store_rec.executeInsert();
            insert_store_rec.bindString(1, "WinCo");
            insert_store_rec.executeInsert();
            Log.d(LOG_TAG, "Finished populating store table");

            //populate category table
            SQLiteStatement insert_category_rec = db.compileStatement("INSERT INTO " + CategoryTable.CategoryEntry.TABLE_NAME + " (category_id, category_name) VALUES (?,?); ");
            insert_category_rec.bindLong(1, 100); insert_category_rec.bindString(2,"Dairy and Egg Products");
            insert_category_rec.executeInsert();
            insert_category_rec.bindLong(1, 200); insert_category_rec.bindString(2,"Spices and Herbs");
            insert_category_rec.executeInsert();
            insert_category_rec.bindLong(1, 300); insert_category_rec.bindString(2,"Baby Foods");
            insert_category_rec.executeInsert();
            insert_category_rec.bindLong(1, 400); insert_category_rec.bindString(2,"Fats and Oils");
            insert_category_rec.executeInsert();
            insert_category_rec.bindLong(1, 500); insert_category_rec.bindString(2,"Poultry Products");
            insert_category_rec.executeInsert();
            insert_category_rec.bindLong(1, 600); insert_category_rec.bindString(2,"Soups, Sauces, and Gravies");
            insert_category_rec.executeInsert();
            insert_category_rec.bindLong(1, 700); insert_category_rec.bindString(2,"Sausages and Luncheon Meats");
            insert_category_rec.executeInsert();
            insert_category_rec.bindLong(1, 800); insert_category_rec.bindString(2,"Breakfast Cereals");
            insert_category_rec.executeInsert();
            insert_category_rec.bindLong(1, 900); insert_category_rec.bindString(2,"Fruits and Fruit Juices");
            insert_category_rec.executeInsert();
            insert_category_rec.bindLong(1, 1000); insert_category_rec.bindString(2,"Pork Products");
            insert_category_rec.executeInsert();
            insert_category_rec.bindLong(1, 1100); insert_category_rec.bindString(2,"Vegetables and Vegetable Products");
            insert_category_rec.executeInsert();
            insert_category_rec.bindLong(1, 1200); insert_category_rec.bindString(2,"Nut and Seed Products");
            insert_category_rec.executeInsert();
            insert_category_rec.bindLong(1, 1300); insert_category_rec.bindString(2,"Beef Products");
            insert_category_rec.executeInsert();
            insert_category_rec.bindLong(1, 1400); insert_category_rec.bindString(2,"Beverages");
            insert_category_rec.executeInsert();
            insert_category_rec.bindLong(1, 1500); insert_category_rec.bindString(2,"Finfish and Shellfish Products");
            insert_category_rec.executeInsert();
            insert_category_rec.bindLong(1, 1600); insert_category_rec.bindString(2,"Legumes and Legume Products");
            insert_category_rec.executeInsert();
            insert_category_rec.bindLong(1, 1700); insert_category_rec.bindString(2,"Lamb, Veal, and Game Products");
            insert_category_rec.executeInsert();
            insert_category_rec.bindLong(1, 1800); insert_category_rec.bindString(2,"Baked Products");
            insert_category_rec.executeInsert();
            insert_category_rec.bindLong(1, 1900); insert_category_rec.bindString(2,"Sweets");
            insert_category_rec.executeInsert();
            insert_category_rec.bindLong(1, 2000); insert_category_rec.bindString(2,"Cereal Grains and Pasta");
            insert_category_rec.executeInsert();
            insert_category_rec.bindLong(1, 2100); insert_category_rec.bindString(2,"Fast Foods");
            insert_category_rec.executeInsert();
            insert_category_rec.bindLong(1, 2200); insert_category_rec.bindString(2,"Meals, Entrees, and Side Dishes");
            insert_category_rec.executeInsert();
            insert_category_rec.bindLong(1, 2500); insert_category_rec.bindString(2,"Snacks");
            insert_category_rec.executeInsert();
            insert_category_rec.bindLong(1, 3500); insert_category_rec.bindString(2,"American Indian/Alaska Native Foods");
            insert_category_rec.executeInsert();
            insert_category_rec.bindLong(1, 3600); insert_category_rec.bindString(2,"Restaurant Foods");
            insert_category_rec.executeInsert();
            insert_category_rec.bindLong(1, 7000); insert_category_rec.bindString(2,"Personal Care");
            insert_category_rec.executeInsert();
            insert_category_rec.bindLong(1, 8000); insert_category_rec.bindString(2,"Pharmacy");
            insert_category_rec.executeInsert();
            insert_category_rec.bindLong(1, 9000); insert_category_rec.bindString(2,"Household");
            insert_category_rec.executeInsert();
            Log.d(LOG_TAG, "Finished populating category table");

            //populate unit table
            SQLiteStatement insert_unit_rec = db.compileStatement("INSERT INTO " + UnitTable.UnitEntry.TABLE_NAME + " (unit_name) VALUES (?); ");
            insert_unit_rec.bindString(1, "pound");
            insert_unit_rec.executeInsert();
            insert_unit_rec.bindString(1, "ounce");
            insert_unit_rec.executeInsert();
            insert_unit_rec.bindString(1, "gallon");
            insert_unit_rec.executeInsert();
            insert_unit_rec.bindString(1, "liter");
            insert_unit_rec.executeInsert();
            insert_unit_rec.bindString(1, "quart");
            insert_unit_rec.executeInsert();
            insert_unit_rec.bindString(1, "pint");
            insert_unit_rec.executeInsert();
            insert_unit_rec.bindString(1, "gram");
            insert_unit_rec.executeInsert();
            insert_unit_rec.bindString(1, "kilogram");
            insert_unit_rec.executeInsert();
            Log.d(LOG_TAG, "Finished populating unit table");

            //populate all_item table
            SQLiteStatement insert_allitem_rec = db.compileStatement("INSERT INTO " + AllItemTable.AllItemEntry.TABLE_NAME + " (item_id, item_name, category_id) VALUES (?, ?, ?); ");
            insert_allitem_rec.bindString(1, "01009");
            insert_allitem_rec.bindString(2, "Cheese, cheddar");
            insert_allitem_rec.bindString(3, "0100");
            insert_allitem_rec.executeInsert();
            insert_allitem_rec.bindString(1, "01079");
            insert_allitem_rec.bindString(2, "Milk, 2%");
            insert_allitem_rec.bindString(3, "0100");
            insert_allitem_rec.executeInsert();
            insert_allitem_rec.bindString(1, "01179");
            insert_allitem_rec.bindString(2, "Sour cream, light");
            insert_allitem_rec.bindString(3, "0100");
            insert_allitem_rec.executeInsert();
            insert_allitem_rec.bindString(1, "11124");
            insert_allitem_rec.bindString(2, "Carrots, raw");
            insert_allitem_rec.bindString(3, "1100");
            insert_allitem_rec.executeInsert();
            insert_allitem_rec.bindString(1, "11135");
            insert_allitem_rec.bindString(2, "Cauliflower, raw");
            insert_allitem_rec.bindString(3, "1100");
            insert_allitem_rec.executeInsert();
            insert_allitem_rec.bindString(1, "11167");
            insert_allitem_rec.bindString(2, "Corn, sweet, yellow, raw");
            insert_allitem_rec.bindString(3, "1100");
            insert_allitem_rec.executeInsert();

            //populate list table with sample list
            db.execSQL(POPULATE_LIST_TABLE);

            //populate item table for sample list
            SQLiteStatement insert_item_rec = db.compileStatement("INSERT INTO " + ItemTable.ItemEntry.TABLE_NAME + " (list_id, item_id, item_name, category_id) VALUES (?, ?, ?, ?); ");
            insert_item_rec.bindString(1, "1");
            insert_item_rec.bindString(2, "01009");
            insert_item_rec.bindString(3, "Cheese, cheddar");
            insert_item_rec.bindString(4, "0100");
            insert_item_rec.executeInsert();
            insert_item_rec.bindString(1, "1");
            insert_item_rec.bindString(2, "01079");
            insert_item_rec.bindString(3, "Milk, 2%");
            insert_item_rec.bindString(4, "0100");
            insert_item_rec.executeInsert();
            insert_item_rec.bindString(1, "1");
            insert_item_rec.bindString(2, "01179");
            insert_item_rec.bindString(3, "Sour cream, light");
            insert_item_rec.bindString(4, "0100");
            insert_item_rec.executeInsert();

            //update all_item table with items on sample list
            SQLiteStatement update_allitem_rec = db.compileStatement("UPDATE " + AllItemTable.AllItemEntry.TABLE_NAME + " SET used = 'Y' WHERE item_id = ?; ");
            update_allitem_rec.bindString(1, "01009");
            update_allitem_rec.executeInsert();
            update_allitem_rec.bindString(1, "01079");
            update_allitem_rec.executeInsert();
            update_allitem_rec.bindString(1, "01179");
            update_allitem_rec.executeInsert();

            Log.d(LOG_TAG, "Finished loading database");
            db.setTransactionSuccessful();
        } catch (SQLException e){
            Log.d(LOG_TAG, "Error creating database " + e.getMessage());
        } finally {
            db.endTransaction();
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
                    CategoryTable.CategoryEntry.COLUMN_NAME_CATEGORY_ID +  " INTEGER," +
                    CategoryTable.CategoryEntry.COLUMN_NAME_CATEGORY_NAME +  " TEXT)";

    private static final String CREATE_UNIT_TABLE =
            "CREATE TABLE " + UnitTable.UnitEntry.TABLE_NAME + "(" +
                    UnitTable.UnitEntry._ID + " INTEGER PRIMARY KEY," +
                    UnitTable.UnitEntry.COLUMN_NAME_UNIT_NAME +  " TEXT)";

    private static final String CREATE_ITEM_TABLE =
            "CREATE TABLE " + ItemTable.ItemEntry.TABLE_NAME + "(" +
                    ItemTable.ItemEntry._ID + " INTEGER PRIMARY KEY," +
                    ItemTable.ItemEntry.COLUMN_NAME_LIST_ID + " INTEGER," +
                    ItemTable.ItemEntry.COLUMN_NAME_ITEM_ID + " INTEGER," +
                    ItemTable.ItemEntry.COLUMN_NAME_ITEM_NAME + " TEXT," +
                    ItemTable.ItemEntry.COLUMN_NAME_CATEGORY_ID + " INTEGER," +
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

    private static final String CREATE_ALLITEM_TABLE =
            "CREATE TABLE " + AllItemTable.AllItemEntry.TABLE_NAME + "(" +
                    AllItemTable.AllItemEntry._ID + " INTEGER PRIMARY KEY," +
                    AllItemTable.AllItemEntry.COLUMN_NAME_ITEM_ID + " INTEGER," +
                    AllItemTable.AllItemEntry.COLUMN_NAME_ITEM_NAME + " TEXT," +
                    AllItemTable.AllItemEntry.COLUMN_NAME_CATEGORY_ID + " INTEGER," +
                    AllItemTable.AllItemEntry.COLUMN_NAME_USED + " TEXT)";

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
