package com.example.administrator.OurPersion.Model.Bean;

import java.util.List;

/**
 * Created by Administrator on 2017/9/30 0030.
 */

public class MeQJWork {

    /**
     * MeQJWork : {"ExtraCount":0,"CurrentPageIndex":1,"PageSize":10,"TotalItemCount":1,"TotalPageCount":1,"StartRecordIndex":1,"EndRecordIndex":1,"Datas":[{"Id":"462aea0e-6afb-4656-b7ec-12865e52524b","ApplicantId":"eef70e20-c0a3-44ee-bbb9-5e671b21bdd7","ApplicantName":"admin","DepartmentId":"2928b47a-2e46-471f-8b66-41c2bb03ba11","DepartmentName":"业务部","ApplyTime":"2017-09-30T17:18:06","ApplyType":"1","ApplyStartTime1":"2017-09-30T17:18:00","ApplyEndTime1":"2017-09-30T17:18:00","ApplyStartTime2":"2017-09-30T17:18:00","ApplyEndTime2":"2017-09-30T17:18:00","AskForLeaveReason":null,"WorkCoordinate":"0","WorkCoordinateRemark":null,"InstanceId":"b24796f5-83b5-44b0-9653-5276a0d05fac","Remark":null,"CreaterId":"eef70e20-c0a3-44ee-bbb9-5e671b21bdd7","CreaterName":"admin","CreatedTime":"2017-09-30T17:19:13.393","ModifierId":"4e3b6f6d-6c15-4905-9424-bd8ac30af636","ModifierName":"王福龙","ModifiedTime":"2017-09-30T17:20:51.28","WorkFlowState":"1","AskForLeaveDays":1,"WorkFlowType":"请假","WorkFlowName":"员工请假流程","NowStepId":"6d3f70ae-a182-4ad3-9e1c-1dc46a2eca2f","NowStepWorkFlowNodeName":"填写请假单","NowStepOperaterId":"00000000-0000-0000-0000-000000000000","NowStepOperaterName":"00000000-0000-0000-0000-000000000000","DataRelationId":"00000000-0000-0000-0000-000000000000","ProcessResult":false,"ProcessOpinion":null,"NextStepOperatoerIds":null,"NextStepName":null,"OtherParm":null,"PrevOperatoerId":"00000000-0000-0000-0000-000000000000","PrevOperatoerName":null,"PrevWorkflowId":"00000000-0000-0000-0000-000000000000","PrevWorkflowName":null,"PrevProcessResult":false,"PrevProcessOpinion":null,"ComparableValue":null}]}
     */

    private MeQJWorkBean MeQJWork;

    public MeQJWorkBean getMeQJWork() {
        return MeQJWork;
    }

    public void setMeQJWork(MeQJWorkBean MeQJWork) {
        this.MeQJWork = MeQJWork;
    }

