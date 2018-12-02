package com.example.nate.second_app;

import android.provider.BaseColumns;

/**
 * Created by Nate on 11/23/2018.
 */

public class AllItemTable {
    private AllItemTable(){}

    public static class AllItemEntry implements BaseColumns {
        public static final String TABLE_NAME = "all_item";
        public static final String COLUMN_NAME_ITEM_ID = "item_id";
        public static final String COLUMN_NAME_ITEM_NAME = "item_name";
        public static final String COLUMN_NAME_CATEGORY_ID = "category_id";
        public static final String COLUMN_NAME_USED = "used";
    }
}
