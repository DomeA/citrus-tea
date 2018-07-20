package com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "t_warehouse", schema = "public", catalog = "invenDB")
public class TWarehouseEntity {
    private String code;
    private String wid;
    private String inventorytime;
    private Boolean isinventory;
    private Integer count;
    private TUserEntity tUserByUid;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Id
    @GeneratedValue(generator = "autoid")
    @GenericGenerator(name = "autoid", strategy = "uuid")
    @Column(name = "wid")
    public String getWid() {
        return wid;
    }

    public void setWid(String wid) {
        this.wid = wid;
    }

    public String getInventorytime() {
        return inventorytime;
    }

    public void setInventorytime(String inventorytime) {
        this.inventorytime = inventorytime;
    }

    public Boolean getIsinventory() {
        return isinventory;
    }

    public void setIsinventory(Boolean isinventory) {
        this.isinventory = isinventory;
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
        TWarehouseEntity that = (TWarehouseEntity) o;
        return Objects.equals(code, that.code) &&
                Objects.equals(wid, that.wid) &&
                Objects.equals(inventorytime, that.inventorytime) &&
                Objects.equals(isinventory, that.isinventory) &&
                Objects.equals(count, that.count);
    }

    @Override
    public int hashCode() {

        return Objects.hash(code, wid, inventorytime, isinventory, count);
    }

    public TUserEntity gettUserByUid() {
        return tUserByUid;
    }

    public void settUserByUid(TUserEntity tUserByUid) {
        this.tUserByUid = tUserByUid;
    }
}
