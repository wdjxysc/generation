package com.whty.edu.brain.ig.service.api.service;

import com.whty.edu.brain.ig.service.api.vo.PsMarkerVO;
import java.util.List;
/**   
 * @formatClassName:  PsMarkerDAO   
 * @Description:TODO    
 * @author: generation
 * @date:   2020年04月17日 09:28:461
 * @Copyright: generation
 */
public interface PsMarkerService {
	/**
	 * @Title: insertPsMarker
	 * @Description:新增
	 * @author: generation
	 * @date:   2020年04月17日 09:28:461
	 * @param psMarker 新增内容
	 */
	void insertPsMarker(PsMarkerVO psMarker);
	
	/**
	 * @Title: deletePsMarker
	 * @Description:删除
	 * @author: generation
	 * @date:   2020年04月17日 09:28:461
	 * @param psMarker 删除对象条件
	 */
	void deletePsMarker(PsMarkerVO psMarker);
	
	/**
	 * @Title: updatePsMarker
	 * @Description:更新
	 * @author: generation
	 * @date:   2020年04月17日 09:28:461
	 * @param psMarker 更新条件及目标对象标识
	 */
	void updatePsMarker(PsMarkerVO psMarker);
	
	/**
	 * @Title: listPsMarker
	 * @Description:查询列表
	 * @author: generation
	 * @date:   2020年04月17日 09:28:461
	 * @param psMarker 查询条件
	 * @return List<PsMarkerVO> 返回结果
	 */
	List<PsMarkerVO> listPsMarker(PsMarkerVO psMarker);
}