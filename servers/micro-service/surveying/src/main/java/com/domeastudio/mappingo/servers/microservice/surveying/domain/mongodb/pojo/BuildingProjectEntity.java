package com.domeastudio.mappingo.servers.microservice.surveying.domain.mongodb.pojo;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import javax.persistence.Id;

//房产项目
@Document(collection = "archives_info")
public class BuildingProjectEntity {
    //    业务号	YWH	Char	255
//    幢号	ZH	Char	255
//    丘号	QH	Char	100
//    建筑物坐落	ZL	Char	255
//    建筑物名称	MC	Char	255
//    图文代码	TWDM	Char	255
//    本次测量报告概况	BCCLGK	Char	255
//    原有测量报告概况	YYCLGK	Char	255
//    项目变化情况说明	XMBHSM	Char	255
    @Id
    private String id;
    private String YWH;
    private String ZH;
    private String QH;
    private String ZL;
    private String MC;
    private String TWDM;
    private String BCCLGK;
    private String YYCLGK;
    private String XMBHSM;
    private List<BuildingLayerEntity> buildingLayers;
    //项目资料
    private List<FileEntity> fileEntities;

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

    public String getQH() {
        return QH;
    }

    public void setQH(String QH) {
        this.QH = QH;
    }

    public String getZL() {
        return ZL;
    }

    public void setZL(String ZL) {
        this.ZL = ZL;
    }

    public String getMC() {
        return MC;
    }

    public void setMC(String MC) {
        this.MC = MC;
    }

    public String getTWDM() {
        return TWDM;
    }

    public void setTWDM(String TWDM) {
        this.TWDM = TWDM;
    }

    public String getBCCLGK() {
        return BCCLGK;
    }

    public void setBCCLGK(String BCCLGK) {
        this.BCCLGK = BCCLGK;
    }

    public String getYYCLGK() {
        return YYCLGK;
    }

    public void setYYCLGK(String YYCLGK) {
        this.YYCLGK = YYCLGK;
    }

    public String getXMBHSM() {
        return XMBHSM;
    }

    public void setXMBHSM(String XMBHSM) {
        this.XMBHSM = XMBHSM;
    }

    public List<BuildingLayerEntity> getBuildingLayers() {
        return buildingLayers;
    }

    public void setBuildingLayers(List<BuildingLayerEntity> buildingLayers) {
        this.buildingLayers = buildingLayers;
    }

    public List<FileEntity> getFileEntities() {
        return fileEntities;
    }

    public void setFileEntities(List<FileEntity> fileEntities) {
        this.fileEntities = fileEntities;
    }
}
