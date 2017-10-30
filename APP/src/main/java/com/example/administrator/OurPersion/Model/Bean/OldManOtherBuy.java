package com.example.administrator.OurPersion.Model.Bean;

import java.util.List;

/**
 * Created by Administrator on 2017/9/21 0021.
 */

public class OldManOtherBuy {
    /**
     * OldManOtherBuy : {"ExtraCount":0,"CurrentPageIndex":1,"PageSize":4,"TotalItemCount":3,"TotalPageCount":1,"StartRecordIndex":1,"EndRecordIndex":3,"Datas":[{"Id":"c70484f9-28e5-42ec-8b4f-3c0129fa8713","CostDesception":"测试","CostAmount":-10,"OldPersonId":"44b4ad7f-00f4-4cbb-98ce-27b66a84ad79","OldPersonName":"李军","CheckInId":"87b46125-6fc9-4c5c-b696-2a4e20b08a81","ProduceTime":"2017-09-21T00:00:00","CreateId":"eef70e20-c0a3-44ee-bbb9-5e671b21bdd7","CreaterName":"admin","CreaterTime":"2017-09-21T15:36:49.123","ModifiedId":"eef70e20-c0a3-44ee-bbb9-5e671b21bdd7","ModifiedName":"admin","ModifiedTime":"2017-09-21T15:36:49.123","Remark":"测试","State":"1"},{"Id":"bacd9765-4933-4bf4-8e6c-aaa2aaa5224e","CostDesception":"cs","CostAmount":-4205,"OldPersonId":"44b4ad7f-00f4-4cbb-98ce-27b66a84ad79","OldPersonName":"李军","CheckInId":"87b46125-6fc9-4c5c-b696-2a4e20b08a81","ProduceTime":"2017-09-21T00:00:00","CreateId":"eef70e20-c0a3-44ee-bbb9-5e671b21bdd7","CreaterName":"admin","CreaterTime":"2017-09-21T16:01:44.887","ModifiedId":"eef70e20-c0a3-44ee-bbb9-5e671b21bdd7","ModifiedName":"admin","ModifiedTime":"2017-09-21T16:01:44.887","Remark":"cs","State":"1"},{"Id":"4b09ad00-c3c2-45a2-9805-ba45ce6fab42","CostDesception":"测试","CostAmount":-4532.23,"OldPersonId":"44b4ad7f-00f4-4cbb-98ce-27b66a84ad79","OldPersonName":"李军","CheckInId":"87b46125-6fc9-4c5c-b696-2a4e20b08a81","ProduceTime":"2017-09-21T00:00:00","CreateId":"eef70e20-c0a3-44ee-bbb9-5e671b21bdd7","CreaterName":"admin","CreaterTime":"2017-09-21T15:33:41.987","ModifiedId":"eef70e20-c0a3-44ee-bbb9-5e671b21bdd7","ModifiedName":"admin","ModifiedTime":"2017-09-21T15:33:41.987","Remark":"测试","State":"1"}]}
     */

    private OldManOtherBuyBean OldManOtherBuy;

    public OldManOtherBuyBean getOldManOtherBuy() {
        return OldManOtherBuy;
    }

    public void setOldManOtherBuy(OldManOtherBuyBean OldManOtherBuy) {
        this.OldManOtherBuy = OldManOtherBuy;
    }

