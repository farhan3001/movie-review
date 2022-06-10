package com.example.moviereviewv3;

import android.content.Context;
import android.content.SharedPreferences;

public class MySharedPreferences {

    public static final String WRITE_TO_DATABASE_STATUS="WriteToDatabaseStatus";


    public static void setWriteToDatabaseStatus(Context context,Boolean writeToDatabaseStatus)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(WRITE_TO_DATABASE_STATUS,writeToDatabaseStatus);
        editor.commit();
    }
    public static Boolean getWriteToDatabaseStatus(Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(WRITE_TO_DATABASE_STATUS,true);
    }

}
