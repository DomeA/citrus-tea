package com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "t_historicalrecords", schema = "public", catalog = "invenDB")
public class THistoricalrecordsEntity {
    private String hid;
    private String usetime;
    private TAssetsEntity tAssetsByAid;
    private TAssetsstatusEntity tAssetsstatusByAsid;

    @Id
    @GeneratedValue(generator = "autoid")
    @GenericGenerator(name = "autoid", strategy = "uuid")
    @Column(name = "hid")
    public String getHid() {
        return hid;
    }

    public void setHid(String hid) {
        this.hid = hid;
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
        THistoricalrecordsEntity that = (THistoricalrecordsEntity) o;
        return Objects.equals(hid, that.hid) &&
                Objects.equals(usetime, that.usetime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(hid, usetime);
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
