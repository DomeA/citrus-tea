package com.domeastudio.mappingo.servers.microservice.surveying.domain.mongodb.repository;

import com.domeastudio.mappingo.servers.microservice.surveying.domain.mongodb.pojo.SmallFileEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmallFileRepository extends MongoRepository<SmallFileEntity, String> {

    SmallFileEntity findByMd5(String md5);
}
