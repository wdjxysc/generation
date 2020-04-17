package com.generation.code.automation.service;

import com.generation.code.automation.vo.AutomationTestApiParamsVO;
import java.util.List;
/**   
 * @formatClassName:  AutomationTestApiParamsDAO   
 * @Description:TODO    
 * @author: generation
 * @date:   2019年06月05日 02:45:917
 * @Copyright: generation
 */
public interface AutomationTestApiParamsService {
	
	void insertAutomationTestApiParams(AutomationTestApiParamsVO automationTestApiParams);
	
	void deleteAutomationTestApiParams(AutomationTestApiParamsVO automationTestApiParams);
	
	void updateAutomationTestApiParams(AutomationTestApiParamsVO automationTestApiParams);
	
	List<AutomationTestApiParamsVO> listAutomationTestApiParams(AutomationTestApiParamsVO automationTestApiParams);
}