package com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tgroup", schema = "public", catalog = "postgres")
public class TgroupEntity {
    private String gid;
    private String name;
    private String parentId;
    private Set<RusergroupEntity> rusergroupsByGid;

    @Id
    @GeneratedValue(generator = "autoid")
    @GenericGenerator(name = "autoid", strategy = "uuid")
    @Column(name = "gid")
    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "parentId")
    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TgroupEntity that = (TgroupEntity) o;

        if (gid != null ? !gid.equals(that.gid) : that.gid != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (parentId != null ? !parentId.equals(that.parentId) : that.parentId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = gid != null ? gid.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "tgroupByGid",cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    public Set<RusergroupEntity> getRusergroupsByGid() {
        return rusergroupsByGid;
    }

    public void setRusergroupsByGid(Set<RusergroupEntity> rusergroupsByGid) {
        this.rusergroupsByGid = rusergroupsByGid;
    }
}
