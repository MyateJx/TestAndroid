package com.myatejx.bus_test.test_intent;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.myatejx.bus_test.R;
import com.myatejx.bus_test.databinding.ActivityTestCommonIntentBinding;

public class TestCommonIntentActivity extends AppCompatActivity{

    private ActivityTestCommonIntentBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_test_common_intent);
        mBinding.setClickProxy(new ClickProxy());
    }

    public class ClickProxy {}
}
