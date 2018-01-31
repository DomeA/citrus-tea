package com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.repository;

import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.TresourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TResourceRepository extends JpaRepository<TresourceEntity, String> {
    TresourceEntity findByName(String name);

    TresourceEntity findByCode(String code);

    List<TresourceEntity> findByCodeContains(String code);

    List<TresourceEntity> findByParenId(String pid);
    //List<TresourceEntity> findByCodeMatchesRegex(String regex);
}
