package com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.pojo;

import java.util.Collection;
import java.util.Objects;

public class TUserEntity {
    private String name;
    private String pwd;
    private String uid;
    private String token;
    private String salt;
    private Collection<THistoricalwarehouseEntity> tHistoricalwarehousesByUid;
    private TDepartmentEntity tDepartmentByDid;
    private Collection<TWarehouseEntity> tWarehousesByUid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TUserEntity that = (TUserEntity) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(pwd, that.pwd) &&
                Objects.equals(uid, that.uid) &&
                Objects.equals(token, that.token) &&
                Objects.equals(salt, that.salt);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, pwd, uid, token, salt);
    }

    public Collection<THistoricalwarehouseEntity> gettHistoricalwarehousesByUid() {
        return tHistoricalwarehousesByUid;
    }

    public void settHistoricalwarehousesByUid(Collection<THistoricalwarehouseEntity> tHistoricalwarehousesByUid) {
        this.tHistoricalwarehousesByUid = tHistoricalwarehousesByUid;
    }

    public TDepartmentEntity gettDepartmentByDid() {
        return tDepartmentByDid;
    }

    public void settDepartmentByDid(TDepartmentEntity tDepartmentByDid) {
        this.tDepartmentByDid = tDepartmentByDid;
    }

    public Collection<TWarehouseEntity> gettWarehousesByUid() {
        return tWarehousesByUid;
    }

    public void settWarehousesByUid(Collection<TWarehouseEntity> tWarehousesByUid) {
        this.tWarehousesByUid = tWarehousesByUid;
    }
}
