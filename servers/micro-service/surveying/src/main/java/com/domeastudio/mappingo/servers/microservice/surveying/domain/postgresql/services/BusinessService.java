package com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.services;

import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.services.impl.ProcessType;

public interface BusinessService {
    Object newBuinessData(ProcessType processType);
}
