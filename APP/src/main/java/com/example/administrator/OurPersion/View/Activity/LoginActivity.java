package com.example.administrator.OurPersion.View.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.OurPersion.Application.AndroidApplication;
import com.example.administrator.OurPersion.Model.Bean.User;
import com.example.administrator.OurPersion.R;
import com.example.administrator.OurPersion.Utils.NetUtils;
import com.example.administrator.OurPersion.Utils.ToastUtils;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Call;
import okhttp3.Callback;

import okhttp3.Response;

public class LoginActivity extends BaseActivity {
    public static SharedPreferences sharedPreferences;
    public static SharedPreferences.Editor editor;
    //忘记密码
    Button forgetpassword_btn;
    //--判断是否是首次登录
    boolean isfirst;
    EditText login_username;
    EditText login_password;
    //--登录按钮
    Button login_btn;
    //--记住密码
    CheckBox remberpassword_check;
    boolean remberischeck;
    //--自动登录
    CheckBox selflogin_check;
    boolean selfloginischeck;
    TextView login_text;
    //--最外层的布局
    LinearLayout loginfirst_layout;
    AndroidApplication application;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //--dialog消失
            dissdialog();
            /***
             * 2表示成功
             * 1表示超时
             * 3表示未连接到网络
             * 4表示用户名或密码错误
             */
            if (msg.arg1 == 2) {
                if (isfirst) {
                    Intent intent = new Intent(LoginActivity.this, WelcomeActivity.class);
                    startActivity(intent);
                    LoginActivity.this.finish();

                } else {
                    Intent intent = new Intent(LoginActivity.this, FirstMainActivity.class);
                    startActivity(intent);
                    LoginActivity.this.finish();
                }
                return;
            } else if (msg.arg1 == 1) {
                ToastUtils.show(LoginActivity.this, "网络连接超时,请重新连接", Toast.LENGTH_SHORT);
                return;
            } else if (msg.arg1 == 3) {
                ToastUtils.show(LoginActivity.this, "未连接到网络", Toast.LENGTH_SHORT);
            } else if (msg.arg1 == 4) {
                ToastUtils.show(LoginActivity.this, "用户名或密码错误", Toast.LENGTH_SHORT);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        application = (AndroidApplication) getApplication();
        application.addactivity(LoginActivity.this);
        //--初始化控件
        initview();

    }

    @Override
    protected void onResume() {
        super.onResume();
        //--初始化sharepreferences
        initsharepreferences();
        //---最外层布局和最外层中最后一个控件布局
        addLayoutListener(loginfirst_layout, forgetpassword_btn);
        forgetpassword_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ForgetPasswordActivity.class);
                startActivity(intent);
            }
        });
        //--点击登录时
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //--首先判断用户名，密码是否为空
                if (login_username.getText().toString().equals("") || login_password.getText().toString().equals("")) {
                    ToastUtils.show(LoginActivity.this, "用户名和密码不能为空", Toast.LENGTH_SHORT);
                    return;
                }
//                //--密码长度不能小于6
//
//                if (login_password.getText().toString().length() < 6) {
//                    ToastUtils.show(LoginActivity.this, "密码长度不能小于6", Toast.LENGTH_SHORT);
//                    return;
//                }
                //---判断是否有网络
                if (!NetUtils.isConnected(LoginActivity.this)) {
                    ToastUtils.show(LoginActivity.this, "未连接到网络", Toast.LENGTH_SHORT);
                    return;
                }
                //--圆形加载显示
                showdialog(LoginActivity.this);
                //---用户有可能重新输入了用户名
                editor.remove("user");
                editor.putString("user", login_username.getText().toString());
                //--记住密码的check
                if (remberpassword_check.isChecked()) {
                    editor.putString("pw", login_password.getText().toString());
                    editor.putBoolean("remberischeck", true);
                } else {
                    editor.putBoolean("remberischeck", false);
                }
                //--自动登录的check
                if (selflogin_check.isChecked()) {
                    editor.putBoolean("selfloginischeck", true);
                } else {
                    editor.putBoolean("selfloginischeck", false);
                }
                editor.commit();
                //--登录
                http();
            }
        });
    }

    public void initview() {
        login_text = (TextView) findViewById(R.id.login_text);
        login_username = (EditText) findViewById(R.id.login_username);
        login_password = (EditText) findViewById(R.id.login_password);
        login_btn = (Button) findViewById(R.id.login_btn);
        remberpassword_check = (CheckBox) findViewById(R.id.remberpassword_check);
        selflogin_check = (CheckBox) findViewById(R.id.selflogin_check);
        loginfirst_layout = (LinearLayout) findViewById(R.id.loginfirst_layout);
        forgetpassword_btn = (Button) findViewById(R.id.forget_password_btn);

    }

    public void http() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(15, TimeUnit.SECONDS).readTimeout(20, TimeUnit.SECONDS).build();
        final Request request = new Request.Builder().url("http://192.168.10.7:7006/api/Employee/EmployeeLogin?LoginId=" + login_username.getText().toString().trim() + "&LoginPwd=" + login_password.getText().toString().trim() + "&Token=1").build();
        okHttpClient.newCall(request).enqueue(new Callback() {
                                                  @Override
                                                  public void onFailure(Call call, IOException e) {
                                                      if (!NetUtils.isConnected(LoginActivity.this)) {
                                                          Message message = new Message();
                                                          message.arg1 = 3;
                                                          handler.sendMessage(message);
                                                          return;
                                                      }
                                                      Message message = new Message();
                                                      message.arg1 = 1;
                                                      handler.sendMessage(message);

                                                  }

                                                  @Override
                                                  public void onResponse(Call call, Response response) throws IOException {
                                                      String result = response.body().string();
                                                      if (result.equals("null")) {
                                                          Message message = new Message();
                                                          message.arg1 = 4;
                                                          handler.sendMessage(message);

                                                      } else {
                                                          Gson gson = new Gson();
                                                          User user = gson.fromJson(result, User.class);
                                                          Message message = new Message();
                                                          message.arg1 = 2;
                                                          handler.sendMessage(message);
                                                          BaseActivity.user = user;
                                                          editor.putBoolean("isfirst", false);
                                                          editor.commit();
                                                      }
                                                  }

                                              }
        );

    }

    public void initsharepreferences() {
        sharedPreferences = getSharedPreferences("user", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        isfirst = sharedPreferences.getBoolean("isfirst", true);
        remberischeck = sharedPreferences.getBoolean("remberischeck", false);
        selfloginischeck = sharedPreferences.getBoolean("selfloginischeck", false);
        //--如果不是第一次登录就从sharedPreferences拿出数据
        if (isfirst == false) {
            login_username.setText(sharedPreferences.getString("user", ""));
            login_username.setSelection(login_username.getText().toString().length());
        }
        //---如果勾选了记住密码就拿出数据
        if (remberischeck == true) {
            login_password.setText(sharedPreferences.getString("pw", ""));
            login_password.setSelection(login_password.getText().toString().length());
            remberpassword_check.setChecked(true);
        } else {
            remberpassword_check.setChecked(false);

        }
        //---如果勾选了自动登录
        if (selfloginischeck == true) {
            //--设置光标消失
            login_username.setCursorVisible(false);
            login_password.setCursorVisible(false);
            //--圆形加载显示
            showdialog(LoginActivity.this);
            http();
            selflogin_check.setChecked(true);

        } else {
            selflogin_check.setChecked(false);

        }


    }
}