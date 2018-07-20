package com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.services;


import com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.pojo.TDepartmentEntity;
import com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.pojo.TUserEntity;

import java.util.List;

public interface TUserService {
    TUserEntity save(String name, String pwd, TDepartmentEntity tDepartmentEntity);
    List<TUserEntity> findAll();
    List<TUserEntity> findByName(String name);
    List<TUserEntity> findByDepartment(TDepartmentEntity tDepartmentEntity);
}
