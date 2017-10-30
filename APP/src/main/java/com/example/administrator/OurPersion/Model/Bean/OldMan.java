package com.example.administrator.OurPersion.Model.Bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/6/5 0005.
 */

/**
 * 入住老人列表
 */

public class OldMan implements Serializable {


    /**
     * OldManList : {"ExtraCount":0,"CurrentPageIndex":1,"PageSize":10,"TotalItemCount":18,"TotalPageCount":2,"StartRecordIndex":1,"EndRecordIndex":10,"Datas":[{"EducationDegree":null,"IDType":null,"PersonalCompositionStr":null,"PoliticalStatusStr":null,"MaritalStatusStr":null,"ReligiousBeliefStr":null,"PositionName":null,"CheckIn":"81d6fc7c-9036-46d3-853f-529420b31489","Id":"dfbffcbd-b22c-44b4-b0cb-3303390a5227","CustomerName":"张三峰","CertificateNumber":"8900321","Sex":"0","Birthday":"2017-09-28","Nationality":null,"PhoneNumber":"13336669985","Address":"成都市青羊区","Status":"1","CreateId":"3434fc57-32db-4443-9b23-ed3c7dac98ff","CreaterName":"赖虹宏","CreaterTime":"2017-09-26T10:12:56.477","ModifiedId":"063879b2-6a58-481c-af3a-2284806de6ba","ModifiedName":"admin","ModifiedTime":"2017-09-28T09:03:07.58","Remark":null,"ImgPath":"/Resource/OldManage/b766be5d-73d6-453a-b0a1-825ccb44ad81.jpg","ImgRealName":"oldfour.jpg","SourceId":"00000000-0000-0000-0000-000000000000","Mark":"0","PoliticalStatusId":"00000000-0000-0000-0000-000000000000","MaritalStatus":"00000000-0000-0000-0000-000000000000","RetirementCareer":null,"Hobby":null,"ReligiousBeliefId":"00000000-0000-0000-0000-000000000000","WorkAbility":null,"FamilyPopulation":0,"EconomicSource":null,"EducationDegreeId":"00000000-0000-0000-0000-000000000000","CheckinTime":null,"DocumentType":"72852799-68e8-427e-b790-3da0e3924753","PersonalComposition":"00000000-0000-0000-0000-000000000000","BloodType":null},{"EducationDegree":null,"IDType":null,"PersonalCompositionStr":null,"PoliticalStatusStr":null,"MaritalStatusStr":null,"ReligiousBeliefStr":null,"PositionName":null,"CheckIn":"873bf602-c0cd-495e-9644-154c941e7264","Id":"a36d8c10-53b4-476f-8cc5-db86f82f69ee","CustomerName":"张峰","CertificateNumber":"8900321123","Sex":"0","Birthday":"2017-09-28","Nationality":null,"PhoneNumber":"13211124354","Address":"成都市青羊区","Status":"1","CreateId":"04fdfa5b-1685-46e4-80bd-d5d663b502bc","CreaterName":"赖虹宏","CreaterTime":"2017-09-26T09:40:45.897","ModifiedId":"063879b2-6a58-481c-af3a-2284806de6ba","ModifiedName":"admin","ModifiedTime":"2017-09-28T09:06:21.82","Remark":null,"ImgPath":"/Resource/OldManage/686e265c-d11e-4fa9-be71-b18ce19bc665.jpg","ImgRealName":"oldsix.jpg","SourceId":"00000000-0000-0000-0000-000000000000","Mark":"0","PoliticalStatusId":"00000000-0000-0000-0000-000000000000","MaritalStatus":"00000000-0000-0000-0000-000000000000","RetirementCareer":null,"Hobby":null,"ReligiousBeliefId":"00000000-0000-0000-0000-000000000000","WorkAbility":null,"FamilyPopulation":0,"EconomicSource":null,"EducationDegreeId":"00000000-0000-0000-0000-000000000000","CheckinTime":null,"DocumentType":"72852799-68e8-427e-b790-3da0e3924753","PersonalComposition":"00000000-0000-0000-0000-000000000000","BloodType":null},{"EducationDegree":null,"IDType":null,"PersonalCompositionStr":null,"PoliticalStatusStr":null,"MaritalStatusStr":null,"ReligiousBeliefStr":null,"PositionName":null,"CheckIn":"a7193237-9845-4bf6-a954-77a154990c03","Id":"c96eff3e-d0e3-4b48-ac23-e4a6735881f6","CustomerName":"刘明小","CertificateNumber":"3534354354354","Sex":"0","Birthday":"2017-09-28","Nationality":null,"PhoneNumber":"138888888","Address":"成都市新都区","Status":"1","CreateId":"e07b7da8-9dd5-4c25-9480-9ee32f652894","CreaterName":"王福龙","CreaterTime":"2017-09-22T15:49:29.787","ModifiedId":"063879b2-6a58-481c-af3a-2284806de6ba","ModifiedName":"admin","ModifiedTime":"2017-09-28T09:03:49.967","Remark":null,"ImgPath":"/Resource/OldManage/7de06815-9748-4824-9c04-e2d1443bd2da.jpg","ImgRealName":"oldnine.jpg","SourceId":"00000000-0000-0000-0000-000000000000","Mark":"0","PoliticalStatusId":"00000000-0000-0000-0000-000000000000","MaritalStatus":"0d04d8d9-933d-41d7-9a17-01970f717f3d","RetirementCareer":null,"Hobby":null,"ReligiousBeliefId":"00000000-0000-0000-0000-000000000000","WorkAbility":null,"FamilyPopulation":0,"EconomicSource":null,"EducationDegreeId":"00000000-0000-0000-0000-000000000000","CheckinTime":null,"DocumentType":"88c3350c-0f51-40a6-b163-5072b07e7d0b","PersonalComposition":"00000000-0000-0000-0000-000000000000","BloodType":null},{"EducationDegree":null,"IDType":null,"PersonalCompositionStr":null,"PoliticalStatusStr":null,"MaritalStatusStr":null,"ReligiousBeliefStr":null,"PositionName":null,"CheckIn":"f09eca9c-c079-424d-b1c1-723f34ff5ce9","Id":"5dcdbd9b-f895-4f07-a617-5034c1e4b966","CustomerName":"张小明","CertificateNumber":"3543543545345","Sex":"0","Birthday":"2017-09-28","Nationality":null,"PhoneNumber":"1388888888","Address":"南充市嘉陵区","Status":"1","CreateId":"85b0cd4e-b774-46f1-aaeb-199ffdb0d4b1","CreaterName":"王福龙","CreaterTime":"2017-09-21T13:49:49.49","ModifiedId":"063879b2-6a58-481c-af3a-2284806de6ba","ModifiedName":"admin","ModifiedTime":"2017-09-28T09:04:15.28","Remark":null,"ImgPath":"/Resource/OldManage/7ca639dc-caf6-4574-987c-bf87baccd297.jpg","ImgRealName":"oldsix.jpg","SourceId":"00000000-0000-0000-0000-000000000000","Mark":"0","PoliticalStatusId":"00000000-0000-0000-0000-000000000000","MaritalStatus":"0d04d8d9-933d-41d7-9a17-01970f717f3d","RetirementCareer":null,"Hobby":null,"ReligiousBeliefId":"00000000-0000-0000-0000-000000000000","WorkAbility":null,"FamilyPopulation":0,"EconomicSource":null,"EducationDegreeId":"00000000-0000-0000-0000-000000000000","CheckinTime":null,"DocumentType":"72852799-68e8-427e-b790-3da0e3924753","PersonalComposition":"00000000-0000-0000-0000-000000000000","BloodType":null},{"EducationDegree":null,"IDType":null,"PersonalCompositionStr":null,"PoliticalStatusStr":null,"MaritalStatusStr":null,"ReligiousBeliefStr":null,"PositionName":null,"CheckIn":"87b46125-6fc9-4c5c-b696-2a4e20b08a81","Id":"44b4ad7f-00f4-4cbb-98ce-27b66a84ad79","CustomerName":"李军","CertificateNumber":"46546546546","Sex":"0","Birthday":"2017-09-28","Nationality":null,"PhoneNumber":"1888888888","Address":"四川","Status":"1","CreateId":"85f6dbf7-609f-4718-9515-872f7a5d15fa","CreaterName":"王福龙","CreaterTime":"2017-09-21T11:34:14.37","ModifiedId":"063879b2-6a58-481c-af3a-2284806de6ba","ModifiedName":"admin","ModifiedTime":"2017-09-28T09:04:54.497","Remark":null,"ImgPath":"/Resource/OldManage/8770158a-16f8-45d5-a5da-b7116f8eee13.jpg","ImgRealName":"oldthree.jpg","SourceId":"00000000-0000-0000-0000-000000000000","Mark":"0","PoliticalStatusId":"00000000-0000-0000-0000-000000000000","MaritalStatus":"0d04d8d9-933d-41d7-9a17-01970f717f3d","RetirementCareer":null,"Hobby":null,"ReligiousBeliefId":"00000000-0000-0000-0000-000000000000","WorkAbility":null,"FamilyPopulation":0,"EconomicSource":null,"EducationDegreeId":"00000000-0000-0000-0000-000000000000","CheckinTime":null,"DocumentType":"72852799-68e8-427e-b790-3da0e3924753","PersonalComposition":"00000000-0000-0000-0000-000000000000","BloodType":null},{"EducationDegree":null,"IDType":null,"PersonalCompositionStr":null,"PoliticalStatusStr":null,"MaritalStatusStr":null,"ReligiousBeliefStr":null,"PositionName":null,"CheckIn":"c9587f63-03b7-4dde-b74e-f8784bbdd039","Id":"48cc5fe1-945b-4de9-a00d-71868d0cf6c0","CustomerName":"李四","CertificateNumber":"512723196601012200","Sex":"0","Birthday":"2017-09-28","Nationality":"汉","PhoneNumber":"15982484156","Address":"四川","Status":"1","CreateId":"0201c01f-3099-497b-9d27-4fa4b80b7762","CreaterName":"admin","CreaterTime":"2017-09-21T11:33:50.773","ModifiedId":"063879b2-6a58-481c-af3a-2284806de6ba","ModifiedName":"admin","ModifiedTime":"2017-09-28T09:05:06.537","Remark":null,"ImgPath":"/Resource/OldManage/fd96efab-020f-4045-92be-c16f7bfff303.jpg","ImgRealName":"oldseven.jpg","SourceId":"00000000-0000-0000-0000-000000000000","Mark":"0","PoliticalStatusId":"00000000-0000-0000-0000-000000000000","MaritalStatus":"0d04d8d9-933d-41d7-9a17-01970f717f3d","RetirementCareer":null,"Hobby":null,"ReligiousBeliefId":"00000000-0000-0000-0000-000000000000","WorkAbility":null,"FamilyPopulation":0,"EconomicSource":null,"EducationDegreeId":"00000000-0000-0000-0000-000000000000","CheckinTime":null,"DocumentType":"72852799-68e8-427e-b790-3da0e3924753","PersonalComposition":"00000000-0000-0000-0000-000000000000","BloodType":null},{"EducationDegree":null,"IDType":null,"PersonalCompositionStr":null,"PoliticalStatusStr":null,"MaritalStatusStr":null,"ReligiousBeliefStr":null,"PositionName":null,"CheckIn":"a73a68e5-4866-4e63-ae0c-932bb34ad1ba","Id":"dfaa7b7d-a1a6-4b98-9629-9609b4d51851","CustomerName":"李小明","CertificateNumber":"35435434534","Sex":"0","Birthday":"2017-09-28","Nationality":null,"PhoneNumber":"1355555555","Address":"四川","Status":"1","CreateId":"17d2a3cc-d6f2-4c5a-89fd-3ddcc0b8bad1","CreaterName":"王福龙","CreaterTime":"2017-09-20T17:39:27.937","ModifiedId":"063879b2-6a58-481c-af3a-2284806de6ba","ModifiedName":"admin","ModifiedTime":"2017-09-28T09:04:40.843","Remark":null,"ImgPath":"/Resource/OldManage/27d33431-eca6-4cdd-9b61-890d8d1f7601.jpg","ImgRealName":"oldthree.jpg","SourceId":"00000000-0000-0000-0000-000000000000","Mark":"0","PoliticalStatusId":"00000000-0000-0000-0000-000000000000","MaritalStatus":"0d04d8d9-933d-41d7-9a17-01970f717f3d","RetirementCareer":null,"Hobby":null,"ReligiousBeliefId":"00000000-0000-0000-0000-000000000000","WorkAbility":null,"FamilyPopulation":0,"EconomicSource":null,"EducationDegreeId":"00000000-0000-0000-0000-000000000000","CheckinTime":null,"DocumentType":"72852799-68e8-427e-b790-3da0e3924753","PersonalComposition":"00000000-0000-0000-0000-000000000000","BloodType":null},{"EducationDegree":null,"IDType":null,"PersonalCompositionStr":null,"PoliticalStatusStr":null,"MaritalStatusStr":null,"ReligiousBeliefStr":null,"PositionName":null,"CheckIn":"c5fa0e36-bc8b-46b5-b895-fe077b780936","Id":"7c9f5ba3-d92c-44e7-9c56-b15de6123e9e","CustomerName":"马岱","CertificateNumber":"510123194910010001","Sex":"0","Birthday":"2017-09-28","Nationality":null,"PhoneNumber":"13881881100","Address":"四川","Status":"1","CreateId":"3781f30c-5175-4b38-a5c5-4a6020b346b4","CreaterName":"汤俊","CreaterTime":"2017-09-16T09:07:14.98","ModifiedId":"063879b2-6a58-481c-af3a-2284806de6ba","ModifiedName":"admin","ModifiedTime":"2017-09-28T09:08:59.383","Remark":null,"ImgPath":"/Resource/OldManage/dffb692f-46ab-4f60-a867-d22e4d8a5771.jpg","ImgRealName":"oldnine.jpg","SourceId":"00000000-0000-0000-0000-000000000000","Mark":"0","PoliticalStatusId":"00000000-0000-0000-0000-000000000000","MaritalStatus":"00000000-0000-0000-0000-000000000000","RetirementCareer":null,"Hobby":null,"ReligiousBeliefId":"00000000-0000-0000-0000-000000000000","WorkAbility":null,"FamilyPopulation":0,"EconomicSource":null,"EducationDegreeId":"00000000-0000-0000-0000-000000000000","CheckinTime":null,"DocumentType":"72852799-68e8-427e-b790-3da0e3924753","PersonalComposition":"00000000-0000-0000-0000-000000000000","BloodType":null},{"EducationDegree":null,"IDType":null,"PersonalCompositionStr":null,"PoliticalStatusStr":null,"MaritalStatusStr":null,"ReligiousBeliefStr":null,"PositionName":null,"CheckIn":"3d5309a2-9bdc-45ec-96b7-fb56a8acf1dd","Id":"b114fb0b-3af2-4fe1-9511-30508c102315","CustomerName":"夏侯恩","CertificateNumber":"123","Sex":"1","Birthday":"2017-09-28","Nationality":null,"PhoneNumber":"1","Address":"测试","Status":"1","CreateId":"952945b7-0aeb-4151-897b-dd78dca37dad","CreaterName":"admin","CreaterTime":"2017-09-14T14:34:31.013","ModifiedId":"063879b2-6a58-481c-af3a-2284806de6ba","ModifiedName":"admin","ModifiedTime":"2017-09-28T09:05:39.04","Remark":null,"ImgPath":"/Resource/OldManage/8b48ad95-8d8b-462c-9c8e-f0df824544cc.jpg","ImgRealName":"oldfive.jpg","SourceId":"00000000-0000-0000-0000-000000000000","Mark":"0","PoliticalStatusId":"00000000-0000-0000-0000-000000000000","MaritalStatus":"00000000-0000-0000-0000-000000000000","RetirementCareer":null,"Hobby":null,"ReligiousBeliefId":"00000000-0000-0000-0000-000000000000","WorkAbility":null,"FamilyPopulation":0,"EconomicSource":null,"EducationDegreeId":"00000000-0000-0000-0000-000000000000","CheckinTime":null,"DocumentType":"72852799-68e8-427e-b790-3da0e3924753","PersonalComposition":"00000000-0000-0000-0000-000000000000","BloodType":null},{"EducationDegree":null,"IDType":null,"PersonalCompositionStr":null,"PoliticalStatusStr":null,"MaritalStatusStr":null,"ReligiousBeliefStr":null,"PositionName":null,"CheckIn":"3fec3732-5f9f-4907-8d29-113cb52db4cb","Id":"d652cbe3-73ce-4a8b-a557-44c51b780d74","CustomerName":"黄忠","CertificateNumber":"510123195505050014","Sex":"0","Birthday":"2017-09-28","Nationality":"汉族","PhoneNumber":"13602587432","Address":"测试","Status":"1","CreateId":"9b77b469-29a3-4e8b-b69e-d1c09be7fffc","CreaterName":"汤俊","CreaterTime":"2017-09-13T09:00:17","ModifiedId":"063879b2-6a58-481c-af3a-2284806de6ba","ModifiedName":"admin","ModifiedTime":"2017-09-28T09:05:51.837","Remark":null,"ImgPath":"/Resource/OldManage/c003d7e7-a4a7-4397-900e-63e3988a4a26.jpg","ImgRealName":"oldnine.jpg","SourceId":"00000000-0000-0000-0000-000000000000","Mark":"0","PoliticalStatusId":"b45b99e4-0853-43af-aeba-610f4e838f1a","MaritalStatus":"dd415865-e079-4610-8001-e9673e7358bf","RetirementCareer":"退休老大爷","Hobby":null,"ReligiousBeliefId":"00000000-0000-0000-0000-000000000000","WorkAbility":null,"FamilyPopulation":0,"EconomicSource":null,"EducationDegreeId":"324f06e9-1ebc-4f84-ab68-e39015c77ced","CheckinTime":null,"DocumentType":"72852799-68e8-427e-b790-3da0e3924753","PersonalComposition":"e570f7b7-bd45-42a1-af9e-68702826f725","BloodType":"B"}]}
     */

