package com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.services;

import com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.pojo.TAssetsstatusEntity;

import java.util.List;

public interface TAssetsstatusService {
    TAssetsstatusEntity save(String name);
    TAssetsstatusEntity update(String oldName,String newName);
    TAssetsstatusEntity delete(String name);
    List<TAssetsstatusEntity> findAll();
    TAssetsstatusEntity findByName(String name);
}
