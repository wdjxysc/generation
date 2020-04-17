package com.whty.edu.brain.ig.service.api.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import com.whty.edu.brain.ig.service.api.service.PsExamineeSheetService;
import com.whty.edu.brain.ig.service.api.vo.PsExamineeSheetVO;
import java.util.List;
import com.whty.edu.brain.ig.framework.config.ResponseModel;


@RequestMapping("/psExamineeSheet")
@Controller
public class PsExamineeSheetController {

	@Autowired
	private PsExamineeSheetService psExamineeSheetService;
	
	/**
	 * @Title: insertPsExamineeSheet
	 * @Description:新增
	 * @author: generation
	 * @date:   2020年04月17日 09:28:467
	 * @param psExamineeSheet 新增内容
	 */
	@RequestMapping(value="/insert.do", method=RequestMethod.PUT)
	@ResponseBody
	public ResponseModel insertPsExamineeSheet(PsExamineeSheetVO psExamineeSheet, HttpServletRequest request, HttpServletResponse response){
		psExamineeSheetService.insertPsExamineeSheet(psExamineeSheet);
		return ResponseModel.success("新增成功");
	}
	
	/**
	 * @Title: deletePsExamineeSheet
	 * @Description:删除
	 * @author: generation
	 * @date:   2020年04月17日 09:28:467
	 * @param psExamineeSheet 删除条件
	 */
	@RequestMapping(value="/delete.do", method=RequestMethod.DELETE)
	@ResponseBody
	public ResponseModel deletePsExamineeSheet(PsExamineeSheetVO psExamineeSheet, HttpServletRequest request, HttpServletResponse response){
		psExamineeSheetService.deletePsExamineeSheet(psExamineeSheet);
		return ResponseModel.success("删除成功");
	}
	
	/**
	 * @Title: updatePsExamineeSheet
	 * @Description:更新
	 * @author: generation
	 * @date:   2020年04月17日 09:28:467
	 * @param psExamineeSheet 更新内容和条件
	 */
	@RequestMapping(value="/update.do", method=RequestMethod.POST)
	@ResponseBody
	public ResponseModel updatePsExamineeSheet(PsExamineeSheetVO psExamineeSheet, HttpServletRequest request, HttpServletResponse response){
		psExamineeSheetService.updatePsExamineeSheet(psExamineeSheet);
		return ResponseModel.success("更新成功");
	}
	
	/**
	 * @Title: listPsExamineeSheet
	 * @Description:查询列表
	 * @author: generation
	 * @date:   2020年04月17日 09:28:467
	 * @param psExamineeSheet 查询条件
	 */
	@RequestMapping(value="/list.do", method=RequestMethod.GET)
	@ResponseBody
	public ResponseModel listPsExamineeSheet(PsExamineeSheetVO psExamineeSheet, HttpServletRequest request, HttpServletResponse response){
		List<PsExamineeSheetVO> list = psExamineeSheetService.listPsExamineeSheet(psExamineeSheet);
		return ResponseModel.success(list);
	}
}

