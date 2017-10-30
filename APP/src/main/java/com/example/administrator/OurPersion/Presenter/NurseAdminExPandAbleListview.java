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

import com.example.administrator.OurPersion.Model.Bean.AllOldManPlan;
import com.example.administrator.OurPersion.Model.Bean.OkHttpURL;
import com.example.administrator.OurPersion.R;
import com.example.administrator.OurPersion.SelfView.CircleImageView;
import com.squareup.picasso.Picasso;


/**
 * Created by Administrator on 2017/9/19 0019.
 */

public class NurseAdminExPandAbleListview extends BaseExpandableListAdapter {
    Context context;
    AllOldManPlan allOldManPlan;
    LayoutInflater layoutInflater;
    int[] imageid = {R.mipmap.zero, R.mipmap.one, R.mipmap.two, R.mipmap.three, R.mipmap.four, R.mipmap.five, R.mipmap.six, R.mipmap.seven, R.mipmap.eight, R.mipmap.nine, R.mipmap.zero, R.mipmap.one, R.mipmap.two, R.mipmap.three, R.mipmap.four, R.mipmap.five, R.mipmap.six, R.mipmap.seven, R.mipmap.eight, R.mipmap.nine, R.mipmap.zero, R.mipmap.one, R.mipmap.two, R.mipmap.three, R.mipmap.four, R.mipmap.five, R.mipmap.six, R.mipmap.seven, R.mipmap.eight, R.mipmap.nine};

    public NurseAdminExPandAbleListview(Context context, AllOldManPlan allOldManPlan) {
        this.allOldManPlan = allOldManPlan;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getGroupCount() {
        return allOldManPlan.getAllOldManPlan().size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return allOldManPlan.getAllOldManPlan().get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return allOldManPlan.getAllOldManPlan().get(groupPosition).getNursingPlans().get(childPosition);
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

        if (null == convertView) {
            convertView = layoutInflater.inflate(R.layout.nurseadmin_group, null);
        }
        AllOldManPlan.AllOldManPlanBean allOldManPlanBean = allOldManPlan.getAllOldManPlan().get(groupPosition);
        return GetGroupView(allOldManPlanBean, groupPosition, isExpanded, convertView);
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        return GetChildView(allOldManPlan, groupPosition, childPosition);
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    public View GetGroupView(AllOldManPlan.AllOldManPlanBean allOldManPlanBean, int groupPosition, boolean arg1, View view) {
        ImageView group_number = (ImageView) view.findViewById(R.id.nurseadmin_number);
        if (groupPosition / 10 > 0) {

            group_number.setImageResource(imageid[groupPosition % 10]);

        } else {
            group_number.setImageResource(imageid[groupPosition]);
        }
        CircleImageView image = (CircleImageView) view.findViewById(R.id.image);
        Picasso.with(context).load(OkHttpURL.ImageURL + allOldManPlanBean.getPic()).placeholder(R.mipmap.oldone).into(image);
        TextView group_name = (TextView) view.findViewById(R.id.nurseadmin_name);
        group_name.setText(allOldManPlanBean.getCustomerName());
        TextView nurseadmin_zubie = (TextView) view.findViewById(R.id.nurseadmin_zubie);
        if (allOldManPlanBean.getNursingGroupName() != null) {
            nurseadmin_zubie.setText(allOldManPlanBean.getNursingGroupName().toString());
        } else {
            nurseadmin_zubie.setText("未分组");
        }

        ImageView imageView = (ImageView) view.findViewById(R.id.nurseradmin_image);
        if (arg1) {

            imageView.setImageResource(R.mipmap.bottom);
        } else {
            imageView.setImageResource(R.mipmap.left);
        }
        return view;

    }

    public View GetChildView(AllOldManPlan allOldManPlan, int groupposition, int childposition) {
        View view = layoutInflater.inflate(R.layout.nurseadmin_child, null);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.nurseadmin_child_recyclerview);
        NurseAdminChildAdapter adapter = new NurseAdminChildAdapter(allOldManPlan.getAllOldManPlan().get(groupposition).getNursingPlans(), context);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
