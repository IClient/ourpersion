package com.example.administrator.OurPersion.Application;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/30 0030.
 */

public class AllFirstMainActivity {
    private final static List<Activity> list = new ArrayList<Activity>();

    public static void AddActivity(Activity activity) {
        list.add(activity);
    }

    public static void DestoryActivity() {
        if (list.size() >= 0) {
            for (int i = 0; i < list.size(); i++) {
                list.get(i).finish();
            }
        } else return;
    }
}
