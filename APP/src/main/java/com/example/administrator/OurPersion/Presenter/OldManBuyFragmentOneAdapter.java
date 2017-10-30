package com.example.administrator.OurPersion.Presenter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.administrator.OurPersion.Model.Bean.OldManMonthBuy;
import com.example.administrator.OurPersion.R;

/**
 * Created by Administrator on 2017/9/20 0020.
 */

public class OldManBuyFragmentOneAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    LayoutInflater layoutInflater;
    OldManMonthBuy oldManBuy;
    /**
     * 1表示正在加载
     * 2表示没有更多数据啦
     */
    public int state = 1;

    public OldManBuyFragmentOneAdapter(OldManMonthBuy oldManBuy, Context context) {
        this.oldManBuy = oldManBuy;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View view = layoutInflater.inflate(R.layout.oldmanbuy_fragmentone_itemone, parent, false);
            MyViewHolder holder = new MyViewHolder(view);
            return holder;
        } else if (viewType == 2) {
            View view = layoutInflater.inflate(R.layout.oldmanbuy_fragmentone_itemtwo, parent, false);
            MyViewHoldertwo holder = new MyViewHoldertwo(view);
            return holder;
        } else if (viewType == 3) {
            View view = layoutInflater.inflate(R.layout.nurseadmin_loadmore_item, parent, false);
            MyViewHolderthree holder = new MyViewHolderthree(view);
            return holder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder) {
            //--支付类型只有一种的情况,
            final MyViewHolder viewHolder = (MyViewHolder) holder;
            viewHolder.oldmanbuy_frgamentone_item_time.setTag(position);
            final OldManMonthBuy.OldManMonthBuyBean.DatasBean datasBean = oldManBuy.getOldManMonthBuy().getDatas().get((Integer) viewHolder.oldmanbuy_frgamentone_item_time.getTag());
            viewHolder.oldmanbuy_frgamentone_item_type.setText(datasBean.getMonthlyFeePaymentDetials().get(0).getPaymentTypeName());
            viewHolder.oldmanbuy_frgamentone_item_money.setText("￥" + datasBean.getMonthlyFeePaymentDetials().get(0).getPaymentCost() + "");
            viewHolder.oldmanbuy_frgamentone_item_money.setTextColor(Color.parseColor("#323232"));
            viewHolder.oldmanbuy_frgamentone_item_number.setText(datasBean.getMonthlyFeePaymentDetials().get(0).getPaymentNumber());
            viewHolder.oldmanbuy_frgamentone_item_time.setText(datasBean.getMonthlyFeePaymentDetials().get(0).getPaymentTime());
            viewHolder.oldmanbuy_frgamentone_item_billnumber.setText(datasBean.getBillNumber());
            viewHolder.oldmanbuy_frgamentone_item_remark.setText(datasBean.getMonthlyFeePaymentDetials().get(0).getRemark());

        } else if (holder instanceof MyViewHoldertwo) {
            //--如果有多种就要嵌套rv
            final MyViewHoldertwo viewHolder = (MyViewHoldertwo) holder;
            viewHolder.oldmanbuy_frgamentone_itemtwo_time.setTag(position);
            final OldManMonthBuy.OldManMonthBuyBean.DatasBean datasBean = oldManBuy.getOldManMonthBuy().getDatas().get((Integer) viewHolder.oldmanbuy_frgamentone_itemtwo_time.getTag());
            viewHolder.oldmanbuy_frgamentone_itemtwo_money.setText("￥" + datasBean.getPaymentAmount() + "");
            viewHolder.oldmanbuy_frgamentone_itemtwo_money.setTextColor(Color.parseColor("#1874CD"));
            viewHolder.oldmanbuy_frgamentone_itemtwo_time.setText(datasBean.getPaymentTime());
            viewHolder.oldmanbuy_frgamentone_itemtwo_billnumber.setText(datasBean.getBillNumber());
            viewHolder.oldmanbuy_frgamentone_itemtwo_money_layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (viewHolder.itemtwo_rv_rv.isShown()) {
                        viewHolder.itemtwo_rv_rv.setVisibility(View.GONE);
                        viewHolder.oldmanbuy_frgamentone_itemtwo_image.setImageResource(R.mipmap.left);

                    } else {
                        OldManBuyFragmentOneItemAdapter adapter = new OldManBuyFragmentOneItemAdapter(datasBean, context);
                        viewHolder.itemtwo_rv_rv.setHasFixedSize(true);
                        viewHolder.itemtwo_rv_rv.setLayoutManager(new LinearLayoutManager(context));
                        viewHolder.itemtwo_rv_rv.setAdapter(adapter);
                        viewHolder.itemtwo_rv_rv.setVisibility(View.VISIBLE);
                        viewHolder.oldmanbuy_frgamentone_itemtwo_image.setImageResource(R.mipmap.bottom);
                    }

                }
            });

        } else if (holder instanceof MyViewHolderthree) {
            //--脚布局根据state判断是否有数据
            final MyViewHolderthree viewHolder = (MyViewHolderthree) holder;
            viewHolder.nurse_text.setTag(position);
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
        if (oldManBuy.getOldManMonthBuy().getDatas().size() > 1) {
            return oldManBuy.getOldManMonthBuy().getDatas().size() + 1;
        } else {
            return oldManBuy.getOldManMonthBuy().getDatas().size();
        }
    }

    /**
     * @param position
     * @return 3表示脚布局，2表示多种支付类型，1表示只有一种支付类型
     */
    @Override
    public int getItemViewType(int position) {
        if (position == oldManBuy.getOldManMonthBuy().getDatas().size()) {
            return 3;
        } else {
            if (oldManBuy.getOldManMonthBuy().getDatas().get(position).getMonthlyFeePaymentDetials().size() == 1) {
                return 1;

            } else if (oldManBuy.getOldManMonthBuy().getDatas().get(position).getMonthlyFeePaymentDetials().size() > 1 || oldManBuy.getOldManMonthBuy().getDatas().get(position).getMonthlyFeePaymentDetials().size() == 0) {
                return 2;
            }
        }
        return 0;

    }

    //一种支付类型的的viewholder
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView oldmanbuy_frgamentone_item_type;
        TextView oldmanbuy_frgamentone_item_money;
        TextView oldmanbuy_frgamentone_item_number;
        TextView oldmanbuy_frgamentone_item_time;
        TextView oldmanbuy_frgamentone_item_billnumber;
        TextView oldmanbuy_frgamentone_item_remark;


        public MyViewHolder(View itemView) {
            super(itemView);
            oldmanbuy_frgamentone_item_type = (TextView) itemView.findViewById(R.id.oldmanbuy_frgamentone_item_type);
            oldmanbuy_frgamentone_item_money = (TextView) itemView.findViewById(R.id.oldmanbuy_frgamentone_item_money);
            oldmanbuy_frgamentone_item_number = (TextView) itemView.findViewById(R.id.oldmanbuy_frgamentone_item_number);
            oldmanbuy_frgamentone_item_time = (TextView) itemView.findViewById(R.id.oldmanbuy_frgamentone_item_time);
            oldmanbuy_frgamentone_item_billnumber = (TextView) itemView.findViewById(R.id.oldmanbuy_frgamentone_item_billnumber);
            oldmanbuy_frgamentone_item_remark = (TextView) itemView.findViewById(R.id.oldmanbuy_frgamentone_item_remark);

        }
    }

    //多种支付类型的viewholder
    public class MyViewHoldertwo extends RecyclerView.ViewHolder {
        TextView oldmanbuy_frgamentone_itemtwo_time;
        TextView oldmanbuy_frgamentone_itemtwo_billnumber;
        LinearLayout oldmanbuy_frgamentone_itemtwo_money_layout;
        TextView oldmanbuy_frgamentone_itemtwo_money;
        ImageView oldmanbuy_frgamentone_itemtwo_image;
        RecyclerView itemtwo_rv_rv;


        public MyViewHoldertwo(View itemView) {
            super(itemView);
            oldmanbuy_frgamentone_itemtwo_time = (TextView) itemView.findViewById(R.id.oldmanbuy_frgamentone_itemtwo_time);
            oldmanbuy_frgamentone_itemtwo_billnumber = (TextView) itemView.findViewById(R.id.oldmanbuy_frgamentone_itemtwo_billnumber);
            oldmanbuy_frgamentone_itemtwo_money_layout = (LinearLayout) itemView.findViewById(R.id.oldmanbuy_frgamentone_itemtwo_money_layout);
            oldmanbuy_frgamentone_itemtwo_money = (TextView) itemView.findViewById(R.id.oldmanbuy_frgamentone_itemtwo_money);
            oldmanbuy_frgamentone_itemtwo_image = (ImageView) itemView.findViewById(R.id.oldmanbuy_frgamentone_itemtwo_image);
            itemtwo_rv_rv = (RecyclerView) itemView.findViewById(R.id.itemtwo_rv_rv);

        }
    }

    //脚布局的viewholder
    public class MyViewHolderthree extends RecyclerView.ViewHolder {
        ProgressBar nurse_progressbar;
        TextView nurse_text;

        public MyViewHolderthree(View itemView) {
            super(itemView);
            nurse_progressbar = (ProgressBar) itemView.findViewById(R.id.nurse_progressbar);
            nurse_text = (TextView) itemView.findViewById(R.id.nurse_text);


        }
    }
}
