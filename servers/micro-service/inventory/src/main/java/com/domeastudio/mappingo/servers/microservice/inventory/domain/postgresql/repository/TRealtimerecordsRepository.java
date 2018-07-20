package com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.repository;

import com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.pojo.TRealtimerecordsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TRealtimerecordsRepository extends JpaRepository<TRealtimerecordsEntity,String> {
}
