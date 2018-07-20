package com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.pojo;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

public class TAssetsinfoEntity {
    private String aiid;
    private String purchasingtime;
    private BigInteger price;
    private String code;
    private Integer count;
    private Set<TAssetsEntity> tAssetsByAiid;

    public String getAiid() {
        return aiid;
    }

    public void setAiid(String aiid) {
        this.aiid = aiid;
    }

    public String getPurchasingtime() {
        return purchasingtime;
    }

    public void setPurchasingtime(String purchasingtime) {
        this.purchasingtime = purchasingtime;
    }

    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TAssetsinfoEntity that = (TAssetsinfoEntity) o;
        return Objects.equals(aiid, that.aiid) &&
                Objects.equals(purchasingtime, that.purchasingtime) &&
                Objects.equals(price, that.price) &&
                Objects.equals(code, that.code) &&
                Objects.equals(count, that.count);
    }

    @Override
    public int hashCode() {

        return Objects.hash(aiid, purchasingtime, price, code, count);
    }

    public Set<TAssetsEntity> gettAssetsByAiid() {
        return tAssetsByAiid;
    }

    public void settAssetsByAiid(Set<TAssetsEntity> tAssetsByAiid) {
        this.tAssetsByAiid = tAssetsByAiid;
    }
}
