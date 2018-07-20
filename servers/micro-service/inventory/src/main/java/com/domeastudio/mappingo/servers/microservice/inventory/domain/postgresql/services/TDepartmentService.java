package com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.services;

import com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.pojo.TDepartmentEntity;

import java.util.List;

public interface TDepartmentService {
    TDepartmentEntity save(String name);
    List<TDepartmentEntity> findAll();
    TDepartmentEntity findByName(String name);
    TDepartmentEntity delete(String name);
    TDepartmentEntity update(String name);
}
