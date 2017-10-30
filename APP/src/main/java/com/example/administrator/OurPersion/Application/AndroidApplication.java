package com.example.administrator.OurPersion.Application;

import android.app.Activity;
import android.app.Application;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2017/6/22 0022.
 */

public class AndroidApplication extends Application {
    //--这个是jpush接受消息的个数
    public int count = 0;
    public List<Activity> activitylist = new ArrayList<>();
    public static final String Appkey = "1ee6f48f07aec";
    public static final String AppSecret = "9c1fe8a6c1eab05b8193a9eca7bfe387";
    @Override
    public void onCreate() {
        super.onCreate();

    }


    //--添加activity
    public void addactivity(Activity activity) {
        activitylist.add(activity);

    }

    //--移除activity
    public void moveactivity() {
        if (activitylist.size() >= 0) {
            for (int i = 0; i < activitylist.size(); i++) {
                activitylist.get(i).finish();
            }
        } else return;

    }


//    public void tt() {
//        String APP_KEY = "a0a5dbaaadafe2bd8e8f2180";
//        String MASTER_SECRET = "80939f204d704a237728865a";
//        JPushClient jpushClient = new JPushClient(MASTER_SECRET, APP_KEY, null, ClientConfig.getInstance());
//
//        // For push, all you need do is to build PushPayload object.
//        PushPayload payload = buildPushObject_all_all_alert();
//
//        try {
//            PushResult result = jpushClient.sendPush(payload);
//
//
//        } catch (APIConnectionException e) {
//
//
//        } catch (APIRequestException e) {
//
//        }
//    }
//
//
//
//    public static PushPayload buildPushObject_all_all_alert() {
//        return PushPayload.alertAll("测试测试");
////        return PushPayload.newBuilder()
////                .setPlatform(Platform.all())
////                .setAudience(Audience.alias("alias1"))
////                .setNotification(Notification.alert("测试测试测试"))
////                .build();
//    }

}
