package com.domeastudio.mappingo.servers.microservice.surveying.domain.mongodb.repository;

import com.domeastudio.mappingo.servers.microservice.surveying.domain.mongodb.pojo.BuildingLayerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BuildingLayerRepository extends MongoRepository<BuildingLayerEntity, String> {
}
