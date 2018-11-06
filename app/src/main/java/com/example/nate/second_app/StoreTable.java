package com.example.nate.second_app;

import android.provider.BaseColumns;

/**
 * Created by Nate on 4/06/2018.
 */

public final class StoreTable {
    private StoreTable(){}

    public static class StoreEntry implements BaseColumns {
        public static final String TABLE_NAME = "store";
        public static final String COLUMN_NAME_STORE_NAME = "store_name";
    }
}
