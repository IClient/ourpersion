package com.example.administrator.OurPersion.Model.Bean;

import java.util.List;

/**
 * Created by Administrator on 2017/9/8 0008.
 */

public class OldManAllPlan {

    private List<OldManAllPlanBean> OldManAllPlan;

    public List<OldManAllPlanBean> getOldManAllPlan() {
        return OldManAllPlan;
    }

    public void setOldManAllPlan(List<OldManAllPlanBean> OldManAllPlan) {
        this.OldManAllPlan = OldManAllPlan;
    }

    public static class OldManAllPlanBean {
        /**
         * Id : aaca6652-eb85-4bbb-a638-03676c3c3e6c
         * ItemType : 3
         * ItemName : 骨折
         * SimpleCode : GZ
         * ItemCost : 200.0
         * Mark : 0
         * CreaterId : f54e463c-0cf4-4269-9d5f-3a3db6e32b31
         * CreaterName : admin
         * CreatedTime : 2017-09-01T15:30:37.61
         * ModifierId : f54e463c-0cf4-4269-9d5f-3a3db6e32b31
         * ModifierName : admin
         * ModifiedTime : 2017-09-01T15:30:37.61
         * Remark : null
         * isCheck:1表示选中，0表示未选中
         */

        private String Id;
        private String ItemType;
        private String ItemName;
        private String SimpleCode;
        private double ItemCost;
        private String Mark;
        private String CreaterId;
        private String CreaterName;
        private String CreatedTime;
        private String ModifierId;
        private String ModifierName;
        private String ModifiedTime;
        private Object Remark;
        private  String isCheck;

        public void setIsCheck(String isCheck) {
            this.isCheck = isCheck;
        }

        public String getIsCheck() {

            return isCheck;
        }

        public String getId() {
            return Id;
        }

        public void setId(String Id) {
            this.Id = Id;
        }

        public String getItemType() {
            return ItemType;
        }

        public void setItemType(String ItemType) {
            this.ItemType = ItemType;
        }

        public String getItemName() {
            return ItemName;
        }

        public void setItemName(String ItemName) {
            this.ItemName = ItemName;
        }

        public String getSimpleCode() {
            return SimpleCode;
        }

        public void setSimpleCode(String SimpleCode) {
            this.SimpleCode = SimpleCode;
        }

        public double getItemCost() {
            return ItemCost;
        }

        public void setItemCost(double ItemCost) {
            this.ItemCost = ItemCost;
        }

        public String getMark() {
            return Mark;
        }

        public void setMark(String Mark) {
            this.Mark = Mark;
        }

        public String getCreaterId() {
            return CreaterId;
        }

        public void setCreaterId(String CreaterId) {
            this.CreaterId = CreaterId;
        }

        public String getCreaterName() {
            return CreaterName;
        }

        public void setCreaterName(String CreaterName) {
            this.CreaterName = CreaterName;
        }

        public String getCreatedTime() {
            return CreatedTime;
        }

        public void setCreatedTime(String CreatedTime) {
            this.CreatedTime = CreatedTime;
        }

        public String getModifierId() {
            return ModifierId;
        }

        public void setModifierId(String ModifierId) {
            this.ModifierId = ModifierId;
        }

        public String getModifierName() {
            return ModifierName;
        }

        public void setModifierName(String ModifierName) {
            this.ModifierName = ModifierName;
        }

        public String getModifiedTime() {
            return ModifiedTime;
        }

        public void setModifiedTime(String ModifiedTime) {
            this.ModifiedTime = ModifiedTime;
        }

        public Object getRemark() {
            return Remark;
        }

        public void setRemark(Object Remark) {
            this.Remark = Remark;
        }
    }
}
