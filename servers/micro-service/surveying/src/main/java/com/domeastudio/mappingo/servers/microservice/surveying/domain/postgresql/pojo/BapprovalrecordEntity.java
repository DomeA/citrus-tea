package com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "bapprovalrecord", schema = "public", catalog = "postgres")
public class BapprovalrecordEntity {
    private String aid;
    private String record;
    private TuserEntity tuserByUid;
    private BprocessformEntity bprocessformByPid;

    @Id
    @GeneratedValue(generator = "autoid")
    @GenericGenerator(name = "autoid", strategy = "uuid")
    @Column(name = "aid")
    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public TuserEntity getTuserByUid() {
        return tuserByUid;
    }

    public void setTuserByUid(TuserEntity tuserByUid) {
        this.tuserByUid = tuserByUid;
    }

    public BprocessformEntity getBprocessformByPid() {
        return bprocessformByPid;
    }

    public void setBprocessformByPid(BprocessformEntity bprocessformByPid) {
        this.bprocessformByPid = bprocessformByPid;
    }
}
