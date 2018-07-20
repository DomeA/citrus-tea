package com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.repository;

import com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.pojo.TWarehouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TWarehouseRepository extends JpaRepository<TWarehouseEntity,String> {
    TWarehouseEntity findByCode(String code);
}
