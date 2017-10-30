package com.example.administrator.OurPersion.Presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.OurPersion.Model.Bean.Bed;
import com.example.administrator.OurPersion.R;
import com.example.administrator.OurPersion.View.Activity.SearchActivity;

import java.util.List;

/**
 * Created by Administrator on 2017/7/14 0014.
 */

public class BedAdminExpandable extends BaseExpandableListAdapter {
    Context context;
    List<List<Bed.UnitBean.UnitsBean.FloorsBean.RoomsBean>> lists;
    List<Bed.UnitBean.UnitsBean.FloorsBean> floorsBeanList;
    LayoutInflater layoutInflater;
    int[] imageid = {R.mipmap.one, R.mipmap.two, R.mipmap.three, R.mipmap.four, R.mipmap.five, R.mipmap.five, R.mipmap.five, R.mipmap.five, R.mipmap.five, R.mipmap.five, R.mipmap.five};
    Bed bed1;
    int position;
    int unitposition;

    public BedAdminExpandable(Context context, List<List<Bed.UnitBean.UnitsBean.FloorsBean.RoomsBean>> lists, List<Bed.UnitBean.UnitsBean.FloorsBean> floorsBeanList, Bed bed1, int position, int unitposition) {
        this.context = context;
        this.floorsBeanList = floorsBeanList;
        this.lists = lists;
        this.position = position;
        this.unitposition = unitposition;
        this.bed1 = bed1;
        layoutInflater = LayoutInflater.from(context);
    }

    // --------------child------------------

