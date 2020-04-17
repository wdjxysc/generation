package com.whty.edu.brain.ig.service.api.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import com.whty.edu.brain.ig.service.api.service.PsOnlineSubmitService;
import com.whty.edu.brain.ig.service.api.vo.PsOnlineSubmitVO;
import java.util.List;
import com.whty.edu.brain.ig.framework.config.ResponseModel;


@RequestMapping("/psOnlineSubmit")
@Controller
public class PsOnlineSubmitController {

	@Autowired
	private PsOnlineSubmitService psOnlineSubmitService;
	
	/**
	 * @Title: insertPsOnlineSubmit
	 * @Description:新增
	 * @author: generation
	 * @date:   2020年04月17日 09:28:457
	 * @param psOnlineSubmit 新增内容
	 */
	@RequestMapping(value="/insert.do", method=RequestMethod.PUT)
	@ResponseBody
	public ResponseModel insertPsOnlineSubmit(PsOnlineSubmitVO psOnlineSubmit, HttpServletRequest request, HttpServletResponse response){
		psOnlineSubmitService.insertPsOnlineSubmit(psOnlineSubmit);
		return ResponseModel.success("新增成功");
	}
	
	/**
	 * @Title: deletePsOnlineSubmit
	 * @Description:删除
	 * @author: generation
	 * @date:   2020年04月17日 09:28:457
	 * @param psOnlineSubmit 删除条件
	 */
	@RequestMapping(value="/delete.do", method=RequestMethod.DELETE)
	@ResponseBody
	public ResponseModel deletePsOnlineSubmit(PsOnlineSubmitVO psOnlineSubmit, HttpServletRequest request, HttpServletResponse response){
		psOnlineSubmitService.deletePsOnlineSubmit(psOnlineSubmit);
		return ResponseModel.success("删除成功");
	}
	
	/**
	 * @Title: updatePsOnlineSubmit
	 * @Description:更新
	 * @author: generation
	 * @date:   2020年04月17日 09:28:457
	 * @param psOnlineSubmit 更新内容和条件
	 */
	@RequestMapping(value="/update.do", method=RequestMethod.POST)
	@ResponseBody
	public ResponseModel updatePsOnlineSubmit(PsOnlineSubmitVO psOnlineSubmit, HttpServletRequest request, HttpServletResponse response){
		psOnlineSubmitService.updatePsOnlineSubmit(psOnlineSubmit);
		return ResponseModel.success("更新成功");
	}
	
	/**
	 * @Title: listPsOnlineSubmit
	 * @Description:查询列表
	 * @author: generation
	 * @date:   2020年04月17日 09:28:457
	 * @param psOnlineSubmit 查询条件
	 */
	@RequestMapping(value="/list.do", method=RequestMethod.GET)
	@ResponseBody
	public ResponseModel listPsOnlineSubmit(PsOnlineSubmitVO psOnlineSubmit, HttpServletRequest request, HttpServletResponse response){
		List<PsOnlineSubmitVO> list = psOnlineSubmitService.listPsOnlineSubmit(psOnlineSubmit);
		return ResponseModel.success(list);
	}
}

