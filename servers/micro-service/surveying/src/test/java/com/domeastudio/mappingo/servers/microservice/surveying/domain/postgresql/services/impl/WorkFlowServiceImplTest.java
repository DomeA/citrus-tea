package com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.services.impl;

import com.domeastudio.mappingo.servers.microservice.surveying.SurveyingApplication;
import com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.services.WorkFlowService;
import com.domeastudio.mappingo.servers.microservice.surveying.dto.request.ProcessDefType;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
classes = SurveyingApplication.class)
//@WebAppConfiguration // 由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
//@ContextConfiguration(locations = {"classpath:application.yml"})
public class WorkFlowServiceImplTest {

    @Autowired
    private WorkFlowService workFlowService;

    @Test
    public void deployTest(){
        System.out.println("部署测试开始");
        Deployment deployment = workFlowService.deploymentProcessDefinition("suv",null,null,null,null,null,null,"workflow/suvery.bpmn", ProcessDefType.PATH);
        System.out.println("部署的流程id："+deployment.getId());
        System.out.println("部署的流程名字："+deployment.getName());
        System.out.println("部署的时间戳："+deployment.getDeploymentTime());
        System.out.println("部署测试结束");
    }

    @Test
    public void startProcessInstanceyKey(){
        ProcessInstance processInstance = workFlowService.startProcessInstanceByKey("suvery");

        Task task =workFlowService.currentTaskById(processInstance.getId());
        System.out.println("任务名称："+task.getName());
        workFlowService.complete(task.getId());

        task =workFlowService.currentTaskById(processInstance.getId());
        System.out.println("任务名称："+task.getName());
        workFlowService.complete(task.getId());

        task =workFlowService.currentTaskById(processInstance.getId());
        System.out.println("任务名称："+task.getName());
        workFlowService.complete(task.getId());

        task =workFlowService.currentTaskById(processInstance.getId());
        System.out.println("任务名称："+task);
    }
}
