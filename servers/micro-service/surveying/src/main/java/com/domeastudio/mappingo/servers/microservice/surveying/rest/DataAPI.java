package com.domeastudio.mappingo.servers.microservice.surveying.rest;

import com.domeastudio.mappingo.servers.microservice.surveying.domain.mongodb.services.FileService;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.TgroupEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.TroleEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.TuserEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.services.AccountService;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.services.TUserService;
import com.domeastudio.mappingo.servers.microservice.surveying.dto.request.Group;
import com.domeastudio.mappingo.servers.microservice.surveying.dto.request.Register;
import com.domeastudio.mappingo.servers.microservice.surveying.dto.request.Role;
import com.domeastudio.mappingo.servers.microservice.surveying.dto.response.ClientMessage;
import com.domeastudio.mappingo.servers.microservice.surveying.dto.response.ResultStatusCode;
import com.domeastudio.mappingo.servers.microservice.surveying.dto.response.UserObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api("测绘数据管理服务")
@RestController
@CrossOrigin
@RequestMapping("/manager")
public class DataAPI {
    private static final Logger logger = LoggerFactory.getLogger(FileAPI.class);

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
    @RequestMapping(value = "/create/role", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ClientMessage createRole(@RequestBody Role role) {
        ClientMessage clientMessage;
        Boolean f = tUserService.createRole(role.getName().trim(), role.getType().trim(), role.getDescribe().trim());
        System.out.println("角色：" + role.getName() + (f ? "创建成功！" : "已经存在"));
        if (f) {
            clientMessage = new ClientMessage(ResultStatusCode.OK.getCode(),
                    ResultStatusCode.OK.getMsg(), "角色创建成功");
            return clientMessage;
        } else {
            clientMessage = new ClientMessage(ResultStatusCode.INVALID_ROLENAME.getCode(),
                    ResultStatusCode.INVALID_ROLENAME.getMsg(), "角色已存在，无法创建");
            return clientMessage;
        }
    }

    @RequestMapping(value = "/update/role", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ClientMessage updateRole(@RequestBody Role role) {
        TroleEntity troleEntity = tUserService.findRoleByName(role.getName());
        if (null != role.getDescribe() &&
                !"".equals(role.getDescribe().trim()) &&
                !troleEntity.getDescribe().equals(role.getDescribe())) {
            troleEntity.setDescribe(role.getDescribe());
            tUserService.save(troleEntity);
        }
        if (null != role.getType() &&
                !"".equals(role.getType().trim()) &&
                !troleEntity.getType().equals(role.getType())) {
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
        List<TroleEntity> troleEntities = tUserService.findRoleAll();
        if (troleEntities.size() > 0) {
            clientMessage = new ClientMessage(ResultStatusCode.OK.getCode(),
                    ResultStatusCode.OK.getMsg(), troleEntities);
        } else {
            clientMessage = new ClientMessage(ResultStatusCode.OK.getCode(),
                    ResultStatusCode.OK.getMsg(), "角色列表为空");
        }
        return clientMessage;
    }

    @RequestMapping(value = "/get/roles/{user}", method = RequestMethod.GET)
    public ClientMessage getRolesByUid(@PathVariable String user) {
        ClientMessage clientMessage;
        TuserEntity tuserEntity = tUserService.findByNameOrEmailOrPhone(user);
        List<TroleEntity> troleEntities = tUserService.findRoleByUser(tuserEntity);
        if (troleEntities.size() > 0) {
            clientMessage = new ClientMessage(ResultStatusCode.OK.getCode(),
                    ResultStatusCode.OK.getMsg(), troleEntities);
        } else {
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
        List<TgroupEntity> tgroupEntities = tUserService.findGroupAll();
        ClientMessage clientMessage = new ClientMessage(ResultStatusCode.OK.getCode(),
                ResultStatusCode.OK.getMsg(), tgroupEntities);
        return clientMessage;
    }

    @RequestMapping(value = "/get/group/{user}", method = RequestMethod.GET)
    public ClientMessage getGroupsByUid(@PathVariable String user) {
        ClientMessage clientMessage;
        TuserEntity tuserEntity = tUserService.findByNameOrEmailOrPhone(user);
        List<TgroupEntity> tgroupEntities = tUserService.findGroupByUser(tuserEntity);
        if (tgroupEntities.size() > 0) {
            clientMessage = new ClientMessage(ResultStatusCode.OK.getCode(),
                    ResultStatusCode.OK.getMsg(), tgroupEntities);
        } else {
            clientMessage = new ClientMessage(ResultStatusCode.OK.getCode(),
                    ResultStatusCode.OK.getMsg(), "组列表为空");
        }
        return clientMessage;
    }


    @RequestMapping(value = "/create/group", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ClientMessage createGroup(@RequestBody Group group) {
        ClientMessage clientMessage;
        Boolean f = tUserService.createGroup(group.getName().trim(), group.getType().trim(), group.getParentId().trim());
        System.out.println("组：" + group.getName() + (f ? "创建成功！" : "已经存在"));
        if (f) {
            clientMessage = new ClientMessage(ResultStatusCode.OK.getCode(),
                    ResultStatusCode.OK.getMsg(), "组创建成功");
            return clientMessage;
        } else {
            clientMessage = new ClientMessage(ResultStatusCode.INVALID_ROLENAME.getCode(),
                    ResultStatusCode.INVALID_ROLENAME.getMsg(), "组已存在，无法创建");
            return clientMessage;
        }
    }

    @RequestMapping(value = "/update/group", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ClientMessage updateGroup(@RequestBody Group group) {
        TgroupEntity tgroupEntity = tUserService.findGroupByName(group.getName());
        if (null != group.getType() &&
                !"".equals(group.getType().trim()) &&
                !tgroupEntity.getType().equals(group.getType())) {
            group.setType(group.getType());
            tUserService.save(tgroupEntity);
        }
        if (null != group.getName() &&
                !"".equals(group.getName().trim()) &&
                !tgroupEntity.getName().equals(group.getName())) {
            tgroupEntity.setName(group.getName());
            tUserService.save(tgroupEntity);
        }
        if (null != group.getParentId() &&
                !"".equals(group.getParentId().trim()) &&
                !tgroupEntity.getParentId().equals(group.getParentId())) {
            tgroupEntity.setParentId(group.getParentId());
            tUserService.save(tgroupEntity);
        }
        ClientMessage clientMessage = new ClientMessage(ResultStatusCode.OK.getCode(),
                ResultStatusCode.OK.getMsg(), "组更新成功");
        return clientMessage;
    }

    @RequestMapping(value = "/delete/group/{groupId}", method = RequestMethod.DELETE)
    public ClientMessage deleteGroup(@PathVariable String groupId) {
        ClientMessage clientMessage = new ClientMessage(ResultStatusCode.OK.getCode(),
                ResultStatusCode.OK.getMsg(), "组删除成功");
        tUserService.deleteGroup(groupId);
        return clientMessage;
    }

    //用户管理
    @RequestMapping(value = "/update/user", method = RequestMethod.POST)
    public void updateUser(@RequestBody Register register) {
        TuserEntity tuserEntity = tUserService.findByNameOrEmailOrPhone(register.getName());
    }

    @RequestMapping(value = "/get/users", method = RequestMethod.GET)
    public ClientMessage getUsers() {
        ClientMessage clientMessage;
        List<TuserEntity> tuserEntities = tUserService.findUserAll();
        if (tuserEntities.size() > 0) {
            List<UserObject> userObjects=new ArrayList<>();
            for(TuserEntity tuserEntity:tuserEntities){
                UserObject userObject=new UserObject();
                userObject.setEmail(tuserEntity.getEmail());
                userObject.setId(tuserEntity.getUid());
                userObject.setName(tuserEntity.getName());
                userObject.setPhone(tuserEntity.getPhone());
               // userObject.setRealName(tuserEntity.getTuserinfoByUiid().getRealName());
                userObjects.add(userObject);
            }
            clientMessage = new ClientMessage(ResultStatusCode.OK.getCode(),
                    ResultStatusCode.OK.getMsg(), userObjects);
        } else {
            clientMessage = new ClientMessage(ResultStatusCode.SYSTEM_ERR.getCode(),
                    ResultStatusCode.SYSTEM_ERR.getMsg(), "用户列表不存在");
        }
        return clientMessage;
    }

    @RequestMapping(value = "/get/user/{user}", method = RequestMethod.GET)
    public ClientMessage getUserByUid(@PathVariable String user) {
        ClientMessage clientMessage;
        TuserEntity tuserEntity = tUserService.findByNameOrEmailOrPhone(user);
        if (tuserEntity != null) {
            clientMessage = new ClientMessage(ResultStatusCode.OK.getCode(),
                    ResultStatusCode.OK.getMsg(), tuserEntity);
        } else {
            clientMessage = new ClientMessage(ResultStatusCode.INVALID_USERNAME.getCode(),
                    ResultStatusCode.INVALID_USERNAME.getMsg(), "用户不存在");
        }
        return clientMessage;
    }

    @RequestMapping(value = "/get/users/{groupId}", method = RequestMethod.GET)
    public ClientMessage getUsersByGid(@PathVariable String groupId) {
        ClientMessage clientMessage;
        TgroupEntity tgroupEntity = tUserService.findGroupOne(groupId);

        List<TuserEntity> tuserEntities = tUserService.findUserByGroup(tgroupEntity);

        if (tuserEntities.size() > 0) {
            clientMessage = new ClientMessage(ResultStatusCode.OK.getCode(),
                    ResultStatusCode.OK.getMsg(), tuserEntities);
        } else {
            clientMessage = new ClientMessage(ResultStatusCode.OK.getCode(),
                    ResultStatusCode.OK.getMsg(), "当前组内用户列表不存在");
        }
        return clientMessage;
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

    //分配 用户 角色 关系
    @RequestMapping(value = "/allocation/{uid}/{rid}", method = RequestMethod.GET)
    public void allocationUserRole(@RequestBody String uid, @RequestBody String rid) {
        tUserService.allocationUserRole(tUserService.findUserOne(uid), tUserService.findRoleOne(rid));

    }

    //分配 用户 组 关系
    @RequestMapping(value = "/allocation/{uid}/{gid}", method = RequestMethod.GET)
    public void allocationUserGroup(@PathVariable String uid, @PathVariable String gid) {
        tUserService.allocationUserGroup(tUserService.findUserOne(uid), tUserService.findGroupOne(gid));
    }

    //分配 用户 资源 关系
    @RequestMapping(value = "/allocation/{uid}/{reid}", method = RequestMethod.GET)
    public void allocationUserResource(@PathVariable String uid, @PathVariable String rid) {
        tUserService.allocationUserRole(tUserService.findUserOne(uid), tUserService.findRoleOne(rid));
    }

    //分配 角色 资源 关系
    @RequestMapping(value = "/allocation/{rid}/{reid}", method = RequestMethod.GET)
    public void allocationRoleResource(@PathVariable String uid, @PathVariable String rid) {
        tUserService.allocationUserRole(tUserService.findUserOne(uid), tUserService.findRoleOne(rid));
    }

    //删除 角色 资源 关系
    @RequestMapping(value = "/delallocation/{rid}/{reid}", method = RequestMethod.DELETE)
    public void delAllocationRoleResource(@PathVariable String uid, @PathVariable String rid) {
        tUserService.allocationUserRole(tUserService.findUserOne(uid), tUserService.findRoleOne(rid));
    }

    //分配 用户 资源 关系
    @RequestMapping(value = "/allocation/{uid}/{reid}", method = RequestMethod.DELETE)
    public void delAllocationUserResource(@PathVariable String uid, @PathVariable String rid) {
        tUserService.allocationUserRole(tUserService.findUserOne(uid), tUserService.findRoleOne(rid));
    }

    //删除 用户 角色 关系
    @RequestMapping(value = "/allocation/{uid}/{rid}", method = RequestMethod.DELETE)
    public void delAllocationUserRole(@PathVariable String uid, @PathVariable String rid) {
        tUserService.allocationUserRole(tUserService.findUserOne(uid), tUserService.findRoleOne(rid));
    }

    //删除 用户 组 关系
    @RequestMapping(value = "/allocation/{rid}/{gid}", method = RequestMethod.DELETE)
    public void delAllocationUserGroup(@PathVariable String uid, @PathVariable String rid) {
        tUserService.allocationUserRole(tUserService.findUserOne(uid), tUserService.findRoleOne(rid));
    }
}
