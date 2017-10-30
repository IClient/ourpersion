package com.example.administrator.OurPersion.View.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.example.administrator.OurPersion.Application.AndroidApplication;
import com.example.administrator.OurPersion.Model.Bean.OkHttpURL;
import com.example.administrator.OurPersion.SelfView.CircleImageView;
import com.example.administrator.OurPersion.View.Fragment.DeviceAdminFragmentOne;
import com.example.administrator.OurPersion.View.Fragment.DeviceAdminFragmentTwo;
import com.example.administrator.OurPersion.R;
import com.example.administrator.OurPersion.SelfView.MyHorizontalScrollView;

import java.util.ArrayList;
import java.util.List;

public class BlueToothAdminActivity extends BaseActivity implements View.OnClickListener {
    MyHorizontalScrollView myHorizontalScrollView;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    List<Fragment> list = new ArrayList<Fragment>();
    Button bluefragment1_btn;
    Button bluefragment2_btn;
    //--菜单用户名字
    TextView textView;
    CircleImageView  menu_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blue_tooth_admin);
        AndroidApplication application= (AndroidApplication) getApplication();
        application.addactivity(BlueToothAdminActivity.this);
        list.add(new DeviceAdminFragmentOne());
        list.add(new DeviceAdminFragmentTwo());
        //--初始化菜单按钮
        initbutton();
        //--设置默认fragment
        SetDefaultFragment();
    }


    public void initbutton() {
        myHorizontalScrollView = (MyHorizontalScrollView) findViewById(R.id.deviceadmain_scrollview);
        nurseadmin_btn = (Button) findViewById(R.id.nurseadmin_btn);
        nurseadmin_btn.setOnClickListener(this);
        oldmanadmin_btn = (Button) findViewById(R.id.oldmanadmin_btn);
        oldmanadmin_btn.setOnClickListener(this);
        bluefragment1_btn = (Button) findViewById(R.id.bluefragment1_btn);
        bluefragment1_btn.setOnClickListener(this);
        bluefragment2_btn = (Button) findViewById(R.id.bluefragment2_btn);
        bluefragment2_btn.setOnClickListener(this);
        textView = (TextView) findViewById(R.id.user_name);
        textView.setText(user.getEmployeeName().toString());
        staffadmin_btn = (Button) findViewById(R.id.staffadmin_btn);
        staffadmin_btn.setOnClickListener(this);

        bedadmin_btn= (Button) findViewById(R.id.bedadmin_btn);
        bedadmin_btn.setOnClickListener(this);
        menu_image= (CircleImageView) findViewById(R.id.menu_circleimage);
        Glide.with(BlueToothAdminActivity.this).load(OkHttpURL.ImageURL + user.getImgPath()).fitCenter().into(menu_image);

    }

    @Override
    public void onClick(View v) {
        fragmentTransaction = fragmentManager.beginTransaction();
        switch (v.getId()) {
            //护理管理
            case R.id.nurseadmin_btn:
                if (myHorizontalScrollView.isopen()) {
                Intent intent = new Intent(BlueToothAdminActivity.this, NurseAdminActivity.class);
                startActivity(intent);
                BlueToothAdminActivity.this.finish();}
                break;
            //老人管理
            case R.id.oldmanadmin_btn:  if (myHorizontalScrollView.isopen()) {
                Intent intent1 = new Intent(BlueToothAdminActivity.this, OldManListActivity.class);
                startActivity(intent1);
                BlueToothAdminActivity.this.finish();}
                break;
            case R.id.staffadmin_btn:
                if (myHorizontalScrollView.isopen()) {
                Intent deviceintent = new Intent(BlueToothAdminActivity.this, StaffAdminActivity.class);
                startActivity(deviceintent);
                BlueToothAdminActivity.this.finish();}
                break;
            case R.id.bedadmin_btn:  if (myHorizontalScrollView.isopen()) {
                Intent bedintent = new Intent(BlueToothAdminActivity.this, BedAdminActivity.class);
                startActivity(bedintent);
                BlueToothAdminActivity.this.finish();}
                break;
            case R.id.bluefragment1_btn:
                if (list.get(1).isAdded()) {
                    fragmentTransaction.hide(list.get(1)).show(list.get(0));

                } else {

                    fragmentTransaction.show(list.get(0));
                }
                bluefragment1_btn.setTextColor(0xf01874CD);
                SetButtonImage(getResources().getDrawable(R.mipmap.zero), bluefragment1_btn);
                bluefragment2_btn.setTextColor(Color.BLACK);
                SetButtonImage(getResources().getDrawable(R.mipmap.zero), bluefragment2_btn);
                fragmentTransaction.commit();
                break;
            case R.id.bluefragment2_btn:
                if (list.get(1).isAdded()) {
                    fragmentTransaction.hide(list.get(0)).show(list.get(1));

                } else {

                    fragmentTransaction.hide(list.get(0)).add(R.id.deviceadmin_fragment, list.get(1));
                }
                bluefragment1_btn.setTextColor(Color.BLACK);
                SetButtonImage(getResources().getDrawable(R.mipmap.zero), bluefragment1_btn);
                bluefragment2_btn.setTextColor(0xf01874CD);
                SetButtonImage(getResources().getDrawable(R.mipmap.zero), bluefragment2_btn);
                fragmentTransaction.commit();
                break;
        }

    }

    public void SetDefaultFragment() {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.deviceadmin_fragment, list.get(0));
        fragmentTransaction.commit();
        bluefragment1_btn.setTextColor(0xf01874CD);
        SetButtonImage(getResources().getDrawable(R.mipmap.zero), bluefragment1_btn);

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (myHorizontalScrollView.isopen()) {
                myHorizontalScrollView.closemenu();

            } else {
                BlueToothAdminActivity.this.finish();

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
