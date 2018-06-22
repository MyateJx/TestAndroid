package com.myatejx.bus_test.test_interface;

/**
 * Created by Administrator on 2018/6/23.
 */

public class RotationManager {

    private IRotationManager mIRotationManager;

    public void setIRotationManager(IRotationManager IRotationManager) {
        mIRotationManager = IRotationManager;
    }

    public interface IRotationManager {
        void onRotationChanged(int yaw, int pitch, int roll);
    }
}
