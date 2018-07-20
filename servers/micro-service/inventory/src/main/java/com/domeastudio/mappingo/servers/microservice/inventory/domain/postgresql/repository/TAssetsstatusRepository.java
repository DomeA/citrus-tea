package com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.repository;

import com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.pojo.TAssetsstatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TAssetsstatusRepository extends JpaRepository<TAssetsstatusEntity,String> {
}
