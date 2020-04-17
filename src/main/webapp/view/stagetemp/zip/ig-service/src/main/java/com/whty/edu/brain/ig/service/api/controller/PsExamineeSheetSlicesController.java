package com.whty.edu.brain.ig.service.api.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import com.whty.edu.brain.ig.service.api.service.PsExamineeSheetSlicesService;
import com.whty.edu.brain.ig.service.api.vo.PsExamineeSheetSlicesVO;
import java.util.List;
import com.whty.edu.brain.ig.framework.config.ResponseModel;


@RequestMapping("/psExamineeSheetSlices")
@Controller
public class PsExamineeSheetSlicesController {

	@Autowired
	private PsExamineeSheetSlicesService psExamineeSheetSlicesService;
	
	/**
	 * @Title: insertPsExamineeSheetSlices
	 * @Description:新增
	 * @author: generation
	 * @date:   2020年04月17日 09:28:479
	 * @param psExamineeSheetSlices 新增内容
	 */
	@RequestMapping(value="/insert.do", method=RequestMethod.PUT)
	@ResponseBody
	public ResponseModel insertPsExamineeSheetSlices(PsExamineeSheetSlicesVO psExamineeSheetSlices, HttpServletRequest request, HttpServletResponse response){
		psExamineeSheetSlicesService.insertPsExamineeSheetSlices(psExamineeSheetSlices);
		return ResponseModel.success("新增成功");
	}
	
	/**
	 * @Title: deletePsExamineeSheetSlices
	 * @Description:删除
	 * @author: generation
	 * @date:   2020年04月17日 09:28:479
	 * @param psExamineeSheetSlices 删除条件
	 */
	@RequestMapping(value="/delete.do", method=RequestMethod.DELETE)
	@ResponseBody
	public ResponseModel deletePsExamineeSheetSlices(PsExamineeSheetSlicesVO psExamineeSheetSlices, HttpServletRequest request, HttpServletResponse response){
		psExamineeSheetSlicesService.deletePsExamineeSheetSlices(psExamineeSheetSlices);
		return ResponseModel.success("删除成功");
	}
	
	/**
	 * @Title: updatePsExamineeSheetSlices
	 * @Description:更新
	 * @author: generation
	 * @date:   2020年04月17日 09:28:479
	 * @param psExamineeSheetSlices 更新内容和条件
	 */
	@RequestMapping(value="/update.do", method=RequestMethod.POST)
	@ResponseBody
	public ResponseModel updatePsExamineeSheetSlices(PsExamineeSheetSlicesVO psExamineeSheetSlices, HttpServletRequest request, HttpServletResponse response){
		psExamineeSheetSlicesService.updatePsExamineeSheetSlices(psExamineeSheetSlices);
		return ResponseModel.success("更新成功");
	}
	
	/**
	 * @Title: listPsExamineeSheetSlices
	 * @Description:查询列表
	 * @author: generation
	 * @date:   2020年04月17日 09:28:480
	 * @param psExamineeSheetSlices 查询条件
	 */
	@RequestMapping(value="/list.do", method=RequestMethod.GET)
	@ResponseBody
	public ResponseModel listPsExamineeSheetSlices(PsExamineeSheetSlicesVO psExamineeSheetSlices, HttpServletRequest request, HttpServletResponse response){
		List<PsExamineeSheetSlicesVO> list = psExamineeSheetSlicesService.listPsExamineeSheetSlices(psExamineeSheetSlices);
		return ResponseModel.success(list);
	}
}

