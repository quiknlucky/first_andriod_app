package com.example.nate.second_app;

import android.provider.BaseColumns;

/**
 * Created by Nate on 7/18/2017.
 */

public final class ListTable {
    private ListTable(){}

    public static class ListEntry implements BaseColumns {
        public static final String TABLE_NAME = "list";
        public static final String COLUMN_NAME_LIST_NAME = "list_name";
    }
}
