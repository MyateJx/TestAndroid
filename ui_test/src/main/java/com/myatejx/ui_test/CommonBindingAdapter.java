package com.myatejx.ui_test;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by xmj on 2017/9/10.
 * <p>
 * 一个自豪的为ListView所依赖的databinding适配器
 */

public abstract class CommonBindingAdapter<T> extends BaseAdapter {

    private List<T> mList;
    private Context mContext;
    private int mLayoutId;

    public CommonBindingAdapter(Context context, int layoutId, List<T> list) {
        mList = list;
        mContext = context;
        mLayoutId = layoutId;
    }

    @Override
    public int getCount() {
        return mList == null ? 0 : mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList == null ? null : mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewDataBinding dataBinding;
        if (view == null) {
            dataBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext), mLayoutId, viewGroup, false);
        } else {
            dataBinding = DataBindingUtil.getBinding(view);
        }
        bindVariable(dataBinding, mList.get(i), i);
        return dataBinding.getRoot();
    }

    /**
     * 用于绑定变量
     *
     * @param dataBinding
     */
    public abstract void bindVariable(ViewDataBinding dataBinding, T t, int position);

}
