package com.domeastudio.mappingo.servers.microservice.surveying.rest;

import com.domeastudio.mappingo.servers.microservice.surveying.dto.response.ClientMessage;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api()
@CrossOrigin
@RestController
@RequestMapping("/manager/menu")
public class DhtmlXAPI {

    @RequestMapping(value = "sildebar/{roleName}")
    public ClientMessage getSidebarData(@PathVariable("roleName") String roleName){

        return null;
    }
}
