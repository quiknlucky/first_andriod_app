package com.example.nate.second_app;

import android.provider.BaseColumns;

/**
 * Created by Nate on 4/06/2018.
 */

public final class CategoryTable {
    private CategoryTable(){}

    public static class CategoryEntry implements BaseColumns {
        public static final String TABLE_NAME = "category";
        public static final String COLUMN_NAME_CATEGORY_ID = "category_id";
        public static final String COLUMN_NAME_CATEGORY_NAME = "category_name";
    }
}
