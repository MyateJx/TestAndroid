package com.myatejx.test.test_json.convert;

import com.alibaba.fastjson.JSON;
import com.myatejx.test.bean.TestEntity;

import java.util.List;

/**
 * Created by admin on 2018/4/12.
 */

public class FastJsonConvert implements IJsonConvert {
    @Override
    public String objectToJson(TestEntity entity) {
        return JSON.toJSONString(entity);
    }

    @Override
    public String arrayToJson(List<TestEntity> entities) {
        return JSON.toJSONString(entities);
    }

    @Override
    public TestEntity jsonToObject(String json) {
        return JSON.parseObject(json, TestEntity.class);
    }

    @Override
    public List<TestEntity> jsonToArray(String jsonArray) {
        return JSON.parseArray(jsonArray, TestEntity.class);
    }
}
