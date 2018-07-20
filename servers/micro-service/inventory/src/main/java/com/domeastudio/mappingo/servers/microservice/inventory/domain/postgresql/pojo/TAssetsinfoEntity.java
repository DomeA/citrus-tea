package com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "t_assetsinfo", schema = "public", catalog = "invenDB")
public class TAssetsinfoEntity {
    private String aiid;
    private String code;
    private String purchasingtime;
    private BigDecimal price;
    private TAssetsEntity tAssetsEntityByAiid;

    @Id
    @GeneratedValue(generator = "autoid")
    @GenericGenerator(name = "autoid", strategy = "uuid")
    @Column(name = "aiid")
    public String getAid() {
        return aiid;
    }

    public void setAid(String aiid) {
        this.aiid = aiid;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TAssetsinfoEntity that = (TAssetsinfoEntity) o;
        return Objects.equals(aiid, that.aiid) &&
                Objects.equals(code, that.code) &&
                Objects.equals(purchasingtime, that.purchasingtime) &&
                Objects.equals(price, that.price) &&
                Objects.equals(tAssetsEntityByAiid, that.tAssetsEntityByAiid);
    }

    @Override
    public int hashCode() {

        return Objects.hash(aiid, code, purchasingtime, price, tAssetsEntityByAiid);
    }
}
