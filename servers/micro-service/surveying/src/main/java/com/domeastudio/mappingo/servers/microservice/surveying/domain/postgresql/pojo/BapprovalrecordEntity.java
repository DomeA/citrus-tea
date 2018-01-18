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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uid", referencedColumnName = "uid")
    public TuserEntity getTuserByUid() {
        return tuserByUid;
    }
    public void setTuserByUid(TuserEntity tuserByUid) {
        this.tuserByUid = tuserByUid;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pid", referencedColumnName = "pid")
    public BprocessformEntity getBprocessformByPid() {
        return bprocessformByPid;
    }
    public void setBprocessformByPid(BprocessformEntity bprocessformByPid) {
        this.bprocessformByPid = bprocessformByPid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BapprovalrecordEntity that = (BapprovalrecordEntity) o;

        if (aid != null ? !aid.equals(that.aid) : that.aid != null) return false;
        if (tuserByUid != null ? !tuserByUid.equals(that.tuserByUid) : that.tuserByUid != null)
            return false;
        if (bprocessformByPid != null ? !bprocessformByPid.equals(that.bprocessformByPid) : that.bprocessformByPid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = aid != null ? aid.hashCode() : 0;
        result = 31 * result + (tuserByUid != null ? tuserByUid.hashCode() : 0);
        result = 31 * result + (bprocessformByPid != null ? bprocessformByPid.hashCode() : 0);
        return result;
    }
}
