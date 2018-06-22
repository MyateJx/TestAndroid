package com.myatejx.bus_test.test_interface;

/**
 * Created by Administrator on 2018/6/23.
 */

public class Parameter {

    private double lontitude;
    private double latitude;
    private double accuracy;
    private int yaw;
    private int pitch;
    private int roll;

    public Parameter() {
    }

    public Parameter(double lontitude, double latitude, double accuracy, int yaw, int pitch, int roll) {
        this.lontitude = lontitude;
        this.latitude = latitude;
        this.accuracy = accuracy;
        this.yaw = yaw;
        this.pitch = pitch;
        this.roll = roll;
    }

    public double getLontitude() {
        return lontitude;
    }

    public void setLontitude(double lontitude) {
        this.lontitude = lontitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }

    public int getYaw() {
        return yaw;
    }

    public void setYaw(int yaw) {
        this.yaw = yaw;
    }

    public int getPitch() {
        return pitch;
    }

    public void setPitch(int pitch) {
        this.pitch = pitch;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }
}
