package com.whty.edu.brain.ig.service.api.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import com.whty.edu.brain.ig.service.api.service.PsZgTotalScoreService;
import com.whty.edu.brain.ig.service.api.vo.PsZgTotalScoreVO;
import java.util.List;
import com.whty.edu.brain.ig.framework.config.ResponseModel;


@RequestMapping("/psZgTotalScore")
@Controller
public class PsZgTotalScoreController {

	@Autowired
	private PsZgTotalScoreService psZgTotalScoreService;
	
	/**
	 * @Title: insertPsZgTotalScore
	 * @Description:新增
	 * @author: generation
	 * @date:   2020年04月17日 09:28:474
	 * @param psZgTotalScore 新增内容
	 */
	@RequestMapping(value="/insert.do", method=RequestMethod.PUT)
	@ResponseBody
	public ResponseModel insertPsZgTotalScore(PsZgTotalScoreVO psZgTotalScore, HttpServletRequest request, HttpServletResponse response){
		psZgTotalScoreService.insertPsZgTotalScore(psZgTotalScore);
		return ResponseModel.success("新增成功");
	}
	
	/**
	 * @Title: deletePsZgTotalScore
	 * @Description:删除
	 * @author: generation
	 * @date:   2020年04月17日 09:28:475
	 * @param psZgTotalScore 删除条件
	 */
	@RequestMapping(value="/delete.do", method=RequestMethod.DELETE)
	@ResponseBody
	public ResponseModel deletePsZgTotalScore(PsZgTotalScoreVO psZgTotalScore, HttpServletRequest request, HttpServletResponse response){
		psZgTotalScoreService.deletePsZgTotalScore(psZgTotalScore);
		return ResponseModel.success("删除成功");
	}
	
	/**
	 * @Title: updatePsZgTotalScore
	 * @Description:更新
	 * @author: generation
	 * @date:   2020年04月17日 09:28:475
	 * @param psZgTotalScore 更新内容和条件
	 */
	@RequestMapping(value="/update.do", method=RequestMethod.POST)
	@ResponseBody
	public ResponseModel updatePsZgTotalScore(PsZgTotalScoreVO psZgTotalScore, HttpServletRequest request, HttpServletResponse response){
		psZgTotalScoreService.updatePsZgTotalScore(psZgTotalScore);
		return ResponseModel.success("更新成功");
	}
	
	/**
	 * @Title: listPsZgTotalScore
	 * @Description:查询列表
	 * @author: generation
	 * @date:   2020年04月17日 09:28:475
	 * @param psZgTotalScore 查询条件
	 */
	@RequestMapping(value="/list.do", method=RequestMethod.GET)
	@ResponseBody
	public ResponseModel listPsZgTotalScore(PsZgTotalScoreVO psZgTotalScore, HttpServletRequest request, HttpServletResponse response){
		List<PsZgTotalScoreVO> list = psZgTotalScoreService.listPsZgTotalScore(psZgTotalScore);
		return ResponseModel.success(list);
	}
}

