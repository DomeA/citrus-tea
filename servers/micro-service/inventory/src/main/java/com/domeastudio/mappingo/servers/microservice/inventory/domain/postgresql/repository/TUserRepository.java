package com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.repository;

import com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.pojo.TDepartmentEntity;
import com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.pojo.TUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TUserRepository extends JpaRepository<TUserEntity,String> {
    List<TUserEntity> findByName(String name);
    List<TUserEntity> findByTDepartmentByDid(TDepartmentEntity tDepartmentEntity);
}
