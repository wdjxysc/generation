package com.whty.edu.brain.ig.service.api.service;

import com.whty.edu.brain.ig.service.api.vo.PsAnswerSheetItemVO;
import java.util.List;
/**   
 * @formatClassName:  PsAnswerSheetItemDAO   
 * @Description:TODO    
 * @author: generation
 * @date:   2020年04月17日 09:28:470
 * @Copyright: generation
 */
public interface PsAnswerSheetItemService {
	/**
	 * @Title: insertPsAnswerSheetItem
	 * @Description:新增
	 * @author: generation
	 * @date:   2020年04月17日 09:28:470
	 * @param psAnswerSheetItem 新增内容
	 */
	void insertPsAnswerSheetItem(PsAnswerSheetItemVO psAnswerSheetItem);
	
	/**
	 * @Title: deletePsAnswerSheetItem
	 * @Description:删除
	 * @author: generation
	 * @date:   2020年04月17日 09:28:470
	 * @param psAnswerSheetItem 删除对象条件
	 */
	void deletePsAnswerSheetItem(PsAnswerSheetItemVO psAnswerSheetItem);
	
	/**
	 * @Title: updatePsAnswerSheetItem
	 * @Description:更新
	 * @author: generation
	 * @date:   2020年04月17日 09:28:471
	 * @param psAnswerSheetItem 更新条件及目标对象标识
	 */
	void updatePsAnswerSheetItem(PsAnswerSheetItemVO psAnswerSheetItem);
	
	/**
	 * @Title: listPsAnswerSheetItem
	 * @Description:查询列表
	 * @author: generation
	 * @date:   2020年04月17日 09:28:471
	 * @param psAnswerSheetItem 查询条件
	 * @return List<PsAnswerSheetItemVO> 返回结果
	 */
	List<PsAnswerSheetItemVO> listPsAnswerSheetItem(PsAnswerSheetItemVO psAnswerSheetItem);
}