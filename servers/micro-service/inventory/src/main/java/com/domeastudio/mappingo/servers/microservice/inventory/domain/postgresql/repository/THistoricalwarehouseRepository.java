package com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.repository;

import com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.pojo.THistoricalwarehouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface THistoricalwarehouseRepository extends JpaRepository<THistoricalwarehouseEntity,String> {
}
