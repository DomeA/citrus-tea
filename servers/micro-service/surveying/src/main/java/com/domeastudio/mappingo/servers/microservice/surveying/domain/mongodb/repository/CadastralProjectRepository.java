package com.domeastudio.mappingo.servers.microservice.surveying.domain.mongodb.repository;

import com.domeastudio.mappingo.servers.microservice.surveying.domain.mongodb.pojo.CadastralProjectEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CadastralProjectRepository extends MongoRepository<CadastralProjectEntity, String> {
}
