package com.whty.edu.brain.ig.service.api.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import com.whty.edu.brain.ig.service.api.service.PsScoringMarkService;
import com.whty.edu.brain.ig.service.api.vo.PsScoringMarkVO;
import java.util.List;
import com.whty.edu.brain.ig.framework.config.ResponseModel;


@RequestMapping("/psScoringMark")
@Controller
public class PsScoringMarkController {

	@Autowired
	private PsScoringMarkService psScoringMarkService;
	
	/**
	 * @Title: insertPsScoringMark
	 * @Description:新增
	 * @author: generation
	 * @date:   2020年04月17日 09:28:454
	 * @param psScoringMark 新增内容
	 */
	@RequestMapping(value="/insert.do", method=RequestMethod.PUT)
	@ResponseBody
	public ResponseModel insertPsScoringMark(PsScoringMarkVO psScoringMark, HttpServletRequest request, HttpServletResponse response){
		psScoringMarkService.insertPsScoringMark(psScoringMark);
		return ResponseModel.success("新增成功");
	}
	
	/**
	 * @Title: deletePsScoringMark
	 * @Description:删除
	 * @author: generation
	 * @date:   2020年04月17日 09:28:454
	 * @param psScoringMark 删除条件
	 */
	@RequestMapping(value="/delete.do", method=RequestMethod.DELETE)
	@ResponseBody
	public ResponseModel deletePsScoringMark(PsScoringMarkVO psScoringMark, HttpServletRequest request, HttpServletResponse response){
		psScoringMarkService.deletePsScoringMark(psScoringMark);
		return ResponseModel.success("删除成功");
	}
	
	/**
	 * @Title: updatePsScoringMark
	 * @Description:更新
	 * @author: generation
	 * @date:   2020年04月17日 09:28:454
	 * @param psScoringMark 更新内容和条件
	 */
	@RequestMapping(value="/update.do", method=RequestMethod.POST)
	@ResponseBody
	public ResponseModel updatePsScoringMark(PsScoringMarkVO psScoringMark, HttpServletRequest request, HttpServletResponse response){
		psScoringMarkService.updatePsScoringMark(psScoringMark);
		return ResponseModel.success("更新成功");
	}
	
	/**
	 * @Title: listPsScoringMark
	 * @Description:查询列表
	 * @author: generation
	 * @date:   2020年04月17日 09:28:454
	 * @param psScoringMark 查询条件
	 */
	@RequestMapping(value="/list.do", method=RequestMethod.GET)
	@ResponseBody
	public ResponseModel listPsScoringMark(PsScoringMarkVO psScoringMark, HttpServletRequest request, HttpServletResponse response){
		List<PsScoringMarkVO> list = psScoringMarkService.listPsScoringMark(psScoringMark);
		return ResponseModel.success(list);
	}
}

