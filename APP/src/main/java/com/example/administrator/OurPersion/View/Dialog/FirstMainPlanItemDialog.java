package com.example.administrator.OurPersion.View.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.administrator.OurPersion.Model.Bean.EventBean;
import com.example.administrator.OurPersion.Model.Bean.OldManPlan;
import com.example.administrator.OurPersion.Model.Bean.OldManPlanItem;
import com.example.administrator.OurPersion.Presenter.FirstMainPlanItemAdapter;
import com.example.administrator.OurPersion.R;
import com.example.administrator.OurPersion.Utils.ToastUtils;
import com.example.administrator.OurPersion.View.Activity.BaseActivity;


import org.greenrobot.eventbus.EventBus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * Created by Administrator on 2017/9/8 0008.
 */

public class FirstMainPlanItemDialog extends Dialog {
    int groupposition;
    OldManPlanItem oldManPlanItem;
    Context context;
    int layout;
    RecyclerView recyclerView;
    String Remark;
    Button main_itmedialog_sure;
    Button main_itmedialog_no;
    OldManPlan.OldManPlanBean.NursingPlansBean nursingPlansBean;
    JSONArray jsonArray = new JSONArray();


    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if ((int) msg.obj == 1) {
                EventBus.getDefault().post(new EventBean("", groupposition));

            } else if ((int) msg.obj == 2) {
                ToastUtils.show(context, "编辑失败", Toast.LENGTH_SHORT);

            }

        }
    };

    public FirstMainPlanItemDialog(Context context, int theme, int layout, OldManPlanItem oldManPlanItem, String Remark, OldManPlan.OldManPlanBean.NursingPlansBean nursingPlansBean, int groupposition) {
        super(context, theme);
        this.context = context;
        this.layout = layout;
        this.oldManPlanItem = oldManPlanItem;
        this.Remark = Remark;
        this.nursingPlansBean = nursingPlansBean;
        this.groupposition = groupposition;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstmain_plan_planitemdialog);
        recyclerView = (RecyclerView) findViewById(R.id.main_fragmentone_planitemdialog_rv);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        FirstMainPlanItemAdapter adapter = new FirstMainPlanItemAdapter(context, oldManPlanItem, nursingPlansBean);
        recyclerView.setAdapter(adapter);
        main_itmedialog_no = (Button) findViewById(R.id.main_itmedialog_no);
        main_itmedialog_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        main_itmedialog_sure = (Button) findViewById(R.id.main_itmedialog_sure);
        main_itmedialog_sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Editplanpost();
                dismiss();
            }
        });
        EditText oldman_name_beizhu = (EditText) findViewById(R.id.oldman_name_beizhu);
        oldman_name_beizhu.setText(Remark);
        oldman_name_beizhu.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Remark = s.toString();

            }
        });

    }

    //--编辑项目
    public void Editplanpost() {
        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String time = df.format(new Date());
        //--判断item类型
        if (FirstMainPlanItemAdapter.itemtype == 1) {
            for (Map.Entry<Integer, Object> entry : FirstMainPlanItemAdapter.map.entrySet()) {
                if ((boolean) entry.getValue()) {
                    JSONObject jsonObject = new JSONObject();
                    try {

                        jsonObject.put("SubItemId", oldManPlanItem.getOldManPlanItem().get(entry.getKey()).getId());
                        jsonObject.put("SubVal", "");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    jsonArray.put(jsonObject);
                    jsonObject = null;

                }
            }
        } else {
            for (int i = 0; i < oldManPlanItem.getOldManPlanItem().size(); i++) {
                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("SubItemId", oldManPlanItem.getOldManPlanItem().get(i).getId());
                    jsonObject.put("SubVal", oldManPlanItem.getOldManPlanItem().get(i).getSetValue());

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                jsonArray.put(jsonObject);
                jsonObject = null;

            }

        }

        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(15, TimeUnit.SECONDS).writeTimeout(15, TimeUnit.SECONDS).build();
        Request request = new Request.Builder().get().url("http://192.168.10.7:7006/api/NursingApi/AjaxSetVal?itemId=" + nursingPlansBean.getNursingItemId() + "&recordDate=" + time + "&inLiveId=" + nursingPlansBean.getInLiveId() + "&timeSignId=" + nursingPlansBean.getTimeSign() + "+&optSign=2" + "&optSignNewAdd=2" + "&remark=" + Remark + "&isChange=6" + "&jsonPlan=" + jsonArray.toString() + "&loginId=" + BaseActivity.user.getId() + "&loginName=" + BaseActivity.user.getEmployeeName()).build();
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

                Message message = new Message();
                message.obj = 1;
                handler.sendMessage(message);


            }
        });
    }
}
