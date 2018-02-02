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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBSM() {
        return BSM;
    }

    public void setBSM(String BSM) {
        this.BSM = BSM;
    }

    public String getPCBH() {
        return PCBH;
    }

    public void setPCBH(String PCBH) {
        this.PCBH = PCBH;
    }

    public String getLSPCBH() {
        return LSPCBH;
    }

    public void setLSPCBH(String LSPCBH) {
        this.LSPCBH = LSPCBH;
    }

    public String getXMMC() {
        return XMMC;
    }

    public void setXMMC(String XMMC) {
        this.XMMC = XMMC;
    }

    public String getQS() {
        return QS;
    }

    public void setQS(String QS) {
        this.QS = QS;
    }

    public String getDKSL() {
        return DKSL;
    }

    public void setDKSL(String DKSL) {
        this.DKSL = DKSL;
    }

    public Float getPZMJGQ() {
        return PZMJGQ;
    }

    public void setPZMJGQ(Float PZMJGQ) {
        this.PZMJGQ = PZMJGQ;
    }

    public Float getPZMJM() {
        return PZMJM;
    }

    public void setPZMJM(Float PZMJM) {
        this.PZMJM = PZMJM;
    }

    public String getSPWH() {
        return SPWH;
    }

    public void setSPWH(String SPWH) {
        this.SPWH = SPWH;
    }

    public Date getSPSJ() {
        return SPSJ;
    }

    public void setSPSJ(Date SPSJ) {
        this.SPSJ = SPSJ;
    }

    public String getCPWH() {
        return CPWH;
    }

    public void setCPWH(String CPWH) {
        this.CPWH = CPWH;
    }

    public Date getCPSJ() {
        return CPSJ;
    }

    public void setCPSJ(Date CPSJ) {
        this.CPSJ = CPSJ;
    }
}
