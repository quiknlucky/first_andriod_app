package com.example.nate.second_app;

import android.provider.BaseColumns;

public class UnitCategoryTable {
    private UnitCategoryTable(){}

    public static class UnitCategoryEntry implements BaseColumns {
        public static final String TABLE_NAME = "unit_category";
        public static final String COLUMN_NAME_STORE_NAME = "unit_category_name";
    }
}
