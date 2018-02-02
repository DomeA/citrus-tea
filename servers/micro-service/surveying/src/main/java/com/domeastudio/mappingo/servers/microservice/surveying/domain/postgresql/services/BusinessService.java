package com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.services;

import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.BbuildingProcessformEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.BcadastralProcessformEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.BsurveyProcessformEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.services.impl.ProcessType;

public interface BusinessService {
    Object newBuinessData(ProcessType processType);

    void updateBuildingProcessform(BbuildingProcessformEntity bbuildingProcessformEntity);

    void updateCadastralProcessform(BcadastralProcessformEntity bcadastralProcessformEntity);

    void updateSurveyProcessform(BsurveyProcessformEntity bsurveyProcessformEntity);
}
