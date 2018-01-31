package com.domeastudio.mappingo.servers.microservice.surveying.domain.mongodb.pojo;

import java.util.List;
import javax.persistence.Id;

public class BuildingLayerEntity {
//    业务号	YWH	Char	255
//    幢号	ZH	Char	255
//    层号	CH	Char	20
//    坐落	ZL	Char	100
//    丘号	QH	Char	100
//    图幅号	TFH1	Char	255
//    不动产单元号	BDCDYH	Char	255
//    层建筑面积	CJZMJ	Float
//    层套内建筑面积	CTNJZMJ	Float
//    层分摊建筑面积	CFTMJ	Float
//    分摊系数K1	FTXSK1	Float
//    分摊系数K2	FTXSK2	Float
//    分摊系数K3	FTXSK3	Float
//    分摊系数K4	FTXSK4	Float
//    分摊系数K5	FTXSK5	Float
//    分摊系数K6	FTXSK6	Float
//    分摊系数K7	FTXSK7	Float
//    分摊系数K8	FTXSK8	Float
//    分摊系数K9	FTXSK9	Float
//    分摊系数K10	FTXSK10	Float
//    分层图	FCT	Varbin
    @Id
    private String id;
    private String YWH;
    private String ZH;
    private String CH;
    private String ZL;
    private String TFH1;
    private String BDCDYH;
    private Float CJZMJ;
    private Float CTNJZMJ;
    private Float CFTMJ;
    private Float FTXSK1;
    private Float FTXSK2;
    private Float FTXSK3;
    private Float FTXSK4;
    private Float FTXSK5;
    private Float FTXSK6;
    private Float FTXSK7;
    private Float FTXSK8;
    private Float FTXSK9;
    private Float FTXSK10;
    private List<FileEntity> FCTs;
    private List<BuildingHouseholdEntity> buildingHouseholdEntities;
}
