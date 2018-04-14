package com.myatejx.archi_test;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.myatejx.archi_test.databinding.ActivityLivedataTestBinding;

import java.util.List;

/**
 * Created by admin on 2018/4/13.
 */

public class LiveDataTestActivity extends AppCompatActivity {

    private ActivityLivedataTestBinding mBinding;
    private TestEntityViewModel mViewModel;
    private TestEntityAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_livedata_test);
        mBinding.setClick(new ClickProxy());
        mBinding.etListSize.setText("3");
        mAdapter = new TestEntityAdapter();
        mBinding.rv.setAdapter();

        mViewModel = ViewModelProviders.of(this).get(TestEntityViewModel.class);

        mViewModel.getObservableList().observe(this, new Observer<List<TestEntity>>() {
            @Override
            public void onChanged(@Nullable List<TestEntity> testEntities) {
                mAdapter.notifyDataSetChanged();
            }
        });

    }

    public class ClickProxy {
        public void insertData() {

        }

        public void deleteData() {

        }
    }

}
