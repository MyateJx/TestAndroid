package com.myatejx.archi_test;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import java.util.List;

/**
 * Created by admin on 2018/4/13.
 */

public class TestEntityViewModel extends AndroidViewModel {

    private MutableLiveData<List<TestEntity>> mObservableList = new MutableLiveData<>();

    public TestEntityViewModel(@NonNull Application application) {
        super(application);

    }


    public MutableLiveData<List<TestEntity>> getObservableList() {
        return mObservableList;
    }
}
