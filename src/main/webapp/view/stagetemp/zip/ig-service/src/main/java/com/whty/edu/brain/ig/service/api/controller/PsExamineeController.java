package com.whty.edu.brain.ig.service.api.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import com.whty.edu.brain.ig.service.api.service.PsExamineeService;
import com.whty.edu.brain.ig.service.api.vo.PsExamineeVO;
import java.util.List;
import com.whty.edu.brain.ig.framework.config.ResponseModel;


@RequestMapping("/psExaminee")
@Controller
public class PsExamineeController {

	@Autowired
	private PsExamineeService psExamineeService;
	
	/**
	 * @Title: insertPsExaminee
	 * @Description:新增
	 * @author: generation
	 * @date:   2020年04月17日 09:28:483
	 * @param psExaminee 新增内容
	 */
	@RequestMapping(value="/insert.do", method=RequestMethod.PUT)
	@ResponseBody
	public ResponseModel insertPsExaminee(PsExamineeVO psExaminee, HttpServletRequest request, HttpServletResponse response){
		psExamineeService.insertPsExaminee(psExaminee);
		return ResponseModel.success("新增成功");
	}
	
	/**
	 * @Title: deletePsExaminee
	 * @Description:删除
	 * @author: generation
	 * @date:   2020年04月17日 09:28:483
	 * @param psExaminee 删除条件
	 */
	@RequestMapping(value="/delete.do", method=RequestMethod.DELETE)
	@ResponseBody
	public ResponseModel deletePsExaminee(PsExamineeVO psExaminee, HttpServletRequest request, HttpServletResponse response){
		psExamineeService.deletePsExaminee(psExaminee);
		return ResponseModel.success("删除成功");
	}
	
	/**
	 * @Title: updatePsExaminee
	 * @Description:更新
	 * @author: generation
	 * @date:   2020年04月17日 09:28:483
	 * @param psExaminee 更新内容和条件
	 */
	@RequestMapping(value="/update.do", method=RequestMethod.POST)
	@ResponseBody
	public ResponseModel updatePsExaminee(PsExamineeVO psExaminee, HttpServletRequest request, HttpServletResponse response){
		psExamineeService.updatePsExaminee(psExaminee);
		return ResponseModel.success("更新成功");
	}
	
	/**
	 * @Title: listPsExaminee
	 * @Description:查询列表
	 * @author: generation
	 * @date:   2020年04月17日 09:28:483
	 * @param psExaminee 查询条件
	 */
	@RequestMapping(value="/list.do", method=RequestMethod.GET)
	@ResponseBody
	public ResponseModel listPsExaminee(PsExamineeVO psExaminee, HttpServletRequest request, HttpServletResponse response){
		List<PsExamineeVO> list = psExamineeService.listPsExaminee(psExaminee);
		return ResponseModel.success(list);
	}
}

