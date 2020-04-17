package com.generation.code.automation.service;

import com.generation.code.automation.vo.AutomationTestApiRunlogVO;
import java.util.List;
/**   
 * @formatClassName:  AutomationTestApiRunlogDAO   
 * @Description:TODO    
 * @author: generation
 * @date:   2019年06月05日 02:45:907
 * @Copyright: generation
 */
public interface AutomationTestApiRunlogService {
	
	void insertAutomationTestApiRunlog(AutomationTestApiRunlogVO automationTestApiRunlog);
	
	void deleteAutomationTestApiRunlog(AutomationTestApiRunlogVO automationTestApiRunlog);
	
	void updateAutomationTestApiRunlog(AutomationTestApiRunlogVO automationTestApiRunlog);
	
	List<AutomationTestApiRunlogVO> listAutomationTestApiRunlog(AutomationTestApiRunlogVO automationTestApiRunlog);
}