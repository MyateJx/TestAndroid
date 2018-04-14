package com.myatejx.test.test_json.convert;

import com.myatejx.test.bean.TestEntity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.myatejx.test.contract.TestEntityContract.FIELD_AGE;
import static com.myatejx.test.contract.TestEntityContract.FIELD_AZIMUTH;
import static com.myatejx.test.contract.TestEntityContract.FIELD_DATE;
import static com.myatejx.test.contract.TestEntityContract.FIELD_LAT;
import static com.myatejx.test.contract.TestEntityContract.FIELD_LON;
import static com.myatejx.test.contract.TestEntityContract.FIELD_NAME;
import static com.myatejx.test.contract.TestEntityContract.FIELD_SELECTED;
import static com.myatejx.test.contract.TestEntityContract.FIELD_TIMESTAMP;

/**
 * Created by admin on 2018/4/11.
 */

public class NativeJsonConvert implements IJsonConvert {

    //TODO 理论上，这一整个类的方法都可以根据实体类自动生成的，无须像我现在这样手写。


    @Override
    public String objectToJson(TestEntity entity) {
        if (entity == null) {
            return null;
        }
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.putOpt(FIELD_NAME, entity.getName());
            jsonObject.putOpt(FIELD_DATE, entity.getDate());
            jsonObject.putOpt(FIELD_AGE, entity.getAge());
            jsonObject.putOpt(FIELD_TIMESTAMP, entity.getTimeStamp());
            jsonObject.putOpt(FIELD_LON, entity.getLon());
            jsonObject.putOpt(FIELD_LAT, entity.getLat());
            jsonObject.putOpt(FIELD_AZIMUTH, entity.getAzimuth());
            jsonObject.putOpt(FIELD_SELECTED, entity.isSelected());
            return jsonObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String arrayToJson(List<TestEntity> entities) {
        if (entities == null || entities.size() == 0) {
            return null;
        }
        JSONArray jsonArray = new JSONArray();
        try {
            for (int i = 0, length = entities.size(); i < length; i++) {
                TestEntity entity = entities.get(i);
                JSONObject jsonObject = new JSONObject();
                jsonObject.putOpt(FIELD_NAME, entity.getName());
                jsonObject.putOpt(FIELD_DATE, entity.getDate());
                jsonObject.putOpt(FIELD_AGE, entity.getAge());
                jsonObject.putOpt(FIELD_TIMESTAMP, entity.getTimeStamp());
                jsonObject.putOpt(FIELD_LON, entity.getLon());
                jsonObject.putOpt(FIELD_LAT, entity.getLat());
                jsonObject.putOpt(FIELD_AZIMUTH, entity.getAzimuth());
                jsonObject.putOpt(FIELD_SELECTED, entity.isSelected());
                jsonArray.put(jsonObject);
            }
            return jsonArray.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    private TestEntity fitEntity(JSONObject jsonObject) {
        TestEntity entity = new TestEntity();
        entity.setName(jsonObject.optString(FIELD_NAME));
        entity.setDate(jsonObject.optString(FIELD_DATE));
        entity.setAge(jsonObject.optInt(FIELD_AGE));
        entity.setTimeStamp(jsonObject.optLong(FIELD_TIMESTAMP));
        entity.setLon(jsonObject.optDouble(FIELD_LON));
        entity.setLat(jsonObject.optDouble(FIELD_LAT));
        entity.setAzimuth(jsonObject.optInt(FIELD_AZIMUTH));
        entity.setSelected(jsonObject.optBoolean(FIELD_SELECTED));
        return entity;
    }

    @Override
    public TestEntity jsonToObject(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            return fitEntity(jsonObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<TestEntity> jsonToArray(String json) {
        List<TestEntity> list = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0, length = jsonArray.length(); i < length; i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                TestEntity entity = fitEntity(jsonObject);
                list.add(entity);
            }
            return list;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }
}
