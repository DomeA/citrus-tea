package com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.pojo;

import java.util.Collection;
import java.util.Objects;

public class TAssetsstatusEntity {
    private String asid;
    private String name;
    private Collection<THistoricalrecordsEntity> tHistoricalrecordsByAsid;
    private Collection<TRealtimerecordsEntity> tRealtimerecordsByAsid;

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

    public Collection<THistoricalrecordsEntity> gettHistoricalrecordsByAsid() {
        return tHistoricalrecordsByAsid;
    }

    public void settHistoricalrecordsByAsid(Collection<THistoricalrecordsEntity> tHistoricalrecordsByAsid) {
        this.tHistoricalrecordsByAsid = tHistoricalrecordsByAsid;
    }

    public Collection<TRealtimerecordsEntity> gettRealtimerecordsByAsid() {
        return tRealtimerecordsByAsid;
    }

    public void settRealtimerecordsByAsid(Collection<TRealtimerecordsEntity> tRealtimerecordsByAsid) {
        this.tRealtimerecordsByAsid = tRealtimerecordsByAsid;
    }
}
