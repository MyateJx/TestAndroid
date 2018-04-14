package com.myatejx.test.test_database.operate;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.myatejx.test.bean.TestEntity;
import com.myatejx.test.test_database.operate.nativedb.TestEntityOpenHelper;

import java.util.ArrayList;
import java.util.List;

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

public class NativeDbManager implements IDatabaseManager {

    private static NativeDbManager INSTANCE;
    private TestEntityOpenHelper mDbHelper;
    private SQLiteDatabase mDb;

    public static NativeDbManager getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new NativeDbManager(context.getApplicationContext());
        }
        return INSTANCE;
    }

    public static NativeDbManager getInstance(Context context, String path) {
        if (INSTANCE == null) {
            INSTANCE = new NativeDbManager(context.getApplicationContext(), path);
        }
        return INSTANCE;
    }

    private NativeDbManager(Context context) {
        mDbHelper = new TestEntityOpenHelper(context);
    }

    private NativeDbManager(Context context, String dbPath) {
        mDbHelper = new TestEntityOpenHelper(context, dbPath);
    }

    @Override
    public List<TestEntity> selectList() {
        mDb = mDbHelper.getWritableDatabase();
        String sql = " select * from " + TABLE_NAME;
        Cursor cursor = mDb.rawQuery(sql, new String[]{});
        List<TestEntity> list = new ArrayList<>();
        try {
            while (cursor.moveToNext()) {
                list.add(fitEntity(cursor));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cursor.close();
            mDb.close();
        }
        return list;
    }

    @Override
    public TestEntity selectEntity() {
        mDb = mDbHelper.getWritableDatabase();
        String sql = " select * from " + TABLE_NAME + " limit 1 ";
        Cursor cursor = mDb.rawQuery(sql, new String[]{});
        try {
            cursor.moveToFirst();
            return fitEntity(cursor);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cursor.close();
            mDb.close();
        }
        return new TestEntity();
    }

    private TestEntity fitEntity(Cursor cursor) {
        TestEntity entity = new TestEntity();
        entity.setId(cursor.getLong(cursor.getColumnIndex(FIELD_ID)));
        entity.setName(cursor.getString(cursor.getColumnIndex(FIELD_NAME)));
        entity.setAge(cursor.getInt(cursor.getColumnIndex(FIELD_AGE)));
        entity.setDate(cursor.getString(cursor.getColumnIndex(FIELD_DATE)));
        entity.setAzimuth(cursor.getInt(cursor.getColumnIndex(FIELD_AZIMUTH)));
        entity.setLon(cursor.getDouble(cursor.getColumnIndex(FIELD_LON)));
        entity.setLat(cursor.getDouble(cursor.getColumnIndex(FIELD_LAT)));
        entity.setTimeStamp(cursor.getLong(cursor.getColumnIndex(FIELD_TIMESTAMP)));
        boolean isSelected = cursor.getInt(cursor.getColumnIndex(FIELD_SELECTED)) != 0;
        entity.setSelected(isSelected);
        return entity;
    }

    private ContentValues fitContentValues(TestEntity entity) {
        ContentValues values = new ContentValues();
        if (entity == null) {
            return values;
        }
        values.put(FIELD_NAME, entity.getName());
        values.put(FIELD_AGE, entity.getAge());
        values.put(FIELD_DATE, entity.getDate());
        values.put(FIELD_AZIMUTH, entity.getAzimuth());
        values.put(FIELD_LON, entity.getLon());
        values.put(FIELD_LAT, entity.getLat());
        values.put(FIELD_TIMESTAMP, entity.getTimeStamp());
        values.put(FIELD_SELECTED, entity.isSelected() ? 1 : 0);
        return values;
    }

    @Override
    public long insertEntity(TestEntity entity) {
        mDb = mDbHelper.getWritableDatabase();
        mDb.beginTransaction();
        ContentValues values = fitContentValues(entity);
        try {
            long rowId = mDb.insert(TABLE_NAME, null, values);
            mDb.setTransactionSuccessful();
            return rowId;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mDb.endTransaction();
            mDb.close();
        }
        return -1;
    }

    @Override
    public long updateEntity(TestEntity entity) {
        mDb = mDbHelper.getWritableDatabase();
        mDb.beginTransaction();
        ContentValues values = fitContentValues(entity);
        try {
            long rowId = mDb.update(TABLE_NAME, values, FIELD_ID + " =? ", new String[]{String.valueOf(entity.getId())});
            mDb.setTransactionSuccessful();
            return rowId;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mDb.endTransaction();
            mDb.close();
        }
        return -1;
    }

    @Override
    public long saveEntity(TestEntity entity) {
        mDb = mDbHelper.getWritableDatabase();
        mDb.beginTransaction();
        ContentValues values = fitContentValues(entity);
        try {
            //TODO 没有where，update的情况果真可以？
            long rowId = mDb.replace(TABLE_NAME, null, values);
            mDb.setTransactionSuccessful();
            return rowId;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mDb.endTransaction();
            mDb.close();
        }
        return -1;
    }

    @Override
    public long deleteEntity(TestEntity entity) {
        mDb = mDbHelper.getWritableDatabase();
        mDb.beginTransaction();
        try {
            long rowId = mDb.delete(TABLE_NAME, FIELD_ID + " =? ", new String[]{String.valueOf(entity.getId())});
            mDb.setTransactionSuccessful();
            return rowId;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mDb.endTransaction();
            mDb.close();
        }
        return -1;
    }

    @Override
    public boolean insertEntities(List<TestEntity> entities) {
        mDb = mDbHelper.getWritableDatabase();
        mDb.beginTransaction();
        try {
            for (TestEntity entity : entities) {
                ContentValues values = fitContentValues(entity);
                mDb.insert(TABLE_NAME, null, values);
            }
            mDb.setTransactionSuccessful();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mDb.endTransaction();
            mDb.close();
        }
        return false;
    }

    @Override
    public boolean updateEntities(List<TestEntity> entities) {
        mDb = mDbHelper.getWritableDatabase();
        mDb.beginTransaction();
        try {
            for (TestEntity entity : entities) {
                ContentValues values = fitContentValues(entity);
                mDb.update(TABLE_NAME, values, FIELD_ID + " =? ", new String[]{String.valueOf(entity.getId())});
            }
            mDb.setTransactionSuccessful();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mDb.endTransaction();
            mDb.close();
        }
        return false;
    }

    @Override
    public boolean saveEntities(List<TestEntity> entities) {
        mDb = mDbHelper.getWritableDatabase();
        mDb.beginTransaction();
        try {
            for (TestEntity entity : entities) {
                ContentValues values = fitContentValues(entity);
                mDb.replace(TABLE_NAME, null, values);
            }
            mDb.setTransactionSuccessful();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mDb.endTransaction();
            mDb.close();
        }
        return false;
    }

    @Override
    public boolean deleteEntities(List<TestEntity> entities) {
        mDb = mDbHelper.getWritableDatabase();
        mDb.beginTransaction();
        try {
            for (TestEntity entity : entities) {
                mDb.delete(TABLE_NAME, FIELD_ID + " =? ", new String[]{String.valueOf(entity.getId())});
            }
            mDb.setTransactionSuccessful();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mDb.endTransaction();
            mDb.close();
        }
        return false;
    }

}