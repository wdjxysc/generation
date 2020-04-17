package com.whty.edu.brain.ig.service.api.dao;
import com.whty.edu.brain.ig.service.api.vo.PsZgTotalScoreVO;
import java.util.List;
/**   
 * @formatClassName:  PsZgTotalScoreDAO   
 * @Description:TODO(持久层接口)   
 * @author: generation
 * @date:   2020年04月17日 09:28:473
 * @Copyright: generation
 */
public interface PsZgTotalScoreDAO {
	/**
	 * @Title: insertPsZgTotalScore
	 * @Description:新增
	 * @author: generation
	 * @date:   2020年04月17日 09:28:473
	 * @param psZgTotalScore 新增内容
	 */
	void insertPsZgTotalScore(PsZgTotalScoreVO psZgTotalScore);
	
	/**
	 * @Title: deletePsZgTotalScore
	 * @Description:删除
	 * @author: generation
	 * @date:   2020年04月17日 09:28:473
	 * @param psZgTotalScore 删除对象条件
	 */
	void deletePsZgTotalScore(PsZgTotalScoreVO psZgTotalScore);
	
	/**
	 * @Title: updatePsZgTotalScore
	 * @Description:更新
	 * @author: generation
	 * @date:   2020年04月17日 09:28:473
	 * @param psZgTotalScore 更新条件及目标对象标识
	 */
	void updatePsZgTotalScore(PsZgTotalScoreVO psZgTotalScore);
	
	/**
	 * @Title: listPsZgTotalScore
	 * @Description:查询列表
	 * @author: generation
	 * @date:   2020年04月17日 09:28:473
	 * @param psZgTotalScore 查询条件
	 * @return List<PsZgTotalScoreVO> 返回结果
	 */
	List<PsZgTotalScoreVO> listPsZgTotalScore(PsZgTotalScoreVO psZgTotalScore);
}
