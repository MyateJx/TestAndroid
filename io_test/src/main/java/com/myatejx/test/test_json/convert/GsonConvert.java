package com.myatejx.test.test_json.convert;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.myatejx.test.bean.TestEntity;

import java.util.List;

/**
 * Created by admin on 2018/4/12.
 */

public class GsonConvert implements IJsonConvert {

    Gson gson = new Gson();

    @Override
    public String objectToJson(TestEntity entity) {
        return gson.toJson(entity);
    }

    @Override
    public String arrayToJson(List<TestEntity> entities) {
        return gson.toJson(entities);
    }

    @Override
    public TestEntity jsonToObject(String json) {
        return gson.fromJson(json, TestEntity.class);
    }

    @Override
    public List<TestEntity> jsonToArray(String jsonArray) {
        return gson.fromJson(jsonArray, new TypeToken<List<TestEntity>>() {
        }.getType());
    }
}
