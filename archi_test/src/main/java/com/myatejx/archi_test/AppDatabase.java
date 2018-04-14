package com.myatejx.archi_test;

import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

/**
 * Created by admin on 2018/4/13.
 */

public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase sINSTANCE;

    private final static String DB_NAME = "ROOM_DB";

    public abstract TestEntityDao getTestEntityDao();

    //final引用，不能为该引用赋别的对象。
    private final MutableLiveData<Boolean> mIsDatabaseCreated = new MutableLiveData<>();

    public static AppDatabase getInstance(Context context, AppExecutors appExecutors) {
        if (sINSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (sINSTANCE == null) {
                    sINSTANCE = buildDatabase(context.getApplicationContext(), appExecutors);
                    sINSTANCE.updateDatabaseCreated(context.getApplicationContext());
                }
            }
        }
        return sINSTANCE;
    }

    private static AppDatabase buildDatabase(Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, DB_NAME).build();
    }

    private static AppDatabase buildDatabase(final Context context, final AppExecutors appExecutors) {
        return Room.databaseBuilder(context, AppDatabase.class, DB_NAME)
                .addCallback(new Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        appExecutors.getDiskIO().execute(new Runnable() {
                            @Override
                            public void run() {
                                AppDatabase database = AppDatabase.getInstance(context, appExecutors);
                                database.setIsDatabaseCreated();
                            }
                        });
                    }
                }).build();
    }

    public MutableLiveData<Boolean> getIsDatabaseCreated() {
        return mIsDatabaseCreated;
    }

    private void setIsDatabaseCreated() {
        //TODO 此处为什么不用set，和post区别为何？
        mIsDatabaseCreated.postValue(true);
    }

    private void updateDatabaseCreated(Context context) {
        if (context.getDatabasePath(DB_NAME).exists()) {
            setIsDatabaseCreated();
        }
    }
}
