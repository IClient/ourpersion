package com.example.administrator.OurPersion.Model.Bean;

import java.util.List;

/**
 * Created by Administrator on 2017/9/16 0016.
 */

public class OldManTrouable {


    private List<OldManTrouableBean> OldManTrouable;

    public List<OldManTrouableBean> getOldManTrouable() {
        return OldManTrouable;
    }

    public void setOldManTrouable(List<OldManTrouableBean> OldManTrouable) {
        this.OldManTrouable = OldManTrouable;
    }

    public static class OldManTrouableBean {
        /**
         * attachmentlist : null
         * ClassModel : {"id":"988442a2-1fcb-4c9c-be6f-65f59ba0b8a2","mark":"0","remark":null,"createrId":"eef70e20-c0a3-44ee-bbb9-5e671b21bdd7","createrName":"admin","createdTime":"2017-09-08T17:26:38.83","modifierId":"eef70e20-c0a3-44ee-bbb9-5e671b21bdd7","modifierName":"admin","modifiedTime":"2017-09-08T17:26:38.83","pid":"bc039df4-5504-4d91-a08e-d863f8d33916","dictionaryType":"事件种类","dictionaryName":"异物入口","sysDataState":"1","costData":0,"SimpleCode":null}
         * StatusModel : {"id":"15006b5c-d992-4b0e-9da6-fe4a830a2d8a","mark":"0","remark":null,"createrId":"eef70e20-c0a3-44ee-bbb9-5e671b21bdd7","createrName":"admin","createdTime":"2017-09-26T15:48:54.357","modifierId":"eef70e20-c0a3-44ee-bbb9-5e671b21bdd7","modifierName":"admin","modifiedTime":"2017-09-26T15:48:54.357","pid":"af582918-08bf-4195-8868-ded92b7211be","dictionaryType":"事件状态","dictionaryName":"跟进中","sysDataState":"1","costData":0,"SimpleCode":null}
         * Id : 19c8f1e2-88e3-4997-b10e-c8bcce6db739
         * HappendTime : 2017-09-26T00:00:00
         * EventDisception : 11
         * HandlePersonId : 00000000-0000-0000-0000-000000000000
         * HandlePersonName : null
         * HandleOpinions : null
         * InspectionStatus : null
         * CreateId : eef70e20-c0a3-44ee-bbb9-5e671b21bdd7
         * CreaterName : admin
         * CreaterTime : 2017-09-26T15:59:55.42
         * ModifiedId : eef70e20-c0a3-44ee-bbb9-5e671b21bdd7
         * ModifiedName : admin
         * ModifiedTime : 2017-09-26T16:00:02.63
         * IsDelete : false
         * Remark : null
         * OldPersonName : 张三峰
         * Place : null
         * TouchWith : 0
         * Type : 0
         * OldId : dfbffcbd-b22c-44b4-b0cb-3303390a5227
         * PlaceId : 00000000-0000-0000-0000-000000000000
         * Class : 988442a2-1fcb-4c9c-be6f-65f59ba0b8a2
         * Status : 15006b5c-d992-4b0e-9da6-fe4a830a2d8a
         */

        private Object attachmentlist;
        private ClassModelBean ClassModel;
        private StatusModelBean StatusModel;
        private String Id;
        private String HappendTime;
        private String EventDisception;
        private String HandlePersonId;
        private Object HandlePersonName;
        private Object HandleOpinions;
        private Object InspectionStatus;
        private String CreateId;
        private String CreaterName;
        private String CreaterTime;
        private String ModifiedId;
        private String ModifiedName;
        private String ModifiedTime;
        private boolean IsDelete;
        private Object Remark;
        private String OldPersonName;
        private Object Place;
        private String TouchWith;
        private String Type;
        private String OldId;
        private String PlaceId;
        private String Status;

        public Object getAttachmentlist() {
            return attachmentlist;
        }

        public void setAttachmentlist(Object attachmentlist) {
            this.attachmentlist = attachmentlist;
        }

        public ClassModelBean getClassModel() {
            return ClassModel;
        }

        public void setClassModel(ClassModelBean ClassModel) {
            this.ClassModel = ClassModel;
        }

        public StatusModelBean getStatusModel() {
            return StatusModel;
        }

