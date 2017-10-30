package com.example.administrator.OurPersion.View.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.administrator.OurPersion.Application.AllBedAdminActivity;
import com.example.administrator.OurPersion.Application.AllFirstMainActivity;
import com.example.administrator.OurPersion.Application.AllOldManActivity;
import com.example.administrator.OurPersion.Model.Bean.AreaOldMan;
import com.example.administrator.OurPersion.Model.Bean.BedOldMan;
import com.example.administrator.OurPersion.Model.Bean.OkHttpURL;
import com.example.administrator.OurPersion.Model.Bean.OldMan;
import com.example.administrator.OurPersion.Model.Bean.OldManEnterTime;
import com.example.administrator.OurPersion.Model.Bean.OldManFamily;
import com.example.administrator.OurPersion.Model.Bean.OldManHealth;
import com.example.administrator.OurPersion.Presenter.OldManHealthAdapter;
import com.example.administrator.OurPersion.R;
import com.example.administrator.OurPersion.SelfView.CircleImageView;
import com.example.administrator.OurPersion.SelfView.MyHorizontalScrollView;
import com.example.administrator.OurPersion.Utils.ToastUtils;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OldManHealthMessageActivity extends BaseActivity implements View.OnClickListener {
    MyHorizontalScrollView horizontalScrollView;
    TextView menu_username;
    CircleImageView menu_image;
    TextView oldmanhealthmessageback_menu;
    OldMan.OldManListBean.DatasBean oldManListBean;
    BedOldMan bedOldMan;
    String oldid;
    AreaOldMan.AreaOldManBean areaOldManBean;
    CircleImageView oldman_health_image;
    TextView oldman_health_name;
    TextView oldman_health_sex;
    RecyclerView recyclerView;
    List<OldManHealth.OldManHealthBean> list;
    OldManHealthAdapter adapter;
    TextView oldmanhealth_text;
    OldManHealth oldManHealth;
    String checkidold;
    OldManEnterTime oldManEnterTime;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if ((int) msg.obj == 1) {
                if (oldManHealth.getOldManHealth().size() == 0) {
                    oldmanhealth_text.setVisibility(View.VISIBLE);
                    return;

                } else {
                    oldmanhealth_text.setVisibility(View.GONE);
                    list = new ArrayList<>();
                    for (int i = 0; i < oldManHealth.getOldManHealth().size(); i++) {
                        list.add(oldManHealth.getOldManHealth().get(i));

                    }
                    adapter = new OldManHealthAdapter(OldManHealthMessageActivity.this, list);
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(OldManHealthMessageActivity.this));
                    recyclerView.setAdapter(adapter);

                }

            } else if ((int) msg.obj == 2) {
                oldmanhealth_text.setVisibility(View.VISIBLE);
                ToastUtils.show(OldManHealthMessageActivity.this, "获取数据失败", Toast.LENGTH_SHORT);

            }else if ((int) msg.obj == 3) {
                Picasso.with(OldManHealthMessageActivity.this).load(OkHttpURL.ImageURL + oldManEnterTime.getOld().getImgPath()).placeholder(R.mipmap.oldone).into(oldman_health_image);
                if (TextUtils.isEmpty( oldManEnterTime.getOld().getCustomerName())) {
                    oldman_health_name.setText("");
                }
                oldman_health_name.setText( oldManEnterTime.getOld().getCustomerName().toString());

                if (TextUtils.isEmpty( oldManEnterTime.getOld().getSex())) {
                    oldman_health_sex.setText("");

                } else if ( oldManEnterTime.getOld().getSex().equals("0")) {
                    oldman_health_sex.setText("男");

                } else if ( oldManEnterTime.getOld().getSex().equals("1")) {
                    oldman_health_sex.setText("女");

                }
                GetOldHealth(oldid);

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_old_man_health_message);
        oldManListBean = (OldMan.OldManListBean.DatasBean) getIntent().getSerializableExtra("oldManListBean");
        bedOldMan = (BedOldMan) getIntent().getSerializableExtra("oldman");
        areaOldManBean = (AreaOldMan.AreaOldManBean) getIntent().getSerializableExtra("firstmainoldman");
        checkidold = (String) getIntent().getSerializableExtra("checkidold");
        if (oldManListBean != null) {
            oldid = oldManListBean.getId();

        } else if (bedOldMan != null) {
            oldid = bedOldMan.getOldId();

        } else if (areaOldManBean != null) {
            oldid = areaOldManBean.getOlderId();
        } else {
            try {
                JSONObject jsonObject = new JSONObject(checkidold);
                oldid = jsonObject.getString("option1");
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        SetZTL();
        initview();
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
        horizontalScrollView = (MyHorizontalScrollView) findViewById(R.id.oldmanhealthmessage_scrollview);
        menu_username = (TextView) findViewById(R.id.user_name);
        menu_username.setText(user.getEmployeeName().toString());
        menu_image = (CircleImageView) findViewById(R.id.menu_circleimage);
        Picasso.with(OldManHealthMessageActivity.this).load(OkHttpURL.ImageURL + user.getImgPath()).placeholder(R.mipmap.default_image).into(menu_image);
        oldmanhealthmessageback_menu = (TextView) findViewById(R.id.oldmanhealthmessageback_menu);
        oldmanhealthmessageback_menu.setOnClickListener(this);
        oldman_health_image = (CircleImageView) findViewById(R.id.oldman_health_image);
        oldman_health_name = (TextView) findViewById(R.id.oldman_health_name);
        oldman_health_sex = (TextView) findViewById(R.id.oldman_health_sex);
        recyclerView = (RecyclerView) findViewById(R.id.oldmanhealth_rv);

        oldmanhealth_text = (TextView) findViewById(R.id.oldmanhealth_text);
        //--老人列表传递过来的
        if (oldManListBean != null) {
            Picasso.with(OldManHealthMessageActivity.this).load(OkHttpURL.ImageURL + oldManListBean.getImgPath()).placeholder(R.mipmap.oldone).into(oldman_health_image);
            if (TextUtils.isEmpty(oldManListBean.getCustomerName())) {
                oldman_health_name.setText("");
            }
            oldman_health_name.setText(oldManListBean.getCustomerName().toString());

            if (TextUtils.isEmpty(oldManListBean.getSex())) {
                oldman_health_sex.setText("");

            } else if (oldManListBean.getSex().equals("0")) {
                oldman_health_sex.setText("男");

            } else if (oldManListBean.getSex().equals("1")) {
                oldman_health_sex.setText("女");

            }
            GetOldHealth(oldid);
        }
//        床位搜索传递过来的
        else if (bedOldMan != null) {
            Picasso.with(OldManHealthMessageActivity.this).load(OkHttpURL.ImageURL + bedOldMan.getOld().getImgPath()).placeholder(R.mipmap.oldone).into(oldman_health_image);
            if (TextUtils.isEmpty(bedOldMan.getOld().getCustomerName())) {
                oldman_health_name.setText("");
            }
            oldman_health_name.setText(bedOldMan.getOld().getCustomerName().toString());

            if (TextUtils.isEmpty(bedOldMan.getOld().getSex())) {
                oldman_health_sex.setText("");

            } else if (bedOldMan.getOld().getSex().equals("0")) {
                oldman_health_sex.setText("男");

            } else if (bedOldMan.getOld().getSex().equals("1")) {
                oldman_health_sex.setText("女");

            }
            GetOldHealth(oldid);
        } else if (areaOldManBean != null) {
            Picasso.with(OldManHealthMessageActivity.this).load(OkHttpURL.ImageURL + areaOldManBean.getImgPath()).placeholder(R.mipmap.oldone).into(oldman_health_image);
            if (TextUtils.isEmpty(areaOldManBean.getCustomerName())) {
                oldman_health_name.setText("");
            }
            oldman_health_name.setText(areaOldManBean.getCustomerName().toString());

            if (TextUtils.isEmpty(areaOldManBean.getSex())) {
                oldman_health_sex.setText("");

            } else if (areaOldManBean.getSex().equals("0")) {
                oldman_health_sex.setText("男");

            } else if (areaOldManBean.getSex().equals("1")) {
                oldman_health_sex.setText("女");

            }
            GetOldHealth(oldid);
        } else {
            GetOldManEnterMessage(oldid);
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.oldmanhealthmessageback_menu:
                this.finish();
                overridePendingTransition(R.animator.animation_in, R.animator.animation_out);
                break;
            //--护理管理
            case R.id.nurseadmin_btn:
                if (horizontalScrollView.isopen()) {
                    AllBedAdminActivity.DestoryActivity();
                    Intent intent = new Intent(OldManHealthMessageActivity.this, NurseAdminActivity.class);
                    startActivity(intent);
                    this.finish();
                    AllOldManActivity.DestoryActivity();
                    AllFirstMainActivity.DestoryActivity();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;

            //--老人管理
            case R.id.oldmanadmin_btn:
                if (horizontalScrollView.isopen()) {
                    Intent intent = new Intent(OldManHealthMessageActivity.this, OldManListActivity.class);
                    startActivity(intent);
                    this.finish();
                    AllOldManActivity.DestoryActivity();
                    AllBedAdminActivity.DestoryActivity();
                    AllFirstMainActivity.DestoryActivity();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            //--员工
            case R.id.staffadmin_btn:
                if (horizontalScrollView.isopen()) {
                    AllBedAdminActivity.DestoryActivity();
                    Intent intent = new Intent(OldManHealthMessageActivity.this, StaffAdminActivity.class);
                    startActivity(intent);
                    this.finish();
                    AllOldManActivity.DestoryActivity();
                    AllFirstMainActivity.DestoryActivity();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            //--床位
            case R.id.bedadmin_btn:
                if (horizontalScrollView.isopen()) {
                    AllBedAdminActivity.DestoryActivity();
                    Intent intent = new Intent(OldManHealthMessageActivity.this, BedAdminActivity.class);
                    startActivity(intent);
                    this.finish();
                    AllOldManActivity.DestoryActivity();
                    AllFirstMainActivity.DestoryActivity();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            case R.id.messagesend_btn:
                if (horizontalScrollView.isopen()) {
                    AllBedAdminActivity.DestoryActivity();
                    Intent intent = new Intent(OldManHealthMessageActivity.this, MessageActivity.class);
                    startActivity(intent);
                    this.finish();
                    AllOldManActivity.DestoryActivity();
                    AllFirstMainActivity.DestoryActivity();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (horizontalScrollView.isopen()) {
                horizontalScrollView.closemenu();

            } else {
                this.finish();
                overridePendingTransition(R.animator.animation_in, R.animator.animation_out);
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    public void GetOldHealth(String oldid) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(15, TimeUnit.SECONDS).writeTimeout(15, TimeUnit.SECONDS).build();
        Request request = new Request.Builder().get().url("http://192.168.10.7:7006/api/Customer/GetAllOldPersonMedicalRecordByOldPersonId?oldPersonId=" + oldid).build();
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
                String s = "{\"OldManHealth\":";
                StringBuffer sb = new StringBuffer(result);
                sb.insert(0, s);
                String data = sb.toString() + "}";
                Gson gson = new Gson();
                oldManHealth = gson.fromJson(data, OldManHealth.class);
                Message message = new Message();
                message.obj = 1;
                handler.sendMessage(message);
            }
        });


    }

    public void GetOldManEnterMessage(final String id) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(15, TimeUnit.SECONDS).writeTimeout(15, TimeUnit.SECONDS).build();
        Request request = new Request.Builder().get().url("http://192.168.10.7:7006/api/Customer/GetCheckinByOldId?OldId=" + id).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                oldManEnterTime = gson.fromJson(response.body().string(), OldManEnterTime.class);
                Message message = new Message();
                message.obj = 3;
                handler.sendMessage(message);
            }
        });


    }
}
