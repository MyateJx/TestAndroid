package com.myatejx.test.bean.record;

import java.util.List;

/**
 * Created by xmj on 2018/4/17.
 * <p>
 * 核查记录item
 */

public class RecordItem {

    private int sequence;
    private boolean defaultVisible;
    private String name;
    private String alias;
    private List<RecordField> fields;
    private List<RecordRelation> relatives;

    public RecordItem() {
    }

    public RecordItem(int sequence, boolean defaultVisible, String name, String alias, List<RecordField> fields, List<RecordRelation> relatives) {
        this.sequence = sequence;
        this.defaultVisible = defaultVisible;
        this.name = name;
        this.alias = alias;
        this.fields = fields;
        this.relatives = relatives;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public boolean isDefaultVisible() {
        return defaultVisible;
    }

    public void setDefaultVisible(boolean defaultVisible) {
        this.defaultVisible = defaultVisible;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public List<RecordField> getFields() {
        return fields;
    }

    public void setFields(List<RecordField> fields) {
        this.fields = fields;
    }

    public List<RecordRelation> getRelatives() {
        return relatives;
    }

    public void setRelatives(List<RecordRelation> relatives) {
        this.relatives = relatives;
    }
}
