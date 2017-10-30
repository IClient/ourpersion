package com.example.administrator.OurPersion.Presenter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.OurPersion.Model.Bean.OldManPlan;
import com.example.administrator.OurPersion.Model.Bean.OldManPlanItem;
import com.example.administrator.OurPersion.R;
import com.example.administrator.OurPersion.Utils.ToastUtils;
import com.example.administrator.OurPersion.View.Activity.BaseActivity;
import com.example.administrator.OurPersion.View.Dialog.FirstMainPlanNoSubItemDialog;
import com.example.administrator.OurPersion.View.Dialog.FirstMainPlanItemDialog;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/8/8 0008.
 */

public class FirstMainPlanAdapter extends RecyclerView.Adapter {
    Activity activity;
    WindowManager.LayoutParams layoutParams;
    //-子项目
    OldManPlanItem oldManPlanItem;
    ///---护理计划集合一级项目
    List<OldManPlan.OldManPlanBean.NursingPlansBean> list;
    Context context;
    LayoutInflater layoutInflater;
    int index;
    SetCheckInterface setCheckInterface;
    int grouposition;
    //老人名字
    String oldmanname;
    //--项目名字
    String name;
    //--备注
    String Remark;
    //--传递给子项目dialog的
    OldManPlan.OldManPlanBean.NursingPlansBean mynursingPlansBean;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            /**1表示获取子项目成功
             * 2表示获取子项目失败
             * 3表示没有子项目
             */
            if ((int) msg.obj == 1) {
                FirstMainPlanItemDialog dialog = new FirstMainPlanItemDialog(context, R.style.MyDialog, R.layout.activity_firstmain_plan_planitemdialog, oldManPlanItem, Remark, mynursingPlansBean, grouposition);
                if (!dialog.isShowing() && dialog != null) {

                    dialog.show();
                }
                TextView oldman_name_plan = (TextView) dialog.findViewById(R.id.oldman_name_plan);
                oldman_name_plan.setText(oldmanname + "-" + name);
                layoutParams.alpha = 0.7f;
                activity.getWindow().setAttributes(layoutParams);
                dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        WindowManager.LayoutParams layoutParams = activity.getWindow().getAttributes();
                        layoutParams.alpha = 1.0f;
                        activity.getWindow().setAttributes(layoutParams);
                    }
                });

            } else if ((int) msg.obj == 2) {

                ToastUtils.show(context, "请求数据失败", Toast.LENGTH_SHORT);
            } else if ((int) msg.obj == 3) {
                NoSubItemDialog();

            }
            /**4表示删除项目成功
             * 5表示删除项目失败
             */
            else if ((int) msg.obj == 4) {
                //--删除数据后刷新界面,利用接口回调
                setCheckInterface.SetCheck(grouposition);

            } else if ((int) msg.obj == 5) {

                ToastUtils.show(context, "请求数据失败", Toast.LENGTH_SHORT);
            }
        }
    };

    public FirstMainPlanAdapter(List<OldManPlan.OldManPlanBean.NursingPlansBean> list, Context context, int grouposition, String oldmanname) {
        this.list = list;
        this.context = context;
        this.grouposition = grouposition;
        this.oldmanname = oldmanname;
        layoutInflater = LayoutInflater.from(context);
        activity = (Activity) context;
        layoutParams = activity.getWindow().getAttributes();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.activity_firstmain_plan_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.frgamentone_item_type.setTag(position);
        final OldManPlan.OldManPlanBean.NursingPlansBean nursingPlansBean = list.get((Integer) myViewHolder.frgamentone_item_type.getTag());
        switch (nursingPlansBean.getIsEnd()) {
            case "0":
                myViewHolder.frgamentone_item_end.setText("默认计划");
                break;
            case "1":
                myViewHolder.frgamentone_item_end.setText("新增项目");
                myViewHolder.frgamentone_item_end.setTextColor(Color.parseColor("#1874CD"));
                break;
            case "2":
                myViewHolder.frgamentone_item_end.setText("修改计划");
                break;
            case "3":
                myViewHolder.frgamentone_item_end.setText("项目已取消");
                myViewHolder.frgamentone_item_end.setTextColor(Color.RED);
                break;
        }

        myViewHolder.frgamentone_item_type.setText(nursingPlansBean.getItemName().toString());
        myViewHolder.frgamentone_item_type.setTextColor(Color.parseColor("#1874CD"));
        myViewHolder.frgamentone_item_time.setText(nursingPlansBean.getBeginTime().substring(nursingPlansBean.getBeginTime().length() - 8, nursingPlansBean.getBeginTime().length() - 3) + "-" + nursingPlansBean.getEndTime().substring(nursingPlansBean.getEndTime().length() - 8, nursingPlansBean.getEndTime().length() - 3));
        //--删除按钮
        myViewHolder.main_frgament_item_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nursingPlansBean.getIsEnd().equals("1")) {
                    index = (int) myViewHolder.frgamentone_item_type.getTag();
                    // 创建退出对话框
                    AlertDialog isExit = new AlertDialog.Builder(context).create();
                    // 设置对话框标题
                    isExit.setTitle("系统提示");
                    // 设置对话框消息
                    isExit.setMessage("确定要删除吗");
                    // 添加选择按钮并注册监听
                    isExit.setButton("确定", listener);
                    isExit.setButton2("取消", listener);
                    // 显示对话框
                    isExit.show();
                } else {
                    ToastUtils.show(context, "默认计划不能删除", Toast.LENGTH_SHORT);

                }
            }
        });
        //--点击项目查看子项目
        myViewHolder.frgamentone_item_type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取项目id
                String id = nursingPlansBean.getNursingItemId();
                GetNursingSubItem(id);
                //--传递给子项目dialog的对象
                mynursingPlansBean = nursingPlansBean;
                //--项目名称
                name = nursingPlansBean.getItemName().toString();
                if (nursingPlansBean.getRemark() != null) {
                    Remark = nursingPlansBean.getRemark().toString();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView frgamentone_item_type;
        TextView frgamentone_item_time;
        ImageButton main_frgament_item_del;
        TextView frgamentone_item_end;

        public MyViewHolder(View itemView) {
            super(itemView);
            frgamentone_item_type = (TextView) itemView.findViewById(R.id.frgamentone_item_type);
            frgamentone_item_time = (TextView) itemView.findViewById(R.id.frgamentone_item_time);
            main_frgament_item_del = (ImageButton) itemView.findViewById(R.id.main_frgament_item_del);
            frgamentone_item_end = (TextView) itemView.findViewById(R.id.frgamentone_item_end);
        }
    }

    DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            switch (which) {
                case AlertDialog.BUTTON_POSITIVE:// "确认"按钮
                    DeletePlan();
                    break;
                case AlertDialog.BUTTON_NEGATIVE:// "取消"第二个按钮取消对话框
                    break;
                default:
                    break;
            }
        }
    };

    public interface SetCheckInterface {
        void SetCheck(int grouposition);

    }

    public void SetInterface(SetCheckInterface setCheckInterface) {
        this.setCheckInterface = setCheckInterface;

    }

    //--根据项目id获取子项目
    public void GetNursingSubItem(final String id) {
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
                    message.obj = 3;
                    handler.sendMessage(message);
                    return;
                }
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

                String s = "{\"OldManPlanItem\":";
                StringBuffer sb = new StringBuffer(result);
                sb.insert(0, s);
                String data = sb.toString() + "}";
                Gson gson = new Gson();
                oldManPlanItem = gson.fromJson(data, OldManPlanItem.class);
                Message message = new Message();
                message.obj = 1;
                handler.sendMessage(message);

            }
        });


    }

    //--删除项目(必须是新增项目)
    public void DeletePlan() {
        JSONArray jsonArray = new JSONArray();
        try {
            for (int i = 0; i < list.get(index).getSubIdAndVal().size(); i++) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("SubItemId", list.get(index).getSubIdAndVal().get(i).getSubItemId());
                jsonObject.put("SubVal", list.get(index).getSubIdAndVal().get(i).getSubVal());
                jsonArray.put(jsonObject);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String time = df.format(new Date());
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(15, TimeUnit.SECONDS).writeTimeout(15, TimeUnit.SECONDS).build();
        Request request = new Request.Builder().get().url("http://192.168.10.7:7006/api/NursingApi/AjaxSetVal?itemId=" + list.get(index).getNursingItemId() + "&recordDate=" + time + "&inLiveId=" + list.get(index).getInLiveId() + "&timeSignId=" + list.get(index).getTimeSign() + "+&optSign=3" + "&optSignNewAdd=1" + "&remark=" + list.get(index).getRemark() + "&isChange=6" + "&jsonPlan=" + jsonArray.toString() + "&loginId=" + BaseActivity.user.getId() + "&loginName=" + BaseActivity.user.getEmployeeName()).build();
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
                        message.obj = 5;
                        handler.sendMessage(message);
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                Message message = new Message();
                message.obj = 4;
                handler.sendMessage(message);

            }
        });

    }

    //--没有子项目的dialog
    public void NoSubItemDialog() {

        final FirstMainPlanNoSubItemDialog nosubdialog = new FirstMainPlanNoSubItemDialog(context, R.style.MyDialog, R.layout.activity_firstmain_plan_nosubitem_dialog, mynursingPlansBean, Remark, grouposition);
        nosubdialog.show();
        layoutParams.alpha = 0.7f;
        activity.getWindow().setAttributes(layoutParams);
        nosubdialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                WindowManager.LayoutParams layoutParams = activity.getWindow().getAttributes();
                layoutParams.alpha = 1.0f;
                activity.getWindow().setAttributes(layoutParams);
            }
        });
        TextView textView = (TextView) nosubdialog.findViewById(R.id.planandname);
        textView.setText(oldmanname + "-" + name);
        EditText editText = (EditText) nosubdialog.findViewById(R.id.nosubitem_remark);
        editText.setText(Remark);
        editText.setSelection(Remark.length());

    }

}
