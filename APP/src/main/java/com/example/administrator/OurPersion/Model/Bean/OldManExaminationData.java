package com.example.administrator.OurPersion.Model.Bean;

import java.util.List;

/**
 * Created by Administrator on 2017/9/27 0027.
 */

public class OldManExaminationData {


    private List<OldManExaminationDataBean> OldManExaminationData;

    public List<OldManExaminationDataBean> getOldManExaminationData() {
        return OldManExaminationData;
    }

    public void setOldManExaminationData(List<OldManExaminationDataBean> OldManExaminationData) {
        this.OldManExaminationData = OldManExaminationData;
    }

    public static class OldManExaminationDataBean {
        /**
         * TastePreference : {"id":"0444355d-83f8-4a73-8600-22c01f1762b2","mark":"0","remark":null,"createrId":"eef70e20-c0a3-44ee-bbb9-5e671b21bdd7","createrName":"超级管理员","createdTime":"2017-08-08T11:26:13.687","modifierId":"eef70e20-c0a3-44ee-bbb9-5e671b21bdd7","modifierName":"超级管理员","modifiedTime":"2017-08-08T11:26:13.687","pid":"35dcff87-0602-42ac-bad3-a29b0afa59d4","dictionaryType":"口味偏好","dictionaryName":"软","sysDataState":"1","costData":0,"SimpleCode":null}
         * BathTypes : {"id":"afec004e-daa0-4a60-bfb1-17eba8ecc2a2","mark":"0","remark":"坐着由护工帮忙洗的","createrId":"eef70e20-c0a3-44ee-bbb9-5e671b21bdd7","createrName":"admin","createdTime":"2017-09-26T11:01:46.193","modifierId":"eef70e20-c0a3-44ee-bbb9-5e671b21bdd7","modifierName":"admin","modifiedTime":"2017-09-26T11:01:46.193","pid":"d29da308-71fd-4ec8-9e9a-0196d81d918f","dictionaryType":"入浴种类","dictionaryName":"座","sysDataState":"1","costData":0,"SimpleCode":null}
         * Id : 988492cf-5e76-449b-b0ec-f6be494503de
         * TestUserId : 00000000-0000-0000-0000-000000000000
         * TestUserName : 234
         * TestTime : 2017-09-27T14:58:35
         * DiastolicPressure : 145
         * SystolicPressure : 45
         * Pulse : 69
         * Temperature : 37.0
         * Breathing : 45
         * MeasuresAndEffect : null
         * CreateId : eef70e20-c0a3-44ee-bbb9-5e671b21bdd7
         * CreaterName : admin
         * CreaterTime : 2017-09-27T14:59:23.197
         * ModifiedId : eef70e20-c0a3-44ee-bbb9-5e671b21bdd7
         * ModifiedName : admin
         * ModifiedTime : 2017-09-27T14:59:23.197
         * IsDelete : false
         * Remark : null
         * OldPersonName : 张三峰
         * OldPersonId : dfbffcbd-b22c-44b4-b0cb-3303390a5227
         * HeartRate : 45
         * Weight : 45.0
         * MainFoodIntake : 4
         * FoodIntake : 5
         * DefecationVolume : 4.0
         * DefecationFrequency : 45
         * UrinaryOutput : 5.0
         * MicturitionTimes : 5
         * BathType : afec004e-daa0-4a60-bfb1-17eba8ecc2a2
         * BathReason : null
         * DietaryPreferenceId : 0444355d-83f8-4a73-8600-22c01f1762b2
         */

        private TastePreferenceBean TastePreference;
        private BathTypesBean BathTypes;
        private String Id;
        private String TestUserId;
        private String TestUserName;
        private String TestTime;
        private int DiastolicPressure;
        private int SystolicPressure;
        private int Pulse;
        private float Temperature;
        private int Breathing;
        private Object MeasuresAndEffect;
        private String CreateId;
        private String CreaterName;
        private String CreaterTime;
        private String ModifiedId;
        private String ModifiedName;
        private String ModifiedTime;
        private boolean IsDelete;
        private Object Remark;
        private String OldPersonName;
        private String OldPersonId;
        private int HeartRate;
        private float Weight;
        private int MainFoodIntake;
        private int FoodIntake;
        private float DefecationVolume;
        private int DefecationFrequency;
        private float UrinaryOutput;
        private int MicturitionTimes;
        private String BathType;
        private Object BathReason;
        private String DietaryPreferenceId;

        public TastePreferenceBean getTastePreference() {
            return TastePreference;
        }

        public void setTastePreference(TastePreferenceBean TastePreference) {
            this.TastePreference = TastePreference;
        }

        public BathTypesBean getBathTypes() {
            return BathTypes;
        }

        public void setBathTypes(BathTypesBean BathTypes) {
            this.BathTypes = BathTypes;
        }

        public String getId() {
            return Id;
        }

        public void setId(String Id) {
            this.Id = Id;
        }