    public static class OldManOtherBuyBean {
        /**
         * ExtraCount : 0
         * CurrentPageIndex : 1
         * PageSize : 4
         * TotalItemCount : 3
         * TotalPageCount : 1
         * StartRecordIndex : 1
         * EndRecordIndex : 3
         * Datas : [{"Id":"c70484f9-28e5-42ec-8b4f-3c0129fa8713","CostDesception":"测试","CostAmount":-10,"OldPersonId":"44b4ad7f-00f4-4cbb-98ce-27b66a84ad79","OldPersonName":"李军","CheckInId":"87b46125-6fc9-4c5c-b696-2a4e20b08a81","ProduceTime":"2017-09-21T00:00:00","CreateId":"eef70e20-c0a3-44ee-bbb9-5e671b21bdd7","CreaterName":"admin","CreaterTime":"2017-09-21T15:36:49.123","ModifiedId":"eef70e20-c0a3-44ee-bbb9-5e671b21bdd7","ModifiedName":"admin","ModifiedTime":"2017-09-21T15:36:49.123","Remark":"测试","State":"1"},{"Id":"bacd9765-4933-4bf4-8e6c-aaa2aaa5224e","CostDesception":"cs","CostAmount":-4205,"OldPersonId":"44b4ad7f-00f4-4cbb-98ce-27b66a84ad79","OldPersonName":"李军","CheckInId":"87b46125-6fc9-4c5c-b696-2a4e20b08a81","ProduceTime":"2017-09-21T00:00:00","CreateId":"eef70e20-c0a3-44ee-bbb9-5e671b21bdd7","CreaterName":"admin","CreaterTime":"2017-09-21T16:01:44.887","ModifiedId":"eef70e20-c0a3-44ee-bbb9-5e671b21bdd7","ModifiedName":"admin","ModifiedTime":"2017-09-21T16:01:44.887","Remark":"cs","State":"1"},{"Id":"4b09ad00-c3c2-45a2-9805-ba45ce6fab42","CostDesception":"测试","CostAmount":-4532.23,"OldPersonId":"44b4ad7f-00f4-4cbb-98ce-27b66a84ad79","OldPersonName":"李军","CheckInId":"87b46125-6fc9-4c5c-b696-2a4e20b08a81","ProduceTime":"2017-09-21T00:00:00","CreateId":"eef70e20-c0a3-44ee-bbb9-5e671b21bdd7","CreaterName":"admin","CreaterTime":"2017-09-21T15:33:41.987","ModifiedId":"eef70e20-c0a3-44ee-bbb9-5e671b21bdd7","ModifiedName":"admin","ModifiedTime":"2017-09-21T15:33:41.987","Remark":"测试","State":"1"}]
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
             * Id : c70484f9-28e5-42ec-8b4f-3c0129fa8713
             * CostDesception : 测试
             * CostAmount : -10
             * OldPersonId : 44b4ad7f-00f4-4cbb-98ce-27b66a84ad79
             * OldPersonName : 李军
             * CheckInId : 87b46125-6fc9-4c5c-b696-2a4e20b08a81
             * ProduceTime : 2017-09-21T00:00:00
             * CreateId : eef70e20-c0a3-44ee-bbb9-5e671b21bdd7
             * CreaterName : admin
             * CreaterTime : 2017-09-21T15:36:49.123
             * ModifiedId : eef70e20-c0a3-44ee-bbb9-5e671b21bdd7
             * ModifiedName : admin
             * ModifiedTime : 2017-09-21T15:36:49.123
             * Remark : 测试
             * State : 1
             */

            private String Id;
            private String CostDesception;
            private double CostAmount;
            private String OldPersonId;
            private String OldPersonName;
            private String CheckInId;
            private String ProduceTime;
            private String CreateId;
            private String CreaterName;
            private String CreaterTime;
            private String ModifiedId;
            private String ModifiedName;
            private String ModifiedTime;
            private String Remark;
            private String State;

            public String getId() {
                return Id;
            }

            public void setId(String Id) {
                this.Id = Id;
            }

            public String getCostDesception() {
                return CostDesception;
            }

            public void setCostDesception(String CostDesception) {
                this.CostDesception = CostDesception;
            }

            public double getCostAmount() {
                return CostAmount;
            }

            public void setCostAmount(double CostAmount) {
                this.CostAmount = CostAmount;
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

            public String getCheckInId() {
                return CheckInId;
            }

            public void setCheckInId(String CheckInId) {
                this.CheckInId = CheckInId;
            }

            public String getProduceTime() {
                return ProduceTime;
            }

            public void setProduceTime(String ProduceTime) {
                this.ProduceTime = ProduceTime;
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

            public String getState() {
                return State;
            }

            public void setState(String State) {
                this.State = State;
            }
        }
    }
}
