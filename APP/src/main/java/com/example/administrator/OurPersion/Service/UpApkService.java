package com.example.administrator.OurPersion.Service;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v4.content.FileProvider;
import android.support.v7.app.NotificationCompat;
import android.webkit.MimeTypeMap;
import android.widget.Toast;

import com.example.administrator.OurPersion.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;


import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class UpApkService extends Service {
    File file;
    int sum;
    int total;
    protected static NotificationManager mNotifyManager;
    protected static NotificationCompat.Builder mBuilder;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            if ((int) msg.obj == 100) {
                new Handler().postAtTime(new Runnable() {
                    @Override
                    public void run() {
                        mNotifyManager.cancel(0);
                        UpApkService.this.stopSelf();
                        Intent intent = new Intent();
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        //执行动作
                        intent.setAction(Intent.ACTION_VIEW);
                        //执行的数据类型
                        intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
                        startActivity(intent);
                        android.os.Process.killProcess(android.os.Process.myPid());

                    }
                }, 8000);


            }

        }
    };

    public UpApkService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;

    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mNotifyManager =
                (NotificationManager) UpApkService.this.getSystemService(UpApkService.this.NOTIFICATION_SERVICE);
        mBuilder = new NotificationCompat.Builder(UpApkService.this);
        mBuilder.setContentTitle("学苑养老")
                .setContentText("正在下载···")
                .setProgress(100, 0, false)
                .setSmallIcon(R.mipmap.applogo);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(15, TimeUnit.SECONDS).writeTimeout(15, TimeUnit.SECONDS).build();
        Request request = new Request.Builder().url("http://192.168.10.7:8089/apk/app-debug.apk").get().build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                file = new File(Environment.getExternalStorageDirectory(), "ourpersion.apk");
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                InputStream inputStream = response.body().byteStream();
                total = (int) response.body().contentLength();
                byte[] byt = new byte[2048];
                int len;
                while ((len = inputStream.read(byt)) != -1) {
                    sum += len;
                    fileOutputStream.write(byt, 0, len);
                    mBuilder.setProgress(100, (int) (sum * 1.0f / total * 100), false).setContentText("已下载" + (int) (sum * 1.0f / total * 100) + "%");
                    mNotifyManager.notify(0, mBuilder.build());
                    if ((int) (sum * 1.0f / total * 100) == 100) {
                        Message message = new Message();
                        message.obj = 100;
                        handler.sendMessage(message);

                    }

                }
                fileOutputStream.flush();
                inputStream.close();
                fileOutputStream.close();

            }
        });
        return super.onStartCommand(intent, flags, startId);
    }

}
