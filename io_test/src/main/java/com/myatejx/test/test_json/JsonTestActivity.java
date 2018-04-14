package com.myatejx.test.test_json;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.myatejx.test.R;
import com.myatejx.test.databinding.ActivityJsonTestBinding;
import com.myatejx.test.test_json.contract.JsonParserType;
import com.myatejx.test.test_json.test.JsonConvertTest;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by admin on 2018/4/12.
 */

public class JsonTestActivity extends AppCompatActivity {

    private ActivityJsonTestBinding mBinding;
    private JsonConvertTest mConvertTest;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_json_test);
        mConvertTest = new JsonConvertTest();
        mBinding.setClick(new ClickProxy());
        mBinding.etListSize.setText("100");
    }

    public class ClickProxy {
        public void testNativeJson() {
            testJson(JsonParserType.NATIVE_JSON);
        }

        public void testGson() {
            testJson(JsonParserType.GSON);
        }

        public void testFastJson() {
            testJson(JsonParserType.FAST_JSON);
        }

        public void testLoganSquare() {
            testJson(JsonParserType.LOGAN_SQUARE);
        }

        private void testJson(final JsonParserType type) {
            Observable.create(new ObservableOnSubscribe<String>() {
                @Override
                public void subscribe(ObservableEmitter<String> e) throws Exception {
                    String result = mConvertTest.testJson(type, Integer.valueOf(mBinding.etListSize.getText().toString()));
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
}
