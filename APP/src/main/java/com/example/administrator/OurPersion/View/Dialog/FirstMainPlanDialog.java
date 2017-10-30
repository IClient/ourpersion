package com.example.administrator.OurPersion.View.Dialog;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.administrator.OurPersion.Model.Bean.OldManAllPlan;
import com.example.administrator.OurPersion.Model.Bean.OldManPlan;
import com.example.administrator.OurPersion.Model.Bean.OldManPlanItem;
import com.example.administrator.OurPersion.Presenter.FirstMainPlanAddDialogAdapter;
import com.example.administrator.OurPersion.Presenter.FirstMainPlanDialogAdapter;
import com.example.administrator.OurPersion.R;
import com.example.administrator.OurPersion.SelfView.PickerView;
import com.example.administrator.OurPersion.Utils.ToastUtils;
import com.example.administrator.OurPersion.View.Activity.BaseActivity;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/8/14 0014.
 */

public class FirstMainPlanDialog extends Dialog implements FirstMainPlanDialogAdapter.GetSubItemByPlan {
    //--如果添加项目成功就刷新isRefash=1表示成功，0默认
    public static int isRefash = 0;
    OldManPlanItem oldManPlanItem;
    //--子项目父布局
    LinearLayout linearLayout;
    //--备注父布局
    EditText edt_remark;
    Context context;
    int layout;
    RecyclerView recyclerView;
    RecyclerView main_fragmentone_subitemplan_rv;
    //    //---这个是每一个老人的护理集合
    List<OldManPlan.OldManPlanBean.NursingPlansBean> everyoldmanlist;
    //--滚动选择器的集合
    List<String> pickdata = new ArrayList<>();
    //--这里是所有老人的护理集合
    List<OldManPlan.OldManPlanBean.NursingPlansBean> data;
    //--时间段
    String time;
    String timeid;
    //父项目id
    String pid;
    //--备注
    String remark = "";
    //--子项目id,对应值
    JSONArray jsonArray = new JSONArray();
    FirstMainPlanAddDialogAdapter adapter;
    OldManAllPlan oldManAllPlan;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            /**
             * 1表示获取项目成功
             * 2表示获取失败
             *
             */
            if ((int) msg.obj == 1) {
                //--这个ischeck是自己加的，所以要设置一个默认值，不然会null指针0选中，1未选中
                for (int i = 0; i < oldManAllPlan.getOldManAllPlan().size(); i++) {
                    oldManAllPlan.getOldManAllPlan().get(i).setIsCheck("1");
                }
                FirstMainPlanDialogAdapter dialogAdapter = new FirstMainPlanDialogAdapter(context, oldManAllPlan);
                recyclerView.setAdapter(dialogAdapter);
                dialogAdapter.SetInterface(FirstMainPlanDialog.this);
            } else if ((int) msg.obj == 2) {
                ToastUtils.show(context, "获取数据失败", Toast.LENGTH_SHORT);

            }
            /**
             * 3表示获取子项目成功
             * 4表示获取失败
             * 5表示没有子项目
             */
            else if ((int) msg.obj == 3) {
                linearLayout.setVisibility(View.VISIBLE);
                //--这里o表示未选中，1表示选中,用来区分添加项目
                for (int i = 0; i < oldManPlanItem.getOldManPlanItem().size(); i++) {
                    oldManPlanItem.getOldManPlanItem().get(i).setIsSelect("0");
                }
                //-子项目集合
                main_fragmentone_subitemplan_rv = (RecyclerView) findViewById(R.id.main_fragmentone_subitemplan_rv);
                main_fragmentone_subitemplan_rv.setLayoutManager(new LinearLayoutManager(context));
                main_fragmentone_subitemplan_rv.setHasFixedSize(true);
                adapter = new FirstMainPlanAddDialogAdapter(context, oldManPlanItem);
                main_fragmentone_subitemplan_rv.setAdapter(adapter);

            } else if ((int) msg.obj == 4) {
                linearLayout.setVisibility(View.GONE);
                ToastUtils.show(context, "请求数据失败", Toast.LENGTH_SHORT);

            } else if ((int) msg.obj == 5) {
                linearLayout.setVisibility(View.GONE);

            }
            /**
             * 6表示添加项目成功
             * 7表示添加失败
             */
            else if ((int) msg.obj == 6) {
                isRefash = 1;
                dismiss();

            } else if ((int) msg.obj == 7) {
                isRefash = 0;
                ToastUtils.show(context, "新增数据失败", Toast.LENGTH_SHORT);
            }
        }
    };

    public FirstMainPlanDialog(Context context, int theme, int layout, List<OldManPlan.OldManPlanBean.NursingPlansBean> data, List<OldManPlan.OldManPlanBean.NursingPlansBean> list) {
        super(context, theme);
        this.context = context;
        this.layout = layout;
        this.data = data;
        this.everyoldmanlist = list;
        setCanceledOnTouchOutside(false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstmain_plan_dialog);
        linearLayout = (LinearLayout) findViewById(R.id.subitemplan_layout);
        linearLayout.setVisibility(View.GONE);
        edt_remark = (EditText) findViewById(R.id.remark);
        edt_remark.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                remark = s.toString();
            }
        });
        //-获取所有项目
        GetAllPlan();
        PickerView pickerView = (PickerView) findViewById(R.id.main_pickview);
        for (int i = 0; i < everyoldmanlist.size(); i++) {
            pickdata.add(everyoldmanlist.get(i).getBeginTime().substring(everyoldmanlist.get(i).getBeginTime().length() - 8, everyoldmanlist.get(i).getBeginTime().length() - 3) + "-" + everyoldmanlist.get(i).getEndTime().substring(everyoldmanlist.get(i).getEndTime().length() - 8, everyoldmanlist.get(i).getEndTime().length() - 3));
        }
        //--去掉重复的时间段
        pickdata = removeDuplicateWithOrder(pickdata);
        pickerView.setData(pickdata);
        //--默认情况
        pickerView.setSelected(pickdata.size() / 2);
        time = pickdata.get(pickdata.size() / 2);
        for (int i = 0; i < everyoldmanlist.size(); i++) {
            if (time.equals(everyoldmanlist.get(i).getBeginTime().substring(everyoldmanlist.get(i).getBeginTime().length() - 8, everyoldmanlist.get(i).getBeginTime().length() - 3) + "-" + everyoldmanlist.get(i).getEndTime().substring(everyoldmanlist.get(i).getEndTime().length() - 8, everyoldmanlist.get(i).getEndTime().length() - 3))) {
                timeid = everyoldmanlist.get(i).getTimeSign();
            }

        }
        pickerView.setOnSelectListener(new PickerView.onSelectListener() {
            @Override
            public void onSelect(String text) {
                for (int i = 0; i < everyoldmanlist.size(); i++) {
                    if (text.equals(everyoldmanlist.get(i).getBeginTime().substring(everyoldmanlist.get(i).getBeginTime().length() - 8, everyoldmanlist.get(i).getBeginTime().length() - 3) + "-" + everyoldmanlist.get(i).getEndTime().substring(everyoldmanlist.get(i).getEndTime().length() - 8, everyoldmanlist.get(i).getEndTime().length() - 3))) {
                        timeid = everyoldmanlist.get(i).getTimeSign();
                    }

                }
                time = text;
            }
        });
        //--父项目集合
        recyclerView = (RecyclerView) findViewById(R.id.main_fragmentone_dialog_rv);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 4);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHasFixedSize(true);
        /**
         * 点击确定后添加数据,这里需要Post请求
         *
         */
        Button button = (Button) findViewById(R.id.main_dialog_sure);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (FirstMainPlanDialogAdapter.isck == 1) {
                    postdata();
                } else if (FirstMainPlanDialogAdapter.isck == 0) {
                    ToastUtils.show(context, "请选择项目", Toast.LENGTH_SHORT);
                }

            }
        });
        //--取消
        Button button1 = (Button) findViewById(R.id.main_dialog_no);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dismiss();
            }
        });
    }

    //--去掉重复数据
    public static List removeDuplicateWithOrder(List<String> list) {
        Set set = new HashSet();
        List<String> newList = new ArrayList();
        for (Iterator iter = list.iterator(); iter.hasNext(); ) {
            String element = iter.next().toString();
            if (set.add(element))
                newList.add(element);
        }
        return newList;
    }

    public void GetAllPlan() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(15, TimeUnit.SECONDS).writeTimeout(15, TimeUnit.SECONDS).build();
        Request request = new Request.Builder().get().url("http://192.168.10.7:7006/api/NursingApi/GetNursingItem").build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                try {
                    JSONObject jsonObject = new JSONObject(result);
                    if (jsonObject.has("Message")) {
                        Message message = new Message();
                        message.obj = 2;
                        handler.sendMessage(message);
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String s = "{\"OldManAllPlan\":";
                StringBuffer sb = new StringBuffer(result);
                sb.insert(0, s);
                String data = sb.toString() + "}";
                Gson gson = new Gson();
                oldManAllPlan = gson.fromJson(data, OldManAllPlan.class);
                Message message = new Message();
                message.obj = 1;
                handler.sendMessage(message);

            }
        });

    }

    //--根据父项目id获取子项目
    @Override
    public void GetSubItem(String id) {
        pid = id;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(15, TimeUnit.SECONDS).writeTimeout(15, TimeUnit.SECONDS).build();
        final Request request = new Request.Builder().get().url("http://192.168.10.7:7006/api/NursingApi/GetNursingSubItem?pItemId=" + id).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                if (result.equals("[]")) {
                    Message message = new Message();
                    message.obj = 5;
                    handler.sendMessage(message);
                    return;
                }
                try {
                    JSONObject jsonObject = new JSONObject(result);
                    if (jsonObject.has("Message")) {
                        Message message = new Message();
                        message.obj = 4;
                        handler.sendMessage(message);
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                String s = "{\"OldManPlanItem\":";
                StringBuffer sb = new StringBuffer(result);
                sb.insert(0, s);
                String data = sb.toString() + "}";
                Gson gson = new Gson();
                oldManPlanItem = gson.fromJson(data, OldManPlanItem.class);
                Message message = new Message();
                message.obj = 3;
                handler.sendMessage(message);

            }
        });


    }

    //--添加项目
    public void addplanpost() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String time = df.format(new Date());
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(15, TimeUnit.SECONDS).writeTimeout(15, TimeUnit.SECONDS).build();
        Request request = new Request.Builder().get().url("http://192.168.10.7:7006/api/NursingApi/AjaxSetVal?itemId=" + pid + "&recordDate=" + time + "&inLiveId=" + everyoldmanlist.get(0).getInLiveId() + "&timeSignId=" + timeid + "+&optSign=1" + "&optSignNewAdd=2" + "&remark=" + remark + "&isChange=6" + "&jsonPlan=" + jsonArray.toString() + "&loginId=" + BaseActivity.user.getId() + "&loginName=" + BaseActivity.user.getEmployeeName()).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                try {
                    JSONObject jsonObject = new JSONObject(result);
                    if (jsonObject.has("Message")) {
                        Message message = new Message();
                        message.obj = 7;
                        handler.sendMessage(message);
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                Message message = new Message();
                message.obj = 6;
                handler.sendMessage(message);

            }
        });
    }

    public void postdata() {
        //--有子项目并且有选择框
        if (FirstMainPlanAddDialogAdapter.itemtype == 1 && oldManPlanItem != null) {
            //获取选中的子项目
            List<String> id = new ArrayList<>();
            List<String> value = new ArrayList<>();
            for (int i = 0; i < oldManPlanItem.getOldManPlanItem().size(); i++) {
                if (oldManPlanItem.getOldManPlanItem().get(i).getIsSelect().equals("1")) {
                    id.add(oldManPlanItem.getOldManPlanItem().get(i).getId());
                    value.add(oldManPlanItem.getOldManPlanItem().get(i).getSubStandardVal());
                }
            }
            if (id.size() > 0) {
                for (int i = 0; i < id.size(); i++) {
                    JSONObject jsonObject = new JSONObject();
                    try {
                        jsonObject.put("SubItemId", id.get(i));
                        jsonObject.put("SubVal", value.get(i));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    jsonArray.put(jsonObject);
                    jsonObject = null;
                }
            }
            addplanpost();
        }
        //--没有子项目的
        else if (oldManPlanItem == null) {
            addplanpost();
        }
        //--y有子项目并且输入值的
        else if (FirstMainPlanAddDialogAdapter.itemtype == 2 && oldManPlanItem != null) {
            //获取选中的子项目
            List<String> id = new ArrayList<>();
            List<String> value = new ArrayList<>();
            for (int i = 0; i < oldManPlanItem.getOldManPlanItem().size(); i++) {
                if (oldManPlanItem.getOldManPlanItem().get(i).getIsSelect().equals("1")) {
                    id.add(oldManPlanItem.getOldManPlanItem().get(i).getId());
                    value.add(oldManPlanItem.getOldManPlanItem().get(i).getSubStandardVal());
                }
            }
            if (id.size() > 0) {
                for (int i = 0; i < id.size(); i++) {
                    JSONObject jsonObject = new JSONObject();
                    try {
                        jsonObject.put("SubItemId", id.get(i));
                        jsonObject.put("SubVal", value.get(i));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    jsonArray.put(jsonObject);
                    jsonObject = null;
                }
            }
            addplanpost();

        }

    }
}
