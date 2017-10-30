package com.example.administrator.OurPersion.View.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.OurPersion.Application.AllBedAdminActivity;
import com.example.administrator.OurPersion.Application.AllFirstMainActivity;
import com.example.administrator.OurPersion.Application.AllOldManActivity;
import com.example.administrator.OurPersion.Model.Bean.AreaOldMan;
import com.example.administrator.OurPersion.Model.Bean.BedOldMan;
import com.example.administrator.OurPersion.Model.Bean.OkHttpURL;
import com.example.administrator.OurPersion.Model.Bean.OldMan;
import com.example.administrator.OurPersion.Model.Bean.OldManEnterTime;
import com.example.administrator.OurPersion.Model.Bean.OldManFamily;
import com.example.administrator.OurPersion.Presenter.OldManFamilyAdapter;
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

public class OldManFamilyMessageActivity extends BaseActivity implements View.OnClickListener {
    MyHorizontalScrollView horizontalScrollView;
    //--菜单头像和名字
    CircleImageView menu_image;
    TextView menu_username;
    TextView oldmanfamilymessageback_menu;
    OldMan.OldManListBean.DatasBean oldManListBean;
    BedOldMan bedOldMan;
    String oldid;
    AreaOldMan.AreaOldManBean areaOldManBean;
    OldManFamily oldManFamily;
    List<OldManFamily.OldManFamilyBean> list;
    RecyclerView recyclerView;
    OldManFamilyAdapter adapter;
    //--家庭信息中老人的头像，性别，姓名
    CircleImageView oldman_family_image;
    TextView oldman_family_name;
    TextView oldman_family_sex;
    //--家属信息,无数据提示
    TextView oldmanfamily_text;
    String checkidold;
    OldManEnterTime oldManEnterTime;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if ((int) msg.obj == 1) {
                if (oldManFamily.getOldManFamily().size() == 0) {
                    oldmanfamily_text.setVisibility(View.VISIBLE);
                    return;
                }
                oldmanfamily_text.setVisibility(View.GONE);
                list = new ArrayList<>();
                for (int i = 0; i < oldManFamily.getOldManFamily().size(); i++) {
                    list.add(oldManFamily.getOldManFamily().get(i));

                }

                adapter = new OldManFamilyAdapter(OldManFamilyMessageActivity.this, list);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(OldManFamilyMessageActivity.this));
                recyclerView.setAdapter(adapter);

            } else if ((int) msg.obj == 2) {
                oldmanfamily_text.setVisibility(View.VISIBLE);
                ToastUtils.show(OldManFamilyMessageActivity.this, "获取数据失败", Toast.LENGTH_SHORT);
            } else if ((int) msg.obj == 3) {
                if (TextUtils.isEmpty(oldManEnterTime.getOld().getSex())) {
                    oldman_family_sex.setText("");
                } else if (oldManEnterTime.getOld().getSex().equals("0")) {
                    oldman_family_sex.setText("男");
                } else if (oldManEnterTime.getOld().getSex().equals("1")) {
                    oldman_family_sex.setText("女");
                }
                if (TextUtils.isEmpty(oldManEnterTime.getOld().getCustomerName())) {
                    oldman_family_name.setText("");
                } else {
                    oldman_family_name.setText(oldManEnterTime.getOld().getCustomerName().toString());
                }

                Picasso.with(OldManFamilyMessageActivity.this).load(OkHttpURL.ImageURL + oldManEnterTime.getOld().getImgPath()).placeholder(R.mipmap.oldone).into(oldman_family_image);
                gethttp();
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_old_man_family_message);
        SetZTL();
        oldManListBean = (OldMan.OldManListBean.DatasBean) getIntent().getSerializableExtra("oldManListBean");
        bedOldMan = (BedOldMan) getIntent().getSerializableExtra("oldman");
        areaOldManBean = (AreaOldMan.AreaOldManBean) getIntent().getSerializableExtra("firstmainoldman");
        checkidold = (String) getIntent().getSerializableExtra("checkidold");
        if (oldManListBean != null) {
            oldid = oldManListBean.getId().toString();
        } else if (bedOldMan != null) {
            oldid = bedOldMan.getOldId().toString();
        } else if (areaOldManBean != null) {
            oldid = areaOldManBean.getOlderId().toString();
        } else {

            try {
                JSONObject jsonObject = new JSONObject(checkidold);
                oldid = jsonObject.getString("option1");
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
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
        horizontalScrollView = (MyHorizontalScrollView) findViewById(R.id.oldmanafamilymessage_scrollview);
        menu_image = (CircleImageView) findViewById(R.id.menu_circleimage);
        Picasso.with(OldManFamilyMessageActivity.this).load(OkHttpURL.ImageURL + user.getImgPath()).placeholder(R.mipmap.default_image).into(menu_image);
        menu_username = (TextView) findViewById(R.id.user_name);
        menu_username.setText(user.getEmployeeName().toString());
        oldmanfamilymessageback_menu = (TextView) findViewById(R.id.oldmanfamilymessageback_menu);
        oldmanfamilymessageback_menu.setOnClickListener(this);
        recyclerView = (RecyclerView) findViewById(R.id.oldmanfamily_rv);
        oldman_family_sex = (TextView) findViewById(R.id.oldman_family_sex);
        oldman_family_name = (TextView) findViewById(R.id.oldman_family_name);
        oldman_family_image = (CircleImageView) findViewById(R.id.oldman_family_image);
        oldmanfamily_text = (TextView) findViewById(R.id.oldmanfamily_text);
        //老人列表传递过来的
        if (oldManListBean != null) {
            if (TextUtils.isEmpty(oldManListBean.getSex())) {
                oldman_family_sex.setText("");
            } else if (oldManListBean.getSex().equals("0")) {
                oldman_family_sex.setText("男");
            } else if (oldManListBean.getSex().equals("1")) {
                oldman_family_sex.setText("女");
            }
            if (TextUtils.isEmpty(oldManListBean.getCustomerName())) {
                oldman_family_name.setText("");
            } else {
                oldman_family_name.setText(oldManListBean.getCustomerName().toString());
            }

            Picasso.with(OldManFamilyMessageActivity.this).load(OkHttpURL.ImageURL + oldManListBean.getImgPath()).placeholder(R.mipmap.oldone).into(oldman_family_image);
            gethttp();
        }
        //床位搜索传递过来的
        else if (bedOldMan != null) {
            if (TextUtils.isEmpty(bedOldMan.getOld().getSex())) {
                oldman_family_sex.setText("");
            } else if (bedOldMan.getOld().getSex().equals("0")) {
                oldman_family_sex.setText("男");
            } else if (bedOldMan.getOld().getSex().equals("1")) {
                oldman_family_sex.setText("女");
            }
            if (TextUtils.isEmpty(bedOldMan.getOld().getCustomerName())) {
                oldman_family_name.setText("");
            } else {
                oldman_family_name.setText(bedOldMan.getOld().getCustomerName().toString());
            }

            Picasso.with(OldManFamilyMessageActivity.this).load(OkHttpURL.ImageURL + bedOldMan.getOld().getImgPath()).placeholder(R.mipmap.oldone).into(oldman_family_image);
            gethttp();
        } else if (areaOldManBean != null) {
            if (TextUtils.isEmpty(areaOldManBean.getSex())) {
                oldman_family_sex.setText("");
            } else if (areaOldManBean.getSex().equals("0")) {
                oldman_family_sex.setText("男");
            } else if (areaOldManBean.getSex().equals("1")) {
                oldman_family_sex.setText("女");
            }
            if (TextUtils.isEmpty(areaOldManBean.getCustomerName())) {
                oldman_family_name.setText("");
            } else {
                oldman_family_name.setText(areaOldManBean.getCustomerName().toString());
            }

            Picasso.with(OldManFamilyMessageActivity.this).load(OkHttpURL.ImageURL + areaOldManBean.getImgPath()).placeholder(R.mipmap.oldone).into(oldman_family_image);
            gethttp();
        } else {
            try {
                JSONObject jsonObject = new JSONObject(checkidold);
                String oldid = jsonObject.getString("option1");
                GetOldManEnterMessage(oldid);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.oldmanfamilymessageback_menu:
                this.finish();
                overridePendingTransition(R.animator.animation_in, R.animator.animation_out);
                break;
            //--护理管理
            case R.id.nurseadmin_btn:
                if (horizontalScrollView.isopen()) {
                    AllBedAdminActivity.DestoryActivity();
                    Intent intent = new Intent(OldManFamilyMessageActivity.this, NurseAdminActivity.class);
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
                    Intent intent = new Intent(OldManFamilyMessageActivity.this, OldManListActivity.class);
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
                    Intent intent = new Intent(OldManFamilyMessageActivity.this, StaffAdminActivity.class);
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
                    Intent intent = new Intent(OldManFamilyMessageActivity.this, BedAdminActivity.class);
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
                    Intent intent = new Intent(OldManFamilyMessageActivity.this, MessageActivity.class);
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

    public void gethttp() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(15, TimeUnit.SECONDS).build();
        Request request = new Request.Builder().get().url("http://192.168.10.7:7006/api/Customer/GetCustomerFamily?customerID=" + oldid).build();
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
                String s = "{\"OldManFamily\":";
                StringBuffer sb = new StringBuffer(result);
                sb.insert(0, s);
                String data = sb.toString() + "}";
                Gson gson = new Gson();
                oldManFamily = gson.fromJson(data, OldManFamily.class);
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
