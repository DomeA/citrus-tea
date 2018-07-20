package com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.services;

public interface TWarehouseService {
    Boolean synchronizationSave();
    Boolean update(String code);
    Boolean start();
}
