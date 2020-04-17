package com.generation.code.automation.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.generation.code.automation.service.AutomationTestApiRunlogService;
import com.generation.code.automation.vo.AutomationTestApiRunlogVO;
import com.generation.code.framework.ResponseModel;




@RequestMapping("/automationTestApiRunlog")
@Controller
public class AutomationTestApiRunlogController {

	@Autowired
	private AutomationTestApiRunlogService automationTestApiRunlogService;
	
	@RequestMapping(value="/insert.do", method=RequestMethod.PUT)
	@ResponseBody
	public ResponseModel insertAutomationTestApiRunlog(AutomationTestApiRunlogVO automationTestApiRunlog, HttpServletRequest request, HttpServletResponse response){
		automationTestApiRunlogService.insertAutomationTestApiRunlog(automationTestApiRunlog);
		return ResponseModel.success("新增成功");
	}
	
	
	@RequestMapping(value="/delete.do", method=RequestMethod.DELETE)
	@ResponseBody
	public ResponseModel deleteAutomationTestApiRunlog(AutomationTestApiRunlogVO automationTestApiRunlog, HttpServletRequest request, HttpServletResponse response){
		automationTestApiRunlogService.deleteAutomationTestApiRunlog(automationTestApiRunlog);
		return ResponseModel.success("删除成功");
	}
	
	
	@RequestMapping(value="/update.do", method=RequestMethod.POST)
	@ResponseBody
	public ResponseModel updateAutomationTestApiRunlog(AutomationTestApiRunlogVO automationTestApiRunlog, HttpServletRequest request, HttpServletResponse response){
		automationTestApiRunlogService.updateAutomationTestApiRunlog(automationTestApiRunlog);
		return ResponseModel.success("更新成功");
	}
	
	
	@RequestMapping(value="/list.do", method=RequestMethod.GET)
	@ResponseBody
	public ResponseModel listAutomationTestApiRunlog(AutomationTestApiRunlogVO automationTestApiRunlog, HttpServletRequest request, HttpServletResponse response){
		List<AutomationTestApiRunlogVO> list = automationTestApiRunlogService.listAutomationTestApiRunlog(automationTestApiRunlog);
		return ResponseModel.success(list);
	}
}

