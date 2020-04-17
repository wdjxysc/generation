package com.generation.code.automation.service.impl;

import com.generation.code.automation.vo.AutomationTestModuleVO;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.generation.code.automation.service.AutomationTestModuleService;
import com.generation.code.automation.dao.AutomationTestModuleDAO;

/**   
 * @formatClassName:  AutomationTestModuleServiceImpl   
 * @Description:TODO    
 * @author: generation
 * @date:   2019年06月05日 02:45:912
 * @Copyright: generation
 */
@Service
public class AutomationTestModuleServiceImpl implements AutomationTestModuleService{
	
	@Autowired
	private AutomationTestModuleDAO automationTestModuleDAO;
	
	@Override
	public void insertAutomationTestModule(AutomationTestModuleVO automationTestModule){
		automationTestModule.setModuleCode(UUID.randomUUID().toString());
		automationTestModuleDAO.insertAutomationTestModule(automationTestModule);
	}
	
	@Override
	public void deleteAutomationTestModule(AutomationTestModuleVO automationTestModule){
		automationTestModuleDAO.deleteAutomationTestModule(automationTestModule);
	}
	
	@Override
	public void updateAutomationTestModule(AutomationTestModuleVO automationTestModule){
		automationTestModuleDAO.updateAutomationTestModule(automationTestModule);
	}
	
	@Override
	public List<AutomationTestModuleVO> listAutomationTestModule(AutomationTestModuleVO automationTestModule){
		List<AutomationTestModuleVO> list = automationTestModuleDAO.listAutomationTestModule(automationTestModule);
		return list;
	}
}