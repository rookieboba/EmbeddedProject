package com.mju.afternoon.EmbeddedProject;

import android.provider.BaseColumns;

/**
 * Created by Kim Myoung jae on 2017-11-26.
 */

public class FeedReaderContract {

    public FeedReaderContract() {};

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + FeedEntry.TABLE_NAME + " ( " +
                    FeedEntry._ID + " INTEGER PRIMARY KEY," +
                    FeedEntry.COLUMN_NAME_NAME + " text , " +
                    FeedEntry.COLUMN_NAME_USERID + " text , " +
                    FeedEntry.COLUMN_NAME_PASSWORD + " text "  +
                    FeedEntry.COLUMN_NAME_PHONENUMBER + " text "  +
                    FeedEntry.CONTENT_NAME_REPASSWORD + " ) " ;

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + FeedEntry.TABLE_NAME;

    public static abstract class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "userdb";

        public static final String COLUMN_NAME_NAME = "username";
        public static final String COLUMN_NAME_USERID = "userid";
        public static final String COLUMN_NAME_PASSWORD = "password";
        public static final String CONTENT_NAME_REPASSWORD="repassword";
        public static final String COLUMN_NAME_PHONENUMBER="phonenumber";
    }

}
