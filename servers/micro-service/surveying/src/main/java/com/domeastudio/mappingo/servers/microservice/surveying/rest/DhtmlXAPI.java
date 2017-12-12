package com.domeastudio.mappingo.servers.microservice.surveying.rest;

import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.services.DhtmlxService;
import com.domeastudio.mappingo.servers.microservice.surveying.dto.response.ClientMessage;
import com.domeastudio.mappingo.servers.microservice.surveying.dto.response.DhtmlxData;
import com.domeastudio.mappingo.servers.microservice.surveying.dto.response.ResultStatusCode;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Api()
@CrossOrigin
@RestController
@RequestMapping("/manager/menu")
public class DhtmlXAPI {
    @Autowired
    DhtmlxService dhtmlxService;

    @RequestMapping(value = "/sildebar/{userid}",method = RequestMethod.GET)
    public ClientMessage getSidebarData(@PathVariable("userid") String userid){
        DhtmlxData dhtmlxData = dhtmlxService.getDhtmlxSidebarData(userid);
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
