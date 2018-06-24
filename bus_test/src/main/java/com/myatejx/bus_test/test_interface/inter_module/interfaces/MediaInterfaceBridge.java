package com.myatejx.bus_test.test_interface.inter_module.interfaces;

/**
 * Created by Administrator on 2018/6/23.
 */

public class MediaInterfaceBridge {

    private static IRotationCallback sIRotationCallback;

    private static IGpsListener sIGpsListener;

    public static void setIRotationCallback(IRotationCallback IRotationCallback) {
        sIRotationCallback = IRotationCallback;
    }

    public static void setIGpsListener(IGpsListener IGpsListener) {
        sIGpsListener = IGpsListener;
    }

    public static IRotationCallback getIRotationCallback() {
        return sIRotationCallback;
    }

    public static IGpsListener getIGpsListener() {
        return sIGpsListener;
    }
}
