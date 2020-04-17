package com.generation.code.automation.service.impl;

import com.generation.code.automation.vo.AutomationTestApiVO;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.generation.code.automation.service.AutomationTestApiService;
import com.generation.code.automation.dao.AutomationTestApiDAO;

/**   
 * @formatClassName:  AutomationTestApiServiceImpl   
 * @Description:TODO    
 * @author: generation
 * @date:   2019年06月05日 02:45:899
 * @Copyright: generation
 */
@Service
public class AutomationTestApiServiceImpl implements AutomationTestApiService{
	
	@Autowired
	private AutomationTestApiDAO automationTestApiDAO;
	
	@Override
	public void insertAutomationTestApi(AutomationTestApiVO automationTestApi){
		automationTestApi.setApiCode(UUID.randomUUID().toString());
		automationTestApiDAO.insertAutomationTestApi(automationTestApi);
	}
	
	@Override
	public void deleteAutomationTestApi(AutomationTestApiVO automationTestApi){
		automationTestApiDAO.deleteAutomationTestApi(automationTestApi);
	}
	
	@Override
	public void updateAutomationTestApi(AutomationTestApiVO automationTestApi){
		automationTestApiDAO.updateAutomationTestApi(automationTestApi);
	}
	
	@Override
	public List<AutomationTestApiVO> listAutomationTestApi(AutomationTestApiVO automationTestApi){
		List<AutomationTestApiVO> list = automationTestApiDAO.listAutomationTestApi(automationTestApi);
		return list;
	}
}