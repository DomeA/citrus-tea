package com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.repository;

import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.RroleresourceEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.TresourceEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.TroleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RRoleResourceRepository extends JpaRepository<RroleresourceEntity, String> {
    List<RroleresourceEntity> findByTroleByRid(TroleEntity troleEntity);
    RroleresourceEntity findByTroleByRidAndTresourceByReid(TroleEntity troleEntity, TresourceEntity tresourceEntity);
}
