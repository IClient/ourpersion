package com.example.administrator.OurPersion.Model.Bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/9/5 0005.
 */

/**
 * 根据床位获取对应入住老人信息
 */

public class BedOldMan implements Serializable {

    /**
     * NursingPlan : null
     * TastePreference : {"id":"0444355d-83f8-4a73-8600-22c01f1762b2","mark":"0","remark":null,"createrId":"eef70e20-c0a3-44ee-bbb9-5e671b21bdd7","createrName":"超级管理员","createdTime":"2017-08-08T11:26:13.687","modifierId":"eef70e20-c0a3-44ee-bbb9-5e671b21bdd7","modifierName":"超级管理员","modifiedTime":"2017-08-08T11:26:13.687","pid":"35dcff87-0602-42ac-bad3-a29b0afa59d4","dictionaryType":"口味偏好","dictionaryName":"软","sysDataState":"1","costData":0,"SimpleCode":null}
     * Nursingtemplet : {"NursingBaseName":null,"Id":"84332177-bfbe-419f-b306-139d51291c06","CycleName":"7天模板","BaseNameId":"355d98e9-d848-450d-bbd2-7b424581a99b","CycleLength":7,"Mark":"0","CreaterId":"d32e87c0-38ba-415f-8bd4-769eaeff9bb7","CreaterName":"admin","CreatedTime":"2017-09-02T11:27:15.6","ModifierId":"d32e87c0-38ba-415f-8bd4-769eaeff9bb7","ModifierName":"admin","ModifiedTime":"2017-09-02T11:27:15.6","Remark":null}
     * NursingGrade : {"Id":"de454b71-9bc3-4e4a-bcc3-914a72fdb068","LevelName":"护理二级","LevelCost":333,"Mark":"0","CreaterId":"158936b5-5c6f-491a-84a4-b964d0e9b76e","CreaterName":"超级管理员","CreatedTime":"2017-08-11T09:37:40.36","ModifierId":"158936b5-5c6f-491a-84a4-b964d0e9b76e","ModifierName":"超级管理员","ModifiedTime":"2017-08-11T09:37:40.36","Remark":null}
     * RecureType : {"ID":"279e74e8-184b-4a74-9cf9-8290fdeb65dd","RecureItem":"一级康复","State":"0","CreaterId":"59b4f4aa-5ef2-4cdd-9bb0-597e06fddc3e","CreaterName":"超级管理员","CreatedTime":"2017-08-28T16:45:52.717","ModifierId":"59b4f4aa-5ef2-4cdd-9bb0-597e06fddc3e","ModifierName":"超级管理员","ModifiedTime":"2017-08-28T16:45:54.35","Remark":"一级康复项目"}
     * Bed : null
     * Id : 9a807da7-61f9-4dd7-abaf-afe9ec7f9ed2
     * CreaterId : 918f02ea-9deb-4e00-b33c-dd51e57b6a2d
     * CreaterTime : 2017-09-04T17:16:32.553
     * CreaterName : 王福龙
     * ModifiedId : 4e3b6f6d-6c15-4905-9424-bd8ac30af636
     * ModifiedName : 王福龙
     * ModifiedTime : 2017-09-04T17:17:46.23
     * Mark : 0
     * CheckinTime : 2017-09-04
     * Status : 2
     * BedId : c8ce9015-c42b-4573-aa5f-dc5d75213da2
     * Deposit : 80000
     * PaymentMonth : 0月25天
     * Money : 3332
     * ExpireTime : 2017-09-28
     * OldId : 7579b0c3-c239-4fbb-92f3-54eb4eaae5b8
     * old : {"EducationDegree":null,"IDType":null,"PersonalCompositionStr":null,"PoliticalStatusStr":null,"MaritalStatusStr":null,"ReligiousBeliefStr":null,"Id":"7579b0c3-c239-4fbb-92f3-54eb4eaae5b8","CustomerName":"李四","CertificateNumber":"45654654654","Sex":"0","Birthday":null,"Nationality":null,"PhoneNumber":"1336536896","Address":null,"Status":"1","CreateId":"918f02ea-9deb-4e00-b33c-dd51e57b6a2d","CreaterName":"王福龙","CreaterTime":"2017-09-04T17:16:32.553","ModifiedId":"918f02ea-9deb-4e00-b33c-dd51e57b6a2d","ModifiedName":"王福龙","ModifiedTime":"2017-09-04T17:16:32.553","Remark":null,"ImgPath":null,"ImgRealName":null,"SourceId":"00000000-0000-0000-0000-000000000000","Mark":"0","PoliticalStatusId":"00000000-0000-0000-0000-000000000000","MaritalStatus":"0d04d8d9-933d-41d7-9a17-01970f717f3d","RetirementCareer":null,"Hobby":null,"ReligiousBeliefId":"00000000-0000-0000-0000-000000000000","WorkAbility":null,"FamilyPopulation":0,"EconomicSource":null,"EducationDegreeId":"00000000-0000-0000-0000-000000000000","CheckinTime":null,"DocumentType":"72852799-68e8-427e-b790-3da0e3924753","PersonalComposition":"00000000-0000-0000-0000-000000000000","BloodType":null}
     * DictionaryId : 0444355d-83f8-4a73-8600-22c01f1762b2
     * NursingtempletId : 84332177-bfbe-419f-b306-139d51291c06
     * NursingGradeId : de454b71-9bc3-4e4a-bcc3-914a72fdb068
     * RecureTypeId : 279e74e8-184b-4a74-9cf9-8290fdeb65dd
     * PositionName : 亲睦家学苑养老>一单元>5楼>105>105
     * FoodProhibited : null
     * CheckCode : 20170904003
     * RelationCardNumber : null
     */

