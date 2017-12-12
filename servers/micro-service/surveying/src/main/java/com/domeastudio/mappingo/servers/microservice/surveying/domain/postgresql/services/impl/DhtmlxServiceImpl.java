package com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.services.impl;

import com.domeastudio.mappingo.servers.microservice.surveying.domain.mongodb.pojo.SmallFileEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.mongodb.repository.SmallFileRepository;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.RroleresourceEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.RuserroleEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.TresourceEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.TuserEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.repository.*;
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
    @Autowired
    RUserResourceRepository rUserResourceRepository;
    @Autowired
    RUserRoleRepository rUserRoleRepository;
    @Autowired
    SmallFileRepository smallFileRepository;
    @Autowired
    TUserRepository tUserRepository;

    @Override
    public DhtmlxData getDhtmlxSidebarData() {

        return null;
    }

    @Override
    public DhtmlxData getDhtmlxSidebarData(String useid) {
        TuserEntity tuserEntity = tUserRepository.findOne(useid);
        if(null==tuserEntity){
            return null;
        }
        List<RuserroleEntity> ruserroleEntities=rUserRoleRepository.findByTuserByUid(tuserEntity);
        List<TresourceEntity> tresourceEntities=new ArrayList<>();
        for(RuserroleEntity ruserroleEntity:ruserroleEntities){
            List<RroleresourceEntity> rroleresourceEntities =rRoleResourceRepository.findByTroleByRid(ruserroleEntity.getTroleByRid());
            for(RroleresourceEntity rroleresourceEntity:rroleresourceEntities){
                tresourceEntities.add(rroleresourceEntity.getTresourceByReid());
            }
        }

        DhtmlxData dhtmlxData=new DhtmlxData();
        List<DhtmlxSiderbarObject> dhtmlxSiderbarObjects=new ArrayList<>();
        for(TresourceEntity tresourceEntity:tresourceEntities){
            DhtmlxSiderbarObject dhtmlxSiderbarObject=new DhtmlxSiderbarObject();
            SmallFileEntity smallFileEntity=smallFileRepository.findOne(tresourceEntity.getIconId());
            dhtmlxSiderbarObject.setIcon(smallFileEntity.getContent());
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
