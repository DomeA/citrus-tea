package com.domeastudio.mappingo.servers.microservice.surveying.domain.mongodb.repository;

import com.domeastudio.mappingo.servers.microservice.surveying.domain.mongodb.pojo.DatumEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DatumRepository extends MongoRepository<DatumEntity,String> {
}
