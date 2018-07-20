package com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.repository;

import com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.pojo.TAssetsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TAssetsRepository extends JpaRepository<TAssetsEntity,String> {
    TAssetsEntity findByCode(String code);
}
