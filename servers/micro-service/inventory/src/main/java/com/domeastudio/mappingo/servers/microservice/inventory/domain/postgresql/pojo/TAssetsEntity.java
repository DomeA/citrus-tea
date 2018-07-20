package com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "t_assets", schema = "public", catalog = "invenDB")
public class TAssetsEntity {
    private String aid;
    private String code;
    private TUserEntity tUserEntityByAid;
    private TAssetstypeEntity tAssetstypeEntityByAid;
    private TAssetsstatusEntity tAssetsstatusEntityByAid;
    private TAssetsinfoEntity tAssetsinfoEntityByAid;

    @Id
    @GeneratedValue(generator = "autoid")
    @GenericGenerator(name = "autoid", strategy = "uuid")
    @Column(name = "aid")
    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    @Basic
    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TAssetsEntity that = (TAssetsEntity) o;
        return Objects.equals(aid, that.aid) &&
                Objects.equals(code, that.code) &&
                Objects.equals(tUserEntityByAid, that.tUserEntityByAid) &&
                Objects.equals(tAssetstypeEntityByAid, that.tAssetstypeEntityByAid) &&
                Objects.equals(tAssetsstatusEntityByAid, that.tAssetsstatusEntityByAid);
    }

    @Override
    public int hashCode() {

        return Objects.hash(aid, code, tUserEntityByAid, tAssetstypeEntityByAid, tAssetsstatusEntityByAid);
    }

    public TUserEntity gettUserEntityByAid() {
        return tUserEntityByAid;
    }

    public void settUserEntityByAid(TUserEntity tUserEntityByAid) {
        this.tUserEntityByAid = tUserEntityByAid;
    }

    public TAssetstypeEntity gettAssetstypeEntityByAid() {
        return tAssetstypeEntityByAid;
    }

    public void settAssetstypeEntityByAid(TAssetstypeEntity tAssetstypeEntityByAid) {
        this.tAssetstypeEntityByAid = tAssetstypeEntityByAid;
    }

    public TAssetsstatusEntity gettAssetsstatusEntityByAid() {
        return tAssetsstatusEntityByAid;
    }

    public void settAssetsstatusEntityByAid(TAssetsstatusEntity tAssetsstatusEntityByAid) {
        this.tAssetsstatusEntityByAid = tAssetsstatusEntityByAid;
    }
}
