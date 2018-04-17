package com.myatejx.test.bean.record;

/**
 * Created by xmj on 2018/4/17.
 * <p>
 * 核查记录字段键值对
 */

public class RecordField {

    private String code;
    private String value;

    public RecordField() {
    }

    public RecordField(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
