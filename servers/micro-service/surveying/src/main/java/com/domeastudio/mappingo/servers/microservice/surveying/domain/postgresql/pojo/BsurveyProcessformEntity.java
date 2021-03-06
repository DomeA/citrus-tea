package com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

//堪界表单
@Entity
@Table(name = "bsurveyProcessform", schema = "public", catalog = "postgres")
public class BsurveyProcessformEntity {
    private String sid;
    //项目名称
    private String projectName;
    //项目时间
    private String projectTime;
    //项目编码
    private String projectCode;
    //项目坐落地址
    private String projectAddress;
    //委托单位
    private String entrustmentUnit;
    //测绘类型
    private String surveyType;
    //接件情况
    private String receive;
    private String datumId;
    private String projectAchievementsId;
    private Set<BapprovalrecordEntity> bapprovalrecordsByBid;

    @Id
    @GeneratedValue(generator = "autoid")
    @GenericGenerator(name = "autoid", strategy = "uuid")
    @Column(name = "sid")
    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectTime() {
        return projectTime;
    }

    public void setProjectTime(String projectTime) {
        this.projectTime = projectTime;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getProjectAddress() {
        return projectAddress;
    }

    public void setProjectAddress(String projectAddress) {
        this.projectAddress = projectAddress;
    }

    public String getEntrustmentUnit() {
        return entrustmentUnit;
    }

    public void setEntrustmentUnit(String entrustmentUnit) {
        this.entrustmentUnit = entrustmentUnit;
    }

    public String getSurveyType() {
        return surveyType;
    }

    public void setSurveyType(String surveyType) {
        this.surveyType = surveyType;
    }

    public String getReceive() {
        return receive;
    }

    public void setReceive(String receive) {
        this.receive = receive;
    }

    @OneToMany(mappedBy = "bbuildingProcessformByBid", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    public Set<BapprovalrecordEntity> getBapprovalrecordsByBid() {
        return bapprovalrecordsByBid;
    }

    public void setBapprovalrecordsByBid(Set<BapprovalrecordEntity> bapprovalrecordsByBid) {
        this.bapprovalrecordsByBid = bapprovalrecordsByBid;
    }

    public String getDatumId() {
        return datumId;
    }

    public void setDatumId(String datumId) {
        this.datumId = datumId;
    }

    public String getProjectAchievementsId() {
        return projectAchievementsId;
    }

    public void setProjectAchievementsId(String projectAchievementsId) {
        this.projectAchievementsId = projectAchievementsId;
    }
}
