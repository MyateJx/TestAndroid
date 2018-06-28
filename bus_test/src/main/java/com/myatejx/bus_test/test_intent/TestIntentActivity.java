package com.myatejx.bus_test.test_intent;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.myatejx.bus_test.R;
import com.myatejx.bus_test.databinding.ActivityTestIntentBinding;

/**
 * @author Administrator
 * @date 2018/6/23
 */

public class TestIntentActivity extends AppCompatActivity {

    private ActivityTestIntentBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_test_intent);
        mBinding.setClickProxy(new ClickProxy());
    }

    /**
     * 通过显式intent启动Activity
     */
    private void startActivityByExplicitIntent() {
        Intent intent = new Intent();
        intent.setClass(TestIntentActivity.this, TestResultActivity.class);
        //打开目标app主模块的MainActivity，成功
//        intent.setClassName("com.myatejx.testandroid", "com.myatejx.testandroid.MainActivity");
        //打开目标app主模块的其他Activity，成功
//        intent.setClassName("com.myatejx.testandroid", "com.myatejx.testandroid.Main2Activity");
        //打开目标app子模块的其他Activity，成功
//        intent.setClassName("com.myatejx.testandroid", "com.myatejx.test.test_database.DatabaseTestActivity");
        //打开闹钟，成功
//        intent.setClassName("com.android.deskclock","com.android.deskclock.DeskClock");
        //打开程序内部的其他actitivy，成功
//        intent.setComponent(new ComponentName("com.myatejx.bus_test", "com.myatejx.bus_test.test_intent.TestResultActivity"));
        startActivity(intent);
    }

    /**
     * 通过隐式intent启动Activity
     */
    private void startActivityByImplicitIntent() {
        Intent intent = new Intent();
        intent.setAction("com.myatejx.bus_test.action.START_RESULT");
        intent.addCategory("com.myatejx.bus_test.category.START_RESULT");
//        intent.setDataAndType(Uri.parse("http://www.baidu.com"), "text/*");

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * 强制弹窗罗列匹配的组件列表
     */
    private void forceShowComponentList() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        String title = "列出所有action为Main和category为launcher的组件";
        Intent chooser = Intent.createChooser(intent, title);

        if (chooser.resolveActivity(getPackageManager()) != null) {
            startActivity(chooser);
        }
    }

    public class ClickProxy {
        public void startByExplicit() {
            startActivityByExplicitIntent();
        }

        public void startByImplicit() {
            startActivityByImplicitIntent();
        }

        public void forceShowMatched() {
            forceShowComponentList();
        }

        public void toTestCommonIntent() {
            startActivity(new Intent(TestIntentActivity.this, TestCommonIntentActivity.class));
        }
    }

}
