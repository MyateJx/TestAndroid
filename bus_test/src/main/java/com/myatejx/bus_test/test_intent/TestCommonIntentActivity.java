package com.myatejx.bus_test.test_intent;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.myatejx.bus_test.R;
import com.myatejx.bus_test.databinding.ActivityTestCommonIntentBinding;

public class TestCommonIntentActivity extends AppCompatActivity {

    private ActivityTestCommonIntentBinding mBinding;
    static final int REQUEST_IMAGE_CAPTURE = 1;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_test_common_intent);
        mBinding.setClickProxy(new ClickProxy());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
//            Bitmap thumbnail = data.getParcelable("data");
            // Do other work with full size photo saved in mLocationForPhotos
        }
    }

    public class ClickProxy {


        public void capturePhoto() {
            /*Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            intent.putExtra(MediaStore.EXTRA_OUTPUT,
                    Uri.withAppendedPath(mLocationForPhotos, targetFilename));
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
            }*/
        }

        /*public void xxx() {
        }

        public void xxx() {
        }

        public void xxx() {
        }

        public void xxx() {
        }

        public void xxx() {
        }

        public void xxx() {
        }

        public void xxx() {
        }

        public void xxx() {
        }

        public void xxx() {
        }

        public void xxx() {
        }*/

    }
}
