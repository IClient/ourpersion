package com.example.administrator.OurPersion.Presenter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.OurPersion.Model.Bean.OldManNurse;
import com.example.administrator.OurPersion.R;

/**
 * Created by Administrator on 2017/9/18 0018.
 */

public class OldManNurseAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    LayoutInflater layoutInflater;
    Context context;
    OldManNurse oldManNurse;

    public OldManNurseAdapter(Context context, OldManNurse oldManNurse) {
        this.context = context;
        this.oldManNurse = oldManNurse;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.oldmannurse_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder viewHolder = (MyViewHolder) holder;
        viewHolder.oldmannurse_item_time.setTag(position);
        OldManNurse.NursingPlansBean nursingPlansBean = oldManNurse.getNursingPlans().get((Integer) viewHolder.oldmannurse_item_time.getTag());
        viewHolder.oldmannurse_item_time.setText(nursingPlansBean.getBeginTime().substring(nursingPlansBean.getBeginTime().length() - 8, nursingPlansBean.getBeginTime().length() - 3) + "-" + nursingPlansBean.getEndTime().substring(nursingPlansBean.getEndTime().length() - 8, nursingPlansBean.getEndTime().length() - 3));
        viewHolder.oldmannurse_item_name.setText(nursingPlansBean.getItemName());
        if (nursingPlansBean.getIsEnd().equals("0")) {
            viewHolder.oldmannurse_item_type.setText("默认计划");
        } else if (nursingPlansBean.getIsEnd().equals("1")) {
            viewHolder.oldmannurse_item_type.setText("新增项目");
            viewHolder.oldmannurse_item_type.setTextColor(Color.parseColor("#1874CD"));
            viewHolder.oldmannurse_item_name.setTextColor(Color.parseColor("#1874CD"));
        } else if (nursingPlansBean.getIsEnd().equals("2")) {
            viewHolder.oldmannurse_item_type.setText("修改计划");
        } else if (nursingPlansBean.getIsEnd().equals("3")) {
            viewHolder.oldmannurse_item_type.setText("计划已取消");
            viewHolder.oldmannurse_item_type.setTextColor(Color.RED);
            viewHolder.oldmannurse_item_name.setTextColor(Color.RED);

        }
    }

    @Override
    public int getItemCount() {
        return oldManNurse.getNursingPlans().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView oldmannurse_item_time;
        TextView oldmannurse_item_name;
        TextView oldmannurse_item_type;

        public MyViewHolder(View itemView) {
            super(itemView);
            oldmannurse_item_time = (TextView) itemView.findViewById(R.id.oldmannurse_item_time);
            oldmannurse_item_name = (TextView) itemView.findViewById(R.id.oldmannurse_item_name);
            oldmannurse_item_type = (TextView) itemView.findViewById(R.id.oldmannurse_item_type);


        }
    }
}
