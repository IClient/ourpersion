package com.example.administrator.OurPersion.Model.Bean;

/**
 * Created by Administrator on 2017/9/7 0007.
 */


import java.util.List;

/**
 * 用户对应的老人的护理计划，isend__0表示默认完成,1表示新增完成，2表示修改，3表示取消但数据存在,ischange__0表示没改变,1表示改变
 */
public class OldManPlan {


    private List<OldManPlanBean> OldManPlan;

    public List<OldManPlanBean> getOldManPlan() {
        return OldManPlan;
    }

    public void setOldManPlan(List<OldManPlanBean> OldManPlan) {
        this.OldManPlan = OldManPlan;
    }

    public static class OldManPlanBean {
        /**
         * NursingPlans : [{"TimeSign":"93a41623-b3c4-4134-a976-48b2ef180b1a","ItemName":"骨折","OldManId":"d0450110-8fbd-4bfb-9dd3-2cbde5f7c008","InLiveId":"2339d403-90b7-46a6-8e2a-ad6cb2d56609","BeginTime":"2017-09-07 00:00:00","EndTime":"2017-09-07 04:00:00","IsChange":"4","IsEnd":"0","NursingItemId":"aaca6652-eb85-4bbb-a638-03676c3c3e6c","SubItemId":null,"SubIdAndVal":[{"SubItemId":"00000000-0000-0000-0000-000000000000","SubVal":null}],"Remark":""},{"TimeSign":"79d66024-ccac-4083-a61c-07fd32e39f20","ItemName":"血压","OldManId":"d0450110-8fbd-4bfb-9dd3-2cbde5f7c008","InLiveId":"2339d403-90b7-46a6-8e2a-ad6cb2d56609","BeginTime":"2017-09-07 04:00:00","EndTime":"2017-09-07 06:00:00","IsChange":"4","IsEnd":"0","NursingItemId":"98d6343c-9802-4869-a1f7-5ff0787fb9a2","SubItemId":null,"SubIdAndVal":[{"SubItemId":"00000000-0000-0000-0000-000000000000","SubVal":null}],"Remark":""},{"TimeSign":"a2496288-6b63-4f89-bfa0-b7c37235fc0f","ItemName":"针灸","OldManId":"d0450110-8fbd-4bfb-9dd3-2cbde5f7c008","InLiveId":"2339d403-90b7-46a6-8e2a-ad6cb2d56609","BeginTime":"2017-09-07 06:00:00","EndTime":"2017-09-07 08:00:00","IsChange":"4","IsEnd":"0","NursingItemId":"8fed7a9e-d17f-4554-b5a7-63c8035f76ac","SubItemId":null,"SubIdAndVal":[{"SubItemId":"00000000-0000-0000-0000-000000000000","SubVal":null}],"Remark":""},{"TimeSign":"8a0a512b-e118-4eb5-9453-9a02e85a8634","ItemName":"入厕","OldManId":"d0450110-8fbd-4bfb-9dd3-2cbde5f7c008","InLiveId":"2339d403-90b7-46a6-8e2a-ad6cb2d56609","BeginTime":"2017-09-07 08:00:00","EndTime":"2017-09-07 10:00:00","IsChange":"4","IsEnd":"0","NursingItemId":"a1dec328-762d-4cde-9c3b-69a45622e429","SubItemId":null,"SubIdAndVal":[{"SubItemId":"00000000-0000-0000-0000-000000000000","SubVal":null}],"Remark":""},{"TimeSign":"ea6cbc35-1cd9-4995-90f7-2bae4a6fbeb6","ItemName":"血糖","OldManId":"d0450110-8fbd-4bfb-9dd3-2cbde5f7c008","InLiveId":"2339d403-90b7-46a6-8e2a-ad6cb2d56609","BeginTime":"2017-09-07 10:00:00","EndTime":"2017-09-07 12:00:00","IsChange":"4","IsEnd":"0","NursingItemId":"59326828-f7b3-4fd6-878c-8d321a7bea28","SubItemId":null,"SubIdAndVal":[{"SubItemId":"00000000-0000-0000-0000-000000000000","SubVal":null}],"Remark":""},{"TimeSign":"ea6cbc35-1cd9-4995-90f7-2bae4a6fbeb6","ItemName":"康复","OldManId":"d0450110-8fbd-4bfb-9dd3-2cbde5f7c008","InLiveId":"2339d403-90b7-46a6-8e2a-ad6cb2d56609","BeginTime":"2017-09-07 10:00:00","EndTime":"2017-09-07 12:00:00","IsChange":"5","IsEnd":"1","NursingItemId":"9bc71951-ef2b-4506-aadd-e9b3bcb375c9","SubItemId":null,"SubIdAndVal":[{"SubItemId":"00000000-0000-0000-0000-000000000000","SubVal":""}],"Remark":""},{"TimeSign":"05df6a4a-0559-4db7-b2e6-2ffccbc5cd14","ItemName":"补水","OldManId":"d0450110-8fbd-4bfb-9dd3-2cbde5f7c008","InLiveId":"2339d403-90b7-46a6-8e2a-ad6cb2d56609","BeginTime":"2017-09-07 12:00:00","EndTime":"2017-09-07 14:00:00","IsChange":"4","IsEnd":"0","NursingItemId":"7da71a22-d5e2-496d-a421-8db665a2e62d","SubItemId":null,"SubIdAndVal":[{"SubItemId":"00000000-0000-0000-0000-000000000000","SubVal":null}],"Remark":""},{"TimeSign":"ed11b561-4500-4a41-a647-afbdd9f2e894","ItemName":"骨折","OldManId":"d0450110-8fbd-4bfb-9dd3-2cbde5f7c008","InLiveId":"2339d403-90b7-46a6-8e2a-ad6cb2d56609","BeginTime":"2017-09-07 14:00:00","EndTime":"2017-09-07 16:00:00","IsChange":"4","IsEnd":"0","NursingItemId":"aaca6652-eb85-4bbb-a638-03676c3c3e6c","SubItemId":null,"SubIdAndVal":[{"SubItemId":"00000000-0000-0000-0000-000000000000","SubVal":null}],"Remark":""},{"TimeSign":"33d9840f-ee5e-4cca-9729-96f79158437c","ItemName":"骨折","OldManId":"d0450110-8fbd-4bfb-9dd3-2cbde5f7c008","InLiveId":"2339d403-90b7-46a6-8e2a-ad6cb2d56609","BeginTime":"2017-09-07 15:00:00","EndTime":"2017-09-07 15:30:00","IsChange":"4","IsEnd":"0","NursingItemId":"aaca6652-eb85-4bbb-a638-03676c3c3e6c","SubItemId":null,"SubIdAndVal":[{"SubItemId":"00000000-0000-0000-0000-000000000000","SubVal":null}],"Remark":""},{"TimeSign":"33d9840f-ee5e-4cca-9729-96f79158437c","ItemName":"血压","OldManId":"d0450110-8fbd-4bfb-9dd3-2cbde5f7c008","InLiveId":"2339d403-90b7-46a6-8e2a-ad6cb2d56609","BeginTime":"2017-09-07 15:00:00","EndTime":"2017-09-07 15:30:00","IsChange":"4","IsEnd":"0","NursingItemId":"98d6343c-9802-4869-a1f7-5ff0787fb9a2","SubItemId":null,"SubIdAndVal":[{"SubItemId":"00000000-0000-0000-0000-000000000000","SubVal":null}],"Remark":""},{"TimeSign":"33d9840f-ee5e-4cca-9729-96f79158437c","ItemName":"针灸","OldManId":"d0450110-8fbd-4bfb-9dd3-2cbde5f7c008","InLiveId":"2339d403-90b7-46a6-8e2a-ad6cb2d56609","BeginTime":"2017-09-07 15:00:00","EndTime":"2017-09-07 15:30:00","IsChange":"4","IsEnd":"0","NursingItemId":"8fed7a9e-d17f-4554-b5a7-63c8035f76ac","SubItemId":null,"SubIdAndVal":[{"SubItemId":"00000000-0000-0000-0000-000000000000","SubVal":null}],"Remark":""},{"TimeSign":"7819f02b-906d-4c87-916b-840a87b5c109","ItemName":"血压","OldManId":"d0450110-8fbd-4bfb-9dd3-2cbde5f7c008","InLiveId":"2339d403-90b7-46a6-8e2a-ad6cb2d56609","BeginTime":"2017-09-07 16:00:00","EndTime":"2017-09-07 18:00:00","IsChange":"4","IsEnd":"0","NursingItemId":"98d6343c-9802-4869-a1f7-5ff0787fb9a2","SubItemId":null,"SubIdAndVal":[{"SubItemId":"00000000-0000-0000-0000-000000000000","SubVal":null}],"Remark":""},{"TimeSign":"6a368754-c00f-4f64-a367-8dd0e83c6e9b","ItemName":"针灸","OldManId":"d0450110-8fbd-4bfb-9dd3-2cbde5f7c008","InLiveId":"2339d403-90b7-46a6-8e2a-ad6cb2d56609","BeginTime":"2017-09-07 18:00:00","EndTime":"2017-09-07 20:00:00","IsChange":"4","IsEnd":"0","NursingItemId":"8fed7a9e-d17f-4554-b5a7-63c8035f76ac","SubItemId":null,"SubIdAndVal":[{"SubItemId":"00000000-0000-0000-0000-000000000000","SubVal":null}],"Remark":""},{"TimeSign":"8983b3f6-f658-4dbd-9b86-050430ee8a96","ItemName":"入厕","OldManId":"d0450110-8fbd-4bfb-9dd3-2cbde5f7c008","InLiveId":"2339d403-90b7-46a6-8e2a-ad6cb2d56609","BeginTime":"2017-09-07 20:00:00","EndTime":"2017-09-07 22:00:00","IsChange":"4","IsEnd":"0","NursingItemId":"a1dec328-762d-4cde-9c3b-69a45622e429","SubItemId":null,"SubIdAndVal":[{"SubItemId":"00000000-0000-0000-0000-000000000000","SubVal":null}],"Remark":""},{"TimeSign":"08478328-ebfa-4e35-9258-53914479f935","ItemName":"血糖","OldManId":"d0450110-8fbd-4bfb-9dd3-2cbde5f7c008","InLiveId":"2339d403-90b7-46a6-8e2a-ad6cb2d56609","BeginTime":"2017-09-07 22:00:00","EndTime":"2017-09-07 00:00:00","IsChange":"4","IsEnd":"0","NursingItemId":"59326828-f7b3-4fd6-878c-8d321a7bea28","SubItemId":null,"SubIdAndVal":[{"SubItemId":"00000000-0000-0000-0000-000000000000","SubVal":null}],"Remark":""},{"TimeSign":"08478328-ebfa-4e35-9258-53914479f935","ItemName":"补水","OldManId":"d0450110-8fbd-4bfb-9dd3-2cbde5f7c008","InLiveId":"2339d403-90b7-46a6-8e2a-ad6cb2d56609","BeginTime":"2017-09-07 22:00:00","EndTime":"2017-09-07 00:00:00","IsChange":"4","IsEnd":"0","NursingItemId":"7da71a22-d5e2-496d-a421-8db665a2e62d","SubItemId":null,"SubIdAndVal":[{"SubItemId":"00000000-0000-0000-0000-000000000000","SubVal":null}],"Remark":""}]
         * CustomerName : 王五
         * ImgPath
         */

