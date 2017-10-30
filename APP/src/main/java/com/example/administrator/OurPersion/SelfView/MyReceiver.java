package com.example.administrator.OurPersion.SelfView;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.administrator.OurPersion.Application.AndroidApplication;
import com.example.administrator.OurPersion.Utils.ToastUtils;
import com.example.administrator.OurPersion.View.Activity.FirstMainActivity;
import com.example.administrator.OurPersion.View.Activity.OldManAdminActivity;
import com.example.administrator.OurPersion.View.Activity.OldManListActivity;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by Administrator on 2017/6/21 0021.
 */

public class MyReceiver extends BroadcastReceiver {
    private static final String TAG = "MyReceiver";
    String message;
    String checkidold;
    AndroidApplication application;

    @Override
    public void onReceive(final Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        application = (AndroidApplication) context.getApplicationContext();
        if (JPushInterface.ACTION_REGISTRATION_ID.equals(intent.getAction())) {

        }
        // 自定义消息不会展示在通知栏，完全要开发者写代码去处理
        else if (JPushInterface.ACTION_MESSAGE_RECEIVED.equals(intent.getAction())) {


        }
        //--通知
        else if (JPushInterface.ACTION_NOTIFICATION_RECEIVED.equals(intent.getAction())) {
            message = bundle.getString(JPushInterface.EXTRA_ALERT);
            checkidold = bundle.getString(JPushInterface.EXTRA_EXTRA);

            if (message != null) {
                application.count += 1;
            }

            /**
             * 附加字段一般都是键值对的形式，所以都是json数据格式
             */

            if (message != null) {
                application.count += 1;

            }

            // 在这里可以自己写代码去定义用户点击后的行为
        } else if (JPushInterface.ACTION_NOTIFICATION_OPENED.equals(intent.getAction())) {
            checkidold = bundle.getString(JPushInterface.EXTRA_EXTRA);
            //--跳转后去掉提醒
            //--用户点开通知栏的消息后暂时进入老人入住列表界面
            Intent i = new Intent(context, OldManAdminActivity.class);
            if (!TextUtils.isEmpty(checkidold) && checkidold != null) {
                Bundle bundle1 = new Bundle();
                bundle1.putSerializable("checkidold", checkidold);
                i.putExtras(bundle1);
            }
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        } else {
            Log.e(TAG, "Unhandled intent - " + intent.getAction());
        }
    }
}