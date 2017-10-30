package com.example.administrator.OurPersion.View.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.OurPersion.Application.AllBedAdminActivity;
import com.example.administrator.OurPersion.Application.AllFirstMainActivity;
import com.example.administrator.OurPersion.Application.AllOldManActivity;
import com.example.administrator.OurPersion.Model.Bean.AreaOldMan;
import com.example.administrator.OurPersion.Model.Bean.BedOldMan;
import com.example.administrator.OurPersion.Model.Bean.OkHttpURL;
import com.example.administrator.OurPersion.Model.Bean.OldMan;
import com.example.administrator.OurPersion.Model.Bean.OldManEnterTime;
import com.example.administrator.OurPersion.R;
import com.example.administrator.OurPersion.SelfView.CircleImageView;
import com.example.administrator.OurPersion.SelfView.MyHorizontalScrollView;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OldManCateringActivity extends BaseActivity implements View.OnClickListener {
    MyHorizontalScrollView horizontalScrollView;
    TextView menu_username;
    CircleImageView menu_image;
    TextView oldmancateringback_menu;
    OldMan.OldManListBean.DatasBean oldManListBean;
    CircleImageView oldman_catering_image;
    TextView oldman_catering_name;
    TextView oldman_catering_sex;
    BedOldMan bedOldMan;
    AreaOldMan.AreaOldManBean areaOldManBean;
    String oldcheckinid;
    TextView catering_text;
    RecyclerView catering_rv;
    String checkidold;
    OldManEnterTime oldManEnterTime;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if ((int) msg.obj == 3) {
                Picasso.with(OldManCateringActivity.this).load(OkHttpURL.ImageURL + oldManEnterTime.getOld().getImgPath()).placeholder(R.mipmap.oldone).into(oldman_catering_image);
                oldman_catering_name = (TextView) findViewById(R.id.oldman_catering_name);
                if (TextUtils.isEmpty(oldManEnterTime.getOld().getCustomerName())) {
                    oldman_catering_name.setText("");
                }
                oldman_catering_name.setText(oldManEnterTime.getOld().getCustomerName().toString());
                oldman_catering_sex = (TextView) findViewById(R.id.oldman_catering_sex);
                if (TextUtils.isEmpty(oldManEnterTime.getOld().getSex())) {
                    oldman_catering_sex.setText("");

                } else if (oldManEnterTime.getOld().getSex().equals("0")) {
                    oldman_catering_sex.setText("男");

                } else if (oldManEnterTime.getOld().getSex().equals("1")) {
                    oldman_catering_sex.setText("女");

                }

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_old_man_catering);
        oldManListBean = (OldMan.OldManListBean.DatasBean) getIntent().getSerializableExtra("oldManListBean");
        bedOldMan = (BedOldMan) getIntent().getSerializableExtra("oldman");
        areaOldManBean = (AreaOldMan.AreaOldManBean) getIntent().getSerializableExtra("firstmainoldman");
        if (oldManListBean != null) {
            oldcheckinid = oldManListBean.getCheckIn().toString();
        } else if (bedOldMan != null) {
            oldcheckinid = bedOldMan.getId().toString();
        } else if (areaOldManBean != null) {
            oldcheckinid = areaOldManBean.getInLiveId();
        } else {
            checkidold = (String) getIntent().getSerializableExtra("checkidold");

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
        horizontalScrollView = (MyHorizontalScrollView) findViewById(R.id.oldmancatering_scrollview);
        menu_username = (TextView) findViewById(R.id.user_name);
        menu_username.setText(user.getEmployeeName().toString());
        menu_image = (CircleImageView) findViewById(R.id.menu_circleimage);
        Picasso.with(OldManCateringActivity.this).load(OkHttpURL.ImageURL + user.getImgPath()).placeholder(R.mipmap.default_image).into(menu_image);
        oldmancateringback_menu = (TextView) findViewById(R.id.oldmancateringback_menu);
        oldmancateringback_menu.setOnClickListener(this);
        oldman_catering_image = (CircleImageView) findViewById(R.id.oldman_catering_image);
        catering_text = (TextView) findViewById(R.id.catering_text);
        catering_rv = (RecyclerView) findViewById(R.id.catering_rv);
        if (oldManListBean != null) {
            Picasso.with(OldManCateringActivity.this).load(OkHttpURL.ImageURL + oldManListBean.getImgPath()).placeholder(R.mipmap.oldone).into(oldman_catering_image);
            oldman_catering_name = (TextView) findViewById(R.id.oldman_catering_name);
            if (TextUtils.isEmpty(oldManListBean.getCustomerName())) {
                oldman_catering_name.setText("");
            }
            oldman_catering_name.setText(oldManListBean.getCustomerName().toString());
            oldman_catering_sex = (TextView) findViewById(R.id.oldman_catering_sex);
            if (TextUtils.isEmpty(oldManListBean.getSex())) {
                oldman_catering_sex.setText("");

            } else if (oldManListBean.getSex().equals("0")) {
                oldman_catering_sex.setText("男");

            } else if (oldManListBean.getSex().equals("1")) {
                oldman_catering_sex.setText("女");

            }
        } else if (bedOldMan != null) {
            Picasso.with(OldManCateringActivity.this).load(OkHttpURL.ImageURL + bedOldMan.getOld().getImgPath()).placeholder(R.mipmap.oldone).into(oldman_catering_image);
            oldman_catering_name = (TextView) findViewById(R.id.oldman_catering_name);
            if (TextUtils.isEmpty(bedOldMan.getOld().getCustomerName())) {
                oldman_catering_name.setText("");
            }
            oldman_catering_name.setText(bedOldMan.getOld().getCustomerName().toString());
            oldman_catering_sex = (TextView) findViewById(R.id.oldman_catering_sex);
            if (TextUtils.isEmpty(bedOldMan.getOld().getSex())) {
                oldman_catering_sex.setText("");

            } else if (bedOldMan.getOld().getSex().equals("0")) {
                oldman_catering_sex.setText("男");

            } else if (bedOldMan.getOld().getSex().equals("1")) {
                oldman_catering_sex.setText("女");

            }

        } else if (areaOldManBean != null) {
            Picasso.with(OldManCateringActivity.this).load(OkHttpURL.ImageURL + areaOldManBean.getImgPath()).placeholder(R.mipmap.oldone).into(oldman_catering_image);
            oldman_catering_name = (TextView) findViewById(R.id.oldman_catering_name);
            if (TextUtils.isEmpty(areaOldManBean.getCustomerName())) {
                oldman_catering_name.setText("");
            }
            oldman_catering_name.setText(areaOldManBean.getCustomerName().toString());
            oldman_catering_sex = (TextView) findViewById(R.id.oldman_catering_sex);
            if (TextUtils.isEmpty(areaOldManBean.getSex())) {
                oldman_catering_sex.setText("");

            } else if (areaOldManBean.equals("0")) {
                oldman_catering_sex.setText("男");

            } else if (areaOldManBean.equals("1")) {
                oldman_catering_sex.setText("女");

            }
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
            case R.id.oldmancateringback_menu:
                this.finish();
                overridePendingTransition(R.animator.animation_in, R.animator.animation_out);
                break;
            //--护理管理
            case R.id.nurseadmin_btn:
                if (horizontalScrollView.isopen()) {
                    AllBedAdminActivity.DestoryActivity();
                    Intent intent = new Intent(OldManCateringActivity.this, NurseAdminActivity.class);
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
                    Intent intent = new Intent(OldManCateringActivity.this, OldManListActivity.class);
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
                    AllFirstMainActivity.DestoryActivity();
                    Intent intent = new Intent(OldManCateringActivity.this, StaffAdminActivity.class);
                    startActivity(intent);
                    this.finish();
                    AllOldManActivity.DestoryActivity();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            //--床位
            case R.id.bedadmin_btn:
                if (horizontalScrollView.isopen()) {
                    AllBedAdminActivity.DestoryActivity();
                    AllFirstMainActivity.DestoryActivity();
                    Intent intent = new Intent(OldManCateringActivity.this, BedAdminActivity.class);
                    startActivity(intent);
                    this.finish();
                    AllOldManActivity.DestoryActivity();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            case R.id.messagesend_btn:
                if (horizontalScrollView.isopen()) {
                    AllBedAdminActivity.DestoryActivity();
                    AllFirstMainActivity.DestoryActivity();
                    Intent intent = new Intent(OldManCateringActivity.this, MessageActivity.class);
                    startActivity(intent);
                    this.finish();
                    AllOldManActivity.DestoryActivity();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == android.view.KeyEvent.KEYCODE_BACK) {
            if (horizontalScrollView.isopen()) {
                horizontalScrollView.closemenu();

            } else {
                this.finish();
                overridePendingTransition(R.animator.animation_in, R.animator.animation_out);
            }
        }
        return false;
    }

//    public void gethttp() {
//        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(15, TimeUnit.SECONDS).readTimeout(15, TimeUnit.SECONDS).build();
//        Request request = new Request.Builder().get().url("").build();
//        okHttpClient.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//
//            }
//        });
//
//    }

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