    private Object NursingPlan;
    private TastePreferenceBean TastePreference;
    private NursingtempletBean Nursingtemplet;
    private NursingGradeBean NursingGrade;
    private RecureTypeBean RecureType;
    private Object Bed;
    private String Id;
    private String CreaterId;
    private String CreaterTime;
    private String CreaterName;
    private String ModifiedId;
    private String ModifiedName;
    private String ModifiedTime;
    private String Mark;
    private String CheckinTime;
    private String Status;
    private String BedId;
    private int Deposit;
    private String PaymentMonth;
    private int Money;
    private String ExpireTime;
    private String OldId;
    private OldBean old;
    private String DictionaryId;
    private String NursingtempletId;
    private String NursingGradeId;
    private String RecureTypeId;
    private String PositionName;
    private Object FoodProhibited;
    private String CheckCode;
    private Object RelationCardNumber;

    public Object getNursingPlan() {
        return NursingPlan;
    }

    public void setNursingPlan(Object NursingPlan) {
        this.NursingPlan = NursingPlan;
    }

    public TastePreferenceBean getTastePreference() {
        return TastePreference;
    }

    public void setTastePreference(TastePreferenceBean TastePreference) {
        this.TastePreference = TastePreference;
    }

    public NursingtempletBean getNursingtemplet() {
        return Nursingtemplet;
    }

    public void setNursingtemplet(NursingtempletBean Nursingtemplet) {
        this.Nursingtemplet = Nursingtemplet;
    }

    public NursingGradeBean getNursingGrade() {
        return NursingGrade;
    }

    public void setNursingGrade(NursingGradeBean NursingGrade) {
        this.NursingGrade = NursingGrade;
    }

    public RecureTypeBean getRecureType() {
        return RecureType;
    }

    public void setRecureType(RecureTypeBean RecureType) {
        this.RecureType = RecureType;
    }

    public Object getBed() {
        return Bed;
    }

