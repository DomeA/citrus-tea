package com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "t_scanninggun", schema = "public", catalog = "invenDB")
public class TScanninggunEntity {
    private String sid;
    private Integer code;
    private String name;
    private TDepartmentEntity tDepartmentByDid;

    @Id
    @GeneratedValue(generator = "autoid")
    @GenericGenerator(name = "autoid", strategy = "uuid")
    @Column(name = "sid")
    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

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
        TScanninggunEntity that = (TScanninggunEntity) o;
        return Objects.equals(sid, that.sid) &&
                Objects.equals(code, that.code) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(sid, code, name);
    }

    public TDepartmentEntity gettDepartmentByDid() {
        return tDepartmentByDid;
    }

    public void settDepartmentByDid(TDepartmentEntity tDepartmentByDid) {
        this.tDepartmentByDid = tDepartmentByDid;
    }
}
