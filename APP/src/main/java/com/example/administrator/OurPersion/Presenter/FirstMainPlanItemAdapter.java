package com.example.administrator.OurPersion.Presenter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.OurPersion.Model.Bean.OldManPlan;
import com.example.administrator.OurPersion.Model.Bean.OldManPlanItem;
import com.example.administrator.OurPersion.R;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/8 0008.
 * 这个适配器有两个地方用到，所以要判断数据是否Null
 */

public class FirstMainPlanItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    LayoutInflater layoutInflater;
    OldManPlanItem oldManPlanItem;
    //--存取单选状态的接口
    public static Map<Integer, Object> map = new HashMap<>();
    //--区分加载那种布局来决定post的数据
    public static int itemtype = 1;
    OldManPlan.OldManPlanBean.NursingPlansBean nursingPlansBean;

    public FirstMainPlanItemAdapter(Context context, OldManPlanItem oldManPlanItem, OldManPlan.OldManPlanBean.NursingPlansBean nursingPlansBean) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.oldManPlanItem = oldManPlanItem;
        this.nursingPlansBean = nursingPlansBean;
        for (int i = 0; i < oldManPlanItem.getOldManPlanItem().size(); i++) {
            for (int j = 0; j < nursingPlansBean.getSubIdAndVal().size(); j++) {
                if (oldManPlanItem.getOldManPlanItem().get(i).getId().equals(nursingPlansBean.getSubIdAndVal().get(j).getSubItemId())) {
                    map.put(i, true);
                    break;
                } else {
                    map.put(i, false);
                }

            }

        }
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
            View view = layoutInflater.inflate(R.layout.activity_firstmain_plan_planitemrv_itemtwo, parent, false);
            MyViewHolder1 viewHolder = new MyViewHolder1(view);
            return viewHolder;
        } else if (viewType == 2) {
            View view = layoutInflater.inflate(R.layout.activity_firstmain_plan_planitemrv_itemone, parent, false);
            MyViewHolder viewHolder = new MyViewHolder(view);
            return viewHolder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof MyViewHolder) {
            itemtype = 1;
            final MyViewHolder viewHolder = (MyViewHolder) holder;
            viewHolder.caozuo.setTag(position);
            viewHolder.caozuo.setChecked((boolean) map.get(position));
            OldManPlanItem.OldManPlanItemBean oldManPlanItemBean = oldManPlanItem.getOldManPlanItem().get((int) viewHolder.caozuo.getTag());
            viewHolder.name.setText(oldManPlanItemBean.getSubItemName());
            viewHolder.caozuo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        map.put((int) viewHolder.caozuo.getTag(), true);

                    } else {
                        map.put((int) viewHolder.caozuo.getTag(), false);
                    }
                }
            });

        } else if (holder instanceof MyViewHolder1) {
            itemtype = 2;
            final MyViewHolder1 viewHolder = (MyViewHolder1) holder;
            viewHolder.caozuo.setTag(position);
            final OldManPlanItem.OldManPlanItemBean oldManPlanItemBean = oldManPlanItem.getOldManPlanItem().get((Integer) viewHolder.caozuo.getTag());
            viewHolder.name.setText(oldManPlanItemBean.getSubItemName());
            viewHolder.caozuo.setText(oldManPlanItemBean.getSubStandardVal());
            viewHolder.caozuo.setSelection(oldManPlanItemBean.getSubStandardVal().length());
            for (int i = 0; i < nursingPlansBean.getSubIdAndVal().size(); i++) {
                if (nursingPlansBean.getSubIdAndVal().get(i).getSubItemId().equals(oldManPlanItemBean.getId())) {
                    if (nursingPlansBean.getSubIdAndVal().get(i).getSubVal() == null) {
                        viewHolder.caozuo.setText(oldManPlanItemBean.getSubStandardVal());
                        viewHolder.caozuo.setSelection(oldManPlanItemBean.getSubStandardVal().length());

                    } else {
                        viewHolder.caozuo.setText(nursingPlansBean.getSubIdAndVal().get(i).getSubVal().toString());
                        viewHolder.caozuo.setSelection(nursingPlansBean.getSubIdAndVal().get(i).getSubVal().toString().length());

                    }
                }

            }
            //设置得到的值
            oldManPlanItemBean.setSetValue(viewHolder.caozuo.getText().toString());
            //--编辑
            viewHolder.caozuo.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {

                    oldManPlanItemBean.setSetValue(s.toString());


                }
            });
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
            name = (TextView) itemView.findViewById(R.id.name);
            caozuo = (CheckBox) itemView.findViewById(R.id.caozuo);


        }
    }

    public class MyViewHolder1 extends RecyclerView.ViewHolder {
        TextView name;
        EditText caozuo;


        public MyViewHolder1(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            caozuo = (EditText) itemView.findViewById(R.id.caozuo);

        }
    }
}
