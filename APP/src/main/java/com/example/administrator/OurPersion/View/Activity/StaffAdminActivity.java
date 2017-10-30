package com.example.administrator.OurPersion.View.Activity;


import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.OurPersion.Application.AndroidApplication;
import com.example.administrator.OurPersion.Model.Bean.FloorMessage;
import com.example.administrator.OurPersion.Model.Bean.OkHttpURL;
import com.example.administrator.OurPersion.Model.Bean.Work;
import com.example.administrator.OurPersion.Presenter.StaffAdminExpandable;
import com.example.administrator.OurPersion.SelfView.BedMyHorizontalScrollView;
import com.example.administrator.OurPersion.SelfView.CircleImageView;
import com.example.administrator.OurPersion.R;
import com.example.administrator.OurPersion.SelfView.MyHorizontalScrollView;
import com.example.administrator.OurPersion.Utils.ToastUtils;
import com.example.administrator.OurPersion.View.Dialog.BedAdminAddiconDialog;
import com.example.administrator.OurPersion.View.Dialog.DatePickerDialog;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class StaffAdminActivity extends BaseActivity implements View.OnClickListener {
    //--菜单用户名字
    TextView user_name;
    CircleImageView menu_image;
    MyHorizontalScrollView myHorizontalScrollView;
    //--内容
    CircleImageView staffadminctivityback_menu;
    ImageButton staffadminctivityback_addaction;
    BedAdminAddiconDialog dialog;
    BedMyHorizontalScrollView bedMyHorizontalScrollView;
    FloorMessage floorMessage;
    //--表示切换单元的时候是那个单元
    int position;
    //--表示切换楼栋的时候是那个楼栋
    int unitsssposition;
    //--单元按钮的id
    int unitit[] = {1110, 1111, 1112, 1113, 1114, 1115, 1116, 1117};
    //--楼栋按钮id
    int unititsss[] = {1110, 1111, 1112, 1113, 1114, 1115, 1116, 1117};
    int image[] = {R.mipmap.one, R.mipmap.two, R.mipmap.three, R.mipmap.four, R.mipmap.five, R.mipmap.six};
    ExpandableListView expandableListView;
    StaffAdminExpandable expandable;
    /**
     * count 表示楼层数，多个楼层请求多少次
     * floorid楼层id
     * work排班对象
     * list排班集合
     */
    int count = 0;
    String floorid;
    Work work;
    List<Work> list = new ArrayList<>();
    int year;
    int month;
    int day;
    boolean isshodialog = false;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if ((int) msg.obj == 1) {
                unitsssposition = floorMessage.getFloormessage().size() - 1;
                position = floorMessage.getFloormessage().get(unitsssposition).getUnits().size() - 1;
                HandlerDo();
            } else if ((int) msg.obj == 2) {
                ToastUtils.show(StaffAdminActivity.this, "获取数据失败", Toast.LENGTH_SHORT);

            } else if ((int) msg.obj == 3) {
                list.add(work);
                ++count;
                if (count == floorMessage.getFloormessage().get(unitsssposition).getUnits().get(position).getFloors().size()) {
                    dissdialog();
                    expandable = new StaffAdminExpandable(StaffAdminActivity.this, floorMessage.getFloormessage().get(unitsssposition).getUnits().get(position).getFloors(), list);
                    expandableListView.setAdapter(expandable);
                    for (int i = 0; i < expandable.getGroupCount(); i++) {
                        expandableListView.expandGroup(i);

                    }
                }

            } else if ((int) msg.obj == 4) {
                ToastUtils.show(StaffAdminActivity.this, "暂无排班", Toast.LENGTH_SHORT);

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_admin);
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        AndroidApplication application = (AndroidApplication) getApplication();
        application.addactivity(StaffAdminActivity.this);
        initview();
        gethttp();

    }


    public void initview() {
        myHorizontalScrollView = (MyHorizontalScrollView) findViewById(R.id.staffadmin_scrollview);
        nurseadmin_btn = (Button) findViewById(R.id.nurseadmin_btn);
        nurseadmin_btn.setOnClickListener(this);
        oldmanadmin_btn = (Button) findViewById(R.id.oldmanadmin_btn);
        oldmanadmin_btn.setOnClickListener(this);
        staffadmin_btn = (Button) findViewById(R.id.staffadmin_btn);
        staffadmin_btn.setOnClickListener(this);
        messagesend_btn = (Button) findViewById(R.id.messagesend_btn);
        messagesend_btn.setOnClickListener(this);
        user_name = (TextView) findViewById(R.id.user_name);
        user_name.setText(user.getEmployeeName());
        bedadmin_btn = (Button) findViewById(R.id.bedadmin_btn);
        bedadmin_btn.setOnClickListener(this);
        menu_image = (CircleImageView) findViewById(R.id.menu_circleimage);
        Picasso.with(StaffAdminActivity.this).load(OkHttpURL.ImageURL + user.getImgPath()).placeholder(R.mipmap.default_image).into(menu_image);
        staffadminctivityback_menu = (CircleImageView) findViewById(R.id.staffadminctivityback_menu);
        staffadminctivityback_menu.setOnClickListener(this);
        Picasso.with(StaffAdminActivity.this).load(OkHttpURL.ImageURL + user.getImgPath()).placeholder(R.mipmap.default_image).into(staffadminctivityback_menu);
        staffadminctivityback_addaction = (ImageButton) findViewById(R.id.staffadminctivityback_addaction);
        staffadminctivityback_addaction.setOnClickListener(this);
        bedMyHorizontalScrollView = (BedMyHorizontalScrollView) findViewById(R.id.staffadmin_horizonscrollview);
        expandableListView = (ExpandableListView) findViewById(R.id.staffadmin_activity_expandbale);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.nurseadmin_btn:
                if (myHorizontalScrollView.isopen()) {
                    Intent nurseintent = new Intent(StaffAdminActivity.this, NurseAdminActivity.class);
                    startActivity(nurseintent);
                    StaffAdminActivity.this.finish();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            case R.id.oldmanadmin_btn:
                if (myHorizontalScrollView.isopen()) {
                    Intent oldmanintent = new Intent(StaffAdminActivity.this, OldManListActivity.class);
                    startActivity(oldmanintent);
                    StaffAdminActivity.this.finish();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            case R.id.bedadmin_btn:
                if (myHorizontalScrollView.isopen()) {
                    Intent bedintent = new Intent(StaffAdminActivity.this, BedAdminActivity.class);
                    startActivity(bedintent);
                    StaffAdminActivity.this.finish();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            case R.id.messagesend_btn:
                if (myHorizontalScrollView.isopen()) {
                    Intent bedintent = new Intent(StaffAdminActivity.this, MessageActivity.class);
                    startActivity(bedintent);
                    StaffAdminActivity.this.finish();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            case R.id.staffadmin_btn:
                if (myHorizontalScrollView.isopen()) {
                    myHorizontalScrollView.closemenu();
                }
                break;
            case R.id.staffadminctivityback_menu:
                if (!myHorizontalScrollView.isopen()) {
                    myHorizontalScrollView.openmenu();
                }
                break;
            case R.id.staffadminctivityback_addaction:
                if (!isshodialog) {
                    dialog = new BedAdminAddiconDialog(StaffAdminActivity.this, R.style.MyDialog, R.layout.bedadmin_addicon_dialog);
                    dialog.show();
                    SetBackgroundalph(0.8f);
                    dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                        @Override
                        public void onDismiss(DialogInterface dialog) {
                            SetBackgroundalph(1.0f);
                        }
                    });
                    LinearLayout linearLayout = (LinearLayout) dialog.findViewById(R.id.add_units);
                    linearLayout.setWeightSum(floorMessage.getFloormessage().size() + 1);
                    linearLayout.setGravity(Gravity.CENTER);
                    linearLayout.setOrientation(LinearLayout.VERTICAL);
                    for (int i = 0; i < floorMessage.getFloormessage().size(); i++) {
                        final Button button = new Button(StaffAdminActivity.this);
                        button.setText(floorMessage.getFloormessage().get(i).getBuildingName().substring(0, 3));
                        button.setBackground(null);
                        button.setId(unititsss[i]);
                        //--默认展示的亲睦家
                        if (i == floorMessage.getFloormessage().size() - 1) {
                            button.setTextColor(Color.RED);
                        }
                        button.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f));
                        button.setPadding(10, 10, 0, 0);
                        Drawable images = getResources().getDrawable(image[i]);
                        images.setBounds(0, 0, images.getMinimumWidth(), images.getMinimumHeight());
                        button.setCompoundDrawables(images, null, null, null);
                        linearLayout.addView(button);
                        button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                for (int m = 0; m < floorMessage.getFloormessage().size(); m++) {
                                    String unitid = v.getId() + "";
                                    if (unitid.substring(unitid.length() - 1, unitid.length()).equals(m + "")) {
                                        button.setTextColor(Color.RED);
                                        unitsssposition = m;
                                        position = floorMessage.getFloormessage().get(unitsssposition).getUnits().size() - 1;
                                        dialog.dismiss();
                                        list.clear();
                                        work = null;
                                        count = 0;
                                        bedMyHorizontalScrollView.removeAllViews();
                                        HandlerDo();
                                    }
                                }
                            }
                        });
                        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                            @Override
                            public void onDismiss(DialogInterface dialog) {
                                SetBackgroundalph(1.0f);

                            }
                        });

                    }
                    Button button = new Button(StaffAdminActivity.this);
                    button.setText("选择日期");
                    button.setBackground(null);
                    button.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f));
                    button.setPadding(10, 10, 0, 0);
                    Drawable images = getResources().getDrawable(image[floorMessage.getFloormessage().size()]);
                    images.setBounds(0, 0, images.getMinimumWidth(), images.getMinimumHeight());
                    button.setCompoundDrawables(images, null, null, null);
                    linearLayout.addView(button);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                            final DatePickerDialog dialog = new DatePickerDialog(StaffAdminActivity.this, R.style.MyDialog, R.layout.datepicker_dialog);
                            dialog.show();
                            SetBackgroundalph(0.8f);
                            CalendarView datePicker = (CalendarView) dialog.findViewById(R.id.datePicker);
                            Calendar calendar = Calendar.getInstance();
                            year = calendar.get(Calendar.YEAR);
                            month = calendar.get(Calendar.MONTH);
                            day = calendar.get(Calendar.DAY_OF_MONTH);
                            datePicker.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                                @Override
                                public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                                    StaffAdminActivity.this.year = year;
                                    StaffAdminActivity.this.month = month;
                                    StaffAdminActivity.this.day = dayOfMonth;
                                }
                            });

                            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                                @Override
                                public void onDismiss(DialogInterface dialog) {
                                    SetBackgroundalph(1.0f);
                                }
                            });
                            Button nobtn = (Button) dialog.findViewById(R.id.datepicker_dialog_no);
                            nobtn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    dialog.dismiss();
                                }
                            });
                            Button yesbtn = (Button) dialog.findViewById(R.id.datepicker_dialog_yes);
                            yesbtn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    list.clear();
                                    work = null;
                                    count = 0;
                                    bedMyHorizontalScrollView.removeAllViews();
                                    HandlerDo();
                                    dialog.dismiss();

                                }
                            });
                        }
                    });
                    isshodialog = true;
                } else {
                    dialog.show();
                    SetBackgroundalph(0.8f);
                    for (int i = 0; i < floorMessage.getFloormessage().size(); i++) {
                        if (i != unitsssposition) {
                            Button btn = (Button) dialog.findViewById(unititsss[i]);
                            btn.setTextColor(Color.BLACK);

                        }

                    }
                }
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (myHorizontalScrollView.isopen()) {
                myHorizontalScrollView.closemenu();

            } else {
                StaffAdminActivity.this.finish();
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

    public void gethttp() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(15, TimeUnit.SECONDS).readTimeout(15, TimeUnit.SECONDS).build();
        Request request = new Request.Builder().get().url("http://192.168.10.7:7006/api/BaseData/GetBuildUnitFloor?Token={Token}").build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                if (result.equals("\"[]\"")) {
                    Message message = new Message();
                    message.obj = 2;
                    handler.sendMessage(message);
                    return;

                }
                result = result.replace("\\", "").toString().trim();
                result = result.substring(1, result.length());
                result = result.substring(0, result.length() - 1);
                String s = "{\"floormessage\":";
                StringBuffer sb = new StringBuffer(result);
                sb.insert(0, s);
                String dataresult = sb.toString() + "}";
                Gson gson = new Gson();
                floorMessage = gson.fromJson(dataresult, FloorMessage.class);
                Message message = new Message();
                message.obj = 1;
                handler.sendMessage(message);

            }
        });


    }

    public void HandlerDo() {
        LinearLayout linearLayout = new LinearLayout(StaffAdminActivity.this);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        linearLayout.setWeightSum(floorMessage.getFloormessage().get(unitsssposition).getUnits().size());
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        bedMyHorizontalScrollView.addView(linearLayout);
        int k = floorMessage.getFloormessage().get(unitsssposition).getUnits().size() - 1;
        for (int i = floorMessage.getFloormessage().get(unitsssposition).getUnits().size() - 1; i >= 0; i--) {
            final Button button = new Button(StaffAdminActivity.this);
            button.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f));
            button.setText(floorMessage.getFloormessage().get(unitsssposition).getUnits().get(i).getUnitName());
            button.setBackground(null);
            button.setId(unitit[k]);
            k--;
            button.setTextColor(Color.parseColor("#66000000"));
            button.setGravity(Gravity.CENTER);
            linearLayout.addView(button);
