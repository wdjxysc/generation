package com.generation.code.automation.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.generation.code.automation.service.AutomationTestApiParamsService;
import com.generation.code.automation.vo.AutomationTestApiParamsVO;
import com.generation.code.framework.ResponseModel;




@RequestMapping("/automationTestApiParams")
@Controller
public class AutomationTestApiParamsController {

	@Autowired
	private AutomationTestApiParamsService automationTestApiParamsService;
	
	@RequestMapping(value="/insert.do", method=RequestMethod.PUT)
	@ResponseBody
	public ResponseModel insertAutomationTestApiParams(AutomationTestApiParamsVO automationTestApiParams, HttpServletRequest request, HttpServletResponse response){
		automationTestApiParamsService.insertAutomationTestApiParams(automationTestApiParams);
		return ResponseModel.success("新增成功");
	}
	
	
	@RequestMapping(value="/delete.do", method=RequestMethod.DELETE)
	@ResponseBody
	public ResponseModel deleteAutomationTestApiParams(AutomationTestApiParamsVO automationTestApiParams, HttpServletRequest request, HttpServletResponse response){
		automationTestApiParamsService.deleteAutomationTestApiParams(automationTestApiParams);
		return ResponseModel.success("删除成功");
	}
	
	
	@RequestMapping(value="/update.do", method=RequestMethod.POST)
	@ResponseBody
	public ResponseModel updateAutomationTestApiParams(AutomationTestApiParamsVO automationTestApiParams, HttpServletRequest request, HttpServletResponse response){
		automationTestApiParamsService.updateAutomationTestApiParams(automationTestApiParams);
		return ResponseModel.success("更新成功");
	}
	
	
	@RequestMapping(value="/list.do", method=RequestMethod.GET)
	@ResponseBody
	public ResponseModel listAutomationTestApiParams(AutomationTestApiParamsVO automationTestApiParams, HttpServletRequest request, HttpServletResponse response){
		List<AutomationTestApiParamsVO> list = automationTestApiParamsService.listAutomationTestApiParams(automationTestApiParams);
		return ResponseModel.success(list);
	}
}

