package com.example.administrator.OurPersion.Presenter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.OurPersion.Model.Bean.AreaOldMan;
import com.example.administrator.OurPersion.Model.Bean.OkHttpURL;
import com.example.administrator.OurPersion.R;
import com.example.administrator.OurPersion.SelfView.CircleImageView;
import com.example.administrator.OurPersion.View.Activity.ShowPhotoViewAcitivty;
import com.squareup.picasso.Picasso;

/**
 * Created by Administrator on 2017/9/30 0030.
 */

public class FirstMainOldManAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    AreaOldMan areaOldMan;
    LayoutInflater layoutInflater;
    OnclickInterFace interFace;

    public FirstMainOldManAdapter(AreaOldMan areaOldMan, Context context) {
        this.areaOldMan = areaOldMan;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.activity_firstmain_oldman_item, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final MyViewHolder viewHolder = (MyViewHolder) holder;
        viewHolder.firstmain_oldman_name.setTag(position);
        final AreaOldMan.AreaOldManBean areaOldManBean = areaOldMan.getAreaOldMan().get((Integer) viewHolder.firstmain_oldman_name.getTag());
        viewHolder.firstmain_oldman_name.setText(areaOldManBean.getCustomerName().toString().trim());
        if (areaOldManBean.getSex().equals("0")) {

            viewHolder.firstmain_oldman_sex.setText("男");
        } else if (areaOldManBean.getSex().equals("1")) {
            viewHolder.firstmain_oldman_sex.setText("女");
        }
        viewHolder.firstmain_oldman_phone.setText(areaOldManBean.getPhoneNumber().toString());
        viewHolder.firstmain_oldman_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ShowPhotoViewAcitivty.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("firstmainoldmanimage", OkHttpURL.ImageURL + areaOldManBean.getImgPath());
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interFace.Onclick((Integer) viewHolder.firstmain_oldman_name.getTag());
            }
        });
        Picasso.with(context).load(OkHttpURL.ImageURL + areaOldManBean.getImgPath()).placeholder(R.mipmap.oldone).into(viewHolder.firstmain_oldman_image);
    }

    @Override
    public int getItemCount() {
        return areaOldMan.getAreaOldMan().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        CircleImageView firstmain_oldman_image;
        TextView firstmain_oldman_name;
        TextView firstmain_oldman_sex;
        TextView firstmain_oldman_phone;

        public MyViewHolder(View itemView) {
            super(itemView);
            firstmain_oldman_image = (CircleImageView) itemView.findViewById(R.id.firstmain_oldman_image);
            firstmain_oldman_name = (TextView) itemView.findViewById(R.id.firstmain_oldman_name);
            firstmain_oldman_sex = (TextView) itemView.findViewById(R.id.firstmain_oldman_sex);
            firstmain_oldman_phone = (TextView) itemView.findViewById(R.id.firstmain_oldman_phone);
        }
    }

    public interface OnclickInterFace {
        void Onclick(int position);

    }

    public void SetInterface(OnclickInterFace interFace) {
        this.interFace = interFace;

    }
}
