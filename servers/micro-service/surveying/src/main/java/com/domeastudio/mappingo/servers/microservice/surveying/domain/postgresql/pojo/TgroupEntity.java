package com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tgroup", schema = "public", catalog = "postgres")
public class TgroupEntity {
    private String gid;
    private String name;
    private String type;
    private String parentId;
    private Set<RusergroupEntity> rusergroupsByGid;
    private Set<RrolegroupEntity> rrolegroupsByGid;
    private Set<RgroupprocessEntity> rgroupprocessesByGid;

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
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = gid != null ? gid.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "tgroupByGid", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    public Set<RusergroupEntity> getRusergroupsByGid() {
        return rusergroupsByGid;
    }

    public void setRusergroupsByGid(Set<RusergroupEntity> rusergroupsByGid) {
        this.rusergroupsByGid = rusergroupsByGid;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @OneToMany(mappedBy = "tgroupByGid", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    public Set<RrolegroupEntity> getRrolegroupsByGid() {
        return rrolegroupsByGid;
    }

    public void setRrolegroupsByGid(Set<RrolegroupEntity> rrolegroupsByGid) {
        this.rrolegroupsByGid = rrolegroupsByGid;
    }

    @OneToMany(mappedBy = "tgroupByGid", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    public Set<RgroupprocessEntity> getRgroupprocessesByGid() {
        return rgroupprocessesByGid;
    }

    public void setRgroupprocessesByGid(Set<RgroupprocessEntity> rgroupprocessesByGid) {
        this.rgroupprocessesByGid = rgroupprocessesByGid;
    }
}
