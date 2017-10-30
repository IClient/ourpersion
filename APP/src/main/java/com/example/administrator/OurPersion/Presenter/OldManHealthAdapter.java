package com.example.administrator.OurPersion.Presenter;

/**
 * Created by Administrator on 2017/8/29 0029.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.OurPersion.Model.Bean.OldManHealth;
import com.example.administrator.OurPersion.R;

import java.util.List;


/**
 * Created by Administrator on 2017/8/25 0025.
 */

public class OldManHealthAdapter extends RecyclerView.Adapter<OldManHealthAdapter.MyviewHolder> {
    private Context context;
    private List<OldManHealth.OldManHealthBean> list;
    private LayoutInflater layoutInflater;


    public OldManHealthAdapter(Context context, List<OldManHealth.OldManHealthBean> list) {
        this.context = context;
        this.list = list;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public MyviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.oldmanhealth_item, parent, false);
        MyviewHolder holder = new MyviewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyviewHolder holder, final int position) {
        OldManHealth.OldManHealthBean healthBean = list.get(position);
        holder.oldman_healthitem_hospital.setText(healthBean.getHospital().toString());
        holder.oldman_healthitem_name.setText(healthBean.getDoctorName().toString());
        holder.oldman_healthitem_time.setText(healthBean.getDiagnosisDate().toString());
        holder.oldman_healthitem_symptom.setText(healthBean.getSymptom().toString());
        //检查情况
        if (TextUtils.isEmpty(healthBean.getInspectionStatus().toString())) {
            holder.oldman_healthitem_inspectionstatus.setText("");
        } else {
            holder.oldman_healthitem_inspectionstatus.setText(healthBean.getInspectionStatus().toString());
        }
        //--诊断信息
        if (TextUtils.isEmpty(healthBean.getDiagnosticInformation().toString())) {
            holder.oldman_healthitem_diagnosticInformation.setText("");
        } else {
            holder.oldman_healthitem_diagnosticInformation.setText(healthBean.getDiagnosticInformation().toString());
        }
        //--意见处理
        if (TextUtils.isEmpty(healthBean.getHandleOpinions().toString())) {
            holder.oldman_healthitem_HandleOpinions.setText("");
        } else {
            holder.oldman_healthitem_HandleOpinions.setText(healthBean.getHandleOpinions().toString());
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        TextView oldman_healthitem_hospital;
        TextView oldman_healthitem_name;
        TextView oldman_healthitem_time;
        TextView oldman_healthitem_symptom;
        TextView oldman_healthitem_inspectionstatus;
        TextView oldman_healthitem_diagnosticInformation;
        TextView oldman_healthitem_HandleOpinions;

        public MyviewHolder(View itemView) {
            super(itemView);
            oldman_healthitem_hospital = (TextView) itemView.findViewById(R.id.oldman_healthitem_hospital);
            oldman_healthitem_name = (TextView) itemView.findViewById(R.id.oldman_healthitem_name);
            oldman_healthitem_time = (TextView) itemView.findViewById(R.id.oldman_healthitem_time);
            oldman_healthitem_symptom = (TextView) itemView.findViewById(R.id.oldman_healthitem_symptom);
            oldman_healthitem_inspectionstatus = (TextView) itemView.findViewById(R.id.oldman_healthitem_inspectionstatus);
            oldman_healthitem_diagnosticInformation = (TextView) itemView.findViewById(R.id.oldman_healthitem_diagnosticInformation);
            oldman_healthitem_HandleOpinions = (TextView) itemView.findViewById(R.id.oldman_healthitem_HandleOpinions);

        }
    }

}

