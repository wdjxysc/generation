package com.generation.code.automation.service;

import com.generation.code.automation.vo.AutomationTestModuleVO;
import java.util.List;
/**   
 * @formatClassName:  AutomationTestModuleDAO   
 * @Description:TODO    
 * @author: generation
 * @date:   2019年06月05日 02:45:912
 * @Copyright: generation
 */
public interface AutomationTestModuleService {
	
	void insertAutomationTestModule(AutomationTestModuleVO automationTestModule);
	
	void deleteAutomationTestModule(AutomationTestModuleVO automationTestModule);
	
	void updateAutomationTestModule(AutomationTestModuleVO automationTestModule);
	
	List<AutomationTestModuleVO> listAutomationTestModule(AutomationTestModuleVO automationTestModule);
}