        public void setStatusModel(StatusModelBean StatusModel) {
            this.StatusModel = StatusModel;
        }

        public String getId() {
            return Id;
        }

        public void setId(String Id) {
            this.Id = Id;
        }

        public String getHappendTime() {
            return HappendTime;
        }

        public void setHappendTime(String HappendTime) {
            this.HappendTime = HappendTime;
        }

        public String getEventDisception() {
            return EventDisception;
        }

        public void setEventDisception(String EventDisception) {
            this.EventDisception = EventDisception;
        }

        public String getHandlePersonId() {
            return HandlePersonId;
        }

        public void setHandlePersonId(String HandlePersonId) {
            this.HandlePersonId = HandlePersonId;
        }

        public Object getHandlePersonName() {
            return HandlePersonName;
        }

        public void setHandlePersonName(Object HandlePersonName) {
            this.HandlePersonName = HandlePersonName;
        }

        public Object getHandleOpinions() {
            return HandleOpinions;
        }

        public void setHandleOpinions(Object HandleOpinions) {
            this.HandleOpinions = HandleOpinions;
        }

        public Object getInspectionStatus() {
            return InspectionStatus;
        }

        public void setInspectionStatus(Object InspectionStatus) {
            this.InspectionStatus = InspectionStatus;
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

        public String getOldPersonName() {
            return OldPersonName;
        }

        public void setOldPersonName(String OldPersonName) {
            this.OldPersonName = OldPersonName;
        }

        public Object getPlace() {
            return Place;
        }

        public void setPlace(Object Place) {
            this.Place = Place;
        }

        public String getTouchWith() {
            return TouchWith;
        }

        public void setTouchWith(String TouchWith) {
            this.TouchWith = TouchWith;
        }

        public String getType() {
            return Type;
        }

        public void setType(String Type) {
            this.Type = Type;
        }

        public String getOldId() {
            return OldId;
        }

        public void setOldId(String OldId) {
            this.OldId = OldId;
        }

        public String getPlaceId() {
            return PlaceId;
        }

        public void setPlaceId(String PlaceId) {
            this.PlaceId = PlaceId;
        }


        public String getStatus() {
            return Status;
        }

        public void setStatus(String Status) {
            this.Status = Status;
        }

        public static class ClassModelBean {
            /**
             * id : 988442a2-1fcb-4c9c-be6f-65f59ba0b8a2
             * mark : 0
             * remark : null
             * createrId : eef70e20-c0a3-44ee-bbb9-5e671b21bdd7
             * createrName : admin
             * createdTime : 2017-09-08T17:26:38.83
             * modifierId : eef70e20-c0a3-44ee-bbb9-5e671b21bdd7
             * modifierName : admin
             * modifiedTime : 2017-09-08T17:26:38.83
             * pid : bc039df4-5504-4d91-a08e-d863f8d33916
             * dictionaryType : 事件种类
             * dictionaryName : 异物入口
             * sysDataState : 1
             * costData : 0
             * SimpleCode : null
             */

            private String id;
            private String mark;
            private Object remark;
            private String createrId;
            private String createrName;
            private String createdTime;
            private String modifierId;
            private String modifierName;
            private String modifiedTime;
            private String pid;
            private String dictionaryType;
            private String dictionaryName;
            private String sysDataState;
            private int costData;
            private Object SimpleCode;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getMark() {
                return mark;
            }

            public void setMark(String mark) {
                this.mark = mark;
            }

            public Object getRemark() {
                return remark;
            }

            public void setRemark(Object remark) {
                this.remark = remark;
            }

            public String getCreaterId() {
                return createrId;
            }

            public void setCreaterId(String createrId) {
                this.createrId = createrId;
            }

            public String getCreaterName() {
                return createrName;
            }

            public void setCreaterName(String createrName) {
                this.createrName = createrName;
            }

            public String getCreatedTime() {
                return createdTime;
            }

            public void setCreatedTime(String createdTime) {
                this.createdTime = createdTime;
            }

            public String getModifierId() {
                return modifierId;
            }

            public void setModifierId(String modifierId) {
                this.modifierId = modifierId;
            }

            public String getModifierName() {
                return modifierName;
            }

            public void setModifierName(String modifierName) {
                this.modifierName = modifierName;
            }

            public String getModifiedTime() {
                return modifiedTime;
            }

            public void setModifiedTime(String modifiedTime) {
                this.modifiedTime = modifiedTime;
            }

            public String getPid() {
                return pid;
            }

            public void setPid(String pid) {
                this.pid = pid;
            }

            public String getDictionaryType() {
                return dictionaryType;
            }

            public void setDictionaryType(String dictionaryType) {
                this.dictionaryType = dictionaryType;
            }

            public String getDictionaryName() {
                return dictionaryName;
            }

            public void setDictionaryName(String dictionaryName) {
                this.dictionaryName = dictionaryName;
            }

            public String getSysDataState() {
                return sysDataState;
            }

            public void setSysDataState(String sysDataState) {
                this.sysDataState = sysDataState;
            }

            public int getCostData() {
                return costData;
            }

            public void setCostData(int costData) {
                this.costData = costData;
            }

            public Object getSimpleCode() {
                return SimpleCode;
            }

            public void setSimpleCode(Object SimpleCode) {
                this.SimpleCode = SimpleCode;
            }
        }

        public static class StatusModelBean {
            /**
             * id : 15006b5c-d992-4b0e-9da6-fe4a830a2d8a
             * mark : 0
             * remark : null
             * createrId : eef70e20-c0a3-44ee-bbb9-5e671b21bdd7
             * createrName : admin
             * createdTime : 2017-09-26T15:48:54.357
             * modifierId : eef70e20-c0a3-44ee-bbb9-5e671b21bdd7
             * modifierName : admin
             * modifiedTime : 2017-09-26T15:48:54.357
             * pid : af582918-08bf-4195-8868-ded92b7211be
             * dictionaryType : 事件状态
             * dictionaryName : 跟进中
             * sysDataState : 1
             * costData : 0
             * SimpleCode : null
             */

            private String id;
            private String mark;
            private Object remark;
            private String createrId;
            private String createrName;
            private String createdTime;
            private String modifierId;
            private String modifierName;
            private String modifiedTime;
            private String pid;
            private String dictionaryType;
            private String dictionaryName;
            private String sysDataState;
            private int costData;
            private Object SimpleCode;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getMark() {
                return mark;
            }

            public void setMark(String mark) {
                this.mark = mark;
            }

            public Object getRemark() {
                return remark;
            }

            public void setRemark(Object remark) {
                this.remark = remark;
            }

            public String getCreaterId() {
                return createrId;
            }

            public void setCreaterId(String createrId) {
                this.createrId = createrId;
            }

            public String getCreaterName() {
                return createrName;
            }

            public void setCreaterName(String createrName) {
                this.createrName = createrName;
            }

            public String getCreatedTime() {
                return createdTime;
            }

            public void setCreatedTime(String createdTime) {
                this.createdTime = createdTime;
            }

            public String getModifierId() {
                return modifierId;
            }

            public void setModifierId(String modifierId) {
                this.modifierId = modifierId;
            }

            public String getModifierName() {
                return modifierName;
            }

            public void setModifierName(String modifierName) {
                this.modifierName = modifierName;
            }

            public String getModifiedTime() {
                return modifiedTime;
            }

            public void setModifiedTime(String modifiedTime) {
                this.modifiedTime = modifiedTime;
            }

            public String getPid() {
                return pid;
            }

            public void setPid(String pid) {
                this.pid = pid;
            }

            public String getDictionaryType() {
                return dictionaryType;
            }

            public void setDictionaryType(String dictionaryType) {
                this.dictionaryType = dictionaryType;
            }

            public String getDictionaryName() {
                return dictionaryName;
            }

            public void setDictionaryName(String dictionaryName) {
                this.dictionaryName = dictionaryName;
            }

            public String getSysDataState() {
                return sysDataState;
            }

            public void setSysDataState(String sysDataState) {
                this.sysDataState = sysDataState;
            }

            public int getCostData() {
                return costData;
            }

            public void setCostData(int costData) {
                this.costData = costData;
            }

            public Object getSimpleCode() {
                return SimpleCode;
            }

            public void setSimpleCode(Object SimpleCode) {
                this.SimpleCode = SimpleCode;
            }
        }
    }
}
