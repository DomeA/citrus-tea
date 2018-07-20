package com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "t_assetsinfo", schema = "public", catalog = "invenDB")
public class TAssetsinfoEntity {
    private String aiid;
    private String purchasingtime;
    private BigDecimal price;
    private String code;
    private Integer count;
    private String name;
    private TAssetsEntity tAssetsByAiid;

    @Id
    @GeneratedValue(generator = "autoid")
    @GenericGenerator(name = "autoid", strategy = "uuid")
    @Column(name = "aiid")
    public String getAiid() {
        return aiid;
    }

    public void setAiid(String aiid) {
        this.aiid = aiid;
    }

    @Basic
    @Column(name = "purchasingtime")
    public String getPurchasingtime() {
        return purchasingtime;
    }

    public void setPurchasingtime(String purchasingtime) {
        this.purchasingtime = purchasingtime;
    }

    @Basic
    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "count")
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
                Objects.equals(count, that.count)&&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(aiid, purchasingtime, price, code, count,name);
    }

    @OneToOne(mappedBy = "tAssetsinfoByAiid", fetch = FetchType.LAZY)
    public TAssetsEntity gettAssetsByAiid() {
        return tAssetsByAiid;
    }

    public void settAssetsByAiid(TAssetsEntity tAssetsByAiid) {
        this.tAssetsByAiid = tAssetsByAiid;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
