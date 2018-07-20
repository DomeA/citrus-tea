package com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.repository;

import com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.pojo.TDepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TDepartmentRepository extends JpaRepository<TDepartmentEntity,String> {
    TDepartmentEntity findTDepartmentEntitiesByName(String name);
}
