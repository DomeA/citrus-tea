package com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.services;

import com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.pojo.TAssetsinfoEntity;

public interface TAssetsinfoService {
    TAssetsinfoEntity save(String code, String purchasingtime, String price);
}
