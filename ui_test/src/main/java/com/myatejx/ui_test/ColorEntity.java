package com.myatejx.ui_test;

/**
 * Created by admin on 2018/3/7.
 */

public class ColorEntity {

    private String bgColorHex;
    private String textColorHex;
    private String title;
    private String content;

    public ColorEntity(String bgColorHex, String textColorHex, String title, String content) {
        this.bgColorHex = bgColorHex;
        this.textColorHex = textColorHex;
        this.title = title;
        this.content = content;
    }

    public ColorEntity() {
    }

    public String getBgColorHex() {
        return bgColorHex;
    }

    public void setBgColorHex(String bgColorHex) {
        this.bgColorHex = bgColorHex;
    }

    public String getTextColorHex() {
        return textColorHex;
    }

    public void setTextColorHex(String textColorHex) {
        this.textColorHex = textColorHex;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