    private OldManListBean OldManList;

    public OldManListBean getOldManList() {
        return OldManList;
    }

    public void setOldManList(OldManListBean OldManList) {
        this.OldManList = OldManList;
    }

    public static class OldManListBean implements Serializable {
        /**
         * ExtraCount : 0
         * CurrentPageIndex : 1
         * PageSize : 10
         * TotalItemCount : 18
         * TotalPageCount : 2
         * StartRecordIndex : 1
         * EndRecordIndex : 10
         * Datas : [{"EducationDegree":null,"IDType":null,"PersonalCompositionStr":null,"PoliticalStatusStr":null,"MaritalStatusStr":null,"ReligiousBeliefStr":null,"PositionName":null,"CheckIn":"81d6fc7c-9036-46d3-853f-529420b31489","Id":"dfbffcbd-b22c-44b4-b0cb-3303390a5227","CustomerName":"张三峰","CertificateNumber":"8900321","Sex":"0","Birthday":"2017-09-28","Nationality":null,"PhoneNumber":"13336669985","Address":"成都市青羊区","Status":"1","CreateId":"3434fc57-32db-4443-9b23-ed3c7dac98ff","CreaterName":"赖虹宏","CreaterTime":"2017-09-26T10:12:56.477","ModifiedId":"063879b2-6a58-481c-af3a-2284806de6ba","ModifiedName":"admin","ModifiedTime":"2017-09-28T09:03:07.58","Remark":null,"ImgPath":"/Resource/OldManage/b766be5d-73d6-453a-b0a1-825ccb44ad81.jpg","ImgRealName":"oldfour.jpg","SourceId":"00000000-0000-0000-0000-000000000000","Mark":"0","PoliticalStatusId":"00000000-0000-0000-0000-000000000000","MaritalStatus":"00000000-0000-0000-0000-000000000000","RetirementCareer":null,"Hobby":null,"ReligiousBeliefId":"00000000-0000-0000-0000-000000000000","WorkAbility":null,"FamilyPopulation":0,"EconomicSource":null,"EducationDegreeId":"00000000-0000-0000-0000-000000000000","CheckinTime":null,"DocumentType":"72852799-68e8-427e-b790-3da0e3924753","PersonalComposition":"00000000-0000-0000-0000-000000000000","BloodType":null},{"EducationDegree":null,"IDType":null,"PersonalCompositionStr":null,"PoliticalStatusStr":null,"MaritalStatusStr":null,"ReligiousBeliefStr":null,"PositionName":null,"CheckIn":"873bf602-c0cd-495e-9644-154c941e7264","Id":"a36d8c10-53b4-476f-8cc5-db86f82f69ee","CustomerName":"张峰","CertificateNumber":"8900321123","Sex":"0","Birthday":"2017-09-28","Nationality":null,"PhoneNumber":"13211124354","Address":"成都市青羊区","Status":"1","CreateId":"04fdfa5b-1685-46e4-80bd-d5d663b502bc","CreaterName":"赖虹宏","CreaterTime":"2017-09-26T09:40:45.897","ModifiedId":"063879b2-6a58-481c-af3a-2284806de6ba","ModifiedName":"admin","ModifiedTime":"2017-09-28T09:06:21.82","Remark":null,"ImgPath":"/Resource/OldManage/686e265c-d11e-4fa9-be71-b18ce19bc665.jpg","ImgRealName":"oldsix.jpg","SourceId":"00000000-0000-0000-0000-000000000000","Mark":"0","PoliticalStatusId":"00000000-0000-0000-0000-000000000000","MaritalStatus":"00000000-0000-0000-0000-000000000000","RetirementCareer":null,"Hobby":null,"ReligiousBeliefId":"00000000-0000-0000-0000-000000000000","WorkAbility":null,"FamilyPopulation":0,"EconomicSource":null,"EducationDegreeId":"00000000-0000-0000-0000-000000000000","CheckinTime":null,"DocumentType":"72852799-68e8-427e-b790-3da0e3924753","PersonalComposition":"00000000-0000-0000-0000-000000000000","BloodType":null},{"EducationDegree":null,"IDType":null,"PersonalCompositionStr":null,"PoliticalStatusStr":null,"MaritalStatusStr":null,"ReligiousBeliefStr":null,"PositionName":null,"CheckIn":"a7193237-9845-4bf6-a954-77a154990c03","Id":"c96eff3e-d0e3-4b48-ac23-e4a6735881f6","CustomerName":"刘明小","CertificateNumber":"3534354354354","Sex":"0","Birthday":"2017-09-28","Nationality":null,"PhoneNumber":"138888888","Address":"成都市新都区","Status":"1","CreateId":"e07b7da8-9dd5-4c25-9480-9ee32f652894","CreaterName":"王福龙","CreaterTime":"2017-09-22T15:49:29.787","ModifiedId":"063879b2-6a58-481c-af3a-2284806de6ba","ModifiedName":"admin","ModifiedTime":"2017-09-28T09:03:49.967","Remark":null,"ImgPath":"/Resource/OldManage/7de06815-9748-4824-9c04-e2d1443bd2da.jpg","ImgRealName":"oldnine.jpg","SourceId":"00000000-0000-0000-0000-000000000000","Mark":"0","PoliticalStatusId":"00000000-0000-0000-0000-000000000000","MaritalStatus":"0d04d8d9-933d-41d7-9a17-01970f717f3d","RetirementCareer":null,"Hobby":null,"ReligiousBeliefId":"00000000-0000-0000-0000-000000000000","WorkAbility":null,"FamilyPopulation":0,"EconomicSource":null,"EducationDegreeId":"00000000-0000-0000-0000-000000000000","CheckinTime":null,"DocumentType":"88c3350c-0f51-40a6-b163-5072b07e7d0b","PersonalComposition":"00000000-0000-0000-0000-000000000000","BloodType":null},{"EducationDegree":null,"IDType":null,"PersonalCompositionStr":null,"PoliticalStatusStr":null,"MaritalStatusStr":null,"ReligiousBeliefStr":null,"PositionName":null,"CheckIn":"f09eca9c-c079-424d-b1c1-723f34ff5ce9","Id":"5dcdbd9b-f895-4f07-a617-5034c1e4b966","CustomerName":"张小明","CertificateNumber":"3543543545345","Sex":"0","Birthday":"2017-09-28","Nationality":null,"PhoneNumber":"1388888888","Address":"南充市嘉陵区","Status":"1","CreateId":"85b0cd4e-b774-46f1-aaeb-199ffdb0d4b1","CreaterName":"王福龙","CreaterTime":"2017-09-21T13:49:49.49","ModifiedId":"063879b2-6a58-481c-af3a-2284806de6ba","ModifiedName":"admin","ModifiedTime":"2017-09-28T09:04:15.28","Remark":null,"ImgPath":"/Resource/OldManage/7ca639dc-caf6-4574-987c-bf87baccd297.jpg","ImgRealName":"oldsix.jpg","SourceId":"00000000-0000-0000-0000-000000000000","Mark":"0","PoliticalStatusId":"00000000-0000-0000-0000-000000000000","MaritalStatus":"0d04d8d9-933d-41d7-9a17-01970f717f3d","RetirementCareer":null,"Hobby":null,"ReligiousBeliefId":"00000000-0000-0000-0000-000000000000","WorkAbility":null,"FamilyPopulation":0,"EconomicSource":null,"EducationDegreeId":"00000000-0000-0000-0000-000000000000","CheckinTime":null,"DocumentType":"72852799-68e8-427e-b790-3da0e3924753","PersonalComposition":"00000000-0000-0000-0000-000000000000","BloodType":null},{"EducationDegree":null,"IDType":null,"PersonalCompositionStr":null,"PoliticalStatusStr":null,"MaritalStatusStr":null,"ReligiousBeliefStr":null,"PositionName":null,"CheckIn":"87b46125-6fc9-4c5c-b696-2a4e20b08a81","Id":"44b4ad7f-00f4-4cbb-98ce-27b66a84ad79","CustomerName":"李军","CertificateNumber":"46546546546","Sex":"0","Birthday":"2017-09-28","Nationality":null,"PhoneNumber":"1888888888","Address":"四川","Status":"1","CreateId":"85f6dbf7-609f-4718-9515-872f7a5d15fa","CreaterName":"王福龙","CreaterTime":"2017-09-21T11:34:14.37","ModifiedId":"063879b2-6a58-481c-af3a-2284806de6ba","ModifiedName":"admin","ModifiedTime":"2017-09-28T09:04:54.497","Remark":null,"ImgPath":"/Resource/OldManage/8770158a-16f8-45d5-a5da-b7116f8eee13.jpg","ImgRealName":"oldthree.jpg","SourceId":"00000000-0000-0000-0000-000000000000","Mark":"0","PoliticalStatusId":"00000000-0000-0000-0000-000000000000","MaritalStatus":"0d04d8d9-933d-41d7-9a17-01970f717f3d","RetirementCareer":null,"Hobby":null,"ReligiousBeliefId":"00000000-0000-0000-0000-000000000000","WorkAbility":null,"FamilyPopulation":0,"EconomicSource":null,"EducationDegreeId":"00000000-0000-0000-0000-000000000000","CheckinTime":null,"DocumentType":"72852799-68e8-427e-b790-3da0e3924753","PersonalComposition":"00000000-0000-0000-0000-000000000000","BloodType":null},{"EducationDegree":null,"IDType":null,"PersonalCompositionStr":null,"PoliticalStatusStr":null,"MaritalStatusStr":null,"ReligiousBeliefStr":null,"PositionName":null,"CheckIn":"c9587f63-03b7-4dde-b74e-f8784bbdd039","Id":"48cc5fe1-945b-4de9-a00d-71868d0cf6c0","CustomerName":"李四","CertificateNumber":"512723196601012200","Sex":"0","Birthday":"2017-09-28","Nationality":"汉","PhoneNumber":"15982484156","Address":"四川","Status":"1","CreateId":"0201c01f-3099-497b-9d27-4fa4b80b7762","CreaterName":"admin","CreaterTime":"2017-09-21T11:33:50.773","ModifiedId":"063879b2-6a58-481c-af3a-2284806de6ba","ModifiedName":"admin","ModifiedTime":"2017-09-28T09:05:06.537","Remark":null,"ImgPath":"/Resource/OldManage/fd96efab-020f-4045-92be-c16f7bfff303.jpg","ImgRealName":"oldseven.jpg","SourceId":"00000000-0000-0000-0000-000000000000","Mark":"0","PoliticalStatusId":"00000000-0000-0000-0000-000000000000","MaritalStatus":"0d04d8d9-933d-41d7-9a17-01970f717f3d","RetirementCareer":null,"Hobby":null,"ReligiousBeliefId":"00000000-0000-0000-0000-000000000000","WorkAbility":null,"FamilyPopulation":0,"EconomicSource":null,"EducationDegreeId":"00000000-0000-0000-0000-000000000000","CheckinTime":null,"DocumentType":"72852799-68e8-427e-b790-3da0e3924753","PersonalComposition":"00000000-0000-0000-0000-000000000000","BloodType":null},{"EducationDegree":null,"IDType":null,"PersonalCompositionStr":null,"PoliticalStatusStr":null,"MaritalStatusStr":null,"ReligiousBeliefStr":null,"PositionName":null,"CheckIn":"a73a68e5-4866-4e63-ae0c-932bb34ad1ba","Id":"dfaa7b7d-a1a6-4b98-9629-9609b4d51851","CustomerName":"李小明","CertificateNumber":"35435434534","Sex":"0","Birthday":"2017-09-28","Nationality":null,"PhoneNumber":"1355555555","Address":"四川","Status":"1","CreateId":"17d2a3cc-d6f2-4c5a-89fd-3ddcc0b8bad1","CreaterName":"王福龙","CreaterTime":"2017-09-20T17:39:27.937","ModifiedId":"063879b2-6a58-481c-af3a-2284806de6ba","ModifiedName":"admin","ModifiedTime":"2017-09-28T09:04:40.843","Remark":null,"ImgPath":"/Resource/OldManage/27d33431-eca6-4cdd-9b61-890d8d1f7601.jpg","ImgRealName":"oldthree.jpg","SourceId":"00000000-0000-0000-0000-000000000000","Mark":"0","PoliticalStatusId":"00000000-0000-0000-0000-000000000000","MaritalStatus":"0d04d8d9-933d-41d7-9a17-01970f717f3d","RetirementCareer":null,"Hobby":null,"ReligiousBeliefId":"00000000-0000-0000-0000-000000000000","WorkAbility":null,"FamilyPopulation":0,"EconomicSource":null,"EducationDegreeId":"00000000-0000-0000-0000-000000000000","CheckinTime":null,"DocumentType":"72852799-68e8-427e-b790-3da0e3924753","PersonalComposition":"00000000-0000-0000-0000-000000000000","BloodType":null},{"EducationDegree":null,"IDType":null,"PersonalCompositionStr":null,"PoliticalStatusStr":null,"MaritalStatusStr":null,"ReligiousBeliefStr":null,"PositionName":null,"CheckIn":"c5fa0e36-bc8b-46b5-b895-fe077b780936","Id":"7c9f5ba3-d92c-44e7-9c56-b15de6123e9e","CustomerName":"马岱","CertificateNumber":"510123194910010001","Sex":"0","Birthday":"2017-09-28","Nationality":null,"PhoneNumber":"13881881100","Address":"四川","Status":"1","CreateId":"3781f30c-5175-4b38-a5c5-4a6020b346b4","CreaterName":"汤俊","CreaterTime":"2017-09-16T09:07:14.98","ModifiedId":"063879b2-6a58-481c-af3a-2284806de6ba","ModifiedName":"admin","ModifiedTime":"2017-09-28T09:08:59.383","Remark":null,"ImgPath":"/Resource/OldManage/dffb692f-46ab-4f60-a867-d22e4d8a5771.jpg","ImgRealName":"oldnine.jpg","SourceId":"00000000-0000-0000-0000-000000000000","Mark":"0","PoliticalStatusId":"00000000-0000-0000-0000-000000000000","MaritalStatus":"00000000-0000-0000-0000-000000000000","RetirementCareer":null,"Hobby":null,"ReligiousBeliefId":"00000000-0000-0000-0000-000000000000","WorkAbility":null,"FamilyPopulation":0,"EconomicSource":null,"EducationDegreeId":"00000000-0000-0000-0000-000000000000","CheckinTime":null,"DocumentType":"72852799-68e8-427e-b790-3da0e3924753","PersonalComposition":"00000000-0000-0000-0000-000000000000","BloodType":null},{"EducationDegree":null,"IDType":null,"PersonalCompositionStr":null,"PoliticalStatusStr":null,"MaritalStatusStr":null,"ReligiousBeliefStr":null,"PositionName":null,"CheckIn":"3d5309a2-9bdc-45ec-96b7-fb56a8acf1dd","Id":"b114fb0b-3af2-4fe1-9511-30508c102315","CustomerName":"夏侯恩","CertificateNumber":"123","Sex":"1","Birthday":"2017-09-28","Nationality":null,"PhoneNumber":"1","Address":"测试","Status":"1","CreateId":"952945b7-0aeb-4151-897b-dd78dca37dad","CreaterName":"admin","CreaterTime":"2017-09-14T14:34:31.013","ModifiedId":"063879b2-6a58-481c-af3a-2284806de6ba","ModifiedName":"admin","ModifiedTime":"2017-09-28T09:05:39.04","Remark":null,"ImgPath":"/Resource/OldManage/8b48ad95-8d8b-462c-9c8e-f0df824544cc.jpg","ImgRealName":"oldfive.jpg","SourceId":"00000000-0000-0000-0000-000000000000","Mark":"0","PoliticalStatusId":"00000000-0000-0000-0000-000000000000","MaritalStatus":"00000000-0000-0000-0000-000000000000","RetirementCareer":null,"Hobby":null,"ReligiousBeliefId":"00000000-0000-0000-0000-000000000000","WorkAbility":null,"FamilyPopulation":0,"EconomicSource":null,"EducationDegreeId":"00000000-0000-0000-0000-000000000000","CheckinTime":null,"DocumentType":"72852799-68e8-427e-b790-3da0e3924753","PersonalComposition":"00000000-0000-0000-0000-000000000000","BloodType":null},{"EducationDegree":null,"IDType":null,"PersonalCompositionStr":null,"PoliticalStatusStr":null,"MaritalStatusStr":null,"ReligiousBeliefStr":null,"PositionName":null,"CheckIn":"3fec3732-5f9f-4907-8d29-113cb52db4cb","Id":"d652cbe3-73ce-4a8b-a557-44c51b780d74","CustomerName":"黄忠","CertificateNumber":"510123195505050014","Sex":"0","Birthday":"2017-09-28","Nationality":"汉族","PhoneNumber":"13602587432","Address":"测试","Status":"1","CreateId":"9b77b469-29a3-4e8b-b69e-d1c09be7fffc","CreaterName":"汤俊","CreaterTime":"2017-09-13T09:00:17","ModifiedId":"063879b2-6a58-481c-af3a-2284806de6ba","ModifiedName":"admin","ModifiedTime":"2017-09-28T09:05:51.837","Remark":null,"ImgPath":"/Resource/OldManage/c003d7e7-a4a7-4397-900e-63e3988a4a26.jpg","ImgRealName":"oldnine.jpg","SourceId":"00000000-0000-0000-0000-000000000000","Mark":"0","PoliticalStatusId":"b45b99e4-0853-43af-aeba-610f4e838f1a","MaritalStatus":"dd415865-e079-4610-8001-e9673e7358bf","RetirementCareer":"退休老大爷","Hobby":null,"ReligiousBeliefId":"00000000-0000-0000-0000-000000000000","WorkAbility":null,"FamilyPopulation":0,"EconomicSource":null,"EducationDegreeId":"324f06e9-1ebc-4f84-ab68-e39015c77ced","CheckinTime":null,"DocumentType":"72852799-68e8-427e-b790-3da0e3924753","PersonalComposition":"e570f7b7-bd45-42a1-af9e-68702826f725","BloodType":"B"}]
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

        public static class DatasBean implements Serializable {
            /**
             * EducationDegree : null
             * IDType : null
             * PersonalCompositionStr : null
             * PoliticalStatusStr : null
             * MaritalStatusStr : null
             * ReligiousBeliefStr : null
             * PositionName : null
             * CheckIn : 81d6fc7c-9036-46d3-853f-529420b31489
             * Id : dfbffcbd-b22c-44b4-b0cb-3303390a5227
             * CustomerName : 张三峰
             * CertificateNumber : 8900321
             * Sex : 0
             * Birthday : 2017-09-28
             * Nationality : null
             * PhoneNumber : 13336669985
             * Address : 成都市青羊区
             * Status : 1
             * CreateId : 3434fc57-32db-4443-9b23-ed3c7dac98ff
             * CreaterName : 赖虹宏
             * CreaterTime : 2017-09-26T10:12:56.477
             * ModifiedId : 063879b2-6a58-481c-af3a-2284806de6ba
             * ModifiedName : admin
             * ModifiedTime : 2017-09-28T09:03:07.58
             * Remark : null
             * ImgPath : /Resource/OldManage/b766be5d-73d6-453a-b0a1-825ccb44ad81.jpg
             * ImgRealName : oldfour.jpg
             * SourceId : 00000000-0000-0000-0000-000000000000
             * Mark : 0
             * PoliticalStatusId : 00000000-0000-0000-0000-000000000000
             * MaritalStatus : 00000000-0000-0000-0000-000000000000
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
            private Object PositionName;
            private String CheckIn;
            private String Id;
            private String CustomerName;
            private String CertificateNumber;
            private String Sex;
            private String Birthday;
            private Object Nationality;
            private String PhoneNumber;
            private String Address;
            private String Status;
            private String CreateId;
            private String CreaterName;
            private String CreaterTime;
            private String ModifiedId;
            private String ModifiedName;
            private String ModifiedTime;
            private Object Remark;
            private String ImgPath;
            private String ImgRealName;
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

            public Object getPositionName() {
                return PositionName;
            }

            public void setPositionName(Object PositionName) {
                this.PositionName = PositionName;
            }

            public String getCheckIn() {
                return CheckIn;
            }

            public void setCheckIn(String CheckIn) {
                this.CheckIn = CheckIn;
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

            public String getBirthday() {
                return Birthday;
            }

            public void setBirthday(String Birthday) {
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

            public String getAddress() {
                return Address;
            }

            public void setAddress(String Address) {
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

            public String getImgPath() {
                return ImgPath;
            }

            public void setImgPath(String ImgPath) {
                this.ImgPath = ImgPath;
            }

            public String getImgRealName() {
                return ImgRealName;
            }

            public void setImgRealName(String ImgRealName) {
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
}
