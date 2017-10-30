package com.example.administrator.OurPersion.View.Activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.OurPersion.Application.AndroidApplication;
import com.example.administrator.OurPersion.Model.Bean.OkHttpURL;
import com.example.administrator.OurPersion.Model.Bean.OldManPlan;
import com.example.administrator.OurPersion.Presenter.FirstMainPlanExpandable;
import com.example.administrator.OurPersion.Service.UpApkService;
import com.example.administrator.OurPersion.Utils.ToastUtils;
import com.example.administrator.OurPersion.R;
import com.example.administrator.OurPersion.SelfView.CircleImageView;
import com.example.administrator.OurPersion.SelfView.MyHorizontalScrollView;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class FirstMainPlanActivity extends BaseActivity implements View.OnClickListener, FirstMainPlanExpandable.RefashInterFace {
    ExpandableListView listView;
    FirstMainPlanExpandable expandable;
    OldManPlan oldManPlan;
    //--菜单用户名字
    TextView user_name;
    //--菜单用户头像
    CircleImageView menu_circleimage;
    MyHorizontalScrollView myHorizontalScrollView;
    CircleImageView mainactivityback_menu;
    AndroidApplication application;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            dissdialog();
            /***
             * 1表示获取所有项目成功
             * 2表示获取数据失败
             */
            if ((int) msg.obj == 1) {
                expandable = new FirstMainPlanExpandable(FirstMainPlanActivity.this, listView, oldManPlan);
                expandable.SetInterFace(FirstMainPlanActivity.this);
                listView.setAdapter(expandable);
                for (int i = 0; i < expandable.getGroupCount(); i++) {
                    listView.expandGroup(i);
                }

            } else if ((int) msg.obj == 2) {
                ToastUtils.show(FirstMainPlanActivity.this, "获取数据失败", Toast.LENGTH_SHORT);

            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstmain_plan);
        application = (AndroidApplication) getApplication();
        application.addactivity(FirstMainPlanActivity.this);
        //--初始化控件
        initview();
        GetNursePlan();
        showdialog(FirstMainPlanActivity.this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //--这里点击调转前判断菜单是否打开，如果没有打开不给予点击响应,打开跳转页面
            case R.id.nurseadmin_btn:
                if (myHorizontalScrollView.isopen()) {
                    Intent nurseintent = new Intent(FirstMainPlanActivity.this, NurseAdminActivity.class);
                    startActivity(nurseintent);
                    this.finish();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            case R.id.oldmanadmin_btn:
                if (myHorizontalScrollView.isopen()) {
                    Intent oldmanintent = new Intent(FirstMainPlanActivity.this, OldManListActivity.class);
                    startActivity(oldmanintent);
                    this.finish();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            case R.id.staffadmin_btn:
                if (myHorizontalScrollView.isopen()) {
                    Intent staffintent = new Intent(FirstMainPlanActivity.this, StaffAdminActivity.class);
                    startActivity(staffintent);
                    this.finish();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            case R.id.bedadmin_btn:
                if (myHorizontalScrollView.isopen()) {
                    Intent systemintent = new Intent(FirstMainPlanActivity.this, BedAdminActivity.class);
                    startActivity(systemintent);
                    this.finish();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            case R.id.messagesend_btn:
                if (myHorizontalScrollView.isopen()) {
                    Intent systemintent = new Intent(FirstMainPlanActivity.this, MessageActivity.class);
                    startActivity(systemintent);
                    this.finish();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            case R.id.mainactivityback_menu:
                if (!myHorizontalScrollView.isopen()) {
                    this.finish();
                    overridePendingTransition(R.animator.animation_in, R.animator.animation_out);
                }
                break;

        }

    }

    public void initview() {
        myHorizontalScrollView = (MyHorizontalScrollView) findViewById(R.id.main_scrollview);
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
        user_name = (TextView) findViewById(R.id.user_name);
        user_name.setText(user.getEmployeeName());
        mainactivityback_menu = (CircleImageView) findViewById(R.id.mainactivityback_menu);
        Picasso.with(FirstMainPlanActivity.this).load(OkHttpURL.ImageURL + user.getImgPath()).placeholder(R.mipmap.default_image).into(mainactivityback_menu);
        mainactivityback_menu.setOnClickListener(this);
        menu_circleimage = (CircleImageView) findViewById(R.id.menu_circleimage);
        Picasso.with(FirstMainPlanActivity.this).load(OkHttpURL.ImageURL + user.getImgPath()).placeholder(R.mipmap.default_image).into(menu_circleimage);
        listView = (ExpandableListView) findViewById(R.id.firstmainplan_expanablelistview);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 10) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Intent intent = new Intent(FirstMainPlanActivity.this, UpApkService.class);
                startService(intent);

            } else {
                ToastUtils.show(FirstMainPlanActivity.this, "权限被拒绝", Toast.LENGTH_SHORT);

            }

        }
    }

    public void GetNursePlan() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String time = df.format(new Date());
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(15, TimeUnit.SECONDS).writeTimeout(15, TimeUnit.SECONDS).build();
        Request request = new Request.Builder().get().url("http://192.168.10.7:7006/api/NursingApi/EmployeeGetGroupPlan?dateSign=" + time + "&loginId=" + BaseActivity.user.getId()).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                try {
                    JSONObject jsonObject = new JSONObject(result);
                    if (jsonObject.has("Message")) {
                        Message message = new Message();
                        message.obj = 2;
                        handler.sendMessage(message);
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String s = "{\"OldManPlan\":";
                StringBuffer sb = new StringBuffer(result);
                sb.insert(0, s);
                String data = sb.toString() + "}";
                Gson gson = new Gson();
                oldManPlan = gson.fromJson(data, OldManPlan.class);
                Message message = new Message();
                message.obj = 1;
                handler.sendMessage(message);
            }
        });

    }

    //刷新所有项目数据的接口
    @Override
    public void Refash() {
        GetNursePlan();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (myHorizontalScrollView.isopen()) {
                myHorizontalScrollView.closemenu();

            } else {
                FirstMainPlanActivity.this.finish();
                overridePendingTransition(R.animator.animation_in, R.animator.animation_out);
            }

        }

        return false;

    }

}
