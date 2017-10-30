package com.example.administrator.OurPersion.Presenter;

import android.content.Context;
import android.content.DialogInterface;
import android.database.DataSetObserver;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.OurPersion.Model.Bean.EventBean;
import com.example.administrator.OurPersion.Model.Bean.OkHttpURL;
import com.example.administrator.OurPersion.Model.Bean.OldManPlan;
import com.example.administrator.OurPersion.R;
import com.example.administrator.OurPersion.Utils.ToastUtils;
import com.example.administrator.OurPersion.View.Activity.FirstMainPlanActivity;
import com.example.administrator.OurPersion.View.Dialog.FirstMainPlanDialog;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

/**
 * Created by Administrator on 2017/6/13 0013.
 */

public class FirstMainPlanExpandable extends BaseExpandableListAdapter implements FirstMainPlanAdapter.SetCheckInterface {

    RefashInterFace refashInterFace;
    Context context;
    LayoutInflater layoutInflater;
    CheckBox checkBox;
    ExpandableListView listView;
    FirstMainPlanDialog dialog;
    OldManPlan oldManPlan;
    int[] imageid = {R.mipmap.one, R.mipmap.two, R.mipmap.three, R.mipmap.four, R.mipmap.five, R.mipmap.six, R.mipmap.seven, R.mipmap.eight, R.mipmap.nine, R.mipmap.zero};

    public FirstMainPlanExpandable(Context context, ExpandableListView listView, OldManPlan oldManPlan) {
        this.context = context;
        this.oldManPlan = oldManPlan;
        this.listView = listView;
        layoutInflater = LayoutInflater.from(context);
        //--注册EventBus
        EventBus.getDefault().register(this);
    }
    // --------------child------------------

    @Override
    public Object getChild(int GroupPosition, int ChildPosition) {
        // TODO Auto-generated method stub
        return oldManPlan.getOldManPlan().get(GroupPosition).getNursingPlans();
    }

    @Override
    public long getChildId(int GroupPosition, int ChildPosition) {
        // TODO Auto-generated method stub
        return ChildPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getChildView(int GroupPosition, int ChildPosition,
                             boolean arg2, View convertView, ViewGroup arg4) {


        List<OldManPlan.OldManPlanBean.NursingPlansBean> list = oldManPlan.getOldManPlan().get(GroupPosition).getNursingPlans();
        return GetChildView(list, GroupPosition);
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    @Override
    public int getChildrenCount(int GroupPosition) {
        // TODO Auto-generated method stub

        return 1;
    }

    // -----group-----------
    @Override
    public Object getGroup(int GroupPosition) {
        // TODO Auto-generated method stub
        return oldManPlan.getOldManPlan().get(GroupPosition);
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getGroupCount() {
        // TODO Auto-generated method stub

        return oldManPlan.getOldManPlan().size();
    }

    @Override
    public long getGroupId(int GroupPosition) {
        // TODO Auto-generated method stub
        return GroupPosition;
    }

    @Override
    public View getGroupView(int GroupPosition, boolean arg1, View convertView,
                             ViewGroup arg3) {
        if (null == convertView) {
            convertView = layoutInflater.inflate(R.layout.activity_firstmain_plan_group, null);
        }
        OldManPlan.OldManPlanBean meNureseOldManBean = oldManPlan.getOldManPlan().get(GroupPosition);
        return GetGroupView(meNureseOldManBean, GroupPosition, arg1, convertView);
    }


    public View GetGroupView(OldManPlan.OldManPlanBean oldManPlanBean, int groupPosition, boolean arg1, View view) {
        ImageView group_number = (ImageView) view.findViewById(R.id.main_jihua_fragmentone_number);
        ImageView image = (ImageView) view.findViewById(R.id.image);
        Picasso.with(context).load(OkHttpURL.ImageURL + oldManPlanBean.getImgPath()).placeholder(R.mipmap.oldone).into(image);
        if (groupPosition / 10 > 0) {

            group_number.setImageResource(imageid[groupPosition % 10]);

        } else {
            group_number.setImageResource(imageid[groupPosition]);
        }
        TextView group_name = (TextView) view.findViewById(R.id.main_jihua_fragmentone_name);
        group_name.setText(oldManPlanBean.getCustomerName());
        TextView group_chuangwei = (TextView) view.findViewById(R.id.main_jihua_fragmentone_chuangwei);
        group_chuangwei.setText("");
        ImageView imageView = (ImageView) view.findViewById(R.id.main_jihua_fragmentone_image);
        if (arg1) {

            imageView.setImageResource(R.mipmap.bottom);
        } else {
            imageView.setImageResource(R.mipmap.left);
        }
        return view;

    }

    public View GetChildView(final List<OldManPlan.OldManPlanBean.NursingPlansBean> list, final int groupposition) {
        View view = layoutInflater.inflate(R.layout.activity_firstmain_plan_child, null);
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.main_jihua_frgamentone_add);
        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.jihua_recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        recyclerView.setLayoutManager(linearLayoutManager);
        final FirstMainPlanAdapter adapter = new FirstMainPlanAdapter(list, context, groupposition, oldManPlan.getOldManPlan().get(groupposition).getCustomerName());
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        //--添加数据按钮,添加数据后更新adapter,以及expandlerviewlist
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (list != null && oldManPlan.getOldManPlan().get(groupposition).getNursingPlans().size() > 0) {
                    dialog = new FirstMainPlanDialog(context, R.style.MyDialog, R.layout.activity_firstmain_plan_dialog, list, oldManPlan.getOldManPlan().get(groupposition).getNursingPlans());
                    dialog.show();
                    final FirstMainPlanActivity activity = (FirstMainPlanActivity) context;
                    WindowManager.LayoutParams layoutParams = activity.getWindow().getAttributes();
                    layoutParams.alpha = 0.7f;
                    activity.getWindow().setAttributes(layoutParams);
                    dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                        @Override
                        public void onDismiss(DialogInterface dialog) {
                            WindowManager.LayoutParams layoutParams = activity.getWindow().getAttributes();
                            layoutParams.alpha = 1.0f;
                            activity.getWindow().setAttributes(layoutParams);
                            //--如果添加项目成功就刷新isRefash=1表示成功，0默认
                            if (FirstMainPlanDialog.isRefash == 1) {
                                refashInterFace.Refash();
                                adapter.notifyDataSetChanged();
                                //--更新childview方法,这里如果不加全选框不会随着添加数据而改变
                                listView.collapseGroup(groupposition);
                                listView.expandGroup(groupposition);
                                FirstMainPlanDialog.isRefash = 0;
                            }
                        }
                    });
                } else {
                    ToastUtils.show(context, "无数据", 5);

                }
            }
        });
        adapter.SetInterface(this);
        return view;

    }

    @Override
    public void SetCheck(int grouposition) {
        //--这里是删除数据后刷新，回调接口
        listView.collapseGroup(grouposition);
        listView.expandGroup(grouposition);
        refashInterFace.Refash();
    }


    //--刷新主页项目数据接口
    public interface RefashInterFace {
        void Refash();

    }

    public void SetInterFace(RefashInterFace refashInterFace) {
        this.refashInterFace = refashInterFace;

    }

    //--接收到的消息
    @Subscribe
    public void onEventMainThread(EventBean event) {
        if (event.getMsg().equals("")) {
            refashInterFace.Refash();
            listView.collapseGroup(event.getPosition());
            listView.expandGroup(event.getPosition());
        }


    }

}
