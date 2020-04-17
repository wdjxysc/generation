package com.whty.edu.brain.ig.service.api.service;

import com.whty.edu.brain.ig.service.api.vo.PsKgMarkVO;
import java.util.List;
/**   
 * @formatClassName:  PsKgMarkDAO   
 * @Description:TODO    
 * @author: generation
 * @date:   2020年04月17日 09:28:488
 * @Copyright: generation
 */
public interface PsKgMarkService {
	/**
	 * @Title: insertPsKgMark
	 * @Description:新增
	 * @author: generation
	 * @date:   2020年04月17日 09:28:488
	 * @param psKgMark 新增内容
	 */
	void insertPsKgMark(PsKgMarkVO psKgMark);
	
	/**
	 * @Title: deletePsKgMark
	 * @Description:删除
	 * @author: generation
	 * @date:   2020年04月17日 09:28:488
	 * @param psKgMark 删除对象条件
	 */
	void deletePsKgMark(PsKgMarkVO psKgMark);
	
	/**
	 * @Title: updatePsKgMark
	 * @Description:更新
	 * @author: generation
	 * @date:   2020年04月17日 09:28:488
	 * @param psKgMark 更新条件及目标对象标识
	 */
	void updatePsKgMark(PsKgMarkVO psKgMark);
	
	/**
	 * @Title: listPsKgMark
	 * @Description:查询列表
	 * @author: generation
	 * @date:   2020年04月17日 09:28:488
	 * @param psKgMark 查询条件
	 * @return List<PsKgMarkVO> 返回结果
	 */
	List<PsKgMarkVO> listPsKgMark(PsKgMarkVO psKgMark);
}