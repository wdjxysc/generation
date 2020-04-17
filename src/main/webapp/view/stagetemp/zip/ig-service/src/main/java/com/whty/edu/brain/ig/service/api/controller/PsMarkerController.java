package com.whty.edu.brain.ig.service.api.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import com.whty.edu.brain.ig.service.api.service.PsMarkerService;
import com.whty.edu.brain.ig.service.api.vo.PsMarkerVO;
import java.util.List;
import com.whty.edu.brain.ig.framework.config.ResponseModel;


@RequestMapping("/psMarker")
@Controller
public class PsMarkerController {

	@Autowired
	private PsMarkerService psMarkerService;
	
	/**
	 * @Title: insertPsMarker
	 * @Description:新增
	 * @author: generation
	 * @date:   2020年04月17日 09:28:462
	 * @param psMarker 新增内容
	 */
	@RequestMapping(value="/insert.do", method=RequestMethod.PUT)
	@ResponseBody
	public ResponseModel insertPsMarker(PsMarkerVO psMarker, HttpServletRequest request, HttpServletResponse response){
		psMarkerService.insertPsMarker(psMarker);
		return ResponseModel.success("新增成功");
	}
	
	/**
	 * @Title: deletePsMarker
	 * @Description:删除
	 * @author: generation
	 * @date:   2020年04月17日 09:28:462
	 * @param psMarker 删除条件
	 */
	@RequestMapping(value="/delete.do", method=RequestMethod.DELETE)
	@ResponseBody
	public ResponseModel deletePsMarker(PsMarkerVO psMarker, HttpServletRequest request, HttpServletResponse response){
		psMarkerService.deletePsMarker(psMarker);
		return ResponseModel.success("删除成功");
	}
	
	/**
	 * @Title: updatePsMarker
	 * @Description:更新
	 * @author: generation
	 * @date:   2020年04月17日 09:28:462
	 * @param psMarker 更新内容和条件
	 */
	@RequestMapping(value="/update.do", method=RequestMethod.POST)
	@ResponseBody
	public ResponseModel updatePsMarker(PsMarkerVO psMarker, HttpServletRequest request, HttpServletResponse response){
		psMarkerService.updatePsMarker(psMarker);
		return ResponseModel.success("更新成功");
	}
	
	/**
	 * @Title: listPsMarker
	 * @Description:查询列表
	 * @author: generation
	 * @date:   2020年04月17日 09:28:462
	 * @param psMarker 查询条件
	 */
	@RequestMapping(value="/list.do", method=RequestMethod.GET)
	@ResponseBody
	public ResponseModel listPsMarker(PsMarkerVO psMarker, HttpServletRequest request, HttpServletResponse response){
		List<PsMarkerVO> list = psMarkerService.listPsMarker(psMarker);
		return ResponseModel.success(list);
	}
}

