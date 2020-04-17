/**  
 * @Title:  StageController.java   
 * @Package com.generation.code.stage.controller   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: 曾肖
 * @date:   2019年5月30日 下午2:22:03   
 * @version V1.0 
 * @Copyright: 2019
 */
package com.generation.code.stage.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.generation.code.constant.CommonConstant;
import com.generation.code.framework.ResponseModel;
import com.generation.code.stage.vo.ProjectAttributeVO;
import com.generation.code.util.CommonUtil;
import com.generation.code.util.FileToZip;
import com.generation.code.util.FileUtil;
import com.generation.code.util.FreemarkerSpringBootUtil;
import com.generation.code.util.SpringbootFalsework;

/**   
 * @ClassName:  StageController   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: 曾肖 
 * @date:   2019年5月30日 下午2:22:03   
 *     
 * @Copyright: 2019
 */
@Controller
@RequestMapping("/stage")
public class StageController {
	/**
	 * @Title: index   
	 * @Description: TODO(脚手架主页)   
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	@RequestMapping(value="/index.view", method=RequestMethod.GET)
	public String index() {
		return "/web/stage/index";
	}
	/**
	 * @Title: createProject   
	 * @Description: TODO(创建工程)   
	 * @param: @param projectAttribute
	 * @param: @return
	 * @param: @throws Exception      
	 * @return: ResponseModel      
	 * @throws
	 */
	@RequestMapping(value="/createProject.do", method=RequestMethod.POST)
	@ResponseBody
	public ResponseModel createProject(ProjectAttributeVO projectAttribute){
		try {
			FreemarkerSpringBootUtil.createProject(projectAttribute);
		} catch (Exception e) {
			String projectDir = CommonUtil.concat(CommonConstant.SRC_STAGETEMP , projectAttribute.getUpArtifactId());
			FileUtil.delete(projectDir);
			e.printStackTrace();
			return ResponseModel.fail();
		}
		return ResponseModel.success(CommonUtil.concat(projectAttribute.getUpArtifactId(), ".zip"));
	}
	@RequestMapping(value="/build.do", method=RequestMethod.POST)
	@ResponseBody
	public ResponseModel build(HttpServletRequest request, @RequestBody Map<String, Object> map) {
		SpringbootFalsework builder = new SpringbootFalsework(map);
		try {
			builder.build();
			String zip = CommonUtil.concat(CommonConstant.SRC_STAGETEMP_ZIP, CommonConstant.SRC_SEPARATE, builder.getArtifactId(), ".zip");
			FileOutputStream fos1 = new FileOutputStream(new File(zip));
			FileToZip.toZip(builder.getProjectDir(), fos1,true);
			FileUtil.delete(CommonConstant.SRC_STAGETEMP + builder.getArtifactId());
			String zipDownload = CommonUtil.concat(request.getScheme(), "://", request.getServerName(), ":", String.valueOf(request.getServerPort()), "/view/stagetemp/zip/", builder.getArtifactId(), ".zip");
			return ResponseModel.success(zipDownload);
		} catch (Exception e) {
			FileUtil.delete(CommonConstant.SRC_STAGETEMP + builder.getArtifactId());
			e.printStackTrace();
		}
		return ResponseModel.success();
	}
	
	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("groupId", "com.whty.edu.brain.ig");
		map.put("artifactId", "ig-service");
		map.put("dburl", "jdbc:mysql://10.0.200.12:29303/ct_exam?useSSL=false&useUnicode=true&characterEncoding=utf-8&autoReconnect=true&rewriteBatchedStatements=true&allowMultiQueries=true&serverTimezone=Asia/Shanghai");
		map.put("dbname", "ct_exam");
		map.put("dbpassowrd", "ct_examtest");
		map.put("packgename", "service");
		map.put("dbpackgename", "api");
		map.put("tables", "ps_examinee_sheet_slices,ps_scoring_mark,ps_examinee,ps_examinee_sheet,ps_kg_mark,ps_subject_score,ps_zg_total_score,ps_answer_sheet_item,ps_marker,ps_online_submit");
		map.put("database", "ct_exam");
		
		SpringbootFalsework builder = new SpringbootFalsework(map);
		try {
			builder.build();
			String zip = CommonUtil.concat(CommonConstant.SRC_STAGETEMP_ZIP, CommonConstant.SRC_SEPARATE, builder.getArtifactId(), ".zip");
			FileOutputStream fos1 = new FileOutputStream(new File(zip));
			FileToZip.toZip(builder.getProjectDir(), fos1,true);
			FileUtil.delete(CommonConstant.SRC_STAGETEMP + builder.getArtifactId());
		} catch (Exception e) {
			FileUtil.delete(CommonConstant.SRC_STAGETEMP + builder.getArtifactId());
			e.printStackTrace();
		}
	}
}
