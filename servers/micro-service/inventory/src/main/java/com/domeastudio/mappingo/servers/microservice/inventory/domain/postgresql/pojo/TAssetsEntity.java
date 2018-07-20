package com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.pojo;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "t_assets", schema = "public", catalog = "invenDB")
public class TAssetsEntity {
    private String aid;
    private String code;
    private TUserEntity tUserByUid;
    private TAssetstypeEntity tAssetstypeByAtid;
    private TAssetsinfoEntity tAssetsinfoByAiid;
    private Set<THistoricalrecordsEntity> tHistoricalrecordsByAid;
    private Set<TRealtimerecordsEntity> tRealtimerecordsByAid;

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

    public TUserEntity gettUserByUid() {
        return tUserByUid;
    }

    public void settUserByUid(TUserEntity tUserByUid) {
        this.tUserByUid = tUserByUid;
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

    public void settHistoricalrecordsByAid(Set<THistoricalrecordsEntity> tHistoricalrecordsByAid) {
        this.tHistoricalrecordsByAid = tHistoricalrecordsByAid;
    }

    public Collection<TRealtimerecordsEntity> gettRealtimerecordsByAid() {
        return tRealtimerecordsByAid;
    }

    public void settRealtimerecordsByAid(Set<TRealtimerecordsEntity> tRealtimerecordsByAid) {
        this.tRealtimerecordsByAid = tRealtimerecordsByAid;
    }
}
