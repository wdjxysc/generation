package com.generation.code.automation.vo;
 
import java.util.Date;
 
public class AutomationTestApiRunlogVO {
 
	/**
	 * 接口编号
	 */
 	private String apiCode;
 	
	/**
	 * 接口返回结果
	 */
 	private String apiRunStatus;
 	
	/**
	 * 接口返回结果编码
	 */
 	private String apiRunStatusCode;
 	
	/**
	 * 返回结果内容
	 */
 	private String apiRunResultContent;
 	
	/**
	 * 日志写入时间
	 */
 	private Date apiRunDate;
 	
 	public String getApiCode() {
 		return apiCode;
 	}
 	
 	public void setApiCode(String apiCode) {
 		this.apiCode = apiCode;
 	}
 	
 	public String getApiRunStatus() {
 		return apiRunStatus;
 	}
 	
 	public void setApiRunStatus(String apiRunStatus) {
 		this.apiRunStatus = apiRunStatus;
 	}
 	
 	public String getApiRunStatusCode() {
 		return apiRunStatusCode;
 	}
 	
 	public void setApiRunStatusCode(String apiRunStatusCode) {
 		this.apiRunStatusCode = apiRunStatusCode;
 	}
 	
 	public String getApiRunResultContent() {
 		return apiRunResultContent;
 	}
 	
 	public void setApiRunResultContent(String apiRunResultContent) {
 		this.apiRunResultContent = apiRunResultContent;
 	}
 	
 	public Date getApiRunDate() {
 		return apiRunDate;
 	}
 	
 	public void setApiRunDate(Date apiRunDate) {
 		this.apiRunDate = apiRunDate;
 	}
 	
	@Override
	public String toString() {
		return "AutomationTestApiRunlogVO :" + "，apiCode=" + apiCode  + "，apiRunStatus=" + apiRunStatus  + "，apiRunStatusCode=" + apiRunStatusCode  + "，apiRunResultContent=" + apiRunResultContent  + "，apiRunDate=" + apiRunDate ;
	}

}