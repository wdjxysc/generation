package com.generation.code.automation.dao;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.generation.code.automation.vo.AutomationTestApiVO;
import java.util.List;
/**   
 * @formatClassName:  AutomationTestApiDAO   
 * @Description:TODO(持久层接口)   
 * @author: generation
 * @date:   2019年06月05日 02:45:895
 * @Copyright: generation
 */
@Mapper
@Repository
public interface AutomationTestApiDAO {
	
	void insertAutomationTestApi(AutomationTestApiVO automationTestApi);
	
	void deleteAutomationTestApi(AutomationTestApiVO automationTestApi);
	
	void updateAutomationTestApi(AutomationTestApiVO automationTestApi);
	
	List<AutomationTestApiVO> listAutomationTestApi(AutomationTestApiVO automationTestApi);
}
