package com.example.moviereviewv3;

import android.provider.BaseColumns;

public class Contract_Actor implements BaseColumns {
        // Tables and Column names
        public static final String TABLE_NAME = "actor";
        public static final String COLUMN_ID = BaseColumns._ID;
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_AGE = "age";
        public static final String COLUMN_IMAGE = "image";
        public static final String COLUMN_DETAIL = "detail";
        public static final String COLUMN_MOVIES = "movies";
        public static final String COLUMN_ROLE = "role";
        public static final String COLUMN_DOB = "date_of_birth";

        // SQL queries
        public static final String CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME + "(" +
                        COLUMN_ID + " INTEGER PRIMARY KEY, " +
                        COLUMN_IMAGE + " BLOB, "+
                        COLUMN_NAME + " TEXT, " +
                        COLUMN_AGE + " INTEGER, "+
                        COLUMN_DOB + " TEXT, " +
                        COLUMN_MOVIES + " TEXT, " +
                        COLUMN_ROLE + " TEXT, " +
                        COLUMN_DETAIL + " TEXT)";

        public static final String DELETE_TABLE =
                "DROP TABLE IF EXISTS " + TABLE_NAME;

        public static final String READ_ALL_TABLE = "SELECT * FROM "+ TABLE_NAME;
}
