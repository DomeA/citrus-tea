package com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.services.impl;

import com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.repository.TDepartmentRepository;
import com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.services.TDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TDepartmentServiceImpl implements TDepartmentService {
    @Autowired
    private TDepartmentRepository tDepartmentRepository;
    @Override
    public TDepartmentEntity save(String name) {
        List<TDepartmentEntity> tDepartmentEntities=findAll();
        for(TDepartmentEntity tDepartmentEntity : tDepartmentEntities){
            if(name.equals(tDepartmentEntity.getName())){
                return null;
            }
        }
        TDepartmentEntity tDepartmentEntity=new TDepartmentEntity();
        tDepartmentEntity.setName(name);
        return tDepartmentRepository.save(tDepartmentEntity);
    }

    @Override
    public List<TDepartmentEntity> findAll() {
        return tDepartmentRepository.findAll();
    }

    @Override
    public TDepartmentEntity findByName(String name) {
        return tDepartmentRepository.findTDepartmentEntitiesByName(name);
    }

    @Override
    public TDepartmentEntity delete(String name) {
        return null;
    }

    @Override
    public TDepartmentEntity update(String name) {
        return null;
    }
}
