package com.example.administrator.OurPersion.View.Activity;


import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;


import com.example.administrator.OurPersion.Application.AndroidApplication;
import com.example.administrator.OurPersion.R;
import com.example.administrator.OurPersion.SelfView.MyHorizontalScrollView;

public class SystemSettingActivity extends BaseActivity {
MyHorizontalScrollView  myHorizontalScrollView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_setting);
        AndroidApplication application= (AndroidApplication) getApplication();
        application.addactivity(SystemSettingActivity.this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.systemsettingactivity_toolbar);
        setSupportActionBar(toolbar);
        myHorizontalScrollView= (MyHorizontalScrollView) findViewById(R.id.activity_system_setting_scroolview);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (myHorizontalScrollView.isopen()) {
                myHorizontalScrollView.closemenu();

            } else {
                SystemSettingActivity.this.finish();

            }
        }
        return false;
    }

}
