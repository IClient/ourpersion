package com.example.administrator.OurPersion.Presenter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.administrator.OurPersion.Model.Bean.OldManTrouable;
import com.example.administrator.OurPersion.R;

/**
 * Created by Administrator on 2017/9/16 0016.
 */

public class OldManTrouableAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    OldManTrouable oldManTrouable;
    Context context;
    LayoutInflater layoutInflater;

    public OldManTrouableAdapter(Context context, OldManTrouable oldManTrouable) {
        this.context = context;
        this.oldManTrouable = oldManTrouable;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.oldmantrouable_item, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder viewHolder = (MyViewHolder) holder;
        viewHolder.oldman_trouable_type.setTag(position);
        OldManTrouable.OldManTrouableBean oldManTrouableBean = oldManTrouable.getOldManTrouable().get((Integer) viewHolder.oldman_trouable_type.getTag());
        viewHolder.oldman_trouable_type.setText(IsNull(oldManTrouableBean.getClassModel().getDictionaryType()));
        viewHolder.oldman_outitem_zhonglei.setText(IsNull(oldManTrouableBean.getClassModel().getDictionaryName()));
        if (IsNull(oldManTrouableBean.getHappendTime()).contains("T")) {
            viewHolder.oldman_trouable_time.setText(IsNull(oldManTrouableBean.getHappendTime().replace("T", "-")));

        } else {
            viewHolder.oldman_trouable_time.setText(IsNull(oldManTrouableBean.getHappendTime()));
        }
        viewHolder.oldman_trouable_shuoming.setText(IsNull(oldManTrouableBean.getEventDisception()));
        viewHolder.oldman_trouable_handlepersonname.setText(IsNull(oldManTrouableBean.getHandlePersonName()));
        viewHolder.oldman_trouable_handleopinions.setText(IsNull(oldManTrouableBean.getHandleOpinions()));
        viewHolder.oldman_trouable_followup.setText(oldManTrouableBean.getStatusModel().getDictionaryName());


    }

    @Override
    public int getItemCount() {
        return oldManTrouable.getOldManTrouable().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView oldman_trouable_type;
        TextView oldman_outitem_zhonglei;
        TextView oldman_trouable_time;
        TextView oldman_trouable_shuoming;
        TextView oldman_trouable_handlepersonname;
        TextView oldman_trouable_handleopinions;
        TextView oldman_trouable_followup;


        public MyViewHolder(View itemView) {
            super(itemView);
            oldman_trouable_type = (TextView) itemView.findViewById(R.id.oldman_trouable_type);
            oldman_outitem_zhonglei = (TextView) itemView.findViewById(R.id.oldman_outitem_zhonglei);
            oldman_trouable_time = (TextView) itemView.findViewById(R.id.oldman_trouable_time);
            oldman_trouable_shuoming = (TextView) itemView.findViewById(R.id.oldman_trouable_shuoming);
            oldman_trouable_handlepersonname = (TextView) itemView.findViewById(R.id.oldman_trouable_handlepersonname);
            oldman_trouable_handleopinions = (TextView) itemView.findViewById(R.id.oldman_trouable_handleopinions);
            oldman_trouable_followup = (TextView) itemView.findViewById(R.id.oldman_trouable_followup);


        }
    }

    public String IsNull(Object str) {
        if (str == null) {
            return "";

        } else {
            if (TextUtils.isEmpty(str.toString())) {
                return "";

            } else {

                return str.toString();
            }

        }
    }
}
