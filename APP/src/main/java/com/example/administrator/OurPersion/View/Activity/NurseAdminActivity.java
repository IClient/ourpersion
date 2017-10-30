package com.example.administrator.OurPersion.View.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.administrator.OurPersion.Application.AndroidApplication;
import com.example.administrator.OurPersion.Model.Bean.AllOldManPlan;
import com.example.administrator.OurPersion.Model.Bean.OkHttpURL;
import com.example.administrator.OurPersion.Presenter.NurseAdminExPandAbleListview;
import com.example.administrator.OurPersion.SelfView.CircleImageView;
import com.example.administrator.OurPersion.R;
import com.example.administrator.OurPersion.SelfView.MyHorizontalScrollView;
import com.example.administrator.OurPersion.Utils.ToastUtils;
import com.example.administrator.OurPersion.View.Dialog.DatePickerDialog;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NurseAdminActivity extends BaseActivity implements View.OnClickListener {
    MyHorizontalScrollView myHorizontalScrollView;
    //--菜单用户名字
    TextView textView;
    CircleImageView menu_image;
    ExpandableListView expandableListView;
    CircleImageView nurseadminback_menu;
    ImageButton nurseadmin_datepicker;
    int year;
    int month;
    int day;
    String time;
    NurseAdminExPandAbleListview adapter;
    AllOldManPlan allOldManPlan;
    SearchView searchView;
    //--搜索数据
    AllOldManPlan myallOldManPlan;
    List<AllOldManPlan.AllOldManPlanBean> list;
    //--加载更多数据
    AllOldManPlan allOldManPlantwo;
    int page = 1;
    View view;
    ProgressBar nurse_progressbar;
    TextView nurse_text;
    Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if ((int) msg.obj == 1) {
                dissdialog();
                if (page == 1) {
                    nurse_text.setVisibility(View.VISIBLE);
                    nurse_text.setText("正在加载...");
                    nurse_progressbar.setVisibility(View.VISIBLE);
                    adapter = new NurseAdminExPandAbleListview(NurseAdminActivity.this, allOldManPlan);
                    expandableListView.setAdapter(adapter);
                    for (int i = 0; i < adapter.getGroupCount(); i++) {
                        expandableListView.expandGroup(i);
                    }


                } else if (page > 1) {

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            nurse_text.setVisibility(View.VISIBLE);
                            nurse_text.setText("正在加载...");
                            nurse_progressbar.setVisibility(View.VISIBLE);
                            for (int i = 0; i < allOldManPlantwo.getAllOldManPlan().size(); i++) {
                                allOldManPlan.getAllOldManPlan().add(allOldManPlantwo.getAllOldManPlan().get(i));

                            }
                            for (int i = 0; i < adapter.getGroupCount(); i++) {
                                expandableListView.expandGroup(i);
                            }
                            adapter.notifyDataSetChanged();

                        }
                    }, 2000);


                }

            } else if ((int) msg.obj == 2)

            {
                dissdialog();
                nurse_text.setVisibility(View.VISIBLE);
                nurse_text.setText("获取数据失败!");
                nurse_progressbar.setVisibility(View.GONE);
            } else if ((int) msg.obj == 3 && page > 1)

            {
                nurse_text.setVisibility(View.VISIBLE);
                nurse_text.setText("没有更多数据拉！");
                nurse_progressbar.setVisibility(View.GONE);
                adapter.notifyDataSetChanged();
            } else if ((int) msg.obj == 3 && page == 1)

            {
                dissdialog();
                nurse_text.setVisibility(View.GONE);
                nurse_progressbar.setVisibility(View.GONE);
                ToastUtils.show(NurseAdminActivity.this, "暂时没有护理计划", Toast.LENGTH_SHORT);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nurse);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        time = format.format(new Date());
        AndroidApplication application = (AndroidApplication) getApplication();
        application.addactivity(NurseAdminActivity.this);
        //---初始化控件
        initview();
        gethttp();
        showdialog(NurseAdminActivity.this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //--打开菜单
            case R.id.nurseadminback_menu:
                if (!myHorizontalScrollView.isopen()) {
                    myHorizontalScrollView.openmenu();
                }
                break;
            //--根据日期查询计划
            case R.id.nurseadmin_datepicker:
                final DatePickerDialog dialog = new DatePickerDialog(NurseAdminActivity.this, R.style.MyDialog, R.layout.datepicker_dialog);
                dialog.show();
                SetBackgroundalph(0.7f);
                dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        SetBackgroundalph(1.0f);
                    }
                });
                CalendarView datePicker = (CalendarView) dialog.findViewById(R.id.datePicker);
                Calendar calendar = Calendar.getInstance();
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                day = calendar.get(Calendar.DAY_OF_MONTH);
                datePicker.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                    @Override
                    public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                        NurseAdminActivity.this.year = year;
                        NurseAdminActivity.this.month = month;
                        NurseAdminActivity.this.day = dayOfMonth;
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
                        searchView.setQueryHint("");
                        myallOldManPlan = null;
                        page = 1;
                        time = year + "-" + (month + 1) + "-" + day;
                        gethttp();
                        dialog.dismiss();

                    }
                });

                break;
            //--护理管理
            case R.id.nurseadmin_btn:
                if (myHorizontalScrollView.isopen()) {
                    myHorizontalScrollView.closemenu();
                }
                break;
            //--老人管理
            case R.id.oldmanadmin_btn:
                if (myHorizontalScrollView.isopen()) {
                    Intent intent1 = new Intent(NurseAdminActivity.this, OldManListActivity.class);
                    startActivity(intent1);
                    this.finish();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            case R.id.staffadmin_btn:
                if (myHorizontalScrollView.isopen()) {
                    Intent staffintent = new Intent(NurseAdminActivity.this, StaffAdminActivity.class);
                    startActivity(staffintent);
                    NurseAdminActivity.this.finish();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            case R.id.bedadmin_btn:
                if (myHorizontalScrollView.isopen()) {
                    Intent bedintent = new Intent(NurseAdminActivity.this, BedAdminActivity.class);
                    startActivity(bedintent);
                    NurseAdminActivity.this.finish();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            case R.id.messagesend_btn:
                if (myHorizontalScrollView.isopen()) {
                    Intent bedintent = new Intent(NurseAdminActivity.this, MessageActivity.class);
                    startActivity(bedintent);
                    NurseAdminActivity.this.finish();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
        }

    }

    //--初始化菜单按钮
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
        myHorizontalScrollView = (MyHorizontalScrollView) findViewById(R.id.nurseadmin_scrollview);
        textView = (TextView) findViewById(R.id.user_name);
        textView.setText(user.getEmployeeName().toString());
        menu_image = (CircleImageView) findViewById(R.id.menu_circleimage);
        Picasso.with(NurseAdminActivity.this).load(OkHttpURL.ImageURL + user.getImgPath()).placeholder(R.mipmap.default_image).into(menu_image);
        nurseadminback_menu = (CircleImageView) findViewById(R.id.nurseadminback_menu);
        Picasso.with(NurseAdminActivity.this).load(OkHttpURL.ImageURL + user.getImgPath()).placeholder(R.mipmap.default_image).into(nurseadminback_menu);
        nurseadminback_menu.setOnClickListener(this);
        nurseadmin_datepicker = (ImageButton) findViewById(R.id.nurseadmin_datepicker);
        nurseadmin_datepicker.setOnClickListener(this);
        //--获取expandableListView
        expandableListView = (ExpandableListView) findViewById(R.id.nurseadmin_explistview);
        view = LayoutInflater.from(NurseAdminActivity.this).inflate(R.layout.nurseadmin_loadmore_item, null);
        nurse_progressbar = (ProgressBar) view.findViewById(R.id.nurse_progressbar);
        nurse_text = (TextView) view.findViewById(R.id.nurse_text);
        //--添加一个尾布局
        expandableListView.addFooterView(view);
        expandableListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                switch (scrollState) {
                    // 当不滚动时
                    case AbsListView.OnScrollListener.SCROLL_STATE_IDLE:
                        // 判断滚动到底部
                        if (view.getLastVisiblePosition() == (view.getCount() - 1) && myallOldManPlan == null) {
                            page = page + 1;
                            gethttp();
                        }
                        break;
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount) {


            }
        });
        searchView = (SearchView) findViewById(R.id.nurseadmin_searchView);
        //--根据老人姓名搜索
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (allOldManPlan != null) {
                    if (!TextUtils.isEmpty(newText)) {
                        nurse_text.setVisibility(View.GONE);
                        nurse_progressbar.setVisibility(View.GONE);
                        myallOldManPlan = new AllOldManPlan();
                        list = new ArrayList<>();
                        for (int i = 0; i < allOldManPlan.getAllOldManPlan().size(); i++) {
                            if (allOldManPlan.getAllOldManPlan().get(i).getCustomerName().startsWith(newText)) {
                                list.add(allOldManPlan.getAllOldManPlan().get(i));
                            }
                        }
                        myallOldManPlan.setAllOldManPlan(list);
                        adapter = new NurseAdminExPandAbleListview(NurseAdminActivity.this, myallOldManPlan);
                        expandableListView.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                        //默认展开
                        for (int i = 0; i < adapter.getGroupCount(); i++) {
                            expandableListView.expandGroup(i);

                        }
                    } else {
                        nurse_text.setVisibility(View.VISIBLE);
                        nurse_text.setText("正在加载...");
                        nurse_progressbar.setVisibility(View.VISIBLE);
                        myallOldManPlan = null;
                        adapter = new NurseAdminExPandAbleListview(NurseAdminActivity.this, allOldManPlan);
                        expandableListView.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                        //默认展开
                        for (int i = 0; i < adapter.getGroupCount(); i++) {
                            expandableListView.expandGroup(i);

                        }
                    }
                }
                return false;
            }
        });


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (myHorizontalScrollView.isopen()) {
                myHorizontalScrollView.closemenu();
            } else {
                NurseAdminActivity.this.finish();
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
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(15, TimeUnit.SECONDS).connectTimeout(15, TimeUnit.SECONDS).build();
        Request request = new Request.Builder().get().url("http://192.168.10.7:7006/api/NursingApi/ApiGetAllNursingPlan?dateSign=" + time + "&pageIndex=" + page).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                if (result.equals("[]")) {
                    Message message = new Message();
                    message.obj = 3;
                    handler.sendMessage(message);
                    return;
                }
                try {
                    JSONObject jsonObject = new JSONObject(result);
                    if (jsonObject.has("Message")) {
                        Message message = new Message();
                        message.obj = 2;
                        handler.sendMessage(message);
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String s = "{\"AllOldManPlan\":";
                StringBuffer sb = new StringBuffer(result);
                sb.insert(0, s);
                String data = sb.toString() + "}".trim();
                if (page == 1) {
                    Gson gson = new Gson();
                    allOldManPlan = gson.fromJson(data, AllOldManPlan.class);
                    Message message = new Message();
                    message.obj = 1;
                    handler.sendMessage(message);
                } else {
                    Gson gson = new Gson();
                    allOldManPlantwo = gson.fromJson(data, AllOldManPlan.class);
                    Message message = new Message();
                    message.obj = 1;
                    handler.sendMessage(message);
                }


            }
        });

    }

}






