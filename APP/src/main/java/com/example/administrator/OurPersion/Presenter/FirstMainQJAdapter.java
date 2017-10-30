package com.example.administrator.OurPersion.Presenter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.administrator.OurPersion.Model.Bean.MeQJWork;
import com.example.administrator.OurPersion.R;

/**
 * Created by Administrator on 2017/9/30 0030.
 */

public class FirstMainQJAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    MeQJWork meQJWork;
    LayoutInflater layoutInflater;
    public int state = 1;

    public FirstMainQJAdapter(Context context, MeQJWork meQJWork) {
        this.context = context;
        this.meQJWork = meQJWork;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemViewType(int position) {
        if (position == meQJWork.getMeQJWork().getDatas().size() && meQJWork.getMeQJWork().getDatas().size() > 1) {
            return 2;

        } else {
            return 1;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View view = layoutInflater.inflate(R.layout.activity_firstmain_qj_item, parent, false);
            MyViewHolder viewHolder = new MyViewHolder(view);
            return viewHolder;
        } else if (viewType == 2) {
            View view = layoutInflater.inflate(R.layout.nurseadmin_loadmore_item, parent, false);
            MyViewHolderTwo myviewHolderTwo = new MyViewHolderTwo(view);
            return myviewHolderTwo;

        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder) {
            MyViewHolder viewHolder = (MyViewHolder) holder;
            viewHolder.firstmain_qj_liucmc.setTag(position);
            MeQJWork.MeQJWorkBean.DatasBean datasBean = meQJWork.getMeQJWork().getDatas().get((Integer) viewHolder.firstmain_qj_liucmc.getTag());
            viewHolder.firstmain_qj_liucmc.setText(datasBean.getWorkFlowName());
            viewHolder.firstmain_qj_sqtime.setText(datasBean.getApplyTime().replaceAll("T", " "));
            switch (datasBean.getApplyType()) {
                case "0":
                    viewHolder.firstmain_qj_qjtype.setText("事假");
                    break;
                case "1":
                    viewHolder.firstmain_qj_qjtype.setText("病假");
                    break;
                case "2":
                    viewHolder.firstmain_qj_qjtype.setText("工伤假");
                    break;
                case "3":
                    viewHolder.firstmain_qj_qjtype.setText("学习假");
                    break;
                case "4":
                    viewHolder.firstmain_qj_qjtype.setText("婚假");
                    break;
                case "5":
                    viewHolder.firstmain_qj_qjtype.setText("丧假");
                    break;
                case "6":
                    viewHolder.firstmain_qj_qjtype.setText("年休假");
                    break;
                case "7":
                    viewHolder.firstmain_qj_qjtype.setText("换休假");
                    break;
                case "8":
                    viewHolder.firstmain_qj_qjtype.setText("陪护假");
                    break;
                case "9":
                    viewHolder.firstmain_qj_qjtype.setText("产假");
                    break;
                case "10":
                    viewHolder.firstmain_qj_qjtype.setText("优职假");
                    break;
                case "11":
                    viewHolder.firstmain_qj_qjtype.setText("其他");
                    break;

            }
            viewHolder.firstmain_qj_qjtime1.setText(datasBean.getApplyStartTime1().replaceAll("T", " ") + "_" + datasBean.getApplyEndTime1().replaceAll("T", " "));
            if (datasBean.getApplyStartTime2().equals("9999-12-31T23:59:59.997") && datasBean.getApplyEndTime2().equals("9999-12-31T23:59:59.997")) {
                viewHolder.firstmain_qj_time2_layout.setVisibility(View.GONE);

            } else {
                viewHolder.firstmain_qj_time2_layout.setVisibility(View.VISIBLE);
                viewHolder.firstmain_qj_qjtime2.setText(datasBean.getApplyStartTime2().replaceAll("T", " ") + "_" + datasBean.getApplyEndTime2().replaceAll("T", " "));
            }
            viewHolder.firstmain_qj_lcbz.setText(datasBean.getNowStepWorkFlowNodeName());
            switch (datasBean.getWorkFlowState()) {
                case "0":
                    viewHolder.firstmain_qj_state.setText("审核中");
                    break;
                case "1":
                    viewHolder.firstmain_qj_state.setText("审核完成");
                    break;
                case "2":
                    viewHolder.firstmain_qj_state.setText("撤销");
                    break;
            }
            viewHolder.firstmain_qj_tianshu.setText(datasBean.getAskForLeaveDays() + "");
        } else if (holder instanceof MyViewHolderTwo) {
            MyViewHolderTwo myviewHolderTwo = (MyViewHolderTwo) holder;
            if (state == 1) {
                myviewHolderTwo.nurse_progressbar.setVisibility(View.VISIBLE);
                myviewHolderTwo.nurse_text.setVisibility(View.VISIBLE);
                myviewHolderTwo.nurse_text.setText("正在加载...");

            } else if (state == 2) {
                myviewHolderTwo.nurse_progressbar.setVisibility(View.GONE);
                myviewHolderTwo.nurse_text.setVisibility(View.VISIBLE);
                myviewHolderTwo.nurse_text.setText("没有更多数据啦！");

            } else if (state == 3) {
                myviewHolderTwo.nurse_progressbar.setVisibility(View.GONE);
                myviewHolderTwo.nurse_text.setVisibility(View.GONE);
            }

        }

    }

    @Override
    public int getItemCount() {
        return meQJWork.getMeQJWork().getDatas().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        LinearLayout firstmain_qj_time2_layout;
        TextView firstmain_qj_liucmc;
        TextView firstmain_qj_sqtime;
        TextView firstmain_qj_qjtype;
        TextView firstmain_qj_qjtime1;
        TextView firstmain_qj_qjtime2;
        TextView firstmain_qj_lcbz;
        TextView firstmain_qj_state;
        TextView firstmain_qj_tianshu;

        public MyViewHolder(View itemView) {
            super(itemView);
            firstmain_qj_time2_layout = (LinearLayout) itemView.findViewById(R.id.firstmain_qj_time2_layout);
            firstmain_qj_liucmc = (TextView) itemView.findViewById(R.id.firstmain_qj_liucmc);
            firstmain_qj_sqtime = (TextView) itemView.findViewById(R.id.firstmain_qj_sqtime);
            firstmain_qj_qjtype = (TextView) itemView.findViewById(R.id.firstmain_qj_qjtype);
            firstmain_qj_qjtime1 = (TextView) itemView.findViewById(R.id.firstmain_qj_qjtime1);
            firstmain_qj_qjtime2 = (TextView) itemView.findViewById(R.id.firstmain_qj_qjtime2);
            firstmain_qj_lcbz = (TextView) itemView.findViewById(R.id.firstmain_qj_lcbz);
            firstmain_qj_state = (TextView) itemView.findViewById(R.id.firstmain_qj_state);
            firstmain_qj_tianshu = (TextView) itemView.findViewById(R.id.firstmain_qj_tianshu);
        }
    }

    public class MyViewHolderTwo extends RecyclerView.ViewHolder {
        ProgressBar nurse_progressbar;
        TextView nurse_text;

        public MyViewHolderTwo(View itemView) {
            super(itemView);
            nurse_progressbar = (ProgressBar) itemView.findViewById(R.id.nurse_progressbar);
            nurse_text = (TextView) itemView.findViewById(R.id.nurse_text);
        }
    }
}
