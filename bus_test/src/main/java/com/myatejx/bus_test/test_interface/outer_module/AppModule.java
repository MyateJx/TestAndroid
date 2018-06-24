package com.myatejx.bus_test.test_interface.outer_module;

import com.myatejx.bus_test.test_interface.inter_module.interfaces.IGpsListener;
import com.myatejx.bus_test.test_interface.inter_module.interfaces.IRotationCallback;
import com.myatejx.bus_test.test_interface.inter_module.interfaces.MediaInterfaceBridge;

/**
 * Created by Administrator on 2018/6/22.
 * <p>
 * 主模块
 */

public class AppModule {

    private RotationManager mRotationManager;

    private void init() {
        mRotationManager = new RotationManager();
        mRotationManager.setIRotationManager(new RotationManager.IRotationManager() {
            @Override
            public void onRotationChanged(int yaw, int pitch, int roll) {
                IRotationCallback callback = MediaInterfaceBridge.getIRotationCallback();
                if (callback != null) {
                    callback.onRotationChanged(yaw, pitch, roll);
                }
            }
        });

        MediaInterfaceBridge.setIGpsListener(new IGpsListener() {
            @Override
            public double getLontitude() {
                return GpsManager.getInstance().getLontitude();
            }

            @Override
            public double getLatitude() {
                return GpsManager.getInstance().getLatitude();
            }

            @Override
            public double getAccuracy() {
                return GpsManager.getInstance().getAccuracy();
            }
        });
    }

}
