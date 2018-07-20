package com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.repository;

import com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.pojo.THistoricalrecordsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface THistoricalrecordsRepository extends JpaRepository<THistoricalrecordsEntity,String> {
}
