package com.myatejx.test.test_database.test;

import android.content.Context;
import android.os.Environment;

import com.myatejx.test.bean.TestEntity;
import com.myatejx.test.test_database.contract.DatabaseParserType;
import com.myatejx.test.test_database.operate.GreendaoManager;
import com.myatejx.test.test_database.operate.IDatabaseManager;
import com.myatejx.test.test_database.operate.NativeDbManager;
import com.myatejx.test.utils.TimeUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2018/4/12.
 */

public class DatabaseOperateTest {


    private Context mContext;

    public DatabaseOperateTest(Context context) {
        this.mContext = context;
    }

    private final static String NATIVE_DB_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "nativeDb";
    private final static String GREENDAO_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "greendao";

    private List<TestEntity> getEntities(int size) {
        List<TestEntity> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(getEntity(i));
        }
        return list;
    }

    private TestEntity getEntity(int age) {
        TestEntity entity = new TestEntity();
        entity.setName("name_a");
        entity.setAge(age);
        entity.setDate(TimeUtils.getNowString());
        entity.setTimeStamp(TimeUtils.getNowMills());
        entity.setLon(119.12345678);
        entity.setLat(30.12345678);
        entity.setAzimuth(12);
        entity.setSelected(true);
        return entity;
    }

    //-----------------------测试database-------------------------

    private IDatabaseManager mDatabaseManager;

    private IDatabaseManager getIDatabaseManager(DatabaseParserType type) {
        switch (type) {
            case NATIVE_DB:
                return NativeDbManager.getInstance(mContext, NATIVE_DB_PATH);
            case GREENDAO:
                return GreendaoManager.getInstance(mContext, GREENDAO_PATH);
            case REALM:
                return null;
            case ROOM:
                return null;
            default:
        }
        return NativeDbManager.getInstance(mContext);
    }

    public String testDatabase(DatabaseParserType type, int listSize) {
        mDatabaseManager = getIDatabaseManager(type);

        TestEntity entity1 = getEntity(100);
        List<TestEntity> list1 = getEntities(listSize);

        //测试插入1条数据
        long insert1StartTime = TimeUtils.getNowMills();
        long id = mDatabaseManager.insertEntity(entity1);
        long insert1EndTime = TimeUtils.getNowMills();
        entity1.setId(id);

        //测试更新1条数据
        long update1StartTime = TimeUtils.getNowMills();
        mDatabaseManager.updateEntity(entity1);
        long update1EndTime = TimeUtils.getNowMills();

        //测试保存1条数据
        long save1StartTime = TimeUtils.getNowMills();
//        mDatabaseManager.saveEntity(entity1);
        long save1EndTime = TimeUtils.getNowMills();

        //测试查询1条数据
        long select1StartTime = TimeUtils.getNowMills();
        mDatabaseManager.selectEntity();
        long select1EndTime = TimeUtils.getNowMills();

        //测试删除1条数据
        long delete1StartTime = TimeUtils.getNowMills();
        mDatabaseManager.deleteEntity(entity1);
        long delete1EndTime = TimeUtils.getNowMills();

        //测试插入多条数据
        long insertListStartTime = TimeUtils.getNowMills();
        mDatabaseManager.insertEntities(list1);
        long insertListEndTime = TimeUtils.getNowMills();

        //测试查询多条数据
        list1.clear();
        long selectListStartTime = TimeUtils.getNowMills();
        List<TestEntity> list = mDatabaseManager.selectList();
        long selectListEndTime = TimeUtils.getNowMills();
        list1.addAll(list);

        //测试更新多条数据
        long updateListStartTime = TimeUtils.getNowMills();
        mDatabaseManager.updateEntities(list1);
        long updateListEndTime = TimeUtils.getNowMills();

        //测试保存多条数据
        long saveListStartTime = TimeUtils.getNowMills();
//        mDatabaseManager.saveEntities(list1);
        long saveListEndTime = TimeUtils.getNowMills();

        //测试删除多条数据
        long deleteStartTime = TimeUtils.getNowMills();
        mDatabaseManager.deleteEntities(list1);
        long deleteEndTime = TimeUtils.getNowMills();

        return "测试" + type.toString() + "---- 对象字段数为8，list size为" + listSize + " \n"
                + "测试插入1条数据:  " + (insert1EndTime - insert1StartTime) + "ms\n"
                + "测试更新1条数据:  " + (update1EndTime - update1StartTime) + "ms\n"
//                + "测试保存1条数据: " + (save1EndTime - save1StartTime) + "ms\n"
                + "测试查询1条数据:  " + (select1EndTime - select1StartTime) + "ms\n"
                + "测试删除1条数据:  " + (delete1EndTime - delete1StartTime) + "ms\n"
                + "测试插入多条数据: " + (insertListEndTime - insertListStartTime) + "ms\n"
                + "测试查询多条数据: " + (selectListEndTime - selectListStartTime) + "ms\n"
                + "测试更新多条数据: " + (updateListEndTime - updateListStartTime) + "ms\n"
//                + "测试保存多条数据: " + (saveListEndTime - saveListStartTime) + "ms\n"
                + "测试删除多条数据: " + (deleteEndTime - deleteStartTime) + "ms\n"
                ;
    }

}
