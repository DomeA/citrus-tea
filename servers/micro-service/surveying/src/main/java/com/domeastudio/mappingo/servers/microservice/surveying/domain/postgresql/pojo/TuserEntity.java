package com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tuser", schema = "public", catalog = "postgres")
public class TuserEntity {
    private String uid;
    private String name;
    private String pwd;
    private String email;
    private String phone;
    private String mac;
    private Boolean desktop;
    private Boolean web;
    private Boolean app;
    private String equipmentid;
    private String salt;
    private String token;
    private Integer authorTime;
    private String registTime;
    private Boolean isDelete;
//    private String processIds;
    private Set<RuserresourceEntity> ruserresourcesByUid;
    private Set<RuserroleEntity> ruserrolesByUid;
    private Set<RusergroupEntity> rusergroupsByUid;
    private Set<BapprovalrecordEntity> bapprovalrecordsByUid;
    private TuserinfoEntity tuserinfoByUiid;

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

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "pwd")
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "isdelete")
    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TuserEntity that = (TuserEntity) o;

        if (uid != null ? !uid.equals(that.uid) : that.uid != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (pwd != null ? !pwd.equals(that.pwd) : that.pwd != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (tuserinfoByUiid != null ? !tuserinfoByUiid.equals(that.tuserinfoByUiid) : that.tuserinfoByUiid != null)
            return false;
        if (token != null ? !token.equals(that.token) : that.token != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (salt != null ? !salt.equals(that.salt) : that.salt != null) return false;
        if (authorTime != null ? !authorTime.equals(that.authorTime) : that.authorTime != null) return false;
        if (registTime != null ? !registTime.equals(that.registTime) : that.registTime != null) return false;
        if (web != null ? !web.equals(that.web) : that.web != null) return false;
        if (app != null ? !app.equals(that.app) : that.app != null) return false;
        if (mac != null ? !mac.equals(that.mac) : that.mac != null) return false;
        if (desktop != null ? !desktop.equals(that.desktop) : that.desktop != null) return false;
        if (equipmentid != null ? !equipmentid.equals(that.equipmentid) : that.equipmentid != null) return false;
        if (isDelete != null ? !isDelete.equals(that.isDelete) : that.isDelete != null) return false;
//        if (processIds != null ? !processIds.equals(that.processIds) : that.processIds != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = uid != null ? uid.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (pwd != null ? pwd.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (tuserinfoByUiid != null ? tuserinfoByUiid.hashCode() : 0);
        result = 31 * result + (token != null ? token.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (salt != null ? salt.hashCode() : 0);
        result = 31 * result + (authorTime != null ? authorTime.hashCode() : 0);
        result = 31 * result + (registTime != null ? registTime.hashCode() : 0);
        result = 31 * result + (web != null ? web.hashCode() : 0);
        result = 31 * result + (app != null ? app.hashCode() : 0);
        result = 31 * result + (desktop != null ? desktop.hashCode() : 0);
        result = 31 * result + (mac != null ? mac.hashCode() : 0);
        result = 31 * result + (equipmentid != null ? equipmentid.hashCode() : 0);
        result = 31 * result + (isDelete != null ? isDelete.hashCode() : 0);
//        result = 31 * result + (processIds != null ? processIds.hashCode() : 0);

        return result;
    }

    @OneToMany(mappedBy = "tuserByUid", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    public Set<RuserresourceEntity> getRuserresourcesByUid() {
        return ruserresourcesByUid;
    }

    public void setRuserresourcesByUid(Set<RuserresourceEntity> ruserresourcesByUid) {
        this.ruserresourcesByUid = ruserresourcesByUid;
    }

    @OneToMany(mappedBy = "tuserByUid", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    public Set<RuserroleEntity> getRuserrolesByUid() {
        return ruserrolesByUid;
    }

    public void setRuserrolesByUid(Set<RuserroleEntity> ruserrolesByUid) {
        this.ruserrolesByUid = ruserrolesByUid;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "uiid")
    public TuserinfoEntity getTuserinfoByUiid() {
        return tuserinfoByUiid;
    }

    public void setTuserinfoByUiid(TuserinfoEntity tuserinfoByUiid) {
        this.tuserinfoByUiid = tuserinfoByUiid;
    }

    @Basic
    @Column(name = "phone", length = 11)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "salt")
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Basic
    @Column(name = "token")
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Basic
    @Column(name = "authorTime")
    public Integer getAuthorTime() {
        return authorTime;
    }

    public void setAuthorTime(Integer authorTime) {
        this.authorTime = authorTime;
    }

    @Basic
    @Column(name = "registTime")
    public String getRegistTime() {
        return registTime;
    }

    public void setRegistTime(String registTime) {
        this.registTime = registTime;
    }

    @OneToMany(mappedBy = "tuserByUid", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    public Set<RusergroupEntity> getRusergroupsByUid() {
        return rusergroupsByUid;
    }

    public void setRusergroupsByUid(Set<RusergroupEntity> rusergroupsByUid) {
        this.rusergroupsByUid = rusergroupsByUid;
    }

    @OneToMany(mappedBy = "tuserByUid", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    public Set<BapprovalrecordEntity> getBapprovalrecordsByUid() {
        return bapprovalrecordsByUid;
    }

    public void setBapprovalrecordsByUid(Set<BapprovalrecordEntity> bapprovalrecordsByUid) {
        this.bapprovalrecordsByUid = bapprovalrecordsByUid;
    }

    @Basic
    @Column(name = "mac")
    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    @Basic
    @Column(name = "desktop")
    public Boolean getDesktop() {
        return desktop;
    }

    public void setDesktop(Boolean desktop) {
        this.desktop = desktop;
    }

    @Basic
    @Column(name = "web")
    public Boolean getWeb() {
        return web;
    }

    public void setWeb(Boolean web) {
        this.web = web;
    }

    @Basic
    @Column(name = "app")
    public Boolean getApp() {
        return app;
    }

    public void setApp(Boolean app) {
        this.app = app;
    }

    @Basic
    @Column(name = "equipmentid")
    public String getEquipmentid() {
        return equipmentid;
    }

    public void setEquipmentid(String equipmentid) {
        this.equipmentid = equipmentid;
    }

//    @Basic
//    @Column(name = "processIds")
//    public String getProcessIds() {
//        return processIds;
//    }
//
//    public void setProcessIds(String processIds) {
//        this.processIds = processIds;
//    }
}
