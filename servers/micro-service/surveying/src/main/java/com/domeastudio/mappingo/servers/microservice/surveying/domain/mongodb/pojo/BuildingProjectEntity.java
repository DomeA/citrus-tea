package com.domeastudio.mappingo.servers.microservice.surveying.domain.mongodb.pojo;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

//房产项目
@Document(collection = "archives_info")
public class BuildingProjectEntity {
//    业务号	YWH	Char	255
//    幢号	ZH	Char	255
//    建筑物坐落	ZL	Char	255
//    建筑物名称	MC	Char	255
//    图文代码	TWDM	Char	255
//    本次测量报告概况	BCCLGK	Char	255
//    原有测量报告概况	YYCLGK	Char	255
//    项目变化情况说明	XMBHSM	Char	255
    List<BuildingLayerEntity> buildingLayers;
}