        private String CustomerName;

        private String ImgPath;

        public void setImgPath(String imgPath) {
            ImgPath = imgPath;
        }

        public String getImgPath() {

            return ImgPath;
        }
        private List<NursingPlansBean> NursingPlans;

        public String getCustomerName() {
            return CustomerName;
        }

        public void setCustomerName(String CustomerName) {
            this.CustomerName = CustomerName;
        }

        public List<NursingPlansBean> getNursingPlans() {
            return NursingPlans;
        }

        public void setNursingPlans(List<NursingPlansBean> NursingPlans) {
            this.NursingPlans = NursingPlans;
        }

        public static class NursingPlansBean {
            /**
             * TimeSign : 93a41623-b3c4-4134-a976-48b2ef180b1a
             * ItemName : 骨折
             * OldManId : d0450110-8fbd-4bfb-9dd3-2cbde5f7c008
             * InLiveId : 2339d403-90b7-46a6-8e2a-ad6cb2d56609
             * BeginTime : 2017-09-07 00:00:00
             * EndTime : 2017-09-07 04:00:00
             * IsChange : 4
             * IsEnd : 0
             * NursingItemId : aaca6652-eb85-4bbb-a638-03676c3c3e6c
             * SubItemId : null
             * SubIdAndVal : [{"SubItemId":"00000000-0000-0000-0000-000000000000","SubVal":null}]
             * Remark :
             */

