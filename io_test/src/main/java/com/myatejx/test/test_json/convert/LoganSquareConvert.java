package com.myatejx.test.test_json.convert;

import com.bluelinelabs.logansquare.LoganSquare;
import com.myatejx.test.bean.TestEntity;

import java.io.IOException;
import java.util.List;

/**
 * Created by admin on 2018/4/12.
 */

public class LoganSquareConvert implements IJsonConvert {
    @Override
    public String objectToJson(TestEntity entity) {
        try {
            return LoganSquare.serialize(entity);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String arrayToJson(List<TestEntity> entities) {
        try {
            return LoganSquare.serialize(entities);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public TestEntity jsonToObject(String json) {
        try {
            return LoganSquare.parse(json, TestEntity.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<TestEntity> jsonToArray(String jsonArray) {
        try {
            return LoganSquare.parseList(jsonArray, TestEntity.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
