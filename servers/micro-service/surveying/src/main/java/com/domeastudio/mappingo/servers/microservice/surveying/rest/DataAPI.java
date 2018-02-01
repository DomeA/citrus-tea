package com.domeastudio.mappingo.servers.microservice.surveying.rest;

import com.domeastudio.mappingo.servers.microservice.surveying.domain.mongodb.services.FileService;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.TgroupEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.TroleEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.TuserEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.services.AccountService;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.services.TUserService;
import com.domeastudio.mappingo.servers.microservice.surveying.dto.request.Group;
import com.domeastudio.mappingo.servers.microservice.surveying.dto.request.Role;
import com.domeastudio.mappingo.servers.microservice.surveying.dto.response.ClientMessage;
import com.domeastudio.mappingo.servers.microservice.surveying.dto.response.ResultStatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api("测绘数据管理服务")
@RestController
@CrossOrigin
@RequestMapping("/manager")
public class DataAPI {

    @Autowired
    private TUserService tUserService;

    @Autowired
    private FileService fileService;

    @Autowired
    private AccountService accountService;

    @ApiOperation(value = "用于测试服务是否正常", notes = "", httpMethod = "GET")
    @ApiResponse(code = 200, message = "String", response = Map.class)
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public Map<String, String> test() {
        Map<String, String> stringStringMap = new HashMap<>();
        stringStringMap.put("message", "hello world");
        return stringStringMap;
    }

