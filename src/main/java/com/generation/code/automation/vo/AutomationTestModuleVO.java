package com.generation.code.automation.vo;
 
 
public class AutomationTestModuleVO {
 
	/**
	 * 模块名称
	 */
 	private String moduleName;
 	
	/**
	 * 模块编号
	 */
 	private String moduleCode;
 	
 	public String getModuleName() {
 		return moduleName;
 	}
 	
 	public void setModuleName(String moduleName) {
 		this.moduleName = moduleName;
 	}
 	
 	public String getModuleCode() {
 		return moduleCode;
 	}
 	
 	public void setModuleCode(String moduleCode) {
 		this.moduleCode = moduleCode;
 	}
 	
	@Override
	public String toString() {
		return "AutomationTestModuleVO :" + "，moduleName=" + moduleName  + "，moduleCode=" + moduleCode ;
	}

}