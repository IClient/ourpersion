package com.example.administrator.OurPersion.Model.Bean;

import java.util.List;

/**
 * Created by Administrator on 2017/9/21 0021.
 */

public class OldManMedicalFeeBuy {

    /**
     * OldManMedicalFeeBuy : {"ExtraCount":0,"CurrentPageIndex":1,"PageSize":4,"TotalItemCount":2,"TotalPageCount":1,"StartRecordIndex":1,"EndRecordIndex":2,"Datas":[{"MedicalBondChangeDetails":null,"MedicalBondPaymentDetials":null,"MedicalBond":null,"Id":"6aa0ce41-a23e-4584-b846-78f52bbad9b1","ChangeAmount":80000,"ChangeType":"0","CreateId":"4e3b6f6d-6c15-4905-9424-bd8ac30af636","CreaterName":"王福龙","CreaterTime":"2017-09-21T11:37:35.5","ModifiedId":"4e3b6f6d-6c15-4905-9424-bd8ac30af636","ModifiedName":"王福龙","ModifiedTime":"2017-09-21T11:37:35.5","Remark":"","MedicalBondId":"21fcdbff-6112-4ea6-8a55-263d41fc30bb","Balance":80000,"ChangeTime":"2017-09-21T11:37:00","ChanageAddress":"1111111","ChangeDisception":"医疗备用金账户首冲","OrderNumber":"YLBYJ201709211137357","HandlePerson":"王福龙"},{"MedicalBondChangeDetails":null,"MedicalBondPaymentDetials":null,"MedicalBond":null,"Id":"82c5b9bf-2b2a-442d-b8af-de8301154dae","ChangeAmount":-5000,"ChangeType":"1","CreateId":"4e3b6f6d-6c15-4905-9424-bd8ac30af636","CreaterName":"王福龙","CreaterTime":"2017-09-21T11:38:34.207","ModifiedId":"4e3b6f6d-6c15-4905-9424-bd8ac30af636","ModifiedName":"王福龙","ModifiedTime":"2017-09-21T11:38:34.207","Remark":"","MedicalBondId":"21fcdbff-6112-4ea6-8a55-263d41fc30bb","Balance":75000,"ChangeTime":"2017-09-21T11:37:00","ChanageAddress":"亲睦家","ChangeDisception":"吃饭","OrderNumber":"YLBYJ201709211138345","HandlePerson":"李小小"}]}
     */

    private OldManMedicalFeeBuyBean OldManMedicalFeeBuy;

    public OldManMedicalFeeBuyBean getOldManMedicalFeeBuy() {
        return OldManMedicalFeeBuy;
    }

    public void setOldManMedicalFeeBuy(OldManMedicalFeeBuyBean OldManMedicalFeeBuy) {
        this.OldManMedicalFeeBuy = OldManMedicalFeeBuy;
    }

    public static class OldManMedicalFeeBuyBean {
        /**
         * ExtraCount : 0
         * CurrentPageIndex : 1
         * PageSize : 4
         * TotalItemCount : 2
         * TotalPageCount : 1
         * StartRecordIndex : 1
         * EndRecordIndex : 2
         * Datas : [{"MedicalBondChangeDetails":null,"MedicalBondPaymentDetials":null,"MedicalBond":null,"Id":"6aa0ce41-a23e-4584-b846-78f52bbad9b1","ChangeAmount":80000,"ChangeType":"0","CreateId":"4e3b6f6d-6c15-4905-9424-bd8ac30af636","CreaterName":"王福龙","CreaterTime":"2017-09-21T11:37:35.5","ModifiedId":"4e3b6f6d-6c15-4905-9424-bd8ac30af636","ModifiedName":"王福龙","ModifiedTime":"2017-09-21T11:37:35.5","Remark":"","MedicalBondId":"21fcdbff-6112-4ea6-8a55-263d41fc30bb","Balance":80000,"ChangeTime":"2017-09-21T11:37:00","ChanageAddress":"1111111","ChangeDisception":"医疗备用金账户首冲","OrderNumber":"YLBYJ201709211137357","HandlePerson":"王福龙"},{"MedicalBondChangeDetails":null,"MedicalBondPaymentDetials":null,"MedicalBond":null,"Id":"82c5b9bf-2b2a-442d-b8af-de8301154dae","ChangeAmount":-5000,"ChangeType":"1","CreateId":"4e3b6f6d-6c15-4905-9424-bd8ac30af636","CreaterName":"王福龙","CreaterTime":"2017-09-21T11:38:34.207","ModifiedId":"4e3b6f6d-6c15-4905-9424-bd8ac30af636","ModifiedName":"王福龙","ModifiedTime":"2017-09-21T11:38:34.207","Remark":"","MedicalBondId":"21fcdbff-6112-4ea6-8a55-263d41fc30bb","Balance":75000,"ChangeTime":"2017-09-21T11:37:00","ChanageAddress":"亲睦家","ChangeDisception":"吃饭","OrderNumber":"YLBYJ201709211138345","HandlePerson":"李小小"}]
         */

        private int ExtraCount;
        private int CurrentPageIndex;
        private int PageSize;
        private int TotalItemCount;
        private int TotalPageCount;
        private int StartRecordIndex;
        private int EndRecordIndex;
        private List<DatasBean> Datas;

        public int getExtraCount() {
            return ExtraCount;
        }

        public void setExtraCount(int ExtraCount) {
            this.ExtraCount = ExtraCount;
        }

