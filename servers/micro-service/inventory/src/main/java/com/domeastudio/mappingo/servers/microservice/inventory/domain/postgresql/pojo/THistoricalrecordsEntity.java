package com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "t_historicalrecords", schema = "public", catalog = "invenDB")
public class THistoricalrecordsEntity {
    private String hid;
    private String aid;
    private String usetime;
    private String asid;

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

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getUsetime() {
        return usetime;
    }

    public void setUsetime(String usetime) {
        this.usetime = usetime;
    }

    public String getAsid() {
        return asid;
    }

    public void setAsid(String asid) {
        this.asid = asid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        THistoricalrecordsEntity that = (THistoricalrecordsEntity) o;
        return Objects.equals(hid, that.hid) &&
                Objects.equals(aid, that.aid) &&
                Objects.equals(usetime, that.usetime) &&
                Objects.equals(asid, that.asid);
    }

    @Override
    public int hashCode() {

        return Objects.hash(hid, aid, usetime, asid);
    }
}
