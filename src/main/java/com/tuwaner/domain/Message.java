package com.tuwaner.domain;

import java.io.Serializable;

/**
 * Created by wanglingyun on 2016/12/5.
 */
public class Message implements Serializable {

    private String title;
    private String info;

    public String getTitle() {
        return title;
    }

    public String getInfo() {
        return info;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setInfo(String info) {
        this.info = info;
    }

}
