package com.example.administrator.OurPersion.Model.Bean;

import java.util.List;

/**
 * Created by Administrator on 2017/8/7 0007.
 */

public class Code {

    private String phone;
    private List<String> para;
    private String serviceModel;
    private String loginId;
    private String loginName;

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPara(List<String> para) {
        this.para = para;
    }

    public void setServiceModel(String serviceModel) {
        this.serviceModel = serviceModel;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPhone() {

        return phone;
    }

    public List<String> getPara() {
        return para;
    }

    public String getServiceModel() {
        return serviceModel;
    }

    public String getLoginId() {
        return loginId;
    }

    public String getLoginName() {
        return loginName;
    }
}
