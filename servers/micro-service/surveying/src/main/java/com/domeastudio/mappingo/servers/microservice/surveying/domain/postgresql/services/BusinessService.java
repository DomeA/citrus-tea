package com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.services;

import com.domeastudio.mappingo.servers.microservice.surveying.domain.mongodb.pojo.BuildingProjectEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.mongodb.pojo.CadastralProjectEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.mongodb.pojo.DatumEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.mongodb.pojo.SurveyProjectEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.BbuildingProcessformEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.BcadastralProcessformEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.BsurveyProcessformEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.services.impl.ProcessType;

public interface BusinessService {
    Object newBuinessData(ProcessType processType);

    void updateBuildingProcessform(BbuildingProcessformEntity bbuildingProcessformEntity, BuildingProjectEntity buildingProjectEntity, DatumEntity datumEntity);

    void updateCadastralProcessform(BcadastralProcessformEntity bcadastralProcessformEntity, CadastralProjectEntity cadastralProjectEntity, DatumEntity datumEntity);

    void updateSurveyProcessform(BsurveyProcessformEntity bsurveyProcessformEntity,SurveyProjectEntity surveyProjectEntity,DatumEntity datumEntity);

    BsurveyProcessformEntity getSurveyProcess(String sid);

    BcadastralProcessformEntity getCadastralProcess(String cid);

    BbuildingProcessformEntity getBuildingProcess(String bid);
}
