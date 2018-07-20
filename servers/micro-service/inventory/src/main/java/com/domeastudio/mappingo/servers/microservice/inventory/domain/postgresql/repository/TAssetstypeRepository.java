package com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.repository;

import com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.pojo.TAssetstypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TAssetstypeRepository extends JpaRepository<TAssetstypeEntity,String> {
}
