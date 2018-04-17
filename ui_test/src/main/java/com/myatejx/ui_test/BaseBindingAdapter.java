package com.myatejx.ui_test;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseBindingAdapter<M, B extends ViewDataBinding> extends RecyclerView.Adapter {
    protected Context context;
    protected List<M> mList;

    public BaseBindingAdapter(Context context) {
        this.context = context;
        this.mList = new ArrayList<>();
    }

    public void setList(List<M> list) {
        mList = list;
    }

    @Override
    public int getItemCount() {
        return this.mList.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        B binding = DataBindingUtil.inflate(LayoutInflater.from(this.context), this.getLayoutResId(viewType), parent, false);
        return new BaseBindingViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        B binding = DataBindingUtil.getBinding(holder.itemView);
        this.onBindItem(binding, this.mList.get(position), position);
    }

    protected abstract int getLayoutResId(@LayoutRes int viewType);

    protected abstract void onBindItem(B binding, M item, int position);

    public class BaseBindingViewHolder extends RecyclerView.ViewHolder {
        public BaseBindingViewHolder(View itemView) {
            super(itemView);
        }
    }
}