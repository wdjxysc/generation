package com.whty.edu.brain.ig.service.api.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import com.whty.edu.brain.ig.service.api.service.PsAnswerSheetItemService;
import com.whty.edu.brain.ig.service.api.vo.PsAnswerSheetItemVO;
import java.util.List;
import com.whty.edu.brain.ig.framework.config.ResponseModel;


@RequestMapping("/psAnswerSheetItem")
@Controller
public class PsAnswerSheetItemController {

	@Autowired
	private PsAnswerSheetItemService psAnswerSheetItemService;
	
	/**
	 * @Title: insertPsAnswerSheetItem
	 * @Description:新增
	 * @author: generation
	 * @date:   2020年04月17日 09:28:471
	 * @param psAnswerSheetItem 新增内容
	 */
	@RequestMapping(value="/insert.do", method=RequestMethod.PUT)
	@ResponseBody
	public ResponseModel insertPsAnswerSheetItem(PsAnswerSheetItemVO psAnswerSheetItem, HttpServletRequest request, HttpServletResponse response){
		psAnswerSheetItemService.insertPsAnswerSheetItem(psAnswerSheetItem);
		return ResponseModel.success("新增成功");
	}
	
	/**
	 * @Title: deletePsAnswerSheetItem
	 * @Description:删除
	 * @author: generation
	 * @date:   2020年04月17日 09:28:472
	 * @param psAnswerSheetItem 删除条件
	 */
	@RequestMapping(value="/delete.do", method=RequestMethod.DELETE)
	@ResponseBody
	public ResponseModel deletePsAnswerSheetItem(PsAnswerSheetItemVO psAnswerSheetItem, HttpServletRequest request, HttpServletResponse response){
		psAnswerSheetItemService.deletePsAnswerSheetItem(psAnswerSheetItem);
		return ResponseModel.success("删除成功");
	}
	
	/**
	 * @Title: updatePsAnswerSheetItem
	 * @Description:更新
	 * @author: generation
	 * @date:   2020年04月17日 09:28:472
	 * @param psAnswerSheetItem 更新内容和条件
	 */
	@RequestMapping(value="/update.do", method=RequestMethod.POST)
	@ResponseBody
	public ResponseModel updatePsAnswerSheetItem(PsAnswerSheetItemVO psAnswerSheetItem, HttpServletRequest request, HttpServletResponse response){
		psAnswerSheetItemService.updatePsAnswerSheetItem(psAnswerSheetItem);
		return ResponseModel.success("更新成功");
	}
	
	/**
	 * @Title: listPsAnswerSheetItem
	 * @Description:查询列表
	 * @author: generation
	 * @date:   2020年04月17日 09:28:472
	 * @param psAnswerSheetItem 查询条件
	 */
	@RequestMapping(value="/list.do", method=RequestMethod.GET)
	@ResponseBody
	public ResponseModel listPsAnswerSheetItem(PsAnswerSheetItemVO psAnswerSheetItem, HttpServletRequest request, HttpServletResponse response){
		List<PsAnswerSheetItemVO> list = psAnswerSheetItemService.listPsAnswerSheetItem(psAnswerSheetItem);
		return ResponseModel.success(list);
	}
}

