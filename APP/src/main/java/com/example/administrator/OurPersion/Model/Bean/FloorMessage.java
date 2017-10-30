package com.example.administrator.OurPersion.Model.Bean;

import java.util.List;

/**
 * Created by Administrator on 2017/9/25 0025.
 */

public class FloorMessage {


    private List<FloormessageBean> floormessage;

    public List<FloormessageBean> getFloormessage() {
        return floormessage;
    }

    public void setFloormessage(List<FloormessageBean> floormessage) {
        this.floormessage = floormessage;
    }

    public static class FloormessageBean {
        /**
         * units : [{"floors":[{"rooms":null,"Id":"b7b4e0fb-8020-443e-aedc-3c0a6167186a","FloorNo":"yll","FloorName":"一楼"}],"Id":"3834c058-875d-4e0e-a2aa-8affa8e75334","BuildId":"a35f2cb6-9f80-4d7b-b66d-df4ce2fd0a93","UnitNo":"D02","UnitName":"一单元"}]
         * Id : a35f2cb6-9f80-4d7b-b66d-df4ce2fd0a93
         * BuildingName : 怡养楼
         * BuildingNo : yll
         */

        private String Id;
        private String BuildingName;
        private String BuildingNo;
        private List<UnitsBean> units;

        public String getId() {
            return Id;
        }

        public void setId(String Id) {
            this.Id = Id;
        }

        public String getBuildingName() {
            return BuildingName;
        }

        public void setBuildingName(String BuildingName) {
            this.BuildingName = BuildingName;
        }

        public String getBuildingNo() {
            return BuildingNo;
        }

        public void setBuildingNo(String BuildingNo) {
            this.BuildingNo = BuildingNo;
        }

        public List<UnitsBean> getUnits() {
            return units;
        }

        public void setUnits(List<UnitsBean> units) {
            this.units = units;
        }

        public static class UnitsBean {
            /**
             * floors : [{"rooms":null,"Id":"b7b4e0fb-8020-443e-aedc-3c0a6167186a","FloorNo":"yll","FloorName":"一楼"}]
             * Id : 3834c058-875d-4e0e-a2aa-8affa8e75334
             * BuildId : a35f2cb6-9f80-4d7b-b66d-df4ce2fd0a93
             * UnitNo : D02
             * UnitName : 一单元
             */

            private String Id;
            private String BuildId;
            private String UnitNo;
            private String UnitName;
            private List<FloorsBean> floors;

            public String getId() {
                return Id;
            }

            public void setId(String Id) {
                this.Id = Id;
            }

            public String getBuildId() {
                return BuildId;
            }

            public void setBuildId(String BuildId) {
                this.BuildId = BuildId;
            }

            public String getUnitNo() {
                return UnitNo;
            }

            public void setUnitNo(String UnitNo) {
                this.UnitNo = UnitNo;
            }

            public String getUnitName() {
                return UnitName;
            }

            public void setUnitName(String UnitName) {
                this.UnitName = UnitName;
            }

            public List<FloorsBean> getFloors() {
                return floors;
            }

            public void setFloors(List<FloorsBean> floors) {
                this.floors = floors;
            }

            public static class FloorsBean {
                /**
                 * rooms : null
                 * Id : b7b4e0fb-8020-443e-aedc-3c0a6167186a
                 * FloorNo : yll
                 * FloorName : 一楼
                 */

                private Object rooms;
                private String Id;
                private String FloorNo;
                private String FloorName;

                public Object getRooms() {
                    return rooms;
                }

                public void setRooms(Object rooms) {
                    this.rooms = rooms;
                }

                public String getId() {
                    return Id;
                }

                public void setId(String Id) {
                    this.Id = Id;
                }

                public String getFloorNo() {
                    return FloorNo;
                }

                public void setFloorNo(String FloorNo) {
                    this.FloorNo = FloorNo;
                }

                public String getFloorName() {
                    return FloorName;
                }

                public void setFloorName(String FloorName) {
                    this.FloorName = FloorName;
                }
            }
        }
    }
}
