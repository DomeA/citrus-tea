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
import com.domeastudio.mappingo.servers.microservice.surveying.dto.response.DhtmlxSidebarData;
import com.domeastudio.mappingo.servers.microservice.surveying.dto.response.DhtmlxSidebarObject;
import com.domeastudio.mappingo.servers.microservice.surveying.dto.response.DhtmlxTreeViewObject;
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
        List<DhtmlxSidebarObject> dhtmlxSidebarObjects =new ArrayList<>();
        for(TresourceEntity tresourceEntity:tresourceEntities){
            if(tresourceEntity.getCode().substring(5,tresourceEntity.getCode().length()).equals("0000-0000-0000-0000-0000-0000-0000-0000-0000")){
                DhtmlxSidebarObject dhtmlxSidebarObject =new DhtmlxSidebarObject();
                SmallFileEntity smallFileEntity=smallFileRepository.findOne(tresourceEntity.getIconId());
                dhtmlxSidebarObject.setIcon(smallFileEntity.getContent());
                dhtmlxSidebarObject.setId(tresourceEntity.getCode());
                dhtmlxSidebarObject.setText(tresourceEntity.getName());
                dhtmlxSidebarObject.setType(tresourceEntity.getType());
                if(null==tresourceEntity.getType()){
                    dhtmlxSidebarObject.setSelected(tresourceEntity.getSelected());
                }
                dhtmlxSidebarObjects.add(dhtmlxSidebarObject);
            }
        }
        DhtmlxSidebarData dhtmlxSidebarData=new DhtmlxSidebarData();
        dhtmlxSidebarData.setItems(dhtmlxSidebarObjects);
        dhtmlxData.setSidebarItem(dhtmlxSidebarData);
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

    @Override
    public DhtmlxData getDhtmlxTreeviewData(String useid) {
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
        List<DhtmlxTreeViewObject> dhtmlxTreeViewObjects=new ArrayList<>();
        for(TresourceEntity tresourceEntity:tresourceEntities){
            if(tresourceEntity.getCode().substring(5,tresourceEntity.getCode().length()).equals("0000-0000-0000-0000-0000-0000-0000-0000-0000")){
                DhtmlxTreeViewObject dhtmlxTreeViewObject =new DhtmlxTreeViewObject();
                //SmallFileEntity smallFileEntity=smallFileRepository.findOne(tresourceEntity.getIconId());
                //dhtmlxTreeViewObject.setIcon(smallFileEntity.getContent());
                dhtmlxTreeViewObject.setId(tresourceEntity.getCode());
                dhtmlxTreeViewObject.setText(tresourceEntity.getName());
                dhtmlxTreeViewObject.setType(tresourceEntity.getType());
                if(null==tresourceEntity.getType()){
                    dhtmlxTreeViewObject.setSelected(tresourceEntity.getSelected());
                }
                dhtmlxTreeViewObjects.add(dhtmlxTreeViewObject);
            }
        }
        dhtmlxData.setTreeItems(dhtmlxTreeViewObjects);
        return dhtmlxData;
    }
}
