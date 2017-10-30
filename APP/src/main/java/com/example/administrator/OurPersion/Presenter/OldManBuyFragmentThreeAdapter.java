package com.example.administrator.OurPersion.Presenter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.example.administrator.OurPersion.Model.Bean.OldManOtherBuy;
import com.example.administrator.OurPersion.R;

/**
 * Created by Administrator on 2017/9/21 0021.
 */

public class OldManBuyFragmentThreeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    LayoutInflater layoutInflater;
    OldManOtherBuy oldManOtherBuy;
    /**
     * 1表示正在加载
     * 2表示没有更多数据啦
     */
    public int state = 1;

    public OldManBuyFragmentThreeAdapter(OldManOtherBuy oldManOtherBuy, Context context) {
        this.oldManOtherBuy = oldManOtherBuy;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View view = layoutInflater.inflate(R.layout.oldmanbuy_fragmentthree_item, parent, false);
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
            viewHolder.oldmanbuy_frgamentthree_item_time.setTag(position);
            final OldManOtherBuy.OldManOtherBuyBean.DatasBean datasBean = oldManOtherBuy.getOldManOtherBuy().getDatas().get((Integer) viewHolder.oldmanbuy_frgamentthree_item_time.getTag());

            if (datasBean.getState().equals("0")) {
                viewHolder.oldmanbuy_frgamentthree_item_state.setText("未结算");
            } else if (datasBean.getState().equals("1")) {
                viewHolder.oldmanbuy_frgamentthree_item_state.setText("已结算");
            }

            viewHolder.oldmanbuy_frgamentthree_item_time.setText(datasBean.getProduceTime());
            viewHolder.oldmanbuy_frgamentthree_item_money.setText("￥" + datasBean.getCostAmount());
            viewHolder.oldmanbuy_frgamentthree_item_content.setText(datasBean.getCostDesception());
            viewHolder.oldmanbuy_frgamentthree_item_remark.setText(datasBean.getRemark());

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
        if (oldManOtherBuy.getOldManOtherBuy().getDatas().size() == 1) {
            return oldManOtherBuy.getOldManOtherBuy().getDatas().size();
        } else {
            return oldManOtherBuy.getOldManOtherBuy().getDatas().size() + 1;
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (position == oldManOtherBuy.getOldManOtherBuy().getDatas().size()) {
            return 2;
        } else {
            return 1;
        }
    }

    //一种支付类型的的viewholder
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView oldmanbuy_frgamentthree_item_time;
        TextView oldmanbuy_frgamentthree_item_money;
        TextView oldmanbuy_frgamentthree_item_content;
        TextView oldmanbuy_frgamentthree_item_state;
        TextView oldmanbuy_frgamentthree_item_remark;


        public MyViewHolder(View itemView) {
            super(itemView);
            oldmanbuy_frgamentthree_item_time = (TextView) itemView.findViewById(R.id.oldmanbuy_frgamentthree_item_time);
            oldmanbuy_frgamentthree_item_money = (TextView) itemView.findViewById(R.id.oldmanbuy_frgamentthree_item_money);
            oldmanbuy_frgamentthree_item_content = (TextView) itemView.findViewById(R.id.oldmanbuy_frgamentthree_item_content);
            oldmanbuy_frgamentthree_item_state = (TextView) itemView.findViewById(R.id.oldmanbuy_frgamentthree_item_state);
            oldmanbuy_frgamentthree_item_remark = (TextView) itemView.findViewById(R.id.oldmanbuy_frgamentthree_item_remark);


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
