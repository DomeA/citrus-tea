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
    public void createBuildingProcessForm(String projectName, String projectCode, String projectAddress, String projectTime) {
        BbuildingProcessformEntity bbuildingProcessformEntity=new BbuildingProcessformEntity();
        bbuildingProcessformEntity.setProjectAddress(projectAddress);
        bbuildingProcessformEntity.setProjectCode(projectCode);
        bbuildingProcessformEntity.setProjectName(projectName);
        bbuildingProcessformEntity.setProjectTime(projectTime);
        bbuildingProcessformRepository.save(bbuildingProcessformEntity);
    }

    @Override
    public void createSurveyProcessForm() {
        BsurveyProcessformEntity bsurveyProcessformEntity=new BsurveyProcessformEntity();

        bsurveyProcessformRepository.save(bsurveyProcessformEntity);
    }

    @Override
    public void updateCadastralProcessForm1(String cid,String receive) {
        BcadastralProcessformEntity bcadastralProcessformEntity= findCadastralProcessFormByCid(cid);
        bcadastralProcessformEntity.setReceive(receive);
        bcadastralProcessformRepository.save(bcadastralProcessformEntity);
    }

    @Override
    public void updateCadastralProcessForm2(String cid) {

    }

    @Override
    public void updateCadastralProcessForm3(String cid) {

    }

    @Override
    public void updateCadastralProcessForm4(String cid) {

    }

    @Override
    public void updateCadastralProcessForm5(String cid) {

    }

    @Override
    public void updateCadastralProcessForm6(String cid) {

    }

    @Override
    public void updateCadastralProcessForm7(String cid) {

    }

    @Override
    public void updateBuildingProcessForm1(String bid) {

    }

    @Override
    public void updateBuildingProcessForm2(String bid) {

    }

    @Override
    public void updateBuildingProcessForm3(String bid) {

    }

    @Override
    public void updateBuildingProcessForm4(String bid) {

    }

    @Override
    public void updateBuildingProcessForm5(String bid) {

    }

    @Override
    public void updateBuildingProcessForm6(String bid) {

    }

    @Override
    public void updateBuildingProcessForm7(String bid) {

    }

    @Override
    public void updateSurveyProcessForm1(String sid) {

    }

    @Override
    public void updateSurveyProcessForm2(String sid) {

    }

    @Override
    public void updateSurveyProcessForm3(String sid) {

    }

    @Override
    public void updateSurveyProcessForm4(String sid) {

    }

    @Override
    public void updateSurveyProcessForm5(String sid) {

    }

    @Override
    public void updateSurveyProcessForm6(String sid) {

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
