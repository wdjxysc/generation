package com.whty.edu.brain.ig.service.api.service;

import com.whty.edu.brain.ig.service.api.vo.PsExamineeSheetVO;
import java.util.List;
/**   
 * @formatClassName:  PsExamineeSheetDAO   
 * @Description:TODO    
 * @author: generation
 * @date:   2020年04月17日 09:28:466
 * @Copyright: generation
 */
public interface PsExamineeSheetService {
	/**
	 * @Title: insertPsExamineeSheet
	 * @Description:新增
	 * @author: generation
	 * @date:   2020年04月17日 09:28:466
	 * @param psExamineeSheet 新增内容
	 */
	void insertPsExamineeSheet(PsExamineeSheetVO psExamineeSheet);
	
	/**
	 * @Title: deletePsExamineeSheet
	 * @Description:删除
	 * @author: generation
	 * @date:   2020年04月17日 09:28:466
	 * @param psExamineeSheet 删除对象条件
	 */
	void deletePsExamineeSheet(PsExamineeSheetVO psExamineeSheet);
	
	/**
	 * @Title: updatePsExamineeSheet
	 * @Description:更新
	 * @author: generation
	 * @date:   2020年04月17日 09:28:466
	 * @param psExamineeSheet 更新条件及目标对象标识
	 */
	void updatePsExamineeSheet(PsExamineeSheetVO psExamineeSheet);
	
	/**
	 * @Title: listPsExamineeSheet
	 * @Description:查询列表
	 * @author: generation
	 * @date:   2020年04月17日 09:28:466
	 * @param psExamineeSheet 查询条件
	 * @return List<PsExamineeSheetVO> 返回结果
	 */
	List<PsExamineeSheetVO> listPsExamineeSheet(PsExamineeSheetVO psExamineeSheet);
}