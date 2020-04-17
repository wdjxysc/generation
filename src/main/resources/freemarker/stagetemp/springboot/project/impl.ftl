package ${packagename}.service.impl;

import ${packagename}.vo.${formatClassName?cap_first}VO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ${packagename}.service.${formatClassName?cap_first}Service;
import ${packagename}.dao.${formatClassName?cap_first}DAO;

/**   
 * @formatClassName:  ${formatClassName?cap_first}ServiceImpl   
 * @Description:TODO    
 * @author: generation
 * @date:   ${.now?string["yyyy年MM月dd日 hh:mm:SS"]}
 * @Copyright: generation
 */
@Service
public class ${formatClassName?cap_first}ServiceImpl implements ${formatClassName?cap_first}Service{
	
	/**
	 *	DAO操作注入对象
	 */
	@Autowired
	private ${formatClassName?cap_first}DAO ${formatClassName?uncap_first}DAO;
	
	/**
	 * <p>Title: insert${formatClassName?cap_first}</p>   
	 * <p>Description: 新增</p>   
	 * @param ${formatClassName?uncap_first}   
	 * @see ${packagename}.service.${formatClassName?cap_first}Service#insert${formatClassName?cap_first}(${packagename}.vo.${formatClassName?cap_first}VO)
	 */
	@Override
	public void insert${formatClassName?cap_first}(${formatClassName?cap_first}VO ${formatClassName?uncap_first}){
		${formatClassName?uncap_first}DAO.insert${formatClassName?cap_first}(${formatClassName?uncap_first});
	}
	
	/**
	 * <p>Title: delete${formatClassName?cap_first}</p>   
	 * <p>Description: 删除</p>   
	 * @param ${formatClassName?uncap_first}   
	 * @see ${packagename}.service.${formatClassName?cap_first}Service#delete${formatClassName?cap_first}(${packagename}.vo.${formatClassName?cap_first}VO)
	 */
	@Override
	public void delete${formatClassName?cap_first}(${formatClassName?cap_first}VO ${formatClassName?uncap_first}){
		${formatClassName?uncap_first}DAO.delete${formatClassName?cap_first}(${formatClassName?uncap_first});
	}
	
	/**
	 * <p>Title: update${formatClassName?cap_first}</p>   
	 * <p>Description: 更新</p>   
	 * @param ${formatClassName?uncap_first}   
	 * @see ${packagename}.service.${formatClassName?cap_first}Service#update${formatClassName?cap_first}(${packagename}.vo.${formatClassName?cap_first}VO)
	 */
	@Override
	public void update${formatClassName?cap_first}(${formatClassName?cap_first}VO ${formatClassName?uncap_first}){
		${formatClassName?uncap_first}DAO.update${formatClassName?cap_first}(${formatClassName?uncap_first});
	}
	
	/**
	 * <p>Title: list${formatClassName?cap_first}</p>   
	 * <p>Description: 列表查询</p>   
	 * @param ${formatClassName?uncap_first}   
	 * @see ${packagename}.service.${formatClassName?cap_first}Service#list${formatClassName?cap_first}(${packagename}.vo.${formatClassName?cap_first}VO)
	 */
	@Override
	public List<${formatClassName?cap_first}VO> list${formatClassName?cap_first}(${formatClassName?cap_first}VO ${formatClassName?uncap_first}){
		List<${formatClassName?cap_first}VO> list = ${formatClassName?uncap_first}DAO.list${formatClassName?cap_first}(${formatClassName?uncap_first});
		return list;
	}
}