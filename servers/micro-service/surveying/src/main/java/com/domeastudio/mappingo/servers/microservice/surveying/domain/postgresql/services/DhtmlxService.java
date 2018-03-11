package com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.services;

import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.TresourceEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.dto.response.DhtmlxData;

import java.io.File;
import java.io.InputStream;
import java.util.List;

public interface DhtmlxService {
    DhtmlxData getDhtmlxSidebarData();

    DhtmlxData getDhtmlxSidebarData(String useid);

    Boolean createTresource(String roleName, TresourceEntity tresourceEntity, byte[] file);

    Boolean createTresource(TresourceEntity tresourceEntity);

    TresourceEntity findByCode(String code);

    DhtmlxData getDhtmlxTreeviewData(String useid);

    DhtmlxData getDhtmlxGridData(String useid);

    DhtmlxData getResources(String pid);
}
