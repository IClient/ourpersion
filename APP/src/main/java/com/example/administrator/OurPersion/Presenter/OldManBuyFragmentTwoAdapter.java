package com.example.administrator.OurPersion.Presenter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.administrator.OurPersion.Model.Bean.OldManMedicalFeeBuy;
import com.example.administrator.OurPersion.R;

/**
 * Created by Administrator on 2017/9/21 0021.
 */

public class OldManBuyFragmentTwoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    LayoutInflater layoutInflater;
    OldManMedicalFeeBuy oldManMedicalFeeBuy;
    /**
     * 1表示正在加载
     * 2表示没有更多数据啦
     */
    public int state = 1;

    public OldManBuyFragmentTwoAdapter(OldManMedicalFeeBuy oldManMedicalFeeBuy, Context context) {
        this.oldManMedicalFeeBuy = oldManMedicalFeeBuy;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View view = layoutInflater.inflate(R.layout.oldmanbuy_fragmenttwo_item, parent, false);
            MyViewHolder holder = new MyViewHolder(view);
            return holder;
        } else {
            View view = layoutInflater.inflate(R.layout.nurseadmin_loadmore_item, parent, false);
            MyViewHolderTwo holder = new MyViewHolderTwo(view);
            return holder;

        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder) {
            final MyViewHolder viewHolder = (MyViewHolder) holder;
            viewHolder.oldmanbuy_frgamenttwo_item_time.setTag(position);
            final OldManMedicalFeeBuy.OldManMedicalFeeBuyBean.DatasBean datasBean = oldManMedicalFeeBuy.getOldManMedicalFeeBuy().getDatas().get((Integer) viewHolder.oldmanbuy_frgamenttwo_item_time.getTag());
            viewHolder.oldmanbuy_frgamenttwo_item_billnumber.setText(datasBean.getOrderNumber());
            if (datasBean.getChangeType().equals("0")) {
                viewHolder.oldmanbuy_frgamenttwo_item_type.setText("收入");
            } else if (datasBean.getChangeType().equals("1")) {
                viewHolder.oldmanbuy_frgamenttwo_item_type.setText("支出");
            }

            viewHolder.oldmanbuy_frgamenttwo_item_content.setText(datasBean.getChangeDisception());
            viewHolder.oldmanbuy_frgamenttwo_item_time.setText(datasBean.getChangeTime());
            viewHolder.oldmanbuy_frgamenttwo_item_money.setText("￥" + datasBean.getChangeAmount());
            viewHolder.oldmanbuy_frgamenttwo_item_handler.setText(datasBean.getHandlePerson());

        } else if (holder instanceof MyViewHolderTwo) {
            final MyViewHolderTwo viewHolder = (MyViewHolderTwo) holder;
            if (state == 1) {
                viewHolder.nurse_progressbar.setVisibility(View.VISIBLE);
                viewHolder.nurse_text.setVisibility(View.VISIBLE);
                viewHolder.nurse_text.setText("正在加载...");

            } else if (state == 2) {
                viewHolder.nurse_progressbar.setVisibility(View.GONE);
                viewHolder.nurse_text.setVisibility(View.VISIBLE);
                viewHolder.nurse_text.setText("没有更多数据啦!");
            }

        }
    }

    @Override
    public int getItemCount() {
        if (oldManMedicalFeeBuy.getOldManMedicalFeeBuy().getDatas().size() == 1) {
            return oldManMedicalFeeBuy.getOldManMedicalFeeBuy().getDatas().size();
        } else {
            return oldManMedicalFeeBuy.getOldManMedicalFeeBuy().getDatas().size() + 1;
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (position == oldManMedicalFeeBuy.getOldManMedicalFeeBuy().getDatas().size()) {
            return 2;
        } else {
            return 1;
        }
    }

    //一种支付类型的的viewholder
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView oldmanbuy_frgamenttwo_item_billnumber;
        TextView oldmanbuy_frgamenttwo_item_type;
        TextView oldmanbuy_frgamenttwo_item_content;
        TextView oldmanbuy_frgamenttwo_item_time;
        TextView oldmanbuy_frgamenttwo_item_money;
        TextView oldmanbuy_frgamenttwo_item_handler;


        public MyViewHolder(View itemView) {
            super(itemView);
            oldmanbuy_frgamenttwo_item_billnumber = (TextView) itemView.findViewById(R.id.oldmanbuy_frgamenttwo_item_billnumber);
            oldmanbuy_frgamenttwo_item_type = (TextView) itemView.findViewById(R.id.oldmanbuy_frgamenttwo_item_type);
            oldmanbuy_frgamenttwo_item_content = (TextView) itemView.findViewById(R.id.oldmanbuy_frgamenttwo_item_content);
            oldmanbuy_frgamenttwo_item_time = (TextView) itemView.findViewById(R.id.oldmanbuy_frgamenttwo_item_time);
            oldmanbuy_frgamenttwo_item_money = (TextView) itemView.findViewById(R.id.oldmanbuy_frgamenttwo_item_money);
            oldmanbuy_frgamenttwo_item_handler = (TextView) itemView.findViewById(R.id.oldmanbuy_frgamenttwo_item_handler);

        }
    }

    //加载更多布局
    public class MyViewHolderTwo extends RecyclerView.ViewHolder {
        ProgressBar nurse_progressbar;
        TextView nurse_text;


        public MyViewHolderTwo(View itemView) {
            super(itemView);
            nurse_progressbar = (ProgressBar) itemView.findViewById(R.id.nurse_progressbar);
            nurse_text = (TextView) itemView.findViewById(R.id.nurse_text);


        }
    }

}
