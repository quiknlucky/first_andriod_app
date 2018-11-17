package com.example.nate.second_app;

import android.provider.BaseColumns;

/**
 * Created by Nate on 4/06/2018.
 */

public final  class HistoryTable {
    private HistoryTable(){}

    public static class HistoryEntry implements BaseColumns {
        public static final String TABLE_NAME = "item_history";
        public static final String COLUMN_NAME_ITEM_NAME = "item_name";
        public static final String COLUMN_NAME_CATEGORY_ID = "category_id";
        public static final String COLUMN_NAME_QUANTITY = "quantity";
        public static final String COLUMN_NAME_QUANTITY_UNIT = "quantity_unit";
        public static final String COLUMN_NAME_UNIT_PRICE = "unit_price";
        public static final String COLUMN_NAME_TOTAL_PRICE = "total_price";
        public static final String COLUMN_NAME_STORE = "store";
        public static final String COLUMN_NAME_DATE = "purchase_date";
    }
}
