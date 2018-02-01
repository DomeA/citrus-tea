package com.domeastudio.mappingo.servers.microservice.surveying.rest;

import com.domeastudio.mappingo.servers.microservice.surveying.domain.mongodb.services.FileService;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.services.TUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Api("测绘数据管理服务")
@RestController
@CrossOrigin
@RequestMapping("/manager")
public class DataAPI {

    @Autowired
    TUserService tUserService;

    @Autowired
    FileService fileService;

    @ApiOperation(value = "用于测试服务是否正常", notes = "", httpMethod = "GET")
    @ApiResponse(code = 200, message = "String", response = Map.class)
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public Map<String, String> test() {
        Map<String, String> stringStringMap = new HashMap<>();
        stringStringMap.put("message", "hello world");
        return stringStringMap;
    }

    //角色管理
    @RequestMapping(value = "/create/role", method = RequestMethod.POST)
    public void addRole(@RequestParam("name") String name, @RequestParam("text") String text, @RequestParam("describe") String describe) {
        Boolean f = tUserService.createRole(name, text, describe);
        System.out.println("角色：" + name + (f ? "成功！" : "已经存在"));
    }

    @RequestMapping(value = "/update/role", method = RequestMethod.POST)
    public void updateRole(@RequestParam("name") String name, @RequestParam("text") String text, @RequestParam("describe") String describe) {
        Boolean f = tUserService.createRole(name, text, describe);
        System.out.println("角色：" + name + (f ? "成功！" : "已经存在"));
    }

    @RequestMapping(value = "/delete/role", method = RequestMethod.POST)
    public void deleteRole(@RequestParam("name") String name, @RequestParam("text") String text, @RequestParam("describe") String describe) {
        Boolean f = tUserService.createRole(name, text, describe);
        System.out.println("角色：" + name + (f ? "成功！" : "已经存在"));
    }

    @RequestMapping(value = "/get/roles", method = RequestMethod.POST)
    public void getRoles(@RequestParam("name") String name, @RequestParam("text") String text, @RequestParam("describe") String describe) {
        Boolean f = tUserService.createRole(name, text, describe);
        System.out.println("角色：" + name + (f ? "成功！" : "已经存在"));
    }

    //组管理
    @RequestMapping(value = "/get/groups", method = RequestMethod.POST)
    public void getGroups(@RequestParam("name") String name, @RequestParam("text") String text, @RequestParam("describe") String describe) {
        Boolean f = tUserService.createRole(name, text, describe);
        System.out.println("角色：" + name + (f ? "成功！" : "已经存在"));
    }
    @RequestMapping(value = "/create/group", method = RequestMethod.POST)
    public void createGroup(@RequestParam("name") String name, @RequestParam("text") String text, @RequestParam("describe") String describe) {
        Boolean f = tUserService.createRole(name, text, describe);
        System.out.println("角色：" + name + (f ? "成功！" : "已经存在"));
    }
    @RequestMapping(value = "/update/group", method = RequestMethod.POST)
    public void updateGroup(@RequestParam("name") String name, @RequestParam("text") String text, @RequestParam("describe") String describe) {
        Boolean f = tUserService.createRole(name, text, describe);
        System.out.println("角色：" + name + (f ? "成功！" : "已经存在"));
    }
    @RequestMapping(value = "/delete/group", method = RequestMethod.POST)
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
