package com.myatejx.archi_test;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by admin on 2018/4/13.
 */

public class AppExecutors {

    private static final int POOL_SIZE = 1;
    private static final int MAX_POOL_SIZE = 3;
    private static final long TIMEOUT = 0;
    private static final int QUEUE_SIZE = 10;

    private Executor mDiskIO;

    private Executor mNetworkIO;

    private Executor mMainThread;

    public Executor getDiskIO() {
        return mDiskIO;
    }

    public Executor getNetworkIO() {
        return mNetworkIO;
    }

    public Executor getMainThread() {
        return mMainThread;
    }

    private AppExecutors(Executor diskIO, Executor networkIO, Executor mainThread) {
        mDiskIO = diskIO;
        mNetworkIO = networkIO;
        mMainThread = mainThread;
    }

    public AppExecutors() {
        this(//single Executor
                new ThreadPoolExecutor(1, 1, TIMEOUT, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>()),
                //fixed Executer
                new ThreadPoolExecutor(MAX_POOL_SIZE, MAX_POOL_SIZE, TIMEOUT, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>()),
                new MainThreadExecutor());
    }

    private static class MainThreadExecutor implements Executor {

        private Handler mHandler = new Handler(Looper.getMainLooper());

        @Override
        public void execute(@NonNull Runnable command) {
            mHandler.post(command);
        }
    }
}
