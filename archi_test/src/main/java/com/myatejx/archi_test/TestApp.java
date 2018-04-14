package com.myatejx.archi_test;

import android.app.Application;

/**
 * Created by admin on 2018/4/13.
 */

public class TestApp extends Application {

    private AppExecutors mAppExecutors;


    @Override
    public void onCreate() {
        super.onCreate();

        mAppExecutors = new AppExecutors();
    }

    public AppDatabase getDatabase() {
        return AppDatabase.getInstance(getApplicationContext(), mAppExecutors);
    }

    public DataRepository getRepository() {
        return DataRepository.getInstance(getDatabase());
    }

}
