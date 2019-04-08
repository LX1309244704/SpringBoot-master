package com.quartz.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyJob implements BaseJob{
	
	 private static Logger _log = LoggerFactory.getLogger(MyJob.class);  
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		_log.error("JobExecutionContext数据 :"+context.getJobDetail().getJobDataMap().get("张三"));
	}

}
