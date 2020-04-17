package com.whty.edu.brain.ig.service.api.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import com.whty.edu.brain.ig.service.api.service.PsSubjectScoreService;
import com.whty.edu.brain.ig.service.api.vo.PsSubjectScoreVO;
import java.util.List;
import com.whty.edu.brain.ig.framework.config.ResponseModel;


@RequestMapping("/psSubjectScore")
@Controller
public class PsSubjectScoreController {

	@Autowired
	private PsSubjectScoreService psSubjectScoreService;
	
	/**
	 * @Title: insertPsSubjectScore
	 * @Description:新增
	 * @author: generation
	 * @date:   2020年04月17日 09:28:486
	 * @param psSubjectScore 新增内容
	 */
	@RequestMapping(value="/insert.do", method=RequestMethod.PUT)
	@ResponseBody
	public ResponseModel insertPsSubjectScore(PsSubjectScoreVO psSubjectScore, HttpServletRequest request, HttpServletResponse response){
		psSubjectScoreService.insertPsSubjectScore(psSubjectScore);
		return ResponseModel.success("新增成功");
	}
	
	/**
	 * @Title: deletePsSubjectScore
	 * @Description:删除
	 * @author: generation
	 * @date:   2020年04月17日 09:28:486
	 * @param psSubjectScore 删除条件
	 */
	@RequestMapping(value="/delete.do", method=RequestMethod.DELETE)
	@ResponseBody
	public ResponseModel deletePsSubjectScore(PsSubjectScoreVO psSubjectScore, HttpServletRequest request, HttpServletResponse response){
		psSubjectScoreService.deletePsSubjectScore(psSubjectScore);
		return ResponseModel.success("删除成功");
	}
	
	/**
	 * @Title: updatePsSubjectScore
	 * @Description:更新
	 * @author: generation
	 * @date:   2020年04月17日 09:28:486
	 * @param psSubjectScore 更新内容和条件
	 */
	@RequestMapping(value="/update.do", method=RequestMethod.POST)
	@ResponseBody
	public ResponseModel updatePsSubjectScore(PsSubjectScoreVO psSubjectScore, HttpServletRequest request, HttpServletResponse response){
		psSubjectScoreService.updatePsSubjectScore(psSubjectScore);
		return ResponseModel.success("更新成功");
	}
	
	/**
	 * @Title: listPsSubjectScore
	 * @Description:查询列表
	 * @author: generation
	 * @date:   2020年04月17日 09:28:486
	 * @param psSubjectScore 查询条件
	 */
	@RequestMapping(value="/list.do", method=RequestMethod.GET)
	@ResponseBody
	public ResponseModel listPsSubjectScore(PsSubjectScoreVO psSubjectScore, HttpServletRequest request, HttpServletResponse response){
		List<PsSubjectScoreVO> list = psSubjectScoreService.listPsSubjectScore(psSubjectScore);
		return ResponseModel.success(list);
	}
}

