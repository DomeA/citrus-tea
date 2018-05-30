package com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.services.impl;

import com.domeastudio.mappingo.servers.microservice.surveying.domain.mongodb.pojo.*;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.mongodb.repository.*;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.BapprovalrecordEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.BbuildingProcessformEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.BcadastralProcessformEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.BsurveyProcessformEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.repository.BapprovalrecordRepository;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.repository.BbuildingProcessformRepository;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.repository.BcadastralProcessformRepository;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.repository.BsurveyProcessformRepository;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.services.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BusinessServiceImpl implements BusinessService {
    @Autowired
    private BsurveyProcessformRepository bsurveyProcessformRepository;
    @Autowired
    private BcadastralProcessformRepository bcadastralProcessformRepository;
    @Autowired
    private BbuildingProcessformRepository bbuildingProcessformRepository;

    @Autowired
    private SurveyProjectRepository surveyProjectRepository;
    @Autowired
    private CadastralProjectRepository cadastralProjectRepository;
    @Autowired
    private BuildingProjectRepository buildingProjectRepository;
    @Autowired
    private BuildingLayerRepository buildingLayerRepository;
    @Autowired
    private BuildingHouseholdRepository buildingHouseholdRepository;
    @Autowired
    private DatumRepository datumRepository;

    @Autowired
    private BapprovalrecordRepository bapprovalrecordRepository;

    @Override
    public Object newBuinessData(ProcessType processType) {
        Object obj = null;
        switch (processType) {
            case SURVEY:
                obj = newSurveyProcess();
                break;
            case BUILDING:
                obj = newBuildingProcess();
                break;
            case CADASTRAL:
                obj = newCadastralProcess();
                break;
        }
        return obj;
    }

    //待完善
    @Override
    public Boolean updateBuildingProcessform(BbuildingProcessformEntity bbuildingProcessformEntity,
                                          BuildingProjectEntity buildingProjectEntity,
                                             DatumEntity datumEntity,BapprovalrecordEntity bapprovalrecordEntity) {
        BbuildingProcessformEntity isExistObject1=bbuildingProcessformRepository.findOne(bbuildingProcessformEntity.getBid());
        if(isExistObject1==null){
            return false;
        }
        //新建添加一个审批流程意见
        bapprovalrecordEntity.setBbuildingProcessformByBid(bbuildingProcessformEntity);
        bapprovalrecordRepository.save(bapprovalrecordEntity);

        BuildingProjectEntity isExistObject2=buildingProjectRepository.findOne(buildingProjectEntity.getId());
        if(isExistObject2==null){
            return false;
        }
        //更新保存项目
        buildingProjectRepository.save(buildingProjectEntity);
        datumRepository.save(datumEntity);
        bbuildingProcessformRepository.save(bbuildingProcessformEntity);
        return true;
    }
    @Override
    public BuildingLayerEntity newBuildingLayer(){
        BuildingLayerEntity buildingLayerEntity=new BuildingLayerEntity();
        return buildingLayerRepository.save(buildingLayerEntity);
    }
    @Override
    public BuildingHouseholdEntity newBuildingHouseHold(){
        BuildingHouseholdEntity buildingHouseholdEntity=new BuildingHouseholdEntity();
        return buildingHouseholdRepository.save(buildingHouseholdEntity);
    }

    @Override
    public BuildingLayerEntity updateBuildingLayer(BuildingLayerEntity buildingLayerEntity){
        BuildingLayerEntity isExistObject=buildingLayerRepository.findOne(buildingLayerEntity.getId());
        if(isExistObject==null){
            return null;
        }
        return buildingLayerRepository.save(buildingLayerEntity);
    }
    @Override
    public BuildingHouseholdEntity updateBuildingHouseHold(BuildingHouseholdEntity buildingHouseholdEntity){
        BuildingHouseholdEntity isExistObject=buildingHouseholdRepository.findOne(buildingHouseholdEntity.getId());
        if(isExistObject==null){
            return null;
        }
        return buildingHouseholdRepository.save(buildingHouseholdEntity);
    }

    @Override
    public void deleteBuildingProcessform(String bid) {
        BbuildingProcessformEntity bbuildingProcessformEntity=bbuildingProcessformRepository.findOne(bid);
        if(bbuildingProcessformEntity!=null){
            BuildingProjectEntity buildingProjectEntity=buildingProjectRepository.findOne(bbuildingProcessformEntity.getProjectAchievementsId());
            DatumEntity datumEntity=datumRepository.findOne(bbuildingProcessformEntity.getDatumId());
            buildingProjectRepository.delete(buildingProjectEntity);
            datumRepository.delete(datumEntity);
            bbuildingProcessformRepository.delete(bbuildingProcessformEntity);
        }
    }

    @Override
    public void deleteSurveyProcessform(String sid) {
        BsurveyProcessformEntity bsurveyProcessformEntity=bsurveyProcessformRepository.findOne(sid);
        if(bsurveyProcessformEntity!=null){
            SurveyProjectEntity surveyProjectEntity=surveyProjectRepository.findOne(bsurveyProcessformEntity.getProjectAchievementsId());
            DatumEntity datumEntity=datumRepository.findOne(bsurveyProcessformEntity.getDatumId());
            surveyProjectRepository.delete(surveyProjectEntity);
            datumRepository.delete(datumEntity);
            bsurveyProcessformRepository.delete(bsurveyProcessformEntity);
        }
    }

    @Override
    public void deleteCadastralProcessform(String cid) {
        BcadastralProcessformEntity bcadastralProcessformEntity=bcadastralProcessformRepository.findOne(cid);
        if(bcadastralProcessformEntity!=null){
            CadastralProjectEntity cadastralProjectEntity=cadastralProjectRepository.findOne(bcadastralProcessformEntity.getProjectAchievementsId());
            DatumEntity datumEntity=datumRepository.findOne(bcadastralProcessformEntity.getDatumId());
            cadastralProjectRepository.delete(cadastralProjectEntity);
            datumRepository.delete(datumEntity);
            bcadastralProcessformRepository.delete(bcadastralProcessformEntity);
        }
    }

    @Override
    public Boolean updateCadastralProcessform(BcadastralProcessformEntity bcadastralProcessformEntity,
                                           CadastralProjectEntity cadastralProjectEntity,
                                              DatumEntity datumEntity,BapprovalrecordEntity bapprovalrecordEntity) {
        BcadastralProcessformEntity isExistObject1=bcadastralProcessformRepository.findOne(bcadastralProcessformEntity.getCid());
        if(isExistObject1==null){
            return false;
        }
        //新建添加一个审批流程意见
        bapprovalrecordEntity.setBcadastralProcessformByCid(bcadastralProcessformEntity);
        bapprovalrecordRepository.save(bapprovalrecordEntity);

        CadastralProjectEntity isExistObject2=cadastralProjectRepository.findOne(cadastralProjectEntity.getId());
        if(isExistObject2==null){
            return false;
        }
        //更新保存项目
        cadastralProjectRepository.save(cadastralProjectEntity);
        //更新保存资料
        datumRepository.save(datumEntity);
        //更新保存流程表单
        bcadastralProcessformRepository.save(bcadastralProcessformEntity);
        return true;
    }

    @Override
    public Boolean updateSurveyProcessform(BsurveyProcessformEntity bsurveyProcessformEntity,
                                        SurveyProjectEntity surveyProjectEntity,
                                           DatumEntity datumEntity,BapprovalrecordEntity bapprovalrecordEntity) {
        BsurveyProcessformEntity isExistObject1=bsurveyProcessformRepository.findOne(bsurveyProcessformEntity.getSid());
        if(isExistObject1==null){
            return false;
        }
        //新建添加一个审批流程意见
        bapprovalrecordEntity.setBsurveyProcessformBySid(bsurveyProcessformEntity);
        bapprovalrecordRepository.save(bapprovalrecordEntity);
        SurveyProjectEntity isExistObject2=surveyProjectRepository.findOne(surveyProjectEntity.getId());
        if(isExistObject2==null){
            return false;
        }
        //更新保存项目
        surveyProjectRepository.save(surveyProjectEntity);
        //更新保存资料
        datumRepository.save(datumEntity);
        //更新保存流程表单
        bsurveyProcessformRepository.save(bsurveyProcessformEntity);
        return true;
    }

    @Override
    public BsurveyProcessformEntity getSurveyProcess(String sid) {
        return bsurveyProcessformRepository.findOne(sid);
    }

    @Override
    public BcadastralProcessformEntity getCadastralProcess(String cid) {
        return bcadastralProcessformRepository.findOne(cid);
    }

    @Override
    public BbuildingProcessformEntity getBuildingProcess(String bid) {
        return bbuildingProcessformRepository.findOne(bid);
    }

    private BsurveyProcessformEntity newSurveyProcess() {
        BsurveyProcessformEntity bsurveyProcessformEntity = new BsurveyProcessformEntity();

        SurveyProjectEntity surveyProjectEntity = new SurveyProjectEntity();
        surveyProjectEntity = surveyProjectRepository.save(surveyProjectEntity);
        bsurveyProcessformEntity.setProjectAchievementsId(surveyProjectEntity.getId());

        DatumEntity datumEntity = new DatumEntity();
        datumEntity = datumRepository.save(datumEntity);
        bsurveyProcessformEntity.setDatumId(datumEntity.getId());

        return bsurveyProcessformRepository.save(bsurveyProcessformEntity);
    }

    private BcadastralProcessformEntity newCadastralProcess() {
        BcadastralProcessformEntity bcadastralProcessformEntity = new BcadastralProcessformEntity();

        CadastralProjectEntity cadastralProjectEntity = new CadastralProjectEntity();
        cadastralProjectEntity = cadastralProjectRepository.save(cadastralProjectEntity);
        bcadastralProcessformEntity.setProjectAchievementsId(cadastralProjectEntity.getId());

        DatumEntity datumEntity = new DatumEntity();
        datumEntity = datumRepository.save(datumEntity);
        bcadastralProcessformEntity.setDatumId(datumEntity.getId());

        return bcadastralProcessformRepository.save(bcadastralProcessformEntity);
    }

    private BbuildingProcessformEntity newBuildingProcess() {
        BbuildingProcessformEntity bbuildingProcessformEntity = new BbuildingProcessformEntity();

        BuildingProjectEntity buildingProjectEntity = new BuildingProjectEntity();
        buildingProjectEntity = buildingProjectRepository.save(buildingProjectEntity);
        bbuildingProcessformEntity.setProjectAchievementsId(buildingProjectEntity.getId());

        DatumEntity datumEntity = new DatumEntity();
        datumEntity = datumRepository.save(datumEntity);
        bbuildingProcessformEntity.setDatumId(datumEntity.getId());

        return bbuildingProcessformRepository.save(bbuildingProcessformEntity);
    }


}
