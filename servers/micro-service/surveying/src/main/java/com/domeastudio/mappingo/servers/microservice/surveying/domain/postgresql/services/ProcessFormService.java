package com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.services;

import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.BapprovalrecordEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.BbuildingProcessformEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.BcadastralProcessformEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.BsurveyProcessformEntity;

import java.util.List;

public interface ProcessFormService {
    BcadastralProcessformEntity findCadastralProcessFormByCid(String cid);
    BbuildingProcessformEntity findBuildingProcessFormByBid(String bid);
    BsurveyProcessformEntity findSurveyProcessFormBySid(String sid);

    Boolean createCadastralProcessForm();
    Boolean createBuildingProcessForm();
    Boolean createSurveyProcessForm();

    void updateCadastralProcessForm();
    void updateBuildingProcessForm();
    void updateSurveyProcessForm();

    List<BapprovalrecordEntity> findApprovalRecordByUid(String uid);
    BapprovalrecordEntity findApprovalRecordByUidAndCid(String uid,String cid);
    BapprovalrecordEntity findApprovalRecordByUidAndBid(String uid,String bid);
    BapprovalrecordEntity findApprovalRecordByUidAndSid(String uid,String sid);


}
