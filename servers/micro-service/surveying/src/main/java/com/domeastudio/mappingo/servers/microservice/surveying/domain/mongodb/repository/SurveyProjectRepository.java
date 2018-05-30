package com.domeastudio.mappingo.servers.microservice.surveying.domain.mongodb.repository;

import com.domeastudio.mappingo.servers.microservice.surveying.domain.mongodb.pojo.SurveyProjectEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SurveyProjectRepository extends MongoRepository<SurveyProjectEntity, String> {
}
