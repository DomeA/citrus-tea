package com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.repository;

import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.RgroupprocessEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RgroupprocessRepository extends JpaRepository<RgroupprocessEntity, String> {
}
