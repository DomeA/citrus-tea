package com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.services.impl;

import com.domeastudio.mappingo.servers.microservice.surveying.domain.mongodb.pojo.SmallFileEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.mongodb.repository.SmallFileRepository;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.*;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.repository.*;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.services.DhtmlxService;
import com.domeastudio.mappingo.servers.microservice.surveying.dto.response.*;
import com.domeastudio.mappingo.servers.microservice.surveying.util.FileUtils;
import com.domeastudio.mappingo.servers.microservice.surveying.util.security.MD5SHAHelper;
import com.domeastudio.mappingo.servers.microservice.surveying.util.tree.TreeParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
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
    @Autowired
    TRoleRepository tRoleRepository;

    @Override
    public DhtmlxData getDhtmlxSidebarData() {

        return null;
    }

    private List<TresourceEntity> getResourceEntitiesByUseid(String useid) {
        TuserEntity tuserEntity = tUserRepository.findOne(useid);
        if (null == tuserEntity) {
            return null;
        }
        List<TresourceEntity> tresourceEntitiesRoot = new ArrayList<>();
        for (RuserroleEntity ruserroleEntity : tuserEntity.getRuserrolesByUid()) {
            Iterator<RroleresourceEntity> rroleresourceEntityIterable = ruserroleEntity.getTroleByRid().getRroleresourcesByRid().iterator();
            while (rroleresourceEntityIterable.hasNext()) {
                RroleresourceEntity rroleresourceEntity = rroleresourceEntityIterable.next();
                tresourceEntitiesRoot.add(rroleresourceEntity.getTresourceByReid());
            }
        }
        return tresourceEntitiesRoot;
    }

    @Override
    public DhtmlxData getDhtmlxSidebarData(String useid) {
        List<TresourceEntity> tresourceEntitiesRoot = getResourceEntitiesByUseid(useid);

        DhtmlxData dhtmlxData = new DhtmlxData();
        List<DhtmlxSidebarObject> dhtmlxSidebarObjects = new ArrayList<>();
        for (TresourceEntity tresourceEntity : tresourceEntitiesRoot) {
            if (tresourceEntity.getCode().substring(5, tresourceEntity.getCode().length()).equals("0000-0000-0000-0000-0000-0000-0000-0000-0000")) {
                DhtmlxSidebarObject dhtmlxSidebarObject = new DhtmlxSidebarObject();
                SmallFileEntity smallFileEntity = smallFileRepository.findOne(tresourceEntity.getIconId());
                dhtmlxSidebarObject.setIcon(smallFileEntity.getContent());
                dhtmlxSidebarObject.setId(tresourceEntity.getReid());
                dhtmlxSidebarObject.setCode(tresourceEntity.getCode());
                dhtmlxSidebarObject.setText(tresourceEntity.getName());
                dhtmlxSidebarObject.setType(tresourceEntity.getType());
                dhtmlxSidebarObject.setSelected(tresourceEntity.getSelected());
                if (null == tresourceEntity.getType()) {
                    dhtmlxSidebarObject.setSelected(tresourceEntity.getSelected());
                }
                dhtmlxSidebarObjects.add(dhtmlxSidebarObject);
            }
        }
        DhtmlxSidebarData dhtmlxSidebarData = new DhtmlxSidebarData();
        dhtmlxSidebarData.setItems(dhtmlxSidebarObjects);
        dhtmlxData.setSidebarItem(dhtmlxSidebarData);
        return dhtmlxData;
    }

    @Override
    public Boolean createTresource(String roleName, TresourceEntity tresourceEntity, byte[] file) {
        if (null == findByCode(tresourceEntity.getCode())) {
            TresourceEntity tresource = tResourceRepository.save(tresourceEntity);
            TroleEntity troleEntity = tRoleRepository.findByName(roleName);
            if (troleEntity == null) {
                return false;
            }
            SmallFileEntity smallFileEntity = new SmallFileEntity();
            smallFileEntity.setName("菜单注册图标");
            smallFileEntity.setContentType("image/png");
            smallFileEntity.setContent(file);
            smallFileEntity.setMd5(MD5SHAHelper.toString(MD5SHAHelper.encryptByMD5(file)));
            smallFileEntity = smallFileRepository.save(smallFileEntity);

            tresourceEntity.setIconId(smallFileEntity.getId());
            RroleresourceEntity rroleresourceEntity = new RroleresourceEntity();
            rroleresourceEntity.setTresourceByReid(tresource);
            rroleresourceEntity.setTroleByRid(troleEntity);
            rRoleResourceRepository.save(rroleresourceEntity);
            return true;
        }
        return false;
    }

    @Override
    public Boolean createTresource(TresourceEntity tresourceEntity) {
        if (null == findByCode(tresourceEntity.getCode())) {
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
        List<TresourceEntity> tresourceEntitiesRoot = getResourceEntitiesByUseid(useid);
        DhtmlxData dhtmlxData = new DhtmlxData();
        List<DhtmlxTreeViewObject> dhtmlxTreeViewObjects = new ArrayList<>();
        //没有根
        if (tresourceEntitiesRoot.size() < 1) {
            return null;
        }
        for (TresourceEntity tresourceEntity : tresourceEntitiesRoot) {
            DhtmlxTreeViewObject dhtmlxTreeViewObject = new DhtmlxTreeViewObject();
            dhtmlxTreeViewObject.setCode(tresourceEntity.getCode());
            dhtmlxTreeViewObject.setParentId(tresourceEntity.getParenId());
            dhtmlxTreeViewObject.setId(tresourceEntity.getReid());
            dhtmlxTreeViewObject.setText(tresourceEntity.getName());
            dhtmlxTreeViewObject.setType(tresourceEntity.getType());
            dhtmlxTreeViewObjects.add(dhtmlxTreeViewObject);
        }
        dhtmlxData.setTreeItem(TreeParser.getTreeList("0", dhtmlxTreeViewObjects));
        return dhtmlxData;
    }

    @Override
    public DhtmlxData getDhtmlxGridData(String useid) {
        TuserEntity tuserEntity = tUserRepository.findOne(useid);

        if (null == tuserEntity) {
            return null;
        }
        //1c
        DhtmlxGridHeadObject dhtmlxGridHeadObject = new DhtmlxGridHeadObject();
        DhtmlxGridRowObject dhtmlxGridRowObject = new DhtmlxGridRowObject();

        dhtmlxGridHeadObject.setValue("序号");
        dhtmlxGridHeadObject.setAlign("right");
        dhtmlxGridHeadObject.setWidth(70);
        //2c
        DhtmlxGridHeadObject dhtmlxGridHeadObject1 = new DhtmlxGridHeadObject();
        DhtmlxGridRowObject dhtmlxGridRowObject1 = new DhtmlxGridRowObject();

        dhtmlxGridHeadObject1.setValue("用户名");
        dhtmlxGridHeadObject1.setAlign("right");
        dhtmlxGridHeadObject1.setWidth(70);

        //3c
        DhtmlxGridHeadObject dhtmlxGridHeadObject2 = new DhtmlxGridHeadObject();
        DhtmlxGridRowObject dhtmlxGridRowObject2 = new DhtmlxGridRowObject();

        dhtmlxGridHeadObject2.setValue("菜单名称");
        dhtmlxGridHeadObject2.setAlign("right");
        dhtmlxGridHeadObject2.setWidth(70);


        //4c
        DhtmlxGridHeadObject dhtmlxGridHeadObject3 = new DhtmlxGridHeadObject();
        DhtmlxGridRowObject dhtmlxGridRowObject3 = new DhtmlxGridRowObject();

        dhtmlxGridHeadObject3.setValue("菜单级数");
        dhtmlxGridHeadObject3.setAlign("left");
        dhtmlxGridHeadObject3.setWidth(70);

        //5c
        DhtmlxGridHeadObject dhtmlxGridHeadObject4 = new DhtmlxGridHeadObject();
        DhtmlxGridRowObject dhtmlxGridRowObject4 = new DhtmlxGridRowObject();

        dhtmlxGridHeadObject4.setValue("图标");
        dhtmlxGridHeadObject4.setAlign("left");
        dhtmlxGridHeadObject4.setWidth(70);
        dhtmlxGridHeadObject4.setType("img");
        //6c
        DhtmlxGridHeadObject dhtmlxGridHeadObject5 = new DhtmlxGridHeadObject();
        DhtmlxGridRowObject dhtmlxGridRowObject5 = new DhtmlxGridRowObject();

        dhtmlxGridHeadObject5.setValue("用户名");
        dhtmlxGridHeadObject5.setAlign("left");
        dhtmlxGridHeadObject5.setWidth(70);
        //7c
        DhtmlxGridHeadObject dhtmlxGridHeadObject6 = new DhtmlxGridHeadObject();
        DhtmlxGridRowObject dhtmlxGridRowObject6 = new DhtmlxGridRowObject();

        dhtmlxGridHeadObject6.setValue("用户名");
        dhtmlxGridHeadObject6.setAlign("left");
        dhtmlxGridHeadObject6.setWidth(70);

        DhtmlxData dhtmlxData = new DhtmlxData();
        List<DhtmlxGridHeadObject> dhtmlxGridHeadObjects = new ArrayList<>();

        List<TresourceEntity> tresourceEntitiesRoot = getResourceEntitiesByUseid(useid);
        return null;
    }

    @Override
    public DhtmlxData getResources(String pid) {
        List<TresourceEntity> tresourceEntities=tResourceRepository.findByParenId(pid);
        DhtmlxData dhtmlxData=new DhtmlxData();
        if(tresourceEntities.size()<1){
            return null;
        }
        List<DhtmlxToolbarObject> dhtmlxToolbarObjects=new ArrayList<>();
        DhtmlxToolbarData dhtmlxToolbarData=new DhtmlxToolbarData();
        for(TresourceEntity tresourceEntity:tresourceEntities){
            DhtmlxToolbarObject dhtmlxToolbarObject=new DhtmlxToolbarObject();
            dhtmlxToolbarObject.setId(tresourceEntity.getReid());
            dhtmlxToolbarObject.setText(tresourceEntity.getName());
            dhtmlxToolbarObject.setType(tresourceEntity.getType());
            dhtmlxToolbarObject.setWidth(tresourceEntity.getWidth());
            dhtmlxToolbarObject.setTitle(tresourceEntity.getName());
            dhtmlxToolbarObjects.add(dhtmlxToolbarObject);
        }
        dhtmlxToolbarData.setItems(dhtmlxToolbarObjects);
        dhtmlxData.setToolbarItem(dhtmlxToolbarData);
        return dhtmlxData;
    }
}
