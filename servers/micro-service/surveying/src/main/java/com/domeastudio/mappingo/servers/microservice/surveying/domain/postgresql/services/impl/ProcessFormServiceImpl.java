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
    public Boolean createCadastralProcessForm() {
        return null;
    }

    @Override
    public Boolean createBuildingProcessForm() {
        return null;
    }

    @Override
    public Boolean createSurveyProcessForm() {
        return null;
    }

    @Override
    public void updateCadastralProcessForm() {

    }

    @Override
    public void updateBuildingProcessForm() {

    }

    @Override
    public void updateSurveyProcessForm() {

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