            private String TimeSign;
            private String ItemName;
            private String OldManId;
            private String InLiveId;
            private String BeginTime;
            private String EndTime;
            private String IsChange;
            private String IsEnd;
            private String NursingItemId;
            private Object SubItemId;
            private String Remark;
            private List<SubIdAndValBean> SubIdAndVal;

            public String getTimeSign() {
                return TimeSign;
            }
            public void setTimeSign(String TimeSign) {
                this.TimeSign = TimeSign;
            }

            public String getItemName() {
                return ItemName;
            }

            public void setItemName(String ItemName) {
                this.ItemName = ItemName;
            }

            public String getOldManId() {
                return OldManId;
            }

            public void setOldManId(String OldManId) {
                this.OldManId = OldManId;
            }

            public String getInLiveId() {
                return InLiveId;
            }

            public void setInLiveId(String InLiveId) {
                this.InLiveId = InLiveId;
            }

            public String getBeginTime() {
                return BeginTime;
            }

            public void setBeginTime(String BeginTime) {
                this.BeginTime = BeginTime;
            }

            public String getEndTime() {
                return EndTime;
            }

            public void setEndTime(String EndTime) {
                this.EndTime = EndTime;
            }

            public String getIsChange() {
                return IsChange;
            }

            public void setIsChange(String IsChange) {
                this.IsChange = IsChange;
            }

