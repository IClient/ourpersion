package com.example.administrator.OurPersion.Model.Bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/9/30 0030.
 */

public class AreaOldMan {


    private List<AreaOldManBean> AreaOldMan;

    public List<AreaOldManBean> getAreaOldMan() {
        return AreaOldMan;
    }

    public void setAreaOldMan(List<AreaOldManBean> AreaOldMan) {
        this.AreaOldMan = AreaOldMan;
    }

    public static class AreaOldManBean implements Serializable {
        /**
         * OlderId : 92440962-d74d-4e79-b8d7-b62a759c0b4e
         * InLiveId : 8c8bec6b-888b-4ad7-8909-760a6471db61
         * CustomerName : 关羽
         * Sex : 0
         * PhoneNumber : 13585454654
         * ImgPath : /Resource/OldManage/d1624e9d-8f08-4b50-9f4b-2d3e7988553f.jpg
         * Birthday
         * Address
         */

        private String OlderId;
        private String InLiveId;
        private String CustomerName;
        private String Sex;
        private String PhoneNumber;
        private String ImgPath;
        private String Birthday;
        private String Address;

        public String getAddress() {
            return Address;
        }

        public void setAddress(String address) {
            Address = address;
        }

        public void setBirthday(String birthday) {
            Birthday = birthday;
        }

        public String getBirthday() {
            return Birthday;
        }

        public String getOlderId() {
            return OlderId;
        }

        public void setOlderId(String OlderId) {
            this.OlderId = OlderId;
        }

        public String getInLiveId() {
            return InLiveId;
        }

        public void setInLiveId(String InLiveId) {
            this.InLiveId = InLiveId;
        }

        public String getCustomerName() {
            return CustomerName;
        }

        public void setCustomerName(String CustomerName) {
            this.CustomerName = CustomerName;
        }

        public String getSex() {
            return Sex;
        }

        public void setSex(String Sex) {
            this.Sex = Sex;
        }

        public String getPhoneNumber() {
            return PhoneNumber;
        }

        public void setPhoneNumber(String PhoneNumber) {
            this.PhoneNumber = PhoneNumber;
        }

        public String getImgPath() {
            return ImgPath;
        }

        public void setImgPath(String ImgPath) {
            this.ImgPath = ImgPath;
        }
    }
}
