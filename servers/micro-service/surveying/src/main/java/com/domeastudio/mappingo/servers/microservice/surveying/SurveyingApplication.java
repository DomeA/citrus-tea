package com.domeastudio.mappingo.servers.microservice.surveying;

import com.domeastudio.mappingo.servers.microservice.surveying.domain.mongodb.pojo.SmallFileEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.mongodb.repository.SmallFileRepository;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.mongodb.services.FileService;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.TgroupEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.TresourceEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.TroleEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.TuserEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.services.AccountService;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.services.DhtmlxService;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.services.TUserService;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.services.WorkFlowService;
import com.domeastudio.mappingo.servers.microservice.surveying.dto.request.ProcessDefType;
import com.domeastudio.mappingo.servers.microservice.surveying.util.FileUtils;
import com.domeastudio.mappingo.servers.microservice.surveying.util.security.MD5SHAHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.ResourceUtils;

import javax.imageio.stream.FileImageInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@SpringBootApplication
public class SurveyingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SurveyingApplication.class, args);
    }

    //-----------------下面代码处理初始化一个用户-------------
    //用户名:system 用户密码:domea 用户角色:ROLE_SYSADMIN
    //除了system用户，其他用户默认角色ROLE_SIGHTSEER
    //
    @Autowired
    TUserService tUserService;

    @Autowired
    DhtmlxService dhtmlxService;

//    @Autowired
//    SmallFileRepository smallFileRepository;

    @Autowired
    FileService fileService;

    @Autowired
    WorkFlowService workFlowService;

    @Autowired
    AccountService accountService;

    @Autowired
    public void init() {
        try {
            TuserEntity uf = tUserService.createUser("system", "domea", "domeastudio@hotmail.com", "18182669306", true, false, false, "", "", 999999);
            Boolean rf1 = tUserService.createRole("ROLE_SYSADMIN", "系统管理员", "系统管理员角色");
            Boolean rf2 = tUserService.createRole("ROLE_SIGHTSEER", "系统游客", "默认角色,游客角色");
            Boolean rf3 = tUserService.createGroup("GROUP_SYSADMIN", "系统管理员组", "0");

            TgroupEntity tgroupEntity = tUserService.findGroupByName("GROUP_SYSADMIN");
            TuserEntity tuserEntity = tUserService.findUserByName("system");
            TroleEntity troleEntity = tUserService.findRoleByName("ROLE_SYSADMIN");
            Boolean urf = tUserService.allocationUserRole(tuserEntity, troleEntity);
            Boolean uug = tUserService.allocationUserGroup(tuserEntity, tgroupEntity);
            accountService.synAllUserAndRoleToFlowable();

            initResources(troleEntity,"classpath:img/menu32.png","菜单新建图标",
                    "0000-0000-0000-0000-0000-0000-0000-0000-0000-0000",
                    "菜单注册","0","","","",true);
            TresourceEntity tresourceEntity= tUserService.findResourceByCode("0000-0000-0000-0000-0000-0000-0000-0000-0000-0000");

            initResources(troleEntity,"",null,
                    "0000-0001-0000-0000-0000-0000-0000-0000-0000-0000",
                    "新建菜单",tresourceEntity.getReid(),"button","","",false);
            initResources(troleEntity,"",null,
                    "0000-0002-0001-0000-0000-0000-0000-0000-0000-0000",
                    "分割线",tresourceEntity.getReid(),"separator","","",false);

            initResources(troleEntity,"",null,
                    "0000-0002-0000-0000-0000-0000-0000-0000-0000-0000",
                    "修改菜单",tresourceEntity.getReid(),"button","","",false);
            initResources(troleEntity,"",null,
                    "0000-0003-0000-0000-0000-0000-0000-0000-0000-0000",
                    "删除菜单",tresourceEntity.getReid(),"button","","",false);
            initResources(troleEntity,"",null,
                    "0000-0003-0001-0000-0000-0000-0000-0000-0000-0000",
                    "分割线",tresourceEntity.getReid(),"separator","","",false);
            initResources(troleEntity,"",null,
                    "0000-0004-0000-0000-0000-0000-0000-0000-0000-0000",
                    "查询框",tresourceEntity.getReid(),"buttonInput","150","",false);

            initResources(troleEntity,"",null,
                    "0000-0005-0000-0000-0000-0000-0000-0000-0000-0000",
                    "查询",tresourceEntity.getReid(),"button","","",false);


            if (uf != null) {
                System.out.println("管理员账户：system 创建成功");
                System.out.println("管理员账户clientId：" + tuserEntity.getToken());
            } else {
                System.out.println("管理员账户：system 已经存在");
            }
            if (rf1) {
                System.out.println("系统管理员角色：ROLE_SYSADMIN 创建成功");
            } else {
                System.out.println("系统管理员角色：ROLE_SYSADMIN 已经存在");
            }
            if (rf2) {
                System.out.println("系统游客角色：ROLE_SIGHTSEER 创建成功");
            } else {
                System.out.println("系统游客角色：ROLE_SIGHTSEER 已经存在");
            }
            if (rf3) {
                System.out.println("系统管理员组：GROUP_SYSADMIN 创建成功");
            } else {
                System.out.println("系统管理员组：GROUP_SYSADMIN 已经存在");
            }

            if (urf) {
                System.out.println("管理员账户：[system] 被赋予 系统管理员角色：[ROLE_SYSADMIN] 成功");
            } else {
                System.out.println("管理员账户：[system] 被赋予 系统管理员角色：[ROLE_SYSADMIN] 已经存在");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initResources(TroleEntity troleEntity,String imgPath,
                               String iconName,String code,String menuName,
                               String parenId,String type,String width,String height,Boolean select) throws FileNotFoundException {
        File iconFile = null;
        if(null!=imgPath){
            iconFile = ResourceUtils.getFile(imgPath);
        }
        SmallFileEntity smallFileEntity=null;
        if(iconFile.exists()) {
            smallFileEntity = new SmallFileEntity();
            smallFileEntity.setName(iconName);
            smallFileEntity.setContentType("image/png");
            smallFileEntity.setContent(FileUtils.File2Byte(iconFile));
            smallFileEntity.setMd5(MD5SHAHelper.toString(MD5SHAHelper.encryptByMD5(FileUtils.File2Byte(iconFile))));
        }

        TresourceEntity tresourceEntity = new TresourceEntity();
        tresourceEntity.setCode(code);
        tresourceEntity.setName(menuName);
        tresourceEntity.setParenId(parenId);
        tresourceEntity.setWidth(width);
        tresourceEntity.setHeight(height);
        tresourceEntity.setType(type);
        tresourceEntity.setSelected(select);
        Boolean trf = tUserService.createResource(smallFileEntity,tresourceEntity);
        TresourceEntity tresource = dhtmlxService.findByCode(tresourceEntity.getCode());
        Boolean rrf = tUserService.allocationRoleResource(troleEntity, tresource);

        if (trf) {
            System.out.println("菜单初始化：["+menuName+"]创建成功");
        } else {
            System.out.println("菜单初始化：["+menuName+"]已经存在");
        }
        if (rrf) {
            System.out.println("菜单初始化：["+menuName+"] 被赋予 系统管理员角色：[ROLE_SYSADMIN] 成功");
        } else {
            System.out.println("菜单初始化：["+menuName+"] 被赋予 系统管理员角色：[ROLE_SYSADMIN] 已经存在");
        }
    }
}
