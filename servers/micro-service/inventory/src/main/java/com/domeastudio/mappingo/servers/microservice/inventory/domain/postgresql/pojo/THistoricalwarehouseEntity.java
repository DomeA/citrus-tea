package com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.pojo;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "t_historicalwarehouse", schema = "public", catalog = "invenDB")
public class THistoricalwarehouseEntity {
    private String hwid;
    private String code;
    private String inventorytime;
    private Boolean isinventory;
    private Integer count;
    private TUserEntity tUserByUid;

    public String getHwid() {
        return hwid;
    }

    public void setHwid(String hwid) {
        this.hwid = hwid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
        THistoricalwarehouseEntity that = (THistoricalwarehouseEntity) o;
        return Objects.equals(hwid, that.hwid) &&
                Objects.equals(code, that.code) &&
                Objects.equals(inventorytime, that.inventorytime) &&
                Objects.equals(isinventory, that.isinventory) &&
                Objects.equals(count, that.count);
    }

    @Override
    public int hashCode() {

        return Objects.hash(hwid, code, inventorytime, isinventory, count);
    }

    public TUserEntity gettUserByUid() {
        return tUserByUid;
    }

    public void settUserByUid(TUserEntity tUserByUid) {
        this.tUserByUid = tUserByUid;
    }
}
