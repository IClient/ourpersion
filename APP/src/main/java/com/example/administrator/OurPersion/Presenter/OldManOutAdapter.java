package com.example.administrator.OurPersion.Presenter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.OurPersion.Model.Bean.OldManOut;
import com.example.administrator.OurPersion.R;


/**
 * Created by Administrator on 2017/9/16 0016.
 */

public class OldManOutAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    OldManOut oldManOut;
    Context context;
    LayoutInflater layoutInflater;

    public OldManOutAdapter(OldManOut oldManOut, Context context) {
        this.oldManOut = oldManOut;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.oldmanout_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder viewHolder = (MyViewHolder) holder;
        viewHolder.oldman_outitem_name.setTag(position);
        OldManOut.OldManOutBean oldManOutBean = oldManOut.getOldManOut().get((Integer) viewHolder.oldman_outitem_name.getTag());
        viewHolder.oldman_outitem_name.setText(IsNull(oldManOutBean.getFamilyName()));
        viewHolder.oldman_outitem_guanxi.setText(IsNull(oldManOutBean.getRelationship()));
        viewHolder.oldman_outitem_phone.setText(IsNull(oldManOutBean.getFamilyNumber()));
        viewHolder.oldman_outitem_type.setText(IsNull(oldManOutBean.getTypeClass().getDictionaryName()));
        viewHolder.oldman_outitem_content.setText(IsNull(oldManOutBean.getOutContent()));
        if (oldManOutBean.getOutTime().contains("T")) {
            viewHolder.oldman_outitem_time.setText(IsNull(oldManOutBean.getOutTime().replace("T", "-")));
        }else{
            viewHolder.oldman_outitem_time.setText(IsNull(oldManOutBean.getOutTime()));
        }

        viewHolder.oldman_outitem_want.setText(IsNull(oldManOutBean.getPlanTime()));
        viewHolder.oldman_outitem_real.setText(IsNull(oldManOutBean.getRealTime()));

    }

    @Override
    public int getItemCount() {
        return oldManOut.getOldManOut().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView oldman_outitem_name;
        TextView oldman_outitem_guanxi;
        TextView oldman_outitem_phone;
        TextView oldman_outitem_type;
        TextView oldman_outitem_content;
        TextView oldman_outitem_time;
        TextView oldman_outitem_want;
        TextView oldman_outitem_real;


        public MyViewHolder(View itemView) {
            super(itemView);
            oldman_outitem_name = (TextView) itemView.findViewById(R.id.oldman_outitem_name);
            oldman_outitem_guanxi = (TextView) itemView.findViewById(R.id.oldman_outitem_guanxi);
            oldman_outitem_phone = (TextView) itemView.findViewById(R.id.oldman_outitem_phone);
            oldman_outitem_type = (TextView) itemView.findViewById(R.id.oldman_outitem_type);
            oldman_outitem_content = (TextView) itemView.findViewById(R.id.oldman_outitem_content);
            oldman_outitem_time = (TextView) itemView.findViewById(R.id.oldman_outitem_time);
            oldman_outitem_want = (TextView) itemView.findViewById(R.id.oldman_outitem_want);
            oldman_outitem_real = (TextView) itemView.findViewById(R.id.oldman_outitem_real);
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
