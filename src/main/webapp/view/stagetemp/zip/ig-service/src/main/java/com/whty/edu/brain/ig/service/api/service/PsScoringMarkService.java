package com.whty.edu.brain.ig.service.api.service;

import com.whty.edu.brain.ig.service.api.vo.PsScoringMarkVO;
import java.util.List;
/**   
 * @formatClassName:  PsScoringMarkDAO   
 * @Description:TODO    
 * @author: generation
 * @date:   2020年04月17日 09:28:450
 * @Copyright: generation
 */
public interface PsScoringMarkService {
	/**
	 * @Title: insertPsScoringMark
	 * @Description:新增
	 * @author: generation
	 * @date:   2020年04月17日 09:28:450
	 * @param psScoringMark 新增内容
	 */
	void insertPsScoringMark(PsScoringMarkVO psScoringMark);
	
	/**
	 * @Title: deletePsScoringMark
	 * @Description:删除
	 * @author: generation
	 * @date:   2020年04月17日 09:28:450
	 * @param psScoringMark 删除对象条件
	 */
	void deletePsScoringMark(PsScoringMarkVO psScoringMark);
	
	/**
	 * @Title: updatePsScoringMark
	 * @Description:更新
	 * @author: generation
	 * @date:   2020年04月17日 09:28:450
	 * @param psScoringMark 更新条件及目标对象标识
	 */
	void updatePsScoringMark(PsScoringMarkVO psScoringMark);
	
	/**
	 * @Title: listPsScoringMark
	 * @Description:查询列表
	 * @author: generation
	 * @date:   2020年04月17日 09:28:450
	 * @param psScoringMark 查询条件
	 * @return List<PsScoringMarkVO> 返回结果
	 */
	List<PsScoringMarkVO> listPsScoringMark(PsScoringMarkVO psScoringMark);
}