package com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.services.impl;

import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.BapprovalrecordEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.BbuildingProcessformEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.BcadastralProcessformEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.BsurveyProcessformEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.repository.BbuildingProcessformRepository;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.repository.BcadastralProcessformRepository;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.repository.BsurveyProcessformRepository;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.services.ProcessFormService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProcessFormServiceImpl implements ProcessFormService {
    @Autowired
    BcadastralProcessformRepository bcadastralProcessformRepository;
    @Autowired
    BbuildingProcessformRepository bbuildingProcessformRepository;

    @Autowired
    BsurveyProcessformRepository bsurveyProcessformRepository;

    @Override
    public BcadastralProcessformEntity findCadastralProcessFormByCid(String cid) {
        return bcadastralProcessformRepository.findOne(cid);
    }

    @Override
    public BbuildingProcessformEntity findBuildingProcessFormByBid(String bid) {
        return bbuildingProcessformRepository.findOne(bid);
    }

    @Override
    public BsurveyProcessformEntity findSurveyProcessFormBySid(String sid) {
        return bsurveyProcessformRepository.findOne(sid);
    }

    @Override
    public void createCadastralProcessForm(String projectName, String projectCode, String projectAddress, String projectTime) {
        BcadastralProcessformEntity bcadastralProcessformEntity = new BcadastralProcessformEntity();
        bcadastralProcessformEntity.setProjectAddress(projectAddress);
        bcadastralProcessformEntity.setProjectCode(projectCode);
        bcadastralProcessformEntity.setProjectName(projectName);
        bcadastralProcessformEntity.setProjectTime(projectTime);

        bcadastralProcessformRepository.save(bcadastralProcessformEntity);
    }

    @Override
    public void createBuildingProcessForm() {

    }

    @Override
    public void createSurveyProcessForm() {

    }

    @Override
    public void updateCadastralProcessForm1() {

    }

    @Override
    public void updateCadastralProcessForm2() {

    }

    @Override
    public void updateCadastralProcessForm3() {

    }

    @Override
    public void updateCadastralProcessForm4() {

    }

    @Override
    public void updateCadastralProcessForm5() {

    }

    @Override
    public void updateCadastralProcessForm6() {

    }

    @Override
    public void updateCadastralProcessForm7() {

    }

    @Override
    public void updateBuildingProcessForm1() {

    }

    @Override
    public void updateBuildingProcessForm2() {

    }

    @Override
    public void updateBuildingProcessForm3() {

    }

    @Override
    public void updateBuildingProcessForm4() {

    }

    @Override
    public void updateBuildingProcessForm5() {

    }

    @Override
    public void updateBuildingProcessForm6() {

    }

    @Override
    public void updateBuildingProcessForm7() {

    }

    @Override
    public void updateSurveyProcessForm1() {

    }

    @Override
    public void updateSurveyProcessForm2() {

    }

    @Override
    public void updateSurveyProcessForm3() {

    }

    @Override
    public void updateSurveyProcessForm4() {

    }

    @Override
    public void updateSurveyProcessForm5() {

    }

    @Override
    public void updateSurveyProcessForm6() {

    }

    @Override
    public List<BapprovalrecordEntity> findApprovalRecordByUid(String uid) {
        return null;
    }

    @Override
    public BapprovalrecordEntity findApprovalRecordByUidAndCid(String uid, String cid) {
        return null;
    }

    @Override
    public BapprovalrecordEntity findApprovalRecordByUidAndBid(String uid, String bid) {
        return null;
    }

    @Override
    public BapprovalrecordEntity findApprovalRecordByUidAndSid(String uid, String sid) {
        return null;
    }
}
