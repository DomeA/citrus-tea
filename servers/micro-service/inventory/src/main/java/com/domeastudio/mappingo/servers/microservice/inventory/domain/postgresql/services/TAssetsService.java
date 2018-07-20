package com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.services;

import com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.pojo.*;

import java.math.BigDecimal;
import java.util.List;

public interface TAssetsService {
    TAssetsEntity save(String code, TAssetsinfoEntity tAssetsinfoEntity, TUserEntity tUserEntity, TAssetstypeEntity tAssetstypeEntity, TAssetsstatusEntity tAssetsstatusEntity);
    List<TAssetsEntity> findByGreaterThanPrice(BigDecimal price);
    List<TAssetsEntity> findByLessThanPrice(BigDecimal price);
    List<TAssetsEntity> findBySectionPrice(BigDecimal lessprice,BigDecimal greaterprice);
    TAssetsEntity findByCode(String code);
    Boolean updateAssetsStatus(String scanningCode,String code);
}
