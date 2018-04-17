package com.myatejx.test.bean.record;

import java.util.List;

/**
 * Created by xmj on 2018/4/17.
 * <p>
 * 核查记录item关联关系
 */

public class RecordRelation {

    private String fieldSelected;
    private String affectName;
    private boolean necessary;
    private boolean visible;
    private List<RecordField> mFields;

    public RecordRelation() {
    }

    public RecordRelation(String fieldSelected, String affectName, boolean necessary, boolean visible, List<RecordField> fields) {
        this.fieldSelected = fieldSelected;
        this.affectName = affectName;
        this.necessary = necessary;
        this.visible = visible;
        mFields = fields;
    }

    public String getFieldSelected() {
        return fieldSelected;
    }

    public void setFieldSelected(String fieldSelected) {
        this.fieldSelected = fieldSelected;
    }

    public String getAffectName() {
        return affectName;
    }

    public void setAffectName(String affectName) {
        this.affectName = affectName;
    }

    public boolean isNecessary() {
        return necessary;
    }

    public void setNecessary(boolean necessary) {
        this.necessary = necessary;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public List<RecordField> getFields() {
        return mFields;
    }

    public void setFields(List<RecordField> fields) {
        mFields = fields;
    }
}
