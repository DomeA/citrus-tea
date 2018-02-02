package com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

//房屋测量表单
@Entity
@Table(name = "bbuildingprocessform", schema = "public", catalog = "postgres")
public class BbuildingProcessformEntity {
    private String bid;
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
    //实测情况
    //计算方法
    //经办人意见
    //互检意见
    //部门质检意见
    //部门意见
    //质检部门意见
    //审批意见
    //财务意见
    //档案意见


    private Set<BapprovalrecordEntity> bapprovalrecordsByBid;

    @Id
    @GeneratedValue(generator = "autoid")
    @GenericGenerator(name = "autoid", strategy = "uuid")
    @Column(name = "bid")
    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
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

    @OneToMany(mappedBy = "bbuildingProcessformByBid", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    public Set<BapprovalrecordEntity> getBapprovalrecordsByBid() {
        return bapprovalrecordsByBid;
    }

    public void setBapprovalrecordsByBid(Set<BapprovalrecordEntity> bapprovalrecordsByBid) {
        this.bapprovalrecordsByBid = bapprovalrecordsByBid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BbuildingProcessformEntity that = (BbuildingProcessformEntity) o;

        if (bid != null ? !bid.equals(that.bid) : that.bid != null) return false;
        if (projectName != null ? !projectName.equals(that.projectName) : that.projectName != null)
            return false;
        if (projectTime != null ? !projectTime.equals(that.projectTime) : that.projectTime != null) return false;
        if (projectCode != null ? !projectCode.equals(that.projectCode) : that.projectCode != null) return false;
        if (projectAddress != null ? !projectAddress.equals(that.projectAddress) : that.projectAddress != null)
            return false;
        if (entrustmentUnit != null ? !entrustmentUnit.equals(that.entrustmentUnit) : that.entrustmentUnit != null)
            return false;
        if (surveyType != null ? !surveyType.equals(that.surveyType) : that.surveyType != null) return false;
        if (receive != null ? !receive.equals(that.receive) : that.receive != null) return false;
        if (datumId != null ? !datumId.equals(that.datumId) : that.datumId != null) return false;
        if (projectAchievementsId != null ? !projectAchievementsId.equals(that.projectAchievementsId) : that.projectAchievementsId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bid != null ? bid.hashCode() : 0;
        result = 31 * result + (projectName != null ? projectName.hashCode() : 0);
        result = 31 * result + (projectTime != null ? projectTime.hashCode() : 0);
        result = 31 * result + (projectCode != null ? projectCode.hashCode() : 0);
        result = 31 * result + (projectAddress != null ? projectAddress.hashCode() : 0);
        result = 31 * result + (entrustmentUnit != null ? entrustmentUnit.hashCode() : 0);
        result = 31 * result + (surveyType != null ? surveyType.hashCode() : 0);
        result = 31 * result + (receive != null ? receive.hashCode() : 0);
        result = 31 * result + (projectAchievementsId != null ? projectAchievementsId.hashCode() : 0);
        result = 31 * result + (datumId != null ? datumId.hashCode() : 0);
        return result;
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
