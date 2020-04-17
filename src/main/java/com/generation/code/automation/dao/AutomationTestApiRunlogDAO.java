package com.generation.code.automation.dao;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.generation.code.automation.vo.AutomationTestApiRunlogVO;
import java.util.List;
/**   
 * @formatClassName:  AutomationTestApiRunlogDAO   
 * @Description:TODO(持久层接口)   
 * @author: generation
 * @date:   2019年06月05日 02:45:906
 * @Copyright: generation
 */
@Mapper
@Repository
public interface AutomationTestApiRunlogDAO {
	
	void insertAutomationTestApiRunlog(AutomationTestApiRunlogVO automationTestApiRunlog);
	
	void deleteAutomationTestApiRunlog(AutomationTestApiRunlogVO automationTestApiRunlog);
	
	void updateAutomationTestApiRunlog(AutomationTestApiRunlogVO automationTestApiRunlog);
	
	List<AutomationTestApiRunlogVO> listAutomationTestApiRunlog(AutomationTestApiRunlogVO automationTestApiRunlog);
}
