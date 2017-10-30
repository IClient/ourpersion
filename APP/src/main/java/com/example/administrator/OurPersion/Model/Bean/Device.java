package com.example.administrator.OurPersion.Model.Bean;

/**
 * Created by Administrator on 2017/6/7 0007.
 */

public class Device {
    private String address;
    private String name;
    private String time;
    private String state;

    public void setAddress(String address) {
        this.address = address;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {

        return state;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAddress() {

        return address;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }
}
