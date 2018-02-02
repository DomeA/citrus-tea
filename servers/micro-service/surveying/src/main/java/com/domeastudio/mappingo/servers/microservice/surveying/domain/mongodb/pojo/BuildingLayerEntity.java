package com.domeastudio.mappingo.servers.microservice.surveying.domain.mongodb.pojo;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import javax.persistence.Id;

@Document(collection = "archives_info")
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getYWH() {
        return YWH;
    }

    public void setYWH(String YWH) {
        this.YWH = YWH;
    }

    public String getZH() {
        return ZH;
    }

    public void setZH(String ZH) {
        this.ZH = ZH;
    }

    public String getCH() {
        return CH;
    }

    public void setCH(String CH) {
        this.CH = CH;
    }

    public String getZL() {
        return ZL;
    }

    public void setZL(String ZL) {
        this.ZL = ZL;
    }

    public String getTFH1() {
        return TFH1;
    }

    public void setTFH1(String TFH1) {
        this.TFH1 = TFH1;
    }

    public String getBDCDYH() {
        return BDCDYH;
    }

    public void setBDCDYH(String BDCDYH) {
        this.BDCDYH = BDCDYH;
    }

    public Float getCJZMJ() {
        return CJZMJ;
    }

    public void setCJZMJ(Float CJZMJ) {
        this.CJZMJ = CJZMJ;
    }

    public Float getCTNJZMJ() {
        return CTNJZMJ;
    }

    public void setCTNJZMJ(Float CTNJZMJ) {
        this.CTNJZMJ = CTNJZMJ;
    }

    public Float getCFTMJ() {
        return CFTMJ;
    }

    public void setCFTMJ(Float CFTMJ) {
        this.CFTMJ = CFTMJ;
    }

    public Float getFTXSK1() {
        return FTXSK1;
    }

    public void setFTXSK1(Float FTXSK1) {
        this.FTXSK1 = FTXSK1;
    }

    public Float getFTXSK2() {
        return FTXSK2;
    }

    public void setFTXSK2(Float FTXSK2) {
        this.FTXSK2 = FTXSK2;
    }

    public Float getFTXSK3() {
        return FTXSK3;
    }

    public void setFTXSK3(Float FTXSK3) {
        this.FTXSK3 = FTXSK3;
    }

    public Float getFTXSK4() {
        return FTXSK4;
    }

    public void setFTXSK4(Float FTXSK4) {
        this.FTXSK4 = FTXSK4;
    }

    public Float getFTXSK5() {
        return FTXSK5;
    }

    public void setFTXSK5(Float FTXSK5) {
        this.FTXSK5 = FTXSK5;
    }

    public Float getFTXSK6() {
        return FTXSK6;
    }

    public void setFTXSK6(Float FTXSK6) {
        this.FTXSK6 = FTXSK6;
    }

    public Float getFTXSK7() {
        return FTXSK7;
    }

    public void setFTXSK7(Float FTXSK7) {
        this.FTXSK7 = FTXSK7;
    }

    public Float getFTXSK8() {
        return FTXSK8;
    }

    public void setFTXSK8(Float FTXSK8) {
        this.FTXSK8 = FTXSK8;
    }

    public Float getFTXSK9() {
        return FTXSK9;
    }

    public void setFTXSK9(Float FTXSK9) {
        this.FTXSK9 = FTXSK9;
    }

    public Float getFTXSK10() {
        return FTXSK10;
    }

    public void setFTXSK10(Float FTXSK10) {
        this.FTXSK10 = FTXSK10;
    }

    public List<FileEntity> getFCTs() {
        return FCTs;
    }

    public void setFCTs(List<FileEntity> FCTs) {
        this.FCTs = FCTs;
    }

    public List<BuildingHouseholdEntity> getBuildingHouseholdEntities() {
        return buildingHouseholdEntities;
    }

    public void setBuildingHouseholdEntities(List<BuildingHouseholdEntity> buildingHouseholdEntities) {
        this.buildingHouseholdEntities = buildingHouseholdEntities;
    }
}
