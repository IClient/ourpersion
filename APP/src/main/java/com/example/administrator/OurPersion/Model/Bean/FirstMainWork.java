package com.example.administrator.OurPersion.Model.Bean;

import java.util.List;

/**
 * Created by Administrator on 2017/10/9 0009.
 */

public class FirstMainWork {

    private List<FirstMainWorkBean> FirstMainWork;

    public List<FirstMainWorkBean> getFirstMainWork() {
        return FirstMainWork;
    }

    public void setFirstMainWork(List<FirstMainWorkBean> FirstMainWork) {
        this.FirstMainWork = FirstMainWork;
    }

    public static class FirstMainWorkBean {
        /**
         * EmployeeId : eef70e20-c0a3-44ee-bbb9-5e671b21bdd7
         * EmployeeName : admin
         * YMD : 2017/10/1
         * Year : 2017
         * Month : 10
         * Day : 1
         * SimpleName : 前,晚,夜
         */

        private String EmployeeId;
        private String EmployeeName;
        private String YMD;
        private int Year;
        private int Month;
        private int Day;
        private String SimpleName;

        public String getEmployeeId() {
            return EmployeeId;
        }

        public void setEmployeeId(String EmployeeId) {
            this.EmployeeId = EmployeeId;
        }

        public String getEmployeeName() {
            return EmployeeName;
        }

        public void setEmployeeName(String EmployeeName) {
            this.EmployeeName = EmployeeName;
        }

        public String getYMD() {
            return YMD;
        }

        public void setYMD(String YMD) {
            this.YMD = YMD;
        }

        public int getYear() {
            return Year;
        }

        public void setYear(int Year) {
            this.Year = Year;
        }

        public int getMonth() {
            return Month;
        }

        public void setMonth(int Month) {
            this.Month = Month;
        }

        public int getDay() {
            return Day;
        }

        public void setDay(int Day) {
            this.Day = Day;
        }

        public String getSimpleName() {
            return SimpleName;
        }

        public void setSimpleName(String SimpleName) {
            this.SimpleName = SimpleName;
        }
    }
}
