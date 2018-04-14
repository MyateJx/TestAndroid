package com.myatejx.archi_test;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;


/**
 * Created by admin on 2018/4/11.
 */

@Entity(tableName = "test_entity")
public class TestEntity {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String date;
    private int age;
    private long timeStamp;
    private double lon;
    private double lat;
    private int azimuth;
    private boolean selected;

    @Ignore
    public TestEntity() {
    }

    public TestEntity(int id, String name, String date, int age, long timeStamp, double lon, double lat, int azimuth, boolean selected) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.age = age;
        this.timeStamp = timeStamp;
        this.lon = lon;
        this.lat = lat;
        this.azimuth = azimuth;
        this.selected = selected;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public int getAzimuth() {
        return azimuth;
    }

    public void setAzimuth(int azimuth) {
        this.azimuth = azimuth;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean getSelected() {
        return this.selected;
    }
}
