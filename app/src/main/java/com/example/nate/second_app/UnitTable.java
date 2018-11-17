package com.example.nate.second_app;

import android.provider.BaseColumns;

public class UnitTable {
    private UnitTable(){}

    public static class UnitEntry implements BaseColumns {
        public static final String TABLE_NAME = "unit";
        public static final String COLUMN_NAME_UNIT_NAME = "unit_name";
    }
}
