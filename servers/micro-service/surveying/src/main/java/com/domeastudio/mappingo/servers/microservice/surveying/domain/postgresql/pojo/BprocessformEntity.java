package com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "bprocessform", schema = "public", catalog = "postgres")
public class BprocessformEntity {
    private String pid;
    private String projectName;
    private String projectTime;
    private Set<BapprovalrecordEntity> bapprovalrecordsByPid;

    @Id
    @GeneratedValue(generator = "autoid")
    @GenericGenerator(name = "autoid", strategy = "uuid")
    @Column(name = "pid")
    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
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

    @OneToMany(mappedBy = "bprocessformByPid",cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    public Set<BapprovalrecordEntity> getBapprovalrecordsByPid() {
        return bapprovalrecordsByPid;
    }

    public void setBapprovalrecordsByPid(Set<BapprovalrecordEntity> bapprovalrecordsByPid) {
        this.bapprovalrecordsByPid = bapprovalrecordsByPid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BprocessformEntity that = (BprocessformEntity) o;

        if (pid != null ? !pid.equals(that.pid) : that.pid != null) return false;
        if (projectName != null ? !projectName.equals(that.projectName) : that.projectName != null)
            return false;
        if (projectTime != null ? !projectTime.equals(that.projectTime) : that.projectTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pid != null ? pid.hashCode() : 0;
        result = 31 * result + (projectName != null ? projectName.hashCode() : 0);
        result = 31 * result + (projectTime != null ? projectTime.hashCode() : 0);
        return result;
    }
}
