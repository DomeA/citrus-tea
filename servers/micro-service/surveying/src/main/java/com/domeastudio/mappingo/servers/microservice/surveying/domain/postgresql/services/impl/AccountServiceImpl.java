package com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.services.impl;

import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.RuserroleEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.TroleEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo.TuserEntity;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.repository.RUserRoleRepository;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.repository.TRoleRepository;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.repository.TUserRepository;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.services.AccountService;
import org.apache.commons.lang3.StringUtils;
import org.flowable.engine.IdentityService;
import org.flowable.idm.api.Group;
import org.flowable.idm.api.GroupQuery;
import org.flowable.idm.api.User;
import org.flowable.idm.api.UserQuery;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private TUserRepository tUserRepository;
    @Autowired
    private TRoleRepository tRoleRepository;
    @Autowired
    private IdentityService identityService;
    @Autowired
    private RUserRoleRepository rUserRoleRepository;


    @Override
    public void save(TuserEntity user, TroleEntity role, Boolean synToFlowable) throws ServiceException, Exception {
        TuserEntity tuserEntity = tUserRepository.save(user);
        String userId = tuserEntity.getUid();

        TroleEntity troleEntity=tRoleRepository.save(role);
        String roleId=troleEntity.getRid();

        if(synToFlowable){
            saveFlowableUser(tuserEntity);
            synRoleToFlowable(troleEntity);
            addMembershipToIdentify(userId,roleId);
        }
    }
    /**
     * 同步角色数据到{@link Group}
     */
    private void synRoleToFlowable(TroleEntity troleEntity) {
        TroleEntity allRole = tRoleRepository.findOne(troleEntity.getRid());
        GroupQuery groupQuery = identityService.createGroupQuery();
        List<Group> groupList=groupQuery.groupId(troleEntity.getRid()).list();
        if(groupList.size()>=1){
            String errorMsg = "发现重复组：id=" + troleEntity.getRid();
            //logger.error(errorMsg);
        }else{
            newFlowableGroup(troleEntity);
        }
    }

    private void newFlowableGroup(TroleEntity troleEntity) {
        String groupId = troleEntity.getRid();
        Group group = identityService.newGroup(groupId);
        group.setName(troleEntity.getName());
        group.setType(troleEntity.getType());
        identityService.saveGroup(group);
    }

    /**
     * 保存用户信息，并且同步用户信息到Flowable的identity.User和identify.Group
     *
     * @param user          用户对象{@link TuserEntity}
     * @param rids          用户拥有的角色ID集合
     * @param synToFlowable 是否同步数据到Activiti
     */
    @Override
    public void saveUser(TuserEntity user, List<String> rids, Boolean synToFlowable) {
        // 保存系统用户
        //todo:是否在此处保存系统用户
        TuserEntity tuserEntity = tUserRepository.save(user);
        String userId = tuserEntity.getUid();

        // 同步数据到Flowable Identify模块
        if (synToFlowable) {
            UserQuery userQuery = identityService.createUserQuery();
            List<User> flowableUsers = userQuery.userId(userId).list();

            if (flowableUsers.size() == 1) {
                updateFlowableData(tuserEntity, rids, flowableUsers.get(0));
            } else if (flowableUsers.size() > 1) {
                String errorMsg = "发现重复用户：id=" + userId;
                //logger.error(errorMsg);
                throw new RuntimeException(errorMsg);
            } else {
                newFlowableUser(tuserEntity, rids);
            }
        }
    }

    /**
     * 添加工作流用户以及角色
     *
     * @param user 用户对象{@link TuserEntity}
     * @param rids 用户拥有的角色ID集合
     */
    private void newFlowableUser(TuserEntity user, List<String> rids) {
        String userId = user.getUid();
        // 添加用户
        saveFlowableUser(user);

        // 添加membership
        addMembershipToIdentify(rids, userId);
    }

    /**
     * 添加一个用户到Flowable {@link TuserEntity}
     *
     * @param user 用户对象, {@link TuserEntity}
     */
    private void saveFlowableUser(TuserEntity user) {
        String userId = user.getUid();
        User flowableUser = identityService.newUser(userId);
        cloneAndSaveFlowableUser(user, flowableUser);
        //logger.debug("add flowable user: {}", ToStringBuilder.reflectionToString(flowableUser));
    }

    /**
     * 添加Flowable Identify的用户于组关系
     *
     * @param rids   角色ID集合
     * @param userId 用户ID
     */
    private void addMembershipToIdentify(List<String> rids, String userId) {
        for (String rid : rids) {
            //TroleEntity troleEntity = tRoleRepository.findOne(rid);
            //logger.debug("add role to flowable: {}", role);
            identityService.createMembership(userId, rid);
        }
    }

    /**
     * 添加Flowable Identify的用户于组关系
     *
     * @param rid   角色ID集合
     * @param userId 用户ID
     */
    private void addMembershipToIdentify(String rid, String userId) {
        //TroleEntity troleEntity = tRoleRepository.findOne(rid);
        //logger.debug("add role to flowable: {}", role);
        identityService.createMembership(userId, rid);

    }

    /**
     * 更新工作流用户以及角色
     *
     * @param user         用户对象{@link TuserEntity}
     * @param rids         用户拥有的角色ID集合
     * @param flowableUser Activiti引擎的用户对象，{@link User}
     */
    private void updateFlowableData(TuserEntity user, List<String> rids, User flowableUser) {

        String userId = user.getUid();

        // 更新用户主体信息
        cloneAndSaveFlowableUser(user, flowableUser);

        // 删除用户的membership
        List<Group> flowableGroups = identityService.createGroupQuery().groupMember(userId).list();
        for (Group group : flowableGroups) {
            //logger.debug("delete group from activit: {}", ToStringBuilder.reflectionToString(group));
            identityService.deleteMembership(userId, group.getId());
        }

        // 添加membership
        addMembershipToIdentify(rids, userId);
    }

    /**
     * 使用系统用户对象属性设置到Flowable User对象中
     *
     * @param user         系统用户对象
     * @param flowableUser Flowable User
     */
    private void cloneAndSaveFlowableUser(TuserEntity user, User flowableUser) {
        flowableUser.setFirstName(user.getName());
        flowableUser.setLastName(StringUtils.EMPTY);
        flowableUser.setPassword(StringUtils.EMPTY);
        flowableUser.setEmail(user.getEmail());
        identityService.saveUser(flowableUser);
    }

    @Override
    public void delete(String userId, Boolean synToFlowable) throws ServiceException, Exception {
        // 查询需要删除的用户对象
        TuserEntity user = tUserRepository.findOne(userId);
        if (user == null) {
            throw new ServiceException("删除用户时，找不到ID为" + userId + "的用户");
        }
        /**
         * 同步删除Flowable User Group
         */
        if (synToFlowable) {
            // 同步删除Flowable User
            List<RuserroleEntity> roleList = rUserRoleRepository.findByTuserByUid(user);
            for (RuserroleEntity ruserroleEntity : roleList) {
                TroleEntity troleEntity = ruserroleEntity.getTroleByRid();
                identityService.deleteMembership(userId, troleEntity.getRid());
            }
            // 同步删除Activiti User
            identityService.deleteUser(userId);
        }
        // 删除本系统用户
        tUserRepository.delete(userId);
    }

    @Override
    public void synAllUserAndRoleToFlowable() throws Exception {
        // 清空工作流用户、角色以及关系
        deleteAllFlowableIdentifyData();

        // 复制角色数据
        synRoleToFlowable();

        // 复制用户以及关系数据
        synUserWithRoleToFlowable();
    }

    /**
     * 复制用户以及关系数据
     */
    private void synUserWithRoleToFlowable() {
        List<TuserEntity> allUser = tUserRepository.findAll();
        for (TuserEntity user : allUser) {
            String userId = user.getUid();
            // 添加一个用户到Flowable
            saveFlowableUser(user);
            // 角色和用户的关系
            List<RuserroleEntity> roleList = rUserRoleRepository.findByTuserByUid(user);
            for (RuserroleEntity ruserroleEntity : roleList) {
                TroleEntity troleEntity = ruserroleEntity.getTroleByRid();
                identityService.createMembership(userId, troleEntity.getRid());
                //logger.debug("add membership {user: {}, role: {}}", userId, role.getEnName());
            }
        }
    }

    /**
     * 同步所有角色数据到{@link Group}
     */
    private void synRoleToFlowable() {
        List<TroleEntity> allRole = tRoleRepository.findAll();
        for (TroleEntity role : allRole) {
            newFlowableGroup(role);
        }
    }

    @Override
    public void deleteAllFlowableIdentifyData() throws Exception {
        List<TuserEntity> tuserEntities = tUserRepository.findAll();
        for (TuserEntity tuserEntity : tuserEntities) {
            identityService.deleteUser(tuserEntity.getUid());
        }
        List<TroleEntity> troleEntities = tRoleRepository.findAll();
        for (TroleEntity troleEntity : troleEntities) {
            identityService.deleteGroup(troleEntity.getRid());
        }
        List<RuserroleEntity> ruserroleEntities = rUserRoleRepository.findAll();
        for (RuserroleEntity ruserroleEntity : ruserroleEntities) {
            identityService.deleteMembership(ruserroleEntity.getTuserByUid().getUid(), ruserroleEntity.getTroleByRid().getRid());
        }
    }
}
