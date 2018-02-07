package com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.services;

import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.TgroupEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.TresourceEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.TroleEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.TuserEntity;

import java.util.List;

public interface TUserService {

    TuserEntity login(String param, String pwd);

    TuserEntity findUserOne(String id);

    TgroupEntity findGroupOne(String id);

    List<TgroupEntity> findGroupAll();

    TgroupEntity findGroupByName(String name);

    TroleEntity findRoleOne(String id);

    TresourceEntity findResourceOne(String id);

    TuserEntity findUserByName(String name);

    List<TuserEntity> findUserAll();

    TroleEntity findRoleByName(String name);

    List<TroleEntity> findRoleAll();

    TresourceEntity findResourceByName(String name);

    TuserEntity save(TuserEntity entity);

    void deleteRole(String rid);

    void deleteAllRole();

    void deleteGroup(String gid);

    void save(TroleEntity troleEntity);

    void save(TresourceEntity tresourceEntity);

    void save(TgroupEntity tgroupEntity);

    TuserEntity findByNameOrEmailOrPhone(String param);

    List<TroleEntity> findRoleByUser(TuserEntity tuserEntity);

    List<TgroupEntity> findGroupByUser(TuserEntity tuserEntity);

    List<TuserEntity> findUserByGroup(TgroupEntity tgroupEntity);

    TuserEntity createUser(String name, String pwd, String email, String phone, Boolean web, Boolean app, Boolean desktop, String mac, String equipmentid, Integer term);

    Boolean createRole(String name, String type, String describe);

    Boolean createResource(String name);
    Boolean createResource(TresourceEntity tresourceEntity);

    Boolean createGroup(String name, String type, String pid);

    Boolean allocationUserGroup(TuserEntity tuserEntity, TgroupEntity tgroupEntity);

    Boolean allocationUserRole(TuserEntity tuserEntity, TroleEntity troleEntity);

    Boolean allocationUserResource(TuserEntity tuserEntity, TresourceEntity tresourceEntity);

    Boolean allocationRoleResource(TroleEntity troleEntity, TresourceEntity tresourceEntity);
}
