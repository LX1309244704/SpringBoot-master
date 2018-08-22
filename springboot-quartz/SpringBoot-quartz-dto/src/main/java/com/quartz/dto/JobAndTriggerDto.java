package com.quartz.dto;

/**  
* @ClassName: JobAndTriggerDto  
* @Description: TODO()  
* @author lixin(1309244704@qq.com)  
* @date 2018年3月15日 上午10:01:16  
* @version V1.0  
*/ 
public class JobAndTriggerDto implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String jobName;
	private String jobDescription;
	private String jobGroupName;
	private String jobClassName;
	private String triggerName;
	private String triggerGroupName;
	private String prevFireTime;
	private String nextFireTime;
	private String cronExpression;
	private String triggerState;

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getJobGroupName() {
		return jobGroupName;
	}

	public void setJobGroupName(String jobGroupName) {
		this.jobGroupName = jobGroupName;
	}

	public String getJobClassName() {
		return jobClassName;
	}

	public void setJobClassName(String jobClassName) {
		this.jobClassName = jobClassName;
	}

	public String getTriggerName() {
		return triggerName;
	}

	public void setTriggerName(String triggerName) {
		this.triggerName = triggerName;
	}

	public String getTriggerGroupName() {
		return triggerGroupName;
	}

	public void setTriggerGroupName(String triggerGroupName) {
		this.triggerGroupName = triggerGroupName;
	}

	public String getPrevFireTime() {
		return prevFireTime;
	}

	public void setPrevFireTime(String prevFireTime) {
		this.prevFireTime = prevFireTime;
	}

	public String getNextFireTime() {
		return nextFireTime;
	}

	public void setNextFireTime(String nextFireTime) {
		this.nextFireTime = nextFireTime;
	}

	public String getCronExpression() {
		return cronExpression;
	}

	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}

	public String getTriggerState() {
		return triggerState;
	}

	public void setTriggerState(String triggerState) {
		this.triggerState = triggerState;
	}

	@Override
	public String toString() {
		return "JobAndTriggerDto [jobName=" + jobName + ", jobDescription=" + jobDescription + ", jobGroupName="
				+ jobGroupName + ", jobClassName=" + jobClassName + ", triggerName=" + triggerName
				+ ", triggerGroupName=" + triggerGroupName + ", prevFireTime=" + prevFireTime + ", nextFireTime="
				+ nextFireTime + ", cronExpression=" + cronExpression + ", triggerState=" + triggerState + "]";
	}
	
}
