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

    void createBuildingProcessForm();

    void createSurveyProcessForm();

    //分步更新表单
    void updateCadastralProcessForm1();

    void updateCadastralProcessForm2();

    void updateCadastralProcessForm3();

    void updateCadastralProcessForm4();

    void updateCadastralProcessForm5();

    void updateCadastralProcessForm6();

    void updateCadastralProcessForm7();

    void updateBuildingProcessForm1();

    void updateBuildingProcessForm2();

    void updateBuildingProcessForm3();

    void updateBuildingProcessForm4();

    void updateBuildingProcessForm5();

    void updateBuildingProcessForm6();

    void updateBuildingProcessForm7();

    void updateSurveyProcessForm1();

    void updateSurveyProcessForm2();

    void updateSurveyProcessForm3();

    void updateSurveyProcessForm4();

    void updateSurveyProcessForm5();

    void updateSurveyProcessForm6();


    List<BapprovalrecordEntity> findApprovalRecordByUid(String uid);

    BapprovalrecordEntity findApprovalRecordByUidAndCid(String uid, String cid);

    BapprovalrecordEntity findApprovalRecordByUidAndBid(String uid, String bid);

    BapprovalrecordEntity findApprovalRecordByUidAndSid(String uid, String sid);


}
