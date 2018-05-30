package com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "rrolegroup", schema = "public", catalog = "postgres")
public class RrolegroupEntity {
    private String id;
    private TroleEntity troleByRid;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RrolegroupEntity that = (RrolegroupEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (troleByRid != null ? !troleByRid.equals(that.troleByRid) : that.troleByRid != null)
            return false;
        if (tgroupByGid != null ? !tgroupByGid.equals(that.tgroupByGid) : that.tgroupByGid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (troleByRid != null ? troleByRid.hashCode() : 0);
        result = 31 * result + (tgroupByGid != null ? tgroupByGid.hashCode() : 0);
        return result;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gid", referencedColumnName = "gid")
    public TgroupEntity getTgroupByGid() {
        return tgroupByGid;
    }

    public void setTgroupByGid(TgroupEntity tgroupByGid) {
        this.tgroupByGid = tgroupByGid;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rid", referencedColumnName = "rid")
    public TroleEntity getTroleByRid() {
        return troleByRid;
    }

    public void setTroleByRid(TroleEntity troleByRid) {
        this.troleByRid = troleByRid;
    }
}
