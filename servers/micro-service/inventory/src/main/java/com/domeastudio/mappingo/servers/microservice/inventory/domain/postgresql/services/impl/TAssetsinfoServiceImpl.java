package com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.services.impl;

import com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.pojo.TAssetsinfoEntity;
import com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.services.TAssetsinfoService;
import org.springframework.stereotype.Service;

@Service
public class TAssetsinfoServiceImpl implements TAssetsinfoService {
    @Override
    public TAssetsinfoEntity save(String code, String purchasingtime, String price) {
        return null;
    }
}
