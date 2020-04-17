package ${packagename}.service;

import ${packagename}.vo.${formatClassName?cap_first}VO;
import java.util.List;
/**   
 * @formatClassName:  ${formatClassName?cap_first}DAO   
 * @Description:TODO    
 * @author: generation
 * @date:   ${.now?string["yyyy年MM月dd日 hh:mm:SS"]}
 * @Copyright: generation
 */
public interface ${formatClassName?cap_first}Service {
	/**
	 * @Title: insert${formatClassName?cap_first}
	 * @Description:新增
	 * @author: generation
	 * @date:   ${.now?string["yyyy年MM月dd日 hh:mm:SS"]}
	 * @param ${formatClassName?uncap_first} 新增内容
	 */
	void insert${formatClassName?cap_first}(${formatClassName?cap_first}VO ${formatClassName?uncap_first});
	
	/**
	 * @Title: delete${formatClassName?cap_first}
	 * @Description:删除
	 * @author: generation
	 * @date:   ${.now?string["yyyy年MM月dd日 hh:mm:SS"]}
	 * @param ${formatClassName?uncap_first} 删除对象条件
	 */
	void delete${formatClassName?cap_first}(${formatClassName?cap_first}VO ${formatClassName?uncap_first});
	
	/**
	 * @Title: update${formatClassName?cap_first}
	 * @Description:更新
	 * @author: generation
	 * @date:   ${.now?string["yyyy年MM月dd日 hh:mm:SS"]}
	 * @param ${formatClassName?uncap_first} 更新条件及目标对象标识
	 */
	void update${formatClassName?cap_first}(${formatClassName?cap_first}VO ${formatClassName?uncap_first});
	
	/**
	 * @Title: list${formatClassName?cap_first}
	 * @Description:查询列表
	 * @author: generation
	 * @date:   ${.now?string["yyyy年MM月dd日 hh:mm:SS"]}
	 * @param ${formatClassName?uncap_first} 查询条件
	 * @return List<${formatClassName?cap_first}VO> 返回结果
	 */
	List<${formatClassName?cap_first}VO> list${formatClassName?cap_first}(${formatClassName?cap_first}VO ${formatClassName?uncap_first});
}