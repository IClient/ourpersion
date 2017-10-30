package com.example.administrator.OurPersion.Presenter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.OurPersion.Model.Bean.OldManFamily;
import com.example.administrator.OurPersion.R;

import java.util.List;

/**
 * Created by Administrator on 2017/8/25 0025.
 */

public class OldManFamilyAdapter extends RecyclerView.Adapter<OldManFamilyAdapter.MyviewHolder> {
    private Context context;
    private List<OldManFamily.OldManFamilyBean> list;
    private LayoutInflater layoutInflater;


    public OldManFamilyAdapter(Context context, List<OldManFamily.OldManFamilyBean> list) {
        this.context = context;
        this.list = list;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public MyviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.oldmanfamily_item, parent, false);
        MyviewHolder holder = new MyviewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyviewHolder holder, final int position) {
        OldManFamily.OldManFamilyBean familyBean = list.get(position);
        if (TextUtils.isEmpty(familyBean.getChaperoneName())) {
            holder.oldman_familtitem_name.setText("");
        } else {
            holder.oldman_familtitem_name.setText(familyBean.getChaperoneName());
        }
        if (TextUtils.isEmpty(familyBean.getSex())) {
            holder.oldman_familtitem_sex.setText("");

        } else if (familyBean.getSex().equals("0")) {
            holder.oldman_familtitem_sex.setText("男");
        } else if (familyBean.getSex().equals("1")) {
            holder.oldman_familtitem_sex.setText("女");
        }
        if (TextUtils.isEmpty(familyBean.getRelation())) {
            holder.oldman_familtitem_guanxi.setText("");
        } else {
            holder.oldman_familtitem_guanxi.setText(familyBean.getRelation());
        }
        if (TextUtils.isEmpty(familyBean.getTelNo())) {
            holder.oldman_familtitem_phone.setText("");
        } else {
            holder.oldman_familtitem_phone.setText(familyBean.getTelNo());
        }
        if (TextUtils.isEmpty(familyBean.getCertificateNo())) {
            holder.oldman_familtitem_book.setText("");

        } else {
            holder.oldman_familtitem_book.setText(familyBean.getCertificateNo());

        }
        if (TextUtils.isEmpty(familyBean.getAddress())) {
            holder.oldman_familtitem_address.setText("");
        } else {
            holder.oldman_familtitem_address.setText(familyBean.getAddress());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        TextView oldman_familtitem_name;
        TextView oldman_familtitem_sex;
        TextView oldman_familtitem_guanxi;
        TextView oldman_familtitem_phone;
        TextView oldman_familtitem_book;
        TextView oldman_familtitem_address;


        public MyviewHolder(View itemView) {
            super(itemView);
            oldman_familtitem_name = (TextView) itemView.findViewById(R.id.oldman_familtitem_name);
            oldman_familtitem_sex = (TextView) itemView.findViewById(R.id.oldman_familtitem_sex);
            oldman_familtitem_guanxi = (TextView) itemView.findViewById(R.id.oldman_familtitem_guanxi);
            oldman_familtitem_phone = (TextView) itemView.findViewById(R.id.oldman_familtitem_phone);
            oldman_familtitem_book = (TextView) itemView.findViewById(R.id.oldman_familtitem_book);
            oldman_familtitem_address = (TextView) itemView.findViewById(R.id.oldman_familtitem_address);


        }
    }

}
