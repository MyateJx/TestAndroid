package com.myatejx.archi_test;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

import java.util.List;

/**
 * Created by admin on 2018/4/13.
 */

public class DataRepository {

    private static DataRepository sINSTANCE;

    private AppDatabase mDatabase;

    private MediatorLiveData<List<TestEntity>> mObservableList;

    public static DataRepository getInstance(AppDatabase database) {
        if (sINSTANCE == null) {
            synchronized (DataRepository.class) {
                if (sINSTANCE == null) {
                    sINSTANCE = new DataRepository(database);
                }
            }
        }
        return sINSTANCE;
    }

    private DataRepository(AppDatabase database) {
        this.mDatabase = database;
        mObservableList = new MediatorLiveData<>();

        mObservableList.addSource(database.getTestEntityDao().selectList(), new Observer<List<TestEntity>>() {
            @Override
            public void onChanged(@Nullable List<TestEntity> testEntities) {
                if (mDatabase.getIsDatabaseCreated().getValue() != null) {
                    mObservableList.postValue(testEntities);
                }
            }
        });
    }

    public LiveData<List<TestEntity>> getTestEntities() {
        return mObservableList;
    }

    public LiveData<TestEntity> getTestEntity(int id) {
        return mDatabase.getTestEntityDao().selectEntity(id);
    }

}
