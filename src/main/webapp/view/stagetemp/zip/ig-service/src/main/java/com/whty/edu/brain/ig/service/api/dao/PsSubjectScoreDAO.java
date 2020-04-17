package com.whty.edu.brain.ig.service.api.dao;
import com.whty.edu.brain.ig.service.api.vo.PsSubjectScoreVO;
import java.util.List;
/**   
 * @formatClassName:  PsSubjectScoreDAO   
 * @Description:TODO(持久层接口)   
 * @author: generation
 * @date:   2020年04月17日 09:28:485
 * @Copyright: generation
 */
public interface PsSubjectScoreDAO {
	/**
	 * @Title: insertPsSubjectScore
	 * @Description:新增
	 * @author: generation
	 * @date:   2020年04月17日 09:28:485
	 * @param psSubjectScore 新增内容
	 */
	void insertPsSubjectScore(PsSubjectScoreVO psSubjectScore);
	
	/**
	 * @Title: deletePsSubjectScore
	 * @Description:删除
	 * @author: generation
	 * @date:   2020年04月17日 09:28:485
	 * @param psSubjectScore 删除对象条件
	 */
	void deletePsSubjectScore(PsSubjectScoreVO psSubjectScore);
	
	/**
	 * @Title: updatePsSubjectScore
	 * @Description:更新
	 * @author: generation
	 * @date:   2020年04月17日 09:28:485
	 * @param psSubjectScore 更新条件及目标对象标识
	 */
	void updatePsSubjectScore(PsSubjectScoreVO psSubjectScore);
	
	/**
	 * @Title: listPsSubjectScore
	 * @Description:查询列表
	 * @author: generation
	 * @date:   2020年04月17日 09:28:485
	 * @param psSubjectScore 查询条件
	 * @return List<PsSubjectScoreVO> 返回结果
	 */
	List<PsSubjectScoreVO> listPsSubjectScore(PsSubjectScoreVO psSubjectScore);
}
