package com.example.administrator.OurPersion.Presenter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
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

public class StaffAdminChildAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    Work work;
    LayoutInflater layoutInflater;


    public StaffAdminChildAdapter(Context context, Work work) {
        this.context = context;
        this.work = work;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.staffadmin_child_item, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder viewHolder = (MyViewHolder) holder;
        viewHolder.staffadmin_child_item_type.setTag(position);
        Work.WorkBean workBean = work.getWork().get((Integer) viewHolder.staffadmin_child_item_type.getTag());
        viewHolder.staffadmin_child_item_type.setText(workBean.getGroupTypeName().toString().trim());
        StaffAdminChildItemAdapter adapter=new StaffAdminChildItemAdapter(context,workBean);
        viewHolder.recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        viewHolder.recyclerView.setLayoutManager(linearLayoutManager);
        viewHolder.recyclerView.setAdapter(adapter);

    }

    @Override
    public int getItemCount() {

        return work.getWork().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView staffadmin_child_item_type;
        RecyclerView recyclerView;

        public MyViewHolder(View itemView) {
            super(itemView);
            staffadmin_child_item_type = (TextView) itemView.findViewById(R.id.staffadmin_child_item_type);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.staffadmin_child_item_rv);

        }
    }
}
