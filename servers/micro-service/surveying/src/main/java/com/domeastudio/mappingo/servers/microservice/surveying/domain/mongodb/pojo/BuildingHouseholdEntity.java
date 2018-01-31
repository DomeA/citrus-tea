package com.domeastudio.mappingo.servers.microservice.surveying.domain.mongodb.pojo;

import javax.persistence.Id;
import java.util.List;

public class BuildingHouseholdEntity {
//    业务号	YWH	Char	255
//    幢号	ZH	Char	255
//    层号	CH	Char	20
//    坐落	ZL	Char	100
//    户号	HH	Int	10
//    不动产编号	BDCDYH	Char	255
//    房屋用途1	FWYT1	Char	255
//    房屋用途2	FWYT2	Char	255
//    房屋用途3	FWYT3	Char	255
//    实测建筑面积 	SCJZMJ	Float
//    实测套内建筑面积	TNJZMJ	Float
//    实测分摊建筑面积	FTJZMJ	Float
//    实测其它建筑面积	QTJZMJ	Float
//    实测分摊系数 	FTXS	Float
//    房产分户图	    FCFHT	Varbin
    @Id
    private String id;
    private String YWH;
    private String ZH;
    private String CH;
    private String ZL;
    private String HH;
    private String BDCDYH;
    private String FWYT1;
    private String FWYT2;
    private String FWYT3;
    private Float SCJZMJ;
    private Float TNJZMJ;
    private Float FTJZMJ;
    private Float QTJZMJ;
    private Float FTXS;
    private List<FileEntity> FCFHTs;
}
