package com.generation.code.automation.vo;
 
 
public class AutomationTestApiParamsVO {
 
	/**
	 * 接口编号
	 */
 	private String apiCode;
 	
	/**
	 * 参数key
	 */
 	private String apiParamKey;
 	
	/**
	 * 参数value
	 */
 	private String apiParamValue;
 	
	/**
	 * 参数类型
	 */
 	private String apiParamType;
 	
	/**
	 * 参数前缀
	 */
 	private String apiParamPrefix;
 	
	/**
	 * 是否随机生成参数
	 */
 	private Integer apiParamRandomValue;
 	
	/**
	 * 参数是否必填，默认否
	 */
 	private Integer apiParamRequired;
 	
	/**
	 * 参数最大长度
	 */
 	private Integer apiParamMaxLength;
 	
 	public String getApiCode() {
 		return apiCode;
 	}
 	
 	public void setApiCode(String apiCode) {
 		this.apiCode = apiCode;
 	}
 	
 	public String getApiParamKey() {
 		return apiParamKey;
 	}
 	
 	public void setApiParamKey(String apiParamKey) {
 		this.apiParamKey = apiParamKey;
 	}
 	
 	public String getApiParamValue() {
 		return apiParamValue;
 	}
 	
 	public void setApiParamValue(String apiParamValue) {
 		this.apiParamValue = apiParamValue;
 	}
 	
 	public String getApiParamType() {
 		return apiParamType;
 	}
 	
 	public void setApiParamType(String apiParamType) {
 		this.apiParamType = apiParamType;
 	}
 	
 	public String getApiParamPrefix() {
 		return apiParamPrefix;
 	}
 	
 	public void setApiParamPrefix(String apiParamPrefix) {
 		this.apiParamPrefix = apiParamPrefix;
 	}
 	
 	public Integer getApiParamRandomValue() {
 		return apiParamRandomValue;
 	}
 	
 	public void setApiParamRandomValue(Integer apiParamRandomValue) {
 		this.apiParamRandomValue = apiParamRandomValue;
 	}
 	
 	public Integer getApiParamRequired() {
 		return apiParamRequired;
 	}
 	
 	public void setApiParamRequired(Integer apiParamRequired) {
 		this.apiParamRequired = apiParamRequired;
 	}
 	
 	public Integer getApiParamMaxLength() {
 		return apiParamMaxLength;
 	}
 	
 	public void setApiParamMaxLength(Integer apiParamMaxLength) {
 		this.apiParamMaxLength = apiParamMaxLength;
 	}
 	
	@Override
	public String toString() {
		return "AutomationTestApiParamsVO :" + "，apiCode=" + apiCode  + "，apiParamKey=" + apiParamKey  + "，apiParamValue=" + apiParamValue  + "，apiParamType=" + apiParamType  + "，apiParamPrefix=" + apiParamPrefix  + "，apiParamRandomValue=" + apiParamRandomValue  + "，apiParamRequired=" + apiParamRequired  + "，apiParamMaxLength=" + apiParamMaxLength ;
	}

}