package com.quartz;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.quartz.api.IJobAndTriggerService;
import com.quartz.util.PageUtil;


/** 
* @ClassName: CapacityCase 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author lixin
* @date 2018年2月24日 上午9:09:59 
*  
*/
@RunWith(SpringRunner.class)  
@SpringBootTest(classes = QuartzApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableTransactionManagement //如果mybatis中service实现类中加入事务注解，需要此处添加该注解
@EnableAutoConfiguration
public class QuartzCase {

	private @Autowired IJobAndTriggerService jobAndTriggerService;
	
	@Test
	public void addJob() throws Exception {
		String jobClassName = "com.quartz.job.NewJob";
		String jobGroupName = "2";
		String cronExpression = "0/5 * * * * ?";
		jobAndTriggerService.addJob(jobClassName, jobGroupName, cronExpression);
	}
	@Test
	public void getPageJob() {
		PageUtil search = new PageUtil();
		Map<String, Object> map=jobAndTriggerService.getPageJob(search);
		System.out.println(map);
	}
	
	@Test
	public void delJob() throws Exception {
		String jobClassName = "com.quartz.job.NewJob";
		String jobGroupName = "2";
		jobAndTriggerService.deleteJob(jobClassName, jobGroupName);
	}
	
}
