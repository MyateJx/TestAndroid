package com.myatejx.test.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by admin on 2018/4/11.
 */

@Entity
public class TestEntity {

    @Id(autoincrement = true)
    private Long id;
    private String name;
    private String date;
    private int age;
    private long timeStamp;
    private double lon;
    private double lat;
    private int azimuth;
    private boolean selected;

    public TestEntity() {
    }

    @Keep
    public TestEntity(Long id, String name, String date, int age, long timeStamp, double lon, double lat, int azimuth, boolean selected) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
