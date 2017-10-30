package com.example.administrator.OurPersion.View.Activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
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
import com.example.administrator.OurPersion.View.Fragment.OldManBuyFragmentOne;
import com.example.administrator.OurPersion.View.Fragment.OldManBuyFragmentThree;
import com.example.administrator.OurPersion.View.Fragment.OldManBuyFragmentTwo;
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

public class OldManBuyActivity extends BaseActivity implements View.OnClickListener {
    MyHorizontalScrollView horizontalScrollView;
    TextView menu_username;
    CircleImageView menu_image;
    TextView oldmanbuyback_menu;
    OldMan.OldManListBean.DatasBean oldManListBean;
    //--老人信息
    CircleImageView oldman_buy_image;
    TextView oldman_buy_name;
    TextView oldman_buy_sex;
    BedOldMan bedOldMan;
    //--老人入住id
    String oldcheckinid;
    List<Fragment> frgamentlist = new ArrayList<>();
    Button oldmanbuy_fragmentone_btn;
    Button oldmanbuy_fragmenttwo_btn;
    Button oldmanbuy_fragmentthree_btn;
    TextView oldmanbuy_title_text;
    AreaOldMan.AreaOldManBean areaOldManBean;
    String checkidold;
    OldManEnterTime oldManEnterTime;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if ((int) msg.obj == 3) {
                Picasso.with(OldManBuyActivity.this).load(OkHttpURL.ImageURL + oldManEnterTime.getOld().getImgPath()).placeholder(R.mipmap.oldone).into(oldman_buy_image);
                oldman_buy_name = (TextView) findViewById(R.id.oldman_buy_name);
                if (TextUtils.isEmpty(oldManEnterTime.getOld().getCustomerName())) {
                    oldman_buy_name.setText("");
                }
                oldman_buy_name.setText(oldManEnterTime.getOld().getCustomerName().toString());
                oldman_buy_sex = (TextView) findViewById(R.id.oldman_buy_sex);
                if (TextUtils.isEmpty(oldManEnterTime.getOld().getSex())) {
                    oldman_buy_sex.setText("");

                } else if (oldManEnterTime.getOld().getSex().equals("0")) {
                    oldman_buy_sex.setText("男");

                } else if (oldManEnterTime.getOld().getSex().equals("1")) {
                    oldman_buy_sex.setText("女");

                }
                oldcheckinid = oldManEnterTime.getId();
                //--设置默认的frgament
                SetDefaultFragment();
            }
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_old_man_buy);
        //--获取老人入住id
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
        frgamentlist.add(new OldManBuyFragmentOne());
        frgamentlist.add(new OldManBuyFragmentTwo());
        frgamentlist.add(new OldManBuyFragmentThree());
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
        horizontalScrollView = (MyHorizontalScrollView) findViewById(R.id.oldmanbuy_scrollview);
        menu_username = (TextView) findViewById(R.id.user_name);
        menu_username.setText(user.getEmployeeName().toString());
        menu_image = (CircleImageView) findViewById(R.id.menu_circleimage);
        Picasso.with(OldManBuyActivity.this).load(OkHttpURL.ImageURL + user.getImgPath()).placeholder(R.mipmap.default_image).into(menu_image);
        oldmanbuyback_menu = (TextView) findViewById(R.id.oldmanbuyback_menu);
        oldmanbuyback_menu.setOnClickListener(this);
        oldman_buy_image = (CircleImageView) findViewById(R.id.oldman_buy_image);
        oldmanbuy_title_text = (TextView) findViewById(R.id.oldmanbuy_title_text);
        oldmanbuy_fragmentone_btn = (Button) findViewById(R.id.oldmanbuy_fragmentone_btn);
        oldmanbuy_fragmentone_btn.setOnClickListener(this);
        oldmanbuy_fragmenttwo_btn = (Button) findViewById(R.id.oldmanbuy_fragmenttwo_btn);
        oldmanbuy_fragmenttwo_btn.setOnClickListener(this);
        oldmanbuy_fragmentthree_btn = (Button) findViewById(R.id.oldmanbuy_fragmentthree_btn);
        oldmanbuy_fragmentthree_btn.setOnClickListener(this);
        if (oldManListBean != null) {
            Picasso.with(OldManBuyActivity.this).load(OkHttpURL.ImageURL + oldManListBean.getImgPath()).placeholder(R.mipmap.oldone).into(oldman_buy_image);
            oldman_buy_name = (TextView) findViewById(R.id.oldman_buy_name);
            if (TextUtils.isEmpty(oldManListBean.getCustomerName())) {
                oldman_buy_name.setText("");
            }
            oldman_buy_name.setText(oldManListBean.getCustomerName().toString());
            oldman_buy_sex = (TextView) findViewById(R.id.oldman_buy_sex);
            if (TextUtils.isEmpty(oldManListBean.getSex())) {
                oldman_buy_sex.setText("");

            } else if (oldManListBean.getSex().equals("0")) {
                oldman_buy_sex.setText("男");

            } else if (oldManListBean.getSex().equals("1")) {
                oldman_buy_sex.setText("女");

            }
            SetDefaultFragment();
        } else if (bedOldMan != null) {
            Picasso.with(OldManBuyActivity.this).load(OkHttpURL.ImageURL + bedOldMan.getOld().getImgPath()).placeholder(R.mipmap.oldone).into(oldman_buy_image);
            oldman_buy_name = (TextView) findViewById(R.id.oldman_buy_name);
            if (TextUtils.isEmpty(bedOldMan.getOld().getCustomerName())) {
                oldman_buy_name.setText("");
            }
            oldman_buy_name.setText(bedOldMan.getOld().getCustomerName().toString());
            oldman_buy_sex = (TextView) findViewById(R.id.oldman_buy_sex);
            if (TextUtils.isEmpty(bedOldMan.getOld().getSex())) {
                oldman_buy_sex.setText("");

            } else if (bedOldMan.getOld().getSex().equals("0")) {
                oldman_buy_sex.setText("男");

            } else if (bedOldMan.getOld().getSex().equals("1")) {
                oldman_buy_sex.setText("女");

            }
            SetDefaultFragment();
        } else if (areaOldManBean != null) {
            Picasso.with(OldManBuyActivity.this).load(OkHttpURL.ImageURL + areaOldManBean.getImgPath()).placeholder(R.mipmap.oldone).into(oldman_buy_image);
            oldman_buy_name = (TextView) findViewById(R.id.oldman_buy_name);
            if (TextUtils.isEmpty(areaOldManBean.getCustomerName())) {
                oldman_buy_name.setText("");
            }
            oldman_buy_name.setText(areaOldManBean.getCustomerName().toString());
            oldman_buy_sex = (TextView) findViewById(R.id.oldman_buy_sex);
            if (TextUtils.isEmpty(areaOldManBean.getSex())) {
                oldman_buy_sex.setText("");

            } else if (areaOldManBean.getSex().equals("0")) {
                oldman_buy_sex.setText("男");

            } else if (areaOldManBean.getSex().equals("1")) {
                oldman_buy_sex.setText("女");

            }
            SetDefaultFragment();
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
        FragmentManager manager = getFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        switch (v.getId()) {
            case R.id.oldmanbuyback_menu:
                this.finish();
                overridePendingTransition(R.animator.animation_in, R.animator.animation_out);
                break;
            //--护理管理
            case R.id.nurseadmin_btn:
                if (horizontalScrollView.isopen()) {
                    AllBedAdminActivity.DestoryActivity();
                    Intent intent = new Intent(OldManBuyActivity.this, NurseAdminActivity.class);
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
                    Intent intent = new Intent(OldManBuyActivity.this, OldManListActivity.class);
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
                    Intent intent = new Intent(OldManBuyActivity.this, StaffAdminActivity.class);
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
                    Intent intent = new Intent(OldManBuyActivity.this, BedAdminActivity.class);
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
                    Intent intent = new Intent(OldManBuyActivity.this, MessageActivity.class);
                    startActivity(intent);
                    this.finish();
                    AllOldManActivity.DestoryActivity();
                    AllFirstMainActivity.DestoryActivity();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            case R.id.oldmanbuy_fragmentone_btn:
                oldmanbuy_title_text.setText("月费记录");
                if (frgamentlist.get(1).isAdded()) {
                    fragmentTransaction.hide(frgamentlist.get(1));

                }
                if (frgamentlist.get(2).isAdded()) {
                    fragmentTransaction.hide(frgamentlist.get(2));

                }
                fragmentTransaction.show(frgamentlist.get(0));
                fragmentTransaction.commit();
                SetButtonImage(getResources().getDrawable(R.mipmap.yuefeitwo), oldmanbuy_fragmentone_btn);
                oldmanbuy_fragmentone_btn.setTextColor(0xf01874CD);
                oldmanbuy_fragmenttwo_btn.setTextColor(Color.BLACK);
                SetButtonImage(getResources().getDrawable(R.mipmap.yiliaoone), oldmanbuy_fragmenttwo_btn);
                oldmanbuy_fragmentthree_btn.setTextColor(Color.BLACK);
                SetButtonImage(getResources().getDrawable(R.mipmap.zafeione), oldmanbuy_fragmentthree_btn);
                break;
            case R.id.oldmanbuy_fragmenttwo_btn:
                oldmanbuy_title_text.setText("备用金变更");
                if (frgamentlist.get(0).isAdded()) {
                    fragmentTransaction.hide(frgamentlist.get(0));

                }
                if (frgamentlist.get(2).isAdded()) {
                    fragmentTransaction.hide(frgamentlist.get(2));

                }
                if (frgamentlist.get(1).isAdded()) {

                    fragmentTransaction.show(frgamentlist.get(1));
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putString("checkid", oldcheckinid);
                    frgamentlist.get(1).setArguments(bundle);
                    fragmentTransaction.add(R.id.oldman_buy_frgament, frgamentlist.get(1));
                }
                fragmentTransaction.commit();
                SetButtonImage(getResources().getDrawable(R.mipmap.yiliaoone), oldmanbuy_fragmentone_btn);
                oldmanbuy_fragmentone_btn.setTextColor(Color.BLACK);
                oldmanbuy_fragmenttwo_btn.setTextColor(0xf01874CD);
                SetButtonImage(getResources().getDrawable(R.mipmap.yiliaotwo), oldmanbuy_fragmenttwo_btn);
                oldmanbuy_fragmentthree_btn.setTextColor(Color.BLACK);
                SetButtonImage(getResources().getDrawable(R.mipmap.zafeione), oldmanbuy_fragmentthree_btn);
                break;
            case R.id.oldmanbuy_fragmentthree_btn:
                oldmanbuy_title_text.setText("杂费记录");
                if (frgamentlist.get(0).isAdded()) {
                    fragmentTransaction.hide(frgamentlist.get(0));

                }
                if (frgamentlist.get(1).isAdded()) {
                    fragmentTransaction.hide(frgamentlist.get(1));

                }
                if (frgamentlist.get(2).isAdded()) {

                    fragmentTransaction.show(frgamentlist.get(2));
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putString("checkid", oldcheckinid);
                    frgamentlist.get(2).setArguments(bundle);
                    fragmentTransaction.add(R.id.oldman_buy_frgament, frgamentlist.get(2));
                }
                fragmentTransaction.commit();
                SetButtonImage(getResources().getDrawable(R.mipmap.yiliaoone), oldmanbuy_fragmentone_btn);
                oldmanbuy_fragmentone_btn.setTextColor(Color.BLACK);
                oldmanbuy_fragmenttwo_btn.setTextColor(Color.BLACK);
                SetButtonImage(getResources().getDrawable(R.mipmap.yiliaoone), oldmanbuy_fragmenttwo_btn);
                oldmanbuy_fragmentthree_btn.setTextColor(0xf01874CD);
                SetButtonImage(getResources().getDrawable(R.mipmap.zafeitwo), oldmanbuy_fragmentthree_btn);
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


    public void SetDefaultFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("checkid", oldcheckinid);
        frgamentlist.get(0).setArguments(bundle);
        FragmentManager manager = getFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.add(R.id.oldman_buy_frgament, frgamentlist.get(0));
        fragmentTransaction.commit();
        SetButtonImage(getResources().getDrawable(R.mipmap.yuefeitwo), oldmanbuy_fragmentone_btn);
        oldmanbuy_fragmentone_btn.setTextColor(0xf01874CD);
        oldmanbuy_title_text.setText("月费记录");

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
