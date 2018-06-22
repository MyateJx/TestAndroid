package com.myatejx.bus_test.test_interface;

/**
 * Created by Administrator on 2018/6/22.
 * <p>
 * 多媒体模块
 */

public class MediaModule {

    private void init() {
        MediaInterfaceBridge.setIRotationCallback(new IRotationCallback() {
            @Override
            public void onRotationChanged(int yaw, int pitch, int roll) {
                IGpsListener iGpsListener = MediaInterfaceBridge.getIGpsListener();
                if (iGpsListener != null) {
                    double lontitude = iGpsListener.getLontitude();
                    double latitude = iGpsListener.getLatitude();
                    double accuracy = iGpsListener.getAccuracy();
                    Parameter parameter = new Parameter(lontitude, latitude, accuracy, yaw, pitch, roll);
                }
            }
        });
    }
}
