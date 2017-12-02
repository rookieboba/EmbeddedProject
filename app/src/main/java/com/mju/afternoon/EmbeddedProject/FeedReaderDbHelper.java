package com.mju.afternoon.EmbeddedProject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Kim Myoung jae on 2017-11-26.
 */

public class FeedReaderDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "userdb.db";

    public FeedReaderDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(com.mju.afternoon.EmbeddedProject.FeedReaderContract.SQL_DELETE_ENTRIES);
        db.execSQL(com.mju.afternoon.EmbeddedProject.FeedReaderContract.SQL_CREATE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(com.mju.afternoon.EmbeddedProject.FeedReaderContract.SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(com.mju.afternoon.EmbeddedProject.FeedReaderContract.SQL_DELETE_ENTRIES);
    }
}
