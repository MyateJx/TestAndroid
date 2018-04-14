package com.myatejx.test.test_database.operate;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.myatejx.test.bean.TestEntity;
import com.myatejx.test.test_database.operate.greendao.DaoMaster;
import com.myatejx.test.test_database.operate.greendao.DaoSession;
import com.myatejx.test.test_database.operate.greendao.TestEntityDao;

import java.util.List;

/**
 * Created by admin on 2018/4/12.
 */

public class GreendaoManager implements IDatabaseManager {

    private final static String DB_NAME = "TEST_DB_GREEN";

    private static GreendaoManager INSTANCE;
    private TestEntityDao mTestEntityDao;

    public static GreendaoManager getInstance(Context context, String path) {
        if (INSTANCE == null) {
            INSTANCE = new GreendaoManager(context.getApplicationContext(), path);
        }
        return INSTANCE;
    }

    public static GreendaoManager getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new GreendaoManager(context.getApplicationContext(), DB_NAME);
        }
        return INSTANCE;
    }

    private GreendaoManager(Context context, String path) {
        DaoMaster.DevOpenHelper dbHelper = new DaoMaster.DevOpenHelper(context, path);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        DaoSession daoSession = daoMaster.newSession();
        mTestEntityDao = daoSession.getTestEntityDao();
    }

    @Override
    public List<TestEntity> selectList() {
        return mTestEntityDao.queryBuilder().build().list();
    }

    @Override
    public TestEntity selectEntity() {
        return mTestEntityDao.queryBuilder().limit(1).build().unique();
    }

    @Override
    public long insertEntity(TestEntity entity) {
        return mTestEntityDao.insert(entity);
    }

    @Override
    public long updateEntity(TestEntity entity) {
        mTestEntityDao.update(entity);
        return 0;
    }

    @Override
    public long saveEntity(TestEntity entity) {
        return mTestEntityDao.insertOrReplace(entity);
    }

    @Override
    public long deleteEntity(TestEntity entity) {
        mTestEntityDao.delete(entity);
        return 0;
    }

    @Override
    public boolean insertEntities(List<TestEntity> entities) {
        mTestEntityDao.insertInTx(entities);
        return true;
    }

    @Override
    public boolean updateEntities(List<TestEntity> entities) {
        mTestEntityDao.updateInTx(entities);
        return true;
    }

    @Override
    public boolean saveEntities(List<TestEntity> entities) {
        mTestEntityDao.insertOrReplaceInTx(entities);
        return true;
    }

    @Override
    public boolean deleteEntities(List<TestEntity> entities) {
        mTestEntityDao.deleteInTx(entities);
        return true;
    }
}
