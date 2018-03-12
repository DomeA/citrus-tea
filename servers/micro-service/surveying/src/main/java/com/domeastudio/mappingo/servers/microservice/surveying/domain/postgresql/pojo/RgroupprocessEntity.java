package com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "rgroupprocesses", schema = "public", catalog = "postgres")
public class RgroupprocessEntity {
    private String gpid;
    private TgroupEntity tgroupByGid;
    private String processesId;

    @Id
    @GeneratedValue(generator = "autoid")
    @GenericGenerator(name = "autoid", strategy = "uuid")
    @Column(name = "gpid")
    public String getGpid() {
        return gpid;
    }

    public void setGpid(String gpid) {
        this.gpid = gpid;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gid", referencedColumnName = "gid")
    public TgroupEntity getTgroupByGid() {
        return tgroupByGid;
    }

    public void setTgroupByGid(TgroupEntity tgroupByGid) {
        this.tgroupByGid = tgroupByGid;
    }

    @Basic
    @Column(name = "processesId")
    public String getProcessesId() {
        return processesId;
    }

    public void setProcessesId(String processesId) {
        this.processesId = processesId;
    }
}
