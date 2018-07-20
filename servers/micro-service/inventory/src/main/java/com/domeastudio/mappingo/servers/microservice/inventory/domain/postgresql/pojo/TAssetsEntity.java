package com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.pojo;

import java.util.Collection;
import java.util.Objects;

public class TAssetsEntity {
    private String aid;
    private String code;
    private TDepartmentEntity tDepartmentByDid;
    private TAssetstypeEntity tAssetstypeByAtid;
    private TAssetsinfoEntity tAssetsinfoByAiid;
    private Collection<THistoricalrecordsEntity> tHistoricalrecordsByAid;
    private Collection<TRealtimerecordsEntity> tRealtimerecordsByAid;

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TAssetsEntity that = (TAssetsEntity) o;
        return Objects.equals(aid, that.aid) &&
                Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {

        return Objects.hash(aid, code);
    }

    public TDepartmentEntity gettDepartmentByDid() {
        return tDepartmentByDid;
    }

    public void settDepartmentByDid(TDepartmentEntity tDepartmentByDid) {
        this.tDepartmentByDid = tDepartmentByDid;
    }

    public TAssetstypeEntity gettAssetstypeByAtid() {
        return tAssetstypeByAtid;
    }

    public void settAssetstypeByAtid(TAssetstypeEntity tAssetstypeByAtid) {
        this.tAssetstypeByAtid = tAssetstypeByAtid;
    }

    public TAssetsinfoEntity gettAssetsinfoByAiid() {
        return tAssetsinfoByAiid;
    }

    public void settAssetsinfoByAiid(TAssetsinfoEntity tAssetsinfoByAiid) {
        this.tAssetsinfoByAiid = tAssetsinfoByAiid;
    }

    public Collection<THistoricalrecordsEntity> gettHistoricalrecordsByAid() {
        return tHistoricalrecordsByAid;
    }

    public void settHistoricalrecordsByAid(Collection<THistoricalrecordsEntity> tHistoricalrecordsByAid) {
        this.tHistoricalrecordsByAid = tHistoricalrecordsByAid;
    }

    public Collection<TRealtimerecordsEntity> gettRealtimerecordsByAid() {
        return tRealtimerecordsByAid;
    }

    public void settRealtimerecordsByAid(Collection<TRealtimerecordsEntity> tRealtimerecordsByAid) {
        this.tRealtimerecordsByAid = tRealtimerecordsByAid;
    }
}
