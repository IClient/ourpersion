package com.example.administrator.OurPersion.Presenter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.OurPersion.Model.Bean.EventBean1;
import com.example.administrator.OurPersion.Model.Bean.OldManPlanItem;
import com.example.administrator.OurPersion.R;


import org.greenrobot.eventbus.EventBus;


/**
 * Created by Administrator on 2017/9/12 0012.
 */

public class FirstMainPlanAddDialogAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    LayoutInflater layoutInflater;
    OldManPlanItem oldManPlanItem;
    String remark = "";

    public static int itemtype = 1;

    public FirstMainPlanAddDialogAdapter(Context context, OldManPlanItem oldManPlanItem) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.oldManPlanItem = oldManPlanItem;


    }

    @Override
    public int getItemViewType(int position) {
        //--0表示编辑，1.2表示选择框
        if (oldManPlanItem.getOldManPlanItem().get(position).getHtmlTagType().equals("0")) {
            return 1;
        } else {
            return 2;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View view = layoutInflater.inflate(R.layout.activity_firstmain_plan_add_itemtwo, parent, false);
            MyViewHolder1 viewHolder = new MyViewHolder1(view);
            return viewHolder;
        } else if (viewType == 2) {
            View view = layoutInflater.inflate(R.layout.activity_firstadmin_plan_add_itemone, parent, false);
            MyViewHolder viewHolder = new MyViewHolder(view);
            return viewHolder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder) {
            itemtype = 1;
            final MyViewHolder viewHolder = (MyViewHolder) holder;
            final OldManPlanItem.OldManPlanItemBean oldManPlanItemBean = oldManPlanItem.getOldManPlanItem().get(position);
            viewHolder.name.setText(oldManPlanItemBean.getSubItemName());
            viewHolder.caozuo.setChecked(false);
            //--这个子项目有勾选，只有勾选的才传入
            viewHolder.caozuo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (viewHolder.caozuo.isChecked()) {
                        oldManPlanItemBean.setIsSelect("1");

                    } else {
                        oldManPlanItemBean.setIsSelect("0");
                    }
                    EventBus.getDefault().post(new EventBean1(remark, oldManPlanItem));
                }
            });
        }
        //--这个子项目没有勾选，只有值和备注，所有要全部传递
        else if (holder instanceof MyViewHolder1) {
            itemtype = 2;
            MyViewHolder1 viewHolder = (MyViewHolder1) holder;
            final OldManPlanItem.OldManPlanItemBean oldManPlanItemBean = oldManPlanItem.getOldManPlanItem().get(position);
            viewHolder.name.setText(oldManPlanItemBean.getSubItemName());
            viewHolder.caozuo.setText(oldManPlanItemBean.getSubStandardVal());
            viewHolder.caozuo.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }

                @Override
                public void afterTextChanged(Editable s) {
                    oldManPlanItemBean.setSubStandardVal(s.toString());
                }
            });
            //--这里o表示未选中，1表示选中
            for (int i = 0; i < oldManPlanItem.getOldManPlanItem().size(); i++) {
                oldManPlanItem.getOldManPlanItem().get(i).setIsSelect("1");

            }
        }
    }


    @Override
    public int getItemCount() {
        return oldManPlanItem.getOldManPlanItem().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        CheckBox caozuo;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.add_name);
            caozuo = (CheckBox) itemView.findViewById(R.id.add_caozuo);
        }
    }

    public class MyViewHolder1 extends RecyclerView.ViewHolder {
        TextView name;
        EditText caozuo;


        public MyViewHolder1(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.add_name);
            caozuo = (EditText) itemView.findViewById(R.id.add_caozuo);
        }
    }

}