    public static class MeQJWorkBean {
        /**
         * ExtraCount : 0
         * CurrentPageIndex : 1
         * PageSize : 10
         * TotalItemCount : 1
         * TotalPageCount : 1
         * StartRecordIndex : 1
         * EndRecordIndex : 1
         * Datas : [{"Id":"462aea0e-6afb-4656-b7ec-12865e52524b","ApplicantId":"eef70e20-c0a3-44ee-bbb9-5e671b21bdd7","ApplicantName":"admin","DepartmentId":"2928b47a-2e46-471f-8b66-41c2bb03ba11","DepartmentName":"业务部","ApplyTime":"2017-09-30T17:18:06","ApplyType":"1","ApplyStartTime1":"2017-09-30T17:18:00","ApplyEndTime1":"2017-09-30T17:18:00","ApplyStartTime2":"2017-09-30T17:18:00","ApplyEndTime2":"2017-09-30T17:18:00","AskForLeaveReason":null,"WorkCoordinate":"0","WorkCoordinateRemark":null,"InstanceId":"b24796f5-83b5-44b0-9653-5276a0d05fac","Remark":null,"CreaterId":"eef70e20-c0a3-44ee-bbb9-5e671b21bdd7","CreaterName":"admin","CreatedTime":"2017-09-30T17:19:13.393","ModifierId":"4e3b6f6d-6c15-4905-9424-bd8ac30af636","ModifierName":"王福龙","ModifiedTime":"2017-09-30T17:20:51.28","WorkFlowState":"1","AskForLeaveDays":1,"WorkFlowType":"请假","WorkFlowName":"员工请假流程","NowStepId":"6d3f70ae-a182-4ad3-9e1c-1dc46a2eca2f","NowStepWorkFlowNodeName":"填写请假单","NowStepOperaterId":"00000000-0000-0000-0000-000000000000","NowStepOperaterName":"00000000-0000-0000-0000-000000000000","DataRelationId":"00000000-0000-0000-0000-000000000000","ProcessResult":false,"ProcessOpinion":null,"NextStepOperatoerIds":null,"NextStepName":null,"OtherParm":null,"PrevOperatoerId":"00000000-0000-0000-0000-000000000000","PrevOperatoerName":null,"PrevWorkflowId":"00000000-0000-0000-0000-000000000000","PrevWorkflowName":null,"PrevProcessResult":false,"PrevProcessOpinion":null,"ComparableValue":null}]
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
             * Id : 462aea0e-6afb-4656-b7ec-12865e52524b
             * ApplicantId : eef70e20-c0a3-44ee-bbb9-5e671b21bdd7
             * ApplicantName : admin
             * DepartmentId : 2928b47a-2e46-471f-8b66-41c2bb03ba11
             * DepartmentName : 业务部
             * ApplyTime : 2017-09-30T17:18:06
             * ApplyType : 1
             * ApplyStartTime1 : 2017-09-30T17:18:00
             * ApplyEndTime1 : 2017-09-30T17:18:00
             * ApplyStartTime2 : 2017-09-30T17:18:00
             * ApplyEndTime2 : 2017-09-30T17:18:00
             * AskForLeaveReason : null
             * WorkCoordinate : 0
             * WorkCoordinateRemark : null
             * InstanceId : b24796f5-83b5-44b0-9653-5276a0d05fac
             * Remark : null
             * CreaterId : eef70e20-c0a3-44ee-bbb9-5e671b21bdd7
             * CreaterName : admin
             * CreatedTime : 2017-09-30T17:19:13.393
             * ModifierId : 4e3b6f6d-6c15-4905-9424-bd8ac30af636
             * ModifierName : 王福龙
             * ModifiedTime : 2017-09-30T17:20:51.28
             * WorkFlowState : 1
             * AskForLeaveDays : 1.0
             * WorkFlowType : 请假
             * WorkFlowName : 员工请假流程
             * NowStepId : 6d3f70ae-a182-4ad3-9e1c-1dc46a2eca2f
             * NowStepWorkFlowNodeName : 填写请假单
             * NowStepOperaterId : 00000000-0000-0000-0000-000000000000
             * NowStepOperaterName : 00000000-0000-0000-0000-000000000000
             * DataRelationId : 00000000-0000-0000-0000-000000000000
             * ProcessResult : false
             * ProcessOpinion : null
             * NextStepOperatoerIds : null
             * NextStepName : null
             * OtherParm : null
             * PrevOperatoerId : 00000000-0000-0000-0000-000000000000
             * PrevOperatoerName : null
             * PrevWorkflowId : 00000000-0000-0000-0000-000000000000
             * PrevWorkflowName : null
             * PrevProcessResult : false
             * PrevProcessOpinion : null
             * ComparableValue : null
             */

