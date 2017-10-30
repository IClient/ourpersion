package com.example.administrator.OurPersion.View.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.OurPersion.Model.Bean.FirstMainWork;
import com.example.administrator.OurPersion.Model.Bean.OkHttpURL;
import com.example.administrator.OurPersion.R;
import com.example.administrator.OurPersion.SelfView.CircleImageView;
import com.example.administrator.OurPersion.SelfView.MyCalendarView;
import com.example.administrator.OurPersion.SelfView.MyHorizontalScrollView;
import com.example.administrator.OurPersion.Utils.ToastUtils;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;

import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/9/29 0029.
 */

public class FirstMainWorkActivity extends BaseActivity implements View.OnClickListener {
    /**
     * 自定义日期的控件以及数据
     */
    private TextView mTextSelectMonth;
    private ImageButton mLastMonthView;
    private ImageButton mNextMonthView;
    private MyCalendarView mCalendarView;
    private List<String> mDatas;
    //菜单
    TextView user_name;
    CircleImageView menu_circleimage;
    MyHorizontalScrollView firstmainwork_scrollview;
    CircleImageView firstmainworkback_menu;
    String year;
    String month;
    public static FirstMainWork firstMainWork;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if ((int) msg.obj == 1) {
                dissdialog();
                ToastUtils.show(FirstMainWorkActivity.this, "获取数据失败", Toast.LENGTH_SHORT);

            } else if ((int) msg.obj == 2) {
                dissdialog();
                firstMainWork = null;
            } else if ((int) msg.obj == 3) {
                dissdialog();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //-请求数据成功后重新绘制
                        mCalendarView.invalidate();
                    }
                }, 1000);


            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstmain_work);
        SetZTL();
        // 初始化默认日期,获取默认日期的排班情况
        initData();

    }

    public void initview() {
        user_name = (TextView) findViewById(R.id.user_name);
        user_name.setText(user.getEmployeeName());
        menu_circleimage = (CircleImageView) findViewById(R.id.menu_circleimage);
        Picasso.with(FirstMainWorkActivity.this).load(OkHttpURL.ImageURL + user.getImgPath()).placeholder(R.mipmap.default_image).into(menu_circleimage);
        firstmainwork_scrollview = (MyHorizontalScrollView) findViewById(R.id.firstmainwork_scrollview);
        firstmainworkback_menu = (CircleImageView) findViewById(R.id.firstmainworkback_menu);
        firstmainworkback_menu.setOnClickListener(this);
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
        mTextSelectMonth = (TextView) findViewById(R.id.txt_select_month);
        mLastMonthView = (ImageButton) findViewById(R.id.img_select_last_month);
        mNextMonthView = (ImageButton) findViewById(R.id.img_select_next_month);
        mCalendarView = (MyCalendarView) findViewById(R.id.calendarView);
        mLastMonthView.setOnClickListener(this);
        mNextMonthView.setOnClickListener(this);
    }

    private void initData() {
        initview();
        mDatas = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR) + "";
        month = calendar.get(Calendar.MONTH) + 1 + "";
        //--得到某月的总天数
        int day = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int i = 1; i < day; i++) {
            if (i < 10) {
                mDatas.add((year + "") + (month + "0") + (i + ""));
            } else {
                mDatas.add((year + "") + (month + "") + (i + ""));
            }
        }
        // 设置可选日期
        mCalendarView.setOptionalDate(mDatas);
        mTextSelectMonth.setText(mCalendarView.getDate());
        year = mCalendarView.getDate().substring(0, 4);
        month = mCalendarView.getDate().substring(5, mCalendarView.getDate().length());
        gethttp();
        showdialog(FirstMainWorkActivity.this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //--上一个月
            case R.id.img_select_last_month:
                showdialog(FirstMainWorkActivity.this);
                mCalendarView.setLastMonth();
                mTextSelectMonth.setText(mCalendarView.getDate());
                year = mCalendarView.getDate().substring(0, 4);
                month = mCalendarView.getDate().substring(5, mCalendarView.getDate().length());
                gethttp();
                break;
            //--下一个月
            case R.id.img_select_next_month:
                showdialog(FirstMainWorkActivity.this);
                mCalendarView.setNextMonth();
                mTextSelectMonth.setText(mCalendarView.getDate());
                year = mCalendarView.getDate().substring(0, 4);
                month = mCalendarView.getDate().substring(5, mCalendarView.getDate().length());
                gethttp();
                break;
            case R.id.firstmainworkback_menu:
                if (!firstmainwork_scrollview.isopen()) {
                    firstmainwork_scrollview.openmenu();
                }
                break;
            case R.id.nurseadmin_btn:
                if (firstmainwork_scrollview.isopen()) {
                    Intent nurseintent = new Intent(FirstMainWorkActivity.this, NurseAdminActivity.class);
                    startActivity(nurseintent);
                    FirstMainWorkActivity.this.finish();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            case R.id.oldmanadmin_btn:
                if (firstmainwork_scrollview.isopen()) {
                    Intent oldmanintent = new Intent(FirstMainWorkActivity.this, OldManListActivity.class);
                    startActivity(oldmanintent);
                    FirstMainWorkActivity.this.finish();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            case R.id.staffadmin_btn:
                if (firstmainwork_scrollview.isopen()) {
                    Intent staffintent = new Intent(FirstMainWorkActivity.this, StaffAdminActivity.class);
                    startActivity(staffintent);
                    FirstMainWorkActivity.this.finish();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            case R.id.bedadmin_btn:
                if (firstmainwork_scrollview.isopen()) {
                    Intent staffintent = new Intent(FirstMainWorkActivity.this, BedAdminActivity.class);
                    startActivity(staffintent);
                    FirstMainWorkActivity.this.finish();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            case R.id.messagesend_btn:
                if (firstmainwork_scrollview.isopen()) {
                    Intent staffintent = new Intent(FirstMainWorkActivity.this, MessageActivity.class);
                    startActivity(staffintent);
                    FirstMainWorkActivity.this.finish();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;

        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (firstmainwork_scrollview.isopen()) {
                firstmainwork_scrollview.closemenu();

            } else {
                FirstMainWorkActivity.this.finish();
                overridePendingTransition(R.animator.animation_in, R.animator.animation_out);

            }
        }
        return false;
    }

    public void gethttp() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(15, TimeUnit.SECONDS).readTimeout(15, TimeUnit.SECONDS).build();
        Request request = new Request.Builder().get().url("http://192.168.10.7:7006/api/Employee/GetPersonWorkforceForm?employeeId=" + user.getId() + "&year=" + year + "&month=" + month).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                Log.e("...", result);
                if (result.contains("Message")) {
                    Message message = new Message();
                    message.obj = 1;
                    handler.sendMessage(message);
                    return;
                } else if (result.equals("[]")) {

                    Message message = new Message();
                    message.obj = 2;
                    handler.sendMessage(message);
                    return;
                }
                String s = "{\"FirstMainWork\":";
                StringBuffer sb = new StringBuffer(result);
                sb.insert(0, s);
                String data = sb.toString() + "}".trim();
                Gson gson = new Gson();
                firstMainWork = gson.fromJson(data, FirstMainWork.class);
                Message message = new Message();
                message.obj = 3;
                handler.sendMessage(message);


            }
        });


    }

}


