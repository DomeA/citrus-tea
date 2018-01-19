package com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "rusergroup", schema = "public", catalog = "postgres")
public class RusergroupEntity {
    private String id;
    private TuserEntity tuserByUid;
    private TgroupEntity tgroupByGid;

    @Id
    @GeneratedValue(generator = "autoid")
    @GenericGenerator(name = "autoid", strategy = "uuid")
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
    @JoinColumn(name = "gid", referencedColumnName = "gid")
    public TgroupEntity getTgroupByGid() {
        return tgroupByGid;
    }

    //
    public void setTgroupByGid(TgroupEntity tgroupByGid) {
        this.tgroupByGid = tgroupByGid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RusergroupEntity that = (RusergroupEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (tuserByUid != null ? !tuserByUid.equals(that.tuserByUid) : that.tuserByUid != null)
            return false;
        if (tgroupByGid != null ? !tgroupByGid.equals(that.tgroupByGid) : that.tgroupByGid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (tuserByUid != null ? tuserByUid.hashCode() : 0);
        result = 31 * result + (tgroupByGid != null ? tgroupByGid.hashCode() : 0);
        return result;
    }
}
