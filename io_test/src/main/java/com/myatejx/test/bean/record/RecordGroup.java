package com.myatejx.test.bean.record;

import java.util.List;

/**
 * Created by xmj on 2018/4/17.
 * <p>
 * 核查记录组
 */

public class RecordGroup {

    private String alias;
    private int sequence;
    private List<RecordItem> items;

    public RecordGroup() {
    }

    public RecordGroup(String alias, int sequence, List<RecordItem> items) {
        this.alias = alias;
        this.sequence = sequence;
        this.items = items;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public List<RecordItem> getItems() {
        return items;
    }

    public void setItems(List<RecordItem> items) {
        this.items = items;
    }
}
