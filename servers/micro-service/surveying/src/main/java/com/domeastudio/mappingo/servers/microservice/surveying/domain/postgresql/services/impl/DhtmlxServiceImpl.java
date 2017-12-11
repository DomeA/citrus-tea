package com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.services.impl;

import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.TresourceEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.repository.RRoleResourceRepository;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.repository.TResourceRepository;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.services.DhtmlxService;
import com.domeastudio.mappingo.servers.microservice.surveying.dto.response.DhtmlxData;
import com.domeastudio.mappingo.servers.microservice.surveying.dto.response.DhtmlxSiderbarObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DhtmlxServiceImpl implements DhtmlxService {
    @Autowired
    TResourceRepository tResourceRepository;
    @Autowired
    RRoleResourceRepository rRoleResourceRepository;
    @Override
    public DhtmlxData getDhtmlxSidebarData() {

        return null;
    }

    @Override
    public DhtmlxData getDhtmlxSidebarData(String code) {
        DhtmlxData dhtmlxData=new DhtmlxData();
        List<DhtmlxSiderbarObject> dhtmlxSiderbarObjects=new ArrayList<>();
        List<TresourceEntity> tresourceEntities = tResourceRepository.findByCodeContains(code);
        for(TresourceEntity tresourceEntity:tresourceEntities){
            DhtmlxSiderbarObject dhtmlxSiderbarObject=new DhtmlxSiderbarObject();
            dhtmlxSiderbarObject.setIcon(tresourceEntity.getIcon());
            dhtmlxSiderbarObject.setId(tresourceEntity.getCode());
            dhtmlxSiderbarObject.setText(tresourceEntity.getName());
            dhtmlxSiderbarObject.setType(tresourceEntity.getType());
            if(null==tresourceEntity.getType()){
                dhtmlxSiderbarObject.setSelected(tresourceEntity.getSelected());
            }
            dhtmlxSiderbarObjects.add(dhtmlxSiderbarObject);
        }
        dhtmlxData.setItems(dhtmlxSiderbarObjects);
        return dhtmlxData;
    }

    @Override
    public Boolean createTresource(TresourceEntity tresourceEntity) {
        if(null==findByCode(tresourceEntity.getCode())){
            tResourceRepository.save(tresourceEntity);
            return true;
        }
        return false;
    }

    @Override
    public TresourceEntity findByCode(String code) {
        return tResourceRepository.findByCode(code);
    }
}
