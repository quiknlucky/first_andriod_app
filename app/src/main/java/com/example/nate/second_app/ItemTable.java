package com.example.nate.second_app;

import android.provider.BaseColumns;

/**
 * Created by Nate on 3/31/2018.
 */

public final class ItemTable {
    private ItemTable(){}

    public static class ItemEntry implements BaseColumns {
        public static final String TABLE_NAME = "item";
        public static final String COLUMN_NAME_ITEM_NAME = "item_name";
        public static final String COLUMN_NAME_LAST_PRICE = "last_price";
        public static final String COLUMN_NAME_AVG_PRICE = "avg_price";
        public static final String COLUMN_NAME_MIN_PRICE = "min_price";
        public static final String COLUMN_NAME_MAX_PRICE = "max_price";
        public static final String COLUMN_NAME_LAST_STORE = "last_store";
        public static final String COLUMN_NAME_LAST_DATE = "last_date";
    }
}
