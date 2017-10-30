package com.example.administrator.OurPersion.View.Activity;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.OurPersion.Application.AndroidApplication;
import com.example.administrator.OurPersion.Model.Bean.Code;
import com.example.administrator.OurPersion.R;
import com.example.administrator.OurPersion.Utils.ToastUtils;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ForgetPasswordActivity extends BaseActivity {
    AndroidApplication application;
    EditText forgetEditYzm;
    Button forgetYzm;
    Button forgetSure;
    EditText login_username;
    EditText login_password;
    EditText forget_username;
    int soud = 60;
    //--随机生成的验证码
    String strcode = "";
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if ((int) msg.obj == 1) {
                forgetYzm.setText("获取验证码");
                ToastUtils.show(ForgetPasswordActivity.this, "设置密码成功", Toast.LENGTH_SHORT);
                ForgetPasswordActivity.this.finish();

            } else if ((int) msg.obj == 2) {
                forgetYzm.setText("重新获取验证码");
                ToastUtils.show(ForgetPasswordActivity.this, "设置密码失败,请重试!", Toast.LENGTH_SHORT);
                login_username.setText("");
                login_password.setText("");
                forget_username.setText("");
                forgetEditYzm.setText("");
            } else if ((int) msg.obj == 3) {

                forgetYzm.setText("已发送");

            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        application = (AndroidApplication) getApplication();
        application.addactivity(ForgetPasswordActivity.this);
        initview();
        //--确定重置密码
        forgetSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!forgetEditYzm.getText().toString().equals(strcode)) {
                    ToastUtils.show(ForgetPasswordActivity.this, "验证码错误", Toast.LENGTH_SHORT);
                    return;
                }
                ForgetPassword();

            }
        });
        //获取验证码
        forgetYzm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (login_username.getText().toString().equals("")) {
                    ToastUtils.show(ForgetPasswordActivity.this, "手机号不能为空", Toast.LENGTH_SHORT);
                    return;
                } else if (login_password.getText().toString().equals("")) {
                    ToastUtils.show(ForgetPasswordActivity.this, "密码不能为空", Toast.LENGTH_SHORT);
                    return;
                } else if (login_password.getText().toString().length() < 6) {
                    ToastUtils.show(ForgetPasswordActivity.this, "密码长度不能小于6", Toast.LENGTH_SHORT);
                    return;
                } else if (forget_username.getText().toString().equals("")) {
                    ToastUtils.show(ForgetPasswordActivity.this, "请输入用户名", Toast.LENGTH_SHORT);
                    return;
                }
                forgetYzm.setText("发送中...");
                Code code = new Code();
                code.setPhone(login_username.getText().toString());
                for (int i = 0; i < 4; i++) {
                    Random random = new Random();
                    int result = random.nextInt(10);
                    strcode += result + "";
                }
                List<String> list = new ArrayList<>();
                list.add(strcode);
                code.setPara(list);
                //这里的用户id和用户名还没有获取到
                code.setLoginId("");
                code.setLoginName("");
                code.setServiceModel("1");
                Gson gson = new Gson();
                String data = gson.toJson(code);
                //--获取短信
                MessageHttp(data);
            }
        });

    }

    public void initview() {
        forgetEditYzm = (EditText) findViewById(R.id.forget_edit_yzm);
        forgetYzm = (Button) findViewById(R.id.forget_yzm);
        forgetSure = (Button) findViewById(R.id.forget_sure);
        login_username = (EditText) findViewById(R.id.login_username);
        login_password = (EditText) findViewById(R.id.login_password);
        forget_username = (EditText) findViewById(R.id.forget_username);
    }

    //--发送短信
    public void MessageHttp(String data) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(15, TimeUnit.SECONDS).writeTimeout(15, TimeUnit.SECONDS).build();
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody requestBody = RequestBody.create(JSON, data);
        Request request = new Request.Builder().url("http://192.168.10.7:7006/api/ShortMsg/MsgSend").post(requestBody).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Message message = new Message();
                message.obj = 3;
                handler.sendMessage(message);
            }
        });

    }

    //修改密码
    public void ForgetPassword() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(15, TimeUnit.SECONDS).readTimeout(15, TimeUnit.SECONDS).build();
        Request request = new Request.Builder().get().url("http://192.168.10.7:7006/Api/Employee/ForgetPwd?LoginName=" + forget_username.getText().toString() + "&NewPwd=" + login_password.getText().toString() + "&Token=1").build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    JSONObject jsonObject = new JSONObject(response.body().string());
                    String state = jsonObject.getString("Msg");
                    if (state.equals("更改失败，密码错误")) {
                        Message message = new Message();
                        message.obj = 2;
                        handler.sendMessage(message);
                        return;
                    }
                    Message message = new Message();
                    message.obj = 1;
                    handler.sendMessage(message);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });

    }
}



