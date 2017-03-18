package com.kaivanshah.assignment73;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;

import java.io.ByteArrayOutputStream;

/**
 * Created by kaivanrasiklal.s on 17-03-2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "EMPLOYEE6.DB";
    public static final int DATABASE_VERSION = 1;

    // Contacts table name
    private static final String TABLE_EMP = "EMPLOYEE";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_AGE = "age";
    private static final String KEY_PhotoURL = "photoURL";
    private static final String KEY_PhotoBLOB = "photoBLOB";



    public DBHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_EMP_TABLE = "CREATE TABLE " + TABLE_EMP + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_AGE + " INT, " + KEY_PhotoURL + " INT, " + KEY_PhotoBLOB + " BLOB)";
        db.execSQL(CREATE_EMP_TABLE);



        ContentValues values = new ContentValues();
        values.put(KEY_NAME, "Kaivan"); // Employee Name
        values.put(KEY_AGE, 31); // Age
        values.put(KEY_PhotoURL, R.drawable.android); // Photo URLe
        // Inserting Row
        db.insert(TABLE_EMP, null, values);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EMP);
        // Create tables again
        onCreate(db);

    }


    //getEmployee()
    // Getting single Employee
    public Employee getEmployee(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_EMP, new String[] { KEY_ID,
                        KEY_NAME, KEY_AGE, KEY_PhotoURL }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Employee oEmployee = new Employee(Integer.parseInt(cursor.getString(0)),cursor.getString(1), Integer.parseInt(cursor.getString(2)), Integer.parseInt(cursor.getString(3)));
        // return Employee
        return oEmployee;
    }



    /**
     * @param bitmap
     * Bitmap object from which you want to get bytes
     * @return byte[] array of bytes by compressing the bitmap to PNG format <br/>
     * null if bitmap passed is null (or) failed to get bytes from the
     * bitmap
     */
    public static byte[] convertBitmapToByteArray(Bitmap bitmap)
    {
        if (bitmap == null) {
            return null;
        } else {
            byte[] b = null;
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
                b = byteArrayOutputStream.toByteArray();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return b;
        }
    }


    //updateEmployee()
    // Updating single contact
    public int UpdateEmployee(int id, Bitmap oBitmap) {
        byte[] oByte = convertBitmapToByteArray(oBitmap);
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, "Kaivan");
        values.put(KEY_PhotoBLOB, oByte);
        // updating row
        return db.update(TABLE_EMP, values, KEY_ID + " = ?",
                new String[] { String.valueOf(id) });
    }
}
