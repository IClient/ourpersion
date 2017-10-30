package com.example.administrator.OurPersion.View.Activity;

import android.content.Intent;
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
import com.example.administrator.OurPersion.View.Fragment.FormsAdminFragmentFour;
import com.example.administrator.OurPersion.View.Fragment.FormsAdminFragmentOne;
import com.example.administrator.OurPersion.View.Fragment.FormsAdminFragmentThree;
import com.example.administrator.OurPersion.View.Fragment.FormsAdminFragmentTwo;
import com.example.administrator.OurPersion.R;
import com.example.administrator.OurPersion.SelfView.MyHorizontalScrollView;

import java.util.ArrayList;
import java.util.List;


public class FormsAdminActivity extends BaseActivity implements View.OnClickListener {
  public  static   MyHorizontalScrollView myHorizontalScrollView;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    List<Fragment> fragmentlist = new ArrayList<Fragment>();
    Button formsfragment1_btn;
    Button formsfragment2_btn;
    Button formsfragment3_btn;
    Button formsfragment4_btn;
    //--菜单用户名字
    TextView textView;
    CircleImageView menu_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forms_admin);
        AndroidApplication application = (AndroidApplication) getApplication();
        application.addactivity(FormsAdminActivity.this);
        fragmentlist.add(new FormsAdminFragmentOne());
        fragmentlist.add(new FormsAdminFragmentTwo());
        fragmentlist.add(new FormsAdminFragmentThree());
        fragmentlist.add(new FormsAdminFragmentFour());
        //-初始化控件
        initview();
        //--设置默认frgament
        SetDefaultFragment();
    }

    public void initview() {
        myHorizontalScrollView = (MyHorizontalScrollView) findViewById(R.id.formsadmin_scrollview);
        oldmanadmin_btn = (Button) findViewById(R.id.oldmanadmin_btn);
        oldmanadmin_btn.setOnClickListener(this);
        nurseadmin_btn = (Button) findViewById(R.id.nurseadmin_btn);
        nurseadmin_btn.setOnClickListener(this);
        formsfragment1_btn = (Button) findViewById(R.id.formsfragment1_btn);
        formsfragment1_btn.setOnClickListener(this);
        formsfragment2_btn = (Button) findViewById(R.id.formsfragment2_btn);
        formsfragment2_btn.setOnClickListener(this);
        formsfragment3_btn = (Button) findViewById(R.id.formsfragment3_btn);
        formsfragment3_btn.setOnClickListener(this);
        formsfragment4_btn = (Button) findViewById(R.id.formsfragment4_btn);
        formsfragment4_btn.setOnClickListener(this);
        textView = (TextView) findViewById(R.id.user_name);
        textView.setText(user.getEmployeeName().toString());;
        staffadmin_btn = (Button) findViewById(R.id.staffadmin_btn);
        staffadmin_btn.setOnClickListener(this);

        bedadmin_btn = (Button) findViewById(R.id.bedadmin_btn);
        bedadmin_btn.setOnClickListener(this);
        menu_image= (CircleImageView) findViewById(R.id.menu_circleimage);
        Glide.with(FormsAdminActivity.this).load(OkHttpURL.ImageURL + user.getImgPath()).fitCenter().into(menu_image);
    }

    @Override
    public void onClick(View v) {
        fragmentTransaction = fragmentManager.beginTransaction();

        switch (v.getId()) {
            case R.id.oldmanadmin_btn:
                if (myHorizontalScrollView.isopen()) {
                    Intent oldmanadminintent = new Intent(FormsAdminActivity.this, OldManListActivity.class);
                    startActivity(oldmanadminintent);
                    FormsAdminActivity.this.finish();
                }
                break;
            case R.id.nurseadmin_btn:
                if (myHorizontalScrollView.isopen()) {
                    Intent nurseadminintent = new Intent(FormsAdminActivity.this, NurseAdminActivity.class);
                    startActivity(nurseadminintent);
                    FormsAdminActivity.this.finish();
                }
                break;
            case R.id.staffadmin_btn:
                if (myHorizontalScrollView.isopen()) {
                    Intent staffadminintent = new Intent(FormsAdminActivity.this, StaffAdminActivity.class);
                    startActivity(staffadminintent);
                    FormsAdminActivity.this.finish();
                }
                break;
            case R.id.bedadmin_btn:
                if (myHorizontalScrollView.isopen()) {
                    Intent bedintent = new Intent(FormsAdminActivity.this, BedAdminActivity.class);
                    startActivity(bedintent);
                    FormsAdminActivity.this.finish();
                }
                break;
            case R.id.formsfragment1_btn:
                if (fragmentlist.get(1).isAdded()) {
                    fragmentTransaction.hide(fragmentlist.get(1));
                }
                if (fragmentlist.get(2).isAdded()) {
                    fragmentTransaction.hide(fragmentlist.get(2));
                }
                if (fragmentlist.get(3).isAdded()) {
                    fragmentTransaction.hide(fragmentlist.get(3));

                }
                fragmentTransaction.show(fragmentlist.get(0));
                fragmentTransaction.commit();
                break;
            case R.id.formsfragment2_btn:
                if (fragmentlist.get(1).isAdded()) {

                    fragmentTransaction.show(fragmentlist.get(1));
                } else {

                    fragmentTransaction.add(R.id.formsadmin_fragment, fragmentlist.get(1));
                }
                if (fragmentlist.get(3).isAdded()) {
                    fragmentTransaction.hide(fragmentlist.get(3));

                }
                if (fragmentlist.get(2).isAdded()) {
                    fragmentTransaction.hide(fragmentlist.get(2));

                }
                if (fragmentlist.get(0).isAdded()) {
                    fragmentTransaction.hide(fragmentlist.get(0));

                }
                fragmentTransaction.commit();

                break;
            case R.id.formsfragment3_btn:

                if (fragmentlist.get(2).isAdded()) {

                    fragmentTransaction.show(fragmentlist.get(2));
                } else {

                    fragmentTransaction.add(R.id.formsadmin_fragment, fragmentlist.get(2));
                }
                if (fragmentlist.get(3).isAdded()) {
                    fragmentTransaction.hide(fragmentlist.get(3));

                }
                if (fragmentlist.get(1).isAdded()) {
                    fragmentTransaction.hide(fragmentlist.get(1));

                }
                if (fragmentlist.get(0).isAdded()) {
                    fragmentTransaction.hide(fragmentlist.get(0));

                }
                fragmentTransaction.commit();
                break;
            case R.id.formsfragment4_btn:

                if (fragmentlist.get(3).isAdded()) {

                    fragmentTransaction.show(fragmentlist.get(3));
                } else {

                    fragmentTransaction.add(R.id.formsadmin_fragment, fragmentlist.get(3));
                }
                if (fragmentlist.get(2).isAdded()) {
                    fragmentTransaction.hide(fragmentlist.get(2));

                }
                if (fragmentlist.get(1).isAdded()) {
                    fragmentTransaction.hide(fragmentlist.get(1));

                }
                if (fragmentlist.get(0).isAdded()) {
                    fragmentTransaction.hide(fragmentlist.get(0));

                }
                fragmentTransaction.commit();
                break;


        }

    }

    public void SetDefaultFragment() {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.formsadmin_fragment, fragmentlist.get(0));
        fragmentTransaction.commit();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (myHorizontalScrollView.isopen()) {
                myHorizontalScrollView.closemenu();

            } else {
                FormsAdminActivity.this.finish();

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

