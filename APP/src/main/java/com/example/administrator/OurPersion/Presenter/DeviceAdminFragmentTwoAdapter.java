package com.example.administrator.OurPersion.Presenter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.OurPersion.Model.Bean.Device;
import com.example.administrator.OurPersion.R;

import java.util.List;

/**
 * Created by Administrator on 2017/6/7 0007.
 */

public class DeviceAdminFragmentTwoAdapter extends RecyclerView.Adapter<DeviceAdminFragmentTwoAdapter.MyHolderView> {
    Context context;
    LayoutInflater layoutInflater;
    List<Device> data;

    public DeviceAdminFragmentTwoAdapter(Context context, List<Device> data) {
        this.context = context;
        this.data = data;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public MyHolderView onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.deviceadminfragmenttwo_item, parent, false);
        MyHolderView myHolderView = new MyHolderView(view);
        return myHolderView;
    }


    @Override
    public void onBindViewHolder(MyHolderView holder, int position) {
        Device device = data.get(position);
        holder.address.setText(device.getAddress());
        holder.name.setText(device.getName());
        holder.device2time.setText(device.getTime());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyHolderView extends RecyclerView.ViewHolder {
        TextView address;
        TextView name;
        TextView device2time;


        public MyHolderView(View itemView) {
            super(itemView);
            address = (TextView) itemView.findViewById(R.id.address);
            name = (TextView) itemView.findViewById(R.id.name);
            device2time = (TextView) itemView.findViewById(R.id.device2time);


        }
    }
}
