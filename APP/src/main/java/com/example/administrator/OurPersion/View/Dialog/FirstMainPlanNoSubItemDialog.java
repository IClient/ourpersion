package com.example.administrator.OurPersion.View.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.OurPersion.Model.Bean.EventBean;
import com.example.administrator.OurPersion.Model.Bean.OldManPlan;
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
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/9/15 0015.
 */

public class FirstMainPlanNoSubItemDialog extends Dialog {
    Context context;
    int layout;
    OldManPlan.OldManPlanBean.NursingPlansBean nursingPlansBean;
    JSONArray jsonArray = new JSONArray();
    String remark;

    int groupposition;
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

    public FirstMainPlanNoSubItemDialog(Context context, int theme, int layout, OldManPlan.OldManPlanBean.NursingPlansBean nursingPlansBean, String Remark, int groupposition) {
        super(context, theme);
        this.context = context;
        this.layout = layout;
        this.nursingPlansBean = nursingPlansBean;
        this.remark = Remark;
        this.groupposition = groupposition;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstmain_plan_nosubitem_dialog);
        Button button_no = (Button) findViewById(R.id.main_dialog_no);
        button_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        Button button_yes = (Button) findViewById(R.id.main_dialog_sure);
        button_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Editplanpost();
                dismiss();
            }
        });
        EditText editText = (EditText) findViewById(R.id.nosubitem_remark);
        editText.addTextChangedListener(new TextWatcher() {
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
    }

    //--编辑项目
    public void Editplanpost() {
        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String time = df.format(new Date());


        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(15, TimeUnit.SECONDS).writeTimeout(15, TimeUnit.SECONDS).build();
        Request request = new Request.Builder().get().url("http://192.168.10.7:7006/api/NursingApi/AjaxSetVal?itemId=" + nursingPlansBean.getNursingItemId() + "&recordDate=" + time + "&inLiveId=" + nursingPlansBean.getInLiveId() + "&timeSignId=" + nursingPlansBean.getTimeSign() + "+&optSign=2" + "&optSignNewAdd=2" + "&remark=" + remark + "&isChange=6" + "&jsonPlan=" + jsonArray.toString() + "&loginId=" + BaseActivity.user.getId() + "&loginName=" + BaseActivity.user.getEmployeeName()).build();
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
