package com.generation.code.automation.dao;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.generation.code.automation.vo.AutomationTestModuleVO;
import java.util.List;
/**   
 * @formatClassName:  AutomationTestModuleDAO   
 * @Description:TODO(持久层接口)   
 * @author: generation
 * @date:   2019年06月05日 02:45:911
 * @Copyright: generation
 */
@Mapper
@Repository
public interface AutomationTestModuleDAO {
	
	void insertAutomationTestModule(AutomationTestModuleVO automationTestModule);
	
	void deleteAutomationTestModule(AutomationTestModuleVO automationTestModule);
	
	void updateAutomationTestModule(AutomationTestModuleVO automationTestModule);
	
	List<AutomationTestModuleVO> listAutomationTestModule(AutomationTestModuleVO automationTestModule);
}
