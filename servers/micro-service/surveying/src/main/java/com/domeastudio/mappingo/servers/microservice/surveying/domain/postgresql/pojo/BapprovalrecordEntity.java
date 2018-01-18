package com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "bapprovalrecord", schema = "public", catalog = "postgres")
public class BapprovalrecordEntity {
    private String aid;
    private String record;
    private TuserEntity tuserByUid;
    private BbuildingProcessformEntity bbuildingProcessformByBid;
    private BcadastralProcessformEntity bcadastralProcessformByCid;
    private BsurveyProcessformEntity bsurveyProcessformBySid;

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



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BapprovalrecordEntity that = (BapprovalrecordEntity) o;

        if (aid != null ? !aid.equals(that.aid) : that.aid != null) return false;
        if (tuserByUid != null ? !tuserByUid.equals(that.tuserByUid) : that.tuserByUid != null)
            return false;
        if (bbuildingProcessformByBid != null ? !bbuildingProcessformByBid.equals(that.bbuildingProcessformByBid) : that.bbuildingProcessformByBid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = aid != null ? aid.hashCode() : 0;
        result = 31 * result + (tuserByUid != null ? tuserByUid.hashCode() : 0);
        result = 31 * result + (bbuildingProcessformByBid != null ? bbuildingProcessformByBid.hashCode() : 0);
        return result;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bid", referencedColumnName = "bid")
    public BbuildingProcessformEntity getBbuildingProcessformByBid() {
        return bbuildingProcessformByBid;
    }

    public void setBbuildingProcessformByBid(BbuildingProcessformEntity bbuildingProcessformByBid) {
        this.bbuildingProcessformByBid = bbuildingProcessformByBid;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cid", referencedColumnName = "cid")
    public BcadastralProcessformEntity getBcadastralProcessformByCid() {
        return bcadastralProcessformByCid;
    }

    public void setBcadastralProcessformByCid(BcadastralProcessformEntity bcadastralProcessformByCid) {
        this.bcadastralProcessformByCid = bcadastralProcessformByCid;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sid", referencedColumnName = "sid")
    public BsurveyProcessformEntity getBsurveyProcessformBySid() {
        return bsurveyProcessformBySid;
    }

    public void setBsurveyProcessformBySid(BsurveyProcessformEntity bsurveyProcessformBySid) {
        this.bsurveyProcessformBySid = bsurveyProcessformBySid;
    }
}
