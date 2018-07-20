package com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "t_user", schema = "public", catalog = "invenDB")
public class TUserEntity {
    private String name;
    private String pwd;
    private String uid;
    private TDepartmentEntity tDepartmentByDid;
    private String token;
    private String salt;

    public TUserEntity() {
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



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TUserEntity that = (TUserEntity) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(pwd, that.pwd) &&
                Objects.equals(uid, that.uid) &&
                Objects.equals(tDepartmentByDid, that.tDepartmentByDid) &&
                Objects.equals(token, that.token) &&
                Objects.equals(salt, that.salt);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, pwd, uid, tDepartmentByDid,token,salt);
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
    @Column(name = "salt")
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "did", referencedColumnName = "did")
    public TDepartmentEntity gettDepartmentByDid() {
        return tDepartmentByDid;
    }
    public void settDepartmentByDid(TDepartmentEntity tDepartmentByDid) {
        this.tDepartmentByDid = tDepartmentByDid;
    }
}
