package com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.services.impl;

import com.domeastudio.mappingo.servers.microservice.surveying.domain.mongodb.pojo.*;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.mongodb.repository.*;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.BbuildingProcessformEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.BcadastralProcessformEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.BsurveyProcessformEntity;
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
    public void updateBuildingProcessform(BbuildingProcessformEntity bbuildingProcessformEntity,
                                          BuildingProjectEntity buildingProjectEntity,DatumEntity datumEntity) {
        datumRepository.save(datumEntity);
        bbuildingProcessformRepository.save(bbuildingProcessformEntity);
    }

    private BuildingLayerEntity newBuildingLayer(){
        BuildingLayerEntity buildingLayerEntity=new BuildingLayerEntity();
        return buildingLayerRepository.save(buildingLayerEntity);
    }

    private BuildingHouseholdEntity newBuildingHouseHold(){
        BuildingHouseholdEntity buildingHouseholdEntity=new BuildingHouseholdEntity();
        return buildingHouseholdRepository.save(buildingHouseholdEntity);
    }

    private void updateBuildingLayer(BuildingLayerEntity buildingLayerEntity){
        buildingLayerRepository.save(buildingLayerEntity);
    }

    private void updateBuildingHouseHold(BuildingHouseholdEntity buildingHouseholdEntity){
        buildingHouseholdRepository.save(buildingHouseholdEntity);
    }

    @Override
    public void updateCadastralProcessform(BcadastralProcessformEntity bcadastralProcessformEntity,
                                           CadastralProjectEntity cadastralProjectEntity,DatumEntity datumEntity) {
        //更新保存项目
        cadastralProjectRepository.save(cadastralProjectEntity);
        //更新保存资料
        datumRepository.save(datumEntity);
        //更新保存流程表单
        bcadastralProcessformRepository.save(bcadastralProcessformEntity);
    }

    @Override
    public void updateSurveyProcessform(BsurveyProcessformEntity bsurveyProcessformEntity,
                                        SurveyProjectEntity surveyProjectEntity,DatumEntity datumEntity) {
        //更新保存项目
        surveyProjectRepository.save(surveyProjectEntity);
        //更新保存资料
        datumRepository.save(datumEntity);
        //更新保存流程表单
        bsurveyProcessformRepository.save(bsurveyProcessformEntity);
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
