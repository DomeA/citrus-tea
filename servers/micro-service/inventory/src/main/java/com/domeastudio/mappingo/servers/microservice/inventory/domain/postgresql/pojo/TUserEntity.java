package com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "t_user", schema = "public", catalog = "invenDB")
public class TUserEntity {
    private String name;
    private String pwd;
    private String uid;
    private String token;
    private String salt;
    private Set<TAssetsEntity> tAssetsByUid;
    private Set<THistoricalwarehouseEntity> tHistoricalwarehousesByUid;
    private TDepartmentEntity tDepartmentByDid;
    private Set<TWarehouseEntity> tWarehousesByUid;

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

    @Id
    @GeneratedValue(generator = "autoid")
    @GenericGenerator(name = "autoid", strategy = "uuid")
    @Column(name = "uid")
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

    public Set<TAssetsEntity> gettAssetsByUid() {
        return tAssetsByUid;
    }

    public void settAssetsByUid(Set<TAssetsEntity> tAssetsByUid) {
        this.tAssetsByUid = tAssetsByUid;
    }

    public Set<THistoricalwarehouseEntity> gettHistoricalwarehousesByUid() {
        return tHistoricalwarehousesByUid;
    }

    public void settHistoricalwarehousesByUid(Set<THistoricalwarehouseEntity> tHistoricalwarehousesByUid) {
        this.tHistoricalwarehousesByUid = tHistoricalwarehousesByUid;
    }

    public TDepartmentEntity gettDepartmentByDid() {
        return tDepartmentByDid;
    }

    public void settDepartmentByDid(TDepartmentEntity tDepartmentByDid) {
        this.tDepartmentByDid = tDepartmentByDid;
    }

    public Set<TWarehouseEntity> gettWarehousesByUid() {
        return tWarehousesByUid;
    }

    public void settWarehousesByUid(Set<TWarehouseEntity> tWarehousesByUid) {
        this.tWarehousesByUid = tWarehousesByUid;
    }
}
