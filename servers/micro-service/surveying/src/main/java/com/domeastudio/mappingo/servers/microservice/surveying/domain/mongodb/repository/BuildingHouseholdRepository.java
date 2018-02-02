package com.domeastudio.mappingo.servers.microservice.surveying.domain.mongodb.repository;

import com.domeastudio.mappingo.servers.microservice.surveying.domain.mongodb.pojo.BuildingHouseholdEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BuildingHouseholdRepository extends MongoRepository<BuildingHouseholdEntity,String> {
}
