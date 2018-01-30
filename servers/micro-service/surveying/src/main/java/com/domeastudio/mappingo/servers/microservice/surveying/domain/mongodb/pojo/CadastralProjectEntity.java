package com.domeastudio.mappingo.servers.microservice.surveying.domain.mongodb.pojo;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.List;

//地籍测绘
@Document(collection = "archives_info")
public class CadastralProjectEntity {
//    业务号	YWH	Char	255
//    总面积（公顷）	ZMJ	Float
//    总面积（亩）	ZMJ1	Float
//    使用面积（公顷）	SYMJ	Float
//    使用面积(亩）	SYMJ1	Float
//    代征道路面积（公顷）	DLMJ	Float
//    代征道路面积(亩）	DLMJ1	Float
//    代征绿地面积（公顷）	LDMJ	Float
//    代征绿地面积(亩）	LDMJ1	Float
//    权利人名称	QLRMC	char	255
//    法人代表或户主名称	HZMC
//    户主证件种类	ZJZL	Char	2
//    户主证件号	ZJH	Char	50
//    户主电话	DH	Char	50
//    代理人名称	DLRMC	char	255
//    代理人证件种类	ZJZL1	Char	2
//    代理人证件号	ZJH1	Char	50
//    代理人电话	DH1	Char	50
//    备注	BZ	Char	255
    @Id
    private String id;
    private List<FileEntity> fileEntities;
    private String ZMJ;
    private String ZMJ1;
    private String SYMJ;
    private String DLMJ;
    private String DLMJ1;
    private String LDMJ;
    private String LDMJ1;
    private String QLRMC;
    private String HZMC;
    private String ZJZL;
    private String ZJH;
    private String DH;
    private String DLRMC;
    private String ZJZL1;
    private String ZJH1;
    private String DH1;
    private String BZ;

}