            private String Id;
            private String ApplicantId;
            private String ApplicantName;
            private String DepartmentId;
            private String DepartmentName;
            private String ApplyTime;
            private String ApplyType;
            private String ApplyStartTime1;
            private String ApplyEndTime1;
            private String ApplyStartTime2;
            private String ApplyEndTime2;
            private Object AskForLeaveReason;
            private String WorkCoordinate;
            private Object WorkCoordinateRemark;
            private String InstanceId;
            private Object Remark;
            private String CreaterId;
            private String CreaterName;
            private String CreatedTime;
            private String ModifierId;
            private String ModifierName;
            private String ModifiedTime;
            private String WorkFlowState;
            private double AskForLeaveDays;
            private String WorkFlowType;
            private String WorkFlowName;
            private String NowStepId;
            private String NowStepWorkFlowNodeName;
            private String NowStepOperaterId;
            private String NowStepOperaterName;
            private String DataRelationId;
            private boolean ProcessResult;
            private Object ProcessOpinion;
            private Object NextStepOperatoerIds;
            private Object NextStepName;
            private Object OtherParm;
            private String PrevOperatoerId;
            private Object PrevOperatoerName;
            private String PrevWorkflowId;
            private Object PrevWorkflowName;
            private boolean PrevProcessResult;
            private Object PrevProcessOpinion;
            private Object ComparableValue;

            public String getId() {
                return Id;
            }

            public void setId(String Id) {
                this.Id = Id;
            }

            public String getApplicantId() {
                return ApplicantId;
            }

            public void setApplicantId(String ApplicantId) {
                this.ApplicantId = ApplicantId;
            }

            public String getApplicantName() {
                return ApplicantName;
            }

            public void setApplicantName(String ApplicantName) {
                this.ApplicantName = ApplicantName;
            }

            public String getDepartmentId() {
                return DepartmentId;
            }

            public void setDepartmentId(String DepartmentId) {
                this.DepartmentId = DepartmentId;
            }

            public String getDepartmentName() {
                return DepartmentName;
            }

            public void setDepartmentName(String DepartmentName) {
                this.DepartmentName = DepartmentName;
            }

            public String getApplyTime() {
                return ApplyTime;
            }

            public void setApplyTime(String ApplyTime) {
                this.ApplyTime = ApplyTime;
            }

            public String getApplyType() {
                return ApplyType;
            }

            public void setApplyType(String ApplyType) {
                this.ApplyType = ApplyType;
            }

            public String getApplyStartTime1() {
                return ApplyStartTime1;
            }

            public void setApplyStartTime1(String ApplyStartTime1) {
                this.ApplyStartTime1 = ApplyStartTime1;
            }

            public String getApplyEndTime1() {
                return ApplyEndTime1;
            }

            public void setApplyEndTime1(String ApplyEndTime1) {
                this.ApplyEndTime1 = ApplyEndTime1;
            }

            public String getApplyStartTime2() {
                return ApplyStartTime2;
            }

            public void setApplyStartTime2(String ApplyStartTime2) {
                this.ApplyStartTime2 = ApplyStartTime2;
            }

            public String getApplyEndTime2() {
                return ApplyEndTime2;
            }

            public void setApplyEndTime2(String ApplyEndTime2) {
                this.ApplyEndTime2 = ApplyEndTime2;
            }

            public Object getAskForLeaveReason() {
                return AskForLeaveReason;
            }

            public void setAskForLeaveReason(Object AskForLeaveReason) {
                this.AskForLeaveReason = AskForLeaveReason;
            }

            public String getWorkCoordinate() {
                return WorkCoordinate;
            }

            public void setWorkCoordinate(String WorkCoordinate) {
                this.WorkCoordinate = WorkCoordinate;
            }

            public Object getWorkCoordinateRemark() {
                return WorkCoordinateRemark;
            }

            public void setWorkCoordinateRemark(Object WorkCoordinateRemark) {
                this.WorkCoordinateRemark = WorkCoordinateRemark;
            }

            public String getInstanceId() {
                return InstanceId;
            }

            public void setInstanceId(String InstanceId) {
                this.InstanceId = InstanceId;
            }

            public Object getRemark() {
                return Remark;
            }

