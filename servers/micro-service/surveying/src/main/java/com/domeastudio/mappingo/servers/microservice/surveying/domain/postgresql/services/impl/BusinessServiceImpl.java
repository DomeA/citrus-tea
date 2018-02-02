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
        Object obj=null;
        switch (processType){
            case SURVEY:
                obj=newSurveyProcess();
                break;
            case BUILDING:
                newBuildingProcess();
                break;
            case CADASTRAL:
                newCadastralProcess();
                break;
        }
        return obj;
    }

    private BsurveyProcessformEntity newSurveyProcess(){
        BsurveyProcessformEntity bsurveyProcessformEntity=new BsurveyProcessformEntity();

        SurveyProjectEntity surveyProjectEntity=new SurveyProjectEntity();
        surveyProjectEntity = surveyProjectRepository.save(surveyProjectEntity);
        bsurveyProcessformEntity.setProjectAchievementsId(surveyProjectEntity.getId());

        DatumEntity datumEntity=new DatumEntity();
        datumEntity=datumRepository.save(datumEntity);
        bsurveyProcessformEntity.setDatumId(datumEntity.getId());

        return bsurveyProcessformRepository.save(bsurveyProcessformEntity);
    }

    private BcadastralProcessformEntity newCadastralProcess(){
        BcadastralProcessformEntity bcadastralProcessformEntity=new BcadastralProcessformEntity();

        CadastralProjectEntity cadastralProjectEntity=new CadastralProjectEntity();
        cadastralProjectEntity = cadastralProjectRepository.save(cadastralProjectEntity);
        bcadastralProcessformEntity.setProjectAchievementsId(cadastralProjectEntity.getId());

        DatumEntity datumEntity=new DatumEntity();
        datumEntity=datumRepository.save(datumEntity);
        bcadastralProcessformEntity.setDatumId(datumEntity.getId());

        return bcadastralProcessformRepository.save(bcadastralProcessformEntity);
    }

    private BbuildingProcessformEntity newBuildingProcess(){
        BbuildingProcessformEntity bbuildingProcessformEntity=new BbuildingProcessformEntity();

//        BuildingHouseholdEntity buildingHouseholdEntity=new BuildingHouseholdEntity();
//        buildingHouseholdEntity=buildingHouseholdRepository.save(buildingHouseholdEntity);
//
//        BuildingLayerEntity  buildingLayerEntity=new BuildingLayerEntity();
//        buildingLayerEntity.set
        BuildingProjectEntity buildingProjectEntity=new BuildingProjectEntity();
        buildingProjectEntity = buildingProjectRepository.save(buildingProjectEntity);
        bbuildingProcessformEntity.setProjectAchievementsId(buildingProjectEntity.getId());

        DatumEntity datumEntity=new DatumEntity();
        datumEntity=datumRepository.save(datumEntity);
        bbuildingProcessformEntity.setDatumId(datumEntity.getId());

        return bbuildingProcessformRepository.save(bbuildingProcessformEntity);
    }
}
