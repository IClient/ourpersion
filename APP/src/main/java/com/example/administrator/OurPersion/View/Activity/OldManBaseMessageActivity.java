package com.example.administrator.OurPersion.View.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
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

public class OldManBaseMessageActivity extends BaseActivity implements View.OnClickListener {
    MyHorizontalScrollView horizontalScrollView;
    TextView menu_username;
    CircleImageView menu_image;
    TextView oldmanadminbasemessageback_menu;
    CircleImageView oldman_basemessage_image;
    OldMan.OldManListBean.DatasBean oldManListBean;
    BedOldMan bedOldMan;
    AreaOldMan.AreaOldManBean areaOldManBean;
    //老人姓名,性别，生日，地址，电话，入住状态，入住时间等信息
    TextView oldman_basemessage_name;
    TextView oldman_basemessage_sex;
    TextView oldman_basemessage_birthday;
    TextView oldman_basemessage_address;
    TextView oldman_basemessage_phone;
    TextView oldman_basemessage_state;
    TextView oldman_basemessage_entertime;
    TextView oldman_basemessage_daoqitime;
    TextView oldman_basemessage_yuefeitime;
    TextView oldman_basemessage_position;
    OldManEnterTime oldManEnterTime;
    String checkidold;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if ((int) msg.obj == 1) {
//                if (oldManEnterTime.getStatus().equals("0")) {
//
//                    oldman_basemessage_state.setText("入住登记中");
//                } else if (oldManEnterTime.getStatus().equals("1")) {
                    oldman_basemessage_state.setText("入住");

//                } else if (oldManEnterTime.getStatus().equals("2")) {
//                    oldman_basemessage_state.setText("退住");
//
//                }
                if (TextUtils.isEmpty(oldManEnterTime.getCheckinTime())) {
                    oldman_basemessage_entertime.setText("");
                } else {
                    oldman_basemessage_entertime.setText(oldManEnterTime.getCheckinTime().toString());
                }
                if (oldManEnterTime.getExpireTime() == null) {
                    oldman_basemessage_daoqitime.setText("");
                } else {
                    oldman_basemessage_daoqitime.setText(oldManEnterTime.getExpireTime().toString());
                }

                if (oldManEnterTime.getPositionName() == null) {
                    oldman_basemessage_position.setText("");
                } else {
                    oldman_basemessage_position.setText(oldManEnterTime.getPositionName().toString().trim());
                }
                oldman_basemessage_yuefeitime.setText("￥" + oldManEnterTime.getMoney());
                //--推送获取老人基本信息
                if (!TextUtils.isEmpty(checkidold)) {
                    oldman_basemessage_name.setText(oldManEnterTime.getOld().getCustomerName().toString());
                    if (oldManEnterTime.getOld().getSex().equals("0")) {
                        oldman_basemessage_sex.setText("男");
                    } else if (oldManEnterTime.getOld().getSex().equals("1")) {
                        oldman_basemessage_sex.setText("女");

                    }
                    if (TextUtils.isEmpty(oldManEnterTime.getOld().getBirthday())) {
                        oldman_basemessage_birthday.setText("");
                    } else {
                        oldman_basemessage_birthday.setText(oldManEnterTime.getOld().getBirthday().toString());
                    }
                    if (isnull(oldManEnterTime.getOld().getAddress())) {

                        oldman_basemessage_address.setText("");
                    } else {
                        oldman_basemessage_address.setText(oldManEnterTime.getOld().getAddress().toString());
                    }

                    if (TextUtils.isEmpty(oldManEnterTime.getOld().getPhoneNumber())) {

                        oldman_basemessage_phone.setText("");
                    } else {
                        oldman_basemessage_phone.setText(oldManEnterTime.getOld().getPhoneNumber().toString());

                    }
                    Picasso.with(OldManBaseMessageActivity.this).load(OkHttpURL.ImageURL + oldManEnterTime.getOld().getImgPath()).placeholder(R.mipmap.oldone).into(oldman_basemessage_image);

                }

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_old_man_base_message);
        bedOldMan = (BedOldMan) getIntent().getSerializableExtra("oldman");
        oldManListBean = (OldMan.OldManListBean.DatasBean) getIntent().getSerializableExtra("oldManListBean");
        areaOldManBean = (AreaOldMan.AreaOldManBean) getIntent().getSerializableExtra("firstmainoldman");
        checkidold = (String) getIntent().getSerializableExtra("checkidold");
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
        horizontalScrollView = (MyHorizontalScrollView) findViewById(R.id.oldmanadminbasemessage_scrollview);
        menu_username = (TextView) findViewById(R.id.user_name);
        menu_username.setText(user.getEmployeeName().toString());
        menu_image = (CircleImageView) findViewById(R.id.menu_circleimage);
        Picasso.with(OldManBaseMessageActivity.this).load(OkHttpURL.ImageURL + user.getImgPath()).placeholder(R.mipmap.default_image).into(menu_image);
        oldmanadminbasemessageback_menu = (TextView) findViewById(R.id.oldmanadminbasemessageback_menu);
        oldmanadminbasemessageback_menu.setOnClickListener(this);
        OldManBaseMessageInit();
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
        return false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.oldmanadminbasemessageback_menu:
                this.finish();
                overridePendingTransition(R.animator.animation_in, R.animator.animation_out);
                break;
            //--护理管理
            case R.id.nurseadmin_btn:
                if (horizontalScrollView.isopen()) {
                    Intent intent = new Intent(OldManBaseMessageActivity.this, NurseAdminActivity.class);
                    startActivity(intent);
                    this.finish();
                    AllOldManActivity.DestoryActivity();
                    AllBedAdminActivity.DestoryActivity();
                    AllFirstMainActivity.DestoryActivity();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;

            //--老人管理
            case R.id.oldmanadmin_btn:
                if (horizontalScrollView.isopen()) {
                    Intent intent = new Intent(OldManBaseMessageActivity.this, OldManListActivity.class);
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
                    Intent intent = new Intent(OldManBaseMessageActivity.this, StaffAdminActivity.class);
                    startActivity(intent);
                    this.finish();
                    AllBedAdminActivity.DestoryActivity();
                    AllOldManActivity.DestoryActivity();
                    AllFirstMainActivity.DestoryActivity();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            //--床位
            case R.id.bedadmin_btn:
                if (horizontalScrollView.isopen()) {
                    AllBedAdminActivity.DestoryActivity();
                    Intent intent = new Intent(OldManBaseMessageActivity.this, BedAdminActivity.class);
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
                    Intent intent = new Intent(OldManBaseMessageActivity.this, MessageActivity.class);
                    startActivity(intent);
                    this.finish();
                    AllOldManActivity.DestoryActivity();
                    AllFirstMainActivity.DestoryActivity();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
        }

    }

    public void OldManBaseMessageInit() {
        oldman_basemessage_entertime = (TextView) findViewById(R.id.oldman_basemessage_entertime);
        oldman_basemessage_daoqitime = (TextView) findViewById(R.id.oldman_basemessage_daoqitime);
        oldman_basemessage_yuefeitime = (TextView) findViewById(R.id.oldman_basemessage_yuefeitime);
        oldman_basemessage_name = (TextView) findViewById(R.id.oldman_basemessage_name);
        oldman_basemessage_sex = (TextView) findViewById(R.id.oldman_basemessage_sex);
        oldman_basemessage_birthday = (TextView) findViewById(R.id.oldman_basemessage_birthday);
        oldman_basemessage_phone = (TextView) findViewById(R.id.oldman_basemessage_phone);
        oldman_basemessage_address = (TextView) findViewById(R.id.oldman_basemessage_address);
        oldman_basemessage_state = (TextView) findViewById(R.id.oldman_basemessage_state);
        oldman_basemessage_image = (CircleImageView) findViewById(R.id.oldman_basemessage_image);
        oldman_basemessage_position = (TextView) findViewById(R.id.oldman_basemessage_position);
        //老人列表传递过来的
        if (oldManListBean != null) {
            oldman_basemessage_name.setText(oldManListBean.getCustomerName().toString());
            if (oldManListBean.getSex().equals("0")) {
                oldman_basemessage_sex.setText("男");
            } else if (oldManListBean.getSex().equals("1")) {
                oldman_basemessage_sex.setText("女");

            }
            if (TextUtils.isEmpty(oldManListBean.getBirthday())) {
                oldman_basemessage_birthday.setText("");
            } else {
                oldman_basemessage_birthday.setText(oldManListBean.getBirthday().toString());
            }
            if (isnull(oldManListBean.getAddress())) {

                oldman_basemessage_address.setText("");
            } else {
                oldman_basemessage_address.setText(oldManListBean.getAddress().toString());
            }

            if (TextUtils.isEmpty(oldManListBean.getPhoneNumber())) {

                oldman_basemessage_phone.setText("");
            } else {
                oldman_basemessage_phone.setText(oldManListBean.getPhoneNumber().toString());

            }
            Picasso.with(OldManBaseMessageActivity.this).load(OkHttpURL.ImageURL + oldManListBean.getImgPath()).placeholder(R.mipmap.oldone).into(oldman_basemessage_image);
            //--获取老人入住信息
            GetOldManEnterMessage(oldManListBean.getId());
        }
        //--床位搜索传递过来的有入住信息所以不需要再次请求网络
        else if (bedOldMan != null) {
            oldman_basemessage_name.setText(bedOldMan.getOld().getCustomerName());
            if (bedOldMan.getOld().getSex().equals("0")) {

                oldman_basemessage_sex.setText("男");
            } else if (bedOldMan.getOld().getSex().equals("1")) {
                oldman_basemessage_sex.setText("女");
            }
            if (bedOldMan.getOld().getBirthday() == null) {
                oldman_basemessage_birthday.setText("");
            } else {
                oldman_basemessage_birthday.setText(bedOldMan.getOld().getBirthday().toString());
            }
            if (bedOldMan.getOld().getAddress() == null) {

                oldman_basemessage_address.setText("");
            } else {
                oldman_basemessage_address.setText(bedOldMan.getOld().getAddress().toString());
            }

            if (TextUtils.isEmpty(bedOldMan.getOld().getPhoneNumber())) {

                oldman_basemessage_phone.setText("");
            } else {
                oldman_basemessage_phone.setText(bedOldMan.getOld().getPhoneNumber().toString());

            }
//            if (bedOldMan.getOld().getStatus().equals("0")) {
//
//                oldman_basemessage_state.setText("入住登记中");
//            } else if (bedOldMan.getOld().getStatus().equals("1")) {
                oldman_basemessage_state.setText("入住");

//            } else if (bedOldMan.getOld().getStatus().equals("2")) {
//                oldman_basemessage_state.setText("退住");
//
//            }
            Picasso.with(OldManBaseMessageActivity.this).load(OkHttpURL.ImageURL + bedOldMan.getOld().getImgPath()).placeholder(R.mipmap.oldone).into(oldman_basemessage_image);
            if (TextUtils.isEmpty(bedOldMan.getCheckinTime())) {
                oldman_basemessage_entertime.setText("");
            } else {
                oldman_basemessage_entertime.setText(bedOldMan.getCheckinTime().toString());
            }
            if (TextUtils.isEmpty(bedOldMan.getExpireTime())) {

                oldman_basemessage_daoqitime.setText("");
            } else {
                oldman_basemessage_daoqitime.setText(bedOldMan.getExpireTime().toString());
            }
            if (TextUtils.isEmpty(bedOldMan.getPositionName())) {

                oldman_basemessage_position.setText("");
            } else {
                oldman_basemessage_position.setText(bedOldMan.getPositionName().toString().trim());
            }

            oldman_basemessage_yuefeitime.setText("￥" + bedOldMan.getMoney());

        } else if (areaOldManBean != null) {
            oldman_basemessage_name.setText(areaOldManBean.getCustomerName());
            if (areaOldManBean.getSex().equals("0")) {

                oldman_basemessage_sex.setText("男");
            } else if (areaOldManBean.getSex().equals("1")) {
                oldman_basemessage_sex.setText("女");
            }
            if (areaOldManBean.getBirthday() == null) {
                oldman_basemessage_birthday.setText("");
            } else {
                oldman_basemessage_birthday.setText(areaOldManBean.getBirthday().toString());
            }
            if (areaOldManBean.getAddress() == null) {

                oldman_basemessage_address.setText("");
            } else {
                oldman_basemessage_address.setText(areaOldManBean.getAddress().toString());
            }

            if (TextUtils.isEmpty(areaOldManBean.getPhoneNumber())) {

                oldman_basemessage_phone.setText("");
            } else {
                oldman_basemessage_phone.setText(areaOldManBean.getPhoneNumber().toString());

            }
            GetOldManEnterMessage(areaOldManBean.getOlderId());


        } else if (!TextUtils.isEmpty(checkidold)) {
            try {
                JSONObject jsonObject = new JSONObject(checkidold);
                String oldid = jsonObject.getString("option1");
                GetOldManEnterMessage(oldid);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }


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
                message.obj = 1;
                handler.sendMessage(message);
            }
        });


    }
}
