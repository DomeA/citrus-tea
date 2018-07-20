package com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.services.impl;

import com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.pojo.TDepartmentEntity;
import com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.pojo.TUserEntity;
import com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.repository.TUserRepository;
import com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.services.TUserService;
import com.domeastudio.mappingo.servers.microservice.inventory.util.security.MD5SHAHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class TUserServiceImpl implements TUserService {
    @Autowired
    private TUserRepository tUserRepository;

    @Override
    public TUserEntity save(String name, String pwd, TDepartmentEntity tDepartmentEntity) {
        TUserEntity tUserEntity=new TUserEntity();
        tUserEntity.setName(name);
        String salt = UUID.randomUUID().toString().replace("-", "");
        tUserEntity.setSalt(salt);
        String pwdstr = MD5SHAHelper.toString(MD5SHAHelper.encryptByMD5((pwd + salt).getBytes()));
        tUserEntity.setPwd(pwdstr);
        tUserEntity.settDepartmentByDid(tDepartmentEntity);
        return tUserRepository.save(tUserEntity);
    }

    @Override
    public List<TUserEntity> findAll() {
        return tUserRepository.findAll();
    }

    @Override
    public List<TUserEntity> findByName(String name) {
        return tUserRepository.findByName(name);
    }

    @Override
    public List<TUserEntity> findByDepartment(TDepartmentEntity tDepartmentEntity) {
        return tUserRepository.findByTDepartmentByDid(tDepartmentEntity);
    }
}
