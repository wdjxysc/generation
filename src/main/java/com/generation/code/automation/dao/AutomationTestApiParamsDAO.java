package com.generation.code.automation.dao;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.generation.code.automation.vo.AutomationTestApiParamsVO;
import java.util.List;
/**   
 * @formatClassName:  AutomationTestApiParamsDAO   
 * @Description:TODO(持久层接口)   
 * @author: generation
 * @date:   2019年06月05日 02:45:916
 * @Copyright: generation
 */
@Mapper
@Repository
public interface AutomationTestApiParamsDAO {
	
	void insertAutomationTestApiParams(AutomationTestApiParamsVO automationTestApiParams);
	
	void deleteAutomationTestApiParams(AutomationTestApiParamsVO automationTestApiParams);
	
	void updateAutomationTestApiParams(AutomationTestApiParamsVO automationTestApiParams);
	
	List<AutomationTestApiParamsVO> listAutomationTestApiParams(AutomationTestApiParamsVO automationTestApiParams);
}
