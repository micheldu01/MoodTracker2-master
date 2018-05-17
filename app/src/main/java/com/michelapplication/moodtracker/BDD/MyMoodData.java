package com.michelapplication.moodtracker.BDD;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by michel on 29/11/2017.
 */

public class MyMoodData extends SQLiteOpenHelper {

    private static final String TABLE_MOODS = "table_moods";
    private static final String COL_ID = "ID";
    private static final String COL_COLOR = "COLOR";
    private static final String COL_SIZE_COLOR = "SIZE_COLOR";
    private static final String COL_COMMENT = "COMMENT";

    private static final String CREATE_BDD = "CREATE TABLE "
            + TABLE_MOODS + " ("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_COLOR + " INTEGER, "
            + COL_SIZE_COLOR + " FLOAT,"
            + COL_COMMENT + " TEXT);";

    public MyMoodData(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //CREATE_BDD
        db.execSQL(CREATE_BDD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //DELETE AND CREATE NEW TABLE
        db.execSQL("DROP TABLE " + TABLE_MOODS + ";");
        onCreate(db);
    }
}
