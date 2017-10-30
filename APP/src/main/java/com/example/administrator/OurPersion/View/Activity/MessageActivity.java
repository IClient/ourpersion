package com.example.administrator.OurPersion.View.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.OurPersion.Model.Bean.OkHttpURL;
import com.example.administrator.OurPersion.R;
import com.example.administrator.OurPersion.SelfView.CircleImageView;
import com.example.administrator.OurPersion.SelfView.MyHorizontalScrollView;
import com.squareup.picasso.Picasso;

/**
 * Created by Administrator on 2017/10/9 0009.
 */

public class MessageActivity extends BaseActivity implements View.OnClickListener {
    //--用户
    TextView user_name;
    CircleImageView menu_circleimage;
    MyHorizontalScrollView message_scrollview;
    CircleImageView messageback_menu;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
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
        user_name = (TextView) findViewById(R.id.user_name);
        user_name.setText(user.getEmployeeName());
        menu_circleimage = (CircleImageView) findViewById(R.id.menu_circleimage);
        Picasso.with(MessageActivity.this).load(OkHttpURL.ImageURL + user.getImgPath()).placeholder(R.mipmap.default_image).into(menu_circleimage);
        messageback_menu = (CircleImageView) findViewById(R.id.messageback_menu);
        Picasso.with(MessageActivity.this).load(OkHttpURL.ImageURL + user.getImgPath()).placeholder(R.mipmap.default_image).into(messageback_menu);
        messageback_menu.setOnClickListener(this);
        message_scrollview = (MyHorizontalScrollView) findViewById(R.id.message_scrollview);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.messageback_menu:
                if (!message_scrollview.isopen()) {
                    message_scrollview.openmenu();

                }

                break;
            case R.id.nurseadmin_btn:
                if (message_scrollview.isopen()) {
                    Intent nurseintent = new Intent(MessageActivity.this, NurseAdminActivity.class);
                    startActivity(nurseintent);
                    this.finish();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            case R.id.oldmanadmin_btn:
                if (message_scrollview.isopen()) {
                    Intent oldmanintent = new Intent(MessageActivity.this, OldManListActivity.class);
                    startActivity(oldmanintent);
                    this.finish();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            case R.id.staffadmin_btn:
                if (message_scrollview.isopen()) {
                    Intent staffintent = new Intent(MessageActivity.this, StaffAdminActivity.class);
                    startActivity(staffintent);
                    this.finish();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            case R.id.bedadmin_btn:
                if (message_scrollview.isopen()) {
                    Intent systemintent = new Intent(MessageActivity.this, BedAdminActivity.class);
                    startActivity(systemintent);
                    this.finish();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            case R.id.messagesend_btn:
                if (message_scrollview.isopen()) {
                    message_scrollview.closemenu();
                }
                break;
        }

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (message_scrollview.isopen()) {
                message_scrollview.closemenu();

            } else {
                MessageActivity.this.finish();
                overridePendingTransition(R.animator.animation_in, R.animator.animation_out);

            }
        }
        return false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (message_scrollview.isopen()) {
            message_scrollview.closemenu();
        }
    }
}
