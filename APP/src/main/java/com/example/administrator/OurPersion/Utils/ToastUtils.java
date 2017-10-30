package com.example.administrator.OurPersion.Utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/7/6 0006.
 */

/**
 * Toast统一管理类这里使用单例模式
 */

public class ToastUtils {
    public static Toast toast;

    public static void show(Context context, CharSequence message, int duration) {

        if (toast == null) {
            toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        } else {
            toast.setText(message);
        }
        toast.show();


    }

}