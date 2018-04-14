package com.myatejx.archi_test;

import android.arch.lifecycle.LiveData;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by admin on 2018/4/13.
 */

public class TestEntityAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LiveData<List<TestEntity>> mLiveData;

    public TestEntityAdapter() {
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mLiveData.getValue().size();
    }
}
