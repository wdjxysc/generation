package com.whty.edu.brain.ig.service.api.service;

import com.whty.edu.brain.ig.service.api.vo.PsOnlineSubmitVO;
import java.util.List;
/**   
 * @formatClassName:  PsOnlineSubmitDAO   
 * @Description:TODO    
 * @author: generation
 * @date:   2020年04月17日 09:28:456
 * @Copyright: generation
 */
public interface PsOnlineSubmitService {
	/**
	 * @Title: insertPsOnlineSubmit
	 * @Description:新增
	 * @author: generation
	 * @date:   2020年04月17日 09:28:456
	 * @param psOnlineSubmit 新增内容
	 */
	void insertPsOnlineSubmit(PsOnlineSubmitVO psOnlineSubmit);
	
	/**
	 * @Title: deletePsOnlineSubmit
	 * @Description:删除
	 * @author: generation
	 * @date:   2020年04月17日 09:28:456
	 * @param psOnlineSubmit 删除对象条件
	 */
	void deletePsOnlineSubmit(PsOnlineSubmitVO psOnlineSubmit);
	
	/**
	 * @Title: updatePsOnlineSubmit
	 * @Description:更新
	 * @author: generation
	 * @date:   2020年04月17日 09:28:456
	 * @param psOnlineSubmit 更新条件及目标对象标识
	 */
	void updatePsOnlineSubmit(PsOnlineSubmitVO psOnlineSubmit);
	
	/**
	 * @Title: listPsOnlineSubmit
	 * @Description:查询列表
	 * @author: generation
	 * @date:   2020年04月17日 09:28:456
	 * @param psOnlineSubmit 查询条件
	 * @return List<PsOnlineSubmitVO> 返回结果
	 */
	List<PsOnlineSubmitVO> listPsOnlineSubmit(PsOnlineSubmitVO psOnlineSubmit);
}