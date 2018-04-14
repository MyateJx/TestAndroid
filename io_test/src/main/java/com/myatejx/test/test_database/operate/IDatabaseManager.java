package com.myatejx.test.test_database.operate;

import com.myatejx.test.bean.TestEntity;

import java.util.List;

/**
 * Created by admin on 2018/4/12.
 */

public interface IDatabaseManager {

    List<TestEntity> selectList();

    TestEntity selectEntity();

    long insertEntity(TestEntity entity);

    long updateEntity(TestEntity entity);

    long saveEntity(TestEntity entity);

    long deleteEntity(TestEntity entity);

    boolean insertEntities(List<TestEntity> entities);

    boolean updateEntities(List<TestEntity> entities);

    boolean saveEntities(List<TestEntity> entities);

    boolean deleteEntities(List<TestEntity> entities);

}
