package com.example.moviereviewv3;

import android.provider.BaseColumns;

public class Contract_Review implements BaseColumns{
    public static final String TABLE_NAME = "reviews";
    public static final String COLUMN_ID = BaseColumns._ID;
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_RATING = "rating";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_MOVIE_NAME = "movie";
    public static final String COLUMN_USER_NAME = "user";

    // SQL queries
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "(" +
                    COLUMN_ID + " INTEGER, " +
                    COLUMN_USER_NAME + " TEXT, "+
                    COLUMN_MOVIE_NAME + " TEXT, "+
                    COLUMN_RATING + " FLOAT, "+
                    COLUMN_TITLE + " TEXT, "+
                    COLUMN_DESCRIPTION + " TEXT,"+
                    "PRIMARY KEY("+COLUMN_MOVIE_NAME+","+COLUMN_USER_NAME+"))";

    public static final String DELETE_TABLE =
            "DROP TABLE IF EXISTS " + TABLE_NAME;

    public static final String READ_ALL_TABLE = "SELECT * FROM "+ TABLE_NAME;
}