            public String getIsEnd() {
                return IsEnd;
            }

            public void setIsEnd(String IsEnd) {
                this.IsEnd = IsEnd;
            }

            public String getNursingItemId() {
                return NursingItemId;
            }

            public void setNursingItemId(String NursingItemId) {
                this.NursingItemId = NursingItemId;
            }

            public Object getSubItemId() {
                return SubItemId;
            }

            public void setSubItemId(Object SubItemId) {
                this.SubItemId = SubItemId;
            }

            public String getRemark() {
                return Remark;
            }

            public void setRemark(String Remark) {
                this.Remark = Remark;
            }

            public List<SubIdAndValBean> getSubIdAndVal() {
                return SubIdAndVal;
            }

            public void setSubIdAndVal(List<SubIdAndValBean> SubIdAndVal) {
                this.SubIdAndVal = SubIdAndVal;
            }

            public static class SubIdAndValBean {
                /**
                 * SubItemId : 00000000-0000-0000-0000-000000000000
                 * SubVal : null
                 */

                private String SubItemId;
                private Object SubVal;

                public String getSubItemId() {
                    return SubItemId;
                }

                public void setSubItemId(String SubItemId) {
                    this.SubItemId = SubItemId;
                }

                public Object getSubVal() {
                    return SubVal;
                }

                public void setSubVal(Object SubVal) {
                    this.SubVal = SubVal;
                }
            }
        }
    }
}
