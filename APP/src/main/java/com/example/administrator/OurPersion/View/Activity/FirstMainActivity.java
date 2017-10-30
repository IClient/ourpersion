package com.example.administrator.OurPersion.View.Activity;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.OurPersion.Application.AllBedAdminActivity;
import com.example.administrator.OurPersion.Application.AllFirstMainActivity;
import com.example.administrator.OurPersion.Application.AllOldManActivity;
import com.example.administrator.OurPersion.Application.AndroidApplication;
import com.example.administrator.OurPersion.Model.Bean.OkHttpURL;
import com.example.administrator.OurPersion.R;
import com.example.administrator.OurPersion.SelfView.CircleImageView;
import com.example.administrator.OurPersion.SelfView.MyHorizontalScrollView;
import com.example.administrator.OurPersion.Service.UpApkService;
import com.example.administrator.OurPersion.View.Dialog.DownApkDialog;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.TagAliasCallback;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/9/29 0029.
 */

public class FirstMainActivity extends BaseActivity implements View.OnClickListener {
//    public static RelativeLayout firstmain_remessage;
//    public static TextView firstmain_message_text;
//    public static ImageButton firstmain_message_btn;
    AndroidApplication application;
    MyHorizontalScrollView firstmain_scrollview;
    //--菜单用户名字
    TextView user_name;
    //--菜单用户头像
    CircleImageView menu_circleimage;
    //--返回菜单
    CircleImageView firstmainactivity_back_menu;
    TextView jihuajizhixing;
    TextView gerenpaiban;
    TextView qingjiajilu;
    TextView gerenzhongxin;
    TextView laorenlieb;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if ((int) msg.obj == 1) {
                //--获取服务器版本,后台启动service
                HandlerUpApkDo();

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstmain);
        application = (AndroidApplication) getApplication();
        application.addactivity(FirstMainActivity.this);
        SetZTL();
        initview();
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
        //极光推送，别名推送，可以点对点通讯。使用别名，用于给某特定用户推送消息（这里以用户名作为别名推送）
        JPushInterface.setAlias(FirstMainActivity.this, LoginActivity.sharedPreferences.getString("user", ""), new TagAliasCallback() {
            /**
             * @param i   返回码
             * @param s   别名
             * @param set 标签(如果是别名的话这里应该为Null)
             */
            @Override
            public void gotResult(int i, String s, Set<String> set) {
            }
        });
        //--获取服务器版本号
        GetVersionFromService();
    }

    public void initview() {
        nurseadmin_btn = (Button) findViewById(R.id.nurseadmin_btn);
        nurseadmin_btn.setOnClickListener(this);
        oldmanadmin_btn = (Button) findViewById(R.id.oldmanadmin_btn);
        oldmanadmin_btn.setOnClickListener(this);
        staffadmin_btn = (Button) findViewById(R.id.staffadmin_btn);
        staffadmin_btn.setOnClickListener(this);
        bedadmin_btn = (Button) findViewById(R.id.bedadmin_btn);
        bedadmin_btn.setOnClickListener(this);
        messagesend_btn = (Button) findViewById(R.id.messagesend_btn);
        messagesend_btn.setOnClickListener(this);
//        firstmain_remessage = (RelativeLayout) findViewById(R.id.firstmain_remessage);
//        firstmain_message_text = (TextView) findViewById(R.id.firstmain_message_text);
//        firstmain_message_btn = (ImageButton) findViewById(R.id.firstmain_message_btn);
        firstmain_scrollview = (MyHorizontalScrollView) findViewById(R.id.firstmain_scrollview);
        user_name = (TextView) findViewById(R.id.user_name);
        user_name.setText(user.getEmployeeName());
        menu_circleimage = (CircleImageView) findViewById(R.id.menu_circleimage);
        Picasso.with(FirstMainActivity.this).load(OkHttpURL.ImageURL + user.getImgPath()).placeholder(R.mipmap.default_image).into(menu_circleimage);
        firstmainactivity_back_menu = (CircleImageView) findViewById(R.id.firstmainactivity_back_menu);
        firstmainactivity_back_menu.setOnClickListener(this);
        jihuajizhixing = (TextView) findViewById(R.id.jihuajizhixing);
        jihuajizhixing.setOnClickListener(this);
        gerenpaiban = (TextView) findViewById(R.id.gerenpaiban);
        gerenpaiban.setOnClickListener(this);
        qingjiajilu = (TextView) findViewById(R.id.qingjiajilu);
        qingjiajilu.setOnClickListener(this);
        gerenzhongxin = (TextView) findViewById(R.id.gerenzhongxin);
        gerenzhongxin.setOnClickListener(this);
        laorenlieb = (TextView) findViewById(R.id.laorenlieb);
        laorenlieb.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //--这里点击调转前判断菜单是否打开，如果没有打开不给予点击响应,打开跳转页面
            case R.id.nurseadmin_btn:
                if (firstmain_scrollview.isopen()) {
                    Intent nurseintent = new Intent(FirstMainActivity.this, NurseAdminActivity.class);
                    startActivity(nurseintent);
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            case R.id.oldmanadmin_btn:
                if (firstmain_scrollview.isopen()) {
                    Intent oldmanintent = new Intent(FirstMainActivity.this, OldManListActivity.class);
                    startActivity(oldmanintent);
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            case R.id.staffadmin_btn:
                if (firstmain_scrollview.isopen()) {
                    Intent staffintent = new Intent(FirstMainActivity.this, StaffAdminActivity.class);
                    startActivity(staffintent);
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            case R.id.bedadmin_btn:
                if (firstmain_scrollview.isopen()) {
                    Intent systemintent = new Intent(FirstMainActivity.this, BedAdminActivity.class);
                    startActivity(systemintent);
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            case R.id.messagesend_btn:
                if (firstmain_scrollview.isopen()) {
                    Intent systemintent = new Intent(FirstMainActivity.this, MessageActivity.class);
                    startActivity(systemintent);
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            //--计划及执行
            case R.id.jihuajizhixing:
                if (!firstmain_scrollview.isopen()) {
                    Intent systemintent = new Intent(FirstMainActivity.this, FirstMainPlanActivity.class);
                    startActivity(systemintent);
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            //--个人排班
            case R.id.gerenpaiban:
                if (!firstmain_scrollview.isopen()) {
                    Intent qjintent = new Intent(FirstMainActivity.this, FirstMainWorkActivity.class);
                    startActivity(qjintent);
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            //--请假记录
            case R.id.qingjiajilu:
                if (!firstmain_scrollview.isopen()) {
                    Intent qjintent = new Intent(FirstMainActivity.this, FirstMainQjActivity.class);
                    startActivity(qjintent);
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);

                }
                break;
            //---个人中心
            case R.id.gerenzhongxin:
                if (!firstmain_scrollview.isopen()) {
                    Intent qjintent = new Intent(FirstMainActivity.this, FirstMainMeActivity.class);
                    startActivity(qjintent);
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            //--老人列表
            case R.id.laorenlieb:
                if (!firstmain_scrollview.isopen()) {
                    Intent oldintent = new Intent(FirstMainActivity.this, FirstMainOldManActivity.class);
                    startActivity(oldintent);
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            case R.id.firstmainactivity_back_menu:
                if (!firstmain_scrollview.isopen()) {
                    firstmain_scrollview.openmenu();
                }
                break;
        }
    }  //--获取服务器apk的版本号

    public void GetVersionFromService() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(15, TimeUnit.SECONDS).writeTimeout(15, TimeUnit.SECONDS).build();
        Request request = new Request.Builder().url("http://192.168.10.7:7006/api/SystemUtility/GetSystemVersion?Token=1").get().build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    JSONObject jsonObject = new JSONObject(response.body().string());
                    //--获取服务器版本
                    String version = jsonObject.getString("Msg");
                    try {
                        //--当前apk版本
                        PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
                        String versionname = packageInfo.versionName;

                        //--比较服务器版本是否大于现在的版本，如果大于就更新下载安装apk
                        if (versionname.equals(version)) {
                            Message message = new Message();
                            message.obj = 1;
                            handler.sendMessage(message);

                        }
                    } catch (PackageManager.NameNotFoundException e) {
                        e.printStackTrace();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });


    }

    //--获取服务器版本后后台启动service
    public void HandlerUpApkDo() {
        final DownApkDialog dialog = new DownApkDialog(FirstMainActivity.this, R.style.MyDialog, R.layout.downapk_dialog);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        SetBackgroundalph(0.7f);
        Button button = (Button) dialog.findViewById(R.id.downapk_dialog_no);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                SetBackgroundalph(1.0f);
            }
        });
        Button button2 = (Button) dialog.findViewById(R.id.downapk_dialog_yes);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                SetBackgroundalph(1.0f);
                if (ContextCompat.checkSelfPermission(FirstMainActivity.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(FirstMainActivity.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                            10);
                } else {
                    Intent intent = new Intent(FirstMainActivity.this, UpApkService.class);
                    startService(intent);
                }
            }
        });

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (firstmain_scrollview.isopen()) {
                firstmain_scrollview.closemenu();

            } else {
                // 创建退出对话框
                AlertDialog isExit = new AlertDialog.Builder(this).create();
                // 设置对话框标题
                isExit.setTitle("系统提示");
                // 设置对话框消息
                isExit.setMessage("确定要退出吗");
                // 添加选择按钮并注册监听
                isExit.setButton("确定", listener);
                isExit.setButton2("取消", listener);
                // 显示对话框
                isExit.show();
            }

        }

        return false;

    }

    /**
     * 监听对话框里面的button点击事件
     */
    DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            switch (which) {
                case AlertDialog.BUTTON_POSITIVE:// "确认"按钮退出程序
                    application.moveactivity();
                    BaseActivity.user = null;
//                    firstmain_remessage = null;
//                    firstmain_message_text = null;
//                    firstmain_message_btn = null;
                    finish();
                    break;
                case AlertDialog.BUTTON_NEGATIVE:// "取消"第二个按钮取消对话框
                    break;
                default:
                    break;
            }
        }
    };

    //--当其他activity覆盖此activity的时候onstop方法会在其他activity启动完成后再执行
    @Override
    protected void onStop() {
        super.onStop();
        if (firstmain_scrollview.isopen()) {
            firstmain_scrollview.closemenu();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解除注册
        EventBus.getDefault().unregister(this);
        application.moveactivity();
        AllBedAdminActivity.DestoryActivity();
        AllOldManActivity.DestoryActivity();
        AllFirstMainActivity.DestoryActivity();
    }

}
