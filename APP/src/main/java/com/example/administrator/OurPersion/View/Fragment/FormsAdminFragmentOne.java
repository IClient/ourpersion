package com.example.administrator.OurPersion.View.Fragment;

import android.graphics.Color;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.bumptech.glide.Glide;
import com.example.administrator.OurPersion.Model.Bean.OkHttpURL;
import com.example.administrator.OurPersion.R;
import com.example.administrator.OurPersion.SelfView.CircleImageView;
import com.example.administrator.OurPersion.View.Activity.BaseActivity;
import com.example.administrator.OurPersion.View.Activity.FormsAdminActivity;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.example.administrator.OurPersion.R.id.chart;

/**
 * Created by Administrator on 2017/6/8 0008.
 */

public class FormsAdminFragmentOne extends Fragment implements View.OnClickListener {
    View view;
    LineChart lineChart;
    Random random;
    //树形图的数据
    private LineData lineData;
    //树形图内容条的数据
    private LineDataSet dataSet;
    CheckBox checkBox;
    CheckBox checkBox1;
    CircleImageView circleImageView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.formsadmin_frgamentone, container, false);
        circleImageView = (CircleImageView) view.findViewById(R.id.formsadminbackfrgament1_menu);
        Glide.with(getActivity()).load(OkHttpURL.ImageURL + BaseActivity.user.getImgPath()).fitCenter().into(circleImageView);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        //初始化控件
        initview();
        xueya();
    }

    public void initview() {

        lineChart = (LineChart) view.findViewById(chart);
        checkBox = (CheckBox) view.findViewById(R.id.xueya);
        checkBox.setOnClickListener(this);
        checkBox.setChecked(true);
        checkBox1 = (CheckBox) view.findViewById(R.id.xuetang);
        checkBox1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.xuetang:
                lineChart.clear();
                checkBox.setChecked(false);
                xuetang();
                break;
            case R.id.xueya:
                lineChart.clear();
                checkBox1.setChecked(false);
                xueya();
        }

    }

    public void xuetang() {
        XAxis xAxis = lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        //-第一条线
        List<Entry> entries1 = new ArrayList<>();
        entries1.add(new Entry(2, 0));
        entries1.add(new Entry(5, 1));
        entries1.add(new Entry(10, 2));
        entries1.add(new Entry(7, 3));
        entries1.add(new Entry(15, 4));
        entries1.add(new Entry(11, 5));
        entries1.add(new Entry(4, 6));
        entries1.add(new Entry(5, 7));
        LineDataSet lineDataSet1 = new LineDataSet(entries1, "血糖");
        ArrayList<LineDataSet> dataSets = new ArrayList<>();
        //将数据加入dataSets
        dataSets.add(lineDataSet1);
        //模拟一个x轴的数据
        ArrayList<String> xValues = new ArrayList<>();
        for (int i = 1; i < 9; i++) {
            xValues.add("第" + i + "天");
        }
        LineData lineData = new LineData(xValues, dataSets);
        lineChart.setData(lineData);
        lineChart.setDescription("8天测试报表(单位：mmol/L)");
        lineChart.animateX(3000);
        lineChart.animateY(3000);
    }

    public void xueya() {

        XAxis xAxis = lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        //-第一条线
        List<Entry> entries = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            entries.add(new Entry(i, i));
        }
        entries.add(new Entry(2, 9));
        entries.add(new Entry(5, 10));
        entries.add(new Entry(10, 11));
        entries.add(new Entry(7, 12));
        entries.add(new Entry(15, 13));
        entries.add(new Entry(11, 14));
        entries.add(new Entry(4, 15));
        entries.add(new Entry(5, 16));
        LineDataSet lineDataSet = new LineDataSet(entries, "血压");
        //--设置线的宽度
//        lineDataSet.setLineWidth(2);
        lineDataSet.setColor(Color.BLACK);
        ArrayList<LineDataSet> dataSets = new ArrayList<>();
        //将数据加入dataSets
        dataSets.add(lineDataSet);
//        //模拟一个x轴的数据
        ArrayList<String> xValues = new ArrayList<>();
        for (int i = 1; i < 18; i++) {
            xValues.add("第" + i + "天");
        }
        LineData lineData = new LineData(xValues, dataSets);
        lineChart.setData(lineData);
        lineChart.setDescription("8天测试报表(单位：mmHg)");
        lineChart.animateX(3000);
        lineChart.animateY(3000);
        lineChart.setTouchEnabled(true); // 设置是否可以触摸
        lineChart.setDragEnabled(true);// 是否可以拖拽
        lineChart.setScaleEnabled(true);// 是否可以缩放
        lineChart.getAxisRight().setEnabled(false); // 隐藏右边 的坐标轴
        //缩放第一种方式
        Matrix matrix = new Matrix();
//1f代表不缩放
        matrix.postScale(3f, 1f);
        lineChart.getViewPortHandler().refresh(matrix, lineChart, false);
//重设所有缩放和拖动，使图表完全适合它的边界（完全缩小）。
        lineChart.fitScreen();
        //缩放第二种方式
//        lineChart.getViewPortHandler().getMatrixTouch().postScale(3f, 1f);

    }
}
