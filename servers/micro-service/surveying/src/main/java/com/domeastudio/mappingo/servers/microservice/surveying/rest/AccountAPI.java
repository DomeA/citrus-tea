package com.domeastudio.mappingo.servers.microservice.surveying.rest;

import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.TgroupEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.TroleEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.TuserEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.services.TUserService;
import com.domeastudio.mappingo.servers.microservice.surveying.dto.request.ForgetUser;
import com.domeastudio.mappingo.servers.microservice.surveying.dto.request.Register;
import com.domeastudio.mappingo.servers.microservice.surveying.dto.response.ClientMessage;
import com.domeastudio.mappingo.servers.microservice.surveying.dto.response.ResultStatusCode;
import com.domeastudio.mappingo.servers.microservice.surveying.util.security.MD5SHAHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@Api("用户注册服务")
@RequestMapping("/account")
public class AccountAPI {
    private static final Logger logger = LoggerFactory.getLogger(FileAPI.class);

    @Autowired
    private TUserService tUserService;

    @ApiOperation(value = "用于测试服务是否正常", notes = "", httpMethod = "GET")
    @ApiResponse(code = 200, message = "String", response = Map.class)
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public Map<String, String> test() {
        Map<String, String> stringStringMap = new HashMap<>();
        stringStringMap.put("message", "hello world");
        return stringStringMap;
    }

    @RequestMapping(value = "/register/user", method = RequestMethod.POST)
    public ClientMessage addUSer(Register register) {
        ClientMessage clientMessage;
        TuserEntity tuserEntity = tUserService.createUser(register.getLoginName().trim(), register.getPwd(), register.getEmail().trim(), register.getPhone().trim(), register.getWeb(), register.getApp(), register.getDesktop(), register.getMac().trim(), register.getEquipmentid().trim(), register.getTerm());
        System.out.println("用户：" + register.getName() + (tuserEntity != null ? "创建成功！" : "已经存在"));
        if (tuserEntity != null) {
            TroleEntity troleEntity = tUserService.findRoleByName("ROLE_SIGHTSEER");
            TgroupEntity tgroupEntity = tUserService.findGroupByName("GROUP_SYSADMIN");
            tUserService.allocationUserGroup(tuserEntity, tgroupEntity);
            tUserService.allocationUserRole(tuserEntity, troleEntity);
            clientMessage = new ClientMessage(ResultStatusCode.OK.getCode(), ResultStatusCode.OK.getMsg(), tuserEntity.getToken());
        } else {
            clientMessage = new ClientMessage(ResultStatusCode.INVALID_USERNAME.getCode(), ResultStatusCode.INVALID_USERNAME.getMsg(), "用户名已经存在");
        }
        return clientMessage;
    }

    @RequestMapping(value = "/forget/inspect/{loginName}", method = RequestMethod.GET)
    public ClientMessage inspectUSerPwd(@PathVariable String loginName) {
        ClientMessage clientMessage;
        TuserEntity tuserEntity = tUserService.findByNameOrEmailOrPhone(loginName);
        if (tuserEntity != null) {
            clientMessage = new ClientMessage(ResultStatusCode.OK.getCode(), ResultStatusCode.OK.getMsg(), "用户存在并可用");
        } else {
            clientMessage = new ClientMessage(ResultStatusCode.INVALID_USERNAME.getCode(), ResultStatusCode.INVALID_USERNAME.getMsg(), "用户名不存在");
        }
        return clientMessage;
    }

    @RequestMapping(value = "/forget/update/form", method = RequestMethod.POST)
    public ClientMessage updateUserPwd4Form(ForgetUser forgetUser) {
        return updateUserPwd(forgetUser);
    }

    @RequestMapping(value = "/forget/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ClientMessage updateUserPwd(@RequestBody ForgetUser forgetUser) {
        ClientMessage clientMessage;
        TuserEntity tuserEntity = tUserService.findByNameOrEmailOrPhone(forgetUser.getUserName());
        if (tuserEntity != null) {
            String pwdstr = MD5SHAHelper.toString(MD5SHAHelper.encryptByMD5((forgetUser.getPassword() + tuserEntity.getSalt()).getBytes()));
            tuserEntity.setPwd(pwdstr);
            tUserService.save(tuserEntity);
            clientMessage = new ClientMessage(ResultStatusCode.OK.getCode(), ResultStatusCode.OK.getMsg(), "用户密码修改成功");
        } else {
            clientMessage = new ClientMessage(ResultStatusCode.INVALID_USERNAME.getCode(), ResultStatusCode.INVALID_USERNAME.getMsg(), "用户名不存在，无法修改密码");
        }
        return clientMessage;
    }
}
