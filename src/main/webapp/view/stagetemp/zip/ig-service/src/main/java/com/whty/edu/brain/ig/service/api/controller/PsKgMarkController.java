package com.whty.edu.brain.ig.service.api.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import com.whty.edu.brain.ig.service.api.service.PsKgMarkService;
import com.whty.edu.brain.ig.service.api.vo.PsKgMarkVO;
import java.util.List;
import com.whty.edu.brain.ig.framework.config.ResponseModel;


@RequestMapping("/psKgMark")
@Controller
public class PsKgMarkController {

	@Autowired
	private PsKgMarkService psKgMarkService;
	
	/**
	 * @Title: insertPsKgMark
	 * @Description:新增
	 * @author: generation
	 * @date:   2020年04月17日 09:28:489
	 * @param psKgMark 新增内容
	 */
	@RequestMapping(value="/insert.do", method=RequestMethod.PUT)
	@ResponseBody
	public ResponseModel insertPsKgMark(PsKgMarkVO psKgMark, HttpServletRequest request, HttpServletResponse response){
		psKgMarkService.insertPsKgMark(psKgMark);
		return ResponseModel.success("新增成功");
	}
	
	/**
	 * @Title: deletePsKgMark
	 * @Description:删除
	 * @author: generation
	 * @date:   2020年04月17日 09:28:489
	 * @param psKgMark 删除条件
	 */
	@RequestMapping(value="/delete.do", method=RequestMethod.DELETE)
	@ResponseBody
	public ResponseModel deletePsKgMark(PsKgMarkVO psKgMark, HttpServletRequest request, HttpServletResponse response){
		psKgMarkService.deletePsKgMark(psKgMark);
		return ResponseModel.success("删除成功");
	}
	
	/**
	 * @Title: updatePsKgMark
	 * @Description:更新
	 * @author: generation
	 * @date:   2020年04月17日 09:28:489
	 * @param psKgMark 更新内容和条件
	 */
	@RequestMapping(value="/update.do", method=RequestMethod.POST)
	@ResponseBody
	public ResponseModel updatePsKgMark(PsKgMarkVO psKgMark, HttpServletRequest request, HttpServletResponse response){
		psKgMarkService.updatePsKgMark(psKgMark);
		return ResponseModel.success("更新成功");
	}
	
	/**
	 * @Title: listPsKgMark
	 * @Description:查询列表
	 * @author: generation
	 * @date:   2020年04月17日 09:28:489
	 * @param psKgMark 查询条件
	 */
	@RequestMapping(value="/list.do", method=RequestMethod.GET)
	@ResponseBody
	public ResponseModel listPsKgMark(PsKgMarkVO psKgMark, HttpServletRequest request, HttpServletResponse response){
		List<PsKgMarkVO> list = psKgMarkService.listPsKgMark(psKgMark);
		return ResponseModel.success(list);
	}
}

