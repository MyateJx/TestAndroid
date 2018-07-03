package com.myatejx.ui_test;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.myatejx.ui_test.databinding.ActivityTwoBinding;

public class TwoActivity extends AppCompatActivity {

    private ActivityTwoBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_two);

    }


    @Override
    public void onBackPressed() {
        KShareViewActivityManager.getInstance(TwoActivity.this).finish(TwoActivity.this);
    }
}
