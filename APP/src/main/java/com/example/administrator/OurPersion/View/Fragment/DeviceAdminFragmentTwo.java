package com.example.administrator.OurPersion.View.Fragment;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.administrator.OurPersion.Model.Bean.Device;
import com.example.administrator.OurPersion.Model.Bean.OkHttpURL;
import com.example.administrator.OurPersion.Presenter.DeviceAdminFragmentTwoAdapter;
import com.example.administrator.OurPersion.R;
import com.example.administrator.OurPersion.SelfView.CircleImageView;
import com.example.administrator.OurPersion.View.Activity.BaseActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017/6/7 0007.
 */

public class DeviceAdminFragmentTwo extends Fragment {
    CircleImageView circleImageView;
    RecyclerView recyclerView;
    BluetoothAdapter bluetoothAdapter;
    BluetoothDevice bluetoothDevice;
    View view;
    List<Device> data;
    DeviceAdminFragmentTwoAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.deviceadmin_fragmenttwo, container, false);
        circleImageView= (CircleImageView) view.findViewById(R.id.deviceadmin2back_menu);
        Glide.with(getActivity()).load(OkHttpURL.ImageURL + BaseActivity.user.getImgPath()).fitCenter().into(circleImageView);
        data = new ArrayList<>();
        recyclerView = (RecyclerView) view.findViewById(R.id.deviceadmin_recyclerview2);
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter.isEnabled()) {
            Set<BluetoothDevice> deviceSet = bluetoothAdapter.getBondedDevices();
            for (Iterator iterator = deviceSet.iterator(); iterator.hasNext(); ) {
                bluetoothDevice = (BluetoothDevice) iterator.next();
                Device device = new Device();
                device.setAddress(bluetoothDevice.getAddress());
                device.setName(bluetoothDevice.getName());
                SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
                Date date = new Date(System.currentTimeMillis());
                device.setTime(format.format(date));
                data.add(device);
            }
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
         adapter = new DeviceAdminFragmentTwoAdapter(getContext(), data);
        recyclerView.setAdapter(adapter);
        return view;
    }
    @Override
    public void onResume() {
        super.onResume();
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
