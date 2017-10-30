package com.example.administrator.OurPersion.View.Activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.OurPersion.Application.AndroidApplication;
import com.example.administrator.OurPersion.Model.Bean.OkHttpURL;
import com.example.administrator.OurPersion.R;
import com.example.administrator.OurPersion.SelfView.CircleImageView;
import com.example.administrator.OurPersion.SelfView.MyHorizontalScrollView;
import com.example.administrator.OurPersion.Utils.ToastUtils;
import com.example.administrator.OurPersion.View.Dialog.MeAddiconDialog;
import com.squareup.picasso.Picasso;

/**
 * Created by Administrator on 2017/9/29 0029.
 */

public class FirstMainMeActivity extends BaseActivity implements View.OnClickListener {
    //--菜单用户名字
    TextView user_name;
    //--个人中心姓名
    TextView me_username;
    TextView me_phonenumber;
    TextView me_sex;
    TextView me_address;
    TextView me_position;
    TextView me_organizationname;
    TextView me_entertime;
    MyHorizontalScrollView myHorizontalScrollView;
    PopupWindow window;
    //--用户头像设置
    CircleImageView me_imagebtn;
    //--用户头像设置取消
    Button btn_back;
    //--用户头像设置从相册中获取
    Button btn_capture;
    //--用户头像设置拍照
    Button btn_camera;
    //--编辑资料
    LinearLayout me_editmessage;
    //--个人中心返回
    CircleImageView meactivityback_menu;
    //菜单
    CircleImageView menu_circleimage;
    Bitmap bitmap;
    //--加号按钮
    ImageButton meactivity_addicon;
    MeAddiconDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstmain_me);
        AndroidApplication application = (AndroidApplication) getApplication();
        application.addactivity(FirstMainMeActivity.this);
        //初始化控件
        initview();
    }

    public void initview() {
        myHorizontalScrollView = (MyHorizontalScrollView) findViewById(R.id.me_scrollview);
        nurseadmin_btn = (Button) findViewById(R.id.nurseadmin_btn);
        nurseadmin_btn.setOnClickListener(this);
        oldmanadmin_btn = (Button) findViewById(R.id.oldmanadmin_btn);
        oldmanadmin_btn.setOnClickListener(this);
        staffadmin_btn = (Button) findViewById(R.id.staffadmin_btn);
        staffadmin_btn.setOnClickListener(this);
        user_name = (TextView) findViewById(R.id.user_name);
        user_name.setText(user.getEmployeeName());
        bedadmin_btn = (Button) findViewById(R.id.bedadmin_btn);
        bedadmin_btn.setOnClickListener(this);
        messagesend_btn= (Button) findViewById(R.id.messagesend_btn);
        messagesend_btn.setOnClickListener(this);
        me_imagebtn = (CircleImageView) findViewById(R.id.me_imagebtn);
        Picasso.with(FirstMainMeActivity.this).load(OkHttpURL.ImageURL + BaseActivity.user.getImgPath()).placeholder(R.mipmap.default_image).into(me_imagebtn);
        me_imagebtn.setOnClickListener(this);
        me_username = (TextView) findViewById(R.id.me_username);
        me_username.setText(user.getEmployeeName());
        me_phonenumber = (TextView) findViewById(R.id.me_phonenumber);
        me_phonenumber.setText(user.getPhoneNumber());
        me_sex = (TextView) findViewById(R.id.me_sex);
        if (TextUtils.isEmpty(user.getSex())) {
            me_sex.setText("");
        } else if (user.getSex().equals("0")) {
            me_sex.setText("男");
        } else if (user.getSex().equals("1")) {
            me_sex.setText("女");
        }
        me_address = (TextView) findViewById(R.id.me_address);
        if (user.getAddress() == null || user.getAddress().equals("")) {
            me_address.setText("");
        } else {
            me_address.setText(user.getAddress().toString());
        }
        me_position = (TextView) findViewById(R.id.me_position);
        me_position.setText(user.getPositionName());
        me_organizationname = (TextView) findViewById(R.id.me_organizationname);
        me_organizationname.setText(user.getOrganizationName());
        me_entertime = (TextView) findViewById(R.id.me_entertime);
        me_entertime.setText(user.getEnterDate());
        me_editmessage = (LinearLayout) findViewById(R.id.me_editmessage);
        me_editmessage.setOnClickListener(this);
        meactivityback_menu = (CircleImageView) findViewById(R.id.meactivityback_menu);
        Picasso.with(FirstMainMeActivity.this).load(OkHttpURL.ImageURL + BaseActivity.user.getImgPath()).placeholder(R.mipmap.default_image).into(meactivityback_menu);
        meactivityback_menu.setOnClickListener(this);
        menu_circleimage = (CircleImageView) findViewById(R.id.menu_circleimage);
        Picasso.with(FirstMainMeActivity.this).load(OkHttpURL.ImageURL + BaseActivity.user.getImgPath()).placeholder(R.mipmap.default_image).into(menu_circleimage);
        meactivity_addicon = (ImageButton) findViewById(R.id.meactivity_addicon);
        meactivity_addicon.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.nurseadmin_btn:
                if (myHorizontalScrollView.isopen()) {
                    Intent nurseintent = new Intent(FirstMainMeActivity.this, NurseAdminActivity.class);
                    startActivity(nurseintent);
                    FirstMainMeActivity.this.finish();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            case R.id.oldmanadmin_btn:
                if (myHorizontalScrollView.isopen()) {
                    Intent oldmanintent = new Intent(FirstMainMeActivity.this, OldManListActivity.class);
                    startActivity(oldmanintent);
                    FirstMainMeActivity.this.finish();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            case R.id.staffadmin_btn:
                if (myHorizontalScrollView.isopen()) {
                    Intent staffintent = new Intent(FirstMainMeActivity.this, StaffAdminActivity.class);
                    startActivity(staffintent);
                    FirstMainMeActivity.this.finish();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            case R.id.bedadmin_btn:
                if (myHorizontalScrollView.isopen()) {
                    Intent bedintent = new Intent(FirstMainMeActivity.this, BedAdminActivity.class);
                    startActivity(bedintent);
                    FirstMainMeActivity.this.finish();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }

                break;
            case R.id.messagesend_btn:
                if (myHorizontalScrollView.isopen()) {
                    Intent bedintent = new Intent(FirstMainMeActivity.this, MessageActivity.class);
                    startActivity(bedintent);
                    FirstMainMeActivity.this.finish();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }

                break;
            case R.id.me_imagebtn:
                MyPoPuWindow();
                SetBackgroundalph(0.5f);
                break;
            case R.id.btn_back:
                window.dismiss();
                SetBackgroundalph(1.0f);
                break;
            //相册获取
            case R.id.btn_capture:
                window.dismiss();
                choosePhone(v);
                break;
            //--拍照
            case R.id.btn_camera:
                window.dismiss();
                takePhoto(v);
                break;
            //--点击资料区域
            case R.id.me_editmessage:
                Intent editintent = new Intent(FirstMainMeActivity.this, EditMeMessageAcivity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable("image", bitmap);
                editintent.putExtras(bundle);
                startActivity(editintent);
                overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                break;
            case R.id.meactivityback_menu:
                if (!myHorizontalScrollView.isopen()) {
                    FirstMainMeActivity.this.finish();
                    overridePendingTransition(R.animator.animation_in, R.animator.animation_out);

                }
                break;
            case R.id.meactivity_addicon:
                dialog = new MeAddiconDialog(FirstMainMeActivity.this, R.style.MyDialog, R.layout.me_addicon_dialog);
                dialog.show();
                Button button = (Button) dialog.findViewById(R.id.medialog_editmessage_btn);
                button.setOnClickListener(this);
                Button button1 = (Button) dialog.findViewById(R.id.medialog_exit_btn);
                button1.setOnClickListener(this);
                Button button2 = (Button) dialog.findViewById(R.id.medialog_editimage_btn);
                button2.setOnClickListener(this);
                Button button5 = (Button) dialog.findViewById(R.id.medialog_updatepassword_btn);
                button5.setOnClickListener(this);
                SetBackgroundalph(0.8f);
                dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        SetBackgroundalph(1.0f);
                    }
                });
                break;
            //--点击编辑资料按钮
            case R.id.medialog_editmessage_btn:
                Intent editintent1 = new Intent(FirstMainMeActivity.this, EditMeMessageAcivity.class);
                Bundle bundle1 = new Bundle();
                bundle1.putParcelable("image", bitmap);
                editintent1.putExtras(bundle1);
                startActivity(editintent1);
                overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                DestoryDialogs();
                break;
            //--点击头像设置按钮
            case R.id.medialog_editimage_btn:
                dialog.dismiss();
                MyPoPuWindow();
                SetBackgroundalph(0.5f);
                break;
            //--退出帐号
            case R.id.medialog_exit_btn:
                /**
                 * editor.remove("user");
                 editor.remove("pw");
                 editor.commit();
                 退出帐号后把自动登录取消
                 */

                LoginActivity.editor.putBoolean("selfloginischeck", false);
                LoginActivity.editor.commit();
                Intent intent = new Intent(FirstMainMeActivity.this, LoginActivity.class);
                startActivity(intent);
                FirstMainMeActivity.this.finish();
                DestoryDialogs();
                break;
            //--修改密码
            case R.id.medialog_updatepassword_btn:
                Intent updatepasswordintent = new Intent(FirstMainMeActivity.this, UpdatePasswordActivity.class);
                startActivity(updatepasswordintent);
                overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                DestoryDialogs();
                break;

        }


    }

    //--底部弹出框
    public void MyPoPuWindow() {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.me_popuwindow, null);
        window = new PopupWindow(view,
                ViewGroup.LayoutParams.MATCH_PARENT, 500);
        // ---设置可以点击---
        window.setFocusable(true);
        // ---设置弹出时的动画---
        window.setAnimationStyle(R.style.mypopuwindow);
        window.showAtLocation(view, Gravity.BOTTOM, 0, 0);
        //--头像设置取消按钮
        btn_back = (Button) view.findViewById(R.id.btn_back);
        btn_back.setOnClickListener(this);
        //--头像设置从相册获取
        btn_capture = (Button) view.findViewById(R.id.btn_capture);
        btn_capture.setOnClickListener(this);
        //--头像设置拍照
        btn_camera = (Button) view.findViewById(R.id.btn_camera);
        btn_camera.setOnClickListener(this);
        //--底部弹出框消失时，设置窗体透明度
        window.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                SetBackgroundalph(1.0f);
            }
        });
    }

    public void onActivityResult(int req, int res, Intent data) {
        switch (req) {
            /**
             * 拍照的请求标志
             */
            case PHOTO_REQUEST_CAMERA:
                try {
                    crop(imageUri);
                } catch (Exception e) {

                    ToastUtils.show(FirstMainMeActivity.this, "程序崩溃", Toast.LENGTH_SHORT);
                }
                break;
            /**
             * 从相册中选取图片的请求标志
             */
            case PHOTO_REQUEST_GALLERY:
                try {
                    /**
                     * 该uri是上一个Activity返回的
                     */
                    Uri uri = data.getData();
                    //--剪切图片
                    crop(uri);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case PHOTO_REQUEST_CUT:
                bitmap = data.getParcelableExtra("data");
                me_imagebtn.setImageBitmap(bitmap);
                meactivityback_menu.setImageBitmap(bitmap);
                menu_circleimage.setImageBitmap(bitmap);

            default:
                break;
        }
    }

    /**
     * 在activity消失时要取消dialog，window,popuwidnow，这些附属在activity上的窗口
     */
    public void DestoryDialogs() {
        if (window != null && window.isShowing()) {
            window.dismiss();
        } else if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        DestoryDialogs();
        if (myHorizontalScrollView.isopen()) {
            myHorizontalScrollView.closemenu();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (myHorizontalScrollView.isopen()) {
                myHorizontalScrollView.closemenu();

            } else {
                FirstMainMeActivity.this.finish();
                overridePendingTransition(R.animator.animation_in, R.animator.animation_out);

            }
        }
        return false;
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        initview();
    }
}
