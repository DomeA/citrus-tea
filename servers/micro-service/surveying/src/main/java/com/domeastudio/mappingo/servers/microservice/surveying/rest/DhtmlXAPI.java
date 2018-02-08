package com.domeastudio.mappingo.servers.microservice.surveying.rest;

import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.TresourceEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.services.DhtmlxService;
import com.domeastudio.mappingo.servers.microservice.surveying.dto.request.MenuDef;
import com.domeastudio.mappingo.servers.microservice.surveying.dto.response.ClientMessage;
import com.domeastudio.mappingo.servers.microservice.surveying.dto.response.DhtmlxData;
import com.domeastudio.mappingo.servers.microservice.surveying.dto.response.ResultStatusCode;
import com.domeastudio.mappingo.servers.microservice.surveying.util.FileUtils;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.stream.FileImageInputStream;
import java.io.*;
import java.util.List;


@Api()
@CrossOrigin
@RestController
@RequestMapping("/manager/menu")
public class DhtmlXAPI {
    @Autowired
    DhtmlxService dhtmlxService;

    @RequestMapping(value = "/registmenu/toolbar", method = RequestMethod.GET)
    public ClientMessage getRegistMenuToolbar(String pid) {
        DhtmlxData dhtmlxData = dhtmlxService.getResources(pid);

        ClientMessage clientMessage;
        if (dhtmlxData.getToolbarItems()!=null) {
            clientMessage = new ClientMessage(ResultStatusCode.OK.getCode(),
                    ResultStatusCode.OK.getMsg(), dhtmlxData);
            return clientMessage;
        }
        clientMessage = new ClientMessage(ResultStatusCode.INVALID_PARAM.getCode(),
                ResultStatusCode.INVALID_PARAM.getMsg(), null);
        return clientMessage;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ClientMessage addMenu(MenuDef menu, @RequestParam("iconFile") MultipartFile multipartFile) {
        TresourceEntity tresourceEntity = new TresourceEntity();
        tresourceEntity.setParenId(menu.getParentid());
        tresourceEntity.setName(menu.getName());
        tresourceEntity.setCode(menu.getCode());
        tresourceEntity.setSelected(false);
        tresourceEntity.setType(null);

        Boolean flage = dhtmlxService.createTresource(menu.getRoleName(), tresourceEntity, FileUtils.FileInput2Byte(multipartFile));

        ClientMessage clientMessage;
        if (flage) {
            clientMessage = new ClientMessage(ResultStatusCode.OK.getCode(),
                    ResultStatusCode.OK.getMsg(), null);
            return clientMessage;
        }
        clientMessage = new ClientMessage(ResultStatusCode.INVALID_PARAM.getCode(),
                ResultStatusCode.INVALID_PARAM.getMsg(), null);
        return clientMessage;
    }

    @RequestMapping(value = "/sildebar/{userid}", method = RequestMethod.GET)
    public ClientMessage getSidebarData(@PathVariable("userid") String userid) {
        DhtmlxData dhtmlxData = dhtmlxService.getDhtmlxSidebarData(userid);
        ClientMessage clientMessage;
        if (dhtmlxData.getSidebarItem().getItems().size() > 0) {
            clientMessage = new ClientMessage(ResultStatusCode.OK.getCode(),
                    ResultStatusCode.OK.getMsg(), dhtmlxData);
            return clientMessage;
        }
        clientMessage = new ClientMessage(ResultStatusCode.INVALID_PARAM.getCode(),
                ResultStatusCode.INVALID_PARAM.getMsg(), null);
        return clientMessage;
    }

    @RequestMapping(value = "/treeview/{userid}", method = RequestMethod.GET)
    public ClientMessage getTreeviewData(@PathVariable("userid") String userid) {
        DhtmlxData dhtmlxData = dhtmlxService.getDhtmlxTreeviewData(userid);
        ClientMessage clientMessage;
        if (dhtmlxData.getTreeItems().size() > 0) {
            clientMessage = new ClientMessage(ResultStatusCode.OK.getCode(),
                    ResultStatusCode.OK.getMsg(), dhtmlxData);
            return clientMessage;
        }
        clientMessage = new ClientMessage(ResultStatusCode.INVALID_PARAM.getCode(),
                ResultStatusCode.INVALID_PARAM.getMsg(), null);
        return clientMessage;
    }

    @RequestMapping(value = "/grid/{userid}", method = RequestMethod.GET)
    public ClientMessage getGridData(@PathVariable("userid") String userid) {
        DhtmlxData dhtmlxData = dhtmlxService.getDhtmlxGridData(userid);
        ClientMessage clientMessage;
        if (dhtmlxData.getTreeItems().size() > 0) {
            clientMessage = new ClientMessage(ResultStatusCode.OK.getCode(),
                    ResultStatusCode.OK.getMsg(), dhtmlxData);
            return clientMessage;
        }
        clientMessage = new ClientMessage(ResultStatusCode.INVALID_PARAM.getCode(),
                ResultStatusCode.INVALID_PARAM.getMsg(), null);
        return clientMessage;
    }
}
