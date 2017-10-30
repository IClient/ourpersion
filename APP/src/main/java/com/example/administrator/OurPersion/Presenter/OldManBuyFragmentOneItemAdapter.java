package com.example.administrator.OurPersion.Presenter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.OurPersion.Model.Bean.OldManMonthBuy;
import com.example.administrator.OurPersion.R;


/**
 * Created by Administrator on 2017/9/20 0020.
 */

public class OldManBuyFragmentOneItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    OldManMonthBuy.OldManMonthBuyBean.DatasBean bean;
    Context context;
    LayoutInflater layoutInflater;
    int[] imageid = {R.mipmap.one, R.mipmap.two, R.mipmap.three, R.mipmap.four, R.mipmap.five, R.mipmap.six, R.mipmap.seven};

    public OldManBuyFragmentOneItemAdapter(OldManMonthBuy.OldManMonthBuyBean.DatasBean bean, Context context) {
        this.bean = bean;
        this.context = context;
        layoutInflater=LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.oldmanbuy_fragmentone_itemtwo_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder viewHolder = (MyViewHolder) holder;
        viewHolder.oldmanbuy_frgamentone_item_item_time.setTag(position);
        OldManMonthBuy.OldManMonthBuyBean.DatasBean.MonthlyFeePaymentDetialsBean detialsBean = bean.getMonthlyFeePaymentDetials().get((Integer) viewHolder.oldmanbuy_frgamentone_item_item_time.getTag());
        viewHolder.oldmanbuy_frgamentone_item_item_time.setText(detialsBean.getPaymentTime());
        viewHolder.oldmanbuy_frgamentone_item_item_image.setImageResource(imageid[(int) viewHolder.oldmanbuy_frgamentone_item_item_time.getTag()]);
        viewHolder.oldmanbuy_frgamentone_item_item_money.setText("￥" + detialsBean.getPaymentCost());
        viewHolder.oldmanbuy_frgamentone_item_item_number.setText(detialsBean.getPaymentNumber());
        viewHolder.oldmanbuy_frgamentone_item_item_type.setText(detialsBean.getPaymentTypeName());
        viewHolder.oldmanbuy_frgamentone_item_item_remark.setText(detialsBean.getRemark());

    }

    @Override
    public int getItemCount() {
        return bean.getMonthlyFeePaymentDetials().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView oldmanbuy_frgamentone_item_item_image;
        TextView oldmanbuy_frgamentone_item_item_time;
        TextView oldmanbuy_frgamentone_item_item_money;
        TextView oldmanbuy_frgamentone_item_item_type;
        TextView oldmanbuy_frgamentone_item_item_number;
        TextView oldmanbuy_frgamentone_item_item_remark;

        public MyViewHolder(View itemView) {
            super(itemView);
            oldmanbuy_frgamentone_item_item_image = (ImageView) itemView.findViewById(R.id.oldmanbuy_frgamentone_item_item_image);
            oldmanbuy_frgamentone_item_item_time = (TextView) itemView.findViewById(R.id.oldmanbuy_frgamentone_item_item_time);
            oldmanbuy_frgamentone_item_item_money = (TextView) itemView.findViewById(R.id.oldmanbuy_frgamentone_item_item_money);
            oldmanbuy_frgamentone_item_item_type = (TextView) itemView.findViewById(R.id.oldmanbuy_frgamentone_item_item_type);
            oldmanbuy_frgamentone_item_item_number = (TextView) itemView.findViewById(R.id.oldmanbuy_frgamentone_item_item_number);
            oldmanbuy_frgamentone_item_item_remark = (TextView) itemView.findViewById(R.id.oldmanbuy_frgamentone_item_item_remark);


        }
    }

}
