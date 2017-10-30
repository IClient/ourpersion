package com.example.administrator.OurPersion.Model.Bean;

/**
 * Created by Administrator on 2017/9/14 0014.
 */

public class EventBean2 {
    private String msg;

    private OldManPlanItem oldManPlanItem;

    public EventBean2(String msg, OldManPlanItem oldManPlanItem) {
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
