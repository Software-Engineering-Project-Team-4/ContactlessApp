package com.attendance.contactless;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {
    private static final String DB_NAME = "attendancedb";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "attendance";
    private static final String ID_COL = "id";
    private static final String FIRST_COL = "firstname";
    private static final String LAST_COL = "lastname";
//    private static final int NUMBER_COLUMN = ; //StudentID
    private static final String PROF_COL = "professor";
    private static final String ATTEND_COL = "attendance";
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " int PRIMARY KEY AUTOINCREMENT, "
                + FIRST_COL + " TEXT,"
                + LAST_COL + " TEXT,"
               // + NUMBER_COLUMN + " int,"
                + PROF_COL + " TEXT,"
                + ATTEND_COL + " TEXT)";
        db.execSQL(query);
    }
    // adds student to database.
    public void addNewStudent(String firstName, String lastName, Integer StudentID, String professor) {
        int attend =1;
        SQLiteDatabase db = this.getWritableDatabase();

        // stores content values.
        ContentValues values = new ContentValues();

        // passes student info to values
        values.put(FIRST_COL, firstName);
        values.put(LAST_COL, lastName);
       // values.put(NUMBER_COLUMN, StudentID)
        values.put(PROF_COL, professor);
        values.put(ATTEND_COL, attend);

        // inserts data into database
        db.insert(TABLE_NAME, null, values);
        db.close();
    }
    public ArrayList<Modal> readAttend() {
        // creates a readable database
        SQLiteDatabase db = this.getReadableDatabase();

        // reads data from database
        Cursor cursorAttend = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        ArrayList<Modal> modalArrayList = new ArrayList<>();

        // moves cursor to first position
        if (cursorAttend.moveToFirst()) {
            do {
                // stores data from database
                modalArrayList.add(new Modal(cursorAttend.getString(1),
                        cursorAttend.getString(2),
                        cursorAttend.getInt(4),
                        cursorAttend.getString(3)));
            } while (cursorAttend.moveToNext());
        }
        cursorAttend.close();
        return modalArrayList;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // checks if table already exists
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addNewStudent(String firstName, String lastName, String professor) {
    }
}
