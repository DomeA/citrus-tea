package com.domeastudio.mappingo.servers.microservice.surveying.rest;

import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.services.DhtmlxService;
import com.domeastudio.mappingo.servers.microservice.surveying.dto.response.ClientMessage;
import com.domeastudio.mappingo.servers.microservice.surveying.dto.response.DhtmlxData;
import com.domeastudio.mappingo.servers.microservice.surveying.dto.response.ResultStatusCode;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api()
@CrossOrigin
@RestController
@RequestMapping("/manager/menu")
public class DhtmlXAPI {
    @Autowired
    DhtmlxService dhtmlxService;

    @RequestMapping(value = "sildebar/{roleName}")
    public ClientMessage getSidebarData(@PathVariable("roleName") String roleName){
        DhtmlxData dhtmlxData = dhtmlxService.getDhtmlxSidebarData(roleName);
        ClientMessage clientMessage;
        if(dhtmlxData.getItems().size()>0){
            clientMessage = new ClientMessage(ResultStatusCode.OK.getCode(),
                    ResultStatusCode.OK.getMsg(), dhtmlxData);
            return clientMessage;
        }
        clientMessage = new ClientMessage(ResultStatusCode.INVALID_PARAM.getCode(),
                ResultStatusCode.INVALID_PARAM.getMsg(), null);
        return clientMessage;
    }
}
