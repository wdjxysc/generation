package com.generation.code.automation.service.impl;

import com.generation.code.automation.vo.AutomationTestApiRunlogVO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.generation.code.automation.service.AutomationTestApiRunlogService;
import com.generation.code.automation.dao.AutomationTestApiRunlogDAO;

/**   
 * @formatClassName:  AutomationTestApiRunlogServiceImpl   
 * @Description:TODO    
 * @author: generation
 * @date:   2019年06月05日 02:45:907
 * @Copyright: generation
 */
@Service
public class AutomationTestApiRunlogServiceImpl implements AutomationTestApiRunlogService{
	
	@Autowired
	private AutomationTestApiRunlogDAO automationTestApiRunlogDAO;
	
	@Override
	public void insertAutomationTestApiRunlog(AutomationTestApiRunlogVO automationTestApiRunlog){
		automationTestApiRunlogDAO.insertAutomationTestApiRunlog(automationTestApiRunlog);
	}
	
	@Override
	public void deleteAutomationTestApiRunlog(AutomationTestApiRunlogVO automationTestApiRunlog){
		automationTestApiRunlogDAO.deleteAutomationTestApiRunlog(automationTestApiRunlog);
	}
	
	@Override
	public void updateAutomationTestApiRunlog(AutomationTestApiRunlogVO automationTestApiRunlog){
		automationTestApiRunlogDAO.updateAutomationTestApiRunlog(automationTestApiRunlog);
	}
	
	@Override
	public List<AutomationTestApiRunlogVO> listAutomationTestApiRunlog(AutomationTestApiRunlogVO automationTestApiRunlog){
		List<AutomationTestApiRunlogVO> list = automationTestApiRunlogDAO.listAutomationTestApiRunlog(automationTestApiRunlog);
		return list;
	}
}