        public int getCurrentPageIndex() {
            return CurrentPageIndex;
        }

        public void setCurrentPageIndex(int CurrentPageIndex) {
            this.CurrentPageIndex = CurrentPageIndex;
        }

        public int getPageSize() {
            return PageSize;
        }

        public void setPageSize(int PageSize) {
            this.PageSize = PageSize;
        }

        public int getTotalItemCount() {
            return TotalItemCount;
        }

        public void setTotalItemCount(int TotalItemCount) {
            this.TotalItemCount = TotalItemCount;
        }

        public int getTotalPageCount() {
            return TotalPageCount;
        }

        public void setTotalPageCount(int TotalPageCount) {
            this.TotalPageCount = TotalPageCount;
        }

        public int getStartRecordIndex() {
            return StartRecordIndex;
        }

        public void setStartRecordIndex(int StartRecordIndex) {
            this.StartRecordIndex = StartRecordIndex;
        }

        public int getEndRecordIndex() {
            return EndRecordIndex;
        }

        public void setEndRecordIndex(int EndRecordIndex) {
            this.EndRecordIndex = EndRecordIndex;
        }

        public List<DatasBean> getDatas() {
            return Datas;
        }

        public void setDatas(List<DatasBean> Datas) {
            this.Datas = Datas;
        }

        public static class DatasBean {
            /**
             * MedicalBondChangeDetails : null
             * MedicalBondPaymentDetials : null
             * MedicalBond : null
             * Id : 6aa0ce41-a23e-4584-b846-78f52bbad9b1
             * ChangeAmount : 80000
             * ChangeType : 0
             * CreateId : 4e3b6f6d-6c15-4905-9424-bd8ac30af636
             * CreaterName : 王福龙
             * CreaterTime : 2017-09-21T11:37:35.5
             * ModifiedId : 4e3b6f6d-6c15-4905-9424-bd8ac30af636
             * ModifiedName : 王福龙
             * ModifiedTime : 2017-09-21T11:37:35.5
             * Remark :
             * MedicalBondId : 21fcdbff-6112-4ea6-8a55-263d41fc30bb
             * Balance : 80000
             * ChangeTime : 2017-09-21T11:37:00
             * ChanageAddress : 1111111
             * ChangeDisception : 医疗备用金账户首冲
             * OrderNumber : YLBYJ201709211137357
             * HandlePerson : 王福龙
             */

            private Object MedicalBondChangeDetails;
            private Object MedicalBondPaymentDetials;
            private Object MedicalBond;
            private String Id;
            private double ChangeAmount;
            private String ChangeType;
            private String CreateId;
            private String CreaterName;
            private String CreaterTime;
            private String ModifiedId;
            private String ModifiedName;
            private String ModifiedTime;
            private String Remark;
            private String MedicalBondId;
            private double Balance;
            private String ChangeTime;
            private String ChanageAddress;
            private String ChangeDisception;
            private String OrderNumber;
            private String HandlePerson;

            public Object getMedicalBondChangeDetails() {
                return MedicalBondChangeDetails;
            }

            public void setMedicalBondChangeDetails(Object MedicalBondChangeDetails) {
                this.MedicalBondChangeDetails = MedicalBondChangeDetails;
            }

            public Object getMedicalBondPaymentDetials() {
                return MedicalBondPaymentDetials;
            }

            public void setMedicalBondPaymentDetials(Object MedicalBondPaymentDetials) {
                this.MedicalBondPaymentDetials = MedicalBondPaymentDetials;
            }

            public Object getMedicalBond() {
                return MedicalBond;
            }

            public void setMedicalBond(Object MedicalBond) {
                this.MedicalBond = MedicalBond;
            }

            public String getId() {
                return Id;
            }

            public void setId(String Id) {
                this.Id = Id;
            }

            public double getChangeAmount() {
                return ChangeAmount;
            }

            public void setChangeAmount(double ChangeAmount) {
                this.ChangeAmount = ChangeAmount;
            }

            public String getChangeType() {
                return ChangeType;
            }

            public void setChangeType(String ChangeType) {
                this.ChangeType = ChangeType;
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

            public String getRemark() {
                return Remark;
            }

            public void setRemark(String Remark) {
                this.Remark = Remark;
            }

            public String getMedicalBondId() {
                return MedicalBondId;
            }

            public void setMedicalBondId(String MedicalBondId) {
                this.MedicalBondId = MedicalBondId;
            }

            public double getBalance() {
                return Balance;
            }

            public void setBalance(double Balance) {
                this.Balance = Balance;
            }

            public String getChangeTime() {
                return ChangeTime;
            }

            public void setChangeTime(String ChangeTime) {
                this.ChangeTime = ChangeTime;
            }

            public String getChanageAddress() {
                return ChanageAddress;
            }

            public void setChanageAddress(String ChanageAddress) {
                this.ChanageAddress = ChanageAddress;
            }

            public String getChangeDisception() {
                return ChangeDisception;
            }

            public void setChangeDisception(String ChangeDisception) {
                this.ChangeDisception = ChangeDisception;
            }

            public String getOrderNumber() {
                return OrderNumber;
            }

            public void setOrderNumber(String OrderNumber) {
                this.OrderNumber = OrderNumber;
            }

            public String getHandlePerson() {
                return HandlePerson;
            }

            public void setHandlePerson(String HandlePerson) {
                this.HandlePerson = HandlePerson;
            }
        }
    }
}
