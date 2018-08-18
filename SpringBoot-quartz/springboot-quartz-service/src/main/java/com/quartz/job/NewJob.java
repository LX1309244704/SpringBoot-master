package com.quartz.job;

import java.util.Date;  
import org.slf4j.Logger;  
import org.slf4j.LoggerFactory;  
import org.quartz.JobExecutionContext;  
import org.quartz.JobExecutionException;  
  
/**  
* @ClassName: NewJob  
* @Description: TODO()  
* @author lixin(1309244704@qq.com)  
* @date 2018年3月15日 上午10:02:34  
* @version V1.0  
*/ 
public class NewJob implements BaseJob {  
  
    private static Logger _log = LoggerFactory.getLogger(NewJob.class);  
     
    public NewJob() {  
          
    }  
     
    public void execute(JobExecutionContext context)  
        throws JobExecutionException {  
        _log.error("New Job执行时间: " + new Date());  
          
    }  
}  