package com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.services.impl;

import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.BapprovalrecordEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.BbuildingProcessformEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.BcadastralProcessformEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.BsurveyProcessformEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.repository.BcadastralProcessformRepository;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.services.ProcessFormService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProcessFormServiceImpl implements ProcessFormService {
    @Autowired
    BcadastralProcessformRepository bcadastralProcessformRepository;
    @Autowired

    @Override
    public BcadastralProcessformEntity findCadastralProcessFormByCid(String cid) {
        return null;
    }

    @Override
    public BbuildingProcessformEntity findBuildingProcessFormByBid(String bid) {
        return null;
    }

    @Override
    public BsurveyProcessformEntity findSurveyProcessFormBySid(String sid) {
        return null;
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
