package com.example.administrator.OurPersion.View.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.OurPersion.Application.AndroidApplication;
import com.example.administrator.OurPersion.Model.Bean.OkHttpURL;
import com.example.administrator.OurPersion.R;
import com.example.administrator.OurPersion.SelfView.CircleImageView;
import com.example.administrator.OurPersion.Utils.ToastUtils;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class UpdatePasswordActivity extends BaseActivity implements View.OnClickListener {
    CircleImageView circleImageView;
    EditText update_oldpw;
    EditText update_newpw;
    EditText update_surenewpw;
    Button update_pw_btn;
    AndroidApplication application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_password);
        application = (AndroidApplication) getApplication();
        application.addactivity(UpdatePasswordActivity.this);
        initview();
    }

    public void initview() {
        circleImageView = (CircleImageView) findViewById(R.id.updatepasswordactivityback_menu);
        circleImageView.setOnClickListener(this);
        Picasso.with(UpdatePasswordActivity.this).load(OkHttpURL.ImageURL + user.getImgPath()).placeholder(R.mipmap.default_image).into(circleImageView);
        update_oldpw = (EditText) findViewById(R.id.update_oldpw);
        update_newpw = (EditText) findViewById(R.id.update_newpw);
        update_surenewpw = (EditText) findViewById(R.id.update_surenewpw);
        update_pw_btn = (Button) findViewById(R.id.update_pw_btn);
        update_pw_btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.updatepasswordactivityback_menu:
                UpdatePasswordActivity.this.finish();
                overridePendingTransition(R.animator.animation_in, R.animator.animation_out);
                break;
            case R.id.update_pw_btn:
                if (update_oldpw.getText().toString().trim() == null || update_oldpw.getText().toString().trim().equals("")) {
                    ToastUtils.show(UpdatePasswordActivity.this, "请输入初始密码", Toast.LENGTH_SHORT);
                    return;

                } else if (!update_oldpw.getText().toString().trim().equals(LoginActivity.sharedPreferences.getString("pw", ""))) {

                    ToastUtils.show(UpdatePasswordActivity.this, "初始密码错误", Toast.LENGTH_SHORT);
                    return;
                } else if (update_newpw.getText().toString().trim() == null || update_newpw.getText().toString().trim().equals("")) {

                    ToastUtils.show(UpdatePasswordActivity.this, "密码不能为空", Toast.LENGTH_SHORT);
                    return;
                } else if (update_newpw.getText().toString().trim().length() < 6) {

                    ToastUtils.show(UpdatePasswordActivity.this, "密码长度不能小于6", Toast.LENGTH_SHORT);
                    return;
                } else if (!update_newpw.getText().toString().trim().equals(update_surenewpw.getText().toString().trim())) {
                    ToastUtils.show(UpdatePasswordActivity.this, "两次密码输入不一致", Toast.LENGTH_SHORT);
                    return;
                }
                OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(10000, TimeUnit.SECONDS).build();
                Request request = new Request.Builder().url("http://192.168.10.7:7006/api/Employee/SaveEmployeePwd?Empid=" + user.getId() + "&oldPwd=" + LoginActivity.sharedPreferences.getString("pw", "") + "&newPwd=" + update_newpw.getText().toString().trim()).get().build();
                okHttpClient.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.e("fail", e.toString());
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        //--密码修改成功后，取消记住密码单选框,
                        LoginActivity.editor.putBoolean("remberischeck", false);
                        LoginActivity.editor.commit();
                        application.moveactivity();
                        Intent intent = new Intent(UpdatePasswordActivity.this, LoginActivity.class);
                        startActivity(intent);
                        overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                    }
                });
                break;
        }

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {

            UpdatePasswordActivity.this.finish();
            overridePendingTransition(R.animator.animation_in, R.animator.animation_out);

        }
        return false;
    }
}
