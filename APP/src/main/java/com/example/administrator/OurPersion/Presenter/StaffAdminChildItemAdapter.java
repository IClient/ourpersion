package com.example.administrator.OurPersion.Presenter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.OurPersion.Model.Bean.Work;
import com.example.administrator.OurPersion.R;

/**
 * Created by Administrator on 2017/9/26 0026.
 */

public class StaffAdminChildItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Work.WorkBean workBean;
    Context context;
    LayoutInflater layoutInflater;
    String name = "";

    public StaffAdminChildItemAdapter(Context context, Work.WorkBean workBean) {
        this.context = context;
        this.workBean = workBean;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.staffadmin_child_item_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        name = "";
        MyViewHolder viewHolder = (MyViewHolder) holder;
        viewHolder.staffadmin_child_item_item_groupname.setTag(position);
        Work.WorkBean.GroupDateManagesBean managesBean = workBean.getGroupDateManages().get((Integer) viewHolder.staffadmin_child_item_item_groupname.getTag());
        viewHolder.staffadmin_child_item_item_groupname.setText(managesBean.getGroupName());
        for (int i = 0; i < managesBean.getGroupEmployees().size(); i++) {
            name = name + managesBean.getGroupEmployees().get(i).getEmployeeName().toString().trim();
            if (i != managesBean.getGroupEmployees().size() - 1) {
                name = name + ",";
            }

        }
        viewHolder.staffadmin_child_item_item_name.setText(name);

        viewHolder.staffadmin_child_item_item_time.setText(managesBean.getBeginTime() + "-" + managesBean.getEndTime());
    }

    @Override
    public int getItemCount() {
        return workBean.getGroupDateManages().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView staffadmin_child_item_item_groupname;
        TextView staffadmin_child_item_item_time;
        TextView staffadmin_child_item_item_name;


        public MyViewHolder(View itemView) {
            super(itemView);
            staffadmin_child_item_item_groupname = (TextView) itemView.findViewById(R.id.staffadmin_child_item_item_groupname);
            staffadmin_child_item_item_time = (TextView) itemView.findViewById(R.id.staffadmin_child_item_item_time);
            staffadmin_child_item_item_name = (TextView) itemView.findViewById(R.id.staffadmin_child_item_item_name);
        }
    }
}
