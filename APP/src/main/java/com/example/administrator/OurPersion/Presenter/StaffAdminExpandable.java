package com.example.administrator.OurPersion.Presenter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.administrator.OurPersion.Model.Bean.FloorMessage;
import com.example.administrator.OurPersion.Model.Bean.Work;
import com.example.administrator.OurPersion.R;

import java.util.List;


/**
 * Created by Administrator on 2017/9/25 0025.
 */

public class StaffAdminExpandable extends BaseExpandableListAdapter {
    Context context;
    List<FloorMessage.FloormessageBean.UnitsBean.FloorsBean> list;
    List<Work> worklist;
    LayoutInflater layoutInflater;
    int[] imageid = {R.mipmap.one, R.mipmap.two, R.mipmap.three, R.mipmap.four, R.mipmap.five, R.mipmap.five, R.mipmap.five, R.mipmap.five, R.mipmap.five, R.mipmap.five, R.mipmap.five};

    public StaffAdminExpandable(Context context, List<FloorMessage.FloormessageBean.UnitsBean.FloorsBean> list, List<Work> worklist) {
        this.context = context;
        this.list = list;
        this.worklist = worklist;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getGroupCount() {
        return list.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return list.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return worklist.get(groupPosition).getWork().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.bedadmin_activity_group, null);
        }
        FloorMessage.FloormessageBean.UnitsBean.FloorsBean floorsBean = list.get(groupPosition);
        return GetGroupView(floorsBean, groupPosition, isExpanded, convertView);

    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.staffadmin_child, null);

        }
        return GetChildView(groupPosition, childPosition, convertView);
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    public View GetGroupView(FloorMessage.FloormessageBean.UnitsBean.FloorsBean floorsBean, int postion, boolean arg1, View view) {
        ImageView group_image = (ImageView) view.findViewById(R.id.bed_image);
        group_image.setImageResource(imageid[postion]);
        TextView group_name = (TextView) view.findViewById(R.id.bed_text);
        group_name.setText(floorsBean.getFloorName() + " (楼层) ");
        ImageView bedadmin_jiantou = (ImageView) view.findViewById(R.id.bedadmin_jiantou);
        if (arg1) {
            bedadmin_jiantou.setImageResource(R.mipmap.bottom);
        } else {
            bedadmin_jiantou.setImageResource(R.mipmap.left);
        }


        return view;

    }

    public View GetChildView(int groupPosition, int childPosition, View view) {


        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.staffadmin_child_rv);
        TextView textView = (TextView) view.findViewById(R.id.staffadmin_child_t);
        if (worklist.size() > 0 && worklist != null) {
            if (worklist.get(groupPosition).getWork().size() > 0 && worklist.get(groupPosition).getWork() != null) {
                recyclerView.setVisibility(View.VISIBLE);
                textView.setVisibility(View.GONE);
                StaffAdminChildAdapter adapter = new StaffAdminChildAdapter(context, worklist.get(groupPosition));
                recyclerView.setHasFixedSize(true);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context) {
                    @Override
                    public boolean canScrollVertically() {
                        return false;
                    }
                };

                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setAdapter(adapter);
            } else {
                recyclerView.setVisibility(View.GONE);
                textView.setVisibility(View.VISIBLE);
            }
        }

        return view;
    }

}
