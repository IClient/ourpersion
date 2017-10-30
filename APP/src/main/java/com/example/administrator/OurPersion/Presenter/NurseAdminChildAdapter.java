package com.example.administrator.OurPersion.Presenter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.OurPersion.Model.Bean.AllOldManPlan;
import com.example.administrator.OurPersion.R;

import java.util.List;

/**
 * Created by Administrator on 2017/9/19 0019.
 */

public class NurseAdminChildAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    LayoutInflater layoutInflater;
    List<AllOldManPlan.AllOldManPlanBean.NursingPlansBean> list;

    public NurseAdminChildAdapter(   List<AllOldManPlan.AllOldManPlanBean.NursingPlansBean> list, Context context) {
        this.list = list;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.nurseadmin_child_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder viewHolder = (MyViewHolder) holder;
        viewHolder.nurseadminchild_item_time.setTag(position);
        AllOldManPlan.AllOldManPlanBean.NursingPlansBean nursingPlansBean = list.get((Integer) viewHolder.nurseadminchild_item_time.getTag());
        viewHolder.nurseadminchild_item_time.setText(nursingPlansBean.getBeginTime().substring(nursingPlansBean.getBeginTime().length() - 8, nursingPlansBean.getBeginTime().length() - 3) + "-" + nursingPlansBean.getEndTime().substring(nursingPlansBean.getEndTime().length() - 8, nursingPlansBean.getEndTime().length() - 3));
        viewHolder.nurseadminchild_item_name.setText(nursingPlansBean.getItemName());
        if (nursingPlansBean.getIsEnd().equals("0")) {
            viewHolder.nurseadminchild_item_type.setText("默认计划");

        }
        if (nursingPlansBean.getIsEnd().equals("1")) {
            viewHolder.nurseadminchild_item_type.setText("新增项目");
            viewHolder.nurseadminchild_item_type.setTextColor(Color.parseColor("#1874CD"));
            viewHolder.nurseadminchild_item_name.setTextColor(Color.parseColor("#1874CD"));
        }
        if (nursingPlansBean.getIsEnd().equals("2")) {
            viewHolder.nurseadminchild_item_type.setText("修改计划");

        }
        if (nursingPlansBean.getIsEnd().equals("3")) {
            viewHolder.nurseadminchild_item_type.setText("计划已取消");
            viewHolder.nurseadminchild_item_type.setTextColor(Color.RED);
            viewHolder.nurseadminchild_item_name.setTextColor(Color.RED);

        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nurseadminchild_item_time;
        TextView nurseadminchild_item_name;
        TextView nurseadminchild_item_type;

        public MyViewHolder(View itemView) {
            super(itemView);
            nurseadminchild_item_time = (TextView) itemView.findViewById(R.id.nurseadminchild_item_time);
            nurseadminchild_item_name = (TextView) itemView.findViewById(R.id.nurseadminchild_item_name);
            nurseadminchild_item_type = (TextView) itemView.findViewById(R.id.nurseadminchild_item_type);


        }
    }
}
