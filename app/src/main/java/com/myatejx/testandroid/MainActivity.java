package com.myatejx.testandroid;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.myatejx.test.test_database.DatabaseTestActivity;
import com.myatejx.test.test_json.JsonTestActivity;
import com.myatejx.testandroid.databinding.ActivityMainBinding;
import com.myatejx.ui_test.OneActivity;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mBinding.setClick(new ClickProxy());

    }


    public class ClickProxy {
        public void testJson() {
            startActivity(new Intent(MainActivity.this, JsonTestActivity.class));
        }

        public void testDatabase() {
            startActivity(new Intent(MainActivity.this, DatabaseTestActivity.class));
        }

        public void testLiveData() {
//            startActivity(new Intent(MainActivity.this, LiveDataTestActivity.class));
        }

        public void testAnimetor() {
            startActivity(new Intent(MainActivity.this, OneActivity.class));
        }
    }
}