    //角色管理
    @RequestMapping(value = "/create/role", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ClientMessage createRole(@RequestBody Role role) {
        ClientMessage clientMessage;
        Boolean f = tUserService.createRole(role.getName().trim(), role.getType().trim(), role.getDescribe().trim());
        System.out.println("角色：" + role.getName() + (f ? "创建成功！" : "已经存在"));
        if(f){
            clientMessage = new ClientMessage(ResultStatusCode.OK.getCode(),
                    ResultStatusCode.OK.getMsg(), "角色创建成功");
            return clientMessage;
        }else{
            clientMessage = new ClientMessage(ResultStatusCode.INVALID_ROLENAME.getCode(),
                    ResultStatusCode.OK.getMsg(), "角色已存在，无法创建");
            return clientMessage;
        }
    }

    @RequestMapping(value = "/update/role", method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ClientMessage updateRole(@RequestBody Role role) {
        TroleEntity troleEntity=tUserService.findRoleByName(role.getName());
        if(null!=role.getDescribe()&&
                !"".equals(role.getDescribe().trim())&&
                !troleEntity.getDescribe().equals(role.getDescribe())){
            troleEntity.setDescribe(role.getDescribe());
            tUserService.save(troleEntity);
        }
        if(null!=role.getType()&&
                !"".equals(role.getType().trim())&&
                !troleEntity.getType().equals(role.getType())){
            troleEntity.setType(role.getType());
            tUserService.save(troleEntity);
        }
        ClientMessage clientMessage = new ClientMessage(ResultStatusCode.OK.getCode(),
                ResultStatusCode.OK.getMsg(), "角色更新成功");
        return clientMessage;
    }

    @RequestMapping(value = "/get/roles", method = RequestMethod.GET)
    public ClientMessage getRoles() {
        ClientMessage clientMessage;
        List<TroleEntity> troleEntities=tUserService.findRoleAll();
        if(troleEntities.size()>0){
            clientMessage = new ClientMessage(ResultStatusCode.OK.getCode(),
                    ResultStatusCode.OK.getMsg(), troleEntities);
        }else{
            clientMessage = new ClientMessage(ResultStatusCode.OK.getCode(),
                    ResultStatusCode.OK.getMsg(), "角色列表为空");
        }
        return clientMessage;
    }

    @RequestMapping(value = "/get/roles/{user}", method = RequestMethod.GET)
    public ClientMessage getRolesByUid(@PathVariable String user) {
        ClientMessage clientMessage;
        TuserEntity tuserEntity=tUserService.findByNameOrEmailOrPhone(user);
        List<TroleEntity> troleEntities=tUserService.findRoleByUser(tuserEntity);
        if(troleEntities.size()>0){
            clientMessage = new ClientMessage(ResultStatusCode.OK.getCode(),
                    ResultStatusCode.OK.getMsg(), troleEntities);
        }else{
            clientMessage = new ClientMessage(ResultStatusCode.OK.getCode(),
                    ResultStatusCode.OK.getMsg(), "角色列表为空");
        }
        return clientMessage;
    }

    @RequestMapping(value = "/delete/role/{roleId}", method = RequestMethod.DELETE)
    public ClientMessage deleteRole(@PathVariable String roleId) {
        ClientMessage clientMessage = new ClientMessage(ResultStatusCode.OK.getCode(),
                ResultStatusCode.OK.getMsg(), "角色删除成功");
        tUserService.deleteRole(roleId);
        return clientMessage;
    }

    @RequestMapping(value = "/delete/roles", method = RequestMethod.DELETE)
    public ClientMessage deleteAllRole() {
        ClientMessage clientMessage = new ClientMessage(ResultStatusCode.OK.getCode(),
                ResultStatusCode.OK.getMsg(), "角色删除成功");
        tUserService.deleteAllRole();
        return clientMessage;
    }

    //组管理
    @RequestMapping(value = "/get/groups", method = RequestMethod.GET)
    public ClientMessage getGroups() {
        List<TgroupEntity> tgroupEntities =tUserService.findGroupAll();
        ClientMessage clientMessage = new ClientMessage(ResultStatusCode.OK.getCode(),
                ResultStatusCode.OK.getMsg(), tgroupEntities);

        return clientMessage;
    }

    @RequestMapping(value = "/get/group/{user}", method = RequestMethod.GET)
    public ClientMessage getGroupsByUid(@PathVariable String user) {
        ClientMessage clientMessage;
        TuserEntity tuserEntity=tUserService.findByNameOrEmailOrPhone(user);
        List<TgroupEntity> tgroupEntities=tUserService.findGroupByUser(tuserEntity);
        if(tgroupEntities.size()>0){
            clientMessage = new ClientMessage(ResultStatusCode.OK.getCode(),
                    ResultStatusCode.OK.getMsg(), tgroupEntities);
        }else{
            clientMessage = new ClientMessage(ResultStatusCode.OK.getCode(),
                    ResultStatusCode.OK.getMsg(), "组列表为空");
        }
        return clientMessage;
    }


    @RequestMapping(value = "/create/group", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ClientMessage createGroup(@RequestBody Group group) {
        ClientMessage clientMessage;
        Boolean f = tUserService.createGroup(group.getName().trim(), group.getType().trim(), group.getParentId().trim());
        System.out.println("组：" + group.getName() + (f ? "创建成功！" : "已经存在"));
        if(f){
            clientMessage = new ClientMessage(ResultStatusCode.OK.getCode(),
                    ResultStatusCode.OK.getMsg(), "组创建成功");
            return clientMessage;
        }else{
            clientMessage = new ClientMessage(ResultStatusCode.INVALID_ROLENAME.getCode(),
                    ResultStatusCode.OK.getMsg(), "组已存在，无法创建");
            return clientMessage;
        }
    }
    @RequestMapping(value = "/update/group", method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateGroup(@RequestParam("name") String name, @RequestParam("text") String text, @RequestParam("describe") String describe) {
        Boolean f = tUserService.createRole(name, text, describe);
        System.out.println("角色：" + name + (f ? "成功！" : "已经存在"));
    }
    @RequestMapping(value = "/delete/group", method = RequestMethod.DELETE)
    public void deleteGroup(@RequestParam("name") String name, @RequestParam("text") String text, @RequestParam("describe") String describe) {
        Boolean f = tUserService.createRole(name, text, describe);
        System.out.println("角色：" + name + (f ? "成功！" : "已经存在"));
    }

    //用户管理
    @RequestMapping(value = "/update/user", method = RequestMethod.POST)
    public void updateUser(@RequestParam("name") String name, @RequestParam("text") String text, @RequestParam("describe") String describe) {
        Boolean f = tUserService.createRole(name, text, describe);
        System.out.println("角色：" + name + (f ? "成功！" : "已经存在"));
    }

    @RequestMapping(value = "/get/users", method = RequestMethod.POST)
    public void getUsers(@RequestParam("name") String name, @RequestParam("text") String text, @RequestParam("describe") String describe) {
        Boolean f = tUserService.createRole(name, text, describe);
        System.out.println("角色：" + name + (f ? "成功！" : "已经存在"));
    }

    @RequestMapping(value = "/delete/user", method = RequestMethod.POST)
    public void deleteUser(@RequestParam("name") String name, @RequestParam("text") String text, @RequestParam("describe") String describe) {
        Boolean f = tUserService.createRole(name, text, describe);
        System.out.println("角色：" + name + (f ? "成功！" : "已经存在"));
    }

    //资源管理
    @RequestMapping(value = "/resource", method = RequestMethod.POST)
    public void addResource(@RequestParam("name") String name) {
        tUserService.createResource(name);
    }

    @RequestMapping(value = "/allocation/{uid}/{rid}", method = RequestMethod.GET)
    public void allocationUserRole(@PathVariable String uid, @PathVariable String rid) {
        tUserService.allocationUserRole(tUserService.findUserOne(uid), tUserService.findRoleOne(rid));
    }
}
