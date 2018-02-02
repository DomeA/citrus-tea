package com.domeastudio.mappingo.servers.microservice.surveying.domain.mongodb.repository;

import com.domeastudio.mappingo.servers.microservice.surveying.domain.mongodb.pojo.BuildingProjectEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BuildingProjectRepository extends MongoRepository<BuildingProjectEntity,String> {
}
