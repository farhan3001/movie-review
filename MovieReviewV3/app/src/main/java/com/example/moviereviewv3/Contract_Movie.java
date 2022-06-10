package com.example.moviereviewv3;

import android.provider.BaseColumns;

public class Contract_Movie {
    // Tables and Column names
    public static final String TABLE_NAME = "movies";
    public static final String COLUMN_ID = BaseColumns._ID;
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_IMAGE = "image";
    public static final String COLUMN_YEAR = "year";
    public static final String COLUMN_DURATION = "duration";
    public static final String COLUMN_GENRE = "genre";
    public static final String COLUMN_CAST = "cast";
    public static final String COLUMN_DIRECTOR = "director";
    public static final String COLUMN_WRITER = "writer";
    public static final String COLUMN_RATING = "rating";
    public static final String COLUMN_REVIEW_TITLE = "review_title";
    public static final String COLUMN_REVIEW_DESCRIPTION = "review_description";
    public static final String COLUMN_TRAILER_PATH = "trailer_path";
    public static final String COLUMN_DESCRIPTION = "description";

    // SQL queries
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "(" +
                    COLUMN_ID + " INTEGER PRIMARY KEY, " +
                    COLUMN_IMAGE + " BLOB, "+
                    COLUMN_NAME + " TEXT, " +
                    COLUMN_YEAR + " TEXT, "+
                    COLUMN_DURATION + " TEXT, " +
                    COLUMN_GENRE + " TEXT, " +
                    COLUMN_CAST + " TEXT, " +
                    COLUMN_DIRECTOR + " TEXT, " +
                    COLUMN_WRITER + " TEXT, " +
                    COLUMN_REVIEW_TITLE + " TEXT, " +
                    COLUMN_REVIEW_DESCRIPTION + " TEXT, " +
                    COLUMN_TRAILER_PATH + " TEXT, " +
                    COLUMN_RATING + " FLOAT, " +
                    COLUMN_DESCRIPTION + " TEXT)";

    public static final String DELETE_TABLE =
            "DROP TABLE IF EXISTS " + TABLE_NAME;

    public static final String READ_ALL_TABLE = "SELECT * FROM "+ TABLE_NAME;
}
