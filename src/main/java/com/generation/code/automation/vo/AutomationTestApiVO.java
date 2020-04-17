package com.generation.code.automation.vo;
 
 
public class AutomationTestApiVO {
 
	/**
	 * 模块编号
	 */
 	private String moduleCode;
 	
	/**
	 * 接口编号
	 */
 	private String apiCode;
 	
 	/**
 	 * 接口名称
 	 */
 	private String apiName;
 	
	/**
	 * 接口请求路径
	 */
 	private String apiUrl;
 	
	/**
	 * 接口请求方式
	 */
 	private String apiMethod;
 	
	/**
	 * 请求头
	 */
 	private String apiHeader;
 	
	/**
	 * 请求参数类型：form, json, xml, text
	 */
 	private String apiApplication;
 	
	/**
	 * 接口状态：1启用，2禁用
	 */
 	private String apiStatus;
 	
	/**
	 * 接口请求成功返回编码
	 */
 	private String apiSucceedCode;
 	
	/**
	 * 判断接口结果的属性名
	 */
 	private String apiDiscernResultAttr;
 	
 	public String getApiName() {
		return apiName;
	}

	public void setApiName(String apiName) {
		this.apiName = apiName;
	}

	public String getModuleCode() {
 		return moduleCode;
 	}
 	
 	public void setModuleCode(String moduleCode) {
 		this.moduleCode = moduleCode;
 	}
 	
 	public String getApiCode() {
 		return apiCode;
 	}
 	
 	public void setApiCode(String apiCode) {
 		this.apiCode = apiCode;
 	}
 	
 	public String getApiUrl() {
 		return apiUrl;
 	}
 	
 	public void setApiUrl(String apiUrl) {
 		this.apiUrl = apiUrl;
 	}
 	
 	public String getApiMethod() {
 		return apiMethod;
 	}
 	
 	public void setApiMethod(String apiMethod) {
 		this.apiMethod = apiMethod;
 	}
 	
 	public String getApiHeader() {
 		return apiHeader;
 	}
 	
 	public void setApiHeader(String apiHeader) {
 		this.apiHeader = apiHeader;
 	}
 	
 	public String getApiApplication() {
 		return apiApplication;
 	}
 	
 	public void setApiApplication(String apiApplication) {
 		this.apiApplication = apiApplication;
 	}
 	
 	public String getApiStatus() {
 		return apiStatus;
 	}
 	
 	public void setApiStatus(String apiStatus) {
 		this.apiStatus = apiStatus;
 	}
 	
 	public String getApiSucceedCode() {
 		return apiSucceedCode;
 	}
 	
 	public void setApiSucceedCode(String apiSucceedCode) {
 		this.apiSucceedCode = apiSucceedCode;
 	}
 	
 	public String getApiDiscernResultAttr() {
 		return apiDiscernResultAttr;
 	}
 	
 	public void setApiDiscernResultAttr(String apiDiscernResultAttr) {
 		this.apiDiscernResultAttr = apiDiscernResultAttr;
 	}
 	
	@Override
	public String toString() {
		return "AutomationTestApiVO :" + "，moduleCode=" + moduleCode  + "，apiCode=" + apiCode  + "，apiUrl=" + apiUrl  + "，apiMethod=" + apiMethod  + "，apiHeader=" + apiHeader  + "，apiApplication=" + apiApplication  + "，apiStatus=" + apiStatus  + "，apiSucceedCode=" + apiSucceedCode  + "，apiDiscernResultAttr=" + apiDiscernResultAttr ;
	}

}