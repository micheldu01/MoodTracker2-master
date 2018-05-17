package com.michelapplication.moodtracker.BDD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by michel on 29/11/2017.
 */

public class MoodBDD {

    private static final int VERSION_BDD = 1;
    private static final String NOM_BDD = "mood10.dbb";
    private static final String TABLE_MOODS = "table_moods";
    private static final String COL_ID = "ID";
    private static final int NUM_COL_ID = 0;
    private static final String COL_COLOR = "COLOR";
    private static final int NUM_COL_COLOR = 1;
    private static final String COL_SIZE_COLOR = "SIZE_COLOR";
    private static final int NUM_COL_SIZE_COLOR = 2;
    private static final String COL_COMMENT = "COMMENT";
    private static final int NUM_COL_COMMENT = 3;

    private SQLiteDatabase bdd;

    private MyMoodData maBaseSQLite;

    public MoodBDD(Context context) {
        //CREATE BDD AND TABLE
        maBaseSQLite = new MyMoodData(context, NOM_BDD, null, VERSION_BDD);
    }

    public void open() {
        //OPEN FOR WRITE
        bdd = maBaseSQLite.getWritableDatabase();
    }

    public void close() {
        //CLOSE BDD
        bdd.close();
    }

    public SQLiteDatabase getBDD() {
        return bdd;
    }

    public long insertMood(Mood mood) {
        //create ContentValues
        ContentValues values = new ContentValues();
        //add values and keys
        values.put(COL_COLOR, mood.getColor());
        values.put(COL_SIZE_COLOR, mood.getSizeColor());
        values.put(COL_COMMENT, mood.getComment());
        //on insère l'objet dans la BDD via le ContentValues
        return bdd.insert(TABLE_MOODS, null, values);
    }

    public ArrayList<Mood> getMood() {
        String selecquery = "SELECT * FROM table_moods";
        Cursor c = bdd.rawQuery(selecquery, null);
        ArrayList<Mood> michelArray = new ArrayList<>();
        if (c.getCount() == 0)
            return null;
        if (c.moveToFirst()) {
            while (c.moveToNext()) {
                Mood mood = cursorToMood(c);
                michelArray.add(mood);
            }
        }return michelArray;
    }

    public Mood cursorToMood(Cursor c) {
        //On créé un livre
        Mood mood = new Mood();
        //on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
        mood.setColor(c.getInt(NUM_COL_COLOR));
        mood.setSizeColor(c.getFloat(NUM_COL_SIZE_COLOR));
        mood.setComment(c.getString(NUM_COL_COMMENT));
        //On ferme le cursor
        //c.close();
        return mood;
    }
}
