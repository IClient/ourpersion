package com.example.administrator.OurPersion.View.Fragment;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.example.administrator.OurPersion.Model.Bean.Device;
import com.example.administrator.OurPersion.Model.Bean.OkHttpURL;
import com.example.administrator.OurPersion.Presenter.DeviceAdminFragmentOneAdapter;
import com.example.administrator.OurPersion.R;
import com.example.administrator.OurPersion.SelfView.CircleImageView;
import com.example.administrator.OurPersion.View.Activity.BaseActivity;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2017/6/7 0007.
 */
public class DeviceAdminFragmentOne extends Fragment {
    View view;
    RecyclerView recyclerView;
    BluetoothAdapter bluetoothAdapter;
    //--列表的集合
    List<Device> data;
    DeviceAdminFragmentOneAdapter adapter;
    SwipeRefreshLayout swipeRefreshLayout;
    TextView textView;
    CircleImageView  circleImageView;


    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.deviceadmin_fragmentone, container, false);
        circleImageView= (CircleImageView) view.findViewById(R.id.deviceadminback_menu);
        Glide.with(getActivity()).load(OkHttpURL.ImageURL + BaseActivity.user.getImgPath()).fitCenter().into(circleImageView);
        //--得到本地蓝牙的类
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        data = new ArrayList<>();
        //初始化控件
        initview();
        //--如果蓝牙打开默认设置刷新，如果没打开蓝牙提示用户打开才设置刷新
        if (bluetoothAdapter.isEnabled()) {
            swipeRefreshLayout.setColorSchemeResources(R.color.blue, R.color.red);
            swipeRefreshLayout.setRefreshing(true);
            textView.setVisibility(View.VISIBLE);
        }
        adapter = new DeviceAdminFragmentOneAdapter(getContext(), data);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        //--设置广播过滤器
        IntentFilter intentFilter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        intentFilter.addAction(BluetoothDevice.ACTION_BOND_STATE_CHANGED);//状态改变
        intentFilter.addAction(BluetoothAdapter.ACTION_SCAN_MODE_CHANGED);//行动扫描模式改变了
        intentFilter.addAction(BluetoothAdapter.ACTION_STATE_CHANGED);//动作状态发生了变化
        intentFilter.addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);//扫描结束
        getActivity().registerReceiver(receiver, intentFilter);
        //判断系统版本
        if (Build.VERSION.SDK_INT >= 23) {
            //检测当前app是否拥有某个权限
            int checkCallPhonePermission = ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION);
            //判断这个权限是否已经授权过
            if (checkCallPhonePermission != PackageManager.PERMISSION_GRANTED) {
                //判断是否需要 向用户解释，为什么要申请该权限
                if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION))
                    Toast.makeText(getActivity(), "学苑养老", Toast.LENGTH_SHORT).show();
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 10);

            } else {
            }
        } else {
        }

        Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        startActivityForResult(intent, 1);
        return view;
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        bluetoothAdapter.startDiscovery();

    }

    //--自定义广播接受者
    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                BluetoothDevice bluetoothDevice = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                Device device = new Device();
                device.setAddress(bluetoothDevice.getAddress());
                device.setName(bluetoothDevice.getName());
                SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
                Date date = new Date(System.currentTimeMillis());
                device.setTime(format.format(date));
                data.add(device);
                adapter.notifyDataSetChanged();
            }
            //--如果扫描完成就停止刷新
            else if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)) {
                swipeRefreshLayout.setRefreshing(false);
                textView.setVisibility(View.GONE);
                swipeRefreshLayout.setEnabled(false);
                // 如果查找到的设备符合要连接的设备，处理
//                for (int i = 0; i < list.size(); i++) {
//                    BluetoothDevice device = list.get(i);
//                    if (device.getName().equalsIgnoreCase(device.getName())) {
//                        int connectionstate = device.getBondState();
//                        switch (connectionstate) {
//                            //---未配对
//                            case BluetoothDevice.BOND_NONE:
//                                //---配对
//                                try {
//                                    Method createBondMeThod = BluetoothDevice.class.getMethod("createBond");
//                                    createBondMeThod.invoke(device);
//                                } catch (Exception e) {
//                                    e.printStackTrace();
//                                }
//                                break;
//                            //---已配对
//                            case BluetoothDevice.BOND_BONDED:
//                                try {
////                                    Toast.makeText(getContext(), device.getAddress() + "已配对", Toast.LENGTH_SHORT).show();
//                                    //--连接
//                                    connect(device);
//                                } catch (Exception e) {
//                                    e.printStackTrace();
//
//                                }
//                                break;
//                        }
//                    }
//
//                }

            }


        }
    };


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            swipeRefreshLayout.setColorSchemeResources(R.color.blue, R.color.red);
            swipeRefreshLayout.setRefreshing(true);
            textView.setVisibility(View.VISIBLE);
            bluetoothAdapter.startDiscovery();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //---注销广播注册
        getActivity().unregisterReceiver(receiver);
        data.clear();

    }

    //    --蓝牙设备的连接
    public void connect(BluetoothDevice bluetoothDevice) throws IOException {
        // 固定的UUID
        final String pp_uuid = "00001101-0000-1000-8000-00805F9B34FB";
        UUID uuid = UUID.fromString(pp_uuid);
        BluetoothSocket bluetoothSocket = bluetoothDevice.createRfcommSocketToServiceRecord(uuid);
        bluetoothSocket.connect();

    }

    public void initview() {
        textView = (TextView) view.findViewById(R.id.deviceadminfragment1_text);
        recyclerView = (RecyclerView) view.findViewById(R.id.deviceadmin_recyclerview1);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.deviceadminfragment1_swiperefresh);

    }

    @Override
    public void onResume() {
        super.onResume();
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