    @Override
    public Object getChild(int GroupPosition, int ChildPosition) {
        // TODO Auto-generated method stub
        return lists.get(GroupPosition).get(ChildPosition);
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
                             boolean arg2, View arg3, ViewGroup arg4) {
        List<Bed.UnitBean.UnitsBean.FloorsBean.RoomsBean> roomsBeanList = lists.get(GroupPosition);
        return GetChildView(roomsBeanList, GroupPosition, ChildPosition);
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    @Override
    public int getChildrenCount(int GroupPosition) {

        // TODO Auto-generated method stub
        return lists.get(GroupPosition).size() / 2 + lists.get(GroupPosition).size() % 2;


    }

    // -----group-----------
    @Override
    public Object getGroup(int GroupPosition) {
        // TODO Auto-generated method stub
        return lists.get(GroupPosition);
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

        return lists.size();
    }

    @Override
    public long getGroupId(int GroupPosition) {
        // TODO Auto-generated method stub
        return GroupPosition;
    }

    @Override
    public View getGroupView(int GroupPosition, boolean arg1, View arg2,
                             ViewGroup arg3) {
        Bed.UnitBean.UnitsBean.FloorsBean floorsBean = floorsBeanList.get(GroupPosition);

        return GetGroupView(floorsBean, GroupPosition, arg1);
    }


    public View GetGroupView(Bed.UnitBean.UnitsBean.FloorsBean floorsBean, int postion, boolean arg1) {
        View view = layoutInflater.inflate(R.layout.bedadmin_activity_group, null);
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

    public View GetChildView(List<Bed.UnitBean.UnitsBean.FloorsBean.RoomsBean> roomsBeanList, final int groupposition, final int childposition) {

        View view = layoutInflater.inflate(R.layout.bedadmin_activity_child, null);
        LinearLayout chuangwei_layout1 = (LinearLayout) view.findViewById(R.id.chuangwei_layout1);
        LinearLayout chuangwei_layout2 = (LinearLayout) view.findViewById(R.id.chuangwei_layout2);
        LinearLayout chuangwei_state1 = (LinearLayout) view.findViewById(R.id.chuangwei_state1);
        LinearLayout chuangwei_state2 = (LinearLayout) view.findViewById(R.id.chuangwei_state2);
        //----获取房间名称以及房间类型
        TextView bed_fangjian = (TextView) view.findViewById(R.id.bed_fangjian);
        bed_fangjian.setText(roomsBeanList.get(childposition * 2).getRoomName() + "(" + roomsBeanList.get(childposition * 2).getRoomType() + ")");
        if (lists.get(groupposition).size() % 2 == 0 || childposition != lists.get(groupposition).size() / 2) {
            TextView bed_fangjian2 = (TextView) view.findViewById(R.id.bed_fangjian2);
            bed_fangjian2.setText(roomsBeanList.get(childposition * 2 + 1).getRoomName() + "(" + roomsBeanList.get(childposition * 2).getRoomType() + ")");
        }

        //--根据房间数量判断是否显示
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.bed_layout2);
        if (lists.get(groupposition).size() % 2 > 0 && childposition == lists.get(groupposition).size() / 2) {
            linearLayout.setVisibility(View.GONE);
        } else if (lists.get(groupposition).size() / 2 == 0) {
            linearLayout.setVisibility(View.GONE);
        }

        //--获取床位
        for (int i = 0; i < bed1.getUnit().get(unitposition).getUnits().get(position).getFloors().get(groupposition).getRooms().get(childposition * 2).getBeds().size();
             i++) {
            int size = bed1.getUnit().get(unitposition).getUnits().get(position).getFloors().get(groupposition).getRooms().get(childposition * 2).getBeds().size();
            final Bed.UnitBean.UnitsBean.FloorsBean.RoomsBean.BedsBean bedsBean = bed1.getUnit().get(unitposition).getUnits().get(position).getFloors().get(groupposition).getRooms().get(childposition * 2).getBeds().get(i);
            chuangwei_layout1.setWeightSum(size);
            chuangwei_layout1.setPadding(0, 10, 0, 0);
            TextView textView = new TextView(context);
            textView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1.0F));
            textView.setText(bedsBean.getBedName());
            textView.setGravity(Gravity.CENTER);
            chuangwei_layout1.addView(textView);
            chuangwei_state1.setWeightSum(size);
            chuangwei_state1.setPadding(0, 5, 0, 0);
            ImageButton imageButton = new ImageButton(context);
            imageButton.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1.0F));
            if (bedsBean.getBedState().equals("0")) {
                imageButton.setImageResource(R.mipmap.bedadmin_empty);
            } else if (bedsBean.getBedState().equals("1")) {
                imageButton.setImageResource(R.mipmap.bedadmin_update);
            } else if (bedsBean.getBedState().equals("3")) {
                imageButton.setImageResource(R.mipmap.bedadmin_ruzhu);

            } else if (bedsBean.getBedState().equals("4") || bedsBean.getBedState().equals("5")) {

                imageButton.setImageResource(R.mipmap.bedadmin_yuyue);
            } else if (bedsBean.getBedState().equals("2")) {
                imageButton.setImageResource(R.mipmap.bedadmin_dengjizhong);
            }
            imageButton.setBackground(null);
            chuangwei_state1.addView(imageButton);
            imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, SearchActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("bedbean", bedsBean);
                    intent.putExtra("unitname", bed1.getUnit().get(unitposition).getUnits().get(position).getUnitName());
                    intent.putExtra("floorname", bed1.getUnit().get(unitposition).getUnits().get(position).getFloors().get(groupposition).getFloorName());
                    intent.putExtra("roomname", bed1.getUnit().get(unitposition).getUnits().get(position).getFloors().get(groupposition).getRooms().get(childposition * 2).getRoomName());
                    intent.putExtra("roomtype", bed1.getUnit().get(unitposition).getUnits().get(position).getFloors().get(groupposition).getRooms().get(childposition * 2).getRoomType());
                    intent.putExtras(bundle);
                    Activity activity = (Activity) context;
                    context.startActivity(intent);
                    activity.overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);

                }
            });


        }
        if (lists.get(groupposition).size() % 2 == 0 || childposition != lists.get(groupposition).size() / 2) {
            for (int i = 0; i < bed1.getUnit().get(unitposition).getUnits().get(position).getFloors().get(groupposition).getRooms().get(childposition * 2 + 1).getBeds().size();
                 i++) {
                int size = bed1.getUnit().get(unitposition).getUnits().get(position).getFloors().get(groupposition).getRooms().get(childposition * 2 + 1).getBeds().size();
                final Bed.UnitBean.UnitsBean.FloorsBean.RoomsBean.BedsBean bedsBean = bed1.getUnit().get(unitposition).getUnits().get(position).getFloors().get(groupposition).getRooms().get(childposition * 2 + 1).getBeds().get(i);
                chuangwei_layout2.setWeightSum(size);
                chuangwei_layout2.setPadding(0, 10, 0, 0);
                TextView textView = new TextView(context);
                textView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1.0F));
                textView.setText(bedsBean.getBedName());
                textView.setGravity(Gravity.CENTER);
                chuangwei_layout2.addView(textView);
                chuangwei_state2.setWeightSum(size);
                chuangwei_state2.setPadding(0, 5, 0, 0);
                ImageButton imageButton = new ImageButton(context);
                imageButton.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1.0F));
                if (bedsBean.getBedState().equals("0")) {
                    imageButton.setImageResource(R.mipmap.bedadmin_empty);
                } else if (bedsBean.getBedState().equals("1")) {

                    imageButton.setImageResource(R.mipmap.bedadmin_update);
                } else if (bedsBean.getBedState().equals("3")) {
                    imageButton.setImageResource(R.mipmap.bedadmin_ruzhu);

                } else if (bedsBean.getBedState().equals("4") || bedsBean.getBedState().equals("5")) {

                    imageButton.setImageResource(R.mipmap.bedadmin_yuyue);
                } else if (bedsBean.getBedState().equals("2")) {
                    imageButton.setImageResource(R.mipmap.bedadmin_dengjizhong);
                }
                imageButton.setBackground(null);
                chuangwei_state2.addView(imageButton);
                imageButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, SearchActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("bedbean", bedsBean);
                        intent.putExtra("unitname", bed1.getUnit().get(unitposition).getUnits().get(position).getUnitName());
                        intent.putExtra("floorname", bed1.getUnit().get(unitposition).getUnits().get(position).getFloors().get(groupposition).getFloorName());
                        intent.putExtra("roomname", bed1.getUnit().get(unitposition).getUnits().get(position).getFloors().get(groupposition).getRooms().get(childposition * 2 + 1).getRoomName());
                        intent.putExtra("roomtype", bed1.getUnit().get(unitposition).getUnits().get(position).getFloors().get(groupposition).getRooms().get(childposition * 2 + 1).getRoomType());
                        intent.putExtras(bundle);
                        Activity activity = (Activity) context;
                        context.startActivity(intent);
                        activity.overridePendingTransition(R.animator.in_from_right, R.animator.out_from_left);
                    }
                });

            }
        }
        return view;


    }
}
