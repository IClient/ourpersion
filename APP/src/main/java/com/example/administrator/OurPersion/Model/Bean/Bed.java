package com.example.administrator.OurPersion.Model.Bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/9/22 0022.
 */

public class Bed {


    private List<UnitBean> unit;

    public List<UnitBean> getUnit() {
        return unit;
    }

    public void setUnit(List<UnitBean> unit) {
        this.unit = unit;
    }

    public static class UnitBean implements Serializable{
        /**
         * units : [{"floors":[{"rooms":[{"beds":[{"Id":"95e5f9d2-d992-4905-b6dd-3e77f5cb6a5a","BedNo":"yyl-1-1-101-01","BedName":"01","BedState":"2","BedType":"豪华级","Money":"2280.00"}],"Id":"f861dd2e-8ba7-4d0a-8824-c6904ccdd542","RoomNo":"yyl-1-1-101","RoomName":"101","RoomType":"标间"}],"Id":"b7b4e0fb-8020-443e-aedc-3c0a6167186a","FloorNo":"yll-1-1","FloorName":"一楼"}],"Id":"3834c058-875d-4e0e-a2aa-8affa8e75334","BuildId":"a35f2cb6-9f80-4d7b-b66d-df4ce2fd0a93","UnitNo":"D02","UnitName":"一单元"}]
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

        public static class UnitsBean implements Serializable{
            /**
             * floors : [{"rooms":[{"beds":[{"Id":"95e5f9d2-d992-4905-b6dd-3e77f5cb6a5a","BedNo":"yyl-1-1-101-01","BedName":"01","BedState":"2","BedType":"豪华级","Money":"2280.00"}],"Id":"f861dd2e-8ba7-4d0a-8824-c6904ccdd542","RoomNo":"yyl-1-1-101","RoomName":"101","RoomType":"标间"}],"Id":"b7b4e0fb-8020-443e-aedc-3c0a6167186a","FloorNo":"yll-1-1","FloorName":"一楼"}]
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

            public static class FloorsBean implements Serializable {
                /**
                 * rooms : [{"beds":[{"Id":"95e5f9d2-d992-4905-b6dd-3e77f5cb6a5a","BedNo":"yyl-1-1-101-01","BedName":"01","BedState":"2","BedType":"豪华级","Money":"2280.00"}],"Id":"f861dd2e-8ba7-4d0a-8824-c6904ccdd542","RoomNo":"yyl-1-1-101","RoomName":"101","RoomType":"标间"}]
                 * Id : b7b4e0fb-8020-443e-aedc-3c0a6167186a
                 * FloorNo : yll-1-1
                 * FloorName : 一楼
                 */

                private String Id;
                private String FloorNo;
                private String FloorName;
                private List<RoomsBean> rooms;

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

                public List<RoomsBean> getRooms() {
                    return rooms;
                }

                public void setRooms(List<RoomsBean> rooms) {
                    this.rooms = rooms;
                }

                public static class RoomsBean implements Serializable{
                    /**
                     * beds : [{"Id":"95e5f9d2-d992-4905-b6dd-3e77f5cb6a5a","BedNo":"yyl-1-1-101-01","BedName":"01","BedState":"2","BedType":"豪华级","Money":"2280.00"}]
                     * Id : f861dd2e-8ba7-4d0a-8824-c6904ccdd542
                     * RoomNo : yyl-1-1-101
                     * RoomName : 101
                     * RoomType : 标间
                     */

                    private String Id;
                    private String RoomNo;
                    private String RoomName;
                    private String RoomType;
                    private List<BedsBean> beds;

                    public String getId() {
                        return Id;
                    }

                    public void setId(String Id) {
                        this.Id = Id;
                    }

                    public String getRoomNo() {
                        return RoomNo;
                    }

                    public void setRoomNo(String RoomNo) {
                        this.RoomNo = RoomNo;
                    }

                    public String getRoomName() {
                        return RoomName;
                    }

                    public void setRoomName(String RoomName) {
                        this.RoomName = RoomName;
                    }

                    public String getRoomType() {
                        return RoomType;
                    }

                    public void setRoomType(String RoomType) {
                        this.RoomType = RoomType;
                    }

                    public List<BedsBean> getBeds() {
                        return beds;
                    }

                    public void setBeds(List<BedsBean> beds) {
                        this.beds = beds;
                    }

                    public static class BedsBean implements Serializable{
                        /**
                         * Id : 95e5f9d2-d992-4905-b6dd-3e77f5cb6a5a
                         * BedNo : yyl-1-1-101-01
                         * BedName : 01
                         * BedState : 2
                         * BedType : 豪华级
                         * Money : 2280.00
                         */

                        private String Id;
                        private String BedNo;
                        private String BedName;
                        private String BedState;
                        private String BedType;
                        private String Money;

                        public String getId() {
                            return Id;
                        }

                        public void setId(String Id) {
                            this.Id = Id;
                        }

                        public String getBedNo() {
                            return BedNo;
                        }

                        public void setBedNo(String BedNo) {
                            this.BedNo = BedNo;
                        }

                        public String getBedName() {
                            return BedName;
                        }

                        public void setBedName(String BedName) {
                            this.BedName = BedName;
                        }

                        public String getBedState() {
                            return BedState;
                        }

                        public void setBedState(String BedState) {
                            this.BedState = BedState;
                        }

                        public String getBedType() {
                            return BedType;
                        }

                        public void setBedType(String BedType) {
                            this.BedType = BedType;
                        }

                        public String getMoney() {
                            return Money;
                        }

                        public void setMoney(String Money) {
                            this.Money = Money;
                        }
                    }
                }
            }
        }
    }
}
