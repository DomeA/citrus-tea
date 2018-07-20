package com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.services.impl;

import com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.pojo.TAssetsEntity;
import com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.pojo.THistoricalwarehouseEntity;
import com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.pojo.TWarehouseEntity;
import com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.repository.TAssetsRepository;
import com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.repository.THistoricalwarehouseRepository;
import com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.repository.TWarehouseRepository;
import com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.services.TWarehouseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class TWarehouseServiceImpl implements TWarehouseService {
    private static final Logger logger = LoggerFactory.getLogger(TWarehouseServiceImpl.class);

    @Autowired
    private TWarehouseRepository tWarehouseRepository;
    @Autowired
    private TAssetsRepository tAssetsRepository;
    @Autowired
    private THistoricalwarehouseRepository tHistoricalwarehouseRepository;

    private static final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
    /**
     * 初始化盘点表
     * @return
     */
    @Override
    public Boolean synchronizationSave() {
        List<TAssetsEntity> tAssetsEntityList = tAssetsRepository.findAll();
        if(tAssetsEntityList==null){
            logger.warn("同步资产表为空");
            return false;
        }
        for(TAssetsEntity tAssetsEntity : tAssetsEntityList){
            TWarehouseEntity tWarehouseEntity=new TWarehouseEntity();
            tWarehouseEntity.setCode(tAssetsEntity.getCode());
            tWarehouseEntity.setIsinventory(false);
            tWarehouseEntity.setInventorytime("NULL");
            tWarehouseEntity.settUserByUid(tAssetsEntity.gettUserByUid());
            tWarehouseEntity.setCount(0);
            tWarehouseRepository.save(tWarehouseEntity);
        }
        return true;
    }

    @Override
    public Boolean update(String code) {
        TAssetsEntity tAssetsEntity=tAssetsRepository.findByCode(code);
        TWarehouseEntity tWarehouseEntity=tWarehouseRepository.findByCode(code);
        THistoricalwarehouseEntity tHistoricalwarehouseEntity=new THistoricalwarehouseEntity();

        if(tAssetsEntity.gettAssetsinfoByAiid()
                .getCount().compareTo(tWarehouseEntity.getCount())<=0){
            tWarehouseEntity.setIsinventory(true);
            String date = df.format(new Date());
            tWarehouseEntity.setInventorytime(date);
            tWarehouseRepository.save(tWarehouseEntity);
            tHistoricalwarehouseEntity.setCode(tWarehouseEntity.getCode());
            tHistoricalwarehouseEntity.setCount(tWarehouseEntity.getCount());
            tHistoricalwarehouseEntity.setInventorytime(tWarehouseEntity.getInventorytime());
            tHistoricalwarehouseEntity.setIsinventory(tWarehouseEntity.getIsinventory());
            tHistoricalwarehouseEntity.settUserByUid(tWarehouseEntity.gettUserByUid());
            tHistoricalwarehouseRepository.save(tHistoricalwarehouseEntity);
            return true;
        }else if(tAssetsEntity.gettAssetsinfoByAiid()
                .getCount().compareTo(tWarehouseEntity.getCount())>0) {
            tWarehouseEntity.setIsinventory(false);
            tWarehouseEntity.setCount(tWarehouseEntity.getCount()+1);
            String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
            tWarehouseEntity.setInventorytime(date);
            tWarehouseRepository.save(tWarehouseEntity);

            tHistoricalwarehouseEntity.setCode(tWarehouseEntity.getCode());
            tHistoricalwarehouseEntity.setCount(tWarehouseEntity.getCount());
            tHistoricalwarehouseEntity.setInventorytime(tWarehouseEntity.getInventorytime());
            tHistoricalwarehouseEntity.setIsinventory(tWarehouseEntity.getIsinventory());
            tHistoricalwarehouseEntity.settUserByUid(tWarehouseEntity.gettUserByUid());
            tHistoricalwarehouseRepository.save(tHistoricalwarehouseEntity);
            return true;
        }
        return false;
    }

    @Override
    public Boolean start() {
        List<TWarehouseEntity> tWarehouseEntities = tWarehouseRepository.findAll();
        if(tWarehouseEntities==null){
            logger.warn("盘点表为空，请先同步");
            return false;
        }
        for(TWarehouseEntity tWarehouseEntity:tWarehouseEntities){
            tWarehouseEntity.setIsinventory(false);
            tWarehouseEntity.setInventorytime("NULL");
            tWarehouseEntity.setCount(0);
            tWarehouseRepository.save(tWarehouseEntity);
        }
        return true;
    }


}
