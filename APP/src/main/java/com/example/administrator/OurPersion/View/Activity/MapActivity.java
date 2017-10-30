package com.example.administrator.OurPersion.View.Activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;

import com.amap.api.maps.AMap;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.MapView;

import com.example.administrator.OurPersion.R;

public class MapActivity extends BaseActivity implements LocationSource, AMapLocationListener {

    private AMap aMap;
    private OnLocationChangedListener mListener;
    private MapView mMapView;
    //声明AMapLocationClient类对象
    public AMapLocationClient mapLocationClient;
    //声明AMapLocationClientOption对象
    public AMapLocationClientOption mapLocationClientOption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        mMapView = (MapView) findViewById(R.id.map);
        //在activity执行onCreate时执行mMapView.onCreate(savedInstanceState)，实现地图生命周期管理
        mMapView.onCreate(savedInstanceState);
        if (aMap == null) {
            aMap = mMapView.getMap();
        }
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION},
                    0);
        } else {
            aMap.setLocationSource(this);// 设置定位监听
            aMap.getUiSettings().setMyLocationButtonEnabled(true);// 设置默认定位按钮是否显示
            // 设置为true表示显示定位层并可触发定位，false表示隐藏定位层并不可触发定位，默认是false
            aMap.setMyLocationEnabled(true);
            // 设置定位的类型为定位模式 ，可以由定位、跟随或地图根据面向方向旋转几种
            aMap.setMyLocationType(AMap.LOCATION_TYPE_LOCATE);

        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMapView.onDestroy();
//       mapLocationClient.onDestroy();

    }

    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView.onResume ()，实现地图生命周期管理
        mMapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView.onPause ()，实现地图生命周期管理
        mMapView.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapLocationClient.stopLocation();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //在activity执行onSaveInstanceState时执行mMapView.onSaveInstanceState (outState)，实现地图生命周期管理
        mMapView.onSaveInstanceState(outState);
    }

    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
        if (aMapLocation != null) {
            if (aMapLocation.getErrorCode() == 0) {
                // 获取当前定位结果来源，如网络定位结果，详见定位类型表
                int type = aMapLocation.getLocationType();
                //定位成功回调信息，设置相关消息
                mListener.onLocationChanged(aMapLocation);// 显示系统小蓝点
//                aMapLocation.getLocationType();//获取当前定位结果来源，如网络定位结果，详见定位类型表
//                aMapLocation.getLatitude();//获取纬度
//                aMapLocation.getLongitude();//获取经度
//                aMapLocation.getAccuracy();//获取精度信息
//                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                Date date = new Date(aMapLocation.getTime());
//                df.format(date);//定位时间
//                aMapLocation.getAddress();//地址，如果option中设置isNeedAddress为false，则没有此结果，网络定位结果中会有地址信息，GPS定位不返回地址信息。
//                aMapLocation.getCountry();//国家信息
                aMapLocation.getProvince();//省信息
                aMapLocation.getCity();//城市信息
                aMapLocation.getDistrict();//城区信息
                aMapLocation.getStreet();//街道信息
                aMapLocation.getStreetNum();//街道门牌号信息
//                aMapLocation.getCityCode();//城市编码
//                aMapLocation.getAdCode();//地区编码
//                aMapLocation.getAoiName();//获取当前定位点的AOI信息
                String address = aMapLocation.getAddress();
                Toast.makeText(this, aMapLocation.getProvince() + aMapLocation.getCity() + aMapLocation.getDistrict() + aMapLocation.getStreet() + aMapLocation.getStreetNum(), Toast.LENGTH_SHORT).show();
            } else {
                //显示错误信息ErrCode是错误码，errInfo是错误信息，详见下方错误码表。
                Log.e("erro info：", aMapLocation.getErrorCode() + "---" + aMapLocation.getErrorInfo());
            }
        }
    }

    //激活定位

    @Override
    public void activate(OnLocationChangedListener onLocationChangedListener) {
        mListener = onLocationChangedListener;
        if (mapLocationClient == null) {
            //初始化AMapLocationClient，并绑定监听
            mapLocationClient = new AMapLocationClient(getApplicationContext());
            //初始化定位参数
            mapLocationClientOption = new AMapLocationClientOption();
            //设置定位精度
            mapLocationClientOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
            //是否返回地址信息
            mapLocationClientOption.setNeedAddress(true);
            //是否只定位一次
            mapLocationClientOption.setOnceLocation(false);
            //设置是否强制刷新WIFI，默认为强制刷新
            mapLocationClientOption.setWifiActiveScan(true);
            //是否允许模拟位置
            mapLocationClientOption.setMockEnable(false);
            //定位时间间隔
            mapLocationClientOption.setInterval(2000);
            //给定位客户端对象设置定位参数
            mapLocationClient.setLocationOption(mapLocationClientOption);
            //绑定监听
            mapLocationClient.setLocationListener(this);
            //开启定位
            mapLocationClient.startLocation();
        }

    }

    //停止定位
    @Override
    public void deactivate() {
        mListener = null;
        if (mapLocationClient != null) {
            mapLocationClient.stopLocation();
            mapLocationClient.onDestroy();
        }
        mapLocationClient = null;
    }


    /**
     * 0  定位成功。
     * 1  一些重要参数为空，如context；请对定位传递的参数进行非空判断。
     * 2  定位失败，由于仅扫描到单个wifi，且没有基站信息。
     * 3  获取到的请求参数为空，可能获取过程中出现异常。
     * 4  请求服务器过程中的异常，多为网络情况差，链路不通导致，请检查设备网络是否通畅。
     * 5  返回的XML格式错误，解析失败。
     * 6  定位服务返回定位失败，如果出现该异常，请将errorDetail信息通过API@autonavi.com反馈给我们。
     * 7  KEY建权失败，请仔细检查key绑定的sha1值与apk签名sha1值是否对应。
     * 8  Android exception通用错误，请将errordetail信息通过API@autonavi.com反馈给我们。
     * 9  定位初始化时出现异常，请重新启动定位。
     * 10     定位客户端启动失败，请检查AndroidManifest.xml文件是否配置了APSService定位服务
     * 11     定位时的基站信息错误，请检查是否安装SIM卡，设备很有可能连入了伪基站网络。
     * 12     缺少定位权限，请在设备的设置中开启app的定位权限。
     **/

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        aMap.setLocationSource(this);// 设置定位监听
        aMap.getUiSettings().setMyLocationButtonEnabled(true);// 设置默认定位按钮是否显示
        // 设置为true表示显示定位层并可触发定位，false表示隐藏定位层并不可触发定位，默认是false
        aMap.setMyLocationEnabled(true);
        // 设置定位的类型为定位模式 ，可以由定位、跟随或地图根据面向方向旋转几种
        aMap.setMyLocationType(AMap.LOCATION_TYPE_LOCATE);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            MapActivity.this.finish();

        }
        return false;
    }
}
