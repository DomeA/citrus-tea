package com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.pojo;

import java.util.Collection;
import java.util.Objects;

public class TDepartmentEntity {
    private String did;
    private String name;
    private Collection<TAssetsEntity> tAssetsByDid;
    private Collection<TScanninggunEntity> tScanninggunsByDid;
    private Collection<TUserEntity> tUsersByDid;

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

    public Collection<TAssetsEntity> gettAssetsByDid() {
        return tAssetsByDid;
    }

    public void settAssetsByDid(Collection<TAssetsEntity> tAssetsByDid) {
        this.tAssetsByDid = tAssetsByDid;
    }

    public Collection<TScanninggunEntity> gettScanninggunsByDid() {
        return tScanninggunsByDid;
    }

    public void settScanninggunsByDid(Collection<TScanninggunEntity> tScanninggunsByDid) {
        this.tScanninggunsByDid = tScanninggunsByDid;
    }

    public Collection<TUserEntity> gettUsersByDid() {
        return tUsersByDid;
    }

    public void settUsersByDid(Collection<TUserEntity> tUsersByDid) {
        this.tUsersByDid = tUsersByDid;
    }
}
