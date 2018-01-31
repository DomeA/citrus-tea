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

}
