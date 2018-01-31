package com.domeastudio.mappingo.servers.microservice.surveying.domain.mongodb.pojo;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Date;

//堪界项目
@Document(collection = "archives_info")
public class SurveyProjectEntity {
//    标识码	BSM	Int	10
//    批次编号	PCBH	Char	255
//    历史批次编号	LSPCBH	Char	255
//    项目名称	XMMC	Char	255
//    权属	QS	Char	255
//    地块数量	DKSL	Int	10
//    批准面积公顷	PZMJGQ	Float
//    批准面积亩	PZMJM	Float
//    省批文号	SPWH	Char	255
//    省批时间	SPSJ	DATE
//    市批文号	CPWH	Char	255
//    市批时间	CPSJ	DATE

    @Id
    private String id;
    private String BSM;
    private String PCBH;
    private String LSPCBH;
    private String XMMC;
    private String QS;
    private String DKSL;
    private Float PZMJGQ;
    private Float PZMJM;
    private String SPWH;
    private Date SPSJ;
    private String CPWH;
    private Date CPSJ;
}
