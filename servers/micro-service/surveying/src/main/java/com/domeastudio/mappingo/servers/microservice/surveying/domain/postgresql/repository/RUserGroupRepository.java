package com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.repository;

import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.RusergroupEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.TgroupEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.TuserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RUserGroupRepository extends JpaRepository<RusergroupEntity, String> {
    RusergroupEntity findByTuserByUidAndAndTgroupByGid(TuserEntity tuserEntity, TgroupEntity tgroupEntity);
}
