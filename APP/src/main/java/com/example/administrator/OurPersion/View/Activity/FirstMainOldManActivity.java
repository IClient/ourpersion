package com.example.administrator.OurPersion.View.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.OurPersion.Application.AllFirstMainActivity;
import com.example.administrator.OurPersion.Model.Bean.AreaOldMan;
import com.example.administrator.OurPersion.Model.Bean.OkHttpURL;
import com.example.administrator.OurPersion.Presenter.FirstMainOldManAdapter;
import com.example.administrator.OurPersion.R;
import com.example.administrator.OurPersion.SelfView.CircleImageView;
import com.example.administrator.OurPersion.SelfView.MyHorizontalScrollView;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/9/29 0029.
 */

public class FirstMainOldManActivity extends BaseActivity implements View.OnClickListener, FirstMainOldManAdapter.OnclickInterFace {
    //--菜单名字
    TextView user_name;
    CircleImageView menu_circleimage;
    MyHorizontalScrollView firstmain_oldman_scrollview;
    CircleImageView firstmain_oldmanback_menu;
    RecyclerView firstmain_oldman_rv;
    TextView firstmain_oldman_t;
    AreaOldMan areaOldMan;
    FirstMainOldManAdapter adapter;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if ((int) msg.obj == 1) {
                firstmain_oldman_t.setVisibility(View.VISIBLE);
                firstmain_oldman_rv.setVisibility(View.GONE);

            } else if ((int) msg.obj == 2) {
                firstmain_oldman_t.setVisibility(View.VISIBLE);
                firstmain_oldman_rv.setVisibility(View.GONE);

            } else if ((int) msg.obj == 3) {
                firstmain_oldman_t.setVisibility(View.GONE);
                firstmain_oldman_rv.setVisibility(View.VISIBLE);
                adapter = new FirstMainOldManAdapter(areaOldMan, FirstMainOldManActivity.this);
                adapter.SetInterface(FirstMainOldManActivity.this);
                firstmain_oldman_rv.setHasFixedSize(true);
                firstmain_oldman_rv.setLayoutManager(new LinearLayoutManager(FirstMainOldManActivity.this));
                firstmain_oldman_rv.setAdapter(adapter);

            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstmain_oldman);
        AllFirstMainActivity.AddActivity(FirstMainOldManActivity.this);
        SetZTL();
        initview();
        gethttp();
    }

    public void initview() {
        firstmain_oldman_scrollview = (MyHorizontalScrollView) findViewById(R.id.firstmain_oldman_scrollview);
        firstmain_oldmanback_menu = (CircleImageView) findViewById(R.id.firstmain_oldmanback_menu);
        firstmain_oldmanback_menu.setOnClickListener(this);
        Picasso.with(FirstMainOldManActivity.this).load(OkHttpURL.ImageURL + user.getImgPath()).placeholder(R.mipmap.default_image).into(firstmain_oldmanback_menu);
        nurseadmin_btn = (Button) findViewById(R.id.nurseadmin_btn);
        nurseadmin_btn.setOnClickListener(this);
        oldmanadmin_btn = (Button) findViewById(R.id.oldmanadmin_btn);
        oldmanadmin_btn.setOnClickListener(this);
        staffadmin_btn = (Button) findViewById(R.id.staffadmin_btn);
        staffadmin_btn.setOnClickListener(this);
        bedadmin_btn = (Button) findViewById(R.id.bedadmin_btn);
        bedadmin_btn.setOnClickListener(this);
        messagesend_btn= (Button) findViewById(R.id.messagesend_btn);
        messagesend_btn.setOnClickListener(this);
        user_name = (TextView) findViewById(R.id.user_name);
        user_name.setText(user.getEmployeeName());
        menu_circleimage = (CircleImageView) findViewById(R.id.menu_circleimage);
        Picasso.with(FirstMainOldManActivity.this).load(OkHttpURL.ImageURL + user.getImgPath()).placeholder(R.mipmap.default_image).into(menu_circleimage);
        firstmain_oldman_rv = (RecyclerView) findViewById(R.id.firstmain_oldman_rv);
        firstmain_oldman_t = (TextView) findViewById(R.id.firstmain_oldman_t);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.nurseadmin_btn:
                if (firstmain_oldman_scrollview.isopen()) {
                    Intent nurseintent = new Intent(FirstMainOldManActivity.this, NurseAdminActivity.class);
                    startActivity(nurseintent);
                    FirstMainOldManActivity.this.finish();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            case R.id.oldmanadmin_btn:
                if (firstmain_oldman_scrollview.isopen()) {
                    Intent oldmanintent = new Intent(FirstMainOldManActivity.this, OldManListActivity.class);
                    startActivity(oldmanintent);
                    FirstMainOldManActivity.this.finish();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            case R.id.staffadmin_btn:
                if (firstmain_oldman_scrollview.isopen()) {
                    Intent staffintent = new Intent(FirstMainOldManActivity.this, StaffAdminActivity.class);
                    startActivity(staffintent);
                    FirstMainOldManActivity.this.finish();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            case R.id.bedadmin_btn:
                if (firstmain_oldman_scrollview.isopen()) {
                    Intent bedintent = new Intent(FirstMainOldManActivity.this, BedAdminActivity.class);
                    startActivity(bedintent);
                    FirstMainOldManActivity.this.finish();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }

                break;
            case R.id.messagesend_btn:
                if (firstmain_oldman_scrollview.isopen()) {
                    Intent bedintent = new Intent(FirstMainOldManActivity.this, MessageActivity.class);
                    startActivity(bedintent);
                    FirstMainOldManActivity.this.finish();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }

                break;

            case R.id.firstmain_oldmanback_menu:
                if (!firstmain_oldman_scrollview.isopen()) {
                    FirstMainOldManActivity.this.finish();
                    overridePendingTransition(R.animator.animation_in, R.animator.animation_out);

                }
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (firstmain_oldman_scrollview.isopen()) {
                firstmain_oldman_scrollview.closemenu();

            } else {
                FirstMainOldManActivity.this.finish();
                overridePendingTransition(R.animator.animation_in, R.animator.animation_out);

            }
        }
        return false;
    }

    public void gethttp() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(15, TimeUnit.SECONDS).readTimeout(15, TimeUnit.SECONDS).build();
        Request request = new Request.Builder().get().url("http://192.168.10.7:7006/api/NursingApi/GetOlderGroupList?LoginId=" + user.getId()).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
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
                String s = "{\"AreaOldMan\":";
                StringBuffer sb = new StringBuffer(result);
                sb.insert(0, s);
                String data = sb.toString() + "}".trim();
                Gson gson = new Gson();
                areaOldMan = gson.fromJson(data, AreaOldMan.class);
                Message message = new Message();
                message.obj = 3;
                handler.sendMessage(message);

            }
        });

    }

    @Override
    public void Onclick(int position) {
        Intent intent = new Intent(FirstMainOldManActivity.this, OldManAdminActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("firstmainoldman", areaOldMan.getAreaOldMan().get(position));
        intent.putExtras(bundle);
        startActivity(intent);
        overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AllFirstMainActivity.DestoryActivity();
    }
}
