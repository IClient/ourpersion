package com.example.administrator.OurPersion.View.Activity;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.OurPersion.Application.AndroidApplication;
import com.example.administrator.OurPersion.Model.Bean.OkHttpURL;
import com.example.administrator.OurPersion.Model.Bean.User;
import com.example.administrator.OurPersion.R;
import com.example.administrator.OurPersion.SelfView.CircleImageView;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class EditMeMessageAcivity extends BaseActivity implements View.OnClickListener {
    /**
     * editmemessageactivityback_menu编辑资料的头像
     * me_sex性别
     * me_position职位
     * me_organizationname所属部门
     * me_entertime入职时间
     * me_phonenumber联系方式
     * me_name姓名
     * me_address地址
     * save_message保存编辑资料
     */
    TextView editmessage_sex;
    TextView editmessage_position;
    TextView editmessage_organizationname;
    TextView editmessage_entertime;
    EditText editmessage_phonenumber;
    TextView editmessage_name;
    EditText editmessage_address;

    Bitmap bitmap;
    Button save_message;
    CircleImageView editmemessageactivityback_me;
    User newuser;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if ((int) msg.obj == 1) {

                EditMeMessageAcivity.this.finish();
                overridePendingTransition(R.animator.animation_in, R.animator.animation_out);
                dissdialog();
            }

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_me_message);
        AndroidApplication application = (AndroidApplication) getApplication();
        application.addactivity(EditMeMessageAcivity.this);
        bitmap = getIntent().getParcelableExtra("image");
        //初始化控件
        initview();
    }

    public void initview() {
        editmessage_address = (EditText) findViewById(R.id.editmessage_address);
        if (user.getAddress() == null || user.getAddress().equals("")) {
            editmessage_address.setText("");
        } else {
            editmessage_address.setText(user.getAddress().toString());
        }
        editmessage_name = (TextView) findViewById(R.id.editmessage_name);
        editmessage_name.setText(user.getEmployeeName());
        editmessage_phonenumber = (EditText) findViewById(R.id.editmessage_phonenumber);
        editmessage_phonenumber.setText(user.getPhoneNumber());
        editmessage_phonenumber.setSelection(editmessage_phonenumber.length());
        editmessage_position = (TextView) findViewById(R.id.editmessage_position);
        editmessage_position.setText(user.getPositionName());
        editmessage_sex = (TextView) findViewById(R.id.editmessage_sex);
        if (TextUtils.isEmpty(user.getSex())) {
            editmessage_sex.setText("");
        } else if (user.getSex().equals("0")) {
            editmessage_sex.setText("男");
        } else if (user.getSex().equals("1")) {
            editmessage_sex.setText("女");
        }
        editmessage_organizationname = (TextView) findViewById(R.id.editmessage_organizationname);
        editmessage_organizationname.setText(user.getOrganizationName());
        editmessage_entertime = (TextView) findViewById(R.id.editmessage_entertime);
        editmessage_entertime.setText(user.getEnterDate());
        editmemessageactivityback_me = (CircleImageView) findViewById(R.id.editmemessageactivityback_me);
        Picasso.with(EditMeMessageAcivity.this).load(OkHttpURL.ImageURL + user.getImgPath()).placeholder(R.mipmap.default_image).into(editmemessageactivityback_me);
        //--当用户没有改变头像时就设置默认头像
        if (bitmap != null) {
            editmemessageactivityback_me.setImageBitmap(bitmap);
        }
        editmemessageactivityback_me.setOnClickListener(this);
        save_message = (Button) findViewById(R.id.edit_me_message_save);
        save_message.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.editmemessageactivityback_me:
                EditMeMessageAcivity.this.finish();
                overridePendingTransition(R.animator.animation_in, R.animator.animation_out);
                break;
            //--保存按钮
            case R.id.edit_me_message_save:
                /**
                 * 目前只编辑电话和地址，首先判断用户是否有修改，如果修改就post，否则直接返回
                 */
                if (user.getAddress() == null || TextUtils.isEmpty(user.getPhoneNumber())) {

                    if (!TextUtils.isEmpty(editmessage_address.getText().toString()) || !TextUtils.isEmpty(editmessage_phonenumber.getText().toString())) {

                        // 创建退出对话框
                        AlertDialog isExit = new AlertDialog.Builder(this).create();
                        // 设置对话框标题
                        isExit.setTitle("系统提示");
                        // 设置对话框消息
                        isExit.setMessage("确定要保存数据吗");
                        // 添加选择按钮并注册监听
                        isExit.setButton("确定", listener);
                        isExit.setButton2("取消", listener);
                        // 显示对话框
                        isExit.show();
                    } else {
                        EditMeMessageAcivity.this.finish();
                        overridePendingTransition(R.animator.animation_in, R.animator.animation_out);

                    }
                    break;
                }


                if (!user.getAddress().toString().equals(editmessage_address.getText().toString()) || !user.getPhoneNumber().toString().equals(editmessage_phonenumber.getText().toString())) {
                    // 创建退出对话框
                    AlertDialog isExit = new AlertDialog.Builder(this).create();
                    // 设置对话框标题
                    isExit.setTitle("系统提示");
                    // 设置对话框消息
                    isExit.setMessage("确定要保存数据吗");
                    // 添加选择按钮并注册监听
                    isExit.setButton("确定", listener);
                    isExit.setButton2("取消", listener);
                    // 显示对话框
                    isExit.show();
                } else {
                    EditMeMessageAcivity.this.finish();
                    overridePendingTransition(R.animator.animation_in, R.animator.animation_out);

                }
                break;


        }
    }

    public void http() {
        newuser = user;
        newuser.setAddress(editmessage_address.getText().toString().trim());
        newuser.setPhoneNumber(editmessage_phonenumber.getText().toString().trim());
        //--对象转换json格式

        Gson gson = new Gson();
        String json = gson.toJson(newuser);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS).build();
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody requestBody = RequestBody.create(JSON, json);
        Request request = new Request.Builder().url("http://192.168.10.7:7006/api/Employee/ModifyEmplpoyee").post(requestBody).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                user = newuser;
                Message message = new Message();
                message.obj = 1;
                handler.sendMessage(message);

            }
        });


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            EditMeMessageAcivity.this.finish();
            overridePendingTransition(R.animator.animation_in, R.animator.animation_out);
        }
        return false;
    }

    /**
     * 监听对话框里面的button点击事件
     */
    DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            switch (which) {
                case AlertDialog.BUTTON_POSITIVE:// "确认"按钮退出程序
                    http();
                    showdialog(EditMeMessageAcivity.this);
                    break;
                case AlertDialog.BUTTON_NEGATIVE:// "取消"第二个按钮取消对话框
                    break;
                default:
                    break;
            }
        }
    };
}
