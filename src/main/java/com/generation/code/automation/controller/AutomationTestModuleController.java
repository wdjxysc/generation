package com.generation.code.automation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.generation.code.automation.service.AutomationTestApiService;
import com.generation.code.automation.service.AutomationTestModuleService;
import com.generation.code.automation.vo.AutomationTestApiVO;
import com.generation.code.automation.vo.AutomationTestModuleVO;
import com.generation.code.framework.ResponseModel;




@RequestMapping("/automationTestModule")
@Controller
public class AutomationTestModuleController {

	@Autowired
	private AutomationTestModuleService automationTestModuleService;
	
	@Autowired
	private AutomationTestApiService automationTestApiService;
	
	@RequestMapping("/index.view")
	public String AutomationTestIndexView() {
		return "/web/automation/automationtest";
	}
	
	@RequestMapping(value="/insert.do", method=RequestMethod.PUT)
	@ResponseBody
	public ResponseModel insertAutomationTestModule(AutomationTestModuleVO automationTestModule, HttpServletRequest request, HttpServletResponse response){
		automationTestModuleService.insertAutomationTestModule(automationTestModule);
		return ResponseModel.success(automationTestModule.getModuleCode());
	}
	
	
	@RequestMapping(value="/delete.do", method=RequestMethod.DELETE)
	@ResponseBody
	public ResponseModel deleteAutomationTestModule(AutomationTestModuleVO automationTestModule, HttpServletRequest request, HttpServletResponse response){
		automationTestModuleService.deleteAutomationTestModule(automationTestModule);
		return ResponseModel.success("删除成功");
	}
	
	
	@RequestMapping(value="/update.do", method=RequestMethod.POST)
	@ResponseBody
	public ResponseModel updateAutomationTestModule(AutomationTestModuleVO automationTestModule, HttpServletRequest request, HttpServletResponse response){
		automationTestModuleService.updateAutomationTestModule(automationTestModule);
		return ResponseModel.success("更新成功");
	}
	
	
	@RequestMapping(value="/list.do", method=RequestMethod.GET)
	@ResponseBody
	public ResponseModel listAutomationTestModule(AutomationTestModuleVO automationTestModule, HttpServletRequest request, HttpServletResponse response){
		List<AutomationTestModuleVO> list = automationTestModuleService.listAutomationTestModule(automationTestModule);
		if(CollectionUtils.isNotEmpty(list)) {
			Map<String, List<AutomationTestApiVO>> result = new HashMap<String, List<AutomationTestApiVO>>();
			AutomationTestApiVO automationTestApi = new AutomationTestApiVO();
			for (int i = 0; i < list.size(); i++) {
				automationTestApi.setModuleCode(list.get(i).getModuleCode());
				List<AutomationTestApiVO> apis = automationTestApiService.listAutomationTestApi(automationTestApi);
				result.put(list.get(i).getModuleName(), apis);
			}
			return ResponseModel.success(result);
		}
		return ResponseModel.success(list);
	}
}

