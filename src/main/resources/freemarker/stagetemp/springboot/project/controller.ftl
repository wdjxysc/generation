package ${packagename}.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import ${packagename}.service.${formatClassName?cap_first}Service;
import ${packagename}.vo.${formatClassName?cap_first}VO;
import java.util.List;
import ${groupId}.framework.config.ResponseModel;


@RequestMapping("/${formatClassName?uncap_first}")
@Controller
public class ${formatClassName?cap_first}Controller {

	@Autowired
	private ${formatClassName?cap_first}Service ${formatClassName?uncap_first}Service;
	
	/**
	 * @Title: insert${formatClassName?cap_first}
	 * @Description:新增
	 * @author: generation
	 * @date:   ${.now?string["yyyy年MM月dd日 hh:mm:SS"]}
	 * @param ${formatClassName?uncap_first} 新增内容
	 */
	@RequestMapping(value="/insert.do", method=RequestMethod.PUT)
	@ResponseBody
	public ResponseModel insert${formatClassName?cap_first}(${formatClassName?cap_first}VO ${formatClassName?uncap_first}, HttpServletRequest request, HttpServletResponse response){
		${formatClassName?uncap_first}Service.insert${formatClassName?cap_first}(${formatClassName?uncap_first});
		return ResponseModel.success("新增成功");
	}
	
	/**
	 * @Title: delete${formatClassName?cap_first}
	 * @Description:删除
	 * @author: generation
	 * @date:   ${.now?string["yyyy年MM月dd日 hh:mm:SS"]}
	 * @param ${formatClassName?uncap_first} 删除条件
	 */
	@RequestMapping(value="/delete.do", method=RequestMethod.DELETE)
	@ResponseBody
	public ResponseModel delete${formatClassName?cap_first}(${formatClassName?cap_first}VO ${formatClassName?uncap_first}, HttpServletRequest request, HttpServletResponse response){
		${formatClassName?uncap_first}Service.delete${formatClassName?cap_first}(${formatClassName?uncap_first});
		return ResponseModel.success("删除成功");
	}
	
	/**
	 * @Title: update${formatClassName?cap_first}
	 * @Description:更新
	 * @author: generation
	 * @date:   ${.now?string["yyyy年MM月dd日 hh:mm:SS"]}
	 * @param ${formatClassName?uncap_first} 更新内容和条件
	 */
	@RequestMapping(value="/update.do", method=RequestMethod.POST)
	@ResponseBody
	public ResponseModel update${formatClassName?cap_first}(${formatClassName?cap_first}VO ${formatClassName?uncap_first}, HttpServletRequest request, HttpServletResponse response){
		${formatClassName?uncap_first}Service.update${formatClassName?cap_first}(${formatClassName?uncap_first});
		return ResponseModel.success("更新成功");
	}
	
	/**
	 * @Title: list${formatClassName?cap_first}
	 * @Description:查询列表
	 * @author: generation
	 * @date:   ${.now?string["yyyy年MM月dd日 hh:mm:SS"]}
	 * @param ${formatClassName?uncap_first} 查询条件
	 */
	@RequestMapping(value="/list.do", method=RequestMethod.GET)
	@ResponseBody
	public ResponseModel list${formatClassName?cap_first}(${formatClassName?cap_first}VO ${formatClassName?uncap_first}, HttpServletRequest request, HttpServletResponse response){
		List<${formatClassName?cap_first}VO> list = ${formatClassName?uncap_first}Service.list${formatClassName?cap_first}(${formatClassName?uncap_first});
		return ResponseModel.success(list);
	}
}

