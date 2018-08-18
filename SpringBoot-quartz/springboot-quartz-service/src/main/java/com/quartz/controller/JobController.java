package com.quartz.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quartz.BaseController;
import com.quartz.api.IJobAndTriggerService;
import com.quartz.util.PageUtil;
import com.quartz.util.ResponseEntity;

/**  
* @ClassName: JobController  
* @Description: TODO()  
* @author lixin(1309244704@qq.com)  
* @date 2018年8月15日 上午10:02:00  
* @version V1.0  
*/ 
@Controller
@RequestMapping(value = "/job")
public class JobController extends BaseController {
	@Autowired
	private IJobAndTriggerService jobAndTriggerService;

	private static Logger log = LoggerFactory.getLogger(JobController.class);

	@RequestMapping(value = "/datagrid", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> queryjob(PageUtil search, HttpServletRequest request,HttpServletResponse response) {
		log.debug("queryjob");
		setHeader(response);
		search.setParams(getParams(request));
		return jobAndTriggerService.getPageJob(search);
	}
	
	/**
	 * @Title: addJob
	 * @Description: TODO(添加Job)
	 * @param jobClassName
	 *            类名
	 * @param jobGroupName
	 *            组名
	 * @param cronExpression
	 *            表达式，如：0/5 * * * * ? (每隔5秒)
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity addJob(
			@RequestParam(value = "jobClassName") String jobClassName, 
			@RequestParam(value = "jobGroupName") String jobGroupName, 
			@RequestParam(value = "cronExpression") String cronExpression,
			HttpServletResponse response){
		try {
			setHeader(response);
			jobAndTriggerService.addJob(jobClassName, jobGroupName, cronExpression);
			return ResponseEntity.SUCCESS();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.FAILURE(e.getMessage());
		}
	}

	/**
	 * @Title: pauseJob
	 * @Description: TODO(暂停Job)
	 * @param jobClassName
	 *            类名
	 * @param jobGroupName
	 *            组名
	 */
	@RequestMapping(value = "/pause", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity pauseJob(
			@RequestParam(value = "jobClassName") String jobClassName, 
			@RequestParam(value = "jobGroupName") String jobGroupName,
			HttpServletResponse response) {
		try {
			setHeader(response);
			jobAndTriggerService.pauseJob(jobClassName, jobGroupName);
			return ResponseEntity.SUCCESS();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.FAILURE(e.getMessage());
		}
	}

	/**
	 * @Title: resumeJob
	 * @Description: TODO(恢复Job)
	 * @param jobClassName
	 *            类名
	 * @param jobGroupName
	 *            组名
	 */
	@RequestMapping(value = "/resume", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity resumeJob(
			@RequestParam(value = "jobClassName") String jobClassName, 
			@RequestParam(value = "jobGroupName") String jobGroupName,
			HttpServletResponse response) {
		try {
			setHeader(response);
			jobAndTriggerService.resumejob(jobClassName, jobGroupName);
			return ResponseEntity.SUCCESS();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.FAILURE(e.getMessage());
		}
	}

	/**
	 * @Title: rescheduleJob
	 * @Description: TODO(重新设置Job)
	 * @param jobClassName
	 *            类名
	 * @param jobGroupName
	 *            组名
	 * @param cronExpression
	 *            表达式
	 */
	@RequestMapping(value = "/reschedule", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity rescheduleJob(
			@RequestParam(value = "jobClassName") String jobClassName, 
			@RequestParam(value = "jobGroupName") String jobGroupName, 
			@RequestParam(value = "cronExpression") String cronExpression,
			HttpServletResponse response) {
		try {
			setHeader(response);
			jobAndTriggerService.updateJob(jobClassName, jobGroupName, cronExpression);
			return ResponseEntity.SUCCESS();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.FAILURE(e.getMessage());
		}
	}

	/**
	 * @Title: deleteJob
	 * @Description: TODO(删除Job)
	 * @param jobClassName
	 *            类名
	 * @param jobGroupName
	 *            组名
	 * @param cronExpression
	 *            表达式
	 */
	@RequestMapping(value = "/del", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity deleteJob(@RequestParam(value = "jobClassName") String jobClassName, @RequestParam(value = "jobGroupName") String jobGroupName,
			HttpServletResponse response) {
		try {
			setHeader(response);
			jobAndTriggerService.deleteJob(jobClassName, jobGroupName);
			return ResponseEntity.SUCCESS();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.FAILURE(e.getMessage());
		}
	}

	
	/*@PostMapping(value = "/addjob")
	public void addjob(@RequestParam(value = "jobClassName") String jobClassName,
			@RequestParam(value = "jobGroupName") String jobGroupName,
			@RequestParam(value = "cronExpression") String cronExpression) throws Exception {
			jobAndTriggerService.addJob(jobClassName, jobGroupName, cronExpression);
	}

	@PostMapping(value = "/pausejob")
	public void pausejob(@RequestParam(value = "jobClassName") String jobClassName,
			@RequestParam(value = "jobGroupName") String jobGroupName) throws Exception {
		jobAndTriggerService.pauseJob(jobClassName, jobGroupName);
	}

	@PostMapping(value = "/resumejob")
	public void resumejob(@RequestParam(value = "jobClassName") String jobClassName,
			@RequestParam(value = "jobGroupName") String jobGroupName) throws Exception {
		jobAndTriggerService.resumejob(jobClassName, jobGroupName);
	}

	@PostMapping(value = "/reschedulejob")
	public void rescheduleJob(@RequestParam(value = "jobClassName") String jobClassName,
			@RequestParam(value = "jobGroupName") String jobGroupName,
			@RequestParam(value = "cronExpression") String cronExpression) throws Exception {
		jobAndTriggerService.updateJob(jobClassName, jobGroupName, cronExpression);
	}

	@PostMapping(value = "/deletejob")
	public void deletejob(@RequestParam(value = "jobClassName") String jobClassName,
			@RequestParam(value = "jobGroupName") String jobGroupName) throws Exception {
		jobAndTriggerService.deleteJob(jobClassName, jobGroupName);
	}
*/

}
