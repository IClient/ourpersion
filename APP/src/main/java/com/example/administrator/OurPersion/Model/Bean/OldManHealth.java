package com.example.administrator.OurPersion.Model.Bean;

import java.util.List;

/**
 * Created by Administrator on 2017/8/29 0029.
 */

/**
 * 入住老人健康信息
 */

public class OldManHealth {

    private List<OldManHealthBean> OldManHealth;

    public List<OldManHealthBean> getOldManHealth() {
        return OldManHealth;
    }

    public void setOldManHealth(List<OldManHealthBean> OldManHealth) {
        this.OldManHealth = OldManHealth;
    }

    public static class OldManHealthBean {
        /**
         * Id : 728581e7-8c46-460b-abed-17e5c6204d54
         * Hospital : 省医院
         * DoctorId : 00000000-0000-0000-0000-000000000000
         * DoctorName : 刘医生
         * DiagnosisDate : 2017-08-29T00:00:00
         * Symptom : 高烧
         * InspectionStatus : null
         * DiagnosticInformation : null
         * HandleOpinions : 卧床休息
         * CreateId : 038869c2-0152-45c1-bf3a-9e78e8ca5616
         * CreaterName : 超级管理员
         * CreaterTime : 2017-08-29T15:12:51.213
         * ModifiedId : 038869c2-0152-45c1-bf3a-9e78e8ca5616
         * ModifiedName : 超级管理员
         * ModifiedTime : 2017-08-29T15:12:51.213
         * IsDelete : false
         * Remark : null
         * OldPersonId : 18c684e9-9177-4f41-bd67-52249fcfe41f
         * OldPersonName : 测试老人1
         */

        private String Id;
        private String Hospital;
        private String DoctorId;
        private String DoctorName;
        private String DiagnosisDate;
        private String Symptom;
        private Object InspectionStatus;
        private Object DiagnosticInformation;
        private String HandleOpinions;
        private String CreateId;
        private String CreaterName;
        private String CreaterTime;
        private String ModifiedId;
        private String ModifiedName;
        private String ModifiedTime;
        private boolean IsDelete;
        private Object Remark;
        private String OldPersonId;
        private String OldPersonName;

        public String getId() {
            return Id;
        }

        public void setId(String Id) {
            this.Id = Id;
        }

        public String getHospital() {
            return Hospital;
        }

        public void setHospital(String Hospital) {
            this.Hospital = Hospital;
        }

        public String getDoctorId() {
            return DoctorId;
        }

        public void setDoctorId(String DoctorId) {
            this.DoctorId = DoctorId;
        }

        public String getDoctorName() {
            return DoctorName;
        }

        public void setDoctorName(String DoctorName) {
            this.DoctorName = DoctorName;
        }

        public String getDiagnosisDate() {
            return DiagnosisDate;
        }

        public void setDiagnosisDate(String DiagnosisDate) {
            this.DiagnosisDate = DiagnosisDate;
        }

        public String getSymptom() {
            return Symptom;
        }

        public void setSymptom(String Symptom) {
            this.Symptom = Symptom;
        }

        public Object getInspectionStatus() {
            return InspectionStatus;
        }

        public void setInspectionStatus(Object InspectionStatus) {
            this.InspectionStatus = InspectionStatus;
        }

        public Object getDiagnosticInformation() {
            return DiagnosticInformation;
        }

        public void setDiagnosticInformation(Object DiagnosticInformation) {
            this.DiagnosticInformation = DiagnosticInformation;
        }

        public String getHandleOpinions() {
            return HandleOpinions;
        }

        public void setHandleOpinions(String HandleOpinions) {
            this.HandleOpinions = HandleOpinions;
        }

        public String getCreateId() {
            return CreateId;
        }

        public void setCreateId(String CreateId) {
            this.CreateId = CreateId;
        }

        public String getCreaterName() {
            return CreaterName;
        }

        public void setCreaterName(String CreaterName) {
            this.CreaterName = CreaterName;
        }

        public String getCreaterTime() {
            return CreaterTime;
        }

        public void setCreaterTime(String CreaterTime) {
            this.CreaterTime = CreaterTime;
        }

        public String getModifiedId() {
            return ModifiedId;
        }

        public void setModifiedId(String ModifiedId) {
            this.ModifiedId = ModifiedId;
        }

        public String getModifiedName() {
            return ModifiedName;
        }

        public void setModifiedName(String ModifiedName) {
            this.ModifiedName = ModifiedName;
        }

        public String getModifiedTime() {
            return ModifiedTime;
        }

        public void setModifiedTime(String ModifiedTime) {
            this.ModifiedTime = ModifiedTime;
        }

        public boolean isIsDelete() {
            return IsDelete;
        }

        public void setIsDelete(boolean IsDelete) {
            this.IsDelete = IsDelete;
        }

        public Object getRemark() {
            return Remark;
        }

        public void setRemark(Object Remark) {
            this.Remark = Remark;
        }

        public String getOldPersonId() {
            return OldPersonId;
        }

        public void setOldPersonId(String OldPersonId) {
            this.OldPersonId = OldPersonId;
        }

        public String getOldPersonName() {
            return OldPersonName;
        }

        public void setOldPersonName(String OldPersonName) {
            this.OldPersonName = OldPersonName;
        }
    }
}
