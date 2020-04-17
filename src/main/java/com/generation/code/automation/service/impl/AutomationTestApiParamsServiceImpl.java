package com.generation.code.automation.service.impl;

import com.generation.code.automation.vo.AutomationTestApiParamsVO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.generation.code.automation.service.AutomationTestApiParamsService;
import com.generation.code.automation.dao.AutomationTestApiParamsDAO;

/**   
 * @formatClassName:  AutomationTestApiParamsServiceImpl   
 * @Description:TODO    
 * @author: generation
 * @date:   2019年06月05日 02:45:917
 * @Copyright: generation
 */
@Service
public class AutomationTestApiParamsServiceImpl implements AutomationTestApiParamsService{
	
	@Autowired
	private AutomationTestApiParamsDAO automationTestApiParamsDAO;
	
	@Override
	public void insertAutomationTestApiParams(AutomationTestApiParamsVO automationTestApiParams){
		automationTestApiParamsDAO.insertAutomationTestApiParams(automationTestApiParams);
	}
	
	@Override
	public void deleteAutomationTestApiParams(AutomationTestApiParamsVO automationTestApiParams){
		automationTestApiParamsDAO.deleteAutomationTestApiParams(automationTestApiParams);
	}
	
	@Override
	public void updateAutomationTestApiParams(AutomationTestApiParamsVO automationTestApiParams){
		automationTestApiParamsDAO.updateAutomationTestApiParams(automationTestApiParams);
	}
	
	@Override
	public List<AutomationTestApiParamsVO> listAutomationTestApiParams(AutomationTestApiParamsVO automationTestApiParams){
		List<AutomationTestApiParamsVO> list = automationTestApiParamsDAO.listAutomationTestApiParams(automationTestApiParams);
		return list;
	}
}