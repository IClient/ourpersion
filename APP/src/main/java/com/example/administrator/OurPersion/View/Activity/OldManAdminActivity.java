package com.example.administrator.OurPersion.View.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.OurPersion.Application.AllBedAdminActivity;
import com.example.administrator.OurPersion.Application.AllFirstMainActivity;
import com.example.administrator.OurPersion.Application.AllOldManActivity;
import com.example.administrator.OurPersion.Model.Bean.AreaOldMan;
import com.example.administrator.OurPersion.Model.Bean.BedOldMan;
import com.example.administrator.OurPersion.Model.Bean.OkHttpURL;
import com.example.administrator.OurPersion.Model.Bean.OldMan;
import com.example.administrator.OurPersion.SelfView.CircleImageView;
import com.example.administrator.OurPersion.R;
import com.example.administrator.OurPersion.SelfView.MyHorizontalScrollView;
import com.squareup.picasso.Picasso;


public class OldManAdminActivity extends BaseActivity implements View.OnClickListener {
    MyHorizontalScrollView myHorizontalScrollView;
    //--菜单用户名字
    TextView textView;
    CircleImageView menu_image;
    TextView oldmanadminback_menu;
    //--基本信息
    TextView jibenxinx;
    //--家属信息
    TextView jiashuxinxi;
    //--健康信息
    TextView jiankangxinxi;
    //--体征数据
    TextView tizhengshuju;
    //--护理计划
    TextView hulijihua;
    //--餐饮计划
    TextView canyjihua;
    //--外出管理
    TextView outadmin;
    //--事故记录
    TextView shigujilu;
    //--消费记录
    TextView xiaofeijilu;
    OldMan.OldManListBean.DatasBean oldManListBean;
    BedOldMan bedOldMan;
    AreaOldMan.AreaOldManBean areaOldManBean;
    String checkidold;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_old_people_admin);
        AllOldManActivity.AddActivity(OldManAdminActivity.this);
        //--床位传递过来
        bedOldMan = (BedOldMan) getIntent().getSerializableExtra("bedOldMan");
        //--老人管理
        oldManListBean = (OldMan.OldManListBean.DatasBean) getIntent().getSerializableExtra("OldManListBean");
        //--护理首页
        areaOldManBean = (AreaOldMan.AreaOldManBean) getIntent().getSerializableExtra("firstmainoldman");
        checkidold = (String) getIntent().getSerializableExtra("checkidold");
        //初始化控件
        initview();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //--护理管理
            case R.id.nurseadmin_btn:
                if (myHorizontalScrollView.isopen()) {
                    AllBedAdminActivity.DestoryActivity();
                    AllOldManActivity.DestoryActivity();
                    AllFirstMainActivity.DestoryActivity();
                    Intent intent = new Intent(OldManAdminActivity.this, NurseAdminActivity.class);
                    startActivity(intent);
                    this.finish();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;

            //--老人管理
            case R.id.oldmanadmin_btn:
                if (myHorizontalScrollView.isopen()) {
                    Intent intent = new Intent(OldManAdminActivity.this, OldManListActivity.class);
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
                if (myHorizontalScrollView.isopen()) {
                    AllBedAdminActivity.DestoryActivity();
                    AllOldManActivity.DestoryActivity();
                    AllFirstMainActivity.DestoryActivity();
                    Intent intent = new Intent(OldManAdminActivity.this, StaffAdminActivity.class);
                    startActivity(intent);
                    this.finish();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            //--床位
            case R.id.bedadmin_btn:
                if (myHorizontalScrollView.isopen()) {
                    AllBedAdminActivity.DestoryActivity();
                    AllOldManActivity.DestoryActivity();
                    AllFirstMainActivity.DestoryActivity();
                    Intent intent = new Intent(OldManAdminActivity.this, BedAdminActivity.class);
                    startActivity(intent);
                    this.finish();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            case R.id.messagesend_btn:
                if (myHorizontalScrollView.isopen()) {
                    AllBedAdminActivity.DestoryActivity();
                    AllOldManActivity.DestoryActivity();
                    AllFirstMainActivity.DestoryActivity();
                    Intent intent = new Intent(OldManAdminActivity.this, MessageActivity.class);
                    startActivity(intent);
                    this.finish();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            //--打开菜单
            case R.id.oldmanadminback_menu:
                this.finish();
                overridePendingTransition(R.animator.animation_in, R.animator.animation_out);
                break;
            //--老人管理——基本信息
            case R.id.jibenxinx:
                if (!myHorizontalScrollView.isopen()) {
                    Intent intent = new Intent(OldManAdminActivity.this, OldManBaseMessageActivity.class);
                    Bundle bundle = new Bundle();
                    if (oldManListBean != null) {
                        bundle.putSerializable("oldManListBean", oldManListBean);
                    } else if (bedOldMan != null) {
                        bundle.putSerializable("oldman", bedOldMan);

                    } else if (areaOldManBean != null) {
                        bundle.putSerializable("firstmainoldman", areaOldManBean);
                    } else {
                        bundle.putSerializable("checkidold", checkidold);
                    }
                    intent.putExtras(bundle);
                    startActivity(intent);
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            //--老人管理——家属信息
            case R.id.jiashuxinxi:
                if (!myHorizontalScrollView.isopen()) {
                    Intent intent = new Intent(OldManAdminActivity.this, OldManFamilyMessageActivity.class);
                    Bundle bundle = new Bundle();
                    if (oldManListBean != null) {
                        bundle.putSerializable("oldManListBean", oldManListBean);
                    } else if (bedOldMan != null) {
                        bundle.putSerializable("oldman", bedOldMan);

                    } else if (areaOldManBean != null) {
                        bundle.putSerializable("firstmainoldman", areaOldManBean);
                    } else {
                        bundle.putSerializable("checkidold", checkidold);
                    }
                    intent.putExtras(bundle);
                    startActivity(intent);
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            //--老人管理——健康信息
            case R.id.jiankangxinxi:
                if (!myHorizontalScrollView.isopen()) {
                    Intent intent = new Intent(OldManAdminActivity.this, OldManHealthMessageActivity.class);
                    Bundle bundle = new Bundle();
                    if (oldManListBean != null) {
                        bundle.putSerializable("oldManListBean", oldManListBean);
                    } else if (bedOldMan != null) {
                        bundle.putSerializable("oldman", bedOldMan);

                    } else if (areaOldManBean != null) {
                        bundle.putSerializable("firstmainoldman", areaOldManBean);
                    } else {
                        bundle.putSerializable("checkidold", checkidold);
                    }
                    intent.putExtras(bundle);
                    startActivity(intent);
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            //--老人管理——体征数据
            case R.id.tizhengshuju:
                if (!myHorizontalScrollView.isopen()) {
                    Intent intent = new Intent(OldManAdminActivity.this, OldManExaminationDataActivity.class);
                    Bundle bundle = new Bundle();
                    if (oldManListBean != null) {
                        bundle.putSerializable("oldManListBean", oldManListBean);
                    } else if (bedOldMan != null) {
                        bundle.putSerializable("oldman", bedOldMan);

                    } else if (areaOldManBean != null) {
                        bundle.putSerializable("firstmainoldman", areaOldManBean);
                    } else {
                        bundle.putSerializable("checkidold", checkidold);
                    }
                    intent.putExtras(bundle);
                    startActivity(intent);
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            //--老人管理——护理计划
            case R.id.hulijihua:
                if (!myHorizontalScrollView.isopen()) {
                    Intent intent = new Intent(OldManAdminActivity.this, OldManNurseProjectActivity.class);
                    Bundle bundle = new Bundle();
                    if (oldManListBean != null) {
                        bundle.putSerializable("oldManListBean", oldManListBean);
                    } else if (bedOldMan != null) {
                        bundle.putSerializable("oldman", bedOldMan);

                    } else if (areaOldManBean != null) {
                        bundle.putSerializable("firstmainoldman", areaOldManBean);
                    } else {
                        bundle.putSerializable("checkidold", checkidold);
                    }
                    intent.putExtras(bundle);
                    startActivity(intent);
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            //--老人管理——餐饮计划
            case R.id.canyinjihua:
                if (!myHorizontalScrollView.isopen()) {
                    Intent intent = new Intent(OldManAdminActivity.this, OldManCateringActivity.class);
                    Bundle bundle = new Bundle();
                    if (oldManListBean != null) {
                        bundle.putSerializable("oldManListBean", oldManListBean);
                    } else if (bedOldMan != null) {
                        bundle.putSerializable("oldman", bedOldMan);

                    } else if (areaOldManBean != null) {
                        bundle.putSerializable("firstmainoldman", areaOldManBean);
                    } else {
                        bundle.putSerializable("checkidold", checkidold);
                    }
                    intent.putExtras(bundle);
                    startActivity(intent);
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            //--老人管理——外出管理
            case R.id.outadmin:
                if (!myHorizontalScrollView.isopen()) {
                    Intent intent = new Intent(OldManAdminActivity.this, OldManOutActivity.class);
                    Bundle bundle = new Bundle();
                    if (oldManListBean != null) {
                        bundle.putSerializable("oldManListBean", oldManListBean);
                    } else if (bedOldMan != null) {
                        bundle.putSerializable("oldman", bedOldMan);

                    } else if (areaOldManBean != null) {
                        bundle.putSerializable("firstmainoldman", areaOldManBean);
                    } else {
                        bundle.putSerializable("checkidold", checkidold);
                    }
                    intent.putExtras(bundle);
                    startActivity(intent);
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            //--老人管理——事故记录
            case R.id.shigujilu:
                if (!myHorizontalScrollView.isopen()) {
                    Intent intent = new Intent(OldManAdminActivity.this, OldManTrouableActivity.class);
                    Bundle bundle = new Bundle();
                    if (oldManListBean != null) {
                        bundle.putSerializable("oldManListBean", oldManListBean);
                    } else if (bedOldMan != null) {
                        bundle.putSerializable("oldman", bedOldMan);

                    } else if (areaOldManBean != null) {
                        bundle.putSerializable("firstmainoldman", areaOldManBean);
                    } else {
                        bundle.putSerializable("checkidold", checkidold);
                    }
                    intent.putExtras(bundle);
                    startActivity(intent);
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            //--老人管理——消费记录
            case R.id.xiaofeijilu:
                if (!myHorizontalScrollView.isopen()) {
                    Intent intent = new Intent(OldManAdminActivity.this, OldManBuyActivity.class);
                    Bundle bundle = new Bundle();
                    if (oldManListBean != null) {
                        bundle.putSerializable("oldManListBean", oldManListBean);
                    } else if (bedOldMan != null) {
                        bundle.putSerializable("oldman", bedOldMan);

                    } else if (areaOldManBean != null) {
                        bundle.putSerializable("firstmainoldman", areaOldManBean);
                    } else {
                        bundle.putSerializable("checkidold", checkidold);
                    }
                    intent.putExtras(bundle);
                    startActivity(intent);
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
        }


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
        myHorizontalScrollView = (MyHorizontalScrollView) findViewById(R.id.oldmanadmin_scrollview);
        textView = (TextView) findViewById(R.id.user_name);
        textView.setText(user.getEmployeeName().toString());
        menu_image = (CircleImageView) findViewById(R.id.menu_circleimage);
        Picasso.with(OldManAdminActivity.this).load(OkHttpURL.ImageURL + user.getImgPath()).placeholder(R.mipmap.default_image).into(menu_image);
        oldmanadminback_menu = (TextView) findViewById(R.id.oldmanadminback_menu);
        oldmanadminback_menu.setOnClickListener(this);
        jibenxinx = (TextView) findViewById(R.id.jibenxinx);
        jibenxinx.setOnClickListener(this);
        jiashuxinxi = (TextView) findViewById(R.id.jiashuxinxi);
        jiashuxinxi.setOnClickListener(this);
        jiankangxinxi = (TextView) findViewById(R.id.jiankangxinxi);
        jiankangxinxi.setOnClickListener(this);
        tizhengshuju = (TextView) findViewById(R.id.tizhengshuju);
        tizhengshuju.setOnClickListener(this);
        hulijihua = (TextView) findViewById(R.id.hulijihua);
        hulijihua.setOnClickListener(this);
        canyjihua = (TextView) findViewById(R.id.canyinjihua);
        canyjihua.setOnClickListener(this);
        outadmin = (TextView) findViewById(R.id.outadmin);
        outadmin.setOnClickListener(this);
        shigujilu = (TextView) findViewById(R.id.shigujilu);
        shigujilu.setOnClickListener(this);
        xiaofeijilu = (TextView) findViewById(R.id.xiaofeijilu);
        xiaofeijilu.setOnClickListener(this);
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (myHorizontalScrollView.isopen()) {
                myHorizontalScrollView.closemenu();

            } else {
                OldManAdminActivity.this.finish();
                overridePendingTransition(R.animator.animation_in, R.animator.animation_out);

            }
        }
        return false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (myHorizontalScrollView.isopen()) {
            myHorizontalScrollView.closemenu();
        }
    }


}
