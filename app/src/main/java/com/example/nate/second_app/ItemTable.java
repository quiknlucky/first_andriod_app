package com.example.nate.second_app;

import android.provider.BaseColumns;

/**
 * Created by Nate on 3/31/2018.
 */

public final class ItemTable {
    private ItemTable(){}

    public static class ItemEntry implements BaseColumns {
        public static final String TABLE_NAME = "item";
        public static final String COLUMN_NAME_LIST_ID = "list_id";
        public static final String COLUMN_NAME_ITEM_NAME = "item_name";
        public static final String COLUMN_NAME_CATEGORY = "category";
        public static final String COLUMN_NAME_QUANTITY = "quantity";
        public static final String COLUMN_NAME_QUANTITY_UNIT = "quantity_unit";
        public static final String COLUMN_NAME_LAST_UNIT_PRICE = "last_unit_price";
        public static final String COLUMN_NAME_LAST_TOTAL_PRICE = "last_total_price";
        public static final String COLUMN_NAME_LAST_DATE = "last_date";
        public static final String COLUMN_NAME_LAST_STORE = "last_store";
        public static final String COLUMN_NAME_AVG_PRICE = "avg_price";
        public static final String COLUMN_NAME_MIN_PRICE = "min_price";
        public static final String COLUMN_NAME_MIN_PRICE_DATE = "min_price_date";
        public static final String COLUMN_NAME_MIN_PRICE_STORE = "min_price_store";
        public static final String COLUMN_NAME_MAX_PRICE = "max_price";
    }
}
