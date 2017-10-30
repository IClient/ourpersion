package com.example.administrator.OurPersion.Presenter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.administrator.OurPersion.Model.Bean.OldManAllPlan;
import com.example.administrator.OurPersion.R;

/**
 * Created by Administrator on 2017/8/21 0021.
 */

public class FirstMainPlanDialogAdapter extends RecyclerView.Adapter {
    OldManAllPlan oldManAllPlan;
    Context context;
    LayoutInflater layoutInflater;
    GetSubItemByPlan getSubItemByPlan;
    public static int isck = 0;

    public FirstMainPlanDialogAdapter(Context context, OldManAllPlan oldManAllPlan) {
        this.context = context;
        this.oldManAllPlan = oldManAllPlan;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.activity_firstmain_plan_dialog_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final OldManAllPlan.OldManAllPlanBean oldManAllPlanBean = oldManAllPlan.getOldManAllPlan().get(position);
        final MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.textView.setText(oldManAllPlanBean.getItemName());
        if (oldManAllPlanBean.getIsCheck().equals("0")) {
            myViewHolder.checkBox.setChecked(true);

        } else if (oldManAllPlanBean.getIsCheck().equals("1")) {
            myViewHolder.checkBox.setChecked(false);

        }

        //--0表示选中，1表示未选中，这里只能单选
        myViewHolder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myViewHolder.checkBox.isChecked()) {
                    //--接口回调
                    getSubItemByPlan.GetSubItem(oldManAllPlanBean.getId());
                    oldManAllPlanBean.setIsCheck("0");
                    isck = 1;
                    for (int i = 0; i < oldManAllPlan.getOldManAllPlan().size(); i++) {
                        if (i != position) {

                            oldManAllPlan.getOldManAllPlan().get(i).setIsCheck("1");

                        }
                    }
                    notifyDataSetChanged();

                } else {
                    oldManAllPlanBean.setIsCheck("1");
                    isck = 0;
                    for (int i = 0; i < oldManAllPlan.getOldManAllPlan().size(); i++) {
                        oldManAllPlan.getOldManAllPlan().get(i).setIsCheck("1");

                    }
                    notifyDataSetChanged();
                }
            }
        });

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        CheckBox checkBox;
        TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            checkBox = (CheckBox) itemView.findViewById(R.id.check);
            textView = (TextView) itemView.findViewById(R.id.dialog_type);
        }
    }

    @Override
    public int getItemCount() {
        return oldManAllPlan.getOldManAllPlan().size();
    }


    public interface GetSubItemByPlan {
        void GetSubItem(String id);

    }

    public void SetInterface(GetSubItemByPlan getSubItemByPlan) {

        this.getSubItemByPlan = getSubItemByPlan;
    }
}
