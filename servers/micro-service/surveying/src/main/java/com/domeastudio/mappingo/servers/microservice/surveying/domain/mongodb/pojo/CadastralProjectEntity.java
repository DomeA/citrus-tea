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
    private Float ZMJ;
    private Float ZMJ1;
    private Float SYMJ;
    private Float SYMJ1;
    private Float DLMJ;
    private Float DLMJ1;
    private Float LDMJ;
    private Float LDMJ1;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<FileEntity> getFileEntities() {
        return fileEntities;
    }

    public void setFileEntities(List<FileEntity> fileEntities) {
        this.fileEntities = fileEntities;
    }

    public Float getZMJ() {
        return ZMJ;
    }

    public void setZMJ(Float ZMJ) {
        this.ZMJ = ZMJ;
    }

    public Float getZMJ1() {
        return ZMJ1;
    }

    public void setZMJ1(Float ZMJ1) {
        this.ZMJ1 = ZMJ1;
    }

    public Float getSYMJ() {
        return SYMJ;
    }

    public void setSYMJ(Float SYMJ) {
        this.SYMJ = SYMJ;
    }

    public Float getSYMJ1() {
        return SYMJ1;
    }

    public void setSYMJ1(Float SYMJ1) {
        this.SYMJ1 = SYMJ1;
    }

    public Float getDLMJ() {
        return DLMJ;
    }

    public void setDLMJ(Float DLMJ) {
        this.DLMJ = DLMJ;
    }

    public Float getDLMJ1() {
        return DLMJ1;
    }

    public void setDLMJ1(Float DLMJ1) {
        this.DLMJ1 = DLMJ1;
    }

    public Float getLDMJ() {
        return LDMJ;
    }

    public void setLDMJ(Float LDMJ) {
        this.LDMJ = LDMJ;
    }

    public Float getLDMJ1() {
        return LDMJ1;
    }

    public void setLDMJ1(Float LDMJ1) {
        this.LDMJ1 = LDMJ1;
    }

    public String getQLRMC() {
        return QLRMC;
    }

    public void setQLRMC(String QLRMC) {
        this.QLRMC = QLRMC;
    }

    public String getHZMC() {
        return HZMC;
    }

    public void setHZMC(String HZMC) {
        this.HZMC = HZMC;
    }

    public String getZJZL() {
        return ZJZL;
    }

    public void setZJZL(String ZJZL) {
        this.ZJZL = ZJZL;
    }

    public String getZJH() {
        return ZJH;
    }

    public void setZJH(String ZJH) {
        this.ZJH = ZJH;
    }

    public String getDH() {
        return DH;
    }

    public void setDH(String DH) {
        this.DH = DH;
    }

    public String getDLRMC() {
        return DLRMC;
    }

    public void setDLRMC(String DLRMC) {
        this.DLRMC = DLRMC;
    }

    public String getZJZL1() {
        return ZJZL1;
    }

    public void setZJZL1(String ZJZL1) {
        this.ZJZL1 = ZJZL1;
    }

    public String getZJH1() {
        return ZJH1;
    }

    public void setZJH1(String ZJH1) {
        this.ZJH1 = ZJH1;
    }

    public String getDH1() {
        return DH1;
    }

    public void setDH1(String DH1) {
        this.DH1 = DH1;
    }

    public String getBZ() {
        return BZ;
    }

    public void setBZ(String BZ) {
        this.BZ = BZ;
    }
}
