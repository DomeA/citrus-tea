package com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.services;

import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.TresourceEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.dto.response.DhtmlxData;

public interface DhtmlxService {
    DhtmlxData getDhtmlxSidebarData();
    DhtmlxData getDhtmlxSidebarData(String code);
    Boolean createTresource(TresourceEntity tresourceEntity);
    TresourceEntity findByCode(String code);
}
