package com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.services;

import com.domeastudio.mappingo.servers.microservice.surveying.domain.mongodb.pojo.*;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.BapprovalrecordEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.BbuildingProcessformEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.BcadastralProcessformEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.BsurveyProcessformEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.services.impl.ProcessType;

public interface BusinessService {
    Object newBuinessData(ProcessType processType);

    Boolean updateBuildingProcessform(BbuildingProcessformEntity bbuildingProcessformEntity, BuildingProjectEntity buildingProjectEntity, DatumEntity datumEntity,BapprovalrecordEntity bapprovalrecordEntity);

    Boolean updateCadastralProcessform(BcadastralProcessformEntity bcadastralProcessformEntity, CadastralProjectEntity cadastralProjectEntity, DatumEntity datumEntity,BapprovalrecordEntity bapprovalrecordEntity);

    Boolean updateSurveyProcessform(BsurveyProcessformEntity bsurveyProcessformEntity,SurveyProjectEntity surveyProjectEntity,DatumEntity datumEntity,BapprovalrecordEntity bapprovalrecordEntity);

    BsurveyProcessformEntity getSurveyProcess(String sid);

    BcadastralProcessformEntity getCadastralProcess(String cid);

    BbuildingProcessformEntity getBuildingProcess(String bid);

    BuildingLayerEntity newBuildingLayer();

    BuildingHouseholdEntity newBuildingHouseHold();

    BuildingLayerEntity updateBuildingLayer(BuildingLayerEntity buildingLayerEntity);

    BuildingHouseholdEntity updateBuildingHouseHold(BuildingHouseholdEntity buildingHouseholdEntity);

    void deleteBuildingProcessform(String bid);
    void deleteSurveyProcessform(String sid);
    void deleteCadastralProcessform(String cid);
}
