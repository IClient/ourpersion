package com.example.administrator.OurPersion.View.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;


import com.example.administrator.OurPersion.Application.AllBedAdminActivity;
import com.example.administrator.OurPersion.Application.AllFirstMainActivity;
import com.example.administrator.OurPersion.Application.AllOldManActivity;
import com.example.administrator.OurPersion.Model.Bean.AreaOldMan;
import com.example.administrator.OurPersion.Model.Bean.BedOldMan;
import com.example.administrator.OurPersion.Model.Bean.OkHttpURL;
import com.example.administrator.OurPersion.Model.Bean.OldMan;
import com.example.administrator.OurPersion.Model.Bean.OldManEnterTime;
import com.example.administrator.OurPersion.Model.Bean.OldManExaminationData;
import com.example.administrator.OurPersion.R;
import com.example.administrator.OurPersion.SelfView.CircleImageView;
import com.example.administrator.OurPersion.SelfView.MyHorizontalScrollView;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OldManExaminationDataActivity extends BaseActivity implements View.OnClickListener {
    MyHorizontalScrollView horizontalScrollView;
    TextView menu_username;
    CircleImageView menu_image;
    TextView oldmanexaminationback_menu;
    OldMan.OldManListBean.DatasBean oldManListBean;
    CircleImageView oldman_examination_image;
    TextView oldman_examination_name;
    TextView oldman_examination_sex;
    BedOldMan bedOldMan;
    String oldid;
    AreaOldMan.AreaOldManBean areaOldManBean;
    //--没有数据时
    TextView oldmanexmination_t;
    LineChart lineChart;
    OldManExaminationData oldManExaminationData;
    //--体征数据切换的checkbox
    CheckBox shuzhangya;
    CheckBox shousuoya;
    CheckBox maibo;
    CheckBox tiwen;
    CheckBox huxi;
    CheckBox tizhong;
    CheckBox zhushiliang;
    CheckBox cailiang;
    CheckBox paibianliang;
    CheckBox pailiaoliang;
    List<String> titles = new ArrayList<>();
    List<CheckBox> checklist = new ArrayList<>();
    String checkidold;
    OldManEnterTime oldManEnterTime;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if ((int) msg.obj == 1) {
                oldmanexmination_t.setVisibility(View.GONE);
                lineChart.setVisibility(View.VISIBLE);
                SetShuZhangYaLineChart();
            } else if ((int) msg.obj == 2) {
                oldmanexmination_t.setVisibility(View.VISIBLE);
                lineChart.setVisibility(View.GONE);

            } else if ((int) msg.obj == 3) {
                Picasso.with(OldManExaminationDataActivity.this).load(OkHttpURL.ImageURL + oldManEnterTime.getOld().getImgPath()).placeholder(R.mipmap.oldone).into(oldman_examination_image);
                oldman_examination_name = (TextView) findViewById(R.id.oldman_examination_name);
                if (TextUtils.isEmpty(oldManEnterTime.getOld().getCustomerName())) {
                    oldman_examination_name.setText("");
                }
                oldman_examination_name.setText(oldManEnterTime.getOld().getCustomerName().toString());
                oldman_examination_sex = (TextView) findViewById(R.id.oldman_examination_sex);
                if (TextUtils.isEmpty(oldManEnterTime.getOld().getSex())) {
                    oldman_examination_sex.setText("");

                } else if (oldManEnterTime.getOld().getSex().equals("0")) {
                    oldman_examination_sex.setText("男");

                } else if (oldManEnterTime.getOld().getSex().equals("1")) {
                    oldman_examination_sex.setText("女");

                }
                gethttp();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_old_man_examination_data);
        //--获取最近一周的日期
        getTitles();
        oldManListBean = (OldMan.OldManListBean.DatasBean) getIntent().getSerializableExtra("oldManListBean");
        bedOldMan = (BedOldMan) getIntent().getSerializableExtra("oldman");
        areaOldManBean = (AreaOldMan.AreaOldManBean) getIntent().getSerializableExtra("firstmainoldman");
        checkidold = (String) getIntent().getSerializableExtra("checkidold");
        if (oldManListBean != null) {
            oldid = oldManListBean.getId().toString();
        } else if (bedOldMan != null) {
            oldid = bedOldMan.getOldId().toString();
        } else if (areaOldManBean != null) {
            oldid = areaOldManBean.getOlderId();
        } else {
            try {
                JSONObject jsonObject = new JSONObject(checkidold);
                oldid = jsonObject.getString("option1");
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
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
        horizontalScrollView = (MyHorizontalScrollView) findViewById(R.id.oldmanexamination_scrollview);
        menu_username = (TextView) findViewById(R.id.user_name);
        menu_username.setText(user.getEmployeeName().toString());
        menu_image = (CircleImageView) findViewById(R.id.menu_circleimage);
        Picasso.with(OldManExaminationDataActivity.this).load(OkHttpURL.ImageURL + user.getImgPath()).placeholder(R.mipmap.default_image).into(menu_image);
        oldmanexaminationback_menu = (TextView) findViewById(R.id.oldmanexaminationback_menu);
        oldmanexaminationback_menu.setOnClickListener(this);
        oldman_examination_image = (CircleImageView) findViewById(R.id.oldman_examination_image);
        oldmanexmination_t = (TextView) findViewById(R.id.oldmanexmination_t);
        lineChart = (LineChart) findViewById(R.id.oldmanexamination_data_linechart);
        shuzhangya = (CheckBox) findViewById(R.id.shuzhangya);
        shuzhangya.setChecked(true);
        shuzhangya.setOnClickListener(this);
        shousuoya = (CheckBox) findViewById(R.id.shousuoya);
        shousuoya.setOnClickListener(this);
        maibo = (CheckBox) findViewById(R.id.maibo);
        maibo.setOnClickListener(this);
        tiwen = (CheckBox) findViewById(R.id.tiwen);
        tiwen.setOnClickListener(this);
        huxi = (CheckBox) findViewById(R.id.huxi);
        huxi.setOnClickListener(this);
        tizhong = (CheckBox) findViewById(R.id.tizhong);
        tizhong.setOnClickListener(this);
        zhushiliang = (CheckBox) findViewById(R.id.zhushiliang);
        zhushiliang.setOnClickListener(this);
        cailiang = (CheckBox) findViewById(R.id.cailiang);
        cailiang.setOnClickListener(this);
        paibianliang = (CheckBox) findViewById(R.id.paibianliang);
        paibianliang.setOnClickListener(this);
        pailiaoliang = (CheckBox) findViewById(R.id.pailiaoliang);
        pailiaoliang.setOnClickListener(this);
        checklist.add(shuzhangya);
        checklist.add(shousuoya);
        checklist.add(maibo);
        checklist.add(tiwen);
        checklist.add(huxi);
        checklist.add(tizhong);
        checklist.add(zhushiliang);
        checklist.add(cailiang);
        checklist.add(paibianliang);
        checklist.add(pailiaoliang);
        //--老人列表传递过来的
        if (oldManListBean != null) {
            Picasso.with(OldManExaminationDataActivity.this).load(OkHttpURL.ImageURL + oldManListBean.getImgPath()).placeholder(R.mipmap.oldone).into(oldman_examination_image);
            oldman_examination_name = (TextView) findViewById(R.id.oldman_examination_name);
            if (TextUtils.isEmpty(oldManListBean.getCustomerName())) {
                oldman_examination_name.setText("");
            }
            oldman_examination_name.setText(oldManListBean.getCustomerName().toString());
            oldman_examination_sex = (TextView) findViewById(R.id.oldman_examination_sex);
            if (TextUtils.isEmpty(oldManListBean.getSex())) {
                oldman_examination_sex.setText("");

            } else if (oldManListBean.getSex().equals("0")) {
                oldman_examination_sex.setText("男");

            } else if (oldManListBean.getSex().equals("1")) {
                oldman_examination_sex.setText("女");

            }
            gethttp();

        }
        //--床位搜索列表传递过来的
        else if (bedOldMan != null) {
            Picasso.with(OldManExaminationDataActivity.this).load(OkHttpURL.ImageURL + bedOldMan.getOld().getImgPath()).placeholder(R.mipmap.oldone).into(oldman_examination_image);
            oldman_examination_name = (TextView) findViewById(R.id.oldman_examination_name);
            if (TextUtils.isEmpty(bedOldMan.getOld().getCustomerName())) {
                oldman_examination_name.setText("");
            }
            oldman_examination_name.setText(bedOldMan.getOld().getCustomerName().toString());
            oldman_examination_sex = (TextView) findViewById(R.id.oldman_examination_sex);
            if (TextUtils.isEmpty(bedOldMan.getOld().getSex())) {
                oldman_examination_sex.setText("");

            } else if (bedOldMan.getOld().getSex().equals("0")) {
                oldman_examination_sex.setText("男");

            } else if (bedOldMan.getOld().getSex().equals("1")) {
                oldman_examination_sex.setText("女");

            }
            gethttp();
        } else if (areaOldManBean != null) {
            Picasso.with(OldManExaminationDataActivity.this).load(OkHttpURL.ImageURL + areaOldManBean.getImgPath()).placeholder(R.mipmap.oldone).into(oldman_examination_image);
            oldman_examination_name = (TextView) findViewById(R.id.oldman_examination_name);
            if (TextUtils.isEmpty(areaOldManBean.getCustomerName())) {
                oldman_examination_name.setText("");
            }
            oldman_examination_name.setText(areaOldManBean.getCustomerName().toString());
            oldman_examination_sex = (TextView) findViewById(R.id.oldman_examination_sex);
            if (TextUtils.isEmpty(areaOldManBean.getSex())) {
                oldman_examination_sex.setText("");

            } else if (areaOldManBean.getSex().equals("0")) {
                oldman_examination_sex.setText("男");

            } else if (areaOldManBean.getSex().equals("1")) {
                oldman_examination_sex.setText("女");

            }
            gethttp();

        } else {
            try {
                JSONObject jsonObject = new JSONObject(checkidold);
                String oldid = jsonObject.getString("option1");
                GetOldManEnterMessage(oldid);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.oldmanexaminationback_menu:
                this.finish();
                overridePendingTransition(R.animator.animation_in, R.animator.animation_out);
                break;
            //--护理管理
            case R.id.nurseadmin_btn:
                if (horizontalScrollView.isopen()) {
                    AllBedAdminActivity.DestoryActivity();
                    Intent intent = new Intent(OldManExaminationDataActivity.this, NurseAdminActivity.class);
                    startActivity(intent);
                    this.finish();
                    AllOldManActivity.DestoryActivity();
                    AllFirstMainActivity.DestoryActivity();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;

            //--老人管理
            case R.id.oldmanadmin_btn:
                if (horizontalScrollView.isopen()) {
                    AllOldManActivity.DestoryActivity();
                    AllBedAdminActivity.DestoryActivity();
                    AllFirstMainActivity.DestoryActivity();
                    Intent intent = new Intent(OldManExaminationDataActivity.this, OldManListActivity.class);
                    startActivity(intent);
                    this.finish();

                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            //--员工
            case R.id.staffadmin_btn:
                if (horizontalScrollView.isopen()) {
                    AllBedAdminActivity.DestoryActivity();
                    Intent intent = new Intent(OldManExaminationDataActivity.this, StaffAdminActivity.class);
                    startActivity(intent);
                    this.finish();
                    AllOldManActivity.DestoryActivity();
                    AllFirstMainActivity.DestoryActivity();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            //--床位
            case R.id.bedadmin_btn:
                if (horizontalScrollView.isopen()) {
                    AllBedAdminActivity.DestoryActivity();
                    Intent intent = new Intent(OldManExaminationDataActivity.this, BedAdminActivity.class);
                    startActivity(intent);
                    this.finish();
                    AllOldManActivity.DestoryActivity();
                    AllFirstMainActivity.DestoryActivity();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            case R.id.messagesend_btn:
                if (horizontalScrollView.isopen()) {
                    AllBedAdminActivity.DestoryActivity();
                    Intent intent = new Intent(OldManExaminationDataActivity.this, MessageActivity.class);
                    startActivity(intent);
                    this.finish();
                    AllOldManActivity.DestoryActivity();
                    AllFirstMainActivity.DestoryActivity();
                    overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                }
                break;
            case R.id.shuzhangya:
                lineChart.clear();
                SelectCheckBox(shuzhangya);
                SetShuZhangYaLineChart();

                break;
            case R.id.shousuoya:
                lineChart.clear();
                SelectCheckBox(shousuoya);
                SetShouSuoYalineChart();

                break;
            case R.id.maibo:
                lineChart.clear();
                SelectCheckBox(maibo);
                SetMaiBoLineChart();
                break;
            case R.id.tiwen:
                lineChart.clear();
                SelectCheckBox(tiwen);
                SetTiWenLineChart();
                break;
            case R.id.huxi:
                lineChart.clear();
                SelectCheckBox(huxi);
                SetHuXiLineChart();
                break;
            case R.id.tizhong:
                lineChart.clear();
                SelectCheckBox(tizhong);
                SetTiZhongLineChart();
                break;
            case R.id.zhushiliang:
                lineChart.clear();
                SelectCheckBox(zhushiliang);
                SetZhuShiLiangLineChart();
                break;
            case R.id.cailiang:
                lineChart.clear();
                SelectCheckBox(cailiang);
                SetCaiLiangLineChart();
                break;
            case R.id.paibianliang:
                lineChart.clear();
                SelectCheckBox(paibianliang);
                SetPaiBianLianggLineChart();
                break;
            case R.id.pailiaoliang:
                lineChart.clear();
                SelectCheckBox(pailiaoliang);
                SetPaiLiaoLiangLineChart();
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (horizontalScrollView.isopen()) {
                horizontalScrollView.closemenu();

            } else {
                this.finish();
                overridePendingTransition(R.animator.animation_in, R.animator.animation_out);
            }
        }
        return false;
    }

    public void gethttp() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(15, TimeUnit.SECONDS).readTimeout(15, TimeUnit.SECONDS).build();
        final Request request = new Request.Builder().get().url("http://192.168.10.7:7006/api/Customer/GetOldPersonSignRecordByOldPersonId?oldPersonId=" + oldid + "&beginTime=" + titles.get(titles.size() - 1) + "&endTime=" + titles.get(0) + "").build();
//        final Request request = new Request.Builder().get().url("http://192.168.10.7:7006/api/Customer/GetOldPersonSignRecordByOldPersonId?oldPersonId=" + oldid + "&beginTime=2017-09-26&endTime=2017-10-01").build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                if (request.equals("[]")) {
                    Message message = new Message();
                    message.obj = 2;
                    handler.sendMessage(message);
                    return;
                }
                String s = "{\"OldManExaminationData\":";
                StringBuffer sb = new StringBuffer(result);
                sb.insert(0, s);
                String data = sb.toString() + "}";
                Gson gson = new Gson();
                oldManExaminationData = gson.fromJson(data, OldManExaminationData.class);
                Message message = new Message();
                message.obj = 1;
                handler.sendMessage(message);

            }
        });

    }

    //--舒张压
    public void SetShuZhangYaLineChart() {

        XAxis xAxis = lineChart.getXAxis();
        xAxis.setAvoidFirstLastClipping(true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(true);//设置x轴上每个点对应的线

        //-第一条线
        List<Entry> entries = new ArrayList<>();
        for (int i = 0; i < oldManExaminationData.getOldManExaminationData().size(); i++) {
            entries.add(new Entry(oldManExaminationData.getOldManExaminationData().get(i).getDiastolicPressure(), i));
        }
        LineDataSet lineDataSet = new LineDataSet(entries, "舒张压");
        //--设置线的宽度
//        lineDataSet.setLineWidth(2);
        lineDataSet.setColor(Color.BLACK);
        ArrayList<LineDataSet> dataSets = new ArrayList<>();
        //将数据加入dataSets
        dataSets.add(lineDataSet);
//        //模拟一个x轴的数据
        ArrayList<String> xValues = new ArrayList<>();
        for (int i = 0; i < oldManExaminationData.getOldManExaminationData().size(); i++) {
            xValues.add(oldManExaminationData.getOldManExaminationData().get(i).getTestTime().replaceAll("T", " "));
        }
        LineData lineData = new LineData(xValues, dataSets);

        lineChart.setData(lineData);
        lineChart.setDescription(oldManExaminationData.getOldManExaminationData().size() + "次测试报表(单位：mmHg)");
        lineChart.animateX(1500);
        lineChart.animateY(1500);
        lineChart.setTouchEnabled(true); // 设置是否可以触摸
        lineChart.setDragEnabled(true);// 是否可以拖拽
        lineChart.setScaleEnabled(true);// 是否可以缩放
        lineChart.getAxisRight().setEnabled(false); // 隐藏右边 的坐标轴
        lineChart.setDrawBorders(false);
        lineChart.setGridBackgroundColor(Color.parseColor("#fafafa"));
        // 没有数据时显示，类似于 ListView 的 EmptyView
        lineChart.setNoDataTextDescription("如果传给MPAndroidChart的数据为空，那么你将看到这段文字。CrazyBoy");

    }

    //--收缩压
    public void SetShouSuoYalineChart() {

        XAxis xAxis = lineChart.getXAxis();
        xAxis.setAvoidFirstLastClipping(true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(true);//设置x轴上每个点对应的线
        //-第一条线
        List<Entry> entries = new ArrayList<>();
        for (int i = 0; i < oldManExaminationData.getOldManExaminationData().size(); i++) {
            entries.add(new Entry(oldManExaminationData.getOldManExaminationData().get(i).getSystolicPressure(), i));
        }
        LineDataSet lineDataSet = new LineDataSet(entries, "收缩压");
        //--设置线的宽度
//        lineDataSet.setLineWidth(2);
        lineDataSet.setColor(Color.BLACK);
        ArrayList<LineDataSet> dataSets = new ArrayList<>();
        //将数据加入dataSets
        dataSets.add(lineDataSet);
//        //模拟一个x轴的数据
        ArrayList<String> xValues = new ArrayList<>();
        for (int i = 0; i < oldManExaminationData.getOldManExaminationData().size(); i++) {
            xValues.add(oldManExaminationData.getOldManExaminationData().get(i).getTestTime().replaceAll("T", " "));
        }
        LineData lineData = new LineData(xValues, dataSets);
        lineChart.setData(lineData);
        lineChart.setDescription(oldManExaminationData.getOldManExaminationData().size() + "次测试报表(单位：mmHg)");
        lineChart.animateX(1500);
        lineChart.animateY(1500);
        lineChart.setTouchEnabled(true); // 设置是否可以触摸
        lineChart.setDragEnabled(true);// 是否可以拖拽
        lineChart.setScaleEnabled(true);// 是否可以缩放
        lineChart.getAxisRight().setEnabled(false); // 隐藏右边 的坐标轴
//        //缩放第一种方式
//        Matrix matrix = new Matrix();
////1f代表不缩放
//        matrix.postScale(3f, 1f);
//        lineChart.getViewPortHandler().refresh(matrix, lineChart, false);
////重设所有缩放和拖动，使图表完全适合它的边界（完全缩小）。
//        lineChart.fitScreen();
//        //缩放第二种方式
////        lineChart.getViewPortHandler().getMatrixTouch().postScale(3f, 1f);


    }

    //--脉搏
    public void SetMaiBoLineChart() {

        XAxis xAxis = lineChart.getXAxis();
        xAxis.setAvoidFirstLastClipping(true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(true);//设置x轴上每个点对应的线
        //-第一条线
        List<Entry> entries = new ArrayList<>();
        for (int i = 0; i < oldManExaminationData.getOldManExaminationData().size(); i++) {
            entries.add(new Entry(oldManExaminationData.getOldManExaminationData().get(i).getPulse(), i));
        }
        LineDataSet lineDataSet = new LineDataSet(entries, "脉搏");
        //--设置线的宽度
//        lineDataSet.setLineWidth(2);
        lineDataSet.setColor(Color.BLACK);
        ArrayList<LineDataSet> dataSets = new ArrayList<>();
        //将数据加入dataSets
        dataSets.add(lineDataSet);
//        //模拟一个x轴的数据
        ArrayList<String> xValues = new ArrayList<>();
        for (int i = 0; i < oldManExaminationData.getOldManExaminationData().size(); i++) {
            xValues.add(oldManExaminationData.getOldManExaminationData().get(i).getTestTime().replaceAll("T", " "));
        }
        LineData lineData = new LineData(xValues, dataSets);
        lineChart.setData(lineData);
        lineChart.setDescription(oldManExaminationData.getOldManExaminationData().size() + "次测试报表(单位：分/次)");
        lineChart.animateX(1500);
        lineChart.animateY(1500);
        lineChart.setTouchEnabled(true); // 设置是否可以触摸
        lineChart.setDragEnabled(true);// 是否可以拖拽
        lineChart.setScaleEnabled(true);// 是否可以缩放
        lineChart.getAxisRight().setEnabled(false); // 隐藏右边 的坐标轴
//        //缩放第一种方式
//        Matrix matrix = new Matrix();
////1f代表不缩放
//        matrix.postScale(3f, 1f);
//        lineChart.getViewPortHandler().refresh(matrix, lineChart, false);
////重设所有缩放和拖动，使图表完全适合它的边界（完全缩小）。
//        lineChart.fitScreen();
//        //缩放第二种方式
////        lineChart.getViewPortHandler().getMatrixTouch().postScale(3f, 1f);


    }

    //--体温
    public void SetTiWenLineChart() {

        XAxis xAxis = lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        //-第一条线
        List<Entry> entries = new ArrayList<>();
        for (int i = 0; i < oldManExaminationData.getOldManExaminationData().size(); i++) {
            entries.add(new Entry(oldManExaminationData.getOldManExaminationData().get(i).getTemperature(), i));
        }
        LineDataSet lineDataSet = new LineDataSet(entries, "体温");
        //--设置线的宽度
//        lineDataSet.setLineWidth(2);
        lineDataSet.setColor(Color.BLACK);
        ArrayList<LineDataSet> dataSets = new ArrayList<>();
        //将数据加入dataSets
        dataSets.add(lineDataSet);
//        //模拟一个x轴的数据
        ArrayList<String> xValues = new ArrayList<>();
        for (int i = 0; i < oldManExaminationData.getOldManExaminationData().size(); i++) {
            xValues.add(oldManExaminationData.getOldManExaminationData().get(i).getTestTime().replaceAll("T", " "));
        }
        LineData lineData = new LineData(xValues, dataSets);
        lineChart.setData(lineData);
        lineChart.setDescription(oldManExaminationData.getOldManExaminationData().size() + "次测试报表(单位：°C)");
        lineChart.animateX(1500);
        lineChart.animateY(1500);
        lineChart.setTouchEnabled(true); // 设置是否可以触摸
        lineChart.setDragEnabled(true);// 是否可以拖拽
        lineChart.setScaleEnabled(true);// 是否可以缩放
        lineChart.getAxisRight().setEnabled(false); // 隐藏右边 的坐标轴
//        //缩放第一种方式
//        Matrix matrix = new Matrix();
////1f代表不缩放
//        matrix.postScale(3f, 1f);
//        lineChart.getViewPortHandler().refresh(matrix, lineChart, false);
////重设所有缩放和拖动，使图表完全适合它的边界（完全缩小）。
//        lineChart.fitScreen();
//        //缩放第二种方式
////        lineChart.getViewPortHandler().getMatrixTouch().postScale(3f, 1f);


    }

    //--呼吸
    public void SetHuXiLineChart() {

        XAxis xAxis = lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        //-第一条线
        List<Entry> entries = new ArrayList<>();
        for (int i = 0; i < oldManExaminationData.getOldManExaminationData().size(); i++) {
            entries.add(new Entry(oldManExaminationData.getOldManExaminationData().get(i).getBreathing(), i));
        }
        LineDataSet lineDataSet = new LineDataSet(entries, "呼吸");
        //--设置线的宽度
//        lineDataSet.setLineWidth(2);
        lineDataSet.setColor(Color.BLACK);
        ArrayList<LineDataSet> dataSets = new ArrayList<>();
        //将数据加入dataSets
        dataSets.add(lineDataSet);
//        //模拟一个x轴的数据
        ArrayList<String> xValues = new ArrayList<>();
        for (int i = 0; i < oldManExaminationData.getOldManExaminationData().size(); i++) {
            xValues.add(oldManExaminationData.getOldManExaminationData().get(i).getTestTime().replaceAll("T", " "));
        }
        LineData lineData = new LineData(xValues, dataSets);
        lineChart.setData(lineData);
        lineChart.setDescription(oldManExaminationData.getOldManExaminationData().size() + "次测试报表(单位：分/次)");
        lineChart.animateX(1500);
        lineChart.animateY(1500);
        lineChart.setTouchEnabled(true); // 设置是否可以触摸
        lineChart.setDragEnabled(true);// 是否可以拖拽
        lineChart.setScaleEnabled(true);// 是否可以缩放
        lineChart.getAxisRight().setEnabled(false); // 隐藏右边 的坐标轴
//        //缩放第一种方式
//        Matrix matrix = new Matrix();
////1f代表不缩放
//        matrix.postScale(3f, 1f);
//        lineChart.getViewPortHandler().refresh(matrix, lineChart, false);
////重设所有缩放和拖动，使图表完全适合它的边界（完全缩小）。
//        lineChart.fitScreen();
//        //缩放第二种方式
////        lineChart.getViewPortHandler().getMatrixTouch().postScale(3f, 1f);


    }

    //--体重
    public void SetTiZhongLineChart() {

        XAxis xAxis = lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        //-第一条线
        List<Entry> entries = new ArrayList<>();
        for (int i = 0; i < oldManExaminationData.getOldManExaminationData().size(); i++) {
            entries.add(new Entry(oldManExaminationData.getOldManExaminationData().get(i).getWeight(), i));
        }
        LineDataSet lineDataSet = new LineDataSet(entries, "体重");
        //--设置线的宽度
//        lineDataSet.setLineWidth(2);
        lineDataSet.setColor(Color.BLACK);
        ArrayList<LineDataSet> dataSets = new ArrayList<>();
        //将数据加入dataSets
        dataSets.add(lineDataSet);
//        //模拟一个x轴的数据
        ArrayList<String> xValues = new ArrayList<>();
        for (int i = 0; i < oldManExaminationData.getOldManExaminationData().size(); i++) {
            xValues.add(oldManExaminationData.getOldManExaminationData().get(i).getTestTime().replaceAll("T", " "));
        }
        LineData lineData = new LineData(xValues, dataSets);
        lineChart.setData(lineData);
        lineChart.setDescription(oldManExaminationData.getOldManExaminationData().size() + "次测试报表(单位：kg)");
        lineChart.animateX(1500);
        lineChart.animateY(1500);
        lineChart.setTouchEnabled(true); // 设置是否可以触摸
        lineChart.setDragEnabled(true);// 是否可以拖拽
        lineChart.setScaleEnabled(true);// 是否可以缩放
        lineChart.getAxisRight().setEnabled(false); // 隐藏右边 的坐标轴
//        //缩放第一种方式
//        Matrix matrix = new Matrix();
////1f代表不缩放
//        matrix.postScale(3f, 1f);
//        lineChart.getViewPortHandler().refresh(matrix, lineChart, false);
////重设所有缩放和拖动，使图表完全适合它的边界（完全缩小）。
//        lineChart.fitScreen();
//        //缩放第二种方式
////        lineChart.getViewPortHandler().getMatrixTouch().postScale(3f, 1f);


    }

    //--主食量
    public void SetZhuShiLiangLineChart() {

        XAxis xAxis = lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        //-第一条线
        List<Entry> entries = new ArrayList<>();
        for (int i = 0; i < oldManExaminationData.getOldManExaminationData().size(); i++) {
            entries.add(new Entry(oldManExaminationData.getOldManExaminationData().get(i).getMainFoodIntake(), i));
        }
        LineDataSet lineDataSet = new LineDataSet(entries, "主食量");
        //--设置线的宽度
//        lineDataSet.setLineWidth(2);
        lineDataSet.setColor(Color.BLACK);
        ArrayList<LineDataSet> dataSets = new ArrayList<>();
        //将数据加入dataSets
        dataSets.add(lineDataSet);
//        //模拟一个x轴的数据
        ArrayList<String> xValues = new ArrayList<>();
        for (int i = 0; i < oldManExaminationData.getOldManExaminationData().size(); i++) {
            xValues.add(oldManExaminationData.getOldManExaminationData().get(i).getTestTime().replaceAll("T", " "));
        }
        LineData lineData = new LineData(xValues, dataSets);
        lineChart.setData(lineData);
        lineChart.setDescription(oldManExaminationData.getOldManExaminationData().size() + "次测试报表(单位：/10)");
        lineChart.animateX(1500);
        lineChart.animateY(1500);
        lineChart.setTouchEnabled(true); // 设置是否可以触摸
        lineChart.setDragEnabled(true);// 是否可以拖拽
        lineChart.setScaleEnabled(true);// 是否可以缩放
        lineChart.getAxisRight().setEnabled(false); // 隐藏右边 的坐标轴
//        //缩放第一种方式
//        Matrix matrix = new Matrix();
////1f代表不缩放
//        matrix.postScale(3f, 1f);
//        lineChart.getViewPortHandler().refresh(matrix, lineChart, false);
////重设所有缩放和拖动，使图表完全适合它的边界（完全缩小）。
//        lineChart.fitScreen();
//        //缩放第二种方式
////        lineChart.getViewPortHandler().getMatrixTouch().postScale(3f, 1f);


    }

    //--菜量
    public void SetCaiLiangLineChart() {

        XAxis xAxis = lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        //-第一条线
        List<Entry> entries = new ArrayList<>();
        for (int i = 0; i < oldManExaminationData.getOldManExaminationData().size(); i++) {
            entries.add(new Entry(oldManExaminationData.getOldManExaminationData().get(i).getFoodIntake(), i));
        }
        LineDataSet lineDataSet = new LineDataSet(entries, "菜量");
        //--设置线的宽度
//        lineDataSet.setLineWidth(2);
        lineDataSet.setColor(Color.BLACK);
        ArrayList<LineDataSet> dataSets = new ArrayList<>();
        //将数据加入dataSets
        dataSets.add(lineDataSet);
//        //模拟一个x轴的数据
        ArrayList<String> xValues = new ArrayList<>();
        for (int i = 0; i < oldManExaminationData.getOldManExaminationData().size(); i++) {
            xValues.add(oldManExaminationData.getOldManExaminationData().get(i).getTestTime().replaceAll("T", " "));
        }
        LineData lineData = new LineData(xValues, dataSets);
        lineChart.setData(lineData);
        lineChart.setDescription(oldManExaminationData.getOldManExaminationData().size() + "次测试报表(单位：/10)");
        lineChart.animateX(1500);
        lineChart.animateY(1500);
        lineChart.setTouchEnabled(true); // 设置是否可以触摸
        lineChart.setDragEnabled(true);// 是否可以拖拽
        lineChart.setScaleEnabled(true);// 是否可以缩放
        lineChart.getAxisRight().setEnabled(false); // 隐藏右边 的坐标轴
//        //缩放第一种方式
//        Matrix matrix = new Matrix();
////1f代表不缩放
//        matrix.postScale(3f, 1f);
//        lineChart.getViewPortHandler().refresh(matrix, lineChart, false);
////重设所有缩放和拖动，使图表完全适合它的边界（完全缩小）。
//        lineChart.fitScreen();
//        //缩放第二种方式
////        lineChart.getViewPortHandler().getMatrixTouch().postScale(3f, 1f);


    }

    //--排便量
    public void SetPaiBianLianggLineChart() {

        XAxis xAxis = lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        //-第一条线
        List<Entry> entries = new ArrayList<>();
        for (int i = 0; i < oldManExaminationData.getOldManExaminationData().size(); i++) {
            entries.add(new Entry(oldManExaminationData.getOldManExaminationData().get(i).getDefecationVolume(), i));
        }
        LineDataSet lineDataSet = new LineDataSet(entries, "排便量");
        //--设置线的宽度
//        lineDataSet.setLineWidth(2);
        lineDataSet.setColor(Color.BLACK);
        ArrayList<LineDataSet> dataSets = new ArrayList<>();
        //将数据加入dataSets
        dataSets.add(lineDataSet);
//        //模拟一个x轴的数据
        ArrayList<String> xValues = new ArrayList<>();
        for (int i = 0; i < oldManExaminationData.getOldManExaminationData().size(); i++) {
            xValues.add(oldManExaminationData.getOldManExaminationData().get(i).getTestTime().replaceAll("T", " "));
        }
        LineData lineData = new LineData(xValues, dataSets);
        lineChart.setData(lineData);
        lineChart.setDescription(oldManExaminationData.getOldManExaminationData().size() + "次测试报表(单位：g)");
        lineChart.animateX(1500);
        lineChart.animateY(1500);
        lineChart.setTouchEnabled(true); // 设置是否可以触摸
        lineChart.setDragEnabled(true);// 是否可以拖拽
        lineChart.setScaleEnabled(true);// 是否可以缩放
        lineChart.getAxisRight().setEnabled(false); // 隐藏右边 的坐标轴
//        //缩放第一种方式
//        Matrix matrix = new Matrix();
////1f代表不缩放
//        matrix.postScale(3f, 1f);
//        lineChart.getViewPortHandler().refresh(matrix, lineChart, false);
////重设所有缩放和拖动，使图表完全适合它的边界（完全缩小）。
//        lineChart.fitScreen();
//        //缩放第二种方式
////        lineChart.getViewPortHandler().getMatrixTouch().postScale(3f, 1f);


    }

    //--排尿量
    public void SetPaiLiaoLiangLineChart() {

        XAxis xAxis = lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        //-第一条线
        List<Entry> entries = new ArrayList<>();
        for (int i = 0; i < oldManExaminationData.getOldManExaminationData().size(); i++) {
            entries.add(new Entry(oldManExaminationData.getOldManExaminationData().get(i).getUrinaryOutput(), i));
        }
        LineDataSet lineDataSet = new LineDataSet(entries, "排尿量");
        //--设置线的宽度
//        lineDataSet.setLineWidth(2);
        lineDataSet.setColor(Color.BLACK);
        ArrayList<LineDataSet> dataSets = new ArrayList<>();
        //将数据加入dataSets
        dataSets.add(lineDataSet);
//        //模拟一个x轴的数据
        ArrayList<String> xValues = new ArrayList<>();
        for (int i = 0; i < oldManExaminationData.getOldManExaminationData().size(); i++) {
            xValues.add(oldManExaminationData.getOldManExaminationData().get(i).getTestTime().replaceAll("T", " "));
        }
        LineData lineData = new LineData(xValues, dataSets);
        lineChart.setData(lineData);
        lineChart.setDescription(oldManExaminationData.getOldManExaminationData().size() + "次测试报表(单位：ML)");
        lineChart.animateX(1500);
        lineChart.animateY(1500);
        lineChart.setTouchEnabled(true); // 设置是否可以触摸
        lineChart.setDragEnabled(true);// 是否可以拖拽
        lineChart.setScaleEnabled(true);// 是否可以缩放
        lineChart.getAxisRight().setEnabled(false); // 隐藏右边 的坐标轴
//        //缩放第一种方式
//        Matrix matrix = new Matrix();
////1f代表不缩放
//        matrix.postScale(3f, 1f);
//        lineChart.getViewPortHandler().refresh(matrix, lineChart, false);
////重设所有缩放和拖动，使图表完全适合它的边界（完全缩小）。
//        lineChart.fitScreen();
//        //缩放第二种方式
////        lineChart.getViewPortHandler().getMatrixTouch().postScale(3f, 1f);


    }

    //--单选框中只能选中其中一个
    public void SelectCheckBox(CheckBox checkBox) {
        for (int i = 0; i < checklist.size(); i++) {
            if (checkBox == checklist.get(i)) {
                checkBox.setChecked(true);

            } else {

                checklist.get(i).setChecked(false);
            }

        }

    }

    public List<String> getTitles() {
        String mYear; // 当前年
        String mMonth; // 月
        String mDay;
        int current_day;
        int current_month;
        int current_year;

        final Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        current_day = c.get(Calendar.DAY_OF_MONTH);
        current_month = c.get(Calendar.MONTH);
        current_year = c.get(Calendar.YEAR);
        for (int i = 0; i < 7; i++) {
            c.clear();//记住一定要clear一次
            c.set(Calendar.MONTH, current_month);
            c.set(Calendar.DAY_OF_MONTH, current_day);
            c.set(Calendar.YEAR, current_year);
            c.add(Calendar.DATE, -i);//j记住是DATE
            mMonth = String.valueOf(c.get(Calendar.MONTH) + 1);// 获取当前月份
            mDay = String.valueOf(c.get(Calendar.DAY_OF_MONTH));// 获取当前日份的日期号码
            mYear = String.valueOf(c.get(Calendar.YEAR));// 获取当前年份
            String date = mYear + "-" + mMonth + "-" + mDay;
            titles.add(date);
        }
        return titles;
    }

    public void GetOldManEnterMessage(final String id) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(15, TimeUnit.SECONDS).writeTimeout(15, TimeUnit.SECONDS).build();
        Request request = new Request.Builder().get().url("http://192.168.10.7:7006/api/Customer/GetCheckinByOldId?OldId=" + id).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                oldManEnterTime = gson.fromJson(response.body().string(), OldManEnterTime.class);
                Message message = new Message();
                message.obj = 3;
                handler.sendMessage(message);
            }
        });


    }
}
