package com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.pojo;

import java.util.Collection;
import java.util.Objects;

public class TAssetstypeEntity {
    private String atid;
    private String typename;
    private String code;
    private Collection<TAssetsEntity> tAssetsByAtid;

    public String getAtid() {
        return atid;
    }

    public void setAtid(String atid) {
        this.atid = atid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
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
        TAssetstypeEntity that = (TAssetstypeEntity) o;
        return Objects.equals(atid, that.atid) &&
                Objects.equals(typename, that.typename) &&
                Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {

        return Objects.hash(atid, typename, code);
    }

    public Collection<TAssetsEntity> gettAssetsByAtid() {
        return tAssetsByAtid;
    }

    public void settAssetsByAtid(Collection<TAssetsEntity> tAssetsByAtid) {
        this.tAssetsByAtid = tAssetsByAtid;
    }
}
