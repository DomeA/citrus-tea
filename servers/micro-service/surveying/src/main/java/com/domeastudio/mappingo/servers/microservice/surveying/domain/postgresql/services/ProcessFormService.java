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

    //创建表单
    void createCadastralProcessForm(String projectName, String projectCode, String projectAddress, String projectTime);

    void createBuildingProcessForm(String projectName, String projectCode, String projectAddress, String projectTime);

    void createSurveyProcessForm();

    //分步更新表单
    void updateCadastralProcessForm1(String cid,String receive);

    void updateCadastralProcessForm2(String cid);

    void updateCadastralProcessForm3(String cid);

    void updateCadastralProcessForm4(String cid);

    void updateCadastralProcessForm5(String cid);

    void updateCadastralProcessForm6(String cid);

    void updateCadastralProcessForm7(String cid);

    void updateBuildingProcessForm1(String bid);

    void updateBuildingProcessForm2(String bid);

    void updateBuildingProcessForm3(String bid);

    void updateBuildingProcessForm4(String bid);

    void updateBuildingProcessForm5(String bid);

    void updateBuildingProcessForm6(String bid);

    void updateBuildingProcessForm7(String bid);

    void updateSurveyProcessForm1(String sid);

    void updateSurveyProcessForm2(String sid);

    void updateSurveyProcessForm3(String sid);

    void updateSurveyProcessForm4(String sid);

    void updateSurveyProcessForm5(String sid);

    void updateSurveyProcessForm6(String sid);


    List<BapprovalrecordEntity> findApprovalRecordByUid(String uid);

    BapprovalrecordEntity findApprovalRecordByUidAndCid(String uid, String cid);

    BapprovalrecordEntity findApprovalRecordByUidAndBid(String uid, String bid);

    BapprovalrecordEntity findApprovalRecordByUidAndSid(String uid, String sid);


}
