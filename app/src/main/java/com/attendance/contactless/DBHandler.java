package com.attendance.contactless;
import static com.attendance.contactless.MainActivity.studentIDIn;
import static com.attendance.contactless.TeacherActivity.lastnameIn;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Random;

public class DBHandler extends SQLiteOpenHelper {
    private static final String DB_NAME = "attendancedb";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "attendance";
    private static final String ID_COL = "id";
    private static final String FIRST_COL = "firstname";
    private static final String LAST_COL = "lastname";
    private static final String STUDENTID_COL = "studentID";
    private static final String PROF_COL = "professor";
    private static final String ATTEND_COL = "attend";
    private static final String PROF_TABLE = "professor";
    private static final String PROFID_COL = "professorID";
    private static final String PIN_COL = "pin";
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + FIRST_COL + " TEXT,"
                + LAST_COL + " TEXT," + STUDENTID_COL + " TEXT,"
                + PROF_COL + " TEXT,"
                + ATTEND_COL + " TEXT)";
        db.execSQL(query);
        query = "CREATE TABLE " + PROF_TABLE + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + FIRST_COL + " TEXT,"
                + LAST_COL + " TEXT," + PROFID_COL + " TEXT,"
                + PIN_COL + " TEXT)";
        db.execSQL(query);
    }
    // adds professor to database.
    public void addNewStudent(String firstName, String lastName, String professor, String studentID) {
        int attend =1;
        SQLiteDatabase db = this.getWritableDatabase();

        // stores content values.
        ContentValues values = new ContentValues();

        // passes student info to values
        values.put(FIRST_COL, firstName);
        values.put(LAST_COL, lastName);
        values.put(STUDENTID_COL, studentID);
        values.put(PROF_COL, professor);
        values.put(ATTEND_COL, attend);

        // inserts data into database
        db.insert(TABLE_NAME, null, values);
        db.close();
    }
    // adds student to database.
    public void addNewProfessor(String firstName, String lastName, String professorID,String pin) {

        SQLiteDatabase db = this.getWritableDatabase();

        // stores content values.
        ContentValues values = new ContentValues();

        // passes student info to values
        values.put(FIRST_COL, firstName);
        values.put(LAST_COL, lastName);
        values.put(PROFID_COL, professorID);
        values.put(PIN_COL, pin);

        // inserts data into database
        db.insert(PROF_TABLE, null, values);
        db.close();
    }
    public ArrayList<Modal> readAttendProf() {
        // creates a readable database
        SQLiteDatabase db = this.getReadableDatabase();

        // reads data from database
        Cursor cursorAttend = db.rawQuery("SELECT * FROM " + TABLE_NAME+" WHERE "+PROF_COL+ " IS \""+lastnameIn+"\"", null);

        ArrayList<Modal> modalArrayList = new ArrayList<>();

        // moves cursor to first position
        if (cursorAttend.moveToFirst()) {
            do {
                // stores data from database
                modalArrayList.add(new Modal(cursorAttend.getString(1),
                        cursorAttend.getString(2),
                        cursorAttend.getInt(5),
                        cursorAttend.getString(4),cursorAttend.getString(3)));
            } while (cursorAttend.moveToNext());
        }
        cursorAttend.close();
        return modalArrayList;
    }
    public String getpin(String lastname) {

        String rv = "not found";
        SQLiteDatabase db = this.getReadableDatabase();
        String whereclause = LAST_COL+" = ?";
        String[] whereargs = new String[]{lastname};
        Cursor csr = db.query(PROF_TABLE, null, whereclause, whereargs, null, null, null);
        if (csr.moveToFirst()) {
            rv = csr.getString(4);
        }
        return rv;
    }
    public String getLast(String studentID) {

        String rv = "not found";
        SQLiteDatabase db = this.getReadableDatabase();
        String whereclause = STUDENTID_COL+" = ?";
        String[] whereargs = new String[]{studentID};
        Cursor csr = db.query(TABLE_NAME, null, whereclause, whereargs, null, null, null);
        if (csr.moveToFirst()) {
            rv = csr.getString(4);
        }
        return rv;
    }
        public ArrayList<Modal> readAttend() {
        // creates a readable database
        SQLiteDatabase db = this.getReadableDatabase();

        // reads data from database
        Cursor cursorAttend = db.rawQuery("SELECT * FROM " + TABLE_NAME+" WHERE studentID IS \""+studentIDIn+"\"", null);

        ArrayList<Modal> modalArrayList = new ArrayList<>();

        // moves cursor to first position
        if (cursorAttend.moveToFirst()) {
            do {
                // stores data from database
                modalArrayList.add(new Modal(cursorAttend.getString(1),
                        cursorAttend.getString(2),
                        cursorAttend.getInt(5),
                        cursorAttend.getString(4),cursorAttend.getString(3)));
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
    public void updateStudent() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE "+TABLE_NAME + " SET "+ATTEND_COL+" = "+ATTEND_COL+"+1 WHERE "+STUDENTID_COL+" IS \""+studentIDIn+"\"";
        db.execSQL(query);
        db.close();
    }
    public void updateProfessor(String pin) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE "+PROF_TABLE + " SET "+PIN_COL+" = \""+pin+"\" WHERE "+LAST_COL+" IS \""+lastnameIn+"\"";
        db.execSQL(query);
        db.close();
    }
}
