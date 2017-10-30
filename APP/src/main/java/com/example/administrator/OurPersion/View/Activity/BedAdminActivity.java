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
import android.widget.ExpandableListView;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.OurPersion.Application.AllBedAdminActivity;

import com.example.administrator.OurPersion.Model.Bean.Bed;
import com.example.administrator.OurPersion.Model.Bean.OkHttpURL;
import com.example.administrator.OurPersion.Presenter.BedAdminExpandable;
import com.example.administrator.OurPersion.R;
import com.example.administrator.OurPersion.SelfView.CircleImageView;
import com.example.administrator.OurPersion.SelfView.MyHorizontalScrollView;
import com.example.administrator.OurPersion.Utils.ToastUtils;
import com.example.administrator.OurPersion.View.Dialog.BedAdminAddiconDialog;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class BedAdminActivity extends BaseActivity implements View.OnClickListener {
    BedAdminAddiconDialog dialog;
    BedAdminExpandable expandable;
    ExpandableListView listView;
    ImageButton imageButton;
    MyHorizontalScrollView myHorizontalScrollView;
    CircleImageView activity_bed_admin_menu;
    //--菜单用户名字，头像
    TextView user_name;
    CircleImageView menu_circleimage;
    Bed bed;
    //--楼层数，以及楼层对应的房间
    List<List<Bed.UnitBean.UnitsBean.FloorsBean.RoomsBean>> lists = new ArrayList<>();
    //--楼层信息
    List<Bed.UnitBean.UnitsBean.FloorsBean> floorsBeanList = new ArrayList<>();
    HorizontalScrollView horizontalScrollView;
    //--单元按钮的id
    int unitit[] = {1110, 1111, 1112, 1113, 1114, 1115, 1116, 1117};
    //--楼栋按钮id
    int unititsss[] = {1110, 1111, 1112, 1113, 1114, 1115, 1116, 1117};
    //--表示切换单元的时候是那个单元
    int position;
    //--表示切换楼栋的时候是那个楼栋
    int unitsssposition;
    int image[] = {R.mipmap.one, R.mipmap.two, R.mipmap.three, R.mipmap.four, R.mipmap.five, R.mipmap.six};
    boolean isshodialog = false;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if ((int) msg.obj == 1) {
                unitsssposition = bed.getUnit().size() - 1;
                position = bed.getUnit().get(unitsssposition).getUnits().size() - 1;
                dissdialog();
                HandlerDo();
            } else if ((int) msg.obj == bed.getUnit().size() - 1) {
                dissdialog();
                ToastUtils.show(BedAdminActivity.this, "获取数据失败", Toast.LENGTH_SHORT);
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bed_admin);
        AllBedAdminActivity.AddActivity(BedAdminActivity.this);
        initview();
        showdialog(BedAdminActivity.this);
        GetDataFromHttp();

    }

    public void initview() {
        horizontalScrollView = (HorizontalScrollView) findViewById(R.id.bed_horizonscrollview);
        myHorizontalScrollView = (MyHorizontalScrollView) findViewById(R.id.activity_bed_admin_scrollview);
        listView = (ExpandableListView) findViewById(R.id.bed_activity_expandbale);
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
        Picasso.with(BedAdminActivity.this).load(OkHttpURL.ImageURL + user.getImgPath()).placeholder(R.mipmap.default_image).into(menu_circleimage);
        activity_bed_admin_menu = (CircleImageView) findViewById(R.id.activity_bed_admin_menu);
        activity_bed_admin_menu.setOnClickListener(this);
        Picasso.with(BedAdminActivity.this).load(OkHttpURL.ImageURL + user.getImgPath()).placeholder(R.mipmap.default_image).into(activity_bed_admin_menu);
        imageButton = (ImageButton) findViewById(R.id.bedadmin_morebtn);
        imageButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.nurseadmin_btn:
                if (myHorizontalScrollView.isopen()) {
                    Intent nurseintent = new Intent(BedAdminActivity.this, NurseAdminActivity.class);
                    startActivity(nurseintent);
                    BedAdminActivity.this.finish();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            case R.id.oldmanadmin_btn:
                if (myHorizontalScrollView.isopen()) {
                    Intent oldmanintent = new Intent(BedAdminActivity.this, OldManListActivity.class);
                    startActivity(oldmanintent);
                    BedAdminActivity.this.finish();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            case R.id.staffadmin_btn:
                if (myHorizontalScrollView.isopen()) {
                    Intent staffintent = new Intent(BedAdminActivity.this, StaffAdminActivity.class);
                    startActivity(staffintent);
                    BedAdminActivity.this.finish();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            case R.id.messagesend_btn:
                if (myHorizontalScrollView.isopen()) {
                    Intent staffintent = new Intent(BedAdminActivity.this, MessageActivity.class);
                    startActivity(staffintent);
                    BedAdminActivity.this.finish();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            case R.id.bedadmin_btn:
                if (myHorizontalScrollView.isopen()) {
                    myHorizontalScrollView.closemenu();
                }
                break;
            case R.id.activity_bed_admin_menu:
                if (!myHorizontalScrollView.isopen()) {
                    myHorizontalScrollView.openmenu();
                }
                break;
            case R.id.bedadmin_morebtn:
                imageButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!isshodialog) {
                            if (bed != null) {
                                dialog = new BedAdminAddiconDialog(BedAdminActivity.this, R.style.MyDialog, R.layout.bedadmin_addicon_dialog);
                                dialog.show();
                                LinearLayout linearLayout = (LinearLayout) dialog.findViewById(R.id.add_units);
                                linearLayout.setWeightSum(bed.getUnit().size());
                                linearLayout.setGravity(Gravity.CENTER);
                                linearLayout.setOrientation(LinearLayout.VERTICAL);
                                for (int i = 0; i < bed.getUnit().size(); i++) {
                                  final  Button button = new Button(BedAdminActivity.this);
                                    button.setText(bed.getUnit().get(i).getBuildingName().substring(0, 3));
                                    button.setBackground(null);
                                    button.setId(unititsss[i]);
                                    //--默认展示的亲睦家
                                    if (i == bed.getUnit().size() - 1) {
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
                                            for (int m = 0; m < bed.getUnit().size(); m++) {
                                                String unitid = v.getId() + "";
                                                if (unitid.substring(unitid.length() - 1, unitid.length()).equals(m + "")) {
                                                    button.setTextColor(Color.RED);
                                                    unitsssposition = m;
                                                    position = bed.getUnit().get(unitsssposition).getUnits().size() - 1;
                                                    dialog.dismiss();
                                                }
                                            }

                                        }
                                    });
                                }


                                SetBackgroundalph(0.8f);
                                dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                                    @Override
                                    public void onDismiss(DialogInterface dialog) {
                                        SetBackgroundalph(1.0f);
                                        horizontalScrollView.removeAllViews();
                                        HandlerDo();
                                    }
                                });
                            } else {
                                ToastUtils.show(BedAdminActivity.this, "获取数据失败", Toast.LENGTH_SHORT);

                            }
                            isshodialog = true;
                        } else {
                            dialog.show();
                            for (int i = 0; i < bed.getUnit().size(); i++) {
                                if (i != unitsssposition) {
                                    Button button = (Button) dialog.findViewById(unititsss[i]);
                                    button.setTextColor(Color.BLACK);

                                }

                            }
                            SetBackgroundalph(0.8f);
                        }

                    }
                });
                break;
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
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
                BedAdminActivity.this.finish();
                overridePendingTransition(R.animator.animation_in, R.animator.animation_out);

            }
        }
        return false;
    }

    public void GetDataFromHttp() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(15, TimeUnit.SECONDS).writeTimeout(15, TimeUnit.SECONDS).build();
        Request request = new Request.Builder().get().url("http://192.168.10.7:7006/api/BaseData/GetBuildTree").build();
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
                String s = "{\"unit\":";
                StringBuffer sb = new StringBuffer(result);
                sb.insert(0, s);
                String dataresult = sb.toString() + "}";
                Gson gson = new Gson();
                bed = gson.fromJson(dataresult, Bed.class);
                Message message = new Message();
                message.obj = 1;
                handler.sendMessage(message);


            }
        });

    }

    //--获取床位列表成功后
    public void HandlerDo() {
        LinearLayout linearLayout = new LinearLayout(BedAdminActivity.this);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        linearLayout.setWeightSum(bed.getUnit().get(unitsssposition).getUnits().size());
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        horizontalScrollView.addView(linearLayout);
        int k = bed.getUnit().get(unitsssposition).getUnits().size() - 1;
        for (int i = bed.getUnit().get(unitsssposition).getUnits().size() - 1; i >= 0; i--) {
            final Button button = new Button(BedAdminActivity.this);
            button.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f));
            button.setText(bed.getUnit().get(unitsssposition).getUnits().get(i).getUnitName());
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
                    for (int m = 0; m < bed.getUnit().get(unitsssposition).getUnits().size(); m++) {
                        String unitid = v.getId() + "";
                        if (unitid.substring(unitid.length() - 1, unitid.length()).equals(m + "")) {
                            position = m;
                            Button buttonbe2 = (Button) findViewById(unitit[m]);
                            buttonbe2.setTextSize(16);
                            buttonbe2.setTextColor(Color.BLACK);
                            for (int n = 0; n < bed.getUnit().get(unitsssposition).getUnits().size(); n++) {
                                if (m != n) {
                                    Button button1 = (Button) findViewById(unitit[n]);
                                    button1.setTextSize(14);
                                    button1.setTextColor(Color.GRAY);
                                }
                            }
                            //--楼层信息
                            floorsBeanList.clear();
                            for (int i = 0; i < bed.getUnit().get(unitsssposition).getUnits().get(m).getFloors().size(); i++) {
                                floorsBeanList.add(bed.getUnit().get(unitsssposition).getUnits().get(m).getFloors().get(i));
                            }
                            //--每个单元对应的楼层数，以及房间信息
                            lists.clear();
                            for (int i = 0; i < bed.getUnit().get(unitsssposition).getUnits().get(m).getFloors().size(); i++) {
                                List<Bed.UnitBean.UnitsBean.FloorsBean.RoomsBean> list = new ArrayList<>();
                                for (int j = 0; j < bed.getUnit().get(unitsssposition).getUnits().get(m).getFloors().get(i).getRooms().size(); j++) {
                                    list.add(bed.getUnit().get(unitsssposition).getUnits().get(m).getFloors().get(i).getRooms().get(j));
                                }
                                lists.add(list);
                            }
                        }

                    }

                    expandable = new BedAdminExpandable(BedAdminActivity.this, lists, floorsBeanList, bed, position, unitsssposition);
                    listView.setAdapter(expandable);
                    for (int i = 0; i < expandable.getGroupCount(); i++) {
                        listView.expandGroup(i);

                    }
                    expandable.notifyDataSetChanged();
                }
            });
        }
