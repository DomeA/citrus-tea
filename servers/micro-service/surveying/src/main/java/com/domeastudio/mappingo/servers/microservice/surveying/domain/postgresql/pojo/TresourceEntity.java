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
    /**
     * 0000-0000-0000-0000-0000-0000-00000-0000-0000-0000
     * 十级菜单
     */
    private String code;
    private String iconId;
    private String type;
    private Boolean selected;
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

        return true;
    }

    @Override
    public int hashCode() {
        int result = reid != null ? reid.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
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
    @Column(name = "code")
    public String getCode() {
        if (code.length() > 49) {
            return code.substring(0, 48);
        }
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
}