        public String getTestUserId() {
            return TestUserId;
        }

        public void setTestUserId(String TestUserId) {
            this.TestUserId = TestUserId;
        }

        public String getTestUserName() {
            return TestUserName;
        }

        public void setTestUserName(String TestUserName) {
            this.TestUserName = TestUserName;
        }

        public String getTestTime() {
            return TestTime;
        }

        public void setTestTime(String TestTime) {
            this.TestTime = TestTime;
        }

        public int getDiastolicPressure() {
            return DiastolicPressure;
        }

        public void setDiastolicPressure(int DiastolicPressure) {
            this.DiastolicPressure = DiastolicPressure;
        }

        public int getSystolicPressure() {
            return SystolicPressure;
        }

        public void setSystolicPressure(int SystolicPressure) {
            this.SystolicPressure = SystolicPressure;
        }

        public int getPulse() {
            return Pulse;
        }

        public void setPulse(int Pulse) {
            this.Pulse = Pulse;
        }

        public float getTemperature() {
            return Temperature;
        }

        public void setTemperature(float Temperature) {
            this.Temperature = Temperature;
        }

        public int getBreathing() {
            return Breathing;
        }

        public void setBreathing(int Breathing) {
            this.Breathing = Breathing;
        }

        public Object getMeasuresAndEffect() {
            return MeasuresAndEffect;
        }

        public void setMeasuresAndEffect(Object MeasuresAndEffect) {
            this.MeasuresAndEffect = MeasuresAndEffect;
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

        public String getOldPersonId() {
            return OldPersonId;
        }

        public void setOldPersonId(String OldPersonId) {
            this.OldPersonId = OldPersonId;
        }

        public int getHeartRate() {
            return HeartRate;
        }

        public void setHeartRate(int HeartRate) {
            this.HeartRate = HeartRate;
        }

        public float getWeight() {
            return Weight;
        }

        public void setWeight(float Weight) {
            this.Weight = Weight;
        }

        public int getMainFoodIntake() {
            return MainFoodIntake;
        }

        public void setMainFoodIntake(int MainFoodIntake) {
            this.MainFoodIntake = MainFoodIntake;
        }

        public int getFoodIntake() {
            return FoodIntake;
        }

        public void setFoodIntake(int FoodIntake) {
            this.FoodIntake = FoodIntake;
        }

        public float getDefecationVolume() {
            return DefecationVolume;
        }

        public void setDefecationVolume(float DefecationVolume) {
            this.DefecationVolume = DefecationVolume;
        }

        public int getDefecationFrequency() {
            return DefecationFrequency;
        }

        public void setDefecationFrequency(int DefecationFrequency) {
            this.DefecationFrequency = DefecationFrequency;
        }

        public float getUrinaryOutput() {
            return UrinaryOutput;
        }

        public void setUrinaryOutput(float UrinaryOutput) {
            this.UrinaryOutput = UrinaryOutput;
        }

        public int getMicturitionTimes() {
            return MicturitionTimes;
        }

        public void setMicturitionTimes(int MicturitionTimes) {
            this.MicturitionTimes = MicturitionTimes;
        }

        public String getBathType() {
            return BathType;
        }

        public void setBathType(String BathType) {
            this.BathType = BathType;
        }

        public Object getBathReason() {
            return BathReason;
        }

        public void setBathReason(Object BathReason) {
            this.BathReason = BathReason;
        }

        public String getDietaryPreferenceId() {
            return DietaryPreferenceId;
        }

        public void setDietaryPreferenceId(String DietaryPreferenceId) {
            this.DietaryPreferenceId = DietaryPreferenceId;
        }

        public static class TastePreferenceBean {
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
             * costData : 0.0
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
            private double costData;
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

            public double getCostData() {
                return costData;
            }

            public void setCostData(double costData) {
                this.costData = costData;
            }

            public Object getSimpleCode() {
                return SimpleCode;
            }

            public void setSimpleCode(Object SimpleCode) {
                this.SimpleCode = SimpleCode;
            }
        }

        public static class BathTypesBean {
            /**
             * id : afec004e-daa0-4a60-bfb1-17eba8ecc2a2
             * mark : 0
             * remark : 坐着由护工帮忙洗的
             * createrId : eef70e20-c0a3-44ee-bbb9-5e671b21bdd7
             * createrName : admin
             * createdTime : 2017-09-26T11:01:46.193
             * modifierId : eef70e20-c0a3-44ee-bbb9-5e671b21bdd7
             * modifierName : admin
             * modifiedTime : 2017-09-26T11:01:46.193
             * pid : d29da308-71fd-4ec8-9e9a-0196d81d918f
             * dictionaryType : 入浴种类
             * dictionaryName : 座
             * sysDataState : 1
             * costData : 0.0
             * SimpleCode : null
             */

            private String id;
            private String mark;
            private String remark;
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
            private double costData;
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

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
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

            public double getCostData() {
                return costData;
            }

            public void setCostData(double costData) {
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
