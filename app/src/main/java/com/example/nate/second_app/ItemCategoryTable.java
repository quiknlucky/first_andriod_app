package com.example.nate.second_app;

import android.provider.BaseColumns;

/**
 * Created by Nate on 4/06/2018.
 */

public final class ItemCategoryTable {
    private ItemCategoryTable(){}

    public static class ItemCategoryEntry implements BaseColumns {
        public static final String TABLE_NAME = "item_category";
        public static final String COLUMN_NAME_STORE_NAME = "item_category_name";
    }
}
