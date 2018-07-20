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
    private Set<TUserEntity> tUserEntitiesByDid;

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

    @OneToMany(mappedBy = "tDepartmentByDid", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    public Set<TUserEntity> gettUserEntitiesByDid() {
        return tUserEntitiesByDid;
    }

    public void settUserEntitiesByDid(Set<TUserEntity> tUserEntitiesByDid) {
        this.tUserEntitiesByDid = tUserEntitiesByDid;
    }
}
