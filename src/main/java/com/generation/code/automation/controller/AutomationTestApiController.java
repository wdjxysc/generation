package com.generation.code.automation.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.generation.code.automation.service.AutomationTestApiService;
import com.generation.code.automation.vo.AutomationTestApiVO;
import com.generation.code.framework.ResponseModel;




@RequestMapping("/automationTestApi")
@Controller
public class AutomationTestApiController {

	@Autowired
	private AutomationTestApiService automationTestApiService;
	
	@RequestMapping(value="/insert.do", method=RequestMethod.PUT)
	@ResponseBody
	public ResponseModel insertAutomationTestApi(AutomationTestApiVO automationTestApi, HttpServletRequest request, HttpServletResponse response){
		automationTestApiService.insertAutomationTestApi(automationTestApi);
		return ResponseModel.success("新增成功");
	}
	
	
	@RequestMapping(value="/delete.do", method=RequestMethod.DELETE)
	@ResponseBody
	public ResponseModel deleteAutomationTestApi(AutomationTestApiVO automationTestApi, HttpServletRequest request, HttpServletResponse response){
		automationTestApiService.deleteAutomationTestApi(automationTestApi);
		return ResponseModel.success("删除成功");
	}
	
	
	@RequestMapping(value="/update.do", method=RequestMethod.POST)
	@ResponseBody
	public ResponseModel updateAutomationTestApi(AutomationTestApiVO automationTestApi, HttpServletRequest request, HttpServletResponse response){
		automationTestApiService.updateAutomationTestApi(automationTestApi);
		return ResponseModel.success("更新成功");
	}
	
	
	@RequestMapping(value="/list.do", method=RequestMethod.GET)
	@ResponseBody
	public ResponseModel listAutomationTestApi(AutomationTestApiVO automationTestApi, HttpServletRequest request, HttpServletResponse response){
		List<AutomationTestApiVO> list = automationTestApiService.listAutomationTestApi(automationTestApi);
		return ResponseModel.success(list);
	}
}

