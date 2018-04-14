package com.myatejx.test.test_database.operate.nativedb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.myatejx.test.contract.TestEntityContract.FIELD_AGE;
import static com.myatejx.test.contract.TestEntityContract.FIELD_AZIMUTH;
import static com.myatejx.test.contract.TestEntityContract.FIELD_DATE;
import static com.myatejx.test.contract.TestEntityContract.FIELD_ID;
import static com.myatejx.test.contract.TestEntityContract.FIELD_LAT;
import static com.myatejx.test.contract.TestEntityContract.FIELD_LON;
import static com.myatejx.test.contract.TestEntityContract.FIELD_NAME;
import static com.myatejx.test.contract.TestEntityContract.FIELD_SELECTED;
import static com.myatejx.test.contract.TestEntityContract.FIELD_TIMESTAMP;
import static com.myatejx.test.contract.TestEntityContract.TABLE_NAME;

/**
 * Created by admin on 2018/4/12.
 */

public class TestEntityOpenHelper extends SQLiteOpenHelper {

    private final static int DB_VERSION = 1;

    private final static String DB_NAME = " TEST_DB ";

    private final static String COMMA = ",";
    private final static String TYPE_TEXT = " TEXT ";
    private final static String TYPE_INTEGER = " INTEGER ";
    private final static String TYPE_REAL = " REAL ";
    private final static String NOT_NULL = " NOT NULL ";
    private final static String PRIMARY_KEY = " PRIMARY KEY AUTOINCREMENT ";

    private final static String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "("
            + FIELD_ID + TYPE_INTEGER + PRIMARY_KEY + COMMA
            + FIELD_TIMESTAMP + TYPE_INTEGER + COMMA
            + FIELD_NAME + TYPE_TEXT + COMMA
            + FIELD_AGE + TYPE_INTEGER + COMMA
            + FIELD_DATE + TYPE_TEXT + COMMA
            + FIELD_AZIMUTH + TYPE_INTEGER + COMMA
            + FIELD_LAT + TYPE_REAL + COMMA
            + FIELD_LON + TYPE_REAL + COMMA
            + FIELD_SELECTED + TYPE_INTEGER
            + ")";

    public TestEntityOpenHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    /**
     * @param context
     * @param path    数据库db文件的完整路径。用于外部存储。
     */
    public TestEntityOpenHelper(Context context, String path) {
        super(context, path, null, DB_VERSION);
    }

    public TestEntityOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }
}
