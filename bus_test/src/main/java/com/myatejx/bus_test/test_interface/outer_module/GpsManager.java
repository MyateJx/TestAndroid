package com.myatejx.bus_test.test_interface.outer_module;

/**
 * Created by Administrator on 2018/6/23.
 */

public class GpsManager {

    private static GpsManager sINSTANCE;

    public static GpsManager getInstance() {
        if (sINSTANCE == null) {
            sINSTANCE = new GpsManager();
        }
        return sINSTANCE;
    }

    private GpsManager() {
    }

    public double getLontitude() {
        return 0;
    }

    public double getLatitude() {
        return 0;
    }

    public double getAccuracy() {
        return 0;
    }
}
