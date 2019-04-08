package com.quartz.api;


import java.util.Map;

import com.quartz.dto.JobAndTriggerDto;
import com.quartz.util.PageUtil;


/**  
* @ClassName: IJobAndTriggerService  
* @Description: TODO(quartz接口)  
* @author lixin(1309244704@qq.com)  
* @date 2018年3月15日 上午10:00:07  
* @version V1.0  
*/ 
public interface IJobAndTriggerService {
	/**  
	* @Title: getPageJob  
	* @Description: TODO(查询定时任务，分页)  
	* @param @param search
	* @param @return    参数  
	* @return Map<String,Object>    返回类型  
	* @throws  
	*/ 
	public Map<String, Object> getPageJob(PageUtil search);
	
	/**  
	* @Title: getPageJobmod  
	* @Description: TODO(查询定时任务)  
	* @param @return    参数  
	* @return JobAndTriggerDto    返回类型  
	* @throws  
	*/ 
	public JobAndTriggerDto getPageJobmod();
	
	/**  
	* @Title: addJob  
	* @Description: TODO(添加任务)  
	* @param @param jobClassName 任务路径名称
	* @param @param jobGroupName 任务分组
	* @param @param cronExpression cron时间规则
	* @param @throws Exception    参数  
	* @return void    返回类型  
	* @throws  
	*/ 
	public void addJob(String jobClassName, String jobGroupName, String cronExpression) throws Exception;
	
	/** 
	* @Title: addJob 
	* @Description: TODO(添加动态任务) 
	* @param @param jobClassName 任务路径名称
	* @param @param jobGroupName 任务分组
	* @param @param cronExpression cron时间规则
	* @param @param jobDescription 参数 
	* @param @param params
	* @param @throws Exception  参数说明 
	* @return void    返回类型 
	* @throws 
	*/
	public void addJob(String jobClassName, String jobGroupName, String cronExpression, String jobDescription, Map<String, Object> params) throws Exception;
	
	/**  
	* @Title: updateJob  
	* @Description: TODO(更新定时任务)  
	* @param @param jobClassName 任务路径名称
	* @param @param jobGroupName 任务分组
	* @param @param cronExpression cron时间规则
	* @param @throws Exception    参数  
	* @return void    返回类型  
	* @throws  
	*/ 
	public void updateJob(String jobClassName, String jobGroupName, String cronExpression) throws Exception;
	
	/**  
	* @Title: deleteJob  
	* @Description: TODO(删除定时任务)  
	* @param @param jobClassName 任务路径名称
	* @param @param jobGroupName 任务分组
	* @param @throws Exception    参数  
	* @return void    返回类型  
	* @throws  
	*/ 
	public void deleteJob(String jobClassName, String jobGroupName) throws Exception;
	
	/**  
	* @Title: pauseJob  
	* @Description: TODO(暂停定时任务)  
	* @param @param jobClassName 任务路径名称
	* @param @param jobGroupName 任务分组
	* @param @throws Exception    参数  
	* @return void    返回类型  
	* @throws  
	*/ 
	public void pauseJob(String jobClassName, String jobGroupName) throws Exception;
	
	/**  
	* @Title: resumejob  
	* @Description: TODO(恢复任务)  
	* @param @param jobClassName 任务路径名称
	* @param @param jobGroupName 任务分组
	* @param @throws Exception    参数  
	* @return void    返回类型  
	* @throws  
	*/ 
	public void resumejob(String jobClassName, String jobGroupName) throws Exception;
}
