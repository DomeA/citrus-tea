package com.domeastudio.mappingo.servers.microservice.surveying.domain.mongodb.pojo;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.List;

@Document(collection = "archives_info")
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

    public String getHH() {
        return HH;
    }

    public void setHH(String HH) {
        this.HH = HH;
    }

    public String getBDCDYH() {
        return BDCDYH;
    }

    public void setBDCDYH(String BDCDYH) {
        this.BDCDYH = BDCDYH;
    }

    public String getFWYT1() {
        return FWYT1;
    }

    public void setFWYT1(String FWYT1) {
        this.FWYT1 = FWYT1;
    }

    public String getFWYT2() {
        return FWYT2;
    }

    public void setFWYT2(String FWYT2) {
        this.FWYT2 = FWYT2;
    }

    public String getFWYT3() {
        return FWYT3;
    }

    public void setFWYT3(String FWYT3) {
        this.FWYT3 = FWYT3;
    }

    public Float getSCJZMJ() {
        return SCJZMJ;
    }

    public void setSCJZMJ(Float SCJZMJ) {
        this.SCJZMJ = SCJZMJ;
    }

    public Float getTNJZMJ() {
        return TNJZMJ;
    }

    public void setTNJZMJ(Float TNJZMJ) {
        this.TNJZMJ = TNJZMJ;
    }

    public Float getFTJZMJ() {
        return FTJZMJ;
    }

    public void setFTJZMJ(Float FTJZMJ) {
        this.FTJZMJ = FTJZMJ;
    }

    public Float getQTJZMJ() {
        return QTJZMJ;
    }

    public void setQTJZMJ(Float QTJZMJ) {
        this.QTJZMJ = QTJZMJ;
    }

    public Float getFTXS() {
        return FTXS;
    }

    public void setFTXS(Float FTXS) {
        this.FTXS = FTXS;
    }

    public List<FileEntity> getFCFHTs() {
        return FCFHTs;
    }

    public void setFCFHTs(List<FileEntity> FCFHTs) {
        this.FCFHTs = FCFHTs;
    }
}