            public void setRemark(Object Remark) {
                this.Remark = Remark;
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

            public String getWorkFlowState() {
                return WorkFlowState;
            }

            public void setWorkFlowState(String WorkFlowState) {
                this.WorkFlowState = WorkFlowState;
            }

            public double getAskForLeaveDays() {
                return AskForLeaveDays;
            }

            public void setAskForLeaveDays(double AskForLeaveDays) {
                this.AskForLeaveDays = AskForLeaveDays;
            }

            public String getWorkFlowType() {
                return WorkFlowType;
            }

            public void setWorkFlowType(String WorkFlowType) {
                this.WorkFlowType = WorkFlowType;
            }

            public String getWorkFlowName() {
                return WorkFlowName;
            }

            public void setWorkFlowName(String WorkFlowName) {
                this.WorkFlowName = WorkFlowName;
            }

            public String getNowStepId() {
                return NowStepId;
            }

            public void setNowStepId(String NowStepId) {
                this.NowStepId = NowStepId;
            }

            public String getNowStepWorkFlowNodeName() {
                return NowStepWorkFlowNodeName;
            }

            public void setNowStepWorkFlowNodeName(String NowStepWorkFlowNodeName) {
                this.NowStepWorkFlowNodeName = NowStepWorkFlowNodeName;
            }

            public String getNowStepOperaterId() {
                return NowStepOperaterId;
            }

            public void setNowStepOperaterId(String NowStepOperaterId) {
                this.NowStepOperaterId = NowStepOperaterId;
            }

            public String getNowStepOperaterName() {
                return NowStepOperaterName;
            }

            public void setNowStepOperaterName(String NowStepOperaterName) {
                this.NowStepOperaterName = NowStepOperaterName;
            }

            public String getDataRelationId() {
                return DataRelationId;
            }

            public void setDataRelationId(String DataRelationId) {
                this.DataRelationId = DataRelationId;
            }

            public boolean isProcessResult() {
                return ProcessResult;
            }

            public void setProcessResult(boolean ProcessResult) {
                this.ProcessResult = ProcessResult;
            }

            public Object getProcessOpinion() {
                return ProcessOpinion;
            }

            public void setProcessOpinion(Object ProcessOpinion) {
                this.ProcessOpinion = ProcessOpinion;
            }

            public Object getNextStepOperatoerIds() {
                return NextStepOperatoerIds;
            }

            public void setNextStepOperatoerIds(Object NextStepOperatoerIds) {
                this.NextStepOperatoerIds = NextStepOperatoerIds;
            }

            public Object getNextStepName() {
                return NextStepName;
            }

            public void setNextStepName(Object NextStepName) {
                this.NextStepName = NextStepName;
            }

            public Object getOtherParm() {
                return OtherParm;
            }

            public void setOtherParm(Object OtherParm) {
                this.OtherParm = OtherParm;
            }

            public String getPrevOperatoerId() {
                return PrevOperatoerId;
            }

            public void setPrevOperatoerId(String PrevOperatoerId) {
                this.PrevOperatoerId = PrevOperatoerId;
            }

            public Object getPrevOperatoerName() {
                return PrevOperatoerName;
            }

            public void setPrevOperatoerName(Object PrevOperatoerName) {
                this.PrevOperatoerName = PrevOperatoerName;
            }

            public String getPrevWorkflowId() {
                return PrevWorkflowId;
            }

            public void setPrevWorkflowId(String PrevWorkflowId) {
                this.PrevWorkflowId = PrevWorkflowId;
            }

            public Object getPrevWorkflowName() {
                return PrevWorkflowName;
            }

            public void setPrevWorkflowName(Object PrevWorkflowName) {
                this.PrevWorkflowName = PrevWorkflowName;
            }

            public boolean isPrevProcessResult() {
                return PrevProcessResult;
            }

            public void setPrevProcessResult(boolean PrevProcessResult) {
                this.PrevProcessResult = PrevProcessResult;
            }

            public Object getPrevProcessOpinion() {
                return PrevProcessOpinion;
            }

            public void setPrevProcessOpinion(Object PrevProcessOpinion) {
                this.PrevProcessOpinion = PrevProcessOpinion;
            }

            public Object getComparableValue() {
                return ComparableValue;
            }

            public void setComparableValue(Object ComparableValue) {
                this.ComparableValue = ComparableValue;
            }
        }
    }
}
