package com.myatejx.test.test_database;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import com.myatejx.test.R;
import com.myatejx.test.databinding.ActivityDatabaseTestBinding;
import com.myatejx.test.test_database.contract.DatabaseParserType;
import com.myatejx.test.test_database.test.DatabaseOperateTest;
import com.myatejx.test.utils.PermissionUtils;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by admin on 2018/4/12.
 */

public class DatabaseTestActivity extends AppCompatActivity {

    private ActivityDatabaseTestBinding mBinding;
    private DatabaseOperateTest mDatabaseOperateTest;
    private final static int REQUESTCODE = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_database_test);
        mBinding.setClick(new ClickProxy());
        mBinding.etListSize.setText("100");

        if (checkPermission()) {
            mDatabaseOperateTest = new DatabaseOperateTest(getApplicationContext());
        }
    }

    private boolean checkPermission() {
        return PermissionUtils.checkPermission(this, REQUESTCODE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        );
    }

    public class ClickProxy {
        public void testNativeDb() {
            testDatabase(DatabaseParserType.NATIVE_DB);
        }

        public void testGreendao() {
            testDatabase(DatabaseParserType.GREENDAO);
        }

//        public void testRoom() {
//            testDatabase(DatabaseParserType.ROOM);
//        }

        private void testDatabase(final DatabaseParserType type) {
            Observable.create(new ObservableOnSubscribe<String>() {
                @Override
                public void subscribe(ObservableEmitter<String> e) throws Exception {
                    String result = mDatabaseOperateTest.testDatabase(type, Integer.valueOf(mBinding.etListSize.getText().toString()));
                    e.onNext(result);
                }
            }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<String>() {
                @Override
                public void accept(String s) throws Exception {
                    mBinding.tvTestResult.setText(s);
                    System.out.println(s);
                }
            });
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == REQUESTCODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                mDatabaseOperateTest = new DatabaseOperateTest(getApplicationContext());

            } else {
                new AlertDialog.Builder(this)
                        .setTitle("是否开启权限")
                        .setMessage("需要这些权限，是否现在去开启？")
                        .setNegativeButton("不好", null)
                        .setPositiveButton("好", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i = new Intent();
                                i.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                Uri uri = Uri.fromParts("package", getPackageName(), null);
                                i.setData(uri);
                                startActivity(i);
                            }
                        }).show();
            }
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

}
