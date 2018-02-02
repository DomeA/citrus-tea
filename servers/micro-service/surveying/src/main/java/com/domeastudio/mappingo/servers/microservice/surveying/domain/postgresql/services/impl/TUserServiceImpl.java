package com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.services.impl;

import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.*;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.repository.*;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.services.TUserService;
import com.domeastudio.mappingo.servers.microservice.surveying.util.DateUtil;
import com.domeastudio.mappingo.servers.microservice.surveying.util.security.MD5SHAHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class TUserServiceImpl implements TUserService {
    @Autowired
    TUserRepository tUserRepository;
    @Autowired
    TRoleRepository tRoleRepository;
    @Autowired
    TResourceRepository tResourceRepository;
    @Autowired
    RUserRoleRepository rUserRoleRepository;
    @Autowired
    TGroupRepository tGroupRepository;
    @Autowired
    RUserGroupRepository rUserGroupRepository;
    @Autowired
    RUserResourceRepository rUserResourceRepository;
    @Autowired
    RRoleResourceRepository rRoleResourceRepository;


    @Override
    public TuserEntity login(String param, String pwd) {
        TuserEntity tuserEntity = null;

        tuserEntity = findByNameOrEmailOrPhone(param);
        if (tuserEntity == null) {
            return null;
        } else {

            String md5Password = MD5SHAHelper.toString(MD5SHAHelper.encryptByMD5((pwd + tuserEntity.getSalt()).getBytes()));
            if (md5Password.compareTo(tuserEntity.getPwd()) != 0) {
                return null;
            }
            return tuserEntity;
        }
    }

    @Override
    public TuserEntity findUserOne(String id) {
        return tUserRepository.findOne(id);
    }

    @Override
    public TgroupEntity findGroupOne(String id) {
        return tGroupRepository.findOne(id);
    }

    @Override
    public List<TgroupEntity> findGroupAll() {
        return tGroupRepository.findAll();
    }

    @Override
    public TgroupEntity findGroupByName(String name) {
        return tGroupRepository.findByName(name);
    }

    @Override
    public TroleEntity findRoleOne(String id) {
        return tRoleRepository.findOne(id);
    }

    @Override
    public TresourceEntity findResourceOne(String id) {
        return tResourceRepository.findOne(id);
    }

    @Override
    public TuserEntity findUserByName(String name) {
        return tUserRepository.findByName(name);
    }

    @Override
    public List<TuserEntity> findUserAll() {
        return tUserRepository.findAll();
    }

    @Override
    public TroleEntity findRoleByName(String name) {
        return tRoleRepository.findByName(name);
    }

    @Override
    public List<TroleEntity> findRoleAll() {
        return tRoleRepository.findAll();
    }

    @Override
    public TresourceEntity findResourceByName(String name) {
        return tResourceRepository.findByName(name);
    }

    @Override
    public TuserEntity save(TuserEntity entity) {
        return tUserRepository.save(entity);
    }

    @Override
    public void deleteRole(String rid) {
        TroleEntity troleEntity = tRoleRepository.findOne(rid);
        List<RuserroleEntity> ruserroleEntities = rUserRoleRepository.findByTroleByRid(troleEntity);
        for (RuserroleEntity ruserroleEntity : ruserroleEntities) {
            rUserRoleRepository.delete(ruserroleEntity.getId());
        }
        List<RroleresourceEntity> rroleresourceEntities = rRoleResourceRepository.findByTroleByRid(troleEntity);
        for (RroleresourceEntity rroleresourceEntity : rroleresourceEntities) {
            rRoleResourceRepository.delete(rroleresourceEntity.getId());
        }
        tRoleRepository.delete(rid);
    }

    @Override
    public void deleteAllRole() {
        rUserRoleRepository.deleteAll();
        rRoleResourceRepository.deleteAll();
        tRoleRepository.deleteAll();
    }

    @Override
    public void deleteGroup(String gid) {
        TgroupEntity tgroupEntity=tGroupRepository.findOne(gid);
        List<RusergroupEntity> rusergroupEntities=rUserGroupRepository.findByTgroupByGid(tgroupEntity);

        for(RusergroupEntity rusergroupEntity : rusergroupEntities){
            rUserGroupRepository.delete(rusergroupEntity.getId());
        }
        tGroupRepository.delete(gid);
    }

    @Override
    public void save(TroleEntity troleEntity) {
        tRoleRepository.save(troleEntity);
    }

    @Override
    public void save(TresourceEntity tresourceEntity) {
        tResourceRepository.save(tresourceEntity);
    }

    @Override
    public void save(TgroupEntity tgroupEntity) {
        tGroupRepository.save(tgroupEntity);
    }

    @Override
    public TuserEntity findByNameOrEmailOrPhone(String param) {
        TuserEntity tuserEntity = null;
        tuserEntity = tUserRepository.findByName(param);
        if (tuserEntity == null) {
            tuserEntity = tUserRepository.findByPhone(param);
            if (tuserEntity == null) {
                tuserEntity = tUserRepository.findByEmail(param);
                if (tuserEntity == null) {
                    return null;
                }
            }
        }
        return tuserEntity;
    }

    @Override
    public List<TroleEntity> findRoleByUser(TuserEntity tuserEntity) {
        List<TroleEntity> roles = new ArrayList<>();
        List<RuserroleEntity> ruserroleEntities = rUserRoleRepository.findByTuserByUid(tuserEntity);
        for (RuserroleEntity rr : ruserroleEntities) {
            TroleEntity name = rr.getTroleByRid();
            roles.add(name);
        }
        return roles;
    }

    @Override
    public List<TgroupEntity> findGroupByUser(TuserEntity tuserEntity) {
        List<TgroupEntity> groups = new ArrayList<>();
        List<RusergroupEntity> rusergroupEntities = rUserGroupRepository.findByTuserByUid(tuserEntity);
        for (RusergroupEntity ug : rusergroupEntities) {
            TgroupEntity tgroupEntity = ug.getTgroupByGid();
            groups.add(tgroupEntity);
        }
        return groups;
    }

    @Override
    public List<TuserEntity> findUserByGroup(TgroupEntity tgroupEntity) {
        List<RusergroupEntity> rusergroupEntities = rUserGroupRepository.findByTgroupByGid(tgroupEntity);
        if(rusergroupEntities.size()>0){
            List<TuserEntity> tuserEntities=new ArrayList<>();
            for(RusergroupEntity rusergroupEntity :rusergroupEntities){
                tuserEntities.add(rusergroupEntity.getTuserByUid());
            }
            return tuserEntities;
        }
        return null;
    }

    @Override
    public TuserEntity createUser(String loginName, String pwd, String email, String phone, Boolean web, Boolean app, Boolean desktop, String mac, String equipmentid, Integer term) {
        if (tUserRepository.findByName(loginName) != null ||
                tUserRepository.findByEmail(email) != null ||
                tUserRepository.findByPhone(phone) != null) {
            return null;
        }
        String salt = UUID.randomUUID().toString().replace("-", "");
        TuserEntity tuserEntity = new TuserEntity();
        tuserEntity.setEmail(email);
        tuserEntity.setName(loginName);
        String pwdstr = MD5SHAHelper.toString(MD5SHAHelper.encryptByMD5((pwd + salt).getBytes()));
        tuserEntity.setPwd(pwdstr);
        tuserEntity.setPhone(phone);
        tuserEntity.setSalt(salt);
        tuserEntity.setApp(app);
        tuserEntity.setDesktop(desktop);
        tuserEntity.setMac(mac);
        tuserEntity.setEquipmentid(equipmentid);
        tuserEntity.setWeb(web);
        String rtime = DateUtil.dateToString("yyyy-MM-dd", new Date(), "MEDIUM");
        tuserEntity.setRegistTime(rtime);
        tuserEntity.setAuthorTime(term);
        String token = UUID.randomUUID().toString().replace("-", "");
        tuserEntity.setToken(token);
        return save(tuserEntity);
    }

    @Override
    public Boolean createRole(String name, String type, String describe) {
        if (tRoleRepository.findByName(name) != null ||
                tRoleRepository.findByType(type) != null) {
            return false;
        }
        TroleEntity troleEntity = new TroleEntity();
        troleEntity.setName(name);
        troleEntity.setType(type);
        troleEntity.setDescribe(describe);
        save(troleEntity);
        return true;
    }

    @Override
    public Boolean createResource(String name) {
        if (tResourceRepository.findByName(name) != null) {
            return false;
        }
        TresourceEntity tresourceEntity = new TresourceEntity();
        tresourceEntity.setName(name);

        save(tresourceEntity);
        return true;
    }

    @Override
    public Boolean createGroup(String name, String type, String pid) {
        if (tGroupRepository.findByName(name) != null) {
            return false;
        }
        TgroupEntity tgroupEntity = new TgroupEntity();
        tgroupEntity.setName(name);
        tgroupEntity.setType(type);
        tgroupEntity.setParentId(pid);
        save(tgroupEntity);
        return true;
    }

    @Override
    public Boolean allocationUserGroup(TuserEntity tuserEntity, TgroupEntity tgroupEntity) {
        if (rUserGroupRepository.findByTuserByUidAndAndTgroupByGid(tuserEntity, tgroupEntity) == null) {
            RusergroupEntity rusergroupEntity = new RusergroupEntity();
            rusergroupEntity.setTuserByUid(tuserEntity);
            rusergroupEntity.setTgroupByGid(tgroupEntity);
            rUserGroupRepository.save(rusergroupEntity);
            return true;
        }
        return false;
    }

    @Override
    public Boolean allocationUserRole(TuserEntity tuserEntity, TroleEntity troleEntity) {
        if (rUserRoleRepository.findByTuserByUidAndTroleByRid(tuserEntity, troleEntity) == null) {
            RuserroleEntity ruserroleEntity = new RuserroleEntity();
            ruserroleEntity.setTuserByUid(tuserEntity);
            ruserroleEntity.setTroleByRid(troleEntity);
            rUserRoleRepository.save(ruserroleEntity);
            return true;
        }
        return false;
    }

    @Override
    public Boolean allocationUserResource(TuserEntity tuserEntity, TresourceEntity tresourceEntity) {
        if (rUserResourceRepository.findByTuserByUidAndTresourceByReid(tuserEntity, tresourceEntity) == null) {
            RuserresourceEntity ruserresourceEntity = new RuserresourceEntity();
            ruserresourceEntity.setTresourceByReid(tresourceEntity);
            ruserresourceEntity.setTuserByUid(tuserEntity);
            rUserResourceRepository.save(ruserresourceEntity);
            return true;
        }
        return false;
    }

    @Override
    public Boolean allocationRoleResource(TroleEntity troleEntity, TresourceEntity tresourceEntity) {
        if (rRoleResourceRepository.findByTroleByRidAndTresourceByReid(troleEntity, tresourceEntity) == null) {
            RroleresourceEntity rroleresourceEntity = new RroleresourceEntity();
            rroleresourceEntity.setTresourceByReid(tresourceEntity);
            rroleresourceEntity.setTroleByRid(troleEntity);
            rRoleResourceRepository.save(rroleresourceEntity);
            return true;
        }
        return false;
    }
}
