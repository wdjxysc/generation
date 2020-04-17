package com.generation.code.automation.service;

import com.generation.code.automation.vo.AutomationTestApiVO;
import java.util.List;
/**   
 * @formatClassName:  AutomationTestApiDAO   
 * @Description:TODO    
 * @author: generation
 * @date:   2019年06月05日 02:45:897
 * @Copyright: generation
 */
public interface AutomationTestApiService {
	
	void insertAutomationTestApi(AutomationTestApiVO automationTestApi);
	
	void deleteAutomationTestApi(AutomationTestApiVO automationTestApi);
	
	void updateAutomationTestApi(AutomationTestApiVO automationTestApi);
	
	List<AutomationTestApiVO> listAutomationTestApi(AutomationTestApiVO automationTestApi);
}