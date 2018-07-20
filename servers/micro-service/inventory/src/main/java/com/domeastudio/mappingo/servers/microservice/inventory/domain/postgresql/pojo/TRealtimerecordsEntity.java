package com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.pojo;

import java.util.Objects;

public class TRealtimerecordsEntity {
    private String rid;
    private String usetime;
    private TAssetsEntity tAssetsByAid;
    private TAssetsstatusEntity tAssetsstatusByAsid;

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getUsetime() {
        return usetime;
    }

    public void setUsetime(String usetime) {
        this.usetime = usetime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TRealtimerecordsEntity that = (TRealtimerecordsEntity) o;
        return Objects.equals(rid, that.rid) &&
                Objects.equals(usetime, that.usetime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(rid, usetime);
    }

    public TAssetsEntity gettAssetsByAid() {
        return tAssetsByAid;
    }

    public void settAssetsByAid(TAssetsEntity tAssetsByAid) {
        this.tAssetsByAid = tAssetsByAid;
    }

    public TAssetsstatusEntity gettAssetsstatusByAsid() {
        return tAssetsstatusByAsid;
    }

    public void settAssetsstatusByAsid(TAssetsstatusEntity tAssetsstatusByAsid) {
        this.tAssetsstatusByAsid = tAssetsstatusByAsid;
    }
}
