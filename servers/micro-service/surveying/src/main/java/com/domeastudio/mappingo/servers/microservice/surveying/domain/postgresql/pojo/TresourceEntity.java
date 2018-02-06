package com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "tresource", schema = "public", catalog = "postgres")
public class TresourceEntity {
    private String reid;
    private String name;
    private String iconId;
    private String type;
    private Boolean selected;
    private String code;
    private String parenId;
    private Set<RroleresourceEntity> rroleresourcesByReid;
    private Set<RuserresourceEntity> ruserresourcesByReid;

    @Id
    @GeneratedValue(generator = "autoid")
    @GenericGenerator(name = "autoid", strategy = "uuid")
    @Column(name = "reid")
    public String getReid() {
        return reid;
    }

    public void setReid(String reid) {
        this.reid = reid;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TresourceEntity that = (TresourceEntity) o;

        if (reid != null ? !reid.equals(that.reid) : that.reid != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (iconId != null ? !iconId.equals(that.iconId) : that.iconId != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (selected != null ? !selected.equals(that.selected) : that.selected != null) return false;
        if (parenId != null ? !parenId.equals(that.parenId) : that.parenId != null) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = reid != null ? reid.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (iconId != null ? iconId.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (selected != null ? selected.hashCode() : 0);
        result = 31 * result + (parenId != null ? parenId.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "tresourceByReid", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    public Set<RroleresourceEntity> getRroleresourcesByReid() {
        return rroleresourcesByReid;
    }

    public void setRroleresourcesByReid(Set<RroleresourceEntity> rroleresourcesByReid) {
        this.rroleresourcesByReid = rroleresourcesByReid;
    }

    @OneToMany(mappedBy = "tresourceByReid", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    public Set<RuserresourceEntity> getRuserresourcesByReid() {
        return ruserresourcesByReid;
    }

    public void setRuserresourcesByReid(Set<RuserresourceEntity> ruserresourcesByReid) {
        this.ruserresourcesByReid = ruserresourcesByReid;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "selected")
    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    @Basic
    @Column(name = "iconId")
    public String getIconId() {
        return iconId;
    }

    public void setIconId(String iconId) {
        this.iconId = iconId;
    }

    @Basic
    @Column(name = "parenId")
    public String getParenId() {
        return parenId;
    }

    public void setParenId(String parenId) {
        this.parenId = parenId;
    }

    @Basic
    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