    public void setBed(Object Bed) {
        this.Bed = Bed;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
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

    public String getCheckinTime() {
        return CheckinTime;
    }

    public void setCheckinTime(String CheckinTime) {
        this.CheckinTime = CheckinTime;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getBedId() {
        return BedId;
    }

    public void setBedId(String BedId) {
        this.BedId = BedId;
    }

    public int getDeposit() {
        return Deposit;
    }

    public void setDeposit(int Deposit) {
        this.Deposit = Deposit;
    }

    public String getPaymentMonth() {
        return PaymentMonth;
    }

    public void setPaymentMonth(String PaymentMonth) {
        this.PaymentMonth = PaymentMonth;
    }

    public int getMoney() {
        return Money;
    }

    public void setMoney(int Money) {
        this.Money = Money;
    }

    public String getExpireTime() {
        return ExpireTime;
    }

    public void setExpireTime(String ExpireTime) {
        this.ExpireTime = ExpireTime;
    }

    public String getOldId() {
        return OldId;
    }

    public void setOldId(String OldId) {
        this.OldId = OldId;
    }

    public OldBean getOld() {
        return old;
    }

    public void setOld(OldBean old) {
        this.old = old;
    }

    public String getDictionaryId() {
        return DictionaryId;
    }

    public void setDictionaryId(String DictionaryId) {
        this.DictionaryId = DictionaryId;
    }

    public String getNursingtempletId() {
        return NursingtempletId;
    }

    public void setNursingtempletId(String NursingtempletId) {
        this.NursingtempletId = NursingtempletId;
    }

    public String getNursingGradeId() {
        return NursingGradeId;
    }

    public void setNursingGradeId(String NursingGradeId) {
        this.NursingGradeId = NursingGradeId;
    }

    public String getRecureTypeId() {
        return RecureTypeId;
    }

    public void setRecureTypeId(String RecureTypeId) {
        this.RecureTypeId = RecureTypeId;
    }

    public String getPositionName() {
        return PositionName;
    }

    public void setPositionName(String PositionName) {
        this.PositionName = PositionName;
    }

    public Object getFoodProhibited() {
        return FoodProhibited;
    }

    public void setFoodProhibited(Object FoodProhibited) {
        this.FoodProhibited = FoodProhibited;
    }

    public String getCheckCode() {
        return CheckCode;
    }

    public void setCheckCode(String CheckCode) {
        this.CheckCode = CheckCode;
    }

    public Object getRelationCardNumber() {
        return RelationCardNumber;
    }

    public void setRelationCardNumber(Object RelationCardNumber) {
        this.RelationCardNumber = RelationCardNumber;
    }

    public static class TastePreferenceBean implements Serializable {
        /**
         * id : 0444355d-83f8-4a73-8600-22c01f1762b2
         * mark : 0
         * remark : null
         * createrId : eef70e20-c0a3-44ee-bbb9-5e671b21bdd7
         * createrName : 超级管理员
         * createdTime : 2017-08-08T11:26:13.687
         * modifierId : eef70e20-c0a3-44ee-bbb9-5e671b21bdd7
         * modifierName : 超级管理员
         * modifiedTime : 2017-08-08T11:26:13.687
         * pid : 35dcff87-0602-42ac-bad3-a29b0afa59d4
         * dictionaryType : 口味偏好
         * dictionaryName : 软
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

    public static class NursingtempletBean implements Serializable {
        /**
         * NursingBaseName : null
         * Id : 84332177-bfbe-419f-b306-139d51291c06
         * CycleName : 7天模板
         * BaseNameId : 355d98e9-d848-450d-bbd2-7b424581a99b
         * CycleLength : 7
         * Mark : 0
         * CreaterId : d32e87c0-38ba-415f-8bd4-769eaeff9bb7
         * CreaterName : admin
         * CreatedTime : 2017-09-02T11:27:15.6
         * ModifierId : d32e87c0-38ba-415f-8bd4-769eaeff9bb7
         * ModifierName : admin
         * ModifiedTime : 2017-09-02T11:27:15.6
         * Remark : null
         */

        private Object NursingBaseName;
        private String Id;
        private String CycleName;
        private String BaseNameId;
        private int CycleLength;
        private String Mark;
        private String CreaterId;
        private String CreaterName;
        private String CreatedTime;
        private String ModifierId;
        private String ModifierName;
        private String ModifiedTime;
        private Object Remark;

        public Object getNursingBaseName() {
            return NursingBaseName;
        }

        public void setNursingBaseName(Object NursingBaseName) {
            this.NursingBaseName = NursingBaseName;
        }

        public String getId() {
            return Id;
        }

        public void setId(String Id) {
            this.Id = Id;
        }

        public String getCycleName() {
            return CycleName;
        }

        public void setCycleName(String CycleName) {
            this.CycleName = CycleName;
        }

        public String getBaseNameId() {
            return BaseNameId;
        }

        public void setBaseNameId(String BaseNameId) {
            this.BaseNameId = BaseNameId;
        }

        public int getCycleLength() {
            return CycleLength;
        }

        public void setCycleLength(int CycleLength) {
            this.CycleLength = CycleLength;
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

    public static class NursingGradeBean implements Serializable {
        /**
         * Id : de454b71-9bc3-4e4a-bcc3-914a72fdb068
         * LevelName : 护理二级
         * LevelCost : 333
         * Mark : 0
         * CreaterId : 158936b5-5c6f-491a-84a4-b964d0e9b76e
         * CreaterName : 超级管理员
         * CreatedTime : 2017-08-11T09:37:40.36
         * ModifierId : 158936b5-5c6f-491a-84a4-b964d0e9b76e
         * ModifierName : 超级管理员
         * ModifiedTime : 2017-08-11T09:37:40.36
         * Remark : null
         */

        private String Id;
        private String LevelName;
        private int LevelCost;
        private String Mark;
        private String CreaterId;
        private String CreaterName;
        private String CreatedTime;
        private String ModifierId;
        private String ModifierName;
        private String ModifiedTime;
        private Object Remark;

        public String getId() {
            return Id;
        }

        public void setId(String Id) {
            this.Id = Id;
        }

        public String getLevelName() {
            return LevelName;
        }

        public void setLevelName(String LevelName) {
            this.LevelName = LevelName;
        }

        public int getLevelCost() {
            return LevelCost;
        }

        public void setLevelCost(int LevelCost) {
            this.LevelCost = LevelCost;
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

    public static class RecureTypeBean implements Serializable {
        /**
         * ID : 279e74e8-184b-4a74-9cf9-8290fdeb65dd
         * RecureItem : 一级康复
         * State : 0
         * CreaterId : 59b4f4aa-5ef2-4cdd-9bb0-597e06fddc3e
         * CreaterName : 超级管理员
         * CreatedTime : 2017-08-28T16:45:52.717
         * ModifierId : 59b4f4aa-5ef2-4cdd-9bb0-597e06fddc3e
         * ModifierName : 超级管理员
         * ModifiedTime : 2017-08-28T16:45:54.35
         * Remark : 一级康复项目
         */

        private String ID;
        private String RecureItem;
        private String State;
        private String CreaterId;
        private String CreaterName;
        private String CreatedTime;
        private String ModifierId;
        private String ModifierName;
        private String ModifiedTime;
        private String Remark;

        public String getID() {
            return ID;
        }

        public void setID(String ID) {
            this.ID = ID;
        }

        public String getRecureItem() {
            return RecureItem;
        }

        public void setRecureItem(String RecureItem) {
            this.RecureItem = RecureItem;
        }

        public String getState() {
            return State;
        }

        public void setState(String State) {
            this.State = State;
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

        public String getRemark() {
            return Remark;
        }

        public void setRemark(String Remark) {
            this.Remark = Remark;
        }
    }

    public static class OldBean implements Serializable {
        /**
         * EducationDegree : null
         * IDType : null
         * PersonalCompositionStr : null
         * PoliticalStatusStr : null
         * MaritalStatusStr : null
         * ReligiousBeliefStr : null
         * Id : 7579b0c3-c239-4fbb-92f3-54eb4eaae5b8
         * CustomerName : 李四
         * CertificateNumber : 45654654654
         * Sex : 0
         * Birthday : null
         * Nationality : null
         * PhoneNumber : 1336536896
         * Address : null
         * Status : 1
         * CreateId : 918f02ea-9deb-4e00-b33c-dd51e57b6a2d
         * CreaterName : 王福龙
         * CreaterTime : 2017-09-04T17:16:32.553
         * ModifiedId : 918f02ea-9deb-4e00-b33c-dd51e57b6a2d
         * ModifiedName : 王福龙
         * ModifiedTime : 2017-09-04T17:16:32.553
         * Remark : null
         * ImgPath : null
         * ImgRealName : null
         * SourceId : 00000000-0000-0000-0000-000000000000
         * Mark : 0
         * PoliticalStatusId : 00000000-0000-0000-0000-000000000000
         * MaritalStatus : 0d04d8d9-933d-41d7-9a17-01970f717f3d
         * RetirementCareer : null
         * Hobby : null
         * ReligiousBeliefId : 00000000-0000-0000-0000-000000000000
         * WorkAbility : null
         * FamilyPopulation : 0
         * EconomicSource : null
         * EducationDegreeId : 00000000-0000-0000-0000-000000000000
         * CheckinTime : null
         * DocumentType : 72852799-68e8-427e-b790-3da0e3924753
         * PersonalComposition : 00000000-0000-0000-0000-000000000000
         * BloodType : null
         */

        private Object EducationDegree;
        private Object IDType;
        private Object PersonalCompositionStr;
        private Object PoliticalStatusStr;
        private Object MaritalStatusStr;
        private Object ReligiousBeliefStr;
        private String Id;
        private String CustomerName;
        private String CertificateNumber;
        private String Sex;
        private Object Birthday;
        private Object Nationality;
        private String PhoneNumber;
        private Object Address;
        private String Status;
        private String CreateId;
        private String CreaterName;
        private String CreaterTime;
        private String ModifiedId;
        private String ModifiedName;
        private String ModifiedTime;
        private Object Remark;
        private Object ImgPath;
        private Object ImgRealName;
        private String SourceId;
        private String Mark;
        private String PoliticalStatusId;
        private String MaritalStatus;
        private Object RetirementCareer;
        private Object Hobby;
        private String ReligiousBeliefId;
        private Object WorkAbility;
        private int FamilyPopulation;
        private Object EconomicSource;
        private String EducationDegreeId;
        private Object CheckinTime;
        private String DocumentType;
        private String PersonalComposition;
        private Object BloodType;

        public Object getEducationDegree() {
            return EducationDegree;
        }

        public void setEducationDegree(Object EducationDegree) {
            this.EducationDegree = EducationDegree;
        }

        public Object getIDType() {
            return IDType;
        }

        public void setIDType(Object IDType) {
            this.IDType = IDType;
        }

        public Object getPersonalCompositionStr() {
            return PersonalCompositionStr;
        }

        public void setPersonalCompositionStr(Object PersonalCompositionStr) {
            this.PersonalCompositionStr = PersonalCompositionStr;
        }

        public Object getPoliticalStatusStr() {
            return PoliticalStatusStr;
        }

        public void setPoliticalStatusStr(Object PoliticalStatusStr) {
            this.PoliticalStatusStr = PoliticalStatusStr;
        }

        public Object getMaritalStatusStr() {
            return MaritalStatusStr;
        }

        public void setMaritalStatusStr(Object MaritalStatusStr) {
            this.MaritalStatusStr = MaritalStatusStr;
        }

        public Object getReligiousBeliefStr() {
            return ReligiousBeliefStr;
        }

        public void setReligiousBeliefStr(Object ReligiousBeliefStr) {
            this.ReligiousBeliefStr = ReligiousBeliefStr;
        }

        public String getId() {
            return Id;
        }

        public void setId(String Id) {
            this.Id = Id;
        }

        public String getCustomerName() {
            return CustomerName;
        }

        public void setCustomerName(String CustomerName) {
            this.CustomerName = CustomerName;
        }

        public String getCertificateNumber() {
            return CertificateNumber;
        }

        public void setCertificateNumber(String CertificateNumber) {
            this.CertificateNumber = CertificateNumber;
        }

        public String getSex() {
            return Sex;
        }

        public void setSex(String Sex) {
            this.Sex = Sex;
        }

        public Object getBirthday() {
            return Birthday;
        }

        public void setBirthday(Object Birthday) {
            this.Birthday = Birthday;
        }

        public Object getNationality() {
            return Nationality;
        }

        public void setNationality(Object Nationality) {
            this.Nationality = Nationality;
        }

        public String getPhoneNumber() {
            return PhoneNumber;
        }

        public void setPhoneNumber(String PhoneNumber) {
            this.PhoneNumber = PhoneNumber;
        }

        public Object getAddress() {
            return Address;
        }

        public void setAddress(Object Address) {
            this.Address = Address;
        }

        public String getStatus() {
            return Status;
        }

        public void setStatus(String Status) {
            this.Status = Status;
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

        public Object getRemark() {
            return Remark;
        }

        public void setRemark(Object Remark) {
            this.Remark = Remark;
        }

        public Object getImgPath() {
            return ImgPath;
        }

        public void setImgPath(Object ImgPath) {
            this.ImgPath = ImgPath;
        }

        public Object getImgRealName() {
            return ImgRealName;
        }

        public void setImgRealName(Object ImgRealName) {
            this.ImgRealName = ImgRealName;
        }

        public String getSourceId() {
            return SourceId;
        }

        public void setSourceId(String SourceId) {
            this.SourceId = SourceId;
        }

        public String getMark() {
            return Mark;
        }

        public void setMark(String Mark) {
            this.Mark = Mark;
        }

        public String getPoliticalStatusId() {
            return PoliticalStatusId;
        }

        public void setPoliticalStatusId(String PoliticalStatusId) {
            this.PoliticalStatusId = PoliticalStatusId;
        }

        public String getMaritalStatus() {
            return MaritalStatus;
        }

        public void setMaritalStatus(String MaritalStatus) {
            this.MaritalStatus = MaritalStatus;
        }

        public Object getRetirementCareer() {
            return RetirementCareer;
        }

        public void setRetirementCareer(Object RetirementCareer) {
            this.RetirementCareer = RetirementCareer;
        }

        public Object getHobby() {
            return Hobby;
        }

        public void setHobby(Object Hobby) {
            this.Hobby = Hobby;
        }

        public String getReligiousBeliefId() {
            return ReligiousBeliefId;
        }

        public void setReligiousBeliefId(String ReligiousBeliefId) {
            this.ReligiousBeliefId = ReligiousBeliefId;
        }

        public Object getWorkAbility() {
            return WorkAbility;
        }

        public void setWorkAbility(Object WorkAbility) {
            this.WorkAbility = WorkAbility;
        }

        public int getFamilyPopulation() {
            return FamilyPopulation;
        }

        public void setFamilyPopulation(int FamilyPopulation) {
            this.FamilyPopulation = FamilyPopulation;
        }

        public Object getEconomicSource() {
            return EconomicSource;
        }

        public void setEconomicSource(Object EconomicSource) {
            this.EconomicSource = EconomicSource;
        }

        public String getEducationDegreeId() {
            return EducationDegreeId;
        }

        public void setEducationDegreeId(String EducationDegreeId) {
            this.EducationDegreeId = EducationDegreeId;
        }

        public Object getCheckinTime() {
            return CheckinTime;
        }

        public void setCheckinTime(Object CheckinTime) {
            this.CheckinTime = CheckinTime;
        }

        public String getDocumentType() {
            return DocumentType;
        }

        public void setDocumentType(String DocumentType) {
            this.DocumentType = DocumentType;
        }

        public String getPersonalComposition() {
            return PersonalComposition;
        }

        public void setPersonalComposition(String PersonalComposition) {
            this.PersonalComposition = PersonalComposition;
        }

        public Object getBloodType() {
            return BloodType;
        }

        public void setBloodType(Object BloodType) {
            this.BloodType = BloodType;
        }
    }
}
