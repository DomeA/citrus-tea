package com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "t_realtimerecords", schema = "public", catalog = "invenDB")
public class TRealtimerecordsEntity {
    private String rid;
    private String aid;
    private String usetime;
    private String asid;

    @Id
    @GeneratedValue(generator = "autoid")
    @GenericGenerator(name = "autoid", strategy = "uuid")
    @Column(name = "rid")
    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
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
        TRealtimerecordsEntity that = (TRealtimerecordsEntity) o;
        return Objects.equals(rid, that.rid) &&
                Objects.equals(aid, that.aid) &&
                Objects.equals(usetime, that.usetime) &&
                Objects.equals(asid, that.asid);
    }

    @Override
    public int hashCode() {

        return Objects.hash(rid, aid, usetime, asid);
    }
}
