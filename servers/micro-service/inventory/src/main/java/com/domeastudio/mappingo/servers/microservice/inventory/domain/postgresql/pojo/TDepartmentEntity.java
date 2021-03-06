package com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "t_department", schema = "public", catalog = "invenDB")
public class TDepartmentEntity {
    private String did;
    private String name;
    private Set<TScanninggunEntity> tScanninggunsByDid;
    private Set<TUserEntity> tUsersByDid;

    @Id
    @GeneratedValue(generator = "autoid")
    @GenericGenerator(name = "autoid", strategy = "uuid")
    @Column(name = "did")
    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
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
        TDepartmentEntity that = (TDepartmentEntity) o;
        return Objects.equals(did, that.did) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(did, name);
    }

    public Set<TScanninggunEntity> gettScanninggunsByDid() {
        return tScanninggunsByDid;
    }

    public void settScanninggunsByDid(Set<TScanninggunEntity> tScanninggunsByDid) {
        this.tScanninggunsByDid = tScanninggunsByDid;
    }

    public Set<TUserEntity> gettUsersByDid() {
        return tUsersByDid;
    }

    public void settUsersByDid(Set<TUserEntity> tUsersByDid) {
        this.tUsersByDid = tUsersByDid;
    }
}
