package com.myatejx.test.test_json.test;

import com.myatejx.test.bean.TestEntity;
import com.myatejx.test.test_json.contract.JsonParserType;
import com.myatejx.test.test_json.convert.FastJsonConvert;
import com.myatejx.test.test_json.convert.GsonConvert;
import com.myatejx.test.test_json.convert.IJsonConvert;
import com.myatejx.test.test_json.convert.NativeJsonConvert;
import com.myatejx.test.utils.TimeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2018/4/11.
 */

public class JsonConvertTest {

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

    //-----------------------测试json-------------------------

    private IJsonConvert mIJsonConvert;

    private IJsonConvert getIJsonConvert(JsonParserType type) {
        switch (type) {
            case NATIVE_JSON:
                return new NativeJsonConvert();
            case FAST_JSON:
                return new FastJsonConvert();
            case GSON:
                return new GsonConvert();
            default:
        }
        return new NativeJsonConvert();
    }

    public String testJson(JsonParserType type, int listSize) {
        mIJsonConvert = getIJsonConvert(type);

        TestEntity entity1 = getEntity(100);
        List<TestEntity> list1 = getEntities(listSize);

        //测试单一对象转json
        long obj2JsonObjStartTime = TimeUtils.getNowMills();
        String aJson = mIJsonConvert.objectToJson(entity1);
        long obj2JsonObjEndTime = TimeUtils.getNowMills();

        //测试list转json数组
        long list2JsonArrayStartTime = TimeUtils.getNowMills();
        String listJson = mIJsonConvert.arrayToJson(list1);
        long list2JsonArrayEndTime = TimeUtils.getNowMills();

        //测试json转单一对象
        long jsonObj2ObjStartTime = TimeUtils.getNowMills();
        TestEntity entity2 = mIJsonConvert.jsonToObject(aJson);
        long jsonObj2ObjEndTime = TimeUtils.getNowMills();

        //测试json数组转list
        long jsonArray2ListStartTime = TimeUtils.getNowMills();
        List<TestEntity> list2 = mIJsonConvert.jsonToArray(listJson);
        long jsonArray2ListEndTime = TimeUtils.getNowMills();

        return "测试" + type.toString() + "---- 对象字段数为8，list size为" + listSize + " \n"
                + "测试单一对象转json: " + (obj2JsonObjEndTime - obj2JsonObjStartTime) + "ms\n"
                + "测试list转json数组: " + (list2JsonArrayEndTime - list2JsonArrayStartTime) + "ms\n"
                + "测试json转单一对象: " + (jsonObj2ObjEndTime - jsonObj2ObjStartTime) + "ms\n"
                + "测试json数组转list: " + (jsonArray2ListEndTime - jsonArray2ListStartTime) + "ms\n";
    }

}
