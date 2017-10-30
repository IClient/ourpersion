package com.example.administrator.OurPersion.Model.Bean;

import java.util.List;

/**
 * Created by Administrator on 2017/8/25 0025.
 */

/**
 * 入住老人家庭信息
 */

public class OldManFamily {

    private List<OldManFamilyBean> OldManFamily;

    public List<OldManFamilyBean> getOldManFamily() {
        return OldManFamily;
    }

    public void setOldManFamily(List<OldManFamilyBean> OldManFamily) {
        this.OldManFamily = OldManFamily;
    }

    public static class OldManFamilyBean {
        /**
         * Id : 41ffecab-c8da-4d7f-8dc5-fbdd95cce593
         * OldId : 58651a18-7f38-41b2-89fe-b1d68094fc66
         * CustomerName : null
         * CertificateNo :
         * ChaperoneName : 王红
         * TelNo : 135422225417
         * Address :
         * Relation : 子女
         * CreaterId : a3b76962-e026-43d0-a98d-2935d80c371a
         * CreaterTime : 2017-08-24T10:55:04.197
         * CreaterName : 超级管理员
         * ModifiedId : eef70e20-c0a3-44ee-bbb9-5e671b21bdd7
         * ModifiedName : 超级管理员
         * Brithday : 2015－09－02
         * ModifiedTime : 2017-08-24T17:13:35.213
         * Mark : 0
         * Sex : 1
         */

        private String Id;
        private String OldId;
        private Object CustomerName;
        private String CertificateNo;
        private String ChaperoneName;
        private String TelNo;
        private String Address;
        private String Relation;
        private String CreaterId;
        private String CreaterTime;
        private String CreaterName;
        private String ModifiedId;
        private String ModifiedName;
        private String Brithday;
        private String ModifiedTime;
        private String Mark;
        private String Sex;

        public String getId() {
            return Id;
        }

        public void setId(String Id) {
            this.Id = Id;
        }

        public String getOldId() {
            return OldId;
        }

        public void setOldId(String OldId) {
            this.OldId = OldId;
        }

        public Object getCustomerName() {
            return CustomerName;
        }

        public void setCustomerName(Object CustomerName) {
            this.CustomerName = CustomerName;
        }

        public String getCertificateNo() {
            return CertificateNo;
        }

        public void setCertificateNo(String CertificateNo) {
            this.CertificateNo = CertificateNo;
        }

        public String getChaperoneName() {
            return ChaperoneName;
        }

        public void setChaperoneName(String ChaperoneName) {
            this.ChaperoneName = ChaperoneName;
        }

        public String getTelNo() {
            return TelNo;
        }

        public void setTelNo(String TelNo) {
            this.TelNo = TelNo;
        }

        public String getAddress() {
            return Address;
        }

        public void setAddress(String Address) {
            this.Address = Address;
        }

        public String getRelation() {
            return Relation;
        }

        public void setRelation(String Relation) {
            this.Relation = Relation;
        }

        public String getCreaterId() {
            return CreaterId;
        }

        public void setCreaterId(String CreaterId) {
            this.CreaterId = CreaterId;
        }

        public String getCreaterTime() {
            return CreaterTime;
        }

        public void setCreaterTime(String CreaterTime) {
            this.CreaterTime = CreaterTime;
        }

        public String getCreaterName() {
            return CreaterName;
        }

        public void setCreaterName(String CreaterName) {
            this.CreaterName = CreaterName;
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

        public String getBrithday() {
            return Brithday;
        }

        public void setBrithday(String Brithday) {
            this.Brithday = Brithday;
        }

        public String getModifiedTime() {
            return ModifiedTime;
        }

        public void setModifiedTime(String ModifiedTime) {
            this.ModifiedTime = ModifiedTime;
        }

        public String getMark() {
            return Mark;
        }

        public void setMark(String Mark) {
            this.Mark = Mark;
        }

        public String getSex() {
            return Sex;
        }

        public void setSex(String Sex) {
            this.Sex = Sex;
        }
    }
}
