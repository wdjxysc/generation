package com.whty.edu.brain.ig.service.api.dao;
import com.whty.edu.brain.ig.service.api.vo.PsExamineeSheetSlicesVO;
import java.util.List;
/**   
 * @formatClassName:  PsExamineeSheetSlicesDAO   
 * @Description:TODO(持久层接口)   
 * @author: generation
 * @date:   2020年04月17日 09:28:478
 * @Copyright: generation
 */
public interface PsExamineeSheetSlicesDAO {
	/**
	 * @Title: insertPsExamineeSheetSlices
	 * @Description:新增
	 * @author: generation
	 * @date:   2020年04月17日 09:28:478
	 * @param psExamineeSheetSlices 新增内容
	 */
	void insertPsExamineeSheetSlices(PsExamineeSheetSlicesVO psExamineeSheetSlices);
	
	/**
	 * @Title: deletePsExamineeSheetSlices
	 * @Description:删除
	 * @author: generation
	 * @date:   2020年04月17日 09:28:478
	 * @param psExamineeSheetSlices 删除对象条件
	 */
	void deletePsExamineeSheetSlices(PsExamineeSheetSlicesVO psExamineeSheetSlices);
	
	/**
	 * @Title: updatePsExamineeSheetSlices
	 * @Description:更新
	 * @author: generation
	 * @date:   2020年04月17日 09:28:478
	 * @param psExamineeSheetSlices 更新条件及目标对象标识
	 */
	void updatePsExamineeSheetSlices(PsExamineeSheetSlicesVO psExamineeSheetSlices);
	
	/**
	 * @Title: listPsExamineeSheetSlices
	 * @Description:查询列表
	 * @author: generation
	 * @date:   2020年04月17日 09:28:478
	 * @param psExamineeSheetSlices 查询条件
	 * @return List<PsExamineeSheetSlicesVO> 返回结果
	 */
	List<PsExamineeSheetSlicesVO> listPsExamineeSheetSlices(PsExamineeSheetSlicesVO psExamineeSheetSlices);
}