// --点击单元切换,用取巧的方法根据button的id判断点击的是第几单元然后来切换数据
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for (int m = 0; m < floorMessage.getFloormessage().get(unitsssposition).getUnits().size(); m++) {
                        String unitid = v.getId() + "";
                        if (unitid.substring(unitid.length() - 1, unitid.length()).equals(m + "")) {
                            position = m;
                            Button buttonbe2 = (Button) findViewById(unitit[m]);
                            buttonbe2.setTextSize(16);
                            buttonbe2.setTextColor(Color.BLACK);
                            for (int n = 0; n < floorMessage.getFloormessage().get(unitsssposition).getUnits().size(); n++) {
                                if (m != n) {
                                    Button button1 = (Button) findViewById(unitit[n]);
                                    button1.setTextSize(14);
                                    button1.setTextColor(Color.GRAY);
                                }
                            }
                            list.clear();
                            work = null;
                            count = 0;
                            showdialog(StaffAdminActivity.this);

                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    for (int i = 0; i < floorMessage.getFloormessage().get(unitsssposition).getUnits().get(position).getFloors().size(); i++) {
                                        floorid = floorMessage.getFloormessage().get(unitsssposition).getUnits().get(position).getFloors().get(i).getId();
                                        gethttptwo();
                                    }
                                }
                            }).start();


                        }
                    }
                }

            });
        }
        Button button = (Button) findViewById(unitit[position]);
        button.setTextSize(16);
        button.setTextColor(Color.BLACK);
        showdialog(StaffAdminActivity.this);


        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < floorMessage.getFloormessage().get(unitsssposition).getUnits().get(position).getFloors().size(); i++) {
                    floorid = floorMessage.getFloormessage().get(unitsssposition).getUnits().get(position).getFloors().get(i).getId();
                    gethttptwo();
                }
            }
        }).start();


    }

    /**
     * android的UI规则
     * 不要阻塞UI线程
     * 这里使用同步请求,由于同步会线程阻塞，所以必须在子线程中进行,异步循环请求数据会混乱
     */
    public void gethttptwo() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(15, TimeUnit.SECONDS).readTimeout(15, TimeUnit.SECONDS).build();
        Request request = new Request.Builder().get().url("http://192.168.10.7:7006/api/Employee/GetGroupDateFormForDay?year=" + year + "+&month=" + (month + 1) + "&day=" + day + "&floorid=" + floorid).build();
        Call call = okHttpClient.newCall(request);
        try {
            Response response = call.execute();
            if (response.code() == 200) {
                String result = response.body().string();
                String s = "{\"work\":";
                StringBuffer sb = new StringBuffer(result);
                sb.insert(0, s);
                String dataresult = sb.toString() + "}";
                Gson gson = new Gson();
                work = gson.fromJson(dataresult, Work.class);
                Message message = new Message();
                message.obj = 3;
                handler.sendMessage(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
