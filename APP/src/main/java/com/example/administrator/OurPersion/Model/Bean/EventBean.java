package com.example.administrator.OurPersion.Model.Bean;

/**
 * Created by Administrator on 2017/9/7 0007.
 */

/**
 * 消息传递
 */
public class EventBean {
    private String msg;
    private int position;

    public EventBean(String msg,int position) {
        this.msg = msg;
        this.position=position;
    }

    public int getPosition() {
        return position;
    }

    public String getMsg() {
        return msg;
    }
}
