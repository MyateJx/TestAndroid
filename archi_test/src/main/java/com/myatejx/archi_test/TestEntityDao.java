package com.myatejx.archi_test;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by admin on 2018/4/13.
 */

public interface TestEntityDao {

    @Query("select * from test_entity")
    LiveData<List<TestEntity>> selectList();

    @Query("select * from test_entity where id = :id")
    LiveData<TestEntity> selectEntity(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertEntity(TestEntity entity);

    @Update
    long updateEntity(TestEntity entity);

//    long saveEntity(TestEntity entity);

    @Delete
    long deleteEntity(TestEntity entity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    boolean insertEntities(List<TestEntity> entities);

    @Update
    boolean updateEntities(List<TestEntity> entities);

//    boolean saveEntities(List<TestEntity> entities);

    @Delete
    boolean deleteEntities(List<TestEntity> entities);

}
