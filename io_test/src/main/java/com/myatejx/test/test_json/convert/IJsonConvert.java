package com.myatejx.test.test_json.convert;

import com.myatejx.test.bean.TestEntity;

import java.util.List;

/**
 * Created by admin on 2018/4/11.
 */

public interface IJsonConvert {

    String objectToJson(TestEntity entity);

    String arrayToJson(List<TestEntity> entities);

    TestEntity jsonToObject(String json);

    List<TestEntity> jsonToArray(String jsonArray);

}
