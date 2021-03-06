package com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "t_assetsstatus", schema = "public", catalog = "invenDB")
public class TAssetsstatusEntity {
    private String asid;
    private String name;
    private Set<THistoricalrecordsEntity> tHistoricalrecordsByAsid;
    private Set<TRealtimerecordsEntity> tRealtimerecordsByAsid;

    @Id
    @GeneratedValue(generator = "autoid")
    @GenericGenerator(name = "autoid", strategy = "uuid")
    @Column(name = "asid")
    public String getAsid() {
        return asid;
    }

    public void setAsid(String asid) {
        this.asid = asid;
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
        TAssetsstatusEntity that = (TAssetsstatusEntity) o;
        return Objects.equals(asid, that.asid) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(asid, name);
    }

    public Set<THistoricalrecordsEntity> gettHistoricalrecordsByAsid() {
        return tHistoricalrecordsByAsid;
    }

    public void settHistoricalrecordsByAsid(Set<THistoricalrecordsEntity> tHistoricalrecordsByAsid) {
        this.tHistoricalrecordsByAsid = tHistoricalrecordsByAsid;
    }

    public Set<TRealtimerecordsEntity> gettRealtimerecordsByAsid() {
        return tRealtimerecordsByAsid;
    }

    public void settRealtimerecordsByAsid(Set<TRealtimerecordsEntity> tRealtimerecordsByAsid) {
        this.tRealtimerecordsByAsid = tRealtimerecordsByAsid;
    }
}
