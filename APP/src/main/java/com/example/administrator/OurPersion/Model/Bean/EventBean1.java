package com.example.administrator.OurPersion.Model.Bean;

/**
 * Created by Administrator on 2017/9/12 0012.
 */

public class EventBean1 {
    private String msg;

    private OldManPlanItem oldManPlanItem;

    public EventBean1(String msg, OldManPlanItem oldManPlanItem) {
        this.msg = msg;
        this.oldManPlanItem = oldManPlanItem;

    }

    public String getMsg() {
        return msg;
    }

    public OldManPlanItem getOldManPlanItem() {
        return oldManPlanItem;
    }
}
