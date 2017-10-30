package com.example.administrator.OurPersion.View.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.bumptech.glide.Glide;
import com.example.administrator.OurPersion.Model.Bean.OkHttpURL;
import com.example.administrator.OurPersion.R;
import com.example.administrator.OurPersion.SelfView.CircleImageView;
import com.example.administrator.OurPersion.View.Activity.BaseActivity;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Administrator on 2017/6/8 0008.
 */

public class FormsAdminFragmentTwo extends Fragment {
    View view;
    BarChart barChart;
    Random random;
    //树形图的数据
    private BarData data;
    //树形图内容条的数据
    private BarDataSet dataSet;
CircleImageView  circleImageView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.formsadmin_fragmenttwo, container, false);
        circleImageView= (CircleImageView) view.findViewById(R.id.formsadminbackfrgament2_menu);
        Glide.with(getActivity()).load(OkHttpURL.ImageURL + BaseActivity.user.getImgPath()).fitCenter().into(circleImageView);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        //初始化控件
        initview();
        /**图表具体设置*/
        ArrayList<BarEntry> entries = new ArrayList<>();//显示条目
        ArrayList<String> xVals = new ArrayList<String>();//横坐标标签
        random = new Random();//随机数
        for (int i = 0; i < 12; i++) {
            float profit = random.nextFloat() * 300;
            //entries.add(BarEntry(float val,int positon);
            entries.add(new BarEntry(profit, i));//y轴的数据条目
            xVals.add((i + 1) + "号");
        }
        dataSet = new BarDataSet(entries, "老人血糖测试报表");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        data = new BarData(xVals, dataSet);
        barChart.setData(data);
        //设置Y方向上动画animateY(int time);
        barChart.animateY(3000);
        //图表描述
        barChart.setDescription("老人最近12天血糖报表(单位：mmHg)");
    }

    public void initview() {

        barChart = (BarChart) view.findViewById(R.id.chart);
    }


}
