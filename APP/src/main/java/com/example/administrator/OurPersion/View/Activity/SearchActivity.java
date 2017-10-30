package com.example.administrator.OurPersion.View.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.OurPersion.Application.AllBedAdminActivity;
import com.example.administrator.OurPersion.Model.Bean.Bed;
import com.example.administrator.OurPersion.Model.Bean.BedOldMan;
import com.example.administrator.OurPersion.Model.Bean.OkHttpURL;
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

public class SearchActivity extends BaseActivity implements View.OnClickListener {
    TextView search_title_text;
    //床位信息
    TextView search_bedno;
    TextView search_bedprice;
    TextView searchview_bedtype;
    TextView serachview_location;
    TextView searchview_state;
    TextView searchview_roomtype;
    CircleImageView search_bedmessage_image;
    //--老人信息
    LinearLayout searchview_oldmanlayout;
    RelativeLayout search_oldmanrl;
    CircleImageView bed_oldman_image;
    TextView bedoldman_name;
    TextView bedoldman_sex;
    TextView bedoldman_age;
    TextView bedoldman_entertime;
    TextView bedolman_days;
    //--根据床位获取到老人对象
    BedOldMan bedOldMan;
    //--菜单头像和名字
    CircleImageView menu_image;
    TextView menu_username;
    MyHorizontalScrollView horizontalScrollView;
    SearchView searchView;
    Button searchback_menu;
    //--床位列表传递过来的床位信息
    Bed.UnitBean.UnitsBean.FloorsBean.RoomsBean.BedsBean bedsBean;
    //--单元，楼层，房间，房间类型
    String unitname;
    String floorname;
    String roomname;
    String roomtype;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if ((int) msg.obj == 1) {
                if (bedOldMan != null) {
                    searchview_oldmanlayout.setVisibility(View.VISIBLE);
                    if (bedOldMan.getOld().getImgPath() != null) {
                        Glide.with(SearchActivity.this).load(OkHttpURL.ImageURL + bedOldMan.getOld().getImgPath().toString()).fitCenter().into(bed_oldman_image);
                    }
                    bedoldman_name.setText(bedOldMan.getOld().getCustomerName());
                    if (bedOldMan.getOld().getSex().equals("0")) {
                        bedoldman_sex.setText("男");

                    } else if (bedOldMan.getOld().getSex().equals("1")) {

                        bedoldman_sex.setText("女");
                    }
                    if (bedOldMan.getOld().getBirthday() != null) {
                        bedoldman_age.setText(bedOldMan.getOld().getBirthday().toString());

                    }
                    if (!TextUtils.isEmpty(bedOldMan.getCheckinTime())) {
                        bedoldman_entertime.setText(bedOldMan.getCheckinTime());
                    }
                    if (!TextUtils.isEmpty(bedOldMan.getPaymentMonth())) {
                        bedolman_days.setText(bedOldMan.getPaymentMonth());
                    }


                }
                search_oldmanrl.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(SearchActivity.this, OldManAdminActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("bedOldMan", bedOldMan);
                        intent.putExtras(bundle);
                        startActivity(intent);
                        overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                    }
                });
            } else if ((int) msg.obj == 2) {
                searchview_oldmanlayout.setVisibility(View.GONE);


            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        bedsBean = (Bed.UnitBean.UnitsBean.FloorsBean.RoomsBean.BedsBean) getIntent().getSerializableExtra("bedbean");
        unitname = getIntent().getStringExtra("unitname");
        floorname = getIntent().getStringExtra("floorname");
        roomname = getIntent().getStringExtra("roomname");
        roomtype = getIntent().getStringExtra("roomtype");
        AllBedAdminActivity.AddActivity(SearchActivity.this);
        SetZTL();
        initview();
        SearchViewOnClick();
    }

    public void initview() {
        search_title_text = (TextView) findViewById(R.id.search_title_text);
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
        horizontalScrollView = (MyHorizontalScrollView) findViewById(R.id.search_scrollview);
        searchView = (SearchView) findViewById(R.id.bedadmin_search);
        searchView.setSubmitButtonEnabled(true);
        searchback_menu = (Button) findViewById(R.id.searchback_menu);
        searchback_menu.setOnClickListener(this);
        menu_username = (TextView) findViewById(R.id.user_name);
        menu_username.setText(user.getEmployeeName().toString());
        menu_image = (CircleImageView) findViewById(R.id.menu_circleimage);
        Picasso.with(SearchActivity.this).load(OkHttpURL.ImageURL + user.getImgPath()).placeholder(R.mipmap.default_image).into(menu_image);
        search_bedno = (TextView) findViewById(R.id.search_bedno);
        search_bedprice = (TextView) findViewById(R.id.search_bedprice);
        searchview_bedtype = (TextView) findViewById(R.id.searchview_bedtype);
        serachview_location = (TextView) findViewById(R.id.serachview_location);
        searchview_state = (TextView) findViewById(R.id.searchview_state);
        searchview_roomtype = (TextView) findViewById(R.id.searchview_roomtype);
        searchview_oldmanlayout = (LinearLayout) findViewById(R.id.searchview_oldmanlayout);
        searchview_oldmanlayout.setVisibility(View.GONE);
        bed_oldman_image = (CircleImageView) findViewById(R.id.bed_oldman_image);
        bedoldman_name = (TextView) findViewById(R.id.bedoldman_name);
        bedoldman_sex = (TextView) findViewById(R.id.bedoldman_sex);
        bedoldman_age = (TextView) findViewById(R.id.bedoldman_age);
        bedoldman_entertime = (TextView) findViewById(R.id.bedoldman_entertime);
        bedolman_days = (TextView) findViewById(R.id.bedolman_days);
        search_oldmanrl = (RelativeLayout) findViewById(R.id.search_oldmanrl);
        search_bedmessage_image = (CircleImageView) findViewById(R.id.search_bedmessage_image);
        if (bedsBean != null) {
            search_title_text.setText("床位信息");
            searchView.setVisibility(View.GONE);
            search_bedno.setText(bedsBean.getBedNo().toString().trim());
            search_bedprice.setText("￥" + bedsBean.getMoney() + "/月");
            searchview_bedtype.setText(bedsBean.getBedType());
            if (bedsBean.getBedState().equals("0")) {
                search_bedmessage_image.setImageResource(R.mipmap.search_bedmessage_kongxian);
                searchview_state.setText("空闲");
            } else if (bedsBean.getBedState().equals("1")) {
                search_bedmessage_image.setImageResource(R.mipmap.search_bedmessage_update);
                searchview_state.setText("维修");
            } else if (bedsBean.getBedState().equals("3")) {
                search_bedmessage_image.setImageResource(R.mipmap.search_bedmessage_ruzhu);
                searchview_state.setText("入住中");

            } else if (bedsBean.getBedState().equals("4") || bedsBean.getBedState().equals("5")) {
                search_bedmessage_image.setImageResource(R.mipmap.search_bedmessage_yuyue);
                searchview_state.setText("预约");
            } else if (bedsBean.getBedState().equals("2")) {
                search_bedmessage_image.setImageResource(R.mipmap.search_bedmessage_dengji);
                searchview_state.setText("入住登记中");
            }
            if (bedsBean.getBedState().equals("3")) {
                searchview_oldmanlayout.setVisibility(View.VISIBLE);
                GetOldManData();
            } else {
                searchview_oldmanlayout.setVisibility(View.GONE);

            }
        }
        if (!TextUtils.isEmpty(unitname) && !TextUtils.isEmpty(floorname)) {
            serachview_location.setText(getIntent().getStringExtra("unitname").toString() + getIntent().getStringExtra("floorname").toString() + getIntent().getStringExtra("roomname").toString() + bedsBean.getBedName());
            searchview_roomtype.setText(getIntent().getStringExtra("roomtype").toString());

        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (horizontalScrollView.isopen()) {
                horizontalScrollView.closemenu();

            } else {
                SearchActivity.this.finish();
                overridePendingTransition(R.animator.animation_in, R.animator.animation_out);
            }
        }
        return false;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.searchback_menu:
                SearchActivity.this.finish();
                overridePendingTransition(R.animator.animation_in, R.animator.animation_out);
                break;
            //--护理管理
            case R.id.nurseadmin_btn:
                if (horizontalScrollView.isopen()) {
                    Intent intent = new Intent(SearchActivity.this, NurseAdminActivity.class);
                    startActivity(intent);
                    this.finish();
                    AllBedAdminActivity.DestoryActivity();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;

            //--老人管理
            case R.id.oldmanadmin_btn:
                if (horizontalScrollView.isopen()) {
                    Intent intent = new Intent(SearchActivity.this, OldManListActivity.class);
                    startActivity(intent);
                    this.finish();
                    AllBedAdminActivity.DestoryActivity();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            //--员工
            case R.id.staffadmin_btn:
                if (horizontalScrollView.isopen()) {
                    Intent intent = new Intent(SearchActivity.this, StaffAdminActivity.class);
                    startActivity(intent);
                    this.finish();
                    AllBedAdminActivity.DestoryActivity();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;

            case R.id.messagesend_btn:
                if (horizontalScrollView.isopen()) {
                    Intent intent = new Intent(SearchActivity.this, MessageActivity.class);
                    startActivity(intent);
                    this.finish();
                    AllBedAdminActivity.DestoryActivity();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            //--床位
            case R.id.bedadmin_btn:
                if (horizontalScrollView.isopen()) {
                    horizontalScrollView.closemenu();
                }
                break;

        }

    }

    public void GetOldManData() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(15, TimeUnit.SECONDS).writeTimeout(15, TimeUnit.SECONDS).build();
        final Request request = new Request.Builder().get().url("http://192.168.10.7:7006/api/Customer/GetCheckInByBedId?BedId=" + bedsBean.getId()).build();
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
                result = result.replace("\\", "").toString().trim();
                result = result.substring(1, result.length());
                result = result.substring(0, result.length() - 1);
                Gson gson = new Gson();
                bedOldMan = gson.fromJson(result, BedOldMan.class);
                Message message = new Message();
                message.obj = 1;
                handler.sendMessage(message);
            }
        });

    }

    @Override
    protected void onStop() {
        super.onStop();
        if (horizontalScrollView.isopen()) {
            horizontalScrollView.closemenu();

        }
    }

    public void SearchViewOnClick() {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

    }
}