//--设置默认的单元显示
        DefalutUnit();


    }

    //--默认的时候的数据
    public void DefalutUnit() {
        lists.clear();
        floorsBeanList.clear();
        //--一单元，楼层数和每个楼层的房间数,这里默认第一个表示楼栋，第二个表示单元，因为一单元是最后一个数据所以..
        for (int i = 0; i < bed.getUnit().get(unitsssposition).getUnits().get(position).getFloors().size(); i++) {
            List<Bed.UnitBean.UnitsBean.FloorsBean.RoomsBean> list = new ArrayList<>();
            for (int j = 0; j < bed.getUnit().get(unitsssposition).getUnits().get(position).getFloors().get(i).getRooms().size(); j++) {
                list.add(bed.getUnit().get(unitsssposition).getUnits().get(position).getFloors().get(i).getRooms().get(j));
            }
            lists.add(list);
        }
        //--一单元楼层数和楼层信息
        for (int i = 0; i < bed.getUnit().get(unitsssposition).getUnits().get(position).getFloors().size(); i++) {
            floorsBeanList.add(bed.getUnit().get(unitsssposition).getUnits().get(position).getFloors().get(i));
        }
        Button button = (Button) findViewById(unitit[position]);
        button.setTextSize(16);
        button.setTextColor(Color.BLACK);

        expandable = new BedAdminExpandable(BedAdminActivity.this, lists, floorsBeanList, bed, position, unitsssposition);
        listView.setAdapter(expandable);
        for (int i = 0; i < expandable.getGroupCount(); i++) {
            listView.expandGroup(i);

        }

    }

    @Override
    protected void onStop() {
        super.onStop();
        if (myHorizontalScrollView.isopen()) {
            myHorizontalScrollView.closemenu();
        }
    }
}
