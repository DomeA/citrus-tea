package com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.services.impl;

import com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.pojo.*;
import com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.repository.TAssetsRepository;
import com.domeastudio.mappingo.servers.microservice.inventory.domain.postgresql.services.TAssetsService;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

public class TAssetsServiceImpl implements TAssetsService {
    @Autowired
    TAssetsRepository tAssetsRepository;

    @Override
    public TAssetsEntity save(String code, TAssetsinfoEntity tAssetsinfoEntity, TUserEntity tUserEntity, TAssetstypeEntity tAssetstypeEntity, TAssetsstatusEntity tAssetsstatusEntity) {
        return null;
    }

    @Override
    public List<TAssetsEntity> findByGreaterThanPrice(BigDecimal price) {
        return null;
    }

    @Override
    public List<TAssetsEntity> findByLessThanPrice(BigDecimal price) {
        return null;
    }

    @Override
    public List<TAssetsEntity> findBySectionPrice(BigDecimal lessprice, BigDecimal greaterprice) {
        return null;
    }

    @Override
    public TAssetsEntity findByCode(String code) {
        return tAssetsRepository.findByCode(code);
    }

    @Override
    public Boolean updateAssetsStatus(String scanningCode, String code) {
        if(findByCode(code)==null){
            return false;
        }
        switch (scanningCode){
            case "10":return updateAssetsStatusFrom10(code);
            case "11":return updateAssetsStatusFrom11(code);
            case "12":return updateAssetsStatusFrom12(code);
            case "13":return updateAssetsStatusFrom13(code);
            case "14":return updateAssetsStatusFrom14();
            case "20":return updateAssetsStatusFrom20(code);
            case "30":return updateAssetsStatusFrom20(code);
            case "40":return updateAssetsStatusFrom20(code);
            case "50":return updateAssetsStatusFrom20(code);
            default:return false;
        }
    }

    /**
     * 10 采购入库
     * 11 报修
     * 12 外借
     * 13 盘点
     * 20 日常签到
     * 30 日常签到
     * 40 日常签到
     * 50 日常签到
     * 10枪 修改到待使用
     */
    private Boolean updateAssetsStatusFrom10(String code){
        return false;
    }

    //11枪 修改到保修
    private Boolean updateAssetsStatusFrom11(String code){
        return false;
    }

    //12枪 修改到外借
    private Boolean updateAssetsStatusFrom12(String code){
        return false;
    }
    //13枪 修改到盘点
    private Boolean updateAssetsStatusFrom13(String code){
        return false;
    }
    //14枪 修改到盘点开始 盘点表全部为未盘点状态
    private Boolean updateAssetsStatusFrom14(){
        return false;
    }

    //20枪 修改 科室01 日常签到
    private Boolean updateAssetsStatusFrom20(String code){
        return false;
    }

    //30枪 修改 科室02 日常签到
    private Boolean updateAssetsStatusFrom30(String code){
        return false;
    }

    //40枪 修改 科室03 日常签到
    private Boolean updateAssetsStatusFrom40(String code){
        return false;
    }

    //50枪 修改 科室04 日常签到
    private Boolean updateAssetsStatusFrom50(String code){
        return false;
    }

    //超时 状态闲置
    //存储过程完成闲置状态改变
//    private Boolean updateAssetsStatusFromTimeOut(){
//        return false;
//    }
}
