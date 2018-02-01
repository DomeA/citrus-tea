package com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.services;

import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.TgroupEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.TroleEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.TuserEntity;
import org.hibernate.service.spi.ServiceException;

import java.util.List;

public interface AccountService {
    /**
     * 添加用户并[同步其他数据库]
     * <ul>
     * <li>step 1: 保存系统用户，同时设置和部门的关系</li>
     * <li>step 2: 同步用户信息到activiti的identity.User，同时设置角色</li>
     * </ul>
     *
     * @param user          用户对象
     * @param role          部门ID
     * @param synToFlowable 是否同步到Activiti数据库，通过配置文件方式设置，使用属性：account.user.add.syntoactiviti
     * @throws ServiceException 关联用户和部门的时候从数据库查询不到哦啊部门对象
     * @throws Exception        其他未知异常
     */
    void save(TuserEntity user, TroleEntity role, Boolean synToFlowable)
            throws ServiceException, Exception;

    void saveUser(TuserEntity user, List<String> rids, Boolean synToActiviti);

    void saveGroup(TgroupEntity tgroupEntity);

    /**
     * 删除用户
     *
     * @param userId        用户ID
     * @param synToFlowable 是否同步到Activiti数据库，通过配置文件方式设置，使用属性：account.user.add.syntoactiviti
     * @throws Exception
     */
    void delete(String userId, Boolean synToFlowable) throws ServiceException, Exception;

    /**
     * 同步用户、角色数据到工作流
     *
     * @throws Exception
     */
    void synAllUserAndRoleToFlowable() throws Exception;

    /**
     * 删除工作流引擎Activiti的用户、角色以及关系
     *
     * @throws Exception
     */
    void deleteAllFlowableIdentifyData() throws Exception;
}
