package com.example.administrator.OurPersion.Model.Bean;

import java.util.List;

/**
 * Created by Administrator on 2017/9/8 0008.
 */

public class OldManPlanItem {

    private List<OldManPlanItemBean> OldManPlanItem;

    public List<OldManPlanItemBean> getOldManPlanItem() {
        return OldManPlanItem;
    }

    public void setOldManPlanItem(List<OldManPlanItemBean> OldManPlanItem) {
        this.OldManPlanItem = OldManPlanItem;
    }

    public static class OldManPlanItemBean {

        /**
         * Id : 8d1e0a38-95fc-4eca-ab97-378aeaac0e65(子项目id)
         * ItemId : 98d6343c-9802-4869-a1f7-5ff0787fb9a2（父项目id）
         * SubItemName : 收缩压
         * SubStandardVal : 70
         * HtmlTagType : 0
         * IsSelect  o表示未选中，1表示选中
         * boolean
         * SetValue
         */

        private String Id;
        private String ItemId;
        private String SubItemName;
        private String SubStandardVal;
        private String HtmlTagType;
        private String IsSelect;
        private String SetValue;

        public void setSetValue(String setValue) {
            SetValue = setValue;
        }

        public String getSetValue() {

            return SetValue;
        }

        public void setIsSelect(String isSelect) {
            IsSelect = isSelect;
        }

        public String getIsSelect() {

            return IsSelect;
        }

        public String getId() {
            return Id;
        }

        public void setId(String Id) {
            this.Id = Id;
        }

        public String getItemId() {
            return ItemId;
        }

        public void setItemId(String ItemId) {
            this.ItemId = ItemId;
        }

        public String getSubItemName() {
            return SubItemName;
        }

        public void setSubItemName(String SubItemName) {
            this.SubItemName = SubItemName;
        }

        public String getSubStandardVal() {
            return SubStandardVal;
        }

        public void setSubStandardVal(String SubStandardVal) {
            this.SubStandardVal = SubStandardVal;
        }

        public String getHtmlTagType() {
            return HtmlTagType;
        }

        public void setHtmlTagType(String HtmlTagType) {
            this.HtmlTagType = HtmlTagType;
        }
    }
}
