package com.example.administrator.OurPersion.Presenter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.amap.api.mapcore.util.ho;
import com.bumptech.glide.Glide;
import com.example.administrator.OurPersion.Model.Bean.OkHttpURL;
import com.example.administrator.OurPersion.Model.Bean.OldMan;
import com.example.administrator.OurPersion.R;
import com.example.administrator.OurPersion.SelfView.CircleImageView;
import com.example.administrator.OurPersion.View.Activity.OldManListActivity;
import com.example.administrator.OurPersion.View.Activity.ShowPhotoViewAcitivty;
import com.squareup.picasso.Picasso;

import java.util.List;


/**
 * Created by Administrator on 2017/6/5 0005.
 */

public class OldManListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<OldMan.OldManListBean.DatasBean> list;
    private LayoutInflater layoutInflater;
    OnclickInterFace interFace;
    public int state = 1;

    public OldManListAdapter(Context context, List<OldMan.OldManListBean.DatasBean> list) {
        this.context = context;
        this.list = list;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 2) {
            View view = layoutInflater.inflate(R.layout.oldmanlist_item, parent, false);
            MyviewHolder holder = new MyviewHolder(view);
            return holder;
        } else {
            View view = layoutInflater.inflate(R.layout.nurseadmin_loadmore_item, parent, false);
            MyviewHolderTwo holder = new MyviewHolderTwo(view);
            return holder;
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof MyviewHolder) {
            MyviewHolder myviewHolder = (MyviewHolder) holder;
            final OldMan.OldManListBean.DatasBean man = list.get(position);
            myviewHolder.oldmanlist_name.setText(man.getCustomerName().toString());
            if (man.getSex().equals("0")) {

                myviewHolder.oldmanlist_sex.setText("男");
            } else if (man.getSex().equals("1")) {
                myviewHolder.oldmanlist_sex.setText("女");
            }
            myviewHolder.oldmanlist_phone.setText(man.getPhoneNumber().toString());
            myviewHolder.oldmanlist_image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ShowPhotoViewAcitivty.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("oldmanimage", OkHttpURL.ImageURL + man.getImgPath());
                    intent.putExtras(bundle);
                    context.startActivity(intent);
                }
            });
            myviewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    interFace.Onclick(position,list);
                }
            });
            Picasso.with(context).load(OkHttpURL.ImageURL + man.getImgPath()).placeholder(R.mipmap.oldone).into(myviewHolder.oldmanlist_image);
        } else if (holder instanceof MyviewHolderTwo) {
            MyviewHolderTwo myviewHolderTwo = (MyviewHolderTwo) holder;
            if (state == 1) {
                myviewHolderTwo.nurse_progressbar.setVisibility(View.VISIBLE);
                myviewHolderTwo.nurse_text.setVisibility(View.VISIBLE);
                myviewHolderTwo.nurse_text.setText("正在加载...");

            } else if (state == 2) {
                myviewHolderTwo.nurse_progressbar.setVisibility(View.GONE);
                myviewHolderTwo.nurse_text.setVisibility(View.VISIBLE);
                myviewHolderTwo.nurse_text.setText("没有更多数据啦！");

            } else if (state == 3) {
                myviewHolderTwo.nurse_progressbar.setVisibility(View.GONE);
                myviewHolderTwo.nurse_text.setVisibility(View.GONE);
            }

        }

    }

    @Override
    public int getItemCount() {
        return list.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == list.size()) {
            return 1;
        } else {
            return 2;
        }

    }

    public class MyviewHolder extends RecyclerView.ViewHolder {

        CircleImageView oldmanlist_image;
        TextView oldmanlist_name;
        TextView oldmanlist_sex;
        TextView oldmanlist_phone;


        public MyviewHolder(View itemView) {
            super(itemView);
            oldmanlist_image = (CircleImageView) itemView.findViewById(R.id.oldmanlist_image);
            oldmanlist_name = (TextView) itemView.findViewById(R.id.oldmanlist_name);
            oldmanlist_sex = (TextView) itemView.findViewById(R.id.oldmanlist_sex);
            oldmanlist_phone = (TextView) itemView.findViewById(R.id.oldmanlist_phone);
        }
    }

    public class MyviewHolderTwo extends RecyclerView.ViewHolder {

        ProgressBar nurse_progressbar;
        TextView nurse_text;

        public MyviewHolderTwo(View itemView) {
            super(itemView);
            nurse_progressbar = (ProgressBar) itemView.findViewById(R.id.nurse_progressbar);
            nurse_text = (TextView) itemView.findViewById(R.id.nurse_text);
        }
    }

    public interface OnclickInterFace {
        void Onclick(int position,List<OldMan.OldManListBean.DatasBean>list);

    }

    public void SetInterface(OnclickInterFace interFace) {
        this.interFace = interFace;

    }
}
