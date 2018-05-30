package com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "tbusinesstype", schema = "public", catalog = "postgres")
public class TbusinesstypeEntity {
    private String btid;
    private String typeName;

    @Id
    @GeneratedValue(generator = "autoid")
    @GenericGenerator(name = "autoid", strategy = "uuid")
    @Column(name = "btid")
    public String getBtid() {
        return btid;
    }

    public void setBtid(String btid) {
        this.btid = btid;
    }

    @Basic
    @Column(name = "typename")
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TbusinesstypeEntity that = (TbusinesstypeEntity) o;

        if (btid != null ? !btid.equals(that.btid) : that.btid != null) return false;
        if (typeName != null ? !typeName.equals(that.typeName) : that.typeName != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = btid != null ? btid.hashCode() : 0;
        result = 31 * result + (typeName != null ? typeName.hashCode() : 0);
        return result;
    }
}
