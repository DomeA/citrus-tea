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

    TgroupEntity findGroupByName(String name);

    TroleEntity findRoleOne(String id);

    TresourceEntity findResourceOne(String id);

    TuserEntity findUserByName(String name);

    TroleEntity findRoleByName(String name);

    TresourceEntity findResourceByName(String name);

    void save(TuserEntity entity);

    void save(TroleEntity troleEntity);

    void save(TresourceEntity tresourceEntity);

    void save(TgroupEntity tgroupEntity);

    TuserEntity findByNameOrEmailOrPhone(String param);

    List<String> findRoleByUser(TuserEntity entity);

    Boolean createUser(String name, String pwd, String email, String phone, Boolean web, Boolean app, Boolean desktop, String mac, String equipmentid, Integer term);

    Boolean createRole(String name, String type, String describe);

    Boolean createResource(String name);

    Boolean createGroup(String name, String type, String pid);

    Boolean createGroup(String name, String type, String pid, String processids);

    Boolean allocationUserGroup(TuserEntity tuserEntity, TgroupEntity tgroupEntity);

    Boolean allocationUserRole(TuserEntity tuserEntity, TroleEntity troleEntity);

    Boolean allocationUserResource(TuserEntity tuserEntity, TresourceEntity tresourceEntity);

    Boolean allocationRoleResource(TroleEntity troleEntity, TresourceEntity tresourceEntity);
